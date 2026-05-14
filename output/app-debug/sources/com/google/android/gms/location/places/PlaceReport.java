package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzk();
    private final String mTag;
    final int zzCY;
    private final String zzazK;
    private final String zzazL;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzCY = i;
        this.zzazK = str;
        this.mTag = str2;
        this.zzazL = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzi(str, str2, "unknown");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zzdo(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1436706272: goto L32;
                case -1194968642: goto L28;
                case -284840886: goto L1e;
                case -262743844: goto L14;
                case 1287171955: goto La;
                default: goto L9;
            }
        L9:
            goto L3c
        La:
            java.lang.String r0 = "inferredRadioSignals"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3c
            r3 = 3
            goto L3d
        L14:
            java.lang.String r0 = "inferredReverseGeocoding"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3c
            r3 = 4
            goto L3d
        L1e:
            java.lang.String r0 = "unknown"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3c
            r3 = 0
            goto L3d
        L28:
            java.lang.String r0 = "userReported"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3c
            r3 = 1
            goto L3d
        L32:
            java.lang.String r0 = "inferredGeofencing"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L3c
            r3 = 2
            goto L3d
        L3c:
            r3 = -1
        L3d:
            switch(r3) {
                case 0: goto L41;
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L41;
                default: goto L40;
            }
        L40:
            return r2
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.PlaceReport.zzdo(java.lang.String):boolean");
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzu.zzcj(str);
        zzu.zzcj(str2);
        zzu.zzcj(str3);
        zzu.zzb(zzdo(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzt.equal(this.zzazK, placeReport.zzazK) && zzt.equal(this.mTag, placeReport.mTag) && zzt.equal(this.zzazL, placeReport.zzazL);
    }

    public String getPlaceId() {
        return this.zzazK;
    }

    public String getSource() {
        return this.zzazL;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazK, this.mTag, this.zzazL);
    }

    public String toString() {
        zzt.zza zzaVarZzt = zzt.zzt(this);
        zzaVarZzt.zzg("placeId", this.zzazK);
        zzaVarZzt.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzazL)) {
            zzaVarZzt.zzg("source", this.zzazL);
        }
        return zzaVarZzt.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
