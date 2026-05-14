package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, strategy.zzaFT);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, strategy.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, strategy.zzaFU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, strategy.zzaFV);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, strategy.zzaFW);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, strategy.zzaFX);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, strategy.zzaFY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfr, reason: merged with bridge method [inline-methods] */
    public Strategy createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        boolean zZzc = false;
        int iZzg5 = 0;
        int iZzg6 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 2:
                        iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 3:
                        iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 4:
                        zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                        break;
                    case 5:
                        iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 6:
                        iZzg6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
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
            return new Strategy(iZzg, iZzg2, iZzg3, iZzg4, zZzc, iZzg5, iZzg6);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzig, reason: merged with bridge method [inline-methods] */
    public Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
