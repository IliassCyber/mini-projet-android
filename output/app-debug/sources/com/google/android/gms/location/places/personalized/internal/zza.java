package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<TestDataImpl> {
    static void zza(TestDataImpl testDataImpl, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, testDataImpl.zzvf(), false);
        zzb.zzc(parcel, 1000, testDataImpl.zzCY);
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeH, reason: merged with bridge method [inline-methods] */
    public TestDataImpl createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int iZzg = 0;
        String strZzo = null;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA == 1) {
                strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
            } else if (iZzbA != 1000) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
            } else {
                iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new TestDataImpl(iZzg, strZzo);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhh, reason: merged with bridge method [inline-methods] */
    public TestDataImpl[] newArray(int i) {
        return new TestDataImpl[i];
    }
}
