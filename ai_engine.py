"""
Module 3 — Moteur IA
Envoie les résultats d'analyse à Claude (claude-sonnet-4-6) et structure
la réponse en checklist MASVS, critères d'acceptation et résumé exécutif.
"""

import os
import re
from dotenv import load_dotenv
import anthropic

load_dotenv()

MODEL = "claude-sonnet-4-6"
MAX_TOKENS = 2048

# ---------------------------------------------------------------------------
# Calcul des scores MASVS par domaine
# ---------------------------------------------------------------------------

# Mapping : préfixe d'id de finding → domaine MASVS
_DOMAIN_MAP = {
    "JWT":             "AUTH",
    "SESSION":         "AUTH",
    "LOGOUT":          "AUTH",
    "ROTATION":        "AUTH",
    "HARDCODED_SECRET":"STORAGE",
    "LOG_CREDENTIALS": "STORAGE",
    "SHARED_PREFS":    "STORAGE",
    "NO_SSL":          "NETWORK",
    "HTTP_CLEARTEXT":  "NETWORK",
    "SSL":             "NETWORK",
    "WEAK_CRYPTO":     "CRYPTO",
    "WEAK_HASH":       "CRYPTO",
    "AES_ECB":         "CRYPTO",
}

_PENALTY = {"CRITIQUE": 3, "ELEVE": 2, "MOYEN": 1}


def compute_domain_scores(static_findings: list, dynamic_findings: list) -> dict:
    scores = {"AUTH": 10, "STORAGE": 10, "NETWORK": 10, "CRYPTO": 10}

    all_findings = static_findings + dynamic_findings
    for f in all_findings:
        fid = f.get("id", f.get("type", "")).upper()
        sev = f.get("severity", "MOYEN")
        penalty = _PENALTY.get(sev, 0)

        for prefix, domain in _DOMAIN_MAP.items():
            if prefix in fid:
                scores[domain] = max(0, scores[domain] - penalty)
                break
        else:
            # Finding non catégorisé → pénalise AUTH par défaut
            scores["AUTH"] = max(0, scores["AUTH"] - (_PENALTY.get(sev, 0) // 2))

    return scores


# ---------------------------------------------------------------------------
# Construction du prompt
# ---------------------------------------------------------------------------

def _build_prompt(auth_type: str, static_findings: list, dynamic: dict,
                  domain_scores: dict) -> str:
    # Résumé des findings statiques (max 25 pour rester dans le contexte)
    findings_text = "\n".join(
        f"  - [{f['severity']}] {f['type']} : {f.get('detail', '')} "
        f"(fichier : {f.get('file', 'N/A')}, ligne {f.get('line', '?')})"
        for f in static_findings[:25]
    ) or "  Aucun finding statique detecte."

    # Résultats dynamiques
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

    # Scores MASVS
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
Application Android utilisant **{auth_type}** pour l'authentification ({auth_hint}).

## Resultats de l'analyse statique
{findings_text}

## Resultats de l'analyse dynamique
{dynamic_text}

## Scores MASVS calcules par domaine
{scores_text}

---

INSTRUCTIONS : Genere les trois blocs ci-dessous EN FRANCAIS, dans l'ordre exact, avec les marqueurs XML exacts.

<CHECKLIST_MASVS>
Checklist de securite contextuelle pour le type {auth_type}, mappee aux chapitres MASVS 4, 6, 7, 12, 14.
Format strict de chaque ligne : - [ ] [MASVS-XXX-N] description du controle
Minimum 12 elements adaptes aux vulnerabilites detectees.
</CHECKLIST_MASVS>

<CRITERES_ACCEPTATION>
Criteres d'acceptation de securite.
Format strict de chaque ligne : Le systeme DOIT/NE DOIT PAS [action] afin de [raison]
Minimum 8 criteres.
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
    """Extrait le contenu entre <tag> et </tag>."""
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

    # Fallback anciens marqueurs si les XML ne sont pas trouvés
    if not checklist_raw:
        try:
            s = text.index("CHECKLIST_START") + len("CHECKLIST_START")
            e = text.index("CHECKLIST_END", s)
            checklist_raw = text[s:e].strip()
        except ValueError:
            pass

    if not criteria_raw:
        try:
            s = text.index("CRITERIA_START") + len("CRITERIA_START")
            e = text.index("CRITERIA_END", s)
            criteria_raw = text[s:e].strip()
        except ValueError:
            pass

    if not summary:
        # Fallback : dernier grand paragraphe narratif (pas de liste)
        candidates = [
            p.strip() for p in text.split("\n\n")
            if len(p.strip()) > 120
            and "[ ]" not in p
            and "<" not in p[:5]
            and not p.strip().startswith("-")
            and "DOIT" not in p[:15]
        ]
        summary = " ".join(candidates[-3:])[:900] if candidates else ""

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

    return checklist, criteria, summary


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def analyze(combined: dict) -> dict:
    """
    combined doit contenir :
      { "auth_type": str, "static": {...}, "dynamic": {...} }

    Retourne :
      { "checklist": [...], "acceptance_criteria": [...],
        "summary": str, "domain_scores": {...} }
    """
    api_key = os.getenv("ANTHROPIC_API_KEY")
    if not api_key:
        raise ValueError(
            "ANTHROPIC_API_KEY manquante. "
            "Ajoutez ANTHROPIC_API_KEY=sk-... dans le fichier .env"
        )

    auth_type       = combined.get("auth_type", "UNKNOWN")
    static_results  = combined.get("static", {})
    dynamic_results = combined.get("dynamic", {})
    static_findings = static_results.get("findings", [])
    dynamic_findings= dynamic_results.get("findings", [])

    domain_scores = compute_domain_scores(static_findings, dynamic_findings)

    prompt = _build_prompt(auth_type, static_findings, dynamic_results, domain_scores)

    client = anthropic.Anthropic(api_key=api_key)
    message = client.messages.create(
        model=MODEL,
        max_tokens=MAX_TOKENS,
        messages=[{"role": "user", "content": prompt}],
    )

    response_text = message.content[0].text
    checklist, criteria, summary = _parse_response(response_text)

    # Fallbacks si le parsing échoue
    if not checklist:
        checklist = [
            line.strip()
            for line in response_text.splitlines()
            if "[ ]" in line
        ]
    if not summary:
        # Prendre les premiers paragraphes significatifs
        summary = " ".join(
            p.strip()
            for p in response_text.split("\n\n")
            if len(p.strip()) > 80
        )[:1000]

    return {
        "checklist":           checklist,
        "acceptance_criteria": criteria,
        "summary":             summary,
        "domain_scores":       domain_scores,
    }

