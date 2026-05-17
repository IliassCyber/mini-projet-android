"""
Module 4 — Génération des rapports
Produit :
  results/<apk_name>_results.json  — données brutes complètes
  results/<apk_name>_report.pdf    — rapport PDF mis en forme (9 sections)

Sections :
  1. Resume Executif
  2. Analyse Statique
  3. Analyse Dynamique
  4. Cookie Security (OWASP flags)        ← Hafssa
  5. Android Storage (SharedPrefs/Keystore) ← Hafssa
  6. Session Security (entropy/fixation)  ← Hafssa
  7. Scores MASVS par Domaine
  8. Checklist de Securite (MASVS)
  9. Criteres d'Acceptation de Securite
"""

import json
import os
from datetime import datetime

from fpdf import FPDF

# ---------------------------------------------------------------------------
# Normalisation latin-1 (polices core fpdf2 = latin-1 uniquement)
# ---------------------------------------------------------------------------

_UNICODE_SUBS = str.maketrans({
    "\u2014": " - ",   # em dash —
    "\u2013": " - ",   # en dash –
    "\u2019": "'",     # right single quotation mark '
    "\u2018": "'",     # left single quotation mark '
    "\u201c": '"',     # left double quotation mark "
    "\u201d": '"',     # right double quotation mark "
    "\u2026": "...",   # ellipsis …
    "\u2022": "-",     # bullet •
    "\u00b7": "-",     # middle dot ·
})


def _t(text: str) -> str:
    """Traduit les caractères hors latin-1 puis encode/decode pour la sécurité."""
    return (
        str(text)
        .translate(_UNICODE_SUBS)
        .encode("latin-1", errors="replace")
        .decode("latin-1")
    )

# ---------------------------------------------------------------------------
# Palette de couleurs
# ---------------------------------------------------------------------------

COL_DARK_BLUE   = (30,  30,  80)
COL_LIGHT_BLUE  = (230, 235, 255)
COL_WHITE       = (255, 255, 255)
COL_LIGHT_GREY  = (245, 245, 245)
COL_MED_GREY    = (200, 200, 200)
COL_TEXT        = (35,  35,  35)
COL_SUBTEXT     = (90,  90,  90)
COL_GREEN_LIGHT = (230, 255, 235)
COL_RED_LIGHT   = (255, 235, 235)
COL_ORANGE_LIGHT= (255, 245, 225)

SEV_COLORS = {
    "CRITIQUE": (210, 40,  40),
    "ELEVE":    (220, 110, 20),
    "MOYEN":    (200, 170, 0),
    "INFO":     (60,  130, 210),
    "PASS":     (40,  160, 70),
}

SCORE_COLOR = {
    "red":    (210, 40,  40),
    "orange": (220, 110, 20),
    "green":  (40,  160, 70),
}

# ---------------------------------------------------------------------------
# Classe PDF personnalisée
# ---------------------------------------------------------------------------

class SecurityPDF(FPDF):
    def __init__(self, apk_name: str):
        super().__init__(orientation="P", unit="mm", format="A4")
        self._apk = apk_name
        self.set_margins(15, 15, 15)
        self.set_auto_page_break(auto=True, margin=22)

    def header(self):
        if self.page_no() == 1:
            return
        self.set_font("Helvetica", "I", 8)
        self.set_text_color(*COL_SUBTEXT)
        self.cell(
            0, 6,
            f"Auth & Session Security Analyzer  |  {self._apk}",
            align="L",
        )
        self.ln(6)
        self.set_draw_color(*COL_MED_GREY)
        self.set_line_width(0.3)
        self.line(15, self.get_y(), 195, self.get_y())
        self.ln(2)

    def footer(self):
        self.set_y(-14)
        self.set_font("Helvetica", "I", 8)
        self.set_text_color(*COL_SUBTEXT)
        self.cell(
            0, 5,
            f"Page {self.page_no()}   |   Confidentiel - Usage academique",
            align="C",
        )


# ---------------------------------------------------------------------------
# Helpers de rendu
# ---------------------------------------------------------------------------

def _section_title(pdf: SecurityPDF, title: str):
    pdf.set_fill_color(*COL_LIGHT_BLUE)
    pdf.set_text_color(*COL_DARK_BLUE)
    pdf.set_font("Helvetica", "B", 12)
    pdf.cell(0, 9, _t(f"  {title}"), fill=True, new_x="LMARGIN", new_y="NEXT")
    pdf.ln(3)


def _section_intro(pdf: SecurityPDF, text: str):
    """Paragraphe d'introduction sous le titre de section."""
    pdf.set_font("Helvetica", "I", 9)
    pdf.set_text_color(*COL_SUBTEXT)
    pdf.multi_cell(0, 5, _t(text))
    pdf.ln(4)


def _draw_bar(pdf: SecurityPDF, label: str, score: int):
    BAR_W   = 110
    BAR_H   = 7
    LABEL_W = 38
    y = pdf.get_y()

    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_TEXT)
    pdf.cell(LABEL_W, BAR_H + 2, _t(label), new_x="RIGHT", new_y="TOP")

    filled = int(BAR_W * score / 10)
    bar_col = (SCORE_COLOR["red"] if score < 4
               else SCORE_COLOR["orange"] if score < 7
               else SCORE_COLOR["green"])

    bar_x = pdf.get_x()
    bar_y = y + 1

    pdf.set_fill_color(*COL_MED_GREY)
    pdf.rect(bar_x, bar_y, BAR_W, BAR_H, "F")
    if filled > 0:
        pdf.set_fill_color(*bar_col)
        pdf.rect(bar_x, bar_y, filled, BAR_H, "F")

    pdf.set_xy(bar_x + BAR_W + 3, y)
    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*bar_col)
    pdf.cell(18, BAR_H + 2, f"{score}/10", new_x="LMARGIN", new_y="NEXT")
    pdf.ln(2)


def _severity_chip(pdf: SecurityPDF, sev: str, w: int = 22, h: int = 6):
    # Normaliser les sévérités anglaises
    sev_norm = {
        "CRITICAL": "CRITIQUE", "HIGH": "ELEVE",
        "MEDIUM": "MOYEN", "LOW": "INFO",
    }.get(sev, sev)
    color = SEV_COLORS.get(sev_norm, (150, 150, 150))
    pdf.set_fill_color(*color)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 7)
    pdf.cell(w, h, sev_norm[:8], border=1, fill=True, align="C",
             new_x="RIGHT", new_y="TOP")


def _bool_str(value) -> str:
    if value is True:
        return "Oui  (invalidation effective)"
    if value is False:
        return "Non  (VULNERABLE - rejeu possible)"
    return "Non teste"


def _findings_table(pdf: SecurityPDF, findings: list):
    """Tableau générique de findings (Sévérité | Type | Fichier | Détail)."""
    if not findings:
        pdf.set_font("Helvetica", "I", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(0, 6, "Aucune vulnerabilite detectee.",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(3)
        return

    W_SEV, W_TYPE, W_FILE = 22, 50, 32
    W_DETAIL = 180 - W_SEV - W_TYPE - W_FILE  # 76mm

    # En-tête
    pdf.set_fill_color(*COL_DARK_BLUE)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 8)
    pdf.cell(W_SEV,    7, "Severite", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_TYPE,   7, "Type",     border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_FILE,   7, "Fichier",  border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_DETAIL, 7, "Detail",   border=1, fill=True, align="C", new_x="LMARGIN", new_y="NEXT")

    def _fit(text: str, max_w: float) -> str:
        pdf.set_font("Helvetica", "", 7)
        if pdf.get_string_width(text) <= max_w:
            return text
        while text and pdf.get_string_width(text + "...") > max_w:
            text = text[:-1]
        return text + "..."

    for f in findings:
        sev      = f.get("severity", "INFO")
        type_t   = _fit(_t(str(f.get("type",   ""))), W_TYPE   - 2)
        file_t   = _fit(_t(os.path.basename(str(f.get("file", "")))), W_FILE - 2)
        detail_t = _fit(_t(str(f.get("detail", ""))), W_DETAIL - 2)

        _severity_chip(pdf, sev, w=W_SEV, h=6)
        pdf.set_fill_color(*COL_LIGHT_GREY)
        pdf.set_text_color(*COL_TEXT)
        pdf.set_font("Helvetica", "", 7)
        pdf.cell(W_TYPE,   6, type_t,   border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FILE,   6, file_t,   border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_DETAIL, 6, detail_t, border=1, fill=True, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(4)


# ---------------------------------------------------------------------------
# Sections du PDF
# ---------------------------------------------------------------------------

def _cover_page(pdf: SecurityPDF, apk_name: str, auth_type: str,
                score: int, findings_count: int):
    pdf.add_page()

    pdf.set_fill_color(*COL_DARK_BLUE)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 20)
    pdf.cell(0, 20, "Auth & Session Security Analyzer", fill=True,
             align="C", new_x="LMARGIN", new_y="NEXT")
    pdf.ln(8)

    pdf.set_font("Helvetica", "B", 13)
    pdf.set_text_color(*COL_DARK_BLUE)
    pdf.cell(0, 8, "Rapport d'audit de securite Android", align="C",
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(10)

    info_rows = [
        ("Application analysee",    apk_name),
        ("Type d'authentification", auth_type),
        ("Vulnerabilites detectees", str(findings_count)),
        ("Date d'analyse",           datetime.now().strftime("%d/%m/%Y  %H:%M")),
    ]
    for label, value in info_rows:
        pdf.set_font("Helvetica", "B", 10)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(65, 8, _t(label + " :"), new_x="RIGHT", new_y="TOP")
        pdf.set_font("Helvetica", "", 10)
        pdf.set_text_color(*COL_TEXT)
        pdf.cell(0, 8, _t(value), new_x="LMARGIN", new_y="NEXT")
    pdf.ln(10)

    if score < 4:
        bg, label = SCORE_COLOR["red"], "CRITIQUE"
    elif score < 7:
        bg, label = SCORE_COLOR["orange"], "ELEVE"
    else:
        bg, label = SCORE_COLOR["green"], "ACCEPTABLE"

    pdf.set_fill_color(*bg)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 16)
    pdf.cell(0, 14, f"Score global de securite : {score} / 10  ({label})",
             fill=True, align="C", new_x="LMARGIN", new_y="NEXT")


def _section_summary(pdf: SecurityPDF, summary: str):
    _section_title(pdf, "1. Resume Executif")
    _section_intro(pdf,
        "Ce resume presente les principales vulnerabilites identifiees lors de l'audit, "
        "evalue le niveau de risque global et formule les recommandations prioritaires.")
    pdf.set_font("Helvetica", "", 10)
    pdf.set_text_color(*COL_TEXT)
    pdf.multi_cell(0, 5.5, _t(summary) if summary else "Analyse IA non disponible.")
    pdf.ln(4)


def _section_static(pdf: SecurityPDF, static: dict):
    _section_title(pdf, "2. Analyse Statique - Vulnerabilites detectees")
    _section_intro(pdf,
        "L'analyse statique consiste en la decompilation de l'APK avec JADX et l'examen "
        "des sources Java/Kotlin par patterns regex. Les resultats sont classes par severite : "
        "CRITIQUE (-3 pts), ELEVE (-2 pts), MOYEN (-1 pt).")

    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_SUBTEXT)
    pdf.cell(0, 6,
             _t(f"Fichiers analyses : {static.get('files_scanned','N/A')}   |   "
                f"Vulnerabilites : {len(static.get('findings', []))}   |   "
                f"Score : {static.get('score', 'N/A')}/10"),
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(4)
    _findings_table(pdf, static.get("findings", []))


def _section_dynamic(pdf: SecurityPDF, dynamic: dict):
    _section_title(pdf, "3. Analyse Dynamique - Tests d'authentification")
    _section_intro(pdf,
        "L'analyse dynamique evalue le comportement de l'application en cours d'execution. "
        "Les tests portent sur la validite des tokens apres deconnexion, la duree de vie, "
        "la rotation des tokens, la fixation de session et la robustesse du mecanisme "
        "d'authentification.")

    rows = [
        ("Mode d'analyse",             dynamic.get("mode", "N/A")),
        ("Deconnexion effective",       _bool_str(dynamic.get("logout_effective"))),
        ("Duree de vie du token",       f"{dynamic.get('token_lifetime_minutes', 'N/A')} min"),
        ("Rotation des refresh tokens", _bool_str(dynamic.get("rotation_enforced"))),
    ]
    for label, value in rows:
        pdf.set_font("Helvetica", "B", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(70, 7, _t(label + " :"), border="B", new_x="RIGHT", new_y="TOP")
        pdf.set_font("Helvetica", "", 9)
        pdf.set_text_color(*COL_TEXT)
        pdf.cell(0, 7, _t(value), border="B", new_x="LMARGIN", new_y="NEXT")
        pdf.ln(1)

    dyn_findings = dynamic.get("findings", [])
    if dyn_findings:
        pdf.ln(4)
        pdf.set_font("Helvetica", "B", 9)
        pdf.set_text_color(*COL_TEXT)
        pdf.cell(0, 6, "Vulnerabilites detectees lors des tests :",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(2)
        for df in dyn_findings:
            sev    = df.get("severity", "INFO")
            sev_norm = {"CRITICAL": "CRITIQUE", "HIGH": "ELEVE",
                        "MEDIUM": "MOYEN", "LOW": "INFO"}.get(sev, sev)
            if sev_norm in ("PASS", "INFO") and not df.get("type"):
                continue
            _severity_chip(pdf, sev, w=22, h=7)
            pdf.set_text_color(*COL_TEXT)
            pdf.set_font("Helvetica", "", 8)
            detail = _t(str(df.get("detail", "")))[:95]
            pdf.cell(0, 7, detail, border=1, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


# ── NOUVEAU : Section 4 — Cookie Security Scanner (Hafssa) ──────────────────

def _section_cookie(pdf: SecurityPDF, cookie: dict):
    _section_title(pdf, "4. Cookie Security Scanner (OWASP)")
    _section_intro(pdf,
        "Analyse des headers HTTP Set-Cookie interceptes via mitmproxy. "
        "Verification des 7 controles OWASP : flag HttpOnly (MASVS-NETWORK-2), "
        "flag Secure (MASVS-NETWORK-1), attribut SameSite (protection CSRF), "
        "Max-Age/Expires, restriction de domaine et prefixes __Host-/__Secure-.")

    cookies_found = cookie.get("cookies_found", 0)
    score         = cookie.get("score", 10)
    findings      = cookie.get("findings", [])

    # Résumé
    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_SUBTEXT)
    score_col = (SCORE_COLOR["red"] if score < 4
                 else SCORE_COLOR["orange"] if score < 7
                 else SCORE_COLOR["green"])
    pdf.cell(0, 6,
             _t(f"Cookies interceptes : {cookies_found}   |   "
                f"Findings : {len(findings)}   |   "
                f"Score : {score}/10"),
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(4)

    if cookies_found == 0 and not findings:
        pdf.set_font("Helvetica", "I", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(0, 6,
                 "Aucun cookie intercepte. Verifier que le proxy mitmproxy est actif "
                 "lors de l'analyse dynamique.",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    # Tableau des findings avec colonne Fix
    if findings:
        W_SEV, W_TYPE, W_FIX = 22, 70, 88

        pdf.set_fill_color(*COL_DARK_BLUE)
        pdf.set_text_color(*COL_WHITE)
        pdf.set_font("Helvetica", "B", 8)
        pdf.cell(W_SEV,  7, "Severite", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
        pdf.cell(W_TYPE, 7, "Probleme", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FIX,  7, "Correction recommandee", border=1, fill=True, align="C",
                 new_x="LMARGIN", new_y="NEXT")

        def _fit_str(text: str, max_w: float) -> str:
            pdf.set_font("Helvetica", "", 7)
            if pdf.get_string_width(text) <= max_w:
                return text
            while text and pdf.get_string_width(text + "...") > max_w:
                text = text[:-1]
            return text + "..."

        for f in findings:
            type_t = _fit_str(_t(str(f.get("type", ""))),  W_TYPE - 2)
            fix_t  = _fit_str(_t(str(f.get("fix",  ""))),  W_FIX  - 2)
            _severity_chip(pdf, f.get("severity", "INFO"), w=W_SEV, h=6)
            pdf.set_fill_color(*COL_LIGHT_GREY)
            pdf.set_text_color(*COL_TEXT)
            pdf.set_font("Helvetica", "", 7)
            pdf.cell(W_TYPE, 6, type_t, border=1, fill=True, new_x="RIGHT", new_y="TOP")
            pdf.cell(W_FIX,  6, fix_t,  border=1, fill=True, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


# ── NOUVEAU : Section 5 — Android Storage Scanner (Hafssa) ──────────────────

def _section_storage(pdf: SecurityPDF, storage: dict):
    _section_title(pdf, "5. Android Storage Scanner (SharedPrefs / Keystore)")
    _section_intro(pdf,
        "Audit du stockage des donnees sensibles dans le code source decompile. "
        "Verification de l'usage de Android Keystore, EncryptedSharedPreferences, "
        "et detection des tokens stockes en clair (MASVS-STORAGE-1 et STORAGE-2).")

    uses_enc  = storage.get("uses_encrypted_prefs", False)
    uses_ks   = storage.get("uses_keystore", False)
    score     = storage.get("score", 10)
    findings  = storage.get("findings", [])

    # Indicateurs clés sur 2 colonnes
    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_SUBTEXT)
    pdf.cell(0, 6,
             _t(f"Findings : {len(findings)}   |   Score : {score}/10   |   "
                f"EncryptedSharedPrefs : {'OUI' if uses_enc else 'NON'}   |   "
                f"Android Keystore : {'OUI' if uses_ks else 'NON'}"),
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(3)

    # Badges OUI/NON pour EncryptedPrefs et Keystore
    for label, ok in [("EncryptedSharedPreferences", uses_enc),
                      ("Android Keystore",           uses_ks)]:
        bg = SCORE_COLOR["green"] if ok else SCORE_COLOR["red"]
        txt = "OUI" if ok else "NON"
        pdf.set_fill_color(*bg)
        pdf.set_text_color(*COL_WHITE)
        pdf.set_font("Helvetica", "B", 8)
        pdf.cell(55, 6, _t(label), border=1, fill=False,
                 new_x="RIGHT", new_y="TOP",
                 align="L")
        pdf.set_fill_color(*bg)
        pdf.cell(15, 6, txt, border=1, fill=True, align="C",
                 new_x="LMARGIN", new_y="NEXT")
    pdf.ln(4)

    # Tableau findings avec colonne Fix
    if findings:
        W_SEV, W_TYPE, W_FILE, W_FIX = 22, 45, 30, 83

        pdf.set_fill_color(*COL_DARK_BLUE)
        pdf.set_text_color(*COL_WHITE)
        pdf.set_font("Helvetica", "B", 8)
        pdf.cell(W_SEV,  7, "Severite", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
        pdf.cell(W_TYPE, 7, "Type",     border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FILE, 7, "Fichier",  border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FIX,  7, "Fix recommande", border=1, fill=True, align="C",
                 new_x="LMARGIN", new_y="NEXT")

        def _fit_s(text: str, max_w: float) -> str:
            pdf.set_font("Helvetica", "", 7)
            if pdf.get_string_width(text) <= max_w:
                return text
            while text and pdf.get_string_width(text + "...") > max_w:
                text = text[:-1]
            return text + "..."

        for f in findings:
            type_t = _fit_s(_t(str(f.get("type", ""))),                        W_TYPE - 2)
            file_t = _fit_s(_t(os.path.basename(str(f.get("file", "")))),      W_FILE - 2)
            fix_t  = _fit_s(_t(str(f.get("fix",  ""))),                        W_FIX  - 2)
            _severity_chip(pdf, f.get("severity", "INFO"), w=W_SEV, h=6)
            pdf.set_fill_color(*COL_LIGHT_GREY)
            pdf.set_text_color(*COL_TEXT)
            pdf.set_font("Helvetica", "", 7)
            pdf.cell(W_TYPE, 6, type_t, border=1, fill=True, new_x="RIGHT", new_y="TOP")
            pdf.cell(W_FILE, 6, file_t, border=1, fill=True, new_x="RIGHT", new_y="TOP")
            pdf.cell(W_FIX,  6, fix_t,  border=1, fill=True, new_x="LMARGIN", new_y="NEXT")
    else:
        pdf.set_font("Helvetica", "I", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(0, 6, "Aucun finding storage detecte.", new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


# ── NOUVEAU : Section 6 — Session Security Scanner (Hafssa) ─────────────────

def _section_session(pdf: SecurityPDF, session: dict):
    _section_title(pdf, "6. Session Security Scanner (Entropie / Fixation / Timeout)")
    _section_intro(pdf,
        "Tests de securite de session cote serveur : analyse de l'entropie du Session ID "
        "(MASVS-AUTH-1), test de fixation de session (MASVS-AUTH-3), "
        "timeout d'inactivite (MASVS-AUTH-2), et invalidation post-deconnexion.")

    sid      = session.get("session_id_detected")
    findings = session.get("findings", [])
    mode     = session.get("mode", "N/A")

    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_SUBTEXT)
    sid_display = f"...{sid[-8:]}" if sid and len(sid) > 8 else (sid or "Non detecte")
    pdf.cell(0, 6,
             _t(f"Mode : {mode}   |   Session ID : {sid_display}   |   "
                f"Findings : {len(findings)}"),
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(4)

    if not findings:
        pdf.set_font("Helvetica", "I", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(0, 6, "Aucun finding session detecte.", new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    # Tableau findings avec colonne Fix
    W_SEV, W_TYPE, W_MASVS, W_FIX = 22, 55, 25, 78

    pdf.set_fill_color(*COL_DARK_BLUE)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 8)
    pdf.cell(W_SEV,   7, "Severite", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_TYPE,  7, "Probleme", border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_MASVS, 7, "MASVS",   border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(W_FIX,   7, "Correction", border=1, fill=True, align="C",
             new_x="LMARGIN", new_y="NEXT")

    def _fit_se(text: str, max_w: float) -> str:
        pdf.set_font("Helvetica", "", 7)
        if pdf.get_string_width(text) <= max_w:
            return text
        while text and pdf.get_string_width(text + "...") > max_w:
            text = text[:-1]
        return text + "..."

    for f in findings:
        sev   = f.get("severity", "INFO")
        if sev in ("INFO", "PASS") and not f.get("fix"):
            # Afficher quand même les INFO significatifs (ex: NA pour JWT)
            pass
        type_t  = _fit_se(_t(str(f.get("type",  ""))), W_TYPE  - 2)
        masvs_t = _fit_se(_t(str(f.get("masvs", ""))), W_MASVS - 2)
        fix_t   = _fit_se(_t(str(f.get("fix",   f.get("detail", "")))), W_FIX - 2)

        _severity_chip(pdf, sev, w=W_SEV, h=6)
        pdf.set_fill_color(*COL_LIGHT_GREY)
        pdf.set_text_color(*COL_TEXT)
        pdf.set_font("Helvetica", "", 7)
        pdf.cell(W_TYPE,  6, type_t,  border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_MASVS, 6, masvs_t, border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FIX,   6, fix_t,   border=1, fill=True, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


def _section_masvs_scores(pdf: SecurityPDF, domain_scores: dict,
                           cookie_score: float = None, storage_score: float = None):
    _section_title(pdf, "7. Scores MASVS par Domaine")
    _section_intro(pdf,
        "Les scores refletent le niveau de securite par domaine OWASP MASVS v2. "
        "Chaque vulnerabilite deduit des points selon sa severite. "
        "Un score inferieur a 4 indique un risque critique sur ce domaine.")

    if not domain_scores and cookie_score is None and storage_score is None:
        pdf.set_font("Helvetica", "I", 9)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(0, 6, "Scores non disponibles (analyse IA desactivee).",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    domain_labels = {
        "AUTH":    "MASVS-AUTH",
        "STORAGE": "MASVS-STORAGE",
        "CRYPTO":  "MASVS-CRYPTO",
        "NETWORK": "MASVS-NETWORK",
    }
    for key, label in domain_labels.items():
        score = domain_scores.get(key, 10)
        _draw_bar(pdf, label, score)

    # Scores supplémentaires des nouveaux modules
    if cookie_score is not None:
        _draw_bar(pdf, "Cookie Security", int(cookie_score))
    if storage_score is not None:
        _draw_bar(pdf, "Storage Security", int(storage_score))

    pdf.ln(4)


def _section_checklist(pdf: SecurityPDF, checklist: list):
    _section_title(pdf, "8. Checklist de Securite (MASVS)")
    _section_intro(pdf,
        "Checklist generee par IA (Claude) adaptee au type d'authentification detecte. "
        "Chaque controle est mappe a un chapitre OWASP MASVS pertinent. "
        "Ces points constituent le referentiel de verification pour la revue de code.")

    if not checklist:
        pdf.set_font("Helvetica", "I", 9)
        pdf.cell(0, 6, "Checklist non disponible.", new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    pdf.set_font("Helvetica", "", 8)
    pdf.set_text_color(*COL_TEXT)
    for item in checklist:
        pdf.multi_cell(0, 5.5, _t(item))
        pdf.ln(1.5)
    pdf.ln(4)


def _section_criteria(pdf: SecurityPDF, criteria: list, structured: list = None):
    _section_title(pdf, "9. Criteres d'Acceptation de Securite")
    _section_intro(pdf,
        "Les criteres d'acceptation definissent les conditions que le systeme doit satisfaire "
        "pour etre considere comme securise. Ils servent de base aux tests d'acceptation, "
        "aux revues de code et aux audits de conformite MASVS.")

    all_criteria = list(criteria or [])

    # Ajouter les critères structurés Gherkin (Iliass) s'ils existent
    if structured:
        all_criteria.append("")  # séparateur
        all_criteria.append("--- Criteres Gherkin (bases sur les tests echoues) ---")
        all_criteria.extend(structured)

    if not all_criteria:
        pdf.set_font("Helvetica", "I", 9)
        pdf.cell(0, 6, "Criteres non disponibles.", new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    for i, item in enumerate(all_criteria, 1):
        item_str = str(item).strip()
        if not item_str:
            pdf.ln(2)
            continue
        if item_str.startswith("---"):
            pdf.set_font("Helvetica", "B", 9)
            pdf.set_text_color(*COL_DARK_BLUE)
            pdf.cell(0, 6, _t(item_str), new_x="LMARGIN", new_y="NEXT")
            pdf.ln(2)
            continue
        pdf.set_font("Helvetica", "B", 9)
        pdf.set_text_color(*COL_DARK_BLUE)
        pdf.cell(8, 6, f"{i}.", new_x="RIGHT", new_y="TOP")
        pdf.set_font("Helvetica", "", 9)
        pdf.set_text_color(*COL_TEXT)
        pdf.multi_cell(0, 6, _t(item_str))
        pdf.ln(2)


# ---------------------------------------------------------------------------
# Génération du PDF — orchestration
# ---------------------------------------------------------------------------

def _generate_pdf(results: dict, apk_name: str, pdf_path: str):
    static  = results.get("static",  {})
    dynamic = results.get("dynamic", {})
    cookie  = results.get("cookie",  {})
    storage = results.get("storage", {})
    session = results.get("session", {})
    ai      = results.get("ai",      {})

    # Comptage total findings toutes sources
    all_findings_count = (
        len(static.get("findings",  []))
        + len(dynamic.get("findings", []))
        + len(cookie.get("findings",  []))
        + len(storage.get("findings", []))
        + len(session.get("findings", []))
    )

    pdf = SecurityPDF(apk_name)

    # ── Page de couverture ────────────────────────────────────────────────
    _cover_page(
        pdf,
        apk_name=apk_name,
        auth_type=static.get("auth_type", "INCONNU"),
        score=static.get("score", 0),
        findings_count=all_findings_count,
    )

    # ── Section 1 : Résumé exécutif ───────────────────────────────────────
    pdf.add_page()
    _section_summary(pdf, ai.get("summary", "Analyse IA non disponible."))

    # ── Section 2 : Analyse statique ─────────────────────────────────────
    _section_static(pdf, static)

    # ── Section 3 : Analyse dynamique ────────────────────────────────────
    _section_dynamic(pdf, dynamic)

    # ── Section 4 : Cookie Security (Hafssa) ─────────────────────────────
    pdf.add_page()
    _section_cookie(pdf, cookie)

    # ── Section 5 : Storage Security (Hafssa) ────────────────────────────
    _section_storage(pdf, storage)

    # ── Section 6 : Session Security (Hafssa) ────────────────────────────
    pdf.add_page()
    _section_session(pdf, session)

    # ── Section 7 : Scores MASVS ─────────────────────────────────────────
    pdf.add_page()
    _section_masvs_scores(
        pdf,
        ai.get("domain_scores", {}),
        cookie_score=cookie.get("score"),
        storage_score=storage.get("score"),
    )

    # ── Section 8 : Checklist ────────────────────────────────────────────
    _section_checklist(pdf, ai.get("checklist", []))

    # ── Section 9 : Critères d'acceptation ───────────────────────────────
    pdf.add_page()
    _section_criteria(
        pdf,
        ai.get("acceptance_criteria", []),
        structured=ai.get("structured_acceptance_criteria", []),
    )

    pdf.output(pdf_path)


# ---------------------------------------------------------------------------
# Point d'entrée
# ---------------------------------------------------------------------------

def generate(results: dict, apk_name: str, results_dir: str) -> tuple:
    """
    Génère le JSON et le PDF.
    Retourne (json_path, pdf_path).
    """
    os.makedirs(results_dir, exist_ok=True)

    safe_name = apk_name.replace(" ", "_")

    json_path = os.path.join(results_dir, f"{safe_name}_results.json")
    with open(json_path, "w", encoding="utf-8") as f:
        json.dump(results, f, indent=2, ensure_ascii=False)

    pdf_path = os.path.join(results_dir, f"{safe_name}_report.pdf")
    _generate_pdf(results, apk_name, pdf_path)

    return json_path, pdf_path