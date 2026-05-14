package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppContentActionEntityCreator implements Parcelable.Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzrO(), false);
        zzb.zzc(parcel, 1000, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zzrP(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, (Parcelable) appContentActionEntity.zzrN(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zzrQ(), false);
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdw, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        ArrayList arrayListZzc = null;
        String strZzo = null;
        Bundle bundleZzq = null;
        String strZzo2 = null;
        String strZzo3 = null;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String strZzo4 = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = zza.zzaa(parcel);
            int iZzbA = zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        arrayListZzc = zza.zzc(parcel, iZzaa, AppContentConditionEntity.CREATOR);
                        break;
                    case 2:
                        strZzo = zza.zzo(parcel, iZzaa);
                        break;
                    case 3:
                        bundleZzq = zza.zzq(parcel, iZzaa);
                        break;
                    default:
                        switch (iZzbA) {
                            case 6:
                                strZzo2 = zza.zzo(parcel, iZzaa);
                                break;
                            case 7:
                                strZzo3 = zza.zzo(parcel, iZzaa);
                                break;
                            case 8:
                                appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, iZzaa, AppContentAnnotationEntity.CREATOR);
                                break;
                            case 9:
                                strZzo4 = zza.zzo(parcel, iZzaa);
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
            return new AppContentActionEntity(iZzg, arrayListZzc, strZzo, bundleZzq, strZzo2, strZzo3, appContentAnnotationEntity, strZzo4);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfs, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity[] newArray(int i) {
        return new AppContentActionEntity[i];
    }
}
