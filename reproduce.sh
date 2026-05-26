#!/usr/bin/env bash
# MobileSec v2.0 — Script de reproduction (Linux / macOS)
set -e

echo "============================================"
echo "  MobileSec v2.0 — Reproduction Script"
echo "============================================"

# 1. Vérifications
command -v python3 >/dev/null 2>&1 || { echo "[ERR] python3 introuvable"; exit 1; }
command -v jadx    >/dev/null 2>&1 || { echo "[ERR] jadx introuvable — installer JADX 1.5.5 et l'ajouter au PATH"; exit 1; }
command -v docker  >/dev/null 2>&1 || { echo "[ERR] docker introuvable"; exit 1; }

echo "[OK] Dépendances système détectées"

# 2. Environnement virtuel
python3 -m venv .venv
source .venv/bin/activate
pip install --quiet -r requirements.txt
echo "[OK] Dépendances Python installées"

# 3. Configuration .env
if [ ! -f .env ]; then
    cp .env.example .env
    echo "[!] .env créé depuis .env.example — renseigner ANTHROPIC_API_KEY avant de continuer"
    exit 0
fi

# 4. Backend DVBA (Docker Compose)
echo "[*] Démarrage backend DVBA..."
cd Damn-Vulnerable-Bank/BackendServer && docker compose up -d && cd ../..
echo "[OK] Backend DVBA démarré sur http://localhost:3000"

# 5. Backend InsecureBankv2
echo "[*] Démarrage backend InsecureBankv2..."
cd Android-InsecureBankv2/AndroLabServer
pip install --quiet flask sqlalchemy simplejson
python app.py &
IBANK_PID=$!
cd ../..
sleep 3
echo "[OK] Backend InsecureBankv2 démarré sur http://localhost:8888 (PID $IBANK_PID)"

# 6. Analyses
echo ""
echo "[*] Analyse DVBA (JWT)..."
python main.py --apk apks/dvba.apk

echo ""
echo "[*] Analyse InsecureBankv2 (Session Cookie)..."
python main.py --apk apks/app-debug.apk

echo ""
echo "============================================"
echo "  Rapports générés dans results/"
echo "  dvba_report.pdf + app-debug_report.pdf"
echo "============================================"

kill $IBANK_PID 2>/dev/null || true
