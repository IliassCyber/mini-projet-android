# MobileSec — Analyseur de Sécurité Multi-Couches pour Android

[![Release](https://img.shields.io/badge/release-v2.0-blue)](https://github.com/IliassCyber/mini-projet-android/releases/tag/v2.0)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Python](https://img.shields.io/badge/python-3.10--3.13-blue)](https://python.org)
[![OWASP MASVS](https://img.shields.io/badge/OWASP-MASVS%20v2-green)](https://mas.owasp.org/MASVS/)

MobileSec est un framework open-source d'analyse de sécurité automatisée ciblant les vulnérabilités d'**authentification** et de **gestion de session** dans les applications Android. Il combine décompilation statique (JADX), tests dynamiques d'API, inspection OWASP des cookies, analyse du stockage Android, analyse avancée des sessions, et remédiation assistée par l'API Claude.

> Évalué sur InsecureBankv2 et DVBA : **145 findings détectés**, rappel **0,92**, F1 **0,52**.

---

## Métadonnées

| Nr. | Description | Information |
|-----|-------------|-------------|
| C1 | Version | v2.0 |
| C2 | Dépôt GitHub | https://github.com/IliassCyber/mini-projet-android |
| C3 | Licence | MIT License |
| C4 | Versionnage | Git |
| C5 | Langages & outils | Python 3.13, JADX 1.5.5, Flask 3.0, mitmproxy 10.2, API Anthropic Claude, PyJWT 2.8 |
| C6 | Prérequis | Windows 10 / Ubuntu 22.04, Python 3.10–3.13, JADX dans le PATH, Docker 24.0+ |
| C7 | Documentation | [README.md](README.md) |
| C8 | Tag release | v2.0 |

---

## Architecture — Pipeline 7 Modules

```
APK (fichier d'entrée)
 │
 ▼
[1] Static Analyzer      — JADX + 12 patterns regex (CRITIQUE / ÉLEVÉ / MOYEN)
 │  auth_type + findings[]
 ▼
[2] Dynamic Analyzer     — Tests HTTP directs (JWT replay, brute force, logout)
 │  dynamic_findings[]
 ▼
[3] Cookie Scanner       — 7 contrôles OWASP Set-Cookie (HttpOnly, Secure, SameSite…)
 │  cookie_findings[]
 ▼
[4] Storage Scanner      — 8 patterns stockage (SharedPrefs, Keystore, SQLite)
 │  storage_findings[]
 ▼
[5] Session Scanner      — 6 tests MASVS-AUTH (entropie, fixation, timeout, logout)
 │  session_findings[]
 ▼
[6] AI Engine            — Claude API → Checklist MASVS + critères Gherkin + résumé
 │  checklist + criteria + summary
 ▼
[7] Report Generator     — PDF 9 sections + JSON structuré
    ↓             ↓
 rapport.pdf   results.json
```

| Module | Fichier | Technologie | MASVS couverts |
|--------|---------|-------------|----------------|
| Static Analyzer | `static_analyzer.py` | JADX 1.5.5 + regex | STORAGE-1/2, CRYPTO-1, NETWORK-1/2 |
| Dynamic Analyzer | `dynamic_analyzer.py` | requests HTTP | AUTH-001, AUTH-007, AUTH-008 |
| Cookie Scanner | `cookie_scanner.py` | mitmproxy 10.2 | NETWORK-1, NETWORK-2 |
| Storage Scanner | `storage_scanner.py` | JADX + ADB | STORAGE-1, STORAGE-2 |
| Session Scanner | `session_scanner.py` | requests HTTP | AUTH-002 à AUTH-006 |
| AI Engine | `ai_engine.py` | Claude API | Tous domaines |
| Report Generator | `report_generator.py` | FPDF2 | — |

---

## Démarrage rapide

### Option A — Docker (recommandé)

```bash
# 1. Copier et configurer les variables d'environnement
cp .env.example .env
# Éditer .env : renseigner ANTHROPIC_API_KEY

# 2. Démarrer toute la stack (MobileSec UI + DVBA + InsecureBankv2)
docker compose up --build

# 3. Ouvrir l'interface web
# http://localhost:5000
```

### Option B — Installation locale

```bash
# 1. Créer l'environnement virtuel
python -m venv .venv
# Windows :
.venv\Scripts\activate
# Linux/macOS :
source .venv/bin/activate

# 2. Installer les dépendances Python
pip install -r requirements.txt

# 3. Configurer la clé API
cp .env.example .env    # puis éditer .env

# 4. Démarrer le backend DVBA (Docker Compose)
cd Damn-Vulnerable-Bank/BackendServer && docker compose up -d && cd ../..

# 5. Démarrer le backend InsecureBankv2
cd Android-InsecureBankv2/AndroLabServer && pip install flask sqlalchemy simplejson && python app.py &

# 6. Lancer l'interface web
python web_server.py
# → http://localhost:5000

# Ou directement en ligne de commande :
python main.py --apk apks/dvba.apk
python main.py --apk apks/app-debug.apk
```

### Script de reproduction automatique

```bash
# Linux / macOS
chmod +x reproduce.sh && ./reproduce.sh

# Windows
reproduce.bat
```

---

## Prérequis

| Outil | Version | Installation |
|-------|---------|-------------|
| Python | 3.10 – 3.13 | [python.org](https://python.org) |
| JADX | 1.5.5 | `scoop install extras/jadx` (Windows) |
| Java | 11+ | Requis par JADX |
| Docker | 24.0+ | [docker.com](https://docker.com) |
| Docker Compose | v2+ | Inclus dans Docker Desktop |

```bash
# Vérifier les installations
python --version    # Python 3.x.x
jadx --version      # jadx - dex to java decompiler, version: 1.5.5
java --version
docker --version
```

---

## Structure du projet

```
mini-projet-android/
│
├── apks/                           # APKs benchmark (versionnés)
│   ├── dvba.apk                   # Damn Vulnerable Bank — JWT
│   └── app-debug.apk              # InsecureBankv2 — Session Cookie
│
├── Android-InsecureBankv2/         # Backend InsecureBankv2
│   └── AndroLabServer/            # Flask/Python — port 8888
│
├── Damn-Vulnerable-Bank/           # Backend DVBA
│   └── BackendServer/             # Node.js + MySQL — port 3000
│
├── templates/                      # Templates HTML (interface web)
├── results/                        # Rapports générés (gitignored)
├── output/                         # Sources décompilées JADX (gitignored)
│
├── static_analyzer.py             # Module 1 — Analyse statique
├── dynamic_analyzer.py            # Module 2 — Analyse dynamique
├── cookie_scanner.py              # Module 3 — Scanner cookies OWASP
├── storage_scanner.py             # Module 4 — Scanner stockage Android
├── session_scanner.py             # Module 5 — Scanner session avancé
├── ai_engine.py                   # Module 6 — Moteur IA (Claude API)
├── report_generator.py            # Module 7 — Générateur de rapports
├── main.py                        # Orchestrateur CLI pipeline
├── web_server.py                  # Interface web Flask (port 5000)
├── addon.py                       # Add-on mitmproxy (interception trafic)
│
├── Dockerfile                     # Image MobileSec (analyzer + web UI)
├── docker-compose.yml             # Stack complète 4 services
├── reproduce.sh                   # Script de reproduction Linux/macOS
├── reproduce.bat                  # Script de reproduction Windows
├── requirements.txt               # Dépendances Python
├── LICENSE                        # MIT License
├── .env.example                   # Template variables d'environnement
└── .gitignore
```

---

## APKs benchmark

### `dvba.apk` — Damn Vulnerable Bank (JWT)

- **Authentification** : JWT, backend Node.js + MySQL (port 3000)
- **Vulnérabilités connues** : JWT sans champ `exp`, token rejouable post-logout, secret JWT codé en dur, token stocké en clair dans SharedPreferences
- **Résultats MobileSec v2.0** : 58 findings · score global 0/10 · MASVS-AUTH 1/10

### `app-debug.apk` — InsecureBankv2 v2.3.1 (Session Cookie)

- **Authentification** : Cookies de session, backend Flask Python (port 8888)
- **Vulnérabilités connues** : credentials envoyés en HTTP clair, accès sans auth (`/getaccounts`), absence de rate limiting, session fixation
- **Résultats MobileSec v2.0** : 87 findings · score global 0/10 · MASVS-AUTH 5/10

---

## Infrastructure Docker

Le `docker-compose.yml` orchestre 4 services sur un réseau interne `security-net` :

| Service | Port | Description |
|---------|------|-------------|
| `mobilesec` | 5000 | Interface web + pipeline d'analyse Python |
| `dvba-backend` | 3000 | Backend Node.js DVBA |
| `mysql` | 3306 | Base de données MySQL 8.0 (DVBA) |
| `insecurebank` | 8888 | Backend Flask InsecureBankv2 |

```bash
# Démarrer
docker compose up -d

# Vérifier les services
docker compose ps

# Lancer une analyse depuis le conteneur
docker compose exec mobilesec python main.py --apk apks/dvba.apk

# Arrêter
docker compose down
```

Les URLs des backends sont configurables via variables d'environnement :
- `DVBA_URL` (défaut : `http://localhost:3000`)
- `INSECURE_URL` (défaut : `http://localhost:8888`)

---

## Interface web

```bash
python web_server.py   # → http://localhost:5000
```

1. Uploader un APK via le formulaire
2. Choisir le mode d'analyse (`--skip-dynamic`, `--static-only`)
3. Suivre les logs en temps réel
4. Télécharger le rapport PDF généré

---

## CLI — Commandes

```bash
# Analyse complète (statique + dynamique + IA + rapport)
python main.py --apk apks/dvba.apk
python main.py --apk apks/app-debug.apk

# Sans analyse dynamique
python main.py --apk apks/dvba.apk --skip-dynamic

# Analyse statique uniquement (pas de clé API requise)
python main.py --apk apks/dvba.apk --static-only

# Mode démo (aucun outil externe requis)
python main.py --apk apks/dvba.apk --demo
```

| Flag | Description |
|------|-------------|
| `--apk <chemin>` | Chemin vers l'APK à analyser (**obligatoire**) |
| `--skip-dynamic` | Ignore les tests dynamiques API |
| `--static-only` | Analyse statique uniquement (pas d'IA) |
| `--demo` | Données pré-calculées, aucun outil requis |
| `--output-dir` | Dossier décompilation JADX (défaut : `output/`) |
| `--results-dir` | Dossier des rapports (défaut : `results/`) |

---

## Résultats de l'évaluation (v2.0)

Environnement : Windows 10 Pro, Python 3.13, JADX 1.5.5, 3 répétitions.

| Métrique | InsecureBankv2 | DVBA | Combiné |
|----------|---------------|------|---------|
| Findings détectés | 87 | 58 | **145** |
| Vrais positifs (TP) | 14 | 8 | 22 |
| Faux positifs (FP, libs tierces) | 28 | 12 | 40 |
| Précision | 0,33 | 0,40 | **0,36** |
| Rappel | 0,93 | 0,89 | **0,92** |
| Score F1 | 0,49 | 0,55 | **0,52** |
| Temps de scan moyen | 48 ± 3 s | 41 ± 2 s | 44,5 s |

> La précision de 0,36 reflète les faux positifs provenant des bibliothèques tierces (Google GMS, AndroidX). Le rappel élevé (0,92) est la priorité pour un outil d'audit de sécurité.

### Comparaison MobileSec v2.0 vs MobSF v3.9.7

| Critère | MobileSec v2.0 | MobSF 3.9.7 |
|---------|---------------|-------------|
| Total findings (2 APKs) | **145** | ≈ 63 |
| Tests logout serveur | ✓ CRITIQUE détecté | ✗ Non testé |
| Token JWT sans `exp` | ✓ CRITIQUE détecté | ✗ Non testé |
| Flags cookies OWASP | ✓ 7 contrôles | ✗ Non |
| Tests session avancés (MASVS-AUTH) | ✓ 12 tests | ✗ Non |
| Remédiation guidée par IA | ✓ Checklist 12+ items | ✗ Non |
| Critères Gherkin par type d'auth | ✓ | ✗ |
| IDs MASVS couverts | **13/14** | ≈ 5 |

---

## Scores MASVS

| Score | Niveau | Interprétation |
|-------|--------|----------------|
| 0 – 3 | CRITIQUE | Vulnérabilités exploitables immédiatement |
| 4 – 6 | ÉLEVÉ | Corrections prioritaires requises |
| 7 – 10 | ACCEPTABLE | Niveau de sécurité satisfaisant |

**Domaines évalués :**
- `MASVS-AUTH` — Authentification et gestion de session (AUTH-001 à AUTH-008)
- `MASVS-STORAGE` — Stockage sécurisé des données sensibles
- `MASVS-CRYPTO` — Algorithmes cryptographiques (MD5, AES/ECB…)
- `MASVS-NETWORK` — Sécurité des communications réseau

---

## Gestion des erreurs

| Module | Erreur possible | Comportement |
|--------|-----------------|--------------|
| `static_analyzer` | JADX absent du PATH | Warning + arrêt propre |
| `dynamic_analyzer` | Backend inaccessible | Warning + skip dynamique |
| `cookie_scanner` | mitmproxy non lancé | Warning + score = N/A |
| `storage_scanner` | Décompilation partielle | Analyse des fichiers disponibles |
| `session_scanner` | Token manquant | Tests marqués N/A |
| `ai_engine` | Clé API absente | Checklist statique de base |
| `report_generator` | Chemin invalide | Erreur fatale + message utilisateur |

---

## Troubleshooting

### JADX introuvable
```
ERR JADX introuvable
```
```bash
# Windows (Scoop)
scoop bucket add extras && scoop install extras/jadx

# Linux
wget https://github.com/skylot/jadx/releases/download/v1.5.5/jadx-1.5.5.zip
unzip jadx-1.5.5.zip -d /opt/jadx
export PATH="/opt/jadx/bin:$PATH"
```

### Backend inaccessible
```
!! Backend inaccessible — analyse dynamique ignorée
```
- **DVBA** : `docker compose up -d` dans `Damn-Vulnerable-Bank/BackendServer/`
- **InsecureBankv2** : `python app.py` dans `Android-InsecureBankv2/AndroLabServer/`
- Tester : `curl http://localhost:3000` / `curl http://localhost:8888`

### Clé API Claude invalide
```
Erreur IA : Error code: 401 - invalid x-api-key
```
- Vérifier que `.env` contient `ANTHROPIC_API_KEY=sk-ant-...`
- Vérifier le solde sur https://console.anthropic.com → Billing

### PDF verrouillé (Windows)
```
PermissionError: [Errno 13] Permission denied: 'results/dvba_report.pdf'
```
Fermer le PDF dans le lecteur avant de relancer.

---

## Dépendances Python

```
anthropic>=0.21        # Claude API
mitmproxy>=10.2        # Interception trafic HTTP (cookie scanner)
requests               # Tests API dynamiques
fpdf2>=2.7             # Génération PDF
python-dotenv          # Chargement .env
colorama               # Couleurs terminal
PyJWT>=2.8             # Décodage/vérification JWT
flask                  # Interface web
```

---

## Licence

MIT License — voir [LICENSE](LICENSE)

---

## Auteurs

Hafssa Chaoulid, Iliass Chbani, Jihad Dahouas, Sayf Eddine Laamri, Mohamed Lachgar  
*Université Cadi Ayyad, École Nationale des Sciences Appliquées, Marrakech, Maroc*
