package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<PlaceRequest> {
    static void zza(PlaceRequest placeRequest, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) placeRequest.zzuG(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, placeRequest.getInterval());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, placeRequest.getPriority());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, placeRequest.getExpirationTime());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzev, reason: merged with bridge method [inline-methods] */
    public PlaceRequest createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long jZzi = PlaceRequest.zzazM;
        PlaceFilter placeFilter = null;
        long jZzi2 = Long.MAX_VALUE;
        int iZzg = 0;
        int iZzg2 = 102;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 2:
                        placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PlaceFilter.CREATOR);
                        break;
                    case 3:
                        jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 4:
                        iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 5:
                        jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
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
            return new PlaceRequest(iZzg, placeFilter, jZzi, iZzg2, jZzi2);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgT, reason: merged with bridge method [inline-methods] */
    public PlaceRequest[] newArray(int i) {
        return new PlaceRequest[i];
    }
}
