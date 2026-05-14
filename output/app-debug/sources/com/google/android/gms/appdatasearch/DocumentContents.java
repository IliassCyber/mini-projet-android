package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final Account account;
    final int zzCY;
    final DocumentSection[] zzMS;
    public final String zzMT;
    public final boolean zzMU;

    public static class zza {
        private List<DocumentSection> zzMV;
        private String zzMW;
        private boolean zzMX;
        private Account zzMY;

        public zza zzI(boolean z) {
            this.zzMX = z;
            return this;
        }

        public zza zza(Account account) {
            this.zzMY = account;
            return this;
        }

        public zza zza(DocumentSection documentSection) {
            if (this.zzMV == null) {
                this.zzMV = new ArrayList();
            }
            this.zzMV.add(documentSection);
            return this;
        }

        public zza zzbp(String str) {
            this.zzMW = str;
            return this;
        }

        public DocumentContents zzkJ() {
            String str = this.zzMW;
            boolean z = this.zzMX;
            Account account = this.zzMY;
            List<DocumentSection> list = this.zzMV;
            return new DocumentContents(str, z, account, list != null ? (DocumentSection[]) list.toArray(new DocumentSection[list.size()]) : null);
        }
    }

    DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account) {
        this.zzCY = i;
        this.zzMS = documentSectionArr;
        this.zzMT = str;
        this.zzMU = z;
        this.account = account;
    }

    DocumentContents(String str, boolean z, Account account, DocumentSection... documentSectionArr) {
        this(1, documentSectionArr, str, z, account);
        BitSet bitSet = new BitSet(zzh.zzkL());
        for (DocumentSection documentSection : documentSectionArr) {
            int i = documentSection.zzNg;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzai(i));
                }
                bitSet.set(i);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }
}
