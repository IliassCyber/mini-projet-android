"""
Module 3 — Moteur IA
Envoie les résultats d'analyse à Claude et structure
la réponse en checklist MASVS, critères d'acceptation et résumé exécutif.
"""

import os
import re
from dotenv import load_dotenv
import anthropic

load_dotenv()
_api_key = os.getenv("ANTHROPIC_API_KEY")
client = anthropic.Anthropic(api_key=_api_key) if _api_key else None

MODEL = "claude-haiku-4-5"
MAX_TOKENS = 3000

# ---------------------------------------------------------------------------
# Calcul des scores MASVS par domaine
# ---------------------------------------------------------------------------

_DOMAIN_MAP = {
    "JWT":              "AUTH",
    "SESSION":          "AUTH",
    "LOGOUT":           "AUTH",
    "ROTATION":         "AUTH",
    "TOKEN REJOUE":     "AUTH",
    "SANS EXPIRATION":  "AUTH",
    "HARDCODED_SECRET": "STORAGE",
    "SECRET CODE":      "STORAGE",
    "LOG_CREDENTIALS":  "STORAGE",
    "IDENTIFIANTS":     "STORAGE",
    "SHARED_PREFS":     "STORAGE",
    "SHAREDPREFERENCES":"STORAGE",
    "DONNEES SENSIBLES":"STORAGE",
    "NO_SSL":           "NETWORK",
    "HTTP_CLEARTEXT":   "NETWORK",
    "COMMUNICATION EN CLAIR": "NETWORK",
    "SSL":              "NETWORK",
    "WEAK_CRYPTO":      "CRYPTO",
    "WEAK_HASH":        "CRYPTO",
    "AES_ECB":          "CRYPTO",
}

_PENALTY = {"CRITIQUE": 3, "CRITICAL": 3, "ELEVE": 2, "HIGH": 2, "MOYEN": 1, "MEDIUM": 1}


def compute_domain_scores(static_findings: list, dynamic_findings: list) -> dict:
    scores = {"AUTH": 10, "STORAGE": 10, "NETWORK": 10, "CRYPTO": 10}

    all_findings = static_findings + dynamic_findings
    for f in all_findings:
        ftype = f.get("type", f.get("id", "")).upper()
        sev   = f.get("severity", "MOYEN").upper()
        penalty = _PENALTY.get(sev, 0)

        matched = False
        for prefix, domain in _DOMAIN_MAP.items():
            if prefix in ftype:
                scores[domain] = max(0, scores[domain] - penalty)
                matched = True
                break
        if not matched:
            scores["AUTH"] = max(0, scores["AUTH"] - (penalty // 2))

    return scores


# ---------------------------------------------------------------------------
# Construction du prompt unifié JWT/SESSION
# ---------------------------------------------------------------------------

def _build_prompt(auth_type: str, static_findings: list, dynamic: dict,
                  domain_scores: dict) -> str:

    findings_text = "\n".join(
        f"  - [{f.get('severity','?')}] {f.get('type','?')} : {f.get('detail','')}"
        f" (fichier : {f.get('file','N/A')}, ligne {f.get('line','?')})"
        for f in static_findings[:25]
    ) or "  Aucun finding statique detecte."

    dyn_lines = [
        f"  - Mode : {dynamic.get('mode', 'N/A')}",
        f"  - Deconnexion effective : {dynamic.get('logout_effective')}",
        f"  - Duree de vie du token : {dynamic.get('token_lifetime_minutes')} min",
        f"  - Rotation des tokens : {dynamic.get('rotation_enforced')}",
    ]
    for df in dynamic.get("findings", []):
        dyn_lines.append(
            f"  - [{df.get('severity','?')}] {df.get('type','?')} : {df.get('detail','')}"
        )
    dynamic_text = "\n".join(dyn_lines)

    scores_text = "\n".join(
        f"  - {domain} : {score}/10" for domain, score in domain_scores.items()
    )

    auth_hint = (
        "gestion de tokens JWT (emission, validation, expiration, rejeu, rotation)"
        if auth_type == "JWT"
        else "gestion de sessions par cookies (JSESSIONID, fixation, timeout, invalidation)"
    )

    return f"""Tu es un expert en securite des applications mobiles Android specialise dans l'OWASP MASVS v2.

## Contexte de l'audit
Application Android utilisant {auth_type} pour l'authentification ({auth_hint}).

## Resultats de l'analyse statique
{findings_text}

## Resultats de l'analyse dynamique
{dynamic_text}

## Scores MASVS calcules par domaine
{scores_text}

---

INSTRUCTIONS STRICTES : Reponds UNIQUEMENT avec les trois blocs XML ci-dessous, dans cet ordre exact.
N'ajoute aucun texte avant ou apres les balises XML.

<CHECKLIST_MASVS>
Genere une checklist de securite JWT adaptee aux vulnerabilites detectees ci-dessus.
Chaque ligne DOIT suivre ce format exact : - [ ] [MASVS-XXX-N] description du controle | Severite: CRITIQUE/ELEVE/MOYEN | CWE: NNN
Minimum 12 elements. Adapte les controles aux findings reels (JWT sans exp, token dans SharedPrefs, secrets en dur, logs, HTTP clair).
</CHECKLIST_MASVS>

<CRITERES_ACCEPTATION>
Genere des criteres d'acceptation de securite bases sur les tests echoues.
Chaque ligne DOIT commencer par : Le systeme DOIT ou Le systeme NE DOIT PAS
Minimum 8 criteres. Adapte aux vulnerabilites JWT detectees (pas d'exp, rejeu apres logout, stockage non chiffre).
</CRITERES_ACCEPTATION>

<RESUME_EXECUTIF>
Redige un paragraphe de resume executif en francais (5 a 7 phrases), objectif et factuel.
Presente : le type d'application analysee, les vulnerabilites critiques identifiees, le niveau de risque global,
l'impact potentiel sur la securite des utilisateurs, et les 3 recommandations prioritaires.
Texte narratif continu uniquement, sans liste, sans titre, sans formule d'adresse.
</RESUME_EXECUTIF>"""


# ---------------------------------------------------------------------------
# Parsing de la réponse
# ---------------------------------------------------------------------------

def _extract_xml(text: str, tag: str) -> str:
    try:
        s = text.index(f"<{tag}>") + len(f"<{tag}>")
        e = text.index(f"</{tag}>", s)
        return text[s:e].strip()
    except ValueError:
        return ""


def _parse_response(text: str) -> tuple:
    checklist_raw = _extract_xml(text, "CHECKLIST_MASVS")
    criteria_raw  = _extract_xml(text, "CRITERES_ACCEPTATION")
    summary       = _extract_xml(text, "RESUME_EXECUTIF")

    checklist = [
        line.strip()
        for line in checklist_raw.splitlines()
        if "[ ]" in line
    ]

    criteria = [
        line.strip()
        for line in criteria_raw.splitlines()
        if re.search(r"\bDOIT\b", line, re.IGNORECASE)
    ]

    # Fallback summary
    if not summary:
        candidates = [
            p.strip() for p in text.split("\n\n")
            if len(p.strip()) > 120
            and "[ ]" not in p
            and not p.strip().startswith("-")
            and "DOIT" not in p[:15]
        ]
        summary = " ".join(candidates[-3:])[:900] if candidates else ""

    return checklist, criteria, summary


# ---------------------------------------------------------------------------
# Critères Gherkin structurés
# ---------------------------------------------------------------------------

def generate_structured_acceptance_criteria(
        client, auth_type: str, dynamic_findings: list) -> list:
    if not client or not dynamic_findings:
        return []
    failed = [
        r.get("test", r.get("type", ""))
        for r in dynamic_findings
        if not r.get("passed", True)
    ]
    if not failed:
        return []
    prompt = (
        f"Tests de securite echoues pour une app Android {auth_type} :\n"
        + "\n".join(f"- {t}" for t in failed)
        + "\nGenere 3-5 criteres Gherkin (Given/When/Then). "
          "Reponds uniquement avec une liste de strings, une par ligne, sans markdown, sans backticks."
    )
    try:
        msg = client.messages.create(
            model=MODEL, max_tokens=600,
            messages=[{"role": "user", "content": prompt}]
        )
        return [
            line.strip()
            for line in msg.content[0].text.splitlines()
            if line.strip() and "```" not in line
        ]
    except Exception:
        return []


def detect_auth_type_extended(static_findings: list, decompiled_path: str) -> str:
    import os, re
    oauth2_patterns = [
        r"authorization_endpoint", r"redirect_uri",
        r"client_id", r"code_verifier", r"code_challenge",
        r"AppAuth", r"OAuthService"
    ]
    for root, _, files in os.walk(decompiled_path):
        for f in files:
            if f.endswith((".java", ".kt")):
                with open(os.path.join(root, f), encoding='utf-8', errors='ignore') as fh:
                    content = fh.read()
                if any(re.search(p, content) for p in oauth2_patterns):
                    return "OAUTH2"
    return "JWT" if any("JWT" in f.get("type", "").upper() or
                        "TOKEN" in f.get("type", "").upper()
                        for f in static_findings) else "SESSION_COOKIE"


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(combined: dict) -> dict:
    api_key = os.getenv("ANTHROPIC_API_KEY")
    if not api_key:
        raise ValueError("ANTHROPIC_API_KEY manquante dans le fichier .env")

    auth_type        = combined.get("auth_type", "JWT")
    static_results   = combined.get("static", {})
    dynamic_results  = combined.get("dynamic", {})
    static_findings  = static_results.get("findings", [])
    dynamic_findings = dynamic_results.get("findings", [])

    decompiled_path = combined.get("decompiled_path", ".")
    auth_type = detect_auth_type_extended(static_findings, decompiled_path)

    # Forcer JWT si OAUTH2 non détecté clairement (DVBA est JWT)
    if auth_type == "OAUTH2":
        auth_type = "JWT"

    client = anthropic.Anthropic(api_key=api_key)

    domain_scores = compute_domain_scores(static_findings, dynamic_findings)
    prompt = _build_prompt(auth_type, static_findings, dynamic_results, domain_scores)

    message = client.messages.create(
        model=MODEL,
        max_tokens=MAX_TOKENS,
        messages=[{"role": "user", "content": prompt}],
    )

    response_text = message.content[0].text
    checklist, criteria, summary = _parse_response(response_text)

    # Fallback checklist
    if not checklist:
        checklist = [
            line.strip()
            for line in response_text.splitlines()
            if "[ ]" in line
        ]

    # Gherkin structurés
    gherkin = generate_structured_acceptance_criteria(client, auth_type, dynamic_findings)

    return {
        "checklist":           checklist,
        "acceptance_criteria": criteria,
        "gherkin_criteria":    gherkin,
        "summary":             summary,
        "domain_scores":       domain_scores,
    }