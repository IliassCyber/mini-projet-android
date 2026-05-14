package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zze implements Parcelable.Creator<PlaceUserData> {
    static void zza(PlaceUserData placeUserData, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placeUserData.zzvb(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeUserData.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeUserData.getPlaceId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, placeUserData.zzve(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, placeUserData.zzvc(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, placeUserData.zzvd(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeG, reason: merged with bridge method [inline-methods] */
    public PlaceUserData createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        String strZzo = null;
        String strZzo2 = null;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        ArrayList arrayListZzc3 = null;
        int iZzg = 0;
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
                    default:
                        switch (iZzbA) {
                            case 5:
                                arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, TestDataImpl.CREATOR);
                                break;
                            case 6:
                                arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, PlaceAlias.CREATOR);
                                break;
                            case 7:
                                arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, HereContent.CREATOR);
                                break;
                            default:
                                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                                break;
                        }
                        break;
                }
            } else {
                iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new PlaceUserData(iZzg, strZzo, strZzo2, arrayListZzc, arrayListZzc2, arrayListZzc3);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhg, reason: merged with bridge method [inline-methods] */
    public PlaceUserData[] newArray(int i) {
        return new PlaceUserData[i];
    }
}
