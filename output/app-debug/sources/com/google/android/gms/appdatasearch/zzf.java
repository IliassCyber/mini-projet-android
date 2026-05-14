package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<GetRecentContextCall.Request> {
    static void zza(GetRecentContextCall.Request request, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) request.zzNj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, request.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, request.zzNk);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, request.zzNl);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, request.zzNm);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Request[] newArray(int i) {
        return new GetRecentContextCall.Request[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Request createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Account account = null;
        int iZzg = 0;
        boolean zZzc = false;
        boolean zZzc2 = false;
        boolean zZzc3 = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        account = (Account) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, Account.CREATOR);
                        break;
                    case 2:
                        zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                        break;
                    case 3:
                        zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                        break;
                    case 4:
                        zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
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
            return new GetRecentContextCall.Request(iZzg, account, zZzc, zZzc2, zZzc3);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }
}
