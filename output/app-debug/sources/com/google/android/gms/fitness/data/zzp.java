package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzp implements Parcelable.Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, session.zzkt());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, session.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, session.zzqs());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, session.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, session.getIdentifier(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, session.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, session.zzqq());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) session.zzqB(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, session.zzqJ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcv, reason: merged with bridge method [inline-methods] */
    public Session createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long jZzi = 0;
        long jZzi2 = 0;
        String strZzo = null;
        String strZzo2 = null;
        String strZzo3 = null;
        Application application = null;
        Long lZzj = null;
        int iZzg = 0;
        int iZzg2 = 0;
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
                        strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    case 4:
                        strZzo2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    case 5:
                        strZzo3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                        break;
                    default:
                        switch (iZzbA) {
                            case 7:
                                iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                                break;
                            case 8:
                                application = (Application) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, Application.CREATOR);
                                break;
                            case 9:
                                lZzj = com.google.android.gms.common.internal.safeparcel.zza.zzj(parcel, iZzaa);
                                break;
                            default:
                                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                                break;
                        }
                        break;
                }
            } else {
                iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new Session(iZzg, jZzi, jZzi2, strZzo, strZzo2, strZzo3, iZzg2, application, lZzj);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzep, reason: merged with bridge method [inline-methods] */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}
