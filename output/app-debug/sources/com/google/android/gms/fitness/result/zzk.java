package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzk implements Parcelable.Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sessionStopResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) sessionStopResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdo, reason: merged with bridge method [inline-methods] */
    public SessionStopResult createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Status status = null;
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 2:
                        status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, Status.CREATOR);
                        break;
                    case 3:
                        arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, Session.CREATOR);
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
            return new SessionStopResult(iZzg, status, arrayListZzc);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfj, reason: merged with bridge method [inline-methods] */
    public SessionStopResult[] newArray(int i) {
        return new SessionStopResult[i];
    }
}
