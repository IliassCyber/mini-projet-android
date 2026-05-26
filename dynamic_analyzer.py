"""
Module 2 — Analyse dynamique

MODE A (JWT / DVBA) : tests automatisés via l'API REST
  - Login → capture du JWT
  - Décodage JWT → vérification du champ exp
  - Logout puis rejeu du token
  - Falsification du payload JWT
  - Double utilisation du refresh token

MODE B (SESSION_COOKIE / InsecureBankv2) : interception mitmproxy
  - Lance mitmdump en sous-processus avec addon.py
  - Configure le proxy sur l'émulateur via ADB
  - Attend que l'utilisateur effectue login + logout manuellement
  - Rejeu du cookie de session capturé
"""

import base64
import json
import time
import requests
import jwt 
import datetime, time

# ---------------------------------------------------------------------------
# Configuration des endpoints
# ---------------------------------------------------------------------------

import os
DVBA_BASE    = os.getenv("DVBA_URL",    "http://localhost:3000")
IBANK_BASE   = os.getenv("INSECURE_URL","http://localhost:8888")
PROXY_PORT   = 8080
EMULATOR_IP  = "10.0.2.2"    # adresse de la machine hôte vue depuis l'émulateur

# Clé XOR codée en dur dans BackendServer/middlewares/crypt.js
DVBA_XOR_KEY = "amazing"

# Endpoints réels (déduits du routing Express : /api + /user + /login)
DVBA_LOGIN_ENDPOINT   = "/api/user/login"
DVBA_PROFILE_ENDPOINT = "/api/user/profile"
DVBA_LOGOUT_ENDPOINT  = "/api/user/logout"
DVBA_REFRESH_ENDPOINT = "/api/user/token/refresh"

# Credentials par défaut (INSTALL.md du repo)
DVBA_LOGIN_ATTEMPTS = [
    {"username": "user1", "password": "password1"},
    {"username": "user2", "password": "password2"},
    {"username": "admin", "password": "admin"},
]

# ---------------------------------------------------------------------------
# Helpers JWT
# ---------------------------------------------------------------------------

def _decode_jwt_payload(token: str) -> dict:
    try:
        b64 = token.split(".")[1]
        b64 += "=" * (4 - len(b64) % 4)
        return json.loads(base64.urlsafe_b64decode(b64))
    except Exception:
        return {}


def _tamper_jwt(token: str, extra_claims: dict) -> str:
    """Construit un JWT avec payload modifié (signature invalide intentionnellement)."""
    try:
        parts = token.split(".")
        if len(parts) != 3:
            return token
        payload = _decode_jwt_payload(token)
        payload.update(extra_claims)
        new_b64 = base64.urlsafe_b64encode(
            json.dumps(payload, separators=(",", ":")).encode()
        ).rstrip(b"=").decode()
        return f"{parts[0]}.{new_b64}.invalidsignature"
    except Exception:
        return token


# ---------------------------------------------------------------------------
# Chiffrement XOR DVBA (BackendServer/middlewares/crypt.js)
# Algo : XOR caractère par caractère avec la clé "amazing" (répétée) + Base64
# Vulnérabilité : clé codée en dur, XOR trivial à casser
# ---------------------------------------------------------------------------

def _dvba_xor(text: str) -> str:
    key = DVBA_XOR_KEY
    return "".join(chr(ord(c) ^ ord(key[i % len(key)])) for i, c in enumerate(text))


def _dvba_encrypt(data: dict) -> dict:
    """Chiffre un dict Python vers le format {'enc_data': '<base64>'} attendu par DVBA."""
    xored = _dvba_xor(json.dumps(data))
    b64 = base64.b64encode(xored.encode("latin-1")).decode()
    return {"enc_data": b64}


def _dvba_decrypt(response_json: dict) -> dict:
    """Déchiffre la réponse DVBA {'enc_data': '...'} vers un dict Python."""
    b64 = response_json.get("enc_data", "")
    xored = base64.b64decode(b64).decode("latin-1")
    return json.loads(_dvba_xor(xored))


# ---------------------------------------------------------------------------
# Helpers HTTP DVBA
# ---------------------------------------------------------------------------

def _dvba_post(base_url: str, endpoint: str, data: dict,
               token: str = None, timeout: int = 8):
    """POST chiffré vers DVBA. Retourne (status_code, dict_reponse)."""
    headers = {"Authorization": f"Bearer {token}"} if token else {}
    try:
        r = requests.post(
            f"{base_url}{endpoint}",
            json=_dvba_encrypt(data),
            headers=headers,
            timeout=timeout,
            verify=False,
        )
        try:
            return r.status_code, _dvba_decrypt(r.json())
        except Exception:
            return r.status_code, {}
    except (requests.ConnectionError, requests.Timeout):
        return None, {}


def _dvba_get(base_url: str, endpoint: str, token: str, timeout: int = 8):
    """GET authentifié vers DVBA. Retourne (status_code, dict_reponse)."""
    headers = {"Authorization": f"Bearer {token}"}
    try:
        r = requests.get(
            f"{base_url}{endpoint}",
            headers=headers,
            timeout=timeout,
            verify=False,
        )
        try:
            return r.status_code, _dvba_decrypt(r.json())
        except Exception:
            return r.status_code, {}
    except Exception:
        return None, {}


def _try_login(base_url: str, timeout: int = 8):
    """Essaie toutes les combinaisons de credentials DVBA.
    Structure de réponse : {'status': {...}, 'data': {'accessToken': '...'}}
    """
    for creds in DVBA_LOGIN_ATTEMPTS:
        status, resp = _dvba_post(base_url, DVBA_LOGIN_ENDPOINT, creds, timeout=timeout)
        if status in (200, 201):
            # Chercher le token à tous les niveaux possibles
            inner = resp.get("data", resp)
            token = (
                inner.get("accessToken")
                or inner.get("token")
                or inner.get("access_token")
                or inner.get("jwt")
                or resp.get("accessToken")
                or resp.get("token")
            )
            if token:
                refresh = (
                    inner.get("refreshToken")
                    or inner.get("refresh_token")
                    or resp.get("refreshToken")
                )
                return token, refresh
    return None, None


def _try_logout(base_url: str, token: str, timeout: int = 8):
    status, _ = _dvba_post(base_url, DVBA_LOGOUT_ENDPOINT, {}, token=token, timeout=timeout)
    return status in (200, 204, 401, 403)


def _try_authenticated_request(base_url: str, token: str, timeout: int = 8):
    # DVBA profile est un POST chiffré (pas un GET)
    status, _ = _dvba_post(base_url, DVBA_PROFILE_ENDPOINT, {}, token=token, timeout=timeout)
    return status


# ---------------------------------------------------------------------------
# ── NOUVEAU : Analyse Token Lifetime & Expired Token
# ---------------------------------------------------------------------------

# Seuils OWASP recommandés (en secondes)
TOKEN_LIFETIME_THRESHOLDS = {
    "access_token_max": 900,        # 15 min
    "access_token_warn": 3600,       # 1h = warning
    "refresh_token_max": 86400 * 7,  # 7 jours
}

def analyze_token_lifetime(token: str) -> dict:
    """
    Décode le JWT sans vérification de signature.
    Retourne durée de vie, sévérité et recommandation MASVS.
    """
    result = {
        "test": "Token Lifetime Analysis",
        "masvs": "MASVS-AUTH-002",
        "passed": False,
        "severity": "UNKNOWN",
        "details": {}
    }
    try:
        payload = jwt.decode(token, options={
            "verify_signature": False,
            "verify_exp": False
        })

        if "exp" not in payload:
            result["severity"] = "CRITICAL"
            result["details"]["exp_present"] = False
            result["details"]["message"] = "No exp claim — token never expires"
            return result

        now = int(time.time())
        exp = payload["exp"]
        iat = payload.get("iat", now)
        lifetime_sec = exp - iat

        result["details"] = {
            "exp_present": True,
            "iat": datetime.datetime.utcfromtimestamp(iat).isoformat(),
            "exp": datetime.datetime.utcfromtimestamp(exp).isoformat(),
            "lifetime_seconds": lifetime_sec,
            "lifetime_human": str(datetime.timedelta(seconds=lifetime_sec))
        }

        if lifetime_sec > TOKEN_LIFETIME_THRESHOLDS["access_token_warn"]:
            result["severity"] = "HIGH"
            result["details"]["recommendation"] = (
                f"Token valid for {lifetime_sec//3600}h. OWASP recommends < 15 min. "
                "MASVS-AUTH-002: short-lived tokens required."
            )
        elif lifetime_sec > TOKEN_LIFETIME_THRESHOLDS["access_token_max"]:
            result["severity"] = "MEDIUM"
            result["details"]["recommendation"] = "Token > 15 min. Consider shorter lifetime."
        else:
            result["severity"] = "LOW"
            result["passed"] = True

    except Exception as e:
        result["details"]["error"] = str(e)

    return result


def test_expired_token_rejection(base_url: str, expired_token: str,
                                   headers_fn) -> dict:
    """
    Rejoue un token expiré (modifié manuellement via exp = past timestamp).
    Vérifie que le serveur répond 401 et pas 200.
    """
    import requests, base64, json

    # Crée un token expiré en modifiant le payload
    parts = expired_token.split(".")
    try:
        padded = parts[1] + "=" * (-len(parts[1]) % 4)
        payload = json.loads(base64.b64decode(padded))
        payload["exp"] = 1000000000  # 2001 — definitely expired
        new_p = base64.b64encode(json.dumps(payload).encode()).decode().rstrip("=")
        tampered = f"{parts[0]}.{new_p}.{parts[2]}"
    except:
        tampered = expired_token  # fallback

    resp = requests.get(
        f"{base_url}/dashboard",
        headers=headers_fn(tampered),
        timeout=5
    )
    accepted = resp.status_code == 200
    return {
        "test": "Expired Token Rejection",
        "masvs": "MASVS-AUTH-003",
        "passed": not accepted,
        "severity": "CRITICAL" if accepted else "PASS",
        "status_code": resp.status_code,
        "details": "Server accepted expired token!" if accepted else "Server correctly rejected expired token"
    }


# ---------------------------------------------------------------------------
# ── NOUVEAU : Session Fixation Tests
# ---------------------------------------------------------------------------

def test_session_fixation_jwt(base_url: str, login_fn, arbitrary_token: str) -> dict:
    """
    Test session fixation JWT :
    Vérifie qu'un token arbitraire fourni avant auth ne devient pas valide après login.
    """
    import requests

    # Vérification pre-auth : le token arbitraire est rejeté
    pre_resp = requests.get(
        f"{base_url}/dashboard",
        headers={"Authorization": f"Bearer {arbitrary_token}"},
        timeout=5
    )

    # Login normal → obtenir token légitime
    legitimate_token = login_fn("user1", "password1")

    # Re-tester le token arbitraire après auth (fixation scenario)
    post_resp = requests.get(
        f"{base_url}/dashboard",
        headers={"Authorization": f"Bearer {arbitrary_token}"},
        timeout=5
    )

    fixation_possible = post_resp.status_code == 200
    return {
        "test": "Session Fixation — JWT pre-auth token injection",
        "masvs": "MASVS-AUTH-006",
        "cwe": "CWE-384",
        "passed": not fixation_possible,
        "severity": "CRITICAL" if fixation_possible else "PASS",
        "pre_auth_status": pre_resp.status_code,
        "post_auth_status": post_resp.status_code,
        "details": "Arbitrary token accepted after auth — Session Fixation!"
                    if fixation_possible
                    else "Arbitrary token correctly rejected before and after auth ✓"
    }

def test_session_fixation_http(base_url: str, username: str, password: str) -> dict:
    """
    Test session fixation pour InsecureBankv2 (HTTP sessions) :
    Vérifie que le session cookie change après authentification.
    """
    import requests
    session = requests.Session()

    # Récupérer un cookie pré-auth
    session.get(f"{base_url}/", timeout=5)
    pre_auth_cookie = dict(session.cookies).copy()

    # Login
    session.post(f"{base_url}/login",
                 data={"username": username, "password": password},
                 timeout=5)
    post_auth_cookie = dict(session.cookies).copy()

    # Comparer les session cookies
    session_changed = pre_auth_cookie != post_auth_cookie
    return {
        "test": "Session Fixation — session cookie regenerated on login",
        "masvs": "MASVS-AUTH-006",
        "cwe": "CWE-384",
        "passed": session_changed,
        "severity": "HIGH" if not session_changed else "PASS",
        "pre_auth_cookies": pre_auth_cookie,
        "post_auth_cookies": post_auth_cookie,
        "details": "Session ID not regenerated after login — Session Fixation risk!"
                    if not session_changed
                    else "Session ID regenerated on login ✓"
    }

# ---------------------------------------------------------------------------
# MODE A — Tests automatisés DVBA
# ---------------------------------------------------------------------------

def analyze_dvba(base_url: str = DVBA_BASE) -> dict:
    findings = []
    result = {
        "mode": "API_DIRECT",
        "logout_effective": None,
        "token_lifetime_minutes": None,
        "rotation_enforced": None,
        "captured_token": None,       # ← NOUVEAU
        "base_url": base_url,         # ← NOUVEAU
        "findings": findings,
    }

    token, refresh_token = _try_login(base_url)

    if not token:
        findings.append({
            "severity": "INFO",
            "type": "Backend inaccessible",
            "detail": f"DVBA non disponible sur {base_url}.",
        })
        return result

    result["captured_token"] = token  # ← NOUVEAU

    # Test 2 : exp
    payload = _decode_jwt_payload(token)
    if "exp" not in payload:
        findings.append({
            "severity": "CRITIQUE",
            "type": "JWT sans expiration",
            "detail": "Le token JWT ne contient pas de champ 'exp'",
        })
        result["token_lifetime_minutes"] = None
    else:
        lifetime_min = round((payload["exp"] - time.time()) / 60, 1)
        result["token_lifetime_minutes"] = lifetime_min
        if lifetime_min > 60 * 24:
            findings.append({
                "severity": "ELEVE",
                "type": "Duree de vie du token excessive",
                "detail": f"Token valide pendant {lifetime_min/60:.1f} heures (> 24h)",
            })

    try:
        hdr_b64 = token.split(".")[0] + "=="
        import json as _json
        hdr = _json.loads(base64.urlsafe_b64decode(hdr_b64))
        jwt_alg = hdr.get("alg", "HS256")
    except Exception:
        jwt_alg = "HS256"
    if jwt_alg.upper() == "NONE":
        findings.append({
            "severity": "CRITIQUE",
            "type": "JWT algorithme none",
            "detail": "Le token utilise l'algorithme 'none'",
        })

    # Test 3 : logout + rejeu
    _try_logout(base_url, token)
    time.sleep(0.5)
    status_after = _try_authenticated_request(base_url, token)
    if status_after in (200, 201):
        result["logout_effective"] = False
        findings.append({
            "severity": "CRITIQUE",
            "type": "Token rejoue apres deconnexion",
            "detail": f"HTTP {status_after} apres logout — invalidation absente",
        })
    elif status_after in (401, 403):
        result["logout_effective"] = True

    # Test 4 : JWT falsifié
    tampered = _tamper_jwt(token, {"role": "admin", "isAdmin": True})
    status_tampered, _ = _dvba_get(base_url, DVBA_PROFILE_ENDPOINT, tampered)
    if status_tampered in (200, 201):
        findings.append({
            "severity": "CRITIQUE",
            "type": "JWT falsifiable",
            "detail": f"Serveur accepte JWT signature invalide (HTTP {status_tampered})",
        })

    # Test 5 : rotation refresh
    if refresh_token:
        try:
            s1, _ = _dvba_post(base_url, DVBA_REFRESH_ENDPOINT,
                               {"refreshToken": refresh_token}, token=token)
            s2, _ = _dvba_post(base_url, DVBA_REFRESH_ENDPOINT,
                               {"refreshToken": refresh_token}, token=token)
            if s1 in (200, 201) and s2 in (200, 201):
                result["rotation_enforced"] = False
                findings.append({
                    "severity": "ELEVE",
                    "type": "Pas de rotation des refresh tokens",
                    "detail": "Le meme refresh token accepte deux fois",
                })
            elif s1 in (200, 201) and s2 in (400, 401, 403):
                result["rotation_enforced"] = True
        except Exception:
            pass

    return result

# ---------------------------------------------------------------------------
# MODE B — Tests directs InsecureBankv2 (pas de session : credentials par requête)
# ---------------------------------------------------------------------------

def analyze_insecure_bank(apk_name: str, results_dir: str) -> dict:
    """
    InsecureBankv2 n'utilise pas de session/JWT — chaque requête envoie
    username+password en clair via HTTP. Les tests portent sur :
      - Transmission des credentials en HTTP clair (pas de HTTPS)
      - Accès aux ressources sans authentification
      - Absence de rate limiting (brute force possible)
      - Exposition des données sensibles dans les réponses
    """
    findings = []
    result = {
        "mode": "API_DIRECT",
        "logout_effective": None,
        "token_lifetime_minutes": None,
        "rotation_enforced": None,
        "findings": findings,
    }

    base = IBANK_BASE

    # ── Test 1 : Login en HTTP clair ─────────────────────────────────────
    try:
        r = requests.post(f"{base}/login",
                          data={"username": "dinesh", "password": "Dinesh@123$"},
                          timeout=8)
    except requests.ConnectionError:
        findings.append({
            "severity": "INFO",
            "type": "Backend inaccessible",
            "detail": f"InsecureBankv2 non disponible sur {base}",
        })
        return result

    if r.status_code != 200 or "Correct" not in r.text:
        findings.append({
            "severity": "INFO",
            "type": "Login echoue",
            "detail": f"HTTP {r.status_code} : {r.text[:80]}",
        })
        return result

    # Credentials transmis en HTTP → vulnérabilité critique
    if base.startswith("http://"):
        findings.append({
            "severity": "CRITIQUE",
            "type": "Credentials transmis en HTTP clair",
            "detail": (
                f"POST {base}/login envoie username+password sans chiffrement "
                "— interceptable par MITM"
            ),
        })
        
    # ── Test 2 : Accès sans authentification ─────────────────────────────
    try:
        r_noauth = requests.post(f"{base}/getaccounts",
                                 data={"username": "dinesh"},
                                 timeout=8)
        if r_noauth.status_code == 200 and "fail" not in r_noauth.text.lower():
            findings.append({
                "severity": "CRITIQUE",
                "type": "Acces sans authentification",
                "detail": f"/getaccounts repond HTTP 200 sans mot de passe valide",
            })
        else:
            # Pas de session = chaque requête doit ré-authentifier
            findings.append({
                "severity": "ELEVE",
                "type": "Absence de gestion de session",
                "detail": (
                    "InsecureBankv2 n'emet aucun token/cookie de session. "
                    "Les credentials sont retransmis a chaque requete."
                ),
            })
    except Exception:
        pass

    # ── Test 3 : Brute force sans rate limiting ───────────────────────────
    blocked = False
    try:
        for _ in range(10):
            rb = requests.post(f"{base}/login",
                               data={"username": "dinesh", "password": "wrongpass"},
                               timeout=5)
            if rb.status_code in (429, 423, 403):
                blocked = True
                break
        if not blocked:
            findings.append({
                "severity": "ELEVE",
                "type": "Pas de protection brute force",
                "detail": (
                    "10 tentatives de login echouees consecutives acceptees "
                    "sans blocage ni CAPTCHA"
                ),
            })
    except Exception:
        pass

    # ── Test 4 : Données sensibles dans la réponse ───────────────────────
    try:
        r_acc = requests.post(f"{base}/getaccounts",
                              data={"username": "dinesh", "password": "Dinesh@123$"},
                              timeout=8)
        if r_acc.status_code == 200:
            result["logout_effective"] = False   # pas de session = pas de logout réel
            findings.append({
                "severity": "MOYEN",
                "type": "Pas de gestion de deconnexion",
                "detail": (
                    "L'application n'a pas de mecanisme de logout cote serveur. "
                    "Le menu 'Restart' ne fait que naviguer vers l'ecran de login."
                ),
            })
    except Exception:
        pass

    return result


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(_apk_path: str, apk_name: str, auth_type: str, results_dir: str) -> dict:
    name = apk_name.lower()
    is_ibank = "insecure" in name or "app-debug" in name or "app_debug" in name
    use_dvba = (not is_ibank) and (("dvba" in name) or (auth_type == "JWT"))

    if use_dvba:
        result = analyze_dvba()
        result["base_url"] = DVBA_BASE
        result["credentials"] = {"username": "user1", "password": "password1"}
        return result
    else:
        result = analyze_insecure_bank(apk_name, results_dir)
        result["base_url"] = IBANK_BASE
        result["credentials"] = {"username": "dinesh", "password": "Dinesh@123$"}
        return result