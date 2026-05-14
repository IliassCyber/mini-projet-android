package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;

/* JADX INFO: loaded from: classes.dex */
public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzol zzaFk;
    private final zzon zzaFm;

    StartScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.versionCode = i;
        zzu.zzu(iBinder);
        this.zzaFm = zzon.zza.zzcZ(iBinder);
        zzu.zzu(iBinder2);
        this.zzaFk = zzol.zza.zzcX(iBinder2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzg zzgVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg zzgVar = CREATOR;
        zzg.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        zzol zzolVar = this.zzaFk;
        if (zzolVar == null) {
            return null;
        }
        return zzolVar.asBinder();
    }

    public IBinder zzwQ() {
        zzon zzonVar = this.zzaFm;
        if (zzonVar == null) {
            return null;
        }
        return zzonVar.asBinder();
    }
}
