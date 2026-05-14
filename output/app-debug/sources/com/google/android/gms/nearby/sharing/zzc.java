package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sharedContent.getUri(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable[]) sharedContent.zzxe(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable[]) sharedContent.zzxf(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfA, reason: merged with bridge method [inline-methods] */
    public SharedContent createFromParcel(Parcel parcel) {
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        String strZzo = null;
        int iZzg = 0;
        ViewableItem[] viewableItemArr = null;
        LocalContent[] localContentArr = null;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            int iZzbA = com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa);
            if (iZzbA == 1) {
                iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
            } else if (iZzbA != 3) {
                switch (iZzbA) {
                    case 8:
                        viewableItemArr = (ViewableItem[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa, ViewableItem.CREATOR);
                        break;
                    case 9:
                        localContentArr = (LocalContent[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa, LocalContent.CREATOR);
                        break;
                    default:
                        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                        break;
                }
            } else {
                strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
            }
        }
        if (parcel.dataPosition() == iZzab) {
            return new SharedContent(iZzg, strZzo, viewableItemArr, localContentArr);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzip, reason: merged with bridge method [inline-methods] */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
