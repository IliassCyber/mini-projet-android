package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;

/* JADX INFO: loaded from: classes.dex */
public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzaFg;
    private final zzoj zzaFi;
    private final zzok zzaFj;
    private final zzol zzaFk;

    EnableTargetRequest(int i, String str, String str2, byte b, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.name = zzu.zzcj(str);
        this.description = (String) zzu.zzu(str2);
        this.zzaFg = b;
        zzu.zzu(iBinder);
        this.zzaFi = zzoj.zza.zzcV(iBinder);
        zzu.zzu(iBinder2);
        this.zzaFj = zzok.zza.zzcW(iBinder2);
        zzu.zzu(iBinder3);
        this.zzaFk = zzol.zza.zzcX(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        zzol zzolVar = this.zzaFk;
        if (zzolVar == null) {
            return null;
        }
        return zzolVar.asBinder();
    }

    public byte zzwK() {
        return this.zzaFg;
    }

    public IBinder zzwO() {
        zzoj zzojVar = this.zzaFi;
        if (zzojVar == null) {
            return null;
        }
        return zzojVar.asBinder();
    }

    public IBinder zzwP() {
        zzok zzokVar = this.zzaFj;
        if (zzokVar == null) {
            return null;
        }
        return zzokVar.asBinder();
    }
}
