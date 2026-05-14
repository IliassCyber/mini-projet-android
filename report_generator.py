"""
Module 4 — Génération des rapports
Produit :
  results/<apk_name>_results.json  — données brutes complètes
  results/<apk_name>_report.pdf    — rapport PDF mis en forme
"""

import json
import os
from datetime import datetime

from fpdf import FPDF

# ---------------------------------------------------------------------------
# Normalisation latin-1 (polices core fpdf2 = latin-1 uniquement)
# ---------------------------------------------------------------------------

_UNICODE_SUBS = str.maketrans({
    "—": " - ",   # em dash —
    "–": " - ",   # en dash –
    "’": "'",     # right single quotation mark '
    "‘": "'",     # left single quotation mark '
    "“": '"',     # left double quotation mark "
    "”": '"',     # right double quotation mark "
    "…": "...",   # ellipsis …
    "•": "-",     # bullet •
    "·": "-",     # middle dot ·
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

SEV_COLORS = {
    "CRITIQUE": (210, 40,  40),
    "ELEVE":    (220, 110, 20),
    "MOYEN":    (200, 170, 0),
    "INFO":     (60,  130, 210),
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


def _score_badge(pdf: SecurityPDF, score: int, label: str, x: float, y: float,
                 w: float = 50, h: float = 16):
    if score < 4:
        color = SCORE_COLOR["red"]
    elif score < 7:
        color = SCORE_COLOR["orange"]
    else:
        color = SCORE_COLOR["green"]

    pdf.set_fill_color(*color)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 11)
    pdf.set_xy(x, y)
    pdf.cell(w, h, f"{label}: {score}/10", fill=True, align="C",
             new_x="RIGHT", new_y="TOP")


def _draw_bar(pdf: SecurityPDF, label: str, score: int):
    BAR_W = 110
    BAR_H = 7
    LABEL_W = 38
    y = pdf.get_y()

    # Étiquette du domaine
    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*COL_TEXT)
    pdf.cell(LABEL_W, BAR_H + 2, _t(label), new_x="RIGHT", new_y="TOP")

    # Barre de progression
    filled = int(BAR_W * score / 10)
    if score < 4:
        bar_col = SCORE_COLOR["red"]
    elif score < 7:
        bar_col = SCORE_COLOR["orange"]
    else:
        bar_col = SCORE_COLOR["green"]

    bar_x = pdf.get_x()
    bar_y = y + 1

    # Fond gris
    pdf.set_fill_color(*COL_MED_GREY)
    pdf.rect(bar_x, bar_y, BAR_W, BAR_H, "F")
    # Remplissage coloré
    if filled > 0:
        pdf.set_fill_color(*bar_col)
        pdf.rect(bar_x, bar_y, filled, BAR_H, "F")

    # Score numérique
    pdf.set_xy(bar_x + BAR_W + 3, y)
    pdf.set_font("Helvetica", "B", 9)
    pdf.set_text_color(*bar_col)
    pdf.cell(18, BAR_H + 2, f"{score}/10", new_x="LMARGIN", new_y="NEXT")
    pdf.ln(2)


def _severity_chip(pdf: SecurityPDF, sev: str, w: int = 22, h: int = 6):
    color = SEV_COLORS.get(sev, (150, 150, 150))
    pdf.set_fill_color(*color)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 7)
    pdf.cell(w, h, sev[:8], border=1, fill=True, align="C",
             new_x="RIGHT", new_y="TOP")


def _bool_str(value) -> str:
    if value is True:
        return "Oui  (invalidation effective)"
    if value is False:
        return "Non  (VULNERABLE - rejeu possible)"
    return "Non teste"


# ---------------------------------------------------------------------------
# Sections du PDF
# ---------------------------------------------------------------------------

def _cover_page(pdf: SecurityPDF, apk_name: str, auth_type: str,
                score: int, findings_count: int):
    pdf.add_page()

    # Bandeau titre
    pdf.set_fill_color(*COL_DARK_BLUE)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 20)
    pdf.cell(0, 20, "Auth & Session Security Analyzer", fill=True,
             align="C", new_x="LMARGIN", new_y="NEXT")
    pdf.ln(8)

    # Sous-titre
    pdf.set_font("Helvetica", "B", 13)
    pdf.set_text_color(*COL_DARK_BLUE)
    pdf.cell(0, 8, "Rapport d'audit de securite Android", align="C",
             new_x="LMARGIN", new_y="NEXT")
    pdf.ln(10)

    # Infos APK
    info_rows = [
        ("Application analysee", apk_name),
        ("Type d'authentification", auth_type),
        ("Vulnerabilites detectees", str(findings_count)),
        ("Date d'analyse", datetime.now().strftime("%d/%m/%Y  %H:%M")),
    ]
    for label, value in info_rows:
        pdf.set_font("Helvetica", "B", 10)
        pdf.set_text_color(*COL_SUBTEXT)
        pdf.cell(65, 8, _t(label + " :"), new_x="RIGHT", new_y="TOP")
        pdf.set_font("Helvetica", "", 10)
        pdf.set_text_color(*COL_TEXT)
        pdf.cell(0, 8, _t(value), new_x="LMARGIN", new_y="NEXT")
    pdf.ln(10)

    # Score global
    if score < 4:
        bg = SCORE_COLOR["red"]
        label = "CRITIQUE"
    elif score < 7:
        bg = SCORE_COLOR["orange"]
        label = "ELEVE"
    else:
        bg = SCORE_COLOR["green"]
        label = "ACCEPTABLE"

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
    text = _t(summary) if summary else "Analyse IA non disponible."
    pdf.multi_cell(0, 5.5, text)
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

    findings = static.get("findings", [])
    if not findings:
        pdf.set_font("Helvetica", "I", 9)
        pdf.cell(0, 6, "Aucune vulnerabilite detectee.",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    # En-tête : Severite | Type | Fichier:Ligne  +  Detail
    pdf.set_fill_color(*COL_DARK_BLUE)
    pdf.set_text_color(*COL_WHITE)
    pdf.set_font("Helvetica", "B", 8)
    pdf.cell(22, 7, "Severite",         border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(50, 7, "Type",             border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(32, 7, "Fichier",          border=1, fill=True, align="C", new_x="RIGHT", new_y="TOP")
    pdf.cell(0,  7, "Detail",           border=1, fill=True, align="C", new_x="LMARGIN", new_y="NEXT")

    # Largeurs des colonnes (mm) — total = 180mm page utile
    W_SEV, W_TYPE, W_FILE = 22, 50, 32
    W_DETAIL = 180 - W_SEV - W_TYPE - W_FILE  # 76mm

    def _fit(pdf, text: str, max_w: float) -> str:
        """Tronque text pour tenir dans max_w mm avec la fonte courante."""
        if pdf.get_string_width(text) <= max_w:
            return text
        while text and pdf.get_string_width(text + "...") > max_w:
            text = text[:-1]
        return text + "..."

    for f in findings:
        sev    = f.get("severity", "INFO")
        pdf.set_font("Helvetica", "", 7)   # doit être défini avant _fit

        type_t   = _fit(pdf, _t(str(f.get("type",   ""))), W_TYPE   - 2)
        file_t   = _fit(pdf, _t(os.path.basename(str(f.get("file", "")))), W_FILE   - 2)
        detail_t = _fit(pdf, _t(str(f.get("detail", ""))), W_DETAIL - 2)

        _severity_chip(pdf, sev, w=W_SEV, h=6)
        pdf.set_fill_color(*COL_LIGHT_GREY)
        pdf.set_text_color(*COL_TEXT)
        pdf.set_font("Helvetica", "", 7)
        pdf.cell(W_TYPE,   6, type_t,   border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_FILE,   6, file_t,   border=1, fill=True, new_x="RIGHT", new_y="TOP")
        pdf.cell(W_DETAIL, 6, detail_t, border=1, fill=True, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


def _section_dynamic(pdf: SecurityPDF, dynamic: dict):
    _section_title(pdf, "3. Analyse Dynamique - Tests d'authentification")
    _section_intro(pdf,
        "L'analyse dynamique evalue le comportement de l'application en cours d'execution. "
        "Les tests portent sur la validite des tokens apres deconnexion, la duree de vie, "
        "la rotation des tokens et la robustesse du mecanisme d'authentification.")

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
            sev = df.get("severity", "INFO")
            _severity_chip(pdf, sev, w=22, h=7)
            pdf.set_text_color(*COL_TEXT)
            pdf.set_font("Helvetica", "", 8)
            detail = _t(str(df.get("detail", "")))[:95]
            pdf.cell(0, 7, detail, border=1, new_x="LMARGIN", new_y="NEXT")

    pdf.ln(5)


def _section_masvs_scores(pdf: SecurityPDF, domain_scores: dict):
    _section_title(pdf, "4. Scores MASVS par Domaine")
    _section_intro(pdf,
        "Les scores refletent le niveau de securite par domaine OWASP MASVS v2. "
        "Chaque vulnerabilite deduit des points selon sa severite. "
        "Un score inferieur a 4 indique un risque critique sur ce domaine.")

    if not domain_scores:
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

    pdf.ln(4)


def _section_checklist(pdf: SecurityPDF, checklist: list):
    _section_title(pdf, "5. Checklist de Securite (MASVS)")
    _section_intro(pdf,
        "Checklist generee par IA (Claude) adaptee au type d'authentification detecte. "
        "Chaque controle est mappe a un chapitre OWASP MASVS pertinent. "
        "Ces points constituent le referentiel de verification pour la revue de code.")

    if not checklist:
        pdf.set_font("Helvetica", "I", 9)
        pdf.cell(0, 6, "Checklist non disponible.",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    pdf.set_font("Helvetica", "", 8)
    pdf.set_text_color(*COL_TEXT)
    for item in checklist:
        pdf.multi_cell(0, 5.5, _t(item))
        pdf.ln(1.5)

    pdf.ln(4)


def _section_criteria(pdf: SecurityPDF, criteria: list):
    _section_title(pdf, "6. Criteres d'Acceptation de Securite")
    _section_intro(pdf,
        "Les criteres d'acceptation definissent les conditions que le systeme doit satisfaire "
        "pour etre considere comme securise. Ils servent de base aux tests d'acceptation, "
        "aux revues de code et aux audits de conformite MASVS.")

    if not criteria:
        pdf.set_font("Helvetica", "I", 9)
        pdf.cell(0, 6, "Criteres non disponibles.",
                 new_x="LMARGIN", new_y="NEXT")
        pdf.ln(4)
        return

    for i, item in enumerate(criteria, 1):
        pdf.set_font("Helvetica", "B", 9)
        pdf.set_text_color(*COL_DARK_BLUE)
        pdf.cell(8, 6, f"{i}.", new_x="RIGHT", new_y="TOP")
        pdf.set_font("Helvetica", "", 9)
        pdf.set_text_color(*COL_TEXT)
        pdf.multi_cell(0, 6, _t(item))
        pdf.ln(2)


# ---------------------------------------------------------------------------
# Génération du PDF
# ---------------------------------------------------------------------------

def _generate_pdf(results: dict, apk_name: str, pdf_path: str):
    static  = results.get("static",  {})
    dynamic = results.get("dynamic", {})
    ai      = results.get("ai",      {})

    all_findings = (
        static.get("findings", [])
        + dynamic.get("findings", [])
    )

    pdf = SecurityPDF(apk_name)

    # Page de couverture
    _cover_page(
        pdf,
        apk_name=apk_name,
        auth_type=static.get("auth_type", "INCONNU"),
        score=static.get("score", 0),
        findings_count=len(all_findings),
    )

    # Section 1 : Résumé exécutif
    pdf.add_page()
    _section_summary(pdf, ai.get("summary", "Analyse IA non disponible."))

    # Section 2 : Analyse statique
    _section_static(pdf, static)

    # Section 3 : Analyse dynamique
    _section_dynamic(pdf, dynamic)

    # Section 4 : Scores MASVS
    pdf.add_page()
    _section_masvs_scores(pdf, ai.get("domain_scores", {}))

    # Section 5 : Checklist
    _section_checklist(pdf, ai.get("checklist", []))

    # Section 6 : Critères d'acceptation
    pdf.add_page()
    _section_criteria(pdf, ai.get("acceptance_criteria", []))

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
