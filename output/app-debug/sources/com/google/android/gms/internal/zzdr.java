package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzdr {
    private static final Set<String> zzwF = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzwG = new DecimalFormat("#,###");
    private zzid zzoA;
    private File zzwH;
    private boolean zzwI;

    public zzdr(zzid zzidVar) {
        this.zzoA = zzidVar;
        File cacheDir = zzidVar.getContext().getCacheDir();
        if (cacheDir == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Context.getCacheDir() returned null");
            return;
        }
        this.zzwH = new File(cacheDir, "admobVideoStreams");
        if (!this.zzwH.isDirectory() && !this.zzwH.mkdirs()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not create preload cache directory at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
            return;
        }
        if (this.zzwH.setReadable(true, false) && this.zzwH.setExecutable(true, false)) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not set cache file permissions at " + this.zzwH.getAbsolutePath());
        this.zzwH = null;
    }

    private String zzX(String str) {
        return com.google.android.gms.ads.internal.client.zzk.zzcA().zzax(str);
    }

    private File zza(File file) {
        return new File(this.zzwH, file.getName() + ".done");
    }

    private void zza(final String str, final File file) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheCanceled");
                map.put("src", str);
                File file2 = file;
                if (file2 != null) {
                    map.put("cachedSrc", file2.getAbsolutePath());
                }
                zzdr.this.zzoA.zzc("onPrecacheEvent", map);
            }
        });
    }

    private void zza(final String str, final File file, final int i) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheComplete");
                map.put("src", str);
                map.put("cachedSrc", file.getAbsolutePath());
                map.put("totalBytes", Integer.toString(i));
                zzdr.this.zzoA.zzc("onPrecacheEvent", map);
            }
        });
    }

    private void zza(final String str, final File file, final int i, final int i2) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheProgress");
                map.put("src", str);
                map.put("cachedSrc", file.getAbsolutePath());
                map.put("bytesLoaded", Integer.toString(i));
                map.put("totalBytes", Integer.toString(i2));
                zzdr.this.zzoA.zzc("onPrecacheEvent", map);
            }
        });
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public void abort() {
        this.zzwI = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0219, code lost:
    
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x021b, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0223, code lost:
    
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(3) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0225, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Preloaded " + com.google.android.gms.internal.zzdr.zzwG.format(r6) + " bytes from " + r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x024a, code lost:
    
        r3.setReadable(true, false);
        zzb(r0);
        zza(r25, r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0255, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0257, code lost:
    
        com.google.android.gms.internal.zzdr.zzwF.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x025a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x025b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x025d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x025e, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0260, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fc A[Catch: IOException -> 0x00f1, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x00f1, blocks: (B:29:0x00c6, B:32:0x00d2, B:33:0x00f0, B:39:0x00fc, B:43:0x012e), top: B:125:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: IOException -> 0x026f, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x026f, blocks: (B:27:0x00a7, B:37:0x00f6, B:41:0x0119, B:45:0x0153), top: B:130:0x00a7 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean zzW(java.lang.String r25) {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdr.zzW(java.lang.String):boolean");
    }

    public int zzdQ() {
        File file = this.zzwH;
        if (file == null) {
            return 0;
        }
        int i = 0;
        for (File file2 : file.listFiles()) {
            if (!file2.getName().endsWith(".done")) {
                i++;
            }
        }
        return i;
    }

    public boolean zzdR() {
        File file = this.zzwH;
        if (file == null) {
            return false;
        }
        long j = Long.MAX_VALUE;
        File file2 = null;
        for (File file3 : file.listFiles()) {
            if (!file3.getName().endsWith(".done")) {
                long jLastModified = file3.lastModified();
                if (jLastModified < j) {
                    file2 = file3;
                    j = jLastModified;
                }
            }
        }
        if (file2 == null) {
            return false;
        }
        boolean zDelete = file2.delete();
        File fileZza = zza(file2);
        return fileZza.isFile() ? zDelete & fileZza.delete() : zDelete;
    }
}
