"""
Module — Android Storage Scanner
Détecte les tokens stockés de manière non sécurisée sur Android.

Conformément au guide AuthGuard (OWASP MASVS-STORAGE) :
  - SharedPreferences non chiffré contenant tokens/JWT
  - SQLite DB avec données auth en clair
  - Fichiers dans storage externe
  - Absence d'EncryptedSharedPreferences ou Android Keystore
  - Détection via analyse statique (code JADX décompilé)
  - Inspection live via ADB (émulateur)

Mappe sur : MASVS-STORAGE-1, MASVS-STORAGE-2, Chap.4/6/12 du cours.
"""

import os
import re
import json
import subprocess
import shutil
from pathlib import Path


# ---------------------------------------------------------------------------
# Patterns de stockage non sécurisé (analyse statique)
# ---------------------------------------------------------------------------

STORAGE_PATTERNS = [
    # ── CRITIQUE ──────────────────────────────────────────────────────────
    {
        "id": "STORAGE_SHARED_PREFS_TOKEN",
        "masvs": "MASVS-STORAGE-1",
        "severity": "CRITIQUE",
        "type": "Token dans SharedPreferences non chiffré",
        "pattern": (
            r'(?:getSharedPreferences|SharedPreferences)[^;]{0,300}'
            r'(?:putString|putInt)[^;]{0,200}'
            r'(?:token|jwt|session|auth|Bearer|access_token|refresh_token)'
        ),
        "description": (
            "Un token d'authentification est stocké dans SharedPreferences "
            "standard — lisible par ADB sur appareil rooté ou via backup ADB."
        ),
        "fix": "Remplacer par EncryptedSharedPreferences (AndroidX Security).",
    },
    {
        "id": "STORAGE_HARDCODED_KEY",
        "masvs": "MASVS-STORAGE-2",
        "severity": "CRITIQUE",
        "type": "Clé de chiffrement codée en dur",
        "pattern": (
            r'(?i)(?:AES|DES|RSA|HMAC)[^"\']{0,50}'
            r'(?:key|secret|password)\s*[=:]\s*["\'][A-Za-z0-9+/]{8,}["\']'
        ),
        "description": (
            "Une clé de chiffrement est définie en clair dans le code source — "
            "extraction triviale après décompilation JADX."
        ),
        "fix": "Générer et stocker la clé dans Android Keystore (KeyPairGenerator/KeyGenerator).",
    },
    {
        "id": "STORAGE_EXTERNAL",
        "masvs": "MASVS-STORAGE-1",
        "severity": "CRITIQUE",
        "type": "Écriture sur stockage externe",
        "pattern": (
            r'(?:getExternalFilesDir|getExternalStorageDirectory'
            r'|Environment\.getExternalStoragePublicDirectory'
            r'|openFileOutput\s*\([^,]+,\s*MODE_WORLD_READABLE)'
        ),
        "description": (
            "Des données sont écrites sur le stockage externe "
            "— accessible par toute application sans permission."
        ),
        "fix": "Utiliser uniquement le stockage interne (getFilesDir).",
    },
    # ── ÉLEVÉ ─────────────────────────────────────────────────────────────
    {
        "id": "STORAGE_SQLITE_TOKEN",
        "masvs": "MASVS-STORAGE-1",
        "severity": "ELEVE",
        "type": "Token dans SQLite non chiffré",
        "pattern": (
            r'(?:SQLiteDatabase|Room|ContentValues)[^;]{0,300}'
            r'(?:token|jwt|password|session|credential)'
        ),
        "description": (
            "Des données d'authentification sont stockées dans une base "
            "SQLite sans chiffrement — extractibles via ADB."
        ),
        "fix": "Utiliser SQLCipher ou Room + EncryptedFile pour protéger la base.",
    },
    {
        "id": "STORAGE_LOG_SENSITIVE",
        "masvs": "MASVS-STORAGE-2",
        "severity": "ELEVE",
        "type": "Données sensibles dans les logs",
        "pattern": (
            r'Log\.[dDeEiIwW]\([^)]{0,200}'
            r'(?:password|token|jwt|secret|credential|pin|card)'
        ),
        "description": (
            "Des données sensibles sont loggées avec Log.d/e/i — "
            "lisibles via logcat même sur appareil non rooté."
        ),
        "fix": "Supprimer tout Log contenant des données d'auth en production (BuildConfig.DEBUG).",
    },
    {
        "id": "STORAGE_NO_KEYSTORE",
        "masvs": "MASVS-STORAGE-2",
        "severity": "ELEVE",
        "type": "Absence d'Android Keystore",
        "pattern": r'(?:KeyStore|KeyPairGenerator|KeyGenerator)',  # absence → détectée en négatif
        "description": (
            "L'application ne semble pas utiliser Android Keystore pour "
            "stocker les clés cryptographiques."
        ),
        "fix": "Utiliser KeyStore.getInstance(\"AndroidKeyStore\") pour toute clé sensible.",
        "_negative": True,   # Finding levé si le pattern EST ABSENT
    },
    # ── MOYEN ─────────────────────────────────────────────────────────────
    {
        "id": "STORAGE_WORLD_READABLE",
        "masvs": "MASVS-STORAGE-1",
        "severity": "MOYEN",
        "type": "Fichier MODE_WORLD_READABLE",
        "pattern": r'MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE',
        "description": (
            "Un fichier est créé avec MODE_WORLD_READABLE — "
            "accessible par toute application (deprecated depuis API 17)."
        ),
        "fix": "Utiliser MODE_PRIVATE (0) et supprimer tous les modes WORLD_*.",
    },
    {
        "id": "STORAGE_CLIPBOARD",
        "masvs": "MASVS-STORAGE-2",
        "severity": "MOYEN",
        "type": "Données sensibles dans le presse-papier",
        "pattern": (
            r'ClipboardManager[^;]{0,200}'
            r'(?:token|password|jwt|secret|otp|pin)'
        ),
        "description": (
            "Des données sensibles semblent copiées dans le presse-papier — "
            "lisibles par d'autres applications."
        ),
        "fix": (
            "Marquer les champs sensibles comme InputType.TYPE_TEXT_VARIATION_PASSWORD "
            "et désactiver le copy pour ces champs."
        ),
    },
]

# ---------------------------------------------------------------------------
# Recommandation positive (code correct à recommander)
# ---------------------------------------------------------------------------

SECURE_PATTERN_ENCRYPTED_PREFS = re.compile(
    r"EncryptedSharedPreferences|MasterKey\.Builder|MasterKeys\.AES256_GCM",
    re.IGNORECASE,
)

KEYSTORE_PATTERN = re.compile(
    r'KeyStore\.getInstance\s*\(\s*["\']AndroidKeyStore["\']'
    r'|KeyPairGenerator\.getInstance[^)]+KeyProperties'
    r'|KeyGenerator\.getInstance',
    re.IGNORECASE,
)


# ---------------------------------------------------------------------------
# Analyse statique des sources JADX
# ---------------------------------------------------------------------------

def _read(path: str) -> str:
    try:
        with open(path, "r", encoding="utf-8", errors="ignore") as f:
            return f.read()
    except Exception:
        return ""


def _line_of(content: str, pos: int) -> int:
    return content[:pos].count("\n") + 1


def scan_sources(output_dir: str) -> dict:
    """
    Parcourt les sources Java/Kotlin décompilées (output JADX).
    Retourne { findings, uses_encrypted_prefs, uses_keystore, files_scanned }.
    """
    findings = []
    seen = set()
    uses_encrypted_prefs = False
    uses_keystore = False
    files_scanned = 0

    # Collecter tous les patterns positifs sur l'ensemble des fichiers
    all_content = ""

    for root, _dirs, files in os.walk(output_dir):
        for fname in files:
            if not fname.endswith((".java", ".kt")):
                continue
            fpath = os.path.join(root, fname)
            content = _read(fpath)
            if not content:
                continue
            files_scanned += 1
            rel = os.path.relpath(fpath, output_dir)
            all_content += content

            # Détecter usage de EncryptedSharedPreferences
            if SECURE_PATTERN_ENCRYPTED_PREFS.search(content):
                uses_encrypted_prefs = True

            # Détecter usage de Keystore
            if KEYSTORE_PATTERN.search(content):
                uses_keystore = True

            for pat in STORAGE_PATTERNS:
                if pat.get("_negative"):
                    continue  # traité globalement après la boucle

                for match in re.finditer(
                    pat["pattern"], content, re.IGNORECASE | re.DOTALL
                ):
                    line = _line_of(content, match.start())
                    key = (pat["id"], rel, line)
                    if key in seen:
                        continue
                    seen.add(key)

                    findings.append({
                        "id":          pat["id"],
                        "masvs":       pat["masvs"],
                        "severity":    pat["severity"],
                        "type":        pat["type"],
                        "file":        rel,
                        "line":        line,
                        "detail":      match.group(0).strip()[:120],
                        "description": pat["description"],
                        "fix":         pat["fix"],
                    })

    # ── Findings négatifs (absence d'une bonne pratique) ──────────────────
    if not uses_keystore and files_scanned > 0:
        findings.append({
            "id":          "STORAGE_NO_KEYSTORE",
            "masvs":       "MASVS-STORAGE-2",
            "severity":    "ELEVE",
            "type":        "Absence d'Android Keystore",
            "file":        "— (non détecté dans les sources)",
            "line":        0,
            "detail":      "KeyStore.getInstance(\"AndroidKeyStore\") introuvable dans le code",
            "description": STORAGE_PATTERNS[4]["description"],
            "fix":         STORAGE_PATTERNS[4]["fix"],
        })

    return {
        "findings":               findings,
        "uses_encrypted_prefs":   uses_encrypted_prefs,
        "uses_keystore":          uses_keystore,
        "files_scanned":          files_scanned,
    }


# ---------------------------------------------------------------------------
# Inspection live via ADB (émulateur connecté)
# ---------------------------------------------------------------------------

def inspect_adb(package: str = "com.android.insecurebankv2") -> dict:
    """
    Se connecte à l'émulateur via ADB et inspecte le stockage de l'application.
    Nécessite un émulateur lancé et adb sur le PATH.

    Returns:
        { findings, shared_prefs_content, sqlite_files }
    """
    adb = shutil.which("adb")
    if not adb:
        return {
            "findings": [{
                "id": "ADB_NOT_FOUND",
                "severity": "INFO",
                "type": "ADB introuvable",
                "detail": "adb non disponible — inspection live ignorée.",
                "description": "Installez Android SDK Platform Tools et ajoutez adb au PATH.",
            }],
            "shared_prefs_content": "",
            "sqlite_files": [],
        }

    findings = []
    shared_prefs_content = ""
    sqlite_files = []

    # ── 1. Lire les SharedPreferences ────────────────────────────────────
    sp_path = f"/data/data/{package}/shared_prefs"
    try:
        result = subprocess.run(
            [adb, "shell", "run-as", package, "ls", sp_path],
            capture_output=True, text=True, timeout=10,
        )
        prefs_files = result.stdout.strip().splitlines()

        for pf in prefs_files:
            if not pf.endswith(".xml"):
                continue
            cat_result = subprocess.run(
                [adb, "shell", "run-as", package, "cat", f"{sp_path}/{pf}"],
                capture_output=True, text=True, timeout=10,
            )
            content = cat_result.stdout
            shared_prefs_content += f"\n--- {pf} ---\n{content}"

            # Chercher des tokens/mots de passe en clair
            if re.search(
                r'(?:token|jwt|password|secret|auth|Bearer)',
                content, re.IGNORECASE
            ):
                findings.append({
                    "id":          "ADB_SHARED_PREFS_SENSITIVE",
                    "masvs":       "MASVS-STORAGE-1",
                    "severity":    "CRITIQUE",
                    "type":        "Token/mot de passe en clair dans SharedPreferences",
                    "file":        f"{sp_path}/{pf}",
                    "line":        0,
                    "detail":      f"Données sensibles détectées dans {pf}",
                    "description": (
                        "Des données d'authentification sont stockées en clair "
                        "dans les SharedPreferences — extractibles sans root via ADB."
                    ),
                    "fix":         "Migrer vers EncryptedSharedPreferences.",
                })
    except (subprocess.TimeoutExpired, Exception) as e:
        findings.append({
            "id":      "ADB_PREFS_ERROR",
            "severity": "INFO",
            "type":    "Erreur inspection SharedPreferences",
            "detail":  str(e)[:120],
        })

    # ── 2. Lister les fichiers SQLite ─────────────────────────────────────
    try:
        db_result = subprocess.run(
            [adb, "shell", "run-as", package, "find",
             f"/data/data/{package}", "-name", "*.db"],
            capture_output=True, text=True, timeout=10,
        )
        sqlite_files = [
            f.strip() for f in db_result.stdout.splitlines() if f.strip()
        ]
        if sqlite_files:
            findings.append({
                "id":          "ADB_SQLITE_FOUND",
                "masvs":       "MASVS-STORAGE-1",
                "severity":    "MOYEN",
                "type":        "Base de données SQLite détectée",
                "file":        ", ".join(sqlite_files[:3]),
                "line":        0,
                "detail":      f"{len(sqlite_files)} base(s) SQLite trouvée(s)",
                "description": "Vérifier que les bases SQLite ne contiennent pas de données auth en clair.",
                "fix":         "Utiliser SQLCipher pour chiffrer les bases SQLite.",
            })
    except Exception as e:
        sqlite_files = []
        findings.append({
            "id":      "ADB_SQLITE_ERROR",
            "severity": "INFO",
            "type":    "Erreur inspection SQLite",
            "detail":  str(e)[:120],
        })

    return {
        "findings":             findings,
        "shared_prefs_content": shared_prefs_content,
        "sqlite_files":         sqlite_files,
    }


# ---------------------------------------------------------------------------
# Score
# ---------------------------------------------------------------------------

_PENALTY = {"CRITIQUE": 2, "ELEVE": 1, "MOYEN": 0.5}


def compute_storage_score(findings: list) -> int:
    score = 10.0
    for f in findings:
        score -= _PENALTY.get(f.get("severity", "MOYEN"), 0)
    return max(0, round(score))


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(output_dir: str, package: str = "", run_adb: bool = False) -> dict:
    """
    Analyse complète du stockage Android.

    Args:
        output_dir : dossier de décompilation JADX.
        package    : package Android (pour inspection ADB).
        run_adb    : si True, tente une inspection live via ADB.

    Returns:
        { findings, uses_encrypted_prefs, uses_keystore, score, adb_result }
    """
    static = scan_sources(output_dir)
    findings = static["findings"]

    adb_result = None
    if run_adb and package:
        adb_result = inspect_adb(package)
        findings += adb_result.get("findings", [])

    return {
        "findings":             findings,
        "uses_encrypted_prefs": static["uses_encrypted_prefs"],
        "uses_keystore":        static["uses_keystore"],
        "files_scanned":        static["files_scanned"],
        "score":                compute_storage_score(findings),
        "adb_result":           adb_result,
    }


# ---------------------------------------------------------------------------
# Test standalone
# ---------------------------------------------------------------------------

if __name__ == "__main__":
    import sys

    output_dir = sys.argv[1] if len(sys.argv) > 1 else "output/app-debug"
    package    = sys.argv[2] if len(sys.argv) > 2 else "com.android.insecurebankv2"
    run_adb    = "--adb" in sys.argv

    print(f"\n{'='*60}")
    print("  Android Storage Scanner — AuthGuard")
    print(f"{'='*60}")
    print(f"  Répertoire : {output_dir}")
    print(f"  Package    : {package}")
    print(f"  Mode ADB   : {'Oui' if run_adb else 'Non'}")
    print()

    result = analyze(output_dir, package, run_adb)

    print(f"  Fichiers scannés        : {result['files_scanned']}")
    print(f"  EncryptedSharedPrefs   : {'✅' if result['uses_encrypted_prefs'] else '❌'}")
    print(f"  Android Keystore       : {'✅' if result['uses_keystore'] else '❌'}")
    print(f"  Score MASVS-STORAGE    : {result['score']}/10")
    print(f"  Findings               : {len(result['findings'])}")
    print()

    _sev_order = {"CRITIQUE": 0, "ELEVE": 1, "MOYEN": 2, "INFO": 3}
    findings = sorted(result["findings"], key=lambda f: _sev_order.get(f.get("severity", "INFO"), 9))

    for f in findings:
        icon = {"CRITIQUE": "🔴", "ELEVE": "🟠", "MOYEN": "🟡", "INFO": "ℹ️"}.get(f.get("severity"), "  ")
        print(f"  {icon} [{f.get('severity','?'):8s}] {f.get('type','?')}")
        if f.get("file"):
            print(f"           Fichier : {f['file']}:{f.get('line',0)}")
        print(f"           MASVS   : {f.get('masvs', 'N/A')}")
        print(f"           Fix     : {f.get('fix','')}")
        print()
