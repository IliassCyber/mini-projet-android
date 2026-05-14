package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzs implements Parcelable.Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sensorRegistrationRequest.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sensorRegistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) sensorRegistrationRequest.getDataType(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sensorRegistrationRequest.zzrl(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, sensorRegistrationRequest.zzams);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, sensorRegistrationRequest.zzamt);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, sensorRegistrationRequest.zzqL());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, sensorRegistrationRequest.zzri());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) sensorRegistrationRequest.zzrg(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, sensorRegistrationRequest.zzrh());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 11, sensorRegistrationRequest.zzrj(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, sensorRegistrationRequest.zzrk());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, sensorRegistrationRequest.zzqU(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, sensorRegistrationRequest.getPackageName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcR, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long jZzi = 0;
        long jZzi2 = 0;
        long jZzi3 = 0;
        long jZzi4 = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinderZzp = null;
        PendingIntent pendingIntent = null;
        ArrayList arrayListZzc = null;
        IBinder iBinderZzp2 = null;
        String strZzo = null;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA != 1000) {
                switch (iZzbA) {
                    case 1:
                        dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, DataSource.CREATOR);
                        break;
                    case 2:
                        dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, DataType.CREATOR);
                        break;
                    case 3:
                        iBinderZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzaa);
                        break;
                    case 4:
                        iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 5:
                        iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 6:
                        jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 7:
                        jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 8:
                        pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PendingIntent.CREATOR);
                        break;
                    case 9:
                        jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 10:
                        iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                        break;
                    case 11:
                        arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, LocationRequest.CREATOR);
                        break;
                    case 12:
                        jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzaa);
                        break;
                    case 13:
                        iBinderZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzaa);
                        break;
                    case 14:
                        strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
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
            return new SensorRegistrationRequest(iZzg, dataSource, dataType, iBinderZzp, iZzg2, iZzg3, jZzi, jZzi2, pendingIntent, jZzi3, iZzg4, arrayListZzc, jZzi4, iBinderZzp2, strZzo);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeL, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest[] newArray(int i) {
        return new SensorRegistrationRequest[i];
    }
}
