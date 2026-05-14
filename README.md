# Auth & Session Security Analyzer

Outil d'audit de sécurité Android qui analyse l'authentification et la gestion de session de deux APKs vulnérables, mappe les résultats sur l'OWASP MASVS et génère un rapport PDF + JSON enrichi par l'IA Claude.

**Module M44 — Sécurité des applications multimédia et Embarquée | ENSA Marrakech**

---

## Table des matières

1. [Vue d'ensemble](#vue-densemble)
2. [Prérequis](#prérequis)
3. [Installation](#installation)
4. [Structure du projet](#structure-du-projet)
5. [APKs cibles](#apks-cibles)
6. [Utilisation](#utilisation)
7. [Modules](#modules)
8. [Rapport généré](#rapport-généré)
9. [Troubleshooting](#troubleshooting)

---

## Vue d'ensemble

```
APK  ──►  [1] Analyse statique (JADX)
               ↓ findings
          [2] Analyse dynamique (API directe)
               ↓ findings
          [3] IA Claude (checklist MASVS + critères)
               ↓ résultats
          [4] Rapport PDF + JSON
```

| Module | Technologie | Rôle |
|---|---|---|
| Analyse statique | JADX + regex Python | Détecte vulnérabilités dans le bytecode |
| Analyse dynamique | requests Python | Tests JWT/API en conditions réelles |
| IA | Claude API (claude-sonnet-4-6) | Checklist MASVS + résumé exécutif |
| Rapport | fpdf2 | PDF 6 sections + JSON structuré |

---

## Prérequis

### Outils système

| Outil | Version min | Installation |
|---|---|---|
| Python | 3.8+ | [python.org](https://python.org) |
| JADX | 1.5+ | `scoop install extras/jadx` |
| ADB | 1.0.41+ | Android SDK Platform Tools |
| Java | 11+ | Requis par JADX |
| Emulateur Android | API 30+ | Android Studio → AVD Manager |

Vérifier que tout est installé :
```powershell
python --version
jadx --version
adb --version
java --version
emulator -list-avds
```

### Installation Scoop (Windows — recommandé)
```powershell
# Installer Scoop si absent
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
irm get.scoop.sh | iex

# Installer JADX
scoop bucket add extras
scoop install extras/jadx
```

### ADB sur le PATH (si absent)
```powershell
$sdk = "$env:LOCALAPPDATA\Android\Sdk"
[Environment]::SetEnvironmentVariable(
  "PATH",
  [Environment]::GetEnvironmentVariable("PATH","User") + ";$sdk\platform-tools;$sdk\emulator",
  "User"
)
# Redémarrer le terminal
```

---

## Installation

### 1. Cloner / récupérer le projet
```
mini-projet-android/
├── apks/
│   ├── dvba.apk
│   └── app-debug.apk
├── main.py
├── static_analyzer.py
├── dynamic_analyzer.py
├── ai_engine.py
├── report_generator.py
├── addon.py
├── requirements.txt
└── .env
```

### 2. Installer les dépendances Python
```powershell
pip install -r requirements.txt
```

### 3. Configurer la clé API Claude
Copier `.env.example` en `.env` et renseigner la clé :
```
ANTHROPIC_API_KEY=sk-ant-api03-VOTRE_CLE_ICI
```

Obtenir une clé sur : https://console.anthropic.com → API Keys

---

## Structure du projet

```
mini-projet-android/
│
├── apks/                        # APKs à analyser (ne pas modifier)
│   ├── dvba.apk                 # Damn Vulnerable Bank (JWT)
│   └── app-debug.apk            # InsecureBankv2 (HTTP form auth)
│
├── output/                      # Créé automatiquement — sources JADX
│   └── dvba/                    # Fichiers Java décompilés
│
├── results/                     # Créé automatiquement — rapports
│   ├── dvba_report.pdf
│   ├── dvba_results.json
│   ├── app-debug_report.pdf
│   └── app-debug_results.json
│
├── main.py                      # Point d'entrée CLI
├── static_analyzer.py           # Module 1 : JADX + regex
├── dynamic_analyzer.py          # Module 2 : tests API
├── addon.py                     # Addon mitmproxy (architecture)
├── ai_engine.py                 # Module 3 : Claude API
├── report_generator.py          # Module 4 : PDF + JSON
├── requirements.txt
├── .env                         # Clé API (ne pas versionner)
└── .env.example                 # Template
```

---

## APKs cibles

### dvba.apk — Damn Vulnerable Bank
- **Authentification** : JWT (JSON Web Token)
- **Backend** : Node.js + MySQL, port **3000**
- **Chiffrement API** : XOR + Base64 (clé `"amazing"` codée en dur)
- **Vulnérabilités connues** : JWT sans `exp`, token rejouable après logout, secret JWT codé en dur

**Démarrer le backend :**
```powershell
git clone https://github.com/rewanthtammana/Damn-Vulnerable-Bank.git
cd "Damn-Vulnerable-Bank\BackendServer"
docker-compose up --build
```
Credentials : `user1 / password1`, `admin / admin`

---

### app-debug.apk — InsecureBankv2
- **Authentification** : HTTP Form (credentials envoyés en clair à chaque requête)
- **Backend** : Python Flask, port **8888**
- **Vulnérabilités connues** : HTTP clair, pas de session, pas de rate limiting, credentials en clair

**Démarrer le backend :**
```powershell
git clone https://github.com/dineshshetty/Android-InsecureBankv2.git
cd "Android-InsecureBankv2\AndroLabServer"
pip install cheroot simplejson flask flask-sqlalchemy
python app.py
```
Credentials : `dinesh / dinesh123`

**Configurer l'émulateur Android :**
```powershell
# Lancer l'émulateur
emulator -avd Medium_Phone

# Installer l'APK
adb install apks/app-debug.apk

# Configurer l'accès au backend (tunnel ADB)
adb reverse tcp:8888 tcp:8888
```

---

## Utilisation

### Commandes principales

```powershell
# Analyse complète (statique + dynamique + IA + rapport)
python main.py --apk apks/dvba.apk
python main.py --apk apks/app-debug.apk

# Sans analyse dynamique (pas de backend nécessaire)
python main.py --apk apks/dvba.apk --skip-dynamic

# Analyse statique uniquement (pas de clé API nécessaire)
python main.py --apk apks/dvba.apk --static-only

# Mode démo (aucun outil externe requis — présentation)
python main.py --apk apks/dvba.apk --demo
python main.py --apk apks/app-debug.apk --demo

# Dossiers de sortie personnalisés
python main.py --apk apks/dvba.apk --output-dir ./decompiled --results-dir ./rapports
```

### Flags disponibles

| Flag | Description |
|---|---|
| `--apk <chemin>` | Chemin vers l'APK à analyser (**obligatoire**) |
| `--skip-dynamic` | Ignore l'analyse dynamique |
| `--static-only` | Statique uniquement (pas d'IA non plus) |
| `--demo` | Données pré-calculées, aucun outil requis |
| `--output-dir` | Dossier de décompilation JADX (défaut : `output/`) |
| `--results-dir` | Dossier des rapports (défaut : `results/`) |

### Ordre de lancement recommandé (analyse complète)

```
Terminal 1 : backend DVBA       →  docker-compose up --build
Terminal 2 : backend InsecureBank →  python app.py
Terminal 3 : émulateur          →  emulator -avd Medium_Phone
Terminal 4 : analyse            →  python main.py --apk apks/dvba.apk
```

---

## Modules

### Module 1 — Analyse statique (`static_analyzer.py`)

1. Lance JADX : `jadx -d ./output/<apk> <apk_path>`
2. Parcourt tous les fichiers `.java` et `.kt` décompilés
3. Applique des patterns regex par sévérité :

| Sévérité | Pattern détecté | Points perdus |
|---|---|---|
| CRITIQUE | JWT codé en dur (`eyJ...`) | -3 |
| CRITIQUE | Secret/password codé en dur | -3 |
| ÉLEVÉ | AES/ECB, MD5, SHA-1 | -2 |
| ÉLEVÉ | Credentials dans les logs | -2 |
| ÉLEVÉ | Token dans SharedPreferences | -2 |
| MOYEN | SSL désactivé (TrustAllCerts) | -1 |
| MOYEN | HTTP en clair | -1 |
| MOYEN | AndroidManifest : debug=true, exported=true | -1 |

4. Détecte le type d'authentification : `JWT` ou `SESSION_COOKIE`
5. Calcule le score : `10 - Σ(pénalités)`, plancher à 0

---

### Module 2 — Analyse dynamique (`dynamic_analyzer.py`)

**DVBA (Mode API_DIRECT) :**
- Chiffrement des requêtes : XOR répété avec la clé `"amazing"` + Base64
- Test 1 : Login → capture du JWT
- Test 2 : Décode le JWT → vérifie la présence du champ `exp`
- Test 3 : Logout → rejoue le même token → vérifie si le serveur le rejette
- Test 4 : Falsification du payload JWT (signature invalide)
- Test 5 : Double utilisation du refresh token

**InsecureBankv2 (Mode API_DIRECT) :**
- Test 1 : Login via HTTP (credentials en clair)
- Test 2 : Accès aux ressources sans authentification
- Test 3 : 10 tentatives de login échouées → vérifie l'absence de rate limiting
- Test 4 : Absence de mécanisme de logout côté serveur

---

### Module 3 — IA Claude (`ai_engine.py`)

- Modèle : `claude-sonnet-4-6`
- Entrée : résultats combinés statique + dynamique
- Calcule les scores MASVS par domaine (AUTH, STORAGE, CRYPTO, NETWORK)
- Génère via prompt structuré :
  - Checklist de sécurité mappée MASVS (chap. 4, 6, 7, 12, 14)
  - Critères d'acceptation ("Le système DOIT/NE DOIT PAS...")
  - Résumé exécutif objectif en français

---

### Module 4 — Rapport (`report_generator.py`)

Génère deux fichiers dans `results/` :

**`<apk>_results.json`** — données brutes complètes  
**`<apk>_report.pdf`** — rapport 6 sections :

| Section | Contenu |
|---|---|
| 1. Résumé exécutif | Paragraphe narratif généré par IA |
| 2. Analyse statique | Tableau : sévérité, type, fichier, détail |
| 3. Analyse dynamique | Résultats des tests d'API |
| 4. Scores MASVS | Barres colorées par domaine |
| 5. Checklist MASVS | Points de contrôle générés par IA |
| 6. Critères d'acceptation | User stories de sécurité |

---

## Troubleshooting

### JADX introuvable
```
ERR JADX introuvable
```
```powershell
scoop bucket add extras
scoop install extras/jadx
# Redémarrer le terminal PowerShell
jadx --version  # doit afficher 1.5.x
```

---

### Clé API invalide (401)
```
Erreur IA : Error code: 401 - invalid x-api-key
```
1. Vérifier que `.env` contient `ANTHROPIC_API_KEY=sk-ant-...`
2. Aller sur https://console.anthropic.com → vérifier que la clé est **Active**
3. Vérifier le solde de crédits dans **Settings → Billing**

---

### Backend inaccessible (analyse dynamique)
```
!! Deconnexion : non testee (backend inaccessible ?)
```
- **DVBA** : s'assurer que `docker-compose up` est lancé et que `localhost:3000` répond
- **InsecureBankv2** : s'assurer que `python app.py` tourne sur le port 8888
- Tester manuellement : `curl http://localhost:3000` ou `curl http://localhost:8888`

---

### Permission denied sur le PDF
```
PermissionError: [Errno 13] Permission denied: 'results\dvba_report.pdf'
```
Le fichier PDF est ouvert dans un lecteur (Acrobat, navigateur...). **Fermer le PDF** avant de relancer.

---

### app-debug.apk — Invalid Credentials dans l'émulateur
1. Vérifier que le tunnel ADB est actif : `adb reverse tcp:8888 tcp:8888`
2. Vérifier que le backend tourne : `python app.py`
3. Les credentials sont : `dinesh / dinesh123` (simplifié depuis `Dinesh@123$`)

---

### ADB/emulator introuvable dans PowerShell
```powershell
# Ajouter Android SDK au PATH utilisateur
$sdk = "$env:LOCALAPPDATA\Android\Sdk"
[Environment]::SetEnvironmentVariable(
  "PATH",
  [Environment]::GetEnvironmentVariable("PATH","User") + ";$sdk\platform-tools;$sdk\emulator",
  "User"
)
# Redémarrer VS Code ou PowerShell
```

---

### JADX produit 0 fichiers
- Vérifier que l'APK n'est pas corrompu : `jadx -d test/ apks/dvba.apk`
- Essayer sans l'option `--no-res` (géré automatiquement par le script)
- Vérifier que Java 11+ est installé : `java --version`

---

### InsecureBankv2 backend — SyntaxError Python 2
Le code source est en Python 2. La conversion Python 3 est déjà appliquée dans ce repo.  
Si vous reclonez le repo original, appliquer :
```powershell
cd Android-InsecureBankv2\AndroLabServer
python -m lib2to3 -w app.py database.py models.py
# Puis corriger manuellement les imports relatifs (.models → models)
```

---

## Dépendances Python

```
anthropic==0.102.0      # Claude API
mitmproxy==12.2.3       # Architecture proxy (addon.py)
requests==2.32.3        # Tests API dynamiques
fpdf2==2.8.7            # Génération PDF
python-dotenv==1.2.2    # Chargement .env
colorama==0.4.6         # Couleurs terminal
```

Installation : `pip install -r requirements.txt`

---

## Scores MASVS — Interprétation

| Score | Niveau | Signification |
|---|---|---|
| 0 — 3 | 🔴 CRITIQUE | Vulnérabilités critiques exploitables immédiatement |
| 4 — 6 | 🟠 ÉLEVÉ | Risque significatif, corrections prioritaires |
| 7 — 10 | 🟢 ACCEPTABLE | Niveau de sécurité satisfaisant |

Les domaines évalués :
- **MASVS-AUTH** — Authentification et gestion de session
- **MASVS-STORAGE** — Stockage des données sensibles
- **MASVS-CRYPTO** — Algorithmes cryptographiques
- **MASVS-NETWORK** — Sécurité des communications réseau
