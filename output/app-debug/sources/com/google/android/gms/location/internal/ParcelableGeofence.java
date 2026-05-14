package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzm CREATOR = new zzm();
    private final int zzCY;
    private final String zzDK;
    private final short zzaxA;
    private final double zzaxB;
    private final double zzaxC;
    private final float zzaxD;
    private final int zzaxE;
    private final int zzaxF;
    private final int zzaxy;
    private final long zzazj;

    public ParcelableGeofence(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        zzdn(str);
        zze(f);
        zza(d, d2);
        int iZzgG = zzgG(i2);
        this.zzCY = i;
        this.zzaxA = s;
        this.zzDK = str;
        this.zzaxB = d;
        this.zzaxC = d2;
        this.zzaxD = f;
        this.zzazj = j;
        this.zzaxy = iZzgG;
        this.zzaxE = i3;
        this.zzaxF = i4;
    }

    public ParcelableGeofence(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zzdn(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static void zze(float f) {
        if (f > 0.0f) {
            return;
        }
        throw new IllegalArgumentException("invalid radius: " + f);
    }

    private static int zzgG(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String zzgH(int i) {
        if (i != 1) {
            return null;
        }
        return "CIRCLE";
    }

    public static ParcelableGeofence zzn(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        ParcelableGeofence parcelableGeofenceCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return parcelableGeofenceCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzm zzmVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        return this.zzaxD == parcelableGeofence.zzaxD && this.zzaxB == parcelableGeofence.zzaxB && this.zzaxC == parcelableGeofence.zzaxC && this.zzaxA == parcelableGeofence.zzaxA;
    }

    public long getExpirationTime() {
        return this.zzazj;
    }

    public double getLatitude() {
        return this.zzaxB;
    }

    public double getLongitude() {
        return this.zzaxC;
    }

    public int getNotificationResponsiveness() {
        return this.zzaxE;
    }

    @Override // com.google.android.gms.location.Geofence
    public String getRequestId() {
        return this.zzDK;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zzaxB);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzaxC);
        return (((((((i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaxD)) * 31) + this.zzaxA) * 31) + this.zzaxy;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", zzgH(this.zzaxA), this.zzDK, Integer.valueOf(this.zzaxy), Double.valueOf(this.zzaxB), Double.valueOf(this.zzaxC), Float.valueOf(this.zzaxD), Integer.valueOf(this.zzaxE / 1000), Integer.valueOf(this.zzaxF), Long.valueOf(this.zzazj));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm zzmVar = CREATOR;
        zzm.zza(this, parcel, i);
    }

    public short zzuA() {
        return this.zzaxA;
    }

    public float zzuB() {
        return this.zzaxD;
    }

    public int zzuC() {
        return this.zzaxy;
    }

    public int zzuD() {
        return this.zzaxF;
    }
}
