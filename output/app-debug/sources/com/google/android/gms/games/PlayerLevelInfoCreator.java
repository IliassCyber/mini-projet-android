package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class PlayerLevelInfoCreator implements Parcelable.Creator<PlayerLevelInfo> {
    static void zza(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        zzb.zzc(parcel, 1000, playerLevelInfo.getVersionCode());
        zzb.zza(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        zzb.zza(parcel, 3, (Parcelable) playerLevelInfo.getCurrentLevel(), i, false);
        zzb.zza(parcel, 4, (Parcelable) playerLevelInfo.getNextLevel(), i, false);
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdu, reason: merged with bridge method [inline-methods] */
    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        PlayerLevel playerLevel = null;
        PlayerLevel playerLevel2 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = zza.zzaa(parcel);
            int iZzbA = zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        jZzi = zza.zzi(parcel, iZzaa);
                        break;
                    case 2:
                        jZzi2 = zza.zzi(parcel, iZzaa);
                        break;
                    case 3:
                        playerLevel = (PlayerLevel) zza.zza(parcel, iZzaa, PlayerLevel.CREATOR);
                        break;
                    case 4:
                        playerLevel2 = (PlayerLevel) zza.zza(parcel, iZzaa, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(iZzg, jZzi, jZzi2, playerLevel, playerLevel2);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfq, reason: merged with bridge method [inline-methods] */
    public PlayerLevelInfo[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }
}
