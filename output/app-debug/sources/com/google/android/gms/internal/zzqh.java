package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqf;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class zzqh {
    public static final Integer zzaPM = 0;
    public static final Integer zzaPN = 1;
    private final Context mContext;
    private final ExecutorService zzaNb;

    public zzqh(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzqh(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaNb = executorService;
    }

    private String zzfc(String str) {
        return "resource_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [byte[]] */
    private byte[] zzm(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                zzlg.zza((InputStream) inputStream, byteArrayOutputStream);
            } catch (IOException e) {
                com.google.android.gms.tagmanager.zzbg.zzaC("Failed to read the resource from disk");
            } finally {
            }
            inputStream = byteArrayOutputStream.toByteArray();
            return inputStream;
        } catch (IOException e2) {
            com.google.android.gms.tagmanager.zzbg.zzaC("Error closing stream for reading resource from disk");
            return null;
        }
    }

    public void zza(final String str, final Integer num, final zzqb zzqbVar, final zzqg zzqgVar) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.internal.zzqh.1
            @Override // java.lang.Runnable
            public void run() {
                zzqh.this.zzb(str, num, zzqbVar, zzqgVar);
            }
        });
    }

    void zzb(String str, Integer num, zzqb zzqbVar, zzqg zzqgVar) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        Object objZzt;
        com.google.android.gms.tagmanager.zzbg.zzaB("DiskLoader: Starting to load resource from Disk.");
        try {
            Object objZzt2 = zzqbVar.zzt(zzm(new FileInputStream(zzfb(str))));
            if (objZzt2 != null) {
                com.google.android.gms.tagmanager.zzbg.zzaB("Saved resource loaded: " + zzfc(str));
                zzqgVar.zza(Status.zzXP, objZzt2, zzaPN, zzfa(str));
                return;
            }
        } catch (zzqf.zzg e) {
            sb = new StringBuilder();
            str2 = "Saved resource is corrupted: ";
            sb.append(str2);
            sb.append(zzfc(str));
            com.google.android.gms.tagmanager.zzbg.zzaz(sb.toString());
        } catch (FileNotFoundException e2) {
            sb = new StringBuilder();
            str2 = "Saved resource not found: ";
            sb.append(str2);
            sb.append(zzfc(str));
            com.google.android.gms.tagmanager.zzbg.zzaz(sb.toString());
        }
        if (num != null) {
            try {
                InputStream inputStreamOpenRawResource = this.mContext.getResources().openRawResource(num.intValue());
                if (inputStreamOpenRawResource != null && (objZzt = zzqbVar.zzt(zzm(inputStreamOpenRawResource))) != null) {
                    com.google.android.gms.tagmanager.zzbg.zzaB("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                    zzqgVar.zza(Status.zzXP, objZzt, zzaPM, 0L);
                    return;
                }
            } catch (Resources.NotFoundException e3) {
                sb2 = new StringBuilder();
                str3 = "Default resource not found. ID: ";
                sb2.append(str3);
                sb2.append(num);
                com.google.android.gms.tagmanager.zzbg.zzaz(sb2.toString());
            } catch (zzqf.zzg e4) {
                sb2 = new StringBuilder();
                str3 = "Default resource resource is corrupted: ";
                sb2.append(str3);
                sb2.append(num);
                com.google.android.gms.tagmanager.zzbg.zzaz(sb2.toString());
            }
        }
        zzqgVar.zza(Status.zzXR, null, null, 0L);
    }

    public void zze(final String str, final byte[] bArr) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.internal.zzqh.2
            @Override // java.lang.Runnable
            public void run() {
                zzqh.this.zzf(str, bArr);
            }
        });
    }

    void zzf(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileZzfb = zzfb(str);
        try {
            try {
                fileOutputStream = new FileOutputStream(fileZzfb);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        str = "Resource " + str + " saved on Disk.";
                        com.google.android.gms.tagmanager.zzbg.zzaB(str);
                    } catch (IOException e) {
                        str = "Error closing stream for writing resource to disk";
                        com.google.android.gms.tagmanager.zzbg.zzaz("Error closing stream for writing resource to disk");
                    }
                } catch (IOException e2) {
                    com.google.android.gms.tagmanager.zzbg.zzaz("Error writing resource to disk. Removing resource from disk");
                    fileZzfb.delete();
                    fileOutputStream.close();
                    str = "Resource " + str + " saved on Disk.";
                    com.google.android.gms.tagmanager.zzbg.zzaB(str);
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    com.google.android.gms.tagmanager.zzbg.zzaB("Resource " + str + " saved on Disk.");
                } catch (IOException e3) {
                    com.google.android.gms.tagmanager.zzbg.zzaz("Error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e4) {
            com.google.android.gms.tagmanager.zzbg.zzaz("Error opening resource file for writing");
        }
    }

    public long zzfa(String str) {
        File fileZzfb = zzfb(str);
        if (fileZzfb.exists()) {
            return fileZzfb.lastModified();
        }
        return 0L;
    }

    File zzfb(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzfc(str));
    }
}
