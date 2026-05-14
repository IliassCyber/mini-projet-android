package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, query.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) query.zzahG, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, query.zzahH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) query.zzahI, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, query.zzahJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, query.zzahK);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, query.zzadR, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbF, reason: merged with bridge method [inline-methods] */
    public Query createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        LogicalFilter logicalFilter = null;
        String strZzo = null;
        SortOrder sortOrder = null;
        ArrayList<String> arrayListZzC = null;
        ArrayList arrayListZzc = null;
        int iZzg = 0;
        boolean zZzc = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA == 1) {
                logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, LogicalFilter.CREATOR);
            } else if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 3:
                        strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    case 4:
                        sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, SortOrder.CREATOR);
                        break;
                    case 5:
                        arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzaa);
                        break;
                    case 6:
                        zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                        break;
                    case 7:
                        arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, DriveSpace.CREATOR);
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
            return new Query(iZzg, logicalFilter, strZzo, sortOrder, arrayListZzC, zZzc, arrayListZzc);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdu, reason: merged with bridge method [inline-methods] */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
