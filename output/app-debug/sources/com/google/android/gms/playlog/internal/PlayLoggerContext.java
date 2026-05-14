package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final int zzaGP;
    public final int zzaGQ;
    public final String zzaGR;
    public final String zzaGS;
    public final boolean zzaGT;
    public final String zzaGU;
    public final boolean zzaGV;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzaGP = i2;
        this.zzaGQ = i3;
        this.zzaGR = str2;
        this.zzaGS = str3;
        this.zzaGT = z;
        this.zzaGU = str4;
        this.zzaGV = z2;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) zzu.zzu(str);
        this.zzaGP = i;
        this.zzaGQ = i2;
        this.zzaGU = null;
        this.zzaGR = str2;
        this.zzaGS = str3;
        this.zzaGT = z;
        this.zzaGV = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzaGP == playLoggerContext.zzaGP && this.zzaGQ == playLoggerContext.zzaGQ && zzt.equal(this.zzaGU, playLoggerContext.zzaGU) && zzt.equal(this.zzaGR, playLoggerContext.zzaGR) && zzt.equal(this.zzaGS, playLoggerContext.zzaGS) && this.zzaGT == playLoggerContext.zzaGT && this.zzaGV == playLoggerContext.zzaGV;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaGP), Integer.valueOf(this.zzaGQ), this.zzaGU, this.zzaGR, this.zzaGS, Boolean.valueOf(this.zzaGT), Boolean.valueOf(this.zzaGV));
    }

    public String toString() {
        return "PlayLoggerContext[versionCode=" + this.versionCode + ",package=" + this.packageName + ",packageVersionCode=" + this.zzaGP + ",logSource=" + this.zzaGQ + ",logSourceName=" + this.zzaGU + ",uploadAccount=" + this.zzaGR + ",loggingId=" + this.zzaGS + ",logAndroidId=" + this.zzaGT + ",isAnonymous=" + this.zzaGV + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
