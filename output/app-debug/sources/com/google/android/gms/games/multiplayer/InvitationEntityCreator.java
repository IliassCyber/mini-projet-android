package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InvitationEntityCreator implements Parcelable.Creator<InvitationEntity> {
    static void zza(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, invitationEntity.getVersionCode());
        zzb.zza(parcel, 2, invitationEntity.getInvitationId(), false);
        zzb.zza(parcel, 3, invitationEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, invitationEntity.getInvitationType());
        zzb.zza(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        zzb.zzc(parcel, 6, invitationEntity.getParticipants(), false);
        zzb.zzc(parcel, 7, invitationEntity.getVariant());
        zzb.zzc(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdI */
    public InvitationEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        GameEntity gameEntity = null;
        String strZzo = null;
        ParticipantEntity participantEntity = null;
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
                        gameEntity = (GameEntity) zza.zza(parcel, iZzaa, GameEntity.CREATOR);
                        break;
                    case 2:
                        strZzo = zza.zzo(parcel, iZzaa);
                        break;
                    case 3:
                        jZzi = zza.zzi(parcel, iZzaa);
                        break;
                    case 4:
                        iZzg2 = zza.zzg(parcel, iZzaa);
                        break;
                    case 5:
                        participantEntity = (ParticipantEntity) zza.zza(parcel, iZzaa, ParticipantEntity.CREATOR);
                        break;
                    case 6:
                        arrayListZzc = zza.zzc(parcel, iZzaa, ParticipantEntity.CREATOR);
                        break;
                    case 7:
                        iZzg3 = zza.zzg(parcel, iZzaa);
                        break;
                    case 8:
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
            return new InvitationEntity(iZzg, gameEntity, strZzo, jZzi, iZzg2, participantEntity, arrayListZzc, iZzg3, iZzg4);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfR, reason: merged with bridge method [inline-methods] */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
