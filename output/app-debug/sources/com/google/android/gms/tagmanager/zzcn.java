package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class zzcn implements zzp.zzf {
    private final Context mContext;
    private final String zzaKy;
    private zzbf<zzpx.zza> zzaMU;
    private final ExecutorService zzaNb = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzaKy = str;
    }

    private zzqf.zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzaz.zzey(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzay("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            zzbg.zzaC("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private void zzd(zzpx.zza zzaVar) throws IllegalArgumentException {
        if (zzaVar.zziO == null && zzaVar.zzaPa == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzqf.zzc zzr(byte[] bArr) {
        try {
            zzqf.zzc zzcVarZzb = zzqf.zzb(zzaf.zzf.zzc(bArr));
            if (zzcVarZzb != null) {
                zzbg.zzaB("The container was successfully loaded from the resource (using binary file)");
            }
            return zzcVarZzb;
        } catch (zzqf.zzg e) {
            zzbg.zzaC("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzrm e2) {
            zzbg.zzaz("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        this.zzaNb.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zza(zzbf<zzpx.zza> zzbfVar) {
        this.zzaMU = zzbfVar;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzb(final zzpx.zza zzaVar) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.2
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzc(zzaVar);
            }
        });
    }

    boolean zzc(zzpx.zza zzaVar) {
        File fileZzzo = zzzo();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileZzzo);
            try {
                try {
                    fileOutputStream.write(zzrn.zzf(zzaVar));
                    return true;
                } catch (IOException e) {
                    zzbg.zzaC("Error writing resource to disk. Removing resource from disk.");
                    fileZzzo.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        zzbg.zzaC("error closing stream for writing resource to disk");
                    }
                    return false;
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzbg.zzaC("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e4) {
            zzbg.zzaz("Error opening resource file for writing");
            return false;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public zzqf.zzc zziR(int i) {
        StringBuilder sb;
        try {
            InputStream inputStreamOpenRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.zzaB("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqf.zzc(inputStreamOpenRawResource, byteArrayOutputStream);
                zzqf.zzc zzcVarZza = zza(byteArrayOutputStream);
                if (zzcVarZza == null) {
                    return zzr(byteArrayOutputStream.toByteArray());
                }
                zzbg.zzaB("The container was successfully loaded from the resource (using JSON file format)");
                return zzcVarZza;
            } catch (IOException e) {
                sb = new StringBuilder();
                sb.append("Error reading the default container with resource ID ");
                sb.append(i);
                sb.append(" (");
                sb.append(this.mContext.getResources().getResourceName(i));
                sb.append(")");
                zzbg.zzaC(sb.toString());
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            sb = new StringBuilder();
            sb.append("Failed to load the container. No default container resource found with the resource ID ");
            sb.append(i);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzyw() {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.1
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzzn();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.io.FileInputStream, java.io.InputStream] */
    void zzzn() {
        ?? fileInputStream;
        zzbf<zzpx.zza> zzbfVar = this.zzaMU;
        if (zzbfVar == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        zzbfVar.zzyv();
        zzbg.zzaB("Attempting to load resource from disk");
        if ((zzcb.zzzf().zzzg() == zzcb.zza.CONTAINER || zzcb.zzzf().zzzg() == zzcb.zza.CONTAINER_DEBUG) && this.zzaKy.equals(zzcb.zzzf().getContainerId())) {
            this.zzaMU.zza(zzbf.zza.NOT_AVAILABLE);
            return;
        }
        try {
            try {
                fileInputStream = new FileInputStream(zzzo());
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        zzqf.zzc(fileInputStream, byteArrayOutputStream);
                        zzpx.zza zzaVarZzs = zzpx.zza.zzs(byteArrayOutputStream.toByteArray());
                        zzd(zzaVarZzs);
                        this.zzaMU.zzz(zzaVarZzs);
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            zzbg.zzaC("Error closing stream for reading resource from disk");
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    this.zzaMU.zza(zzbf.zza.IO_ERROR);
                    zzbg.zzaC("Failed to read the resource from disk");
                    fileInputStream.close();
                } catch (IllegalArgumentException e3) {
                    this.zzaMU.zza(zzbf.zza.IO_ERROR);
                    zzbg.zzaC("Failed to read the resource from disk. The resource is inconsistent");
                    fileInputStream.close();
                }
            } catch (IOException e4) {
                zzbg.zzaC("Error closing stream for reading resource from disk");
            }
            fileInputStream = "The Disk resource was successfully read.";
            zzbg.zzaB("The Disk resource was successfully read.");
        } catch (FileNotFoundException e5) {
            zzbg.zzay("Failed to find the resource in the disk");
            this.zzaMU.zza(zzbf.zza.NOT_AVAILABLE);
        }
    }

    File zzzo() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaKy);
    }
}
