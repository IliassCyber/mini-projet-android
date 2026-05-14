package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppContentSectionEntityCreator implements Parcelable.Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zzsj(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zzrP(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzsb(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzsk(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzrZ(), false);
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdA, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        String strZzo = null;
        Bundle bundleZzq = null;
        String strZzo2 = null;
        String strZzo3 = null;
        String strZzo4 = null;
        String strZzo5 = null;
        String strZzo6 = null;
        ArrayList arrayListZzc3 = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = zza.zzaa(parcel);
            int iZzbA = zza.zzbA(iZzaa);
            if (iZzbA == 1) {
                arrayListZzc = zza.zzc(parcel, iZzaa, AppContentActionEntity.CREATOR);
            } else if (iZzbA == 14) {
                arrayListZzc3 = zza.zzc(parcel, iZzaa, AppContentAnnotationEntity.CREATOR);
            } else if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 3:
                        arrayListZzc2 = zza.zzc(parcel, iZzaa, AppContentCardEntity.CREATOR);
                        break;
                    case 4:
                        strZzo = zza.zzo(parcel, iZzaa);
                        break;
                    case 5:
                        bundleZzq = zza.zzq(parcel, iZzaa);
                        break;
                    case 6:
                        strZzo2 = zza.zzo(parcel, iZzaa);
                        break;
                    case 7:
                        strZzo3 = zza.zzo(parcel, iZzaa);
                        break;
                    case 8:
                        strZzo4 = zza.zzo(parcel, iZzaa);
                        break;
                    case 9:
                        strZzo5 = zza.zzo(parcel, iZzaa);
                        break;
                    case 10:
                        strZzo6 = zza.zzo(parcel, iZzaa);
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
            return new AppContentSectionEntity(iZzg, arrayListZzc, arrayListZzc2, strZzo, bundleZzq, strZzo2, strZzo3, strZzo4, strZzo5, strZzo6, arrayListZzc3);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfw, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }
}
