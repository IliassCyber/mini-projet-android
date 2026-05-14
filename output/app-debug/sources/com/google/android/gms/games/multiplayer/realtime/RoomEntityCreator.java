package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RoomEntityCreator implements Parcelable.Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzb.zzc(parcel, 1000, roomEntity.getVersionCode());
        zzb.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzb.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, roomEntity.getStatus());
        zzb.zza(parcel, 5, roomEntity.getDescription(), false);
        zzb.zzc(parcel, 6, roomEntity.getVariant());
        zzb.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzb.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdM */
    public RoomEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        String strZzo = null;
        String strZzo2 = null;
        String strZzo3 = null;
        Bundle bundleZzq = null;
        ArrayList arrayListZzc = null;
        long jZzi = 0;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = zza.zzaa(parcel);
            int iZzbA = zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        strZzo = zza.zzo(parcel, iZzaa);
                        break;
                    case 2:
                        strZzo2 = zza.zzo(parcel, iZzaa);
                        break;
                    case 3:
                        jZzi = zza.zzi(parcel, iZzaa);
                        break;
                    case 4:
                        iZzg2 = zza.zzg(parcel, iZzaa);
                        break;
                    case 5:
                        strZzo3 = zza.zzo(parcel, iZzaa);
                        break;
                    case 6:
                        iZzg3 = zza.zzg(parcel, iZzaa);
                        break;
                    case 7:
                        bundleZzq = zza.zzq(parcel, iZzaa);
                        break;
                    case 8:
                        arrayListZzc = zza.zzc(parcel, iZzaa, ParticipantEntity.CREATOR);
                        break;
                    case 9:
                        iZzg4 = zza.zzg(parcel, iZzaa);
                        break;
                    default:
                        zza.zzb(parcel, iZzaa);
                        break;
                }
            } else {
                iZzg = zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new RoomEntity(iZzg, strZzo, strZzo2, jZzi, iZzg2, strZzo3, iZzg3, bundleZzq, arrayListZzc, iZzg4);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfV, reason: merged with bridge method [inline-methods] */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
