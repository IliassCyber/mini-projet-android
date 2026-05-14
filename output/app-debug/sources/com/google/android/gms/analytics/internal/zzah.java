package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class zzah extends zzd {
    private static final byte[] zzMs = "\n".getBytes();
    private final String zzFP;
    private final zzaj zzMr;

    private class zza {
        private int zzMt;
        private ByteArrayOutputStream zzMu = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzMu.toByteArray();
        }

        public boolean zzj(zzab zzabVar) {
            com.google.android.gms.common.internal.zzu.zzu(zzabVar);
            if (this.zzMt + 1 > zzah.this.zzhR().zzji()) {
                return false;
            }
            String strZza = zzah.this.zza(zzabVar, false);
            if (strZza == null) {
                zzah.this.zzhQ().zza(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = strZza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzhR().zzja()) {
                zzah.this.zzhQ().zza(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzMu.size() > 0) {
                length++;
            }
            if (this.zzMu.size() + length > zzah.this.zzhR().zzjc()) {
                return false;
            }
            try {
                if (this.zzMu.size() > 0) {
                    this.zzMu.write(zzah.zzMs);
                }
                this.zzMu.write(bytes);
                this.zzMt++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzkj() {
            return this.zzMt;
        }
    }

    zzah(zzf zzfVar) {
        super(zzfVar);
        this.zzFP = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzMr = new zzaj(zzfVar.zzhP());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.net.URL] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int zza(java.net.URL r4, byte[] r5) throws java.lang.Throwable {
        /*
            r3 = this;
            com.google.android.gms.common.internal.zzu.zzu(r4)
            com.google.android.gms.common.internal.zzu.zzu(r5)
            java.lang.String r0 = "POST bytes, url"
            int r1 = r5.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.zzb(r0, r1, r4)
            boolean r0 = r3.zzhZ()
            if (r0 == 0) goto L20
            java.lang.String r0 = "Post payload\n"
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
            r3.zza(r0, r1)
        L20:
            r0 = 0
            java.net.HttpURLConnection r4 = r3.zzc(r4)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6b
            r1 = 1
            r4.setDoOutput(r1)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            int r1 = r5.length     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.setFixedLengthStreamingMode(r1)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.connect()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            java.io.OutputStream r0 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r0.write(r5)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r3.zzb(r4)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            int r5 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 != r1) goto L49
            com.google.android.gms.analytics.internal.zzb r1 = r3.zzhl()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r1.zzhL()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
        L49:
            java.lang.String r1 = "POST status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r3.zzb(r1, r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            if (r0 == 0) goto L5e
            r0.close()     // Catch: java.io.IOException -> L58
            goto L5e
        L58:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r3.zze(r1, r0)
        L5e:
            if (r4 == 0) goto L63
            r4.disconnect()
        L63:
            return r5
        L64:
            r5 = move-exception
            goto L85
        L66:
            r5 = move-exception
            goto L6d
        L68:
            r5 = move-exception
            r4 = r0
            goto L85
        L6b:
            r5 = move-exception
            r4 = r0
        L6d:
            java.lang.String r1 = "Network POST connection error"
            r3.zzd(r1, r5)     // Catch: java.lang.Throwable -> L64
            r5 = 0
            if (r0 == 0) goto L7f
            r0.close()     // Catch: java.io.IOException -> L79
            goto L7f
        L79:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r3.zze(r1, r0)
        L7f:
            if (r4 == 0) goto L84
            r4.disconnect()
        L84:
            return r5
        L85:
            if (r0 == 0) goto L91
            r0.close()     // Catch: java.io.IOException -> L8b
            goto L91
        L8b:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r3.zze(r1, r0)
        L91:
            if (r4 == 0) goto L96
            r4.disconnect()
        L96:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        com.google.android.gms.common.internal.zzu.zzu(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnectionZzc = null;
        try {
            try {
                httpURLConnectionZzc = zzc(url);
                httpURLConnectionZzc.connect();
                zzb(httpURLConnectionZzc);
                int responseCode = httpURLConnectionZzc.getResponseCode();
                if (responseCode == 200) {
                    zzhl().zzhL();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnectionZzc != null) {
                    httpURLConnectionZzc.disconnect();
                }
                return responseCode;
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                if (httpURLConnectionZzc != null) {
                    httpURLConnectionZzc.disconnect();
                }
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnectionZzc != null) {
                httpURLConnectionZzc.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int zzb(java.net.URL r10, byte[] r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzabVar, String str) {
        StringBuilder sb;
        String strZzjl;
        if (zzabVar.zzjY()) {
            sb = new StringBuilder();
            strZzjl = zzhR().zzjk();
        } else {
            sb = new StringBuilder();
            strZzjl = zzhR().zzjl();
        }
        sb.append(strZzjl);
        sb.append(zzhR().zzjm());
        sb.append("?");
        sb.append(str);
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void zzb(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zze("Error closing http connection input stream", e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http connection input stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private boolean zzg(zzab zzabVar) {
        String str;
        zzaf zzafVarZzhQ;
        String str2;
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        String strZza = zza(zzabVar, !zzabVar.zzjY());
        if (strZza != null) {
            if (strZza.length() <= zzhR().zziZ()) {
                URL urlZzb = zzb(zzabVar, strZza);
                if (urlZzb != null) {
                    return zzb(urlZzb) == 200;
                }
                str = "Failed to build collect GET endpoint url";
            } else {
                String strZza2 = zza(zzabVar, false);
                if (strZza2 == null) {
                    zzafVarZzhQ = zzhQ();
                    str2 = "Error formatting hit for POST upload";
                } else {
                    byte[] bytes = strZza2.getBytes();
                    if (bytes.length > zzhR().zzjb()) {
                        zzafVarZzhQ = zzhQ();
                        str2 = "Hit payload exceeds size limit";
                    } else {
                        URL urlZzh = zzh(zzabVar);
                        if (urlZzh != null) {
                            return zza(urlZzh, bytes) == 200;
                        }
                        str = "Failed to build collect POST endpoint url";
                    }
                }
            }
            zzaX(str);
            return false;
        }
        zzafVarZzhQ = zzhQ();
        str2 = "Error formatting hit for upload";
        zzafVarZzhQ.zza(zzabVar, str2);
        return true;
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzabVar) {
        StringBuilder sb;
        String strZzjl;
        if (zzabVar.zzjY()) {
            sb = new StringBuilder();
            strZzjl = zzhR().zzjk();
        } else {
            sb = new StringBuilder();
            strZzjl = zzhR().zzjl();
        }
        sb.append(strZzjl);
        sb.append(zzhR().zzjm());
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzabVar) {
        return String.valueOf(zzabVar.zzjV());
    }

    private URL zzkh() {
        try {
            return new URL(zzhR().zzjk() + zzhR().zzjn());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzabVar.zzjW()));
            zza(sb, "qt", String.valueOf(zzhP().currentTimeMillis() - zzabVar.zzjW()));
            if (zzhR().zziW()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long jZzjZ = zzabVar.zzjZ();
                zza(sb, "z", jZzjZ != 0 ? String.valueOf(jZzjZ) : zzi(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzab> list, boolean z) {
        com.google.android.gms.common.internal.zzu.zzV(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zzaVar = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzabVar : list) {
            if (!zzaVar.zzj(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
        }
        if (zzaVar.zzkj() == 0) {
            return arrayList;
        }
        URL urlZzkh = zzkh();
        if (urlZzkh == null) {
            zzaX("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int iZzb = z ? zzb(urlZzkh, zzaVar.getPayload()) : zza(urlZzkh, zzaVar.getPayload());
        if (200 == iZzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zzaVar.zzkj()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(iZzb));
        if (zzhR().zzjq().contains(Integer.valueOf(iZzb))) {
            zzaW("Server instructed the client to stop batching");
            this.zzMr.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzhR().zzjz());
        httpURLConnection.setReadTimeout(zzhR().zzjA());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzFP);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> zzf(List<zzab> list) {
        boolean z;
        zzhO();
        zzia();
        com.google.android.gms.common.internal.zzu.zzu(list);
        boolean z2 = false;
        if (zzhR().zzjq().isEmpty() || !this.zzMr.zzv(zzhR().zzjj() * 1000)) {
            z = false;
        } else {
            z = zzhR().zzjo() != zzm.NONE;
            if (zzhR().zzjp() == zzo.GZIP) {
                z2 = true;
            }
        }
        return z ? zza(list, z2) : zzg(list);
    }

    List<Long> zzg(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzabVar : list) {
            if (!zzg(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
            if (arrayList.size() >= zzhR().zzjh()) {
                break;
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
        zza("Network initialized. User agent", this.zzFP);
    }

    public boolean zzkg() {
        NetworkInfo activeNetworkInfo;
        zzhO();
        zzia();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzaT("No network connectivity");
        return false;
    }
}
