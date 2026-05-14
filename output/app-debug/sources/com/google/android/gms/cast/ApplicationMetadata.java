package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int zzCY;
    String zzQv;
    List<String> zzQw;
    String zzQx;
    Uri zzQy;
    List<WebImage> zzvi;

    private ApplicationMetadata() {
        this.zzCY = 1;
        this.zzvi = new ArrayList();
        this.zzQw = new ArrayList();
    }

    ApplicationMetadata(int i, String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.zzCY = i;
        this.zzQv = str;
        this.mName = str2;
        this.zzvi = list;
        this.zzQw = list2;
        this.zzQx = str3;
        this.zzQy = uri;
    }

    public boolean areNamespacesSupported(List<String> list) {
        List<String> list2 = this.zzQw;
        return list2 != null && list2.containsAll(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzQv, applicationMetadata.zzQv) && zzf.zza(this.zzvi, applicationMetadata.zzvi) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzQw, applicationMetadata.zzQw) && zzf.zza(this.zzQx, applicationMetadata.zzQx) && zzf.zza(this.zzQy, applicationMetadata.zzQy);
    }

    public String getApplicationId() {
        return this.zzQv;
    }

    public List<WebImage> getImages() {
        return this.zzvi;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzQx;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzCY), this.zzQv, this.mName, this.zzvi, this.zzQw, this.zzQx, this.zzQy);
    }

    public boolean isNamespaceSupported(String str) {
        List<String> list = this.zzQw;
        return list != null && list.contains(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("applicationId: ");
        sb.append(this.zzQv);
        sb.append(", name: ");
        sb.append(this.mName);
        sb.append(", images.count: ");
        List<WebImage> list = this.zzvi;
        sb.append(list == null ? 0 : list.size());
        sb.append(", namespaces.count: ");
        List<String> list2 = this.zzQw;
        sb.append(list2 != null ? list2.size() : 0);
        sb.append(", senderAppIdentifier: ");
        sb.append(this.zzQx);
        sb.append(", senderAppLaunchUrl: ");
        sb.append(this.zzQy);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzle() {
        return this.zzQy;
    }
}
