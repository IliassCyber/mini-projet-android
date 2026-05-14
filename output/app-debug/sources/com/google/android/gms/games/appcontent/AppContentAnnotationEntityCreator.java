package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class AppContentAnnotationEntityCreator implements Parcelable.Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int iZzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentAnnotationEntity.zzrU(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zzrX(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zzrS(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zzrT());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zzrW());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zzrV(), false);
        zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdx, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity createFromParcel(Parcel parcel) {
        int iZzab = zza.zzab(parcel);
        String strZzo = null;
        Uri uri = null;
        String strZzo2 = null;
        String strZzo3 = null;
        String strZzo4 = null;
        String strZzo5 = null;
        Bundle bundleZzq = null;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = zza.zzaa(parcel);
            int iZzbA = zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        strZzo = zza.zzo(parcel, iZzaa);
                        break;
                    case 2:
                        uri = (Uri) zza.zza(parcel, iZzaa, Uri.CREATOR);
                        break;
                    case 3:
                        strZzo2 = zza.zzo(parcel, iZzaa);
                        break;
                    default:
                        switch (iZzbA) {
                            case 5:
                                strZzo3 = zza.zzo(parcel, iZzaa);
                                break;
                            case 6:
                                strZzo4 = zza.zzo(parcel, iZzaa);
                                break;
                            case 7:
                                strZzo5 = zza.zzo(parcel, iZzaa);
                                break;
                            case 8:
                                iZzg2 = zza.zzg(parcel, iZzaa);
                                break;
                            case 9:
                                iZzg3 = zza.zzg(parcel, iZzaa);
                                break;
                            case 10:
                                bundleZzq = zza.zzq(parcel, iZzaa);
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
            return new AppContentAnnotationEntity(iZzg, strZzo, uri, strZzo2, strZzo3, strZzo4, strZzo5, iZzg2, iZzg3, bundleZzq);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzft, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
