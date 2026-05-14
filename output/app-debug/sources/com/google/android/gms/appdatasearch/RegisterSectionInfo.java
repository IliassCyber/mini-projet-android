package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    public final String name;
    public final int weight;
    final int zzCY;
    public final String zzNs;
    public final boolean zzNt;
    public final boolean zzNu;
    public final String zzNv;
    public final Feature[] zzNw;
    final int[] zzNx;
    public final String zzNy;

    public static final class zza {
        private final String mName;
        private boolean zzNA;
        private boolean zzNC;
        private String zzND;
        private BitSet zzNF;
        private String zzNG;
        private String zzNz;
        private int zzNB = 1;
        private final List<Feature> zzNE = new ArrayList();

        public zza(String str) {
            this.mName = str;
        }

        public zza zzJ(boolean z) {
            this.zzNA = z;
            return this;
        }

        public zza zzK(boolean z) {
            this.zzNC = z;
            return this;
        }

        public zza zzaj(int i) {
            if (this.zzNF == null) {
                this.zzNF = new BitSet();
            }
            this.zzNF.set(i);
            return this;
        }

        public zza zzbr(String str) {
            this.zzNz = str;
            return this;
        }

        public zza zzbs(String str) {
            this.zzNG = str;
            return this;
        }

        public RegisterSectionInfo zzkM() {
            int[] iArr;
            BitSet bitSet = this.zzNF;
            if (bitSet != null) {
                iArr = new int[bitSet.cardinality()];
                int i = 0;
                int iNextSetBit = this.zzNF.nextSetBit(0);
                while (iNextSetBit >= 0) {
                    iArr[i] = iNextSetBit;
                    iNextSetBit = this.zzNF.nextSetBit(iNextSetBit + 1);
                    i++;
                }
            } else {
                iArr = null;
            }
            String str = this.mName;
            String str2 = this.zzNz;
            boolean z = this.zzNA;
            int i2 = this.zzNB;
            boolean z2 = this.zzNC;
            String str3 = this.zzND;
            List<Feature> list = this.zzNE;
            return new RegisterSectionInfo(str, str2, z, i2, z2, str3, (Feature[]) list.toArray(new Feature[list.size()]), iArr, this.zzNG);
        }
    }

    RegisterSectionInfo(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this.zzCY = i;
        this.name = str;
        this.zzNs = str2;
        this.zzNt = z;
        this.weight = i2;
        this.zzNu = z2;
        this.zzNv = str3;
        this.zzNw = featureArr;
        this.zzNx = iArr;
        this.zzNy = str4;
    }

    RegisterSectionInfo(String str, String str2, boolean z, int i, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzi zziVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi zziVar = CREATOR;
        zzi.zza(this, parcel, i);
    }
}
