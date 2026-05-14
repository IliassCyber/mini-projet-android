package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataSourceStatsResult.zzajG, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataSourceStatsResult.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataSourceStatsResult.zzOw);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, dataSourceStatsResult.zzamS);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataSourceStatsResult.zzamT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, dataSourceStatsResult.zzamU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdh, reason: merged with bridge method [inline-methods] */
    public DataSourceStatsResult createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long jZzi = 0;
        long jZzi2 = 0;
        long jZzi3 = 0;
        DataSource dataSource = null;
        int iZzg = 0;
        boolean zZzc = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, DataSource.CREATOR);
                        break;
                    case 2:
                        jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 3:
                        zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                        break;
                    case 4:
                        jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 5:
                        jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
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
            return new DataSourceStatsResult(iZzg, dataSource, jZzi, zZzc, jZzi2, jZzi3);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfc, reason: merged with bridge method [inline-methods] */
    public DataSourceStatsResult[] newArray(int i) {
        return new DataSourceStatsResult[i];
    }
}
