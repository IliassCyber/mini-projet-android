"""
Web Server — Auth & Session Security Analyzer
Lance une interface web pour uploader un APK et visualiser les résultats.

Usage :
  pip install flask
  python web_server.py
  Ouvrir http://localhost:5000
"""

import json
import os
import subprocess
import sys
import threading
import uuid
from datetime import datetime
from pathlib import Path

from flask import (Flask, jsonify, render_template, request,
                   send_from_directory)

app = Flask(__name__)

BASE_DIR    = Path(__file__).parent
UPLOAD_DIR  = BASE_DIR / "apks"
RESULTS_DIR = BASE_DIR / "results"
UPLOAD_DIR.mkdir(exist_ok=True)
RESULTS_DIR.mkdir(exist_ok=True)

# Stockage en mémoire des scans (id → état)
scans: dict[str, dict] = {}


# ---------------------------------------------------------------------------
# Routes
# ---------------------------------------------------------------------------

@app.route("/")
def index():
    return render_template("index.html")


@app.route("/api/scan", methods=["POST"])
def start_scan():
    """Reçoit l'APK, lance main.py en arrière-plan, renvoie un scan_id."""
    if "apk" not in request.files:
        return jsonify({"error": "Aucun fichier APK fourni"}), 400

    file = request.files["apk"]
    if not file.filename.endswith(".apk"):
        return jsonify({"error": "Le fichier doit être un .apk"}), 400

    skip_dynamic = request.form.get("skip_dynamic") == "true"
    static_only  = request.form.get("static_only")  == "true"

    scan_id  = str(uuid.uuid4())[:8]
    apk_name = f"{scan_id}_{file.filename}"
    apk_path = UPLOAD_DIR / apk_name
    file.save(apk_path)

    scans[scan_id] = {
        "id":         scan_id,
        "filename":   file.filename,
        "status":     "running",
        "started_at": datetime.now().isoformat(),
        "log":        [],
        "results":    None,
        "pdf":        None,
        "error":      None,
    }

    thread = threading.Thread(
        target=_run_scan,
        args=(scan_id, apk_path, skip_dynamic, static_only),
        daemon=True,
    )
    thread.start()

    return jsonify({"scan_id": scan_id})


@app.route("/api/scan/<scan_id>")
def scan_status(scan_id):
    """Retourne l'état courant d'un scan."""
    if scan_id not in scans:
        return jsonify({"error": "Scan introuvable"}), 404
    return jsonify(scans[scan_id])


@app.route("/api/scans")
def list_scans():
    """Liste tous les scans (historique)."""
    ordered = sorted(scans.values(), key=lambda s: s["started_at"], reverse=True)
    return jsonify(ordered)


@app.route("/api/scan/<scan_id>/pdf")
def download_pdf(scan_id):
    """Télécharge le rapport PDF."""
    scan = scans.get(scan_id)
    if not scan or not scan.get("pdf"):
        return jsonify({"error": "PDF non disponible"}), 404
    pdf_path = Path(scan["pdf"])
    return send_from_directory(pdf_path.parent, pdf_path.name, as_attachment=True)


# ---------------------------------------------------------------------------
# Logique de scan (thread)
# ---------------------------------------------------------------------------

def _run_scan(scan_id: str, apk_path: Path, skip_dynamic: bool, static_only: bool):
    scan = scans[scan_id]
    apk_stem = apk_path.stem  # ex: "abc123_dvba"

    cmd = [sys.executable, str(BASE_DIR / "main.py"), "--apk", str(apk_path)]
    if skip_dynamic:
        cmd.append("--skip-dynamic")
    if static_only:
        cmd.append("--static-only")

    try:
        proc = subprocess.Popen(
            cmd,
            stdout=subprocess.PIPE,
            stderr=subprocess.STDOUT,
            text=True,
            cwd=str(BASE_DIR),
        )
        for line in proc.stdout:
            line = line.rstrip()
            if line:
                scan["log"].append(line)

        proc.wait()

        # Chercher le JSON de résultats
        # main.py nomme le fichier d'après le nom de l'APK original
        original_stem = apk_path.name.split("_", 1)[1].replace(".apk", "") if "_" in apk_path.name else apk_stem
        json_path = RESULTS_DIR / f"{original_stem}_results.json"
        pdf_path  = RESULTS_DIR / f"{original_stem}_report.pdf"

        # Fallback : chercher n'importe quel JSON récent
        if not json_path.exists():
            jsons = sorted(RESULTS_DIR.glob("*_results.json"), key=os.path.getmtime, reverse=True)
            if jsons:
                json_path = jsons[0]
                pdf_path  = Path(str(json_path).replace("_results.json", "_report.pdf"))

        if json_path.exists():
            with open(json_path, encoding="utf-8") as f:
                scan["results"] = json.load(f)

        if pdf_path.exists():
            scan["pdf"] = str(pdf_path)

        scan["status"]     = "done" if proc.returncode == 0 else "error"
        scan["ended_at"]   = datetime.now().isoformat()

    except Exception as e:
        scan["status"] = "error"
        scan["error"]  = str(e)
        scan["ended_at"] = datetime.now().isoformat()


# ---------------------------------------------------------------------------
# Lancement
# ---------------------------------------------------------------------------

if __name__ == "__main__":
    print("=" * 60)
    print("  Auth & Session Security Analyzer — Interface Web")
    print("  http://localhost:5000")
    print("=" * 60)
    app.run(debug=False, host="0.0.0.0", port=5000)