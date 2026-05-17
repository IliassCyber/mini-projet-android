"""
Module — Cookie Security Scanner
Vérifie les flags de sécurité OWASP sur les cookies HTTP interceptés.
Mappe les résultats sur MASVS-NETWORK et MASVS-AUTH.

Conformément au guide AuthGuard :
  - HttpOnly (bloque vol XSS)
  - Secure (uniquement HTTPS)
  - SameSite=Lax/Strict (protection CSRF)
  - Cookie Prefix __Host- / __Secure-
  - Expires / Max-Age (durée de vie)
  - Domain scope (limité au domaine cible)

Usage :
    from cookie_scanner import scan_cookies, scan_traffic_file
    findings = scan_cookies("JSESSIONID=abc; HttpOnly; Secure; SameSite=Lax")
    findings = scan_traffic_file("results/traffic_app-debug.json")
"""

import json
import re
from typing import Optional


# ---------------------------------------------------------------------------
# Définition des contrôles OWASP (Section Cookies du Session Mgmt Cheat Sheet)
# ---------------------------------------------------------------------------

COOKIE_CHECKS = [
    {
        "id": "COOKIE_NO_HTTPONLY",
        "masvs": "MASVS-NETWORK-2",
        "severity": "CRITIQUE",
        "type": "Cookie sans flag HttpOnly",
        "description": (
            "Sans HttpOnly, le cookie est accessible via JavaScript "
            "(document.cookie) — vol possible en cas de XSS."
        ),
        "test": lambda c: "httponly" not in c.lower(),
        "fix": "Ajouter le flag HttpOnly : Set-Cookie: session=...; HttpOnly",
    },
    {
        "id": "COOKIE_NO_SECURE",
        "masvs": "MASVS-NETWORK-1",
        "severity": "ELEVE",
        "type": "Cookie sans flag Secure",
        "description": (
            "Sans Secure, le cookie peut être transmis sur HTTP non chiffré "
            "— interceptable par MITM."
        ),
        "test": lambda c: "secure" not in c.lower(),
        "fix": "Ajouter le flag Secure : Set-Cookie: session=...; Secure",
    },
    {
        "id": "COOKIE_NO_SAMESITE",
        "masvs": "MASVS-NETWORK-2",
        "severity": "ELEVE",
        "type": "Cookie sans SameSite",
        "description": (
            "Sans SameSite, le cookie est envoyé dans les requêtes "
            "cross-site — risque CSRF."
        ),
        "test": lambda c: "samesite" not in c.lower(),
        "fix": "Ajouter SameSite=Lax (minimum) ou Strict.",
    },
    {
        "id": "COOKIE_SAMESITE_NONE",
        "masvs": "MASVS-NETWORK-2",
        "severity": "ELEVE",
        "type": "SameSite=None sans Secure",
        "description": (
            "SameSite=None autorise l'envoi cross-site. "
            "Sans Secure, le cookie voyage en clair."
        ),
        "test": lambda c: (
            "samesite=none" in c.lower() and "secure" not in c.lower()
        ),
        "fix": "SameSite=None impose Secure : Set-Cookie: ...; SameSite=None; Secure",
    },
    {
        "id": "COOKIE_NO_EXPIRES",
        "masvs": "MASVS-AUTH-2",
        "severity": "MOYEN",
        "type": "Cookie de session sans expiration",
        "description": (
            "Un cookie sans Max-Age ni Expires persiste jusqu'à fermeture "
            "du navigateur — risque session longue durée."
        ),
        "test": lambda c: (
            "max-age" not in c.lower() and "expires" not in c.lower()
            and _is_session_cookie(c)
        ),
        "fix": "Définir Max-Age ou Expires avec une durée limitée (< 24h).",
    },
    {
        "id": "COOKIE_DOMAIN_TOO_BROAD",
        "masvs": "MASVS-NETWORK-2",
        "severity": "MOYEN",
        "type": "Cookie Domain trop large",
        "description": (
            "Un cookie avec Domain=.example.com est partagé par tous "
            "les sous-domaines — surface d'attaque étendue."
        ),
        "test": lambda c: bool(re.search(r"domain=\.\w", c, re.IGNORECASE)),
        "fix": (
            "Omettre l'attribut Domain pour le restreindre "
            "au domaine exact (comportement par défaut)."
        ),
    },
    {
        "id": "COOKIE_NO_HOST_PREFIX",
        "masvs": "MASVS-NETWORK-2",
        "severity": "INFO",
        "type": "Cookie sans préfixe __Host- ou __Secure-",
        "description": (
            "Les préfixes __Host- et __Secure- garantissent Secure + "
            "absence de Domain et Path=/ — protection supplémentaire."
        ),
        "test": lambda c: (
            "__host-" not in c.lower() and "__secure-" not in c.lower()
            and _is_session_cookie(c)
        ),
        "fix": (
            "Renommer le cookie en __Host-session=... pour forcer "
            "Secure, Path=/ et l'absence de Domain."
        ),
    },
]


# ---------------------------------------------------------------------------
# Helpers
# ---------------------------------------------------------------------------

def _is_session_cookie(cookie_header: str) -> bool:
    """Heuristique : le cookie contient-il un token de session ?"""
    return bool(re.search(
        r"(?:jsessionid|session|auth|token|jwt|sid)\s*=",
        cookie_header,
        re.IGNORECASE,
    ))


def _extract_cookie_name(cookie_header: str) -> str:
    """Extrait le nom du premier cookie du header."""
    m = re.match(r"\s*([^=;,\s]+)\s*=", cookie_header)
    return m.group(1) if m else "unknown"


# ---------------------------------------------------------------------------
# Analyse d'un header Set-Cookie
# ---------------------------------------------------------------------------

def scan_cookie(cookie_header: str, source: str = "HTTP response") -> list:
    """
    Analyse un header Set-Cookie et retourne la liste des findings OWASP.

    Args:
        cookie_header : valeur brute du header Set-Cookie.
        source        : description de la source (URL, fichier, etc.).

    Returns:
        Liste de dicts { id, masvs, severity, type, detail, description, fix }.
    """
    findings = []
    name = _extract_cookie_name(cookie_header)

    for check in COOKIE_CHECKS:
        try:
            if check["test"](cookie_header):
                findings.append({
                    "id":          check["id"],
                    "masvs":       check["masvs"],
                    "severity":    check["severity"],
                    "type":        check["type"],
                    "detail":      f"Cookie '{name}' — source : {source}",
                    "description": check["description"],
                    "fix":         check["fix"],
                    "raw_cookie":  cookie_header[:120],
                })
        except Exception:
            pass

    return findings


def scan_cookies(cookies: list[str], source: str = "HTTP response") -> list:
    """Analyse une liste de headers Set-Cookie."""
    all_findings = []
    seen = set()
    for cookie in cookies:
        for f in scan_cookie(cookie, source):
            key = (f["id"], _extract_cookie_name(cookie))
            if key not in seen:
                seen.add(key)
                all_findings.append(f)
    return all_findings


# ---------------------------------------------------------------------------
# Analyse depuis un fichier de trafic JSON (produit par addon.py / mitmproxy)
# ---------------------------------------------------------------------------

def scan_traffic_file(traffic_file: str) -> dict:
    """
    Lit le fichier de trafic JSON produit par addon.py et analyse
    tous les headers Set-Cookie capturés.

    Returns:
        {
          "findings"     : [...],
          "cookies_found": int,
          "score"        : int (0-10),
        }
    """
    try:
        with open(traffic_file, "r", encoding="utf-8") as f:
            traffic = json.load(f)
    except FileNotFoundError:
        return {
            "findings": [{
                "id": "NO_TRAFFIC_FILE",
                "severity": "INFO",
                "type": "Fichier de trafic introuvable",
                "detail": f"{traffic_file} non trouvé — lancez d'abord l'analyse dynamique.",
                "description": "Aucun trafic intercepté.",
            }],
            "cookies_found": 0,
            "score": 10,
        }
    except json.JSONDecodeError as e:
        return {
            "findings": [{
                "id": "TRAFFIC_PARSE_ERROR",
                "severity": "INFO",
                "type": "Fichier de trafic corrompu",
                "detail": str(e),
                "description": "Impossible de parser le fichier JSON.",
            }],
            "cookies_found": 0,
            "score": 10,
        }

    all_findings = []
    cookies_found = 0

    for entry in traffic:
        set_cookie = entry.get("set_cookie", "")
        if not set_cookie:
            continue
        url = entry.get("url", "unknown URL")
        cookies_found += 1
        for f in scan_cookie(set_cookie, source=url):
            all_findings.append(f)

    # Score : 10 points, -1 CRITIQUE, -0.5 ELEVE, -0.25 MOYEN
    _penalty = {"CRITIQUE": 1, "ELEVE": 0.5, "MOYEN": 0.25}
    score = 10.0
    for f in all_findings:
        score -= _penalty.get(f["severity"], 0)
    score = max(0.0, round(score, 1))

    return {
        "findings":      all_findings,
        "cookies_found": cookies_found,
        "score":         score,
    }


# ---------------------------------------------------------------------------
# Point d'entrée standalone (test rapide)
# ---------------------------------------------------------------------------

if __name__ == "__main__":
    import sys

    # Test depuis un fichier de trafic ou depuis un cookie en ligne de commande
    if len(sys.argv) > 1 and sys.argv[1].endswith(".json"):
        result = scan_traffic_file(sys.argv[1])
    else:
        # Exemples de cookies insécurisés pour démonstration
        test_cookies = [
            "JSESSIONID=abc123; Path=/",                                    # manque HttpOnly, Secure, SameSite
            "session=xyz789; HttpOnly; Secure; SameSite=None",             # SameSite=None OK car Secure présent
            "auth_token=eyJhbG...; Domain=.insecurebank.local; Path=/",    # Domain trop large, pas de préfixes
        ]
        result = {
            "findings":      scan_cookies(test_cookies, "CLI demo"),
            "cookies_found": len(test_cookies),
            "score":         10,
        }

    print(f"\n{'='*60}")
    print("  Cookie Security Scanner — AuthGuard")
    print(f"{'='*60}")
    print(f"  Cookies analysés : {result['cookies_found']}")
    print(f"  Findings         : {len(result['findings'])}")
    print(f"  Score MASVS      : {result.get('score', '?')}/10")
    print()

    _sev_order = {"CRITIQUE": 0, "ELEVE": 1, "MOYEN": 2, "INFO": 3}
    findings = sorted(result["findings"], key=lambda f: _sev_order.get(f["severity"], 9))

    for f in findings:
        sev_icon = {"CRITIQUE": "🔴", "ELEVE": "🟠", "MOYEN": "🟡", "INFO": "ℹ️"}.get(f["severity"], "  ")
        print(f"  {sev_icon} [{f['severity']:8s}] {f['type']}")
        print(f"           MASVS  : {f.get('masvs', 'N/A')}")
        print(f"           Détail : {f.get('detail', '')}")
        print(f"           Fix    : {f.get('fix', '')}")
        print()
