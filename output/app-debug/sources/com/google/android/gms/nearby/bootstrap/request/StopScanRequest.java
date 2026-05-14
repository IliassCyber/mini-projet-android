package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;

/* JADX INFO: loaded from: classes.dex */
public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzol zzaFk;

    StopScanRequest(int i, IBinder iBinder) {
        this.versionCode = i;
        zzu.zzu(iBinder);
        this.zzaFk = zzol.zza.zzcX(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzh zzhVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh zzhVar = CREATOR;
        zzh.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        zzol zzolVar = this.zzaFk;
        if (zzolVar == null) {
            return null;
        }
        return zzolVar.asBinder();
    }
}
