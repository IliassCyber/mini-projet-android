package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QuestEntityCreator implements Parcelable.Creator<QuestEntity> {
    static void zza(QuestEntity questEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) questEntity.getGame(), i, false);
        zzb.zza(parcel, 2, questEntity.getQuestId(), false);
        zzb.zza(parcel, 3, questEntity.getAcceptedTimestamp());
        zzb.zza(parcel, 4, (Parcelable) questEntity.getBannerImageUri(), i, false);
        zzb.zza(parcel, 5, questEntity.getBannerImageUrl(), false);
        zzb.zza(parcel, 6, questEntity.getDescription(), false);
        zzb.zza(parcel, 7, questEntity.getEndTimestamp());
        zzb.zza(parcel, 8, questEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 9, (Parcelable) questEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 10, questEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, questEntity.getName(), false);
        zzb.zza(parcel, 13, questEntity.zztO());
        zzb.zza(parcel, 14, questEntity.getStartTimestamp());
        zzb.zzc(parcel, 15, questEntity.getState());
        zzb.zzc(parcel, 17, questEntity.zztN(), false);
        zzb.zzc(parcel, 16, questEntity.getType());
        zzb.zzc(parcel, 1000, questEntity.getVersionCode());
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdP, reason: merged with bridge method [inline-methods] */
    public QuestEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        long jZzi = 0;
        long jZzi2 = 0;
        long jZzi3 = 0;
        long jZzi4 = 0;
        long jZzi5 = 0;
        GameEntity gameEntity = null;
        String strZzo = null;
        Uri uri = null;
        String strZzo2 = null;
        String strZzo3 = null;
        Uri uri2 = null;
        String strZzo4 = null;
        String strZzo5 = null;
        ArrayList arrayListZzc = null;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
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
                        uri = (Uri) zza.zza(parcel, iZzaa, Uri.CREATOR);
                        break;
                    case 5:
                        strZzo2 = zza.zzo(parcel, iZzaa);
                        break;
                    case 6:
                        strZzo3 = zza.zzo(parcel, iZzaa);
                        break;
                    case 7:
                        jZzi2 = zza.zzi(parcel, iZzaa);
                        break;
                    case 8:
                        jZzi3 = zza.zzi(parcel, iZzaa);
                        break;
                    case 9:
                        uri2 = (Uri) zza.zza(parcel, iZzaa, Uri.CREATOR);
                        break;
                    case 10:
                        strZzo4 = zza.zzo(parcel, iZzaa);
                        break;
                    default:
                        switch (iZzbA) {
                            case 12:
                                strZzo5 = zza.zzo(parcel, iZzaa);
                                break;
                            case 13:
                                jZzi4 = zza.zzi(parcel, iZzaa);
                                break;
                            case 14:
                                jZzi5 = zza.zzi(parcel, iZzaa);
                                break;
                            case 15:
                                iZzg2 = zza.zzg(parcel, iZzaa);
                                break;
                            case 16:
                                iZzg3 = zza.zzg(parcel, iZzaa);
                                break;
                            case 17:
                                arrayListZzc = zza.zzc(parcel, iZzaa, MilestoneEntity.CREATOR);
                                break;
                            default:
                                zza.zzb(parcel, iZzaa);
                                break;
                        }
                        break;
                }
            } else {
                iZzg = zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new QuestEntity(iZzg, gameEntity, strZzo, jZzi, uri, strZzo2, strZzo3, jZzi2, jZzi3, uri2, strZzo4, strZzo5, jZzi4, jZzi5, iZzg2, iZzg3, arrayListZzc);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfY, reason: merged with bridge method [inline-methods] */
    public QuestEntity[] newArray(int i) {
        return new QuestEntity[i];
    }
}
