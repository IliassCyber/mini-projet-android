package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, autocompletePredictionEntity.zzakM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, autocompletePredictionEntity.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, autocompletePredictionEntity.zzazK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, autocompletePredictionEntity.zzazo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaAe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaAf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzex, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        String strZzo = null;
        String strZzo2 = null;
        ArrayList<Integer> arrayListZzB = null;
        ArrayList arrayListZzc = null;
        int iZzg = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    case 2:
                        strZzo2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    case 3:
                        arrayListZzB = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, iZzaa);
                        break;
                    case 4:
                        arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                        break;
                    case 5:
                        iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    default:
                        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                        break;
                }
            } else {
                iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new AutocompletePredictionEntity(iZzg, strZzo, strZzo2, arrayListZzB, arrayListZzc, iZzg2);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgW, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
