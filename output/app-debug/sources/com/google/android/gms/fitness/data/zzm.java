package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<RawBucket> {
    static void zza(RawBucket rawBucket, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, rawBucket.zzKT);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, rawBucket.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, rawBucket.zzajH);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) rawBucket.zzajJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, rawBucket.zzakG);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, rawBucket.zzajS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, rawBucket.zzajT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, rawBucket.zzajU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcs, reason: merged with bridge method [inline-methods] */
    public RawBucket createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Session session = null;
        ArrayList arrayListZzc = null;
        long jZzi = 0;
        long jZzi2 = 0;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        boolean zZzc = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 2:
                        jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 3:
                        session = (Session) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, Session.CREATOR);
                        break;
                    case 4:
                        iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 5:
                        arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, RawDataSet.CREATOR);
                        break;
                    case 6:
                        iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 7:
                        zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
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
            return new RawBucket(iZzg, jZzi, jZzi2, session, iZzg2, arrayListZzc, iZzg3, zZzc);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzel, reason: merged with bridge method [inline-methods] */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}
