"""
Module 1 — Analyse statique
Décompile l'APK avec JADX puis scanne les fichiers Java/Kotlin
avec des patterns regex pour détecter les vulnérabilités d'authentification.
"""

import subprocess
import os
import re
import base64
import json
import shutil
from pathlib import Path


def _find_jadx() -> str:
    """Résout le chemin réel de JADX (gère jadx.cmd sur Windows)."""
    for name in ("jadx", "jadx.cmd"):
        path = shutil.which(name)
        if path:
            return path
    raise RuntimeError(
        "JADX introuvable. Installez-le avec : scoop install extras/jadx\n"
        "Puis redemarrez votre terminal."
    )

# ---------------------------------------------------------------------------
# Patterns de vulnérabilités
# ---------------------------------------------------------------------------

SOURCE_PATTERNS = [
    # ── CRITIQUE ──────────────────────────────────────────────────────────
    {
        "id": "JWT_HARDCODED",
        "severity": "CRITIQUE",
        "type": "JWT code en dur",
        "pattern": r"eyJ[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]*",
        "description": "Token JWT code en dur dans le code source",
    },
    {
        "id": "HARDCODED_SECRET",
        "severity": "CRITIQUE",
        "type": "Secret code en dur",
        "pattern": (
            r'(?i)(?:password|secret|api_key|apikey|passwd|pwd|jwt_secret'
            r'|private_key)\s*[=:]\s*["\'][^"\']{6,}["\']'
        ),
        "description": "Mot de passe ou cle secrete code en dur",
    },
    # ── ELEVE ─────────────────────────────────────────────────────────────
    {
        "id": "WEAK_CRYPTO_AES_ECB",
        "severity": "ELEVE",
        "type": "Chiffrement AES/ECB faible",
        "pattern": r'AES/ECB|Cipher\.getInstance\(\s*["\']AES["\']',
        "description": "Mode AES/ECB vulnerabe (pas d'IV, fuites de motifs)",
    },
    {
        "id": "WEAK_HASH_MD5",
        "severity": "ELEVE",
        "type": "Hachage MD5 faible",
        "pattern": r'MessageDigest\.getInstance\(\s*["\']MD5["\']|\.md5\(',
        "description": "MD5 est cryptographiquement casse",
    },
    {
        "id": "WEAK_HASH_SHA1",
        "severity": "ELEVE",
        "type": "Hachage SHA-1 faible",
        "pattern": r'MessageDigest\.getInstance\(\s*["\']SHA-1["\']|DigestUtils\.sha1',
        "description": "SHA-1 est deprecie pour les usages cryptographiques",
    },
    {
        "id": "LOG_CREDENTIALS",
        "severity": "ELEVE",
        "type": "Identifiants dans les logs",
        "pattern": (
            r'Log\.[dDeEiIwW]\([^)]*'
            r'(?:password|token|secret|credential|passwd|jwt)[^)]*\)'
        ),
        "description": "Donnees sensibles enregistrees dans les logs Android",
    },
    {
        "id": "SHARED_PREFS_TOKEN",
        "severity": "ELEVE",
        "type": "Token dans SharedPreferences",
        "pattern": (
            r'(?:getSharedPreferences|SharedPreferences)[^;]{0,200}'
            r'(?:token|jwt|session|auth|cookie)'
        ),
        "description": "Token d'authentification stocke en clair dans SharedPreferences",
    },
    # ── MOYEN ─────────────────────────────────────────────────────────────
    {
        "id": "NO_SSL_VALIDATION",
        "severity": "MOYEN",
        "type": "Validation SSL desactivee",
        "pattern": (
            r'TrustAllCerts|ALLOW_ALL_HOSTNAME_VERIFIER'
            r'|setHostnameVerifier\s*\([^)]*ALLOW_ALL'
            r'|X509TrustManager\b'
            r'|checkServerTrusted\s*\(\s*\)'
        ),
        "description": "Validation du certificat SSL contournee (vulnerable au MITM)",
    },
    {
        "id": "HTTP_CLEARTEXT",
        "severity": "MOYEN",
        "type": "Communication en clair (HTTP)",
        "pattern": r'http://(?!localhost|127\.0\.0\.1|10\.0\.2\.2)[A-Za-z0-9]',
        "description": "URL HTTP non chiffree vers un serveur externe",
    },
]

MANIFEST_PATTERNS = [
    {
        "id": "DEBUG_ENABLED",
        "severity": "MOYEN",
        "type": "Mode debug active",
        "pattern": r'android:debuggable\s*=\s*"true"',
        "description": "L'application est en mode debug (extraction de donnees facilitee)",
    },
    {
        "id": "EXPORTED_ACTIVITY",
        "severity": "MOYEN",
        "type": "Activite exportee",
        "pattern": r'android:exported\s*=\s*"true"',
        "description": "Composant accessible depuis d'autres applications sans permission",
    },
    {
        "id": "BACKUP_ENABLED",
        "severity": "MOYEN",
        "type": "Sauvegarde ADB activee",
        "pattern": r'android:allowBackup\s*=\s*"true"',
        "description": "Sauvegarde ADB activee — données extractibles via adb backup",
    },
]

# ---------------------------------------------------------------------------
# Helpers JWT
# ---------------------------------------------------------------------------

def _decode_jwt_payload(token: str) -> dict:
    """Décode le payload d'un token JWT (base64url) et retourne le dict JSON."""
    try:
        parts = token.split(".")
        if len(parts) < 2:
            return {}
        b64 = parts[1]
        # Ajouter le padding manquant
        b64 += "=" * (4 - len(b64) % 4)
        return json.loads(base64.urlsafe_b64decode(b64))
    except Exception:
        return {}


def _jwt_missing_exp(token: str) -> bool:
    payload = _decode_jwt_payload(token)
    return bool(payload) and "exp" not in payload


# ---------------------------------------------------------------------------
# Décompilation JADX
# ---------------------------------------------------------------------------

def decompile_apk(apk_path: str, output_dir: str) -> int:
    """
    Lance JADX pour décompiler l'APK.
    Retourne le nombre de fichiers Java/Kotlin produits.
    Lève RuntimeError si JADX échoue.
    """
    os.makedirs(output_dir, exist_ok=True)
    jadx = _find_jadx()

    try:
        subprocess.run(
            [jadx, "-d", output_dir, "--no-res", apk_path],
            capture_output=True,
            #text=True,
            timeout=180,
        )
    except subprocess.TimeoutExpired:
        raise RuntimeError("JADX a depasse le delai de 180 secondes")

    java_files = list(Path(output_dir).rglob("*.java"))
    kt_files = list(Path(output_dir).rglob("*.kt"))
    total = len(java_files) + len(kt_files)

    if total == 0:
        # Essayer sans --no-res (certains APKs en ont besoin)
        try:
            subprocess.run(
                [jadx, "-d", output_dir, apk_path],
                capture_output=True,
                #text=True,
                timeout=180,
            )
            java_files = list(Path(output_dir).rglob("*.java"))
            kt_files = list(Path(output_dir).rglob("*.kt"))
            total = len(java_files) + len(kt_files)
        except Exception:
            pass

    return total


# ---------------------------------------------------------------------------
# Scan des fichiers sources
# ---------------------------------------------------------------------------

def _read_file(path: str) -> str:
    try:
        with open(path, "r", encoding="utf-8", errors="ignore") as f:
            return f.read()
    except Exception:
        return ""


def _line_of(content: str, pos: int) -> int:
    return content[:pos].count("\n") + 1


def scan_sources(output_dir: str) -> tuple:
    """
    Parcourt les fichiers Java/Kotlin décompilés et applique les patterns.
    Retourne (findings, auth_type).
    """
    findings = []
    seen = set()           # éviter les doublons (fichier, id, ligne)
    jwt_found = False
    session_found = False

    for root, _dirs, files in os.walk(output_dir):
        for fname in files:
            if not fname.endswith((".java", ".kt")):
                continue
            fpath = os.path.join(root, fname)
            content = _read_file(fpath)
            if not content:
                continue

            rel = os.path.relpath(fpath, output_dir)

            # Détecter l'usage JWT uniquement dans le code de l'application
            # (exclure les librairies obfusquées : chemins type a/b/c/X.java)
            path_parts = rel.replace("\\", "/").split("/")
            is_app_code = any(
                len(part) > 3 for part in path_parts if part.endswith(".java") is False
            )
            if is_app_code and re.search(
                r"import.*jwt|Jwts\.|JwtBuilder|JWTVerifier|JWTCreator"
                r"|parseJwt|validateToken|generateToken|accessToken|refreshToken"
                r"|Bearer\b|Authorization.*Bearer|jwt\.decode|jwt\.sign"
                r"|com\.auth0\.jwt|io\.jsonwebtoken",
                content,
                re.IGNORECASE,
            ):
                jwt_found = True

            # Détecter les patterns session/cookie (seulement si pas JWT)
            if not jwt_found and re.search(
                r"JSESSIONID|SessionCookie|HttpSession|getSession\(\)"
                r"|cookie.*session|session.*cookie",
                content,
                re.IGNORECASE,
            ):
                session_found = True

            for pat in SOURCE_PATTERNS:
                for match in re.finditer(pat["pattern"], content, re.IGNORECASE | re.DOTALL):
                    line = _line_of(content, match.start())
                    key = (pat["id"], rel, line)
                    if key in seen:
                        continue
                    seen.add(key)

                    detail = match.group(0).strip()[:100]
                    finding = {
                        "id": pat["id"],
                        "severity": pat["severity"],
                        "type": pat["type"],
                        "file": rel,
                        "line": line,
                        "detail": detail,
                        "description": pat["description"],
                    }
                    findings.append(finding)

                    if pat["id"] == "JWT_HARDCODED":
                        jwt_found = True
                        if _jwt_missing_exp(detail):
                            exp_key = ("JWT_NO_EXP", rel, line)
                            if exp_key not in seen:
                                seen.add(exp_key)
                                findings.append({
                                    "id": "JWT_NO_EXP",
                                    "severity": "CRITIQUE",
                                    "type": "JWT sans expiration (exp)",
                                    "file": rel,
                                    "line": line,
                                    "detail": "Champ 'exp' absent du payload JWT",
                                    "description": (
                                        "Le token JWT ne contient pas de champ 'exp' "
                                        "et ne expire jamais"
                                    ),
                                })

    return findings, jwt_found, session_found


def scan_manifest(output_dir: str) -> list:
    """Scanne AndroidManifest.xml pour les mauvaises configurations."""
    findings = []

    # Chercher le manifest dans les répertoires courants de JADX
    candidates = [
        os.path.join(output_dir, "resources", "AndroidManifest.xml"),
        os.path.join(output_dir, "AndroidManifest.xml"),
    ]
    for root, _dirs, files in os.walk(output_dir):
        for fname in files:
            if fname == "AndroidManifest.xml":
                candidates.insert(0, os.path.join(root, fname))
                break

    manifest_path = None
    for c in candidates:
        if os.path.exists(c):
            manifest_path = c
            break

    if not manifest_path:
        return findings

    content = _read_file(manifest_path)
    seen = set()

    for pat in MANIFEST_PATTERNS:
        for match in re.finditer(pat["pattern"], content, re.IGNORECASE):
            line = _line_of(content, match.start())
            key = (pat["id"], line)
            if key in seen:
                continue
            seen.add(key)
            findings.append({
                "id": pat["id"],
                "severity": pat["severity"],
                "type": pat["type"],
                "file": "AndroidManifest.xml",
                "line": line,
                "detail": match.group(0).strip()[:100],
                "description": pat["description"],
            })

    return findings


# ---------------------------------------------------------------------------
# Score
# ---------------------------------------------------------------------------

SEVERITY_PENALTY = {"CRITIQUE": 3, "ELEVE": 2, "MOYEN": 1}


def compute_score(findings: list) -> int:
    score = 10
    for f in findings:
        score -= SEVERITY_PENALTY.get(f["severity"], 0)
    return max(0, score)


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(apk_path: str, output_dir: str) -> dict:
    files_count = decompile_apk(apk_path, output_dir)

    if files_count == 0:
        return {
            "auth_type": "UNKNOWN",
            "findings": [],
            "score": 10,
            "files_scanned": 0,
            "error": "JADX n'a produit aucun fichier source",
        }

    src_findings, jwt_found, session_found = scan_sources(output_dir)
    manifest_findings = scan_manifest(output_dir)
    all_findings = src_findings + manifest_findings

    # Détection simple — PAS de OAUTH2 ici (trop de faux positifs GMS)
    if jwt_found:
        auth_type = "JWT"
    elif session_found:
        auth_type = "SESSION_COOKIE"
    else:
        auth_type = "UNKNOWN"

    return {
        "auth_type": auth_type,
        "findings": all_findings,
        "score": compute_score(all_findings),
        "files_scanned": files_count,
    }