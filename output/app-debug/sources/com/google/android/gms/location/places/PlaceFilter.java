package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zza implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    final int zzCY;
    final boolean zzazC;
    final List<Integer> zzazs;
    private final Set<Integer> zzazt;
    final List<String> zzazu;
    final List<UserDataType> zzazv;
    private final Set<String> zzazw;
    private final Set<UserDataType> zzazx;

    @Deprecated
    public static final class zza {
        private boolean zzazC;
        private Collection<Integer> zzazD;
        private Collection<UserDataType> zzazE;
        private String[] zzazF;

        private zza() {
            this.zzazD = null;
            this.zzazC = false;
            this.zzazE = null;
            this.zzazF = null;
        }

        public PlaceFilter zzuK() {
            Collection<Integer> collection = this.zzazD;
            ArrayList arrayList = collection != null ? new ArrayList(collection) : null;
            Collection<UserDataType> collection2 = this.zzazE;
            ArrayList arrayList2 = collection2 != null ? new ArrayList(collection2) : null;
            String[] strArr = this.zzazF;
            return new PlaceFilter(arrayList, this.zzazC, strArr != null ? Arrays.asList(strArr) : null, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, List<Integer> list, boolean z, List<String> list2, List<UserDataType> list3) {
        this.zzCY = i;
        this.zzazs = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzazC = z;
        this.zzazv = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzazu = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzazt = zzl(this.zzazs);
        this.zzazx = zzl(this.zzazv);
        this.zzazw = zzl(this.zzazu);
    }

    public PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<UserDataType> collection3) {
        this(0, zzc(collection), z, zzc(collection2), zzc(collection3));
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this(null, z, collection, null);
    }

    @Deprecated
    public static PlaceFilter zzuJ() {
        return new zza().zzuK();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzf zzfVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzazt.equals(placeFilter.zzazt) && this.zzazC == placeFilter.zzazC && this.zzazx.equals(placeFilter.zzazx) && this.zzazw.equals(placeFilter.zzazw);
    }

    @Override // com.google.android.gms.location.places.zza
    public Set<String> getPlaceIds() {
        return this.zzazw;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzazt;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazt, Boolean.valueOf(this.zzazC), this.zzazx, this.zzazw);
    }

    @Override // com.google.android.gms.location.places.zza
    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzazC;
    }

    public String toString() {
        zzt.zza zzaVarZzt = zzt.zzt(this);
        if (!this.zzazt.isEmpty()) {
            zzaVarZzt.zzg("types", this.zzazt);
        }
        zzaVarZzt.zzg("requireOpenNow", Boolean.valueOf(this.zzazC));
        if (!this.zzazw.isEmpty()) {
            zzaVarZzt.zzg("placeIds", this.zzazw);
        }
        if (!this.zzazx.isEmpty()) {
            zzaVarZzt.zzg("requestedUserDataTypes", this.zzazx);
        }
        return zzaVarZzt.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf zzfVar = CREATOR;
        zzf.zza(this, parcel, i);
    }

    public Set<UserDataType> zzuI() {
        return this.zzazx;
    }
}
