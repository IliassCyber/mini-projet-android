package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public class MapValue implements SafeParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzl();
    private final int zzCY;
    private final int zzakB;
    private final float zzakF;

    public MapValue(int i, float f) {
        this(1, i, f);
    }

    MapValue(int i, int i2, float f) {
        this.zzCY = i;
        this.zzakB = i2;
        this.zzakF = f;
    }

    private boolean zza(MapValue mapValue) {
        int i = this.zzakB;
        if (i == mapValue.zzakB) {
            return i != 2 ? this.zzakF == mapValue.zzakF : asFloat() == mapValue.asFloat();
        }
        return false;
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzu.zza(this.zzakB == 2, "Value is not in float format");
        return this.zzakF;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MapValue) && zza((MapValue) obj));
    }

    int getFormat() {
        return this.zzakB;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return (int) this.zzakF;
    }

    public String toString() {
        return this.zzakB != 2 ? "unknown" : Float.toString(asFloat());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    float zzqI() {
        return this.zzakF;
    }
}
