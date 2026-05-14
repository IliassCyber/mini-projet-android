"""
Addon mitmproxy — utilisé en interne par dynamic_analyzer.py (Mode B).
Lance avec : mitmdump -p 8080 -s addon.py --set traffic_file=... --set token_file=...

Intercepte le trafic HTTP/HTTPS de l'émulateur Android :
  - Logue chaque requête (méthode, URL, headers d'auth, cookies)
  - Extrait le token (JWT ou cookie de session) de la réponse de login
  - Sauvegarde le trafic en JSON
"""

from mitmproxy import ctx, http
import json
import os
import re
from datetime import datetime, timezone


class TrafficLogger:
    def __init__(self):
        self._log: list = []

    # ── Enregistrement des options personnalisées ──────────────────────────
    def load(self, loader):
        loader.add_option(
            name="traffic_file",
            typespec=str,
            default="results/traffic.json",
            help="Chemin du fichier JSON de trafic",
        )
        loader.add_option(
            name="token_file",
            typespec=str,
            default="captured_token.txt",
            help="Fichier où écrire le token capturé",
        )

    # ── Hook : chaque requête ──────────────────────────────────────────────
    def request(self, flow: http.HTTPFlow):
        entry = {
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "direction": "REQUEST",
            "method": flow.request.method,
            "url": flow.request.pretty_url,
            "authorization": flow.request.headers.get("Authorization", ""),
            "cookies": flow.request.headers.get("Cookie", ""),
        }
        self._log.append(entry)
        self._save_traffic()

    # ── Hook : chaque réponse ──────────────────────────────────────────────
    def response(self, flow: http.HTTPFlow):
        url = flow.request.pretty_url

        # Journaliser la réponse
        entry = {
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "direction": "RESPONSE",
            "url": url,
            "status_code": flow.response.status_code,
            "set_cookie": flow.response.headers.get("Set-Cookie", ""),
        }
        self._log.append(entry)
        self._save_traffic()

        # Chercher un token uniquement sur les endpoints de login
        if not re.search(r"/login|/signin|/auth|/session", url, re.IGNORECASE):
            return

        # 1. JWT dans le corps de la réponse
        try:
            body = flow.response.text
        except Exception:
            body = ""

        jwt_match = re.search(
            r"eyJ[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]*",
            body,
        )
        if jwt_match:
            self._write_token(jwt_match.group(0))
            ctx.log.info(f"[addon] JWT capture depuis la reponse de {url}")
            return

        # 2. Cookie de session dans Set-Cookie
        set_cookie = flow.response.headers.get("Set-Cookie", "")
        cookie_match = re.search(
            r"(JSESSIONID=[^;]+|session=[^;]+|auth=[^;]+)",
            set_cookie,
            re.IGNORECASE,
        )
        if cookie_match:
            self._write_token(cookie_match.group(0))
            ctx.log.info(f"[addon] Cookie de session capture depuis {url}")

    # ── Helpers ───────────────────────────────────────────────────────────
    def _write_token(self, token: str):
        token_file = ctx.options.token_file
        try:
            os.makedirs(os.path.dirname(token_file) or ".", exist_ok=True)
        except Exception:
            pass
        with open(token_file, "w", encoding="utf-8") as f:
            f.write(token.strip())

    def _save_traffic(self):
        traffic_file = ctx.options.traffic_file
        try:
            os.makedirs(os.path.dirname(traffic_file) or ".", exist_ok=True)
            with open(traffic_file, "w", encoding="utf-8") as f:
                json.dump(self._log, f, indent=2, ensure_ascii=False)
        except Exception:
            pass


addons = [TrafficLogger()]
