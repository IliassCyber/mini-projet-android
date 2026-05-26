@echo off
REM MobileSec v2.0 — Script de reproduction (Windows)
echo ============================================
echo   MobileSec v2.0 ^— Reproduction Script
echo ============================================

REM 1. Verifications
python --version >nul 2>&1 || (echo [ERR] python introuvable & exit /b 1)
jadx --version   >nul 2>&1 || (echo [ERR] jadx introuvable — installer JADX 1.5.5 et l'ajouter au PATH & exit /b 1)
docker --version >nul 2>&1 || (echo [ERR] docker introuvable & exit /b 1)
echo [OK] Dependances systeme detectees

REM 2. Environnement virtuel
python -m venv .venv
call .venv\Scripts\activate.bat
pip install --quiet -r requirements.txt
echo [OK] Dependances Python installees

REM 3. Configuration .env
if not exist .env (
    copy .env.example .env
    echo [!] .env cree depuis .env.example — renseigner ANTHROPIC_API_KEY avant de continuer
    exit /b 0
)

REM 4. Backend DVBA
echo [*] Demarrage backend DVBA...
pushd Damn-Vulnerable-Bank\BackendServer
docker compose up -d
popd
echo [OK] Backend DVBA demarre sur http://localhost:3000

REM 5. Backend InsecureBankv2
echo [*] Demarrage backend InsecureBankv2...
pushd Android-InsecureBankv2\AndroLabServer
pip install --quiet flask sqlalchemy simplejson
start /B python app.py
popd
timeout /t 3 /nobreak >nul
echo [OK] Backend InsecureBankv2 demarre sur http://localhost:8888

REM 6. Analyses
echo.
echo [*] Analyse DVBA (JWT)...
python main.py --apk apks/dvba.apk

echo.
echo [*] Analyse InsecureBankv2 (Session Cookie)...
python main.py --apk apks/app-debug.apk

echo.
echo ============================================
echo   Rapports generes dans results/
echo   dvba_report.pdf + app-debug_report.pdf
echo ============================================
