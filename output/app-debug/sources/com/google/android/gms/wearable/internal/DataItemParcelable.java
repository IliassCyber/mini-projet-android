package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Parcelable.Creator<DataItemParcelable> CREATOR = new zzab();
    private final Uri mUri;
    final int zzCY;
    private final Map<String, DataItemAsset> zzaUo;
    private byte[] zzauL;

    DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.zzCY = i;
        this.mUri = uri;
        HashMap map = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            map.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzaUo = map;
        this.zzauL = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> getAssets() {
        return this.zzaUo;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return this.zzauL;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        String str;
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(",dataSz=");
        byte[] bArr = this.zzauL;
        sb2.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        sb.append(sb2.toString());
        sb.append(", numAssets=" + this.zzaUo.size());
        sb.append(", uri=" + this.mUri);
        if (z) {
            sb.append("]\n  assets: ");
            for (String str2 : this.zzaUo.keySet()) {
                sb.append("\n    " + str2 + ": " + this.zzaUo.get(str2));
            }
            str = "\n  ]";
        } else {
            str = "]";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }

    public Bundle zzAR() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry<String, DataItemAsset> entry : this.zzaUo.entrySet()) {
            bundle.putParcelable(entry.getKey(), new DataItemAssetParcelable(entry.getValue()));
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzBf, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItem
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable setData(byte[] bArr) {
        this.zzauL = bArr;
        return this;
    }
}
