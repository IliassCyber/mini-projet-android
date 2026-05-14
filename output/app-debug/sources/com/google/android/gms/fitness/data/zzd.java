package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataPoint.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataPoint.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, dataPoint.getTimestampNanos());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataPoint.zzqy());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable[]) dataPoint.zzqu(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) dataPoint.getOriginalDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, dataPoint.zzqv());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, dataPoint.zzqw());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
    public DataPoint createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        DataSource dataSource = null;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        long jZzi3 = 0;
        long jZzi4 = 0;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA == 1) {
                dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, DataSource.CREATOR);
            } else if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 3:
                        jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 4:
                        jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 5:
                        valueArr = (Value[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa, Value.CREATOR);
                        break;
                    case 6:
                        dataSource2 = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, DataSource.CREATOR);
                        break;
                    case 7:
                        jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 8:
                        jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
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
            return new DataPoint(iZzg, dataSource, jZzi, jZzi2, valueArr, dataSource2, jZzi3, jZzi4);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzee, reason: merged with bridge method [inline-methods] */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
