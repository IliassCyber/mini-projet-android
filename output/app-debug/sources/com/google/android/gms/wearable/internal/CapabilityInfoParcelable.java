package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzh();
    private final String mName;
    final int zzCY;
    private final List<NodeParcelable> zzaTH;
    private final Object zzqt = new Object();
    private Set<Node> zzaTE = null;

    CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.zzCY = i;
        this.mName = str;
        this.zzaTH = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
        if (this.zzCY != capabilityInfoParcelable.zzCY) {
            return false;
        }
        String str = this.mName;
        if (str == null ? capabilityInfoParcelable.mName != null : !str.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        List<NodeParcelable> list = this.zzaTH;
        return list == null ? capabilityInfoParcelable.zzaTH == null : list.equals(capabilityInfoParcelable.zzaTH);
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzqt) {
            if (this.zzaTE == null) {
                this.zzaTE = new HashSet(this.zzaTH);
            }
            set = this.zzaTE;
        }
        return set;
    }

    public int hashCode() {
        int i = this.zzCY * 31;
        String str = this.mName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<NodeParcelable> list = this.zzaTH;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzaTH + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public List<NodeParcelable> zzBa() {
        return this.zzaTH;
    }
}
