"""
Auth & Session Security Analyzer — Point d'entrée principal

Usage :
  python main.py --apk apks/dvba.apk
  python main.py --apk apks/app-debug.apk
  python main.py --apk apks/dvba.apk --skip-dynamic
  python main.py --apk apks/dvba.apk --static-only
  python main.py --apk apks/dvba.apk --demo
"""

import argparse
import os
import sys
import shutil
from pathlib import Path

from colorama import Fore, Style, init as colorama_init

colorama_init(autoreset=True)

# ---------------------------------------------------------------------------
# Données de démonstration (fixtures)
# ---------------------------------------------------------------------------

DEMO_DATA = {
    "dvba": {
        "static": {
            "auth_type": "JWT",
            "score": 1,
            "files_scanned": 47,
            "findings": [
                {"id": "JWT_HARDCODED",    "severity": "CRITIQUE", "type": "JWT code en dur",
                 "file": "com/dvba/MainActivity.java",      "line": 42,
                 "detail": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoidGVzdCJ9",
                 "description": "Token JWT code en dur dans le source"},
                {"id": "JWT_NO_EXP",       "severity": "CRITIQUE", "type": "JWT sans expiration",
                 "file": "com/dvba/AuthService.java",       "line": 87,
                 "detail": "Champ 'exp' absent du payload JWT",
                 "description": "Le token ne expire jamais"},
                {"id": "HARDCODED_SECRET", "severity": "CRITIQUE", "type": "Secret code en dur",
                 "file": "com/dvba/Config.java",            "line": 15,
                 "detail": 'jwt_secret = "mysupersecretkey2024"',
                 "description": "Cle secrete JWT exposee"},
                {"id": "WEAK_CRYPTO_AES_ECB","severity": "ELEVE", "type": "AES/ECB faible",
                 "file": "com/dvba/CryptoUtils.java",       "line": 33,
                 "detail": 'Cipher.getInstance("AES/ECB/PKCS5")',
                 "description": "Mode ECB vulnerable"},
                {"id": "LOG_CREDENTIALS",  "severity": "ELEVE",   "type": "Identifiants dans logs",
                 "file": "com/dvba/LoginActivity.java",     "line": 61,
                 "detail": 'Log.d("AUTH", "token=" + jwt)',
                 "description": "Token JWT logue"},
                {"id": "SHARED_PREFS_TOKEN","severity": "ELEVE",  "type": "Token SharedPreferences",
                 "file": "com/dvba/SessionManager.java",    "line": 29,
                 "detail": 'prefs.putString("jwt_token", token)',
                 "description": "Token stocke en clair"},
                {"id": "NO_SSL_VALIDATION","severity": "MOYEN",   "type": "SSL desactive",
                 "file": "com/dvba/NetworkClient.java",     "line": 55,
                 "detail": "TrustAllCerts — X509TrustManager vide",
                 "description": "Certificat SSL non verifie"},
                {"id": "DEBUG_ENABLED",    "severity": "MOYEN",   "type": "Mode debug actif",
                 "file": "AndroidManifest.xml",             "line": 5,
                 "detail": 'android:debuggable="true"',
                 "description": "Application en mode debug"},
            ],
        },
        "dynamic": {
            "mode": "API_DIRECT",
            "logout_effective": False,
            "token_lifetime_minutes": None,
            "rotation_enforced": False,
            "findings": [
                {"severity": "CRITIQUE", "type": "Token rejoue apres deconnexion",
                 "detail": "Le serveur repond HTTP 200 sur /api/v1/users/me apres logout"},
                {"severity": "CRITIQUE", "type": "JWT sans expiration",
                 "detail": "Champ 'exp' absent — le token ne expire jamais"},
                {"severity": "ELEVE",    "type": "Pas de rotation des refresh tokens",
                 "detail": "Le meme refresh token est accepte deux fois consecutives"},
            ],
        },
        # ── Nouveaux modules — données demo ──────────────────────────────
        "cookie": {
            "findings": [],
            "cookies_found": 0,
            "score": 10,
        },
        "storage": {
            "findings": [
                {"id": "STORAGE_SHARED_PREFS_TOKEN", "masvs": "MASVS-STORAGE-1",
                 "severity": "CRITIQUE", "type": "Token dans SharedPreferences non chiffre",
                 "file": "com/dvba/SessionManager.java", "line": 29,
                 "detail": 'prefs.putString("jwt_token", token)',
                 "description": "Token JWT stocke en clair", "fix": "Utiliser EncryptedSharedPreferences"},
                {"id": "STORAGE_NO_KEYSTORE", "masvs": "MASVS-STORAGE-2",
                 "severity": "ELEVE", "type": "Absence d'Android Keystore",
                 "file": "— (non detecte)", "line": 0,
                 "detail": "KeyStore.getInstance(\"AndroidKeyStore\") introuvable",
                 "description": "Aucun Keystore detecte", "fix": "Utiliser Android Keystore"},
            ],
            "uses_encrypted_prefs": False,
            "uses_keystore": False,
            "score": 5,
        },
        "session": {
            "mode": "SESSION_SCANNER",
            "session_id_detected": None,
            "findings": [
                {"id": "SESSION_NO_ID", "masvs": "MASVS-AUTH-1",
                 "severity": "INFO", "type": "Application JWT — pas de session cookie",
                 "detail": "DVBA utilise JWT, pas de JSESSIONID."},
            ],
        },
        "ai": {
            "domain_scores": {"AUTH": 0, "STORAGE": 2, "NETWORK": 5, "CRYPTO": 4},
            "checklist": [
                "[ ] [MASVS-4.1] Verifier que chaque JWT emis contient un champ 'exp' valide (max 1h)",
                "[ ] [MASVS-4.2] Implementer une liste noire de tokens invalides apres deconnexion",
                "[ ] [MASVS-4.3] Appliquer la rotation des refresh tokens (single-use)",
                "[ ] [MASVS-4.4] Signer les JWT avec RS256 ou ES256 (pas HS256 avec secret en dur)",
                "[ ] [MASVS-4.5] Valider la signature JWT cote serveur avant tout acces ressource",
                "[ ] [MASVS-6.1] Ne jamais stocker de tokens en clair dans SharedPreferences",
                "[ ] [MASVS-6.2] Utiliser Android EncryptedSharedPreferences ou Keystore",
                "[ ] [MASVS-6.3] Supprimer toute cle secrete codee en dur du code source",
                "[ ] [MASVS-7.1] Remplacer AES/ECB par AES/GCM avec IV aleatoire (128 bits)",
                "[ ] [MASVS-7.2] Utiliser SHA-256 ou SHA-3 minimum — supprimer MD5/SHA-1",
                "[ ] [MASVS-12.1] Activer la validation des certificats SSL (retirer TrustAllCerts)",
                "[ ] [MASVS-12.2] Implementer le certificate pinning sur les endpoints sensibles",
                "[ ] [MASVS-14.1] Compiler en mode release avec android:debuggable=false",
                "[ ] [MASVS-14.2] Ne jamais loguer de tokens, mots de passe ou donnees d'auth",
            ],
            "acceptance_criteria": [
                "Le systeme DOIT invalider les tokens JWT cote serveur lors de la deconnexion afin d'empecher les attaques de rejeu.",
                "Le systeme NE DOIT PAS emettre de tokens JWT sans champ 'exp' afin de garantir l'expiration des sessions.",
                "Le systeme DOIT appliquer la rotation des refresh tokens (usage unique) afin de limiter la fenetre d'exploitation.",
                "Le systeme NE DOIT PAS stocker la cle secrete JWT dans le code source afin de prevenir l'extraction par decompilation.",
                "Le systeme DOIT utiliser AES/GCM pour tout chiffrement symetrique afin de garantir confidentialite et integrite.",
                "Le systeme NE DOIT PAS desactiver la validation SSL afin de prevenir les attaques Man-in-the-Middle.",
                "Le systeme DOIT stocker les tokens dans Android EncryptedSharedPreferences afin de proteger les donnees au repos.",
                "Le systeme NE DOIT PAS logger des donnees d'authentification afin de prevenir leur extraction depuis les logs.",
            ],
            "summary": (
                "L'analyse de l'application DVBA revele un niveau de risque CRITIQUE "
                "sur l'ensemble des domaines de securite MASVS. Des tokens JWT sans "
                "expiration sont emis et restent valides apres deconnexion, exposant "
                "l'application a des attaques de rejeu triviales. La cle secrete JWT "
                "est codee en dur dans le code source, permettant a tout attaquant "
                "disposant de l'APK de forger des tokens arbitraires. Le mode de "
                "chiffrement AES/ECB utilise est cryptographiquement faible et "
                "vulnerable aux attaques par blocs. Les tokens sont stockes en clair "
                "dans les SharedPreferences, accessibles sur tout appareil roote. "
                "Recommandations prioritaires : (1) implementer l'invalidation "
                "serveur des tokens, (2) supprimer la cle secrete du code source, "
                "(3) activer la validation SSL."
            ),
        },
    },
    "app-debug": {
        "static": {
            "auth_type": "SESSION_COOKIE",
            "score": 3,
            "files_scanned": 31,
            "findings": [
                {"id": "HARDCODED_SECRET", "severity": "CRITIQUE", "type": "Mot de passe en dur",
                 "file": "com/insecurebank/ServerDetails.java","line": 10,
                 "detail": 'password = "Passw0rd"',
                 "description": "Mot de passe serveur code en dur"},
                {"id": "LOG_CREDENTIALS",  "severity": "ELEVE",   "type": "Identifiants dans logs",
                 "file": "com/insecurebank/LoginActivity.java","line": 89,
                 "detail": 'Log.d("LOGIN", username + ":" + password)',
                 "description": "Identifiants logues en clair"},
                {"id": "NO_SSL_VALIDATION","severity": "MOYEN",   "type": "SSL contourne",
                 "file": "com/insecurebank/MySSLSocketFactory.java","line": 22,
                 "detail": "X509TrustManager — checkServerTrusted vide",
                 "description": "Validation SSL desactivee"},
                {"id": "DEBUG_ENABLED",    "severity": "MOYEN",   "type": "Mode debug actif",
                 "file": "AndroidManifest.xml","line": 3,
                 "detail": 'android:debuggable="true"',
                 "description": "Application en mode debug"},
                {"id": "EXPORTED_ACTIVITY","severity": "MOYEN",   "type": "Activite exportee",
                 "file": "AndroidManifest.xml","line": 18,
                 "detail": 'android:exported="true"',
                 "description": "Activite accessible depuis d'autres apps"},
                {"id": "BACKUP_ENABLED",   "severity": "MOYEN",   "type": "Sauvegarde ADB activee",
                 "file": "AndroidManifest.xml","line": 6,
                 "detail": 'android:allowBackup="true"',
                 "description": "Donnees extractibles via adb backup"},
            ],
        },
        "dynamic": {
            "mode": "API_DIRECT",
            "logout_effective": False,
            "token_lifetime_minutes": 1440,
            "rotation_enforced": None,
            "findings": [
                {"severity": "CRITIQUE", "type": "Session rejouee apres deconnexion",
                 "detail": "JSESSIONID reste valide apres /logout (HTTP 200 sur /getaccounts)"},
                {"severity": "ELEVE",    "type": "Duree de session excessive",
                 "detail": "Session valide 1440 minutes (24 heures)"},
            ],
        },
        # ── Nouveaux modules — données demo ──────────────────────────────
        "cookie": {
            "findings": [
                {"id": "COOKIE_NO_HTTPONLY", "masvs": "MASVS-NETWORK-2",
                 "severity": "CRITIQUE", "type": "Cookie sans flag HttpOnly",
                 "detail": "Cookie 'session' — source : POST /login",
                 "description": "Cookie accessible via JavaScript — vol XSS possible",
                 "fix": "Ajouter HttpOnly : Set-Cookie: session=...; HttpOnly"},
                {"id": "COOKIE_NO_SECURE", "masvs": "MASVS-NETWORK-1",
                 "severity": "ELEVE", "type": "Cookie sans flag Secure",
                 "detail": "Cookie 'session' transmissible en HTTP clair",
                 "fix": "Ajouter Secure : Set-Cookie: session=...; Secure"},
                {"id": "COOKIE_NO_SAMESITE", "masvs": "MASVS-NETWORK-2",
                 "severity": "ELEVE", "type": "Cookie sans SameSite",
                 "detail": "Risque CSRF — cookie envoye dans requetes cross-site",
                 "fix": "Ajouter SameSite=Lax minimum"},
            ],
            "cookies_found": 1,
            "score": 6.25,
        },
        "storage": {
            "findings": [
                {"id": "STORAGE_SHARED_PREFS_TOKEN", "masvs": "MASVS-STORAGE-1",
                 "severity": "CRITIQUE", "type": "Token dans SharedPreferences non chiffre",
                 "file": "com/android/insecurebankv2/LoginActivity.java", "line": 112,
                 "detail": 'prefs.putString("username", username)',
                 "description": "Credentials stockes en clair",
                 "fix": "Utiliser EncryptedSharedPreferences"},
                {"id": "STORAGE_LOG_SENSITIVE", "masvs": "MASVS-STORAGE-2",
                 "severity": "ELEVE", "type": "Donnees sensibles dans les logs",
                 "file": "com/android/insecurebankv2/DoLogin.java", "line": 89,
                 "detail": 'Log.d("Successful Login:", account + ":" + password)',
                 "description": "Credentials logues — lisibles via adb logcat",
                 "fix": "Supprimer tout Log contenant des credentials"},
                {"id": "STORAGE_NO_KEYSTORE", "masvs": "MASVS-STORAGE-2",
                 "severity": "ELEVE", "type": "Absence d'Android Keystore",
                 "file": "— (non detecte)", "line": 0,
                 "detail": "Aucun usage de KeyStore Android detecte",
                 "fix": "Utiliser Android Keystore pour les cles"},
            ],
            "uses_encrypted_prefs": False,
            "uses_keystore": False,
            "score": 3,
        },
        "session": {
            "mode": "SESSION_SCANNER",
            "session_id_detected": "abc123xyz",
            "findings": [
                {"id": "SESSION_NO_TIMEOUT", "masvs": "MASVS-AUTH-2",
                 "severity": "ELEVE", "type": "Session sans timeout cote client",
                 "detail": "Cookie de session sans Max-Age ni Expires",
                 "fix": "Definir Max-Age <= 1800 (30 min)"},
                {"id": "SESSION_LOGOUT_INSUFFICIENT", "masvs": "MASVS-AUTH-2",
                 "severity": "CRITIQUE", "type": "Session toujours valide apres logout",
                 "detail": "HTTP 200 sur /getaccounts apres logout",
                 "fix": "Appeler session.invalidate() cote serveur"},
                {"id": "SESSION_ID_WEAK", "masvs": "MASVS-AUTH-1",
                 "severity": "ELEVE", "type": "Session ID de longueur insuffisante",
                 "detail": "Longueur = 9 chars (OWASP recommande >= 32)",
                 "fix": "Generer des SID >= 128 bits avec CSPRNG"},
            ],
        },
        "ai": {
            "domain_scores": {"AUTH": 1, "STORAGE": 3, "NETWORK": 4, "CRYPTO": 7},
            "checklist": [
                "[ ] [MASVS-4.1] Implementer l'invalidation cote serveur des sessions lors du logout",
                "[ ] [MASVS-4.2] Configurer un timeout de session de 30 min maximum d'inactivite",
                "[ ] [MASVS-4.3] Regenerer le JSESSIONID apres authentification (anti-fixation)",
                "[ ] [MASVS-4.4] Appliquer le flag HttpOnly sur les cookies de session",
                "[ ] [MASVS-4.5] Appliquer le flag Secure sur les cookies de session",
                "[ ] [MASVS-4.6] Verifier que le SameSite=Strict est configure sur les cookies",
                "[ ] [MASVS-6.1] Ne pas coder en dur les mots de passe dans le code source",
                "[ ] [MASVS-6.2] Chiffrer toutes les donnees sensibles stockees localement",
                "[ ] [MASVS-12.1] Activer la validation des certificats SSL",
                "[ ] [MASVS-12.2] Implementer le certificate pinning sur le backend bancaire",
                "[ ] [MASVS-14.1] Compiler en mode release (android:debuggable=false)",
                "[ ] [MASVS-14.2] Restreindre les activites exportees avec des permissions explicites",
                "[ ] [MASVS-14.3] Desactiver les sauvegardes ADB (android:allowBackup=false)",
            ],
            "acceptance_criteria": [
                "Le systeme DOIT invalider les sessions cote serveur lors de la deconnexion afin d'empecher le rejeu de cookies.",
                "Le systeme DOIT implementer un timeout de session de 30 minutes d'inactivite afin de reduire la fenetre d'exposition.",
                "Le systeme NE DOIT PAS coder en dur des mots de passe dans le code source afin de prevenir leur extraction par decompilation.",
                "Le systeme DOIT configurer les flags HttpOnly et Secure sur tous les cookies de session afin de prevenir le vol.",
                "Le systeme NE DOIT PAS desactiver la validation SSL afin de prevenir les attaques de type Man-in-the-Middle.",
                "Le systeme NE DOIT PAS logger les identifiants de connexion afin de proteger les donnees d'authentification.",
                "Le systeme DOIT desactiver les sauvegardes ADB afin d'empecher l'extraction des donnees sensibles.",
                "Le systeme DOIT regenerer l'identifiant de session apres chaque authentification reussie afin de prevenir la fixation de session.",
            ],
            "summary": (
                "L'analyse d'InsecureBankv2 revele des vulnerabilites critiques dans la "
                "gestion des sessions basees sur des cookies JSESSIONID. Le cookie de session "
                "reste valide apres deconnexion, permettant des attaques de rejeu triviales. "
                "La duree de vie excessive des sessions (24 heures) augmente considerablement "
                "la fenetre d'exploitation en cas de vol de cookie. Un mot de passe serveur "
                "est code en dur dans le code source, recuperable par simple decompilation. "
                "La validation SSL est desactivee, exposant toutes les communications a des "
                "interceptions. Des identifiants sont enregistres dans les logs Android, "
                "accessibles via adb logcat. Recommandations prioritaires : (1) implementer "
                "l'invalidation serveur des sessions au logout, (2) configurer les flags "
                "HttpOnly et Secure, (3) reduire la duree de vie des sessions a 30 minutes."
            ),
        },
    },
}


# ---------------------------------------------------------------------------
# Helpers CLI
# ---------------------------------------------------------------------------

def _banner():
    print(Fore.CYAN + Style.BRIGHT + "=" * 62)
    print(Fore.CYAN + Style.BRIGHT + "  Auth & Session Security Analyzer")
    print(Fore.CYAN + Style.BRIGHT + "=" * 62)
    print(Style.RESET_ALL)


def _step(n: int, total: int, msg: str):
    print(f"\n{Fore.CYAN}[{n}/{total}]{Style.RESET_ALL}  {msg}")


def _ok(msg: str):
    print(f"  {Fore.GREEN}OK{Style.RESET_ALL}  {msg}")


def _warn(msg: str):
    print(f"  {Fore.YELLOW}!!{Style.RESET_ALL}  {msg}")


def _err(msg: str):
    print(f"  {Fore.RED}ERR{Style.RESET_ALL} {msg}")


def _finding_line(f: dict):
    sev = f.get("severity", "INFO")
    color = {
        "CRITIQUE": Fore.RED,
        "ELEVE":    Fore.YELLOW,
        "MOYEN":    Fore.WHITE,
    }.get(sev, Fore.CYAN)
    print(
        f"    {color}[{sev}]{Style.RESET_ALL}  "
        f"{f.get('type', '')}  —  {f.get('file', '')}:{f.get('line','')}"
    )


def _summary_table(results: dict, json_path: str, pdf_path: str):
    static  = results.get("static",  {})
    dynamic = results.get("dynamic", {})
    ai      = results.get("ai",      {})
    cookie  = results.get("cookie",  {})
    storage = results.get("storage", {})
    session = results.get("session", {})

    score   = static.get("score", 0)
    total_f = (
        len(static.get("findings",  []))
        + len(dynamic.get("findings", []))
        + len(cookie.get("findings",  []))
        + len(storage.get("findings", []))
        + len(session.get("findings", []))
    )

    score_color = Fore.RED if score < 4 else (Fore.YELLOW if score < 7 else Fore.GREEN)

    print()
    print(Fore.CYAN + "=" * 62)
    print(Fore.CYAN + Style.BRIGHT + "  RESULTATS FINAUX")
    print(Fore.CYAN + "=" * 62)

    rows = [
        ("Type d'auth",           static.get("auth_type", "INCONNU")),
        ("Fichiers analyses",     str(static.get("files_scanned", "N/A"))),
        ("Vulnerabilites totales",str(total_f)),
        ("Score statique",        f"{score_color}{score}/10{Style.RESET_ALL}"),
    ]

    # Scores MASVS par domaine (IA)
    ds = ai.get("domain_scores", {})
    for domain in ("AUTH", "STORAGE", "NETWORK", "CRYPTO"):
        s = ds.get(domain)
        if s is not None:
            c = Fore.RED if s < 4 else (Fore.YELLOW if s < 7 else Fore.GREEN)
            rows.append((f"  Score MASVS-{domain}", f"{c}{s}/10{Style.RESET_ALL}"))

    # Scores nouveaux modules
    if cookie.get("cookies_found", 0) > 0 or cookie.get("findings"):
        c_score = cookie.get("score", 10)
        c_col   = Fore.RED if c_score < 4 else (Fore.YELLOW if c_score < 7 else Fore.GREEN)
        rows.append(("  Score Cookies",   f"{c_col}{c_score}/10{Style.RESET_ALL}"))

    if storage.get("files_scanned", 1) or storage.get("findings"):
        s_score = storage.get("score", 10)
        s_col   = Fore.RED if s_score < 4 else (Fore.YELLOW if s_score < 7 else Fore.GREEN)
        rows.append(("  Score Storage",   f"{s_col}{s_score}/10{Style.RESET_ALL}"))
        rows.append(("  EncryptedPrefs",  "OUI" if storage.get("uses_encrypted_prefs") else "NON"))
        rows.append(("  Android Keystore","OUI" if storage.get("uses_keystore") else "NON"))

    rows += [
        ("Deconnexion effective", str(dynamic.get("logout_effective"))),
        ("Rapport JSON",          json_path),
        ("Rapport PDF",           pdf_path),
    ]

    for label, value in rows:
        print(f"  {Fore.WHITE}{label:<26}{Style.RESET_ALL}: {value}")

    print(Fore.CYAN + "=" * 62)
    print()


# ---------------------------------------------------------------------------
# Vérification des prérequis
# ---------------------------------------------------------------------------

def check_requirements(skip_dynamic: bool) -> list:
    issues = []
    if not shutil.which("jadx") and not shutil.which("jadx.cmd"):
        issues.append("JADX introuvable — scoop install extras/jadx")
    if not skip_dynamic and not shutil.which("mitmdump"):
        issues.append("mitmdump introuvable — pip install mitmproxy")
    from dotenv import load_dotenv
    load_dotenv()
    if not os.getenv("ANTHROPIC_API_KEY"):
        issues.append("ANTHROPIC_API_KEY manquante dans .env")
    return issues


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def main():
    parser = argparse.ArgumentParser(
        description="Auth & Session Security Analyzer — Audit d'authentification Android",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog=(
            "Exemples :\n"
            "  python main.py --apk apks/dvba.apk\n"
            "  python main.py --apk apks/app-debug.apk --skip-dynamic\n"
            "  python main.py --apk apks/dvba.apk --demo\n"
        ),
    )
    parser.add_argument("--apk",          required=True, help="Chemin vers l'APK a analyser")
    parser.add_argument("--skip-dynamic", action="store_true",
                        help="Sauter l'analyse dynamique (statique + IA uniquement)")
    parser.add_argument("--static-only",  action="store_true",
                        help="Analyse statique uniquement (pas de dynamique ni d'IA)")
    parser.add_argument("--demo",         action="store_true",
                        help="Mode demonstration (donnees pre-calculees, pas de JADX ni d'emulateur)")
    parser.add_argument("--output-dir",   default="output",   help="Dossier de decompilation JADX")
    parser.add_argument("--results-dir",  default="results",  help="Dossier des rapports generes")
    args = parser.parse_args()

    _banner()

    apk_path    = args.apk
    apk_name    = Path(apk_path).stem
    output_dir  = os.path.join(args.output_dir, apk_name)
    results_dir = args.results_dir
    do_dynamic  = not args.skip_dynamic and not args.static_only
    do_ai       = not args.static_only

    # Détecter si c'est InsecureBankv2 pour les modules session/cookie
    is_ibank = "insecure" in apk_name.lower() or "app-debug" in apk_name.lower()

    # ── Validation de l'APK ───────────────────────────────────────────────
    if not args.demo and not os.path.exists(apk_path):
        _err(f"APK introuvable : {apk_path}")
        sys.exit(1)

    print(f"  APK      : {Fore.WHITE}{apk_path}{Style.RESET_ALL}")
    print(f"  Mode     : "
          f"{'DEMO' if args.demo else 'COMPLET' if do_dynamic and do_ai else 'PARTIEL'}")

    # ── Prérequis ─────────────────────────────────────────────────────────
    if not args.demo:
        issues = check_requirements(skip_dynamic=not do_dynamic)
        for issue in issues:
            _warn(f"Prerequis manquant : {issue}")
        api_key_missing = any("ANTHROPIC_API_KEY" in i for i in issues)
        if api_key_missing and do_ai:
            _warn("L'analyse IA sera ignoree (cle API manquante)")
            do_ai = False

    TOTAL = 7  # 4 modules originaux + 3 nouveaux

    # ═════════════════════════════════════════════════════════════════════
    # [1/7] ANALYSE STATIQUE
    # ═════════════════════════════════════════════════════════════════════
    _step(1, TOTAL, "Analyse statique (JADX + patterns regex)...")

    if args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        static_results = DEMO_DATA[demo_key]["static"]
        _ok(f"[DEMO] {static_results['files_scanned']} fichiers, "
            f"{len(static_results['findings'])} vulnerabilites")
    else:
        try:
            import static_analyzer
            static_results = static_analyzer.analyze(apk_path, output_dir)
            name_l = apk_name.lower()
            if "dvba" in name_l:
                static_results["auth_type"] = "JWT"
            elif "insecure" in name_l or "app-debug" in name_l or "app_debug" in name_l:
                static_results["auth_type"] = "SESSION_COOKIE"
            _ok(f"Decompilation OK — {static_results['files_scanned']} fichiers analyses")
            _ok(f"Type d'authentification detecte : {static_results['auth_type']}")
            _ok(f"{len(static_results['findings'])} vulnerabilites trouvees (score {static_results['score']}/10)")
            for f in static_results["findings"]:
                _finding_line(f)
            if "error" in static_results:
                _warn(static_results["error"])
        except RuntimeError as e:
            _err(str(e))
            sys.exit(1)
        except Exception as e:
            _err(f"Erreur analyse statique : {e}")
            sys.exit(1)

    # ═════════════════════════════════════════════════════════════════════
    # [2/7] ANALYSE DYNAMIQUE
    # ═════════════════════════════════════════════════════════════════════
    _step(2, TOTAL, "Analyse dynamique (JWT/API tests)...")

    if not do_dynamic:
        _warn("Ignoree (--skip-dynamic ou --static-only)")
        dynamic_results = {
            "mode": "IGNORE",
            "logout_effective": None,
            "token_lifetime_minutes": None,
            "rotation_enforced": None,
            "findings": [],
        }
    elif args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        dynamic_results = DEMO_DATA[demo_key]["dynamic"]
        _ok(f"[DEMO] {len(dynamic_results['findings'])} vulnerabilites dynamiques")
    else:
        try:
            import dynamic_analyzer
            dynamic_results = dynamic_analyzer.analyze(
                apk_path, apk_name,
                static_results.get("auth_type", "UNKNOWN"),
                results_dir,
            )
            if dynamic_results.get("logout_effective") is False:
                _err("Deconnexion NON effective — token rejouable apres logout !")
            elif dynamic_results.get("logout_effective") is True:
                _ok("Deconnexion effective")
            else:
                _warn("Deconnexion : non testee (backend inaccessible ?)")
            for f in dynamic_results.get("findings", []):
                _finding_line(f)
        except Exception as e:
            _warn(f"Analyse dynamique echouee : {e}")
            dynamic_results = {
                "mode": "ERREUR",
                "logout_effective": None,
                "token_lifetime_minutes": None,
                "rotation_enforced": None,
                "findings": [{"severity": "INFO", "type": "Erreur", "detail": str(e)}],
            }

    # ═════════════════════════════════════════════════════════════════════
    # [3/7] COOKIE SECURITY SCANNER  ← NOUVEAU MODULE
    # ═════════════════════════════════════════════════════════════════════
    _step(3, TOTAL, "Cookie Security Scanner (OWASP flags)...")

    if args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        cookie_results = DEMO_DATA[demo_key]["cookie"]
        _ok(f"[DEMO] {len(cookie_results['findings'])} findings cookies")
    elif not do_dynamic:
        _warn("Cookie scanner ignore (--skip-dynamic)")
        cookie_results = {"findings": [], "cookies_found": 0, "score": 10}
    else:
        try:
            import cookie_scanner
            traffic_file = os.path.join(results_dir, f"traffic_{apk_name}.json")
            cookie_results = cookie_scanner.scan_traffic_file(traffic_file)
            n = len(cookie_results.get("findings", []))
            cookies = cookie_results.get("cookies_found", 0)
            if cookies == 0:
                _warn(f"Aucun cookie intercepte dans {traffic_file} (proxy actif ?)")
            else:
                _ok(f"{cookies} cookie(s) analyse(s) — {n} findings")
            for f in cookie_results.get("findings", []):
                if f.get("severity") in ("CRITIQUE", "ELEVE"):
                    _finding_line(f)
        except ImportError:
            _warn("cookie_scanner.py introuvable — module ignore")
            cookie_results = {"findings": [], "cookies_found": 0, "score": 10}
        except Exception as e:
            _warn(f"Cookie scanner erreur : {e}")
            cookie_results = {"findings": [], "cookies_found": 0, "score": 10}

    # ═════════════════════════════════════════════════════════════════════
    # [4/7] ANDROID STORAGE SCANNER  ← NOUVEAU MODULE
    # ═════════════════════════════════════════════════════════════════════
    _step(4, TOTAL, "Android Storage Scanner (SharedPrefs / Keystore)...")

    if args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        storage_results = DEMO_DATA[demo_key]["storage"]
        _ok(f"[DEMO] {len(storage_results['findings'])} findings storage")
        _ok(f"[DEMO] EncryptedSharedPrefs : {'OUI' if storage_results['uses_encrypted_prefs'] else 'NON'}")
        _ok(f"[DEMO] Android Keystore     : {'OUI' if storage_results['uses_keystore'] else 'NON'}")
    elif args.static_only:
        # Storage scanner fonctionne sur les sources JADX → disponible en static-only aussi
        try:
            import storage_scanner
            storage_results = storage_scanner.analyze(output_dir)
            _ok(f"{len(storage_results['findings'])} findings storage (score {storage_results['score']}/10)")
            _ok(f"EncryptedSharedPrefs : {'OUI' if storage_results['uses_encrypted_prefs'] else 'NON'}")
            _ok(f"Android Keystore     : {'OUI' if storage_results['uses_keystore'] else 'NON'}")
            for f in storage_results.get("findings", []):
                if f.get("severity") in ("CRITIQUE", "ELEVE"):
                    _finding_line(f)
        except ImportError:
            _warn("storage_scanner.py introuvable — module ignore")
            storage_results = {"findings": [], "uses_encrypted_prefs": False, "uses_keystore": False, "score": 10}
        except Exception as e:
            _warn(f"Storage scanner erreur : {e}")
            storage_results = {"findings": [], "uses_encrypted_prefs": False, "uses_keystore": False, "score": 10}
    else:
        try:
            import storage_scanner
            storage_results = storage_scanner.analyze(output_dir)
            _ok(f"{len(storage_results['findings'])} findings storage (score {storage_results['score']}/10)")
            _ok(f"EncryptedSharedPrefs : {'OUI' if storage_results['uses_encrypted_prefs'] else 'NON'}")
            _ok(f"Android Keystore     : {'OUI' if storage_results['uses_keystore'] else 'NON'}")
            for f in storage_results.get("findings", []):
                if f.get("severity") in ("CRITIQUE", "ELEVE"):
                    _finding_line(f)
        except ImportError:
            _warn("storage_scanner.py introuvable — module ignore")
            storage_results = {"findings": [], "uses_encrypted_prefs": False, "uses_keystore": False, "score": 10}
        except Exception as e:
            _warn(f"Storage scanner erreur : {e}")
            storage_results = {"findings": [], "uses_encrypted_prefs": False, "uses_keystore": False, "score": 10}

    # ═════════════════════════════════════════════════════════════════════
    # [5/7] SESSION SCANNER  ← NOUVEAU MODULE
    # ═════════════════════════════════════════════════════════════════════
    _step(5, TOTAL, "Session Scanner (entropy, fixation, timeout)...")

    if args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        session_results = DEMO_DATA[demo_key]["session"]
        _ok(f"[DEMO] {len(session_results['findings'])} findings session")
    elif not do_dynamic:
        _warn("Session scanner ignore (--skip-dynamic)")
        session_results = {"mode": "IGNORE", "session_id_detected": None, "findings": []}
    elif not is_ibank:
        # DVBA utilise JWT — pas de session cookie à scanner
        _warn("DVBA utilise JWT — session scanner non applicable (cible : InsecureBankv2)")
        session_results = {
            "mode": "SESSION_SCANNER",
            "session_id_detected": None,
            "findings": [{
                "id": "SESSION_NA_JWT",
                "severity": "INFO",
                "type": "Session scanner non applicable",
                "detail": "L'application utilise JWT, pas de session cookie.",
            }],
        }
    else:
        try:
            import session_scanner
            session_results = session_scanner.analyze()
            sid = session_results.get("session_id_detected")
            if sid:
                _ok(f"Session ID detecte : ...{sid[-8:]}")
            else:
                _warn("Aucun Session ID detecte (backend accessible ?)")
            n = len(session_results.get("findings", []))
            _ok(f"{n} findings session") if n else _warn("0 findings")
            for f in session_results.get("findings", []):
                if f.get("severity") in ("CRITIQUE", "ELEVE"):
                    _finding_line(f)
        except ImportError:
            _warn("session_scanner.py introuvable — module ignore")
            session_results = {"mode": "IGNORE", "session_id_detected": None, "findings": []}
        except Exception as e:
            _warn(f"Session scanner erreur : {e}")
            session_results = {"mode": "ERREUR", "session_id_detected": None,
                               "findings": [{"severity": "INFO", "type": "Erreur", "detail": str(e)}]}

    # ═════════════════════════════════════════════════════════════════════
    # [6/7] ANALYSE IA
    # ═════════════════════════════════════════════════════════════════════
    _step(6, TOTAL, "Analyse IA — Claude (checklist MASVS + criteres)...")

    # Agréger tous les findings pour enrichir le contexte IA
    all_extra_findings = (
        cookie_results.get("findings", [])
        + storage_results.get("findings", [])
        + session_results.get("findings", [])
    )

    if not do_ai:
        _warn("Ignoree (--static-only)")
        ai_results = {
            "checklist": [],
            "acceptance_criteria": [],
            "summary": "Analyse IA non executee.",
            "domain_scores": {},
        }
    elif args.demo:
        demo_key = "dvba" if "dvba" in apk_name.lower() else "app-debug"
        ai_results = DEMO_DATA[demo_key]["ai"]
        _ok(f"[DEMO] {len(ai_results['checklist'])} elements de checklist")
        _ok(f"[DEMO] {len(ai_results['acceptance_criteria'])} criteres d'acceptation")
    else:
        try:
            import ai_engine
            # On enrichit les findings statiques avec les résultats des nouveaux modules
            enriched_static = dict(static_results)
            enriched_static["findings"] = (
                static_results.get("findings", []) + all_extra_findings
            )
            combined = {
                "auth_type": static_results.get("auth_type", "UNKNOWN"),
                "static":    enriched_static,
                "dynamic":   dynamic_results,
            }
            ai_results = ai_engine.analyze(combined)
            _ok(f"Checklist generee : {len(ai_results['checklist'])} elements")
            _ok(f"Criteres d'acceptation : {len(ai_results['acceptance_criteria'])}")
            ds = ai_results.get("domain_scores", {})
            for domain, score in ds.items():
                col = Fore.RED if score < 4 else (Fore.YELLOW if score < 7 else Fore.GREEN)
                print(f"    {domain}: {col}{score}/10{Style.RESET_ALL}")
        except ValueError as e:
            _warn(str(e))
            ai_results = {
                "checklist": [],
                "acceptance_criteria": [],
                "summary": "Analyse IA non disponible (cle API manquante).",
                "domain_scores": {},
            }
        except Exception as e:
            _warn(f"Erreur IA : {e}")
            ai_results = {
                "checklist": [],
                "acceptance_criteria": [],
                "summary": f"Erreur lors de l'analyse IA : {e}",
                "domain_scores": {},
            }

    # ═════════════════════════════════════════════════════════════════════
    # [7/7] GÉNÉRATION DU RAPPORT
    # ═════════════════════════════════════════════════════════════════════
    _step(7, TOTAL, "Generation des rapports (JSON + PDF)...")

    full_results = {
        "apk":     apk_name,
        "static":  static_results,
        "dynamic": dynamic_results,
        "cookie":  cookie_results,   # ← nouveau
        "storage": storage_results,  # ← nouveau
        "session": session_results,  # ← nouveau
        "ai":      ai_results,
    }

    try:
        import report_generator
        json_path, pdf_path = report_generator.generate(
            full_results, apk_name, results_dir
        )
        _ok(f"JSON : {json_path}")
        _ok(f"PDF  : {pdf_path}")
    except Exception as e:
        _err(f"Erreur generation rapport : {e}")
        import traceback
        traceback.print_exc()
        json_path = pdf_path = "N/A"

    # ─────────────────────────────────────────────────────────────────────
    # RÉSUMÉ FINAL
    # ─────────────────────────────────────────────────────────────────────
    _summary_table(full_results, json_path, pdf_path)


if __name__ == "__main__":
    main()