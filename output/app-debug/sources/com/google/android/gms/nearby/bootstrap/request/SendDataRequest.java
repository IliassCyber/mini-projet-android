package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzaFh;
    private final zzol zzaFk;

    SendDataRequest(int i, Device device, byte[] bArr, IBinder iBinder) {
        this.versionCode = i;
        this.zzaFh = (Device) zzu.zzu(device);
        this.data = (byte[]) zzu.zzu(bArr);
        zzu.zzu(iBinder);
        this.zzaFk = zzol.zza.zzcX(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzf zzfVar = CREATOR;
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf zzfVar = CREATOR;
        zzf.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        zzol zzolVar = this.zzaFk;
        if (zzolVar == null) {
            return null;
        }
        return zzolVar.asBinder();
    }

    public Device zzwM() {
        return this.zzaFh;
    }
}
