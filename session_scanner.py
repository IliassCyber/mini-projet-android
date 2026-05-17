"""
Module — Session Scanner
Teste les vulnérabilités de gestion de session selon l'OWASP Session
Management Cheat Sheet (sections : Entropy, Fixation, Timeout, Regeneration).

Conformément au guide AuthGuard (P2 — Refresh Session) :
  - Entropy du Session ID (longueur, entropie estimée)
  - Session Fixation (le SID change-t-il après login ?)
  - Timeout d'inactivité (le serveur invalide-t-il les sessions inactives ?)
  - Régénération du SID (nouveau SID à chaque nouveau login ?)
  - Invalidation côté serveur au logout

Mappe sur : MASVS-AUTH-1, MASVS-AUTH-2, MASVS-AUTH-3, Chap.7/14 du cours.
"""

import re
import math
import time
import requests

# ---------------------------------------------------------------------------
# Configuration
# ---------------------------------------------------------------------------

IBANK_BASE  = "http://localhost:8888"
DEFAULT_CREDS = {"username": "dinesh", "password": "Dinesh@123$"}
SESSION_TIMEOUT_MINUTES = 30  # OWASP recommande ≤ 30 min d'inactivité


# ---------------------------------------------------------------------------
# Helpers
# ---------------------------------------------------------------------------

def _shannon_entropy(s: str) -> float:
    """Entropie de Shannon en bits pour une chaîne."""
    if not s:
        return 0.0
    freq = {}
    for c in s:
        freq[c] = freq.get(c, 0) + 1
    n = len(s)
    return -sum((f / n) * math.log2(f / n) for f in freq.values())


def _extract_session_id(response: requests.Response) -> str | None:
    """Extrait le Session ID depuis Set-Cookie ou le corps de la réponse."""
    set_cookie = response.headers.get("Set-Cookie", "")
    if set_cookie:
        m = re.search(r"(?:JSESSIONID|session|auth|sid)=([^;,\s]+)", set_cookie, re.I)
        if m:
            return m.group(1)
    # Chercher dans le corps JSON
    try:
        body = response.json()
        for key in ("session_id", "sid", "session", "auth_token"):
            if key in body:
                return str(body[key])
    except Exception:
        pass
    return None


def _login(base: str, creds: dict, timeout: int = 8) -> tuple:
    """
    Effectue un login et retourne (response, session_id).
    Session ID extrait depuis Set-Cookie ou corps JSON.
    """
    try:
        r = requests.post(f"{base}/login", data=creds, timeout=timeout, allow_redirects=True)
        sid = _extract_session_id(r)
        return r, sid
    except requests.ConnectionError:
        return None, None


# ---------------------------------------------------------------------------
# Tests de session
# ---------------------------------------------------------------------------

def test_session_entropy(sid: str) -> list:
    """
    OWASP : le Session ID doit avoir une entropie minimale de 64 bits.
    Longueur recommandée : ≥ 128 bits (16 octets hex = 32 chars).
    """
    findings = []
    if not sid:
        findings.append({
            "id":          "SESSION_NO_ID",
            "masvs":       "MASVS-AUTH-1",
            "severity":    "CRITIQUE",
            "type":        "Aucun Session ID détecté",
            "detail":      "Le serveur n'émet pas de cookie de session identifiable.",
            "description": "L'application ne gère pas de sessions côté serveur.",
        })
        return findings

    # Entropie Shannon (approximation)
    ent = _shannon_entropy(sid)
    ent_bits = ent * len(sid)

    if len(sid) < 16:
        findings.append({
            "id":          "SESSION_ID_TOO_SHORT",
            "masvs":       "MASVS-AUTH-1",
            "severity":    "CRITIQUE",
            "type":        "Session ID trop court",
            "detail":      f"Longueur = {len(sid)} chars (OWASP : ≥ 32 chars / 128 bits)",
            "description": "Un SID court est vulnérable aux attaques brute-force.",
            "fix":         "Générer des SID de ≥ 128 bits avec un CSPRNG.",
        })
    elif len(sid) < 32:
        findings.append({
            "id":          "SESSION_ID_WEAK",
            "masvs":       "MASVS-AUTH-1",
            "severity":    "ELEVE",
            "type":        "Session ID de longueur insuffisante",
            "detail":      f"Longueur = {len(sid)} chars (OWASP recommande ≥ 32)",
            "description": "La longueur du SID est inférieure à la recommandation OWASP.",
            "fix":         "Augmenter la longueur à ≥ 32 caractères aléatoires.",
        })

    if ent_bits < 64:
        findings.append({
            "id":          "SESSION_ID_LOW_ENTROPY",
            "masvs":       "MASVS-AUTH-1",
            "severity":    "ELEVE",
            "type":        "Entropie Session ID insuffisante",
            "detail":      f"Entropie estimée : {ent_bits:.1f} bits (OWASP : ≥ 64 bits)",
            "description": "L'entropie basse du SID le rend vulnérable à la prédiction.",
            "fix":         "Utiliser os.urandom(32) ou SecureRandom (Java).",
        })
    return findings


def test_session_fixation(base: str, creds: dict, timeout: int = 8) -> list:
    """
    OWASP Session Fixation : le SID doit changer après authentification.
    Test : noter le SID avant login → login → comparer le SID après.
    """
    findings = []
    try:
        # Obtenir un SID avant login (page publique ou endpoint unauthenticated)
        r_pre = requests.get(f"{base}/", timeout=timeout)
        sid_before = _extract_session_id(r_pre)

        r_post, sid_after = _login(base, creds, timeout)
        if r_post is None:
            return findings  # backend inaccessible

        if sid_before and sid_after and sid_before == sid_after:
            findings.append({
                "id":          "SESSION_FIXATION",
                "masvs":       "MASVS-AUTH-3",
                "severity":    "CRITIQUE",
                "type":        "Risque de Session Fixation",
                "detail":      f"SID identique avant/après login : ...{sid_before[-8:]}",
                "description": (
                    "Le serveur conserve le même Session ID avant et après "
                    "authentification — un attaquant peut fixer le SID à l'avance."
                ),
                "fix":         "Régénérer le SID à chaque login (invalidate() + getSession(true)).",
            })
        elif sid_before and sid_after and sid_before != sid_after:
            findings.append({
                "id":          "SESSION_REGEN_OK",
                "masvs":       "MASVS-AUTH-3",
                "severity":    "INFO",
                "type":        "Régénération SID correcte",
                "detail":      "Le SID change après authentification.",
                "description": "Bonne pratique : le SID est renouvelé après login.",
            })
    except Exception as e:
        findings.append({
            "id":      "SESSION_FIXATION_ERROR",
            "severity": "INFO",
            "type":    "Test fixation non concluant",
            "detail":  str(e)[:100],
        })
    return findings


def test_session_timeout(base: str, creds: dict, wait_seconds: int = 5) -> list:
    """
    OWASP : les sessions inactives doivent expirer (max 30 min recommandé).
    Note : en labo on ne peut pas attendre 30 min — on vérifie l'en-tête
    Max-Age/Expires du cookie ou on tente une requête après un délai court.
    """
    findings = []
    try:
        r, sid = _login(base, creds)
        if r is None or not sid:
            return findings

        set_cookie = r.headers.get("Set-Cookie", "")
        c_lower = set_cookie.lower()

        # Vérifier l'absence de Max-Age/Expires (session cookie sans limite)
        if "max-age" not in c_lower and "expires" not in c_lower:
            findings.append({
                "id":          "SESSION_NO_TIMEOUT",
                "masvs":       "MASVS-AUTH-2",
                "severity":    "ELEVE",
                "type":        "Session sans timeout côté client",
                "detail":      "Cookie de session sans Max-Age ni Expires",
                "description": (
                    "La session ne expire pas côté client à la fermeture "
                    "du navigateur si aucun timeout n'est configuré."
                ),
                "fix":         "Définir Max-Age ≤ 1800 (30 min) sur le cookie de session.",
            })
        else:
            # Vérifier la durée si Max-Age est défini
            m = re.search(r"max-age\s*=\s*(\d+)", c_lower)
            if m:
                age = int(m.group(1))
                if age > SESSION_TIMEOUT_MINUTES * 60:
                    findings.append({
                        "id":          "SESSION_TIMEOUT_EXCESSIVE",
                        "masvs":       "MASVS-AUTH-2",
                        "severity":    "MOYEN",
                        "type":        "Timeout de session excessif",
                        "detail":      f"Max-Age = {age}s ({age//60} min) — OWASP recommande ≤ 30 min",
                        "description": "Une longue durée de session augmente la fenêtre de vol de cookie.",
                        "fix":         f"Réduire Max-Age à ≤ {SESSION_TIMEOUT_MINUTES * 60} secondes.",
                    })

    except Exception as e:
        findings.append({
            "id":      "SESSION_TIMEOUT_ERROR",
            "severity": "INFO",
            "type":    "Test timeout non concluant",
            "detail":  str(e)[:100],
        })
    return findings


def test_logout_invalidation(base: str, creds: dict, timeout: int = 8) -> list:
    """
    OWASP Logout : le serveur doit invalider la session côté serveur.
    Test : login → noter SID → logout → rejouer SID → vérifier le rejet.
    """
    findings = []
    try:
        r_login, sid = _login(base, creds, timeout)
        if r_login is None or not sid:
            findings.append({
                "id":      "SESSION_LOGOUT_SKIPPED",
                "severity": "INFO",
                "type":    "Test logout ignoré",
                "detail":  "Login échoué — backend inaccessible ou credentials incorrects.",
            })
            return findings

        session_cookie = {"Cookie": f"session={sid}"}

        # Effectuer le logout
        try:
            requests.get(f"{base}/logout", headers=session_cookie, timeout=timeout)
        except Exception:
            pass  # certains backends ne redirigent pas proprement

        # Rejouer la requête authentifiée avec l'ancien SID
        try:
            r_replay = requests.post(
                f"{base}/getaccounts",
                data={"username": creds["username"], "password": creds["password"]},
                headers=session_cookie,
                timeout=timeout,
            )

            if r_replay.status_code == 200 and "fail" not in r_replay.text.lower():
                findings.append({
                    "id":          "SESSION_LOGOUT_INSUFFICIENT",
                    "masvs":       "MASVS-AUTH-2",
                    "severity":    "CRITIQUE",
                    "type":        "Session toujours valide après logout",
                    "detail":      f"HTTP {r_replay.status_code} sur /getaccounts après logout",
                    "description": (
                        "Le serveur n'invalide pas la session côté serveur au logout. "
                        "Un attaquant peut réutiliser un cookie capturé."
                    ),
                    "fix":         "Appeler session.invalidate() côté serveur au logout.",
                })
            elif r_replay.status_code in (401, 403, 302):
                findings.append({
                    "id":      "SESSION_LOGOUT_OK",
                    "masvs":   "MASVS-AUTH-2",
                    "severity": "INFO",
                    "type":    "Invalidation session correcte",
                    "detail":  f"HTTP {r_replay.status_code} après rejeu — session rejetée.",
                    "description": "La session est correctement invalidée côté serveur.",
                })
        except Exception:
            pass

    except Exception as e:
        findings.append({
            "id":      "SESSION_LOGOUT_ERROR",
            "severity": "INFO",
            "type":    "Test logout non concluant",
            "detail":  str(e)[:100],
        })
    return findings


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(base_url: str = IBANK_BASE, creds: dict = None) -> dict:
    """
    Exécute tous les tests de session sur un backend cible.

    Returns:
        { findings, mode, session_id_detected }
    """
    if creds is None:
        creds = DEFAULT_CREDS

    all_findings = []

    # Test préliminaire : connexion possible ?
    r_test, sid = _login(base_url, creds)
    if r_test is None:
        return {
            "mode":                 "SESSION_SCANNER",
            "session_id_detected":  None,
            "findings": [{
                "id":      "SESSION_BACKEND_DOWN",
                "severity": "INFO",
                "type":    "Backend inaccessible",
                "detail":  f"{base_url} ne répond pas.",
                "description": "Démarrez le backend InsecureBankv2 avant l'analyse.",
            }],
        }

    # Entropy du SID
    all_findings += test_session_entropy(sid)

    # Session Fixation
    all_findings += test_session_fixation(base_url, creds)

    # Timeout
    all_findings += test_session_timeout(base_url, creds)

    # Logout Invalidation
    all_findings += test_logout_invalidation(base_url, creds)

    return {
        "mode":                "SESSION_SCANNER",
        "session_id_detected": sid,
        "findings":            all_findings,
    }


# ---------------------------------------------------------------------------
# Standalone
# ---------------------------------------------------------------------------

if __name__ == "__main__":
    import sys
    base = sys.argv[1] if len(sys.argv) > 1 else IBANK_BASE
    print(f"\n{'='*60}")
    print("  Session Scanner — AuthGuard")
    print(f"{'='*60}\n")
    result = analyze(base)
    print(f"  SID détecté : {result.get('session_id_detected', 'N/A')}\n")

    _sev_order = {"CRITIQUE": 0, "ELEVE": 1, "MOYEN": 2, "INFO": 3}
    findings = sorted(result["findings"], key=lambda f: _sev_order.get(f.get("severity", "INFO"), 9))
    for f in findings:
        icon = {"CRITIQUE": "🔴", "ELEVE": "🟠", "MOYEN": "🟡", "INFO": "ℹ️"}.get(f.get("severity"), "  ")
        print(f"  {icon} [{f.get('severity'):8s}] {f.get('type')}")
        print(f"           {f.get('detail','')}")
        if f.get("fix"):
            print(f"           Fix : {f['fix']}")
        print()
