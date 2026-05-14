package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.internal.zzb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzv implements com.google.android.gms.internal.zzb {
    private final int zzaA;
    private final Map<String, zza> zzax;
    private long zzay;
    private final File zzaz;

    static class zza {
        public long zzaB;
        public String zzaC;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map<String, String> zzg;

        private zza() {
        }

        public zza(String str, zzb.zza zzaVar) {
            this.zzaC = str;
            this.zzaB = zzaVar.data.length;
            this.zzb = zzaVar.zzb;
            this.zzc = zzaVar.zzc;
            this.zzd = zzaVar.zzd;
            this.zze = zzaVar.zze;
            this.zzf = zzaVar.zzf;
            this.zzg = zzaVar.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zzaVar = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zzaVar.zzaC = zzv.zzd(inputStream);
            zzaVar.zzb = zzv.zzd(inputStream);
            if (zzaVar.zzb.equals("")) {
                zzaVar.zzb = null;
            }
            zzaVar.zzc = zzv.zzc(inputStream);
            zzaVar.zzd = zzv.zzc(inputStream);
            zzaVar.zze = zzv.zzc(inputStream);
            zzaVar.zzf = zzv.zzc(inputStream);
            zzaVar.zzg = zzv.zze(inputStream);
            return zzaVar;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaC);
                zzv.zza(outputStream, this.zzb == null ? "" : this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(outputStream, this.zzf);
                zzv.zza(this.zzg, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zzb = this.zzb;
            zzaVar.zzc = this.zzc;
            zzaVar.zzd = this.zzd;
            zzaVar.zze = this.zze;
            zzaVar.zzf = this.zzf;
            zzaVar.zzg = this.zzg;
            return zzaVar;
        }
    }

    private static class zzb extends FilterInputStream {
        private int zzaD;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaD = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.zzaD++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.zzaD += i3;
            }
            return i3;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0L;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String str) {
        zza zzaVar = this.zzax.get(str);
        if (zzaVar != null) {
            this.zzay -= zzaVar.zzaB;
            this.zzax.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zzaVar) {
        if (this.zzax.containsKey(str)) {
            this.zzay += zzaVar.zzaB - this.zzax.get(str).zzaB;
        } else {
            this.zzay += zzaVar.zzaB;
        }
        this.zzax.put(str, zzaVar);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            zza(outputStream, 0);
            return;
        }
        zza(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zza(outputStream, entry.getKey());
            zza(outputStream, entry.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return ((((long) zza(inputStream)) & 255) << 0) | 0 | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private void zzc(int i) {
        long j;
        long j2 = i;
        if (this.zzay + j2 < this.zzaA) {
            return;
        }
        if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.zzay;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, zza>> it = this.zzax.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zza value = it.next().getValue();
            if (zzf(value.zzaC).delete()) {
                j = j2;
                this.zzay -= value.zzaB;
            } else {
                j = j2;
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", value.zzaC, zze(value.zzaC));
            }
            it.remove();
            i2++;
            if (this.zzay + j < this.zzaA * 0.9f) {
                break;
            } else {
                j2 = j;
            }
        }
        if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int iZzb = zzb(inputStream);
        Map<String, String> mapEmptyMap = iZzb == 0 ? Collections.emptyMap() : new HashMap<>(iZzb);
        for (int i = 0; i < iZzb; i++) {
            mapEmptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return mapEmptyMap;
    }

    public synchronized void remove(String str) {
        boolean zDelete = zzf(str).delete();
        removeEntry(str);
        if (!zDelete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r8.zzax     // Catch: java.lang.Throwable -> L70
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.Throwable -> L70
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch: java.lang.Throwable -> L70
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r8)
            return r1
        Le:
            java.io.File r2 = r8.zzf(r9)     // Catch: java.lang.Throwable -> L70
            com.google.android.gms.internal.zzv$zzb r3 = new com.google.android.gms.internal.zzv$zzb     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            com.google.android.gms.internal.zzv.zza.zzf(r3)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            long r4 = r2.length()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            int r6 = com.google.android.gms.internal.zzv.zzb.zza(r3)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            long r6 = (long) r6     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            long r4 = r4 - r6
            int r5 = (int) r4     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            byte[] r4 = zza(r3, r5)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            com.google.android.gms.internal.zzb$zza r9 = r0.zzb(r4)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L65
            r3.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L70
            monitor-exit(r8)
            return r9
        L37:
            r9 = move-exception
            monitor-exit(r8)
            return r1
        L3a:
            r0 = move-exception
            goto L41
        L3c:
            r9 = move-exception
            r3 = r1
            goto L66
        L3f:
            r0 = move-exception
            r3 = r1
        L41:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L65
            r6 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L65
            r5[r6] = r2     // Catch: java.lang.Throwable -> L65
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L65
            r5[r2] = r0     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch: java.lang.Throwable -> L65
            r8.remove(r9)     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.io.IOException -> L60 java.lang.Throwable -> L70
            goto L63
        L60:
            r9 = move-exception
            monitor-exit(r8)
            return r1
        L63:
            monitor-exit(r8)
            return r1
        L65:
            r9 = move-exception
        L66:
            if (r3 == 0) goto L6f
            r3.close()     // Catch: java.io.IOException -> L6c java.lang.Throwable -> L70
            goto L6f
        L6c:
            r9 = move-exception
            monitor-exit(r8)
            return r1
        L6f:
            throw r9     // Catch: java.lang.Throwable -> L70
        L70:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza() {
        BufferedInputStream bufferedInputStream;
        if (!this.zzaz.exists()) {
            if (!this.zzaz.mkdirs()) {
                zzs.zzc("Unable to create cache dir %s", this.zzaz.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.zzaz.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
            }
            try {
                zza zzaVarZzf = zza.zzf(bufferedInputStream);
                zzaVarZzf.zzaB = file.length();
                zza(zzaVarZzf.zzaC, zzaVarZzf);
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                bufferedInputStream2 = bufferedInputStream;
                if (file != null) {
                    file.delete();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zzaVar) {
        zzc(zzaVar.data.length);
        File fileZzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileZzf);
            zza zzaVar2 = new zza(str, zzaVar);
            if (!zzaVar2.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zzaVar.data);
            fileOutputStream.close();
            zza(str, zzaVar2);
        } catch (IOException e) {
            if (fileZzf.delete()) {
                return;
            }
            zzs.zzb("Could not clean up file %s", fileZzf.getAbsolutePath());
        }
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
