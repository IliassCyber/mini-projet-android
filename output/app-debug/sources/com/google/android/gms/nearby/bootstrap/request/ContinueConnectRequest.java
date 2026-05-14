package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;

/* JADX INFO: loaded from: classes.dex */
public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzol zzaFk;
    private final String zzaFl;

    ContinueConnectRequest(int i, String str, IBinder iBinder) {
        this.versionCode = i;
        this.zzaFl = (String) zzu.zzu(str);
        this.zzaFk = zzol.zza.zzcX(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public String getToken() {
        return this.zzaFl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        zzol zzolVar = this.zzaFk;
        if (zzolVar == null) {
            return null;
        }
        return zzolVar.asBinder();
    }
}
