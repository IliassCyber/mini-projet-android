FROM python:3.13-slim

# Java (required by JADX) + download tools
RUN apt-get update && apt-get install -y --no-install-recommends \
    default-jre-headless \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Install JADX 1.5.5
RUN wget -q "https://github.com/skylot/jadx/releases/download/v1.5.5/jadx-1.5.5.zip" \
    -O /tmp/jadx.zip \
    && unzip -q /tmp/jadx.zip -d /opt/jadx \
    && rm /tmp/jadx.zip \
    && chmod +x /opt/jadx/bin/jadx

ENV PATH="/opt/jadx/bin:${PATH}"

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

RUN mkdir -p output results apks

EXPOSE 5000

CMD ["python", "web_server.py"]
