package com.google.android.gms.analytics.internal;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class zzn extends zzd {
    private volatile String zzJd;
    private Future<String> zzKG;

    protected zzn(zzf zzfVar) {
        super(zzfVar);
    }

    private boolean zzg(Context context, String str) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        com.google.android.gms.common.internal.zzu.zzbZ("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                zza("Storing clientId", str);
                fileOutputStreamOpenFileOutput = context.openFileOutput("gaClientId", 0);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e) {
                        zze("Failed to close clientId writing stream", e);
                    }
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e2) {
                        zze("Failed to close clientId writing stream", e2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            zze("Error creating clientId file", e3);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    zze("Failed to close clientId writing stream", e4);
                }
            }
            return false;
        } catch (IOException e5) {
            zze("Error writing to clientId file", e5);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zziS() {
        String strZziT = zziT();
        try {
            return !zzg(zzhS().getContext(), strZziT) ? "0" : strZziT;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String zzX(android.content.Context r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.zzu.zzbZ(r0)
            r0 = 0
            java.lang.String r1 = "gaClientId"
            java.io.FileInputStream r1 = r7.openFileInput(r1)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75 java.io.FileNotFoundException -> L9c
            r2 = 36
            byte[] r2 = new byte[r2]     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            int r3 = r2.length     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            r4 = 0
            int r3 = r1.read(r2, r4, r3)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            int r5 = r1.available()     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            if (r5 <= 0) goto L36
            java.lang.String r2 = "clientId file seems corrupted, deleting it."
            r6.zzaW(r2)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            r1.close()     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            if (r1 == 0) goto L35
            r1.close()     // Catch: java.io.IOException -> L2f
            goto L35
        L2f:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L35:
            return r0
        L36:
            r5 = 14
            if (r3 >= r5) goto L54
            java.lang.String r2 = "clientId file is empty, deleting it."
            r6.zzaW(r2)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            r1.close()     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L4d
            goto L53
        L4d:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L53:
            return r0
        L54:
            r1.close()     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            java.lang.String r5 = new java.lang.String     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            r5.<init>(r2, r4, r3)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            java.lang.String r2 = "Read client id from disk"
            r6.zza(r2, r5)     // Catch: java.io.IOException -> L6e java.io.FileNotFoundException -> L70 java.lang.Throwable -> L8e
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6d
        L67:
            r7 = move-exception
            java.lang.String r0 = "Failed to close client id reading stream"
            r6.zze(r0, r7)
        L6d:
            return r5
        L6e:
            r2 = move-exception
            goto L77
        L70:
            r7 = move-exception
            goto L9e
        L72:
            r7 = move-exception
            r1 = r0
            goto L8f
        L75:
            r2 = move-exception
            r1 = r0
        L77:
            java.lang.String r3 = "Error reading client id file, deleting it"
            r6.zze(r3, r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.io.IOException -> L87
            goto L8d
        L87:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L8d:
            return r0
        L8e:
            r7 = move-exception
        L8f:
            if (r1 == 0) goto L9b
            r1.close()     // Catch: java.io.IOException -> L95
            goto L9b
        L95:
            r0 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r0)
        L9b:
            throw r7
        L9c:
            r7 = move-exception
            r1 = r0
        L9e:
            if (r1 == 0) goto Laa
            r1.close()     // Catch: java.io.IOException -> La4
            goto Laa
        La4:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.zzX(android.content.Context):java.lang.String");
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0017, B:9:0x001b, B:16:0x003a, B:18:0x003e, B:19:0x0042, B:20:0x004c, B:21:0x004e, B:12:0x0027, B:13:0x002e, B:15:0x0032), top: B:27:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String zziP() {
        /*
            r2 = this;
            r2.zzia()
            monitor-enter(r2)
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L17
            com.google.android.gms.internal.zzns r0 = r2.zzhS()     // Catch: java.lang.Throwable -> L50
            com.google.android.gms.analytics.internal.zzn$1 r1 = new com.google.android.gms.analytics.internal.zzn$1     // Catch: java.lang.Throwable -> L50
            r1.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.concurrent.Future r0 = r0.zzb(r1)     // Catch: java.lang.Throwable -> L50
            r2.zzKG = r0     // Catch: java.lang.Throwable -> L50
        L17:
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzKG     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L4c
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzKG     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            r2.zzJd = r0     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            goto L3a
        L26:
            r0 = move-exception
            java.lang.String r1 = "Failed to load or generate client id"
            r2.zze(r1, r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "0"
        L2e:
            r2.zzJd = r0     // Catch: java.lang.Throwable -> L50
            goto L3a
        L31:
            r0 = move-exception
            java.lang.String r1 = "ClientId loading or generation was interrupted"
            r2.zzd(r1, r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "0"
            goto L2e
        L3a:
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L42
            java.lang.String r0 = "0"
            r2.zzJd = r0     // Catch: java.lang.Throwable -> L50
        L42:
            java.lang.String r0 = "Loaded clientId"
            java.lang.String r1 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            r2.zza(r0, r1)     // Catch: java.lang.Throwable -> L50
            r0 = 0
            r2.zzKG = r0     // Catch: java.lang.Throwable -> L50
        L4c:
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L50
            return r0
        L50:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L50
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.zziP():java.lang.String");
    }

    String zziQ() {
        synchronized (this) {
            this.zzJd = null;
            this.zzKG = zzhS().zzb(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zziU, reason: merged with bridge method [inline-methods] */
                public String call() throws Exception {
                    return zzn.this.zziS();
                }
            });
        }
        return zziP();
    }

    String zziR() throws Throwable {
        String strZzX = zzX(zzhS().getContext());
        return strZzX == null ? zziS() : strZzX;
    }

    protected String zziT() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
