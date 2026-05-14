package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public class DocumentSection implements SafeParcelable {
    final int zzCY;
    public final String zzNe;
    final RegisterSectionInfo zzNf;
    public final int zzNg;
    public final byte[] zzNh;
    public static final int zzNc = Integer.parseInt("-1");
    public static final zzd CREATOR = new zzd();
    private static final RegisterSectionInfo zzNd = new RegisterSectionInfo.zza("SsbContext").zzJ(true).zzbr("blob").zzkM();

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        zzu.zzb(i2 == zzNc || zzh.zzai(i2) != null, "Invalid section type " + i2);
        this.zzCY = i;
        this.zzNe = str;
        this.zzNf = registerSectionInfo;
        this.zzNg = i2;
        this.zzNh = bArr;
        String strZzkK = zzkK();
        if (strZzkK != null) {
            throw new IllegalArgumentException(strZzkK);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, zzNc, null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.zzbq(str2), null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, null, registerSectionInfo, zzNc, bArr);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzNd);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public String zzkK() {
        int i = this.zzNg;
        if (i == zzNc || zzh.zzai(i) != null) {
            if (this.zzNe == null || this.zzNh == null) {
                return null;
            }
            return "Both content and blobContent set";
        }
        return "Invalid section type " + this.zzNg;
    }
}
