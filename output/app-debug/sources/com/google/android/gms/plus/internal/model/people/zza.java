package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set<Integer> set = personEntity.zzaHQ;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, personEntity.zzCY);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, personEntity.zzaIO, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) personEntity.zzaIP, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, personEntity.zzaIQ, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, personEntity.zzaIR, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, personEntity.zzaIS);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) personEntity.zzaIT, i, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, personEntity.zzaIU, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, personEntity.zzadI, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, personEntity.zzsC);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, personEntity.zzKI, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) personEntity.zzaIV, i, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, personEntity.zzaIW);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, (Parcelable) personEntity.zzaIX, i, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, personEntity.zzRA, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 21, personEntity.zzaIZ);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, personEntity.zzaIY, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 23, personEntity.zzaJb, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 22, personEntity.zzaJa, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 25, personEntity.zzaJd);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 24, personEntity.zzaJc);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, personEntity.zzaJe, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, personEntity.zzaJg);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 28, personEntity.zzaJf, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfM, reason: merged with bridge method [inline-methods] */
    public PersonEntity createFromParcel(Parcel parcel) {
        int i;
        PersonEntity.ImageEntity imageEntity;
        int i2;
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        String strZzo = null;
        PersonEntity.AgeRangeEntity ageRangeEntity = null;
        String strZzo2 = null;
        String strZzo3 = null;
        PersonEntity.CoverEntity coverEntity = null;
        String strZzo4 = null;
        String strZzo5 = null;
        String strZzo6 = null;
        PersonEntity.ImageEntity imageEntity2 = null;
        String strZzo7 = null;
        PersonEntity.NameEntity nameEntity = null;
        String strZzo8 = null;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        String strZzo9 = null;
        String strZzo10 = null;
        ArrayList arrayListZzc3 = null;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        boolean zZzc = false;
        int iZzg4 = 0;
        int iZzg5 = 0;
        int iZzg6 = 0;
        boolean zZzc2 = false;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 1;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 2:
                    strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 2;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 3:
                    ageRangeEntity = (PersonEntity.AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PersonEntity.AgeRangeEntity.CREATOR);
                    i = 3;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 4:
                    strZzo2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 4;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 5:
                    strZzo3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 5;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 6:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 6;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 7:
                    coverEntity = (PersonEntity.CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PersonEntity.CoverEntity.CREATOR);
                    i = 7;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 8:
                    strZzo4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 8;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 9:
                    strZzo5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 9;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                    break;
                case 12:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 12;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 14:
                    strZzo6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 14;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 15:
                    imageEntity2 = (PersonEntity.ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PersonEntity.ImageEntity.CREATOR);
                    i = 15;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 16:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                    i = 16;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 18:
                    strZzo7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 18;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 19:
                    imageEntity = imageEntity2;
                    nameEntity = (PersonEntity.NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, PersonEntity.NameEntity.CREATOR);
                    i2 = 19;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 20:
                    strZzo8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 20;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 21:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 21;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 22:
                    imageEntity = imageEntity2;
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, PersonEntity.OrganizationsEntity.CREATOR);
                    i2 = 22;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 23:
                    imageEntity = imageEntity2;
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, PersonEntity.PlacesLivedEntity.CREATOR);
                    i2 = 23;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 24:
                    iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 24;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 25:
                    iZzg6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 25;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 26:
                    strZzo9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 26;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 27:
                    strZzo10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 27;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 28:
                    imageEntity = imageEntity2;
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, PersonEntity.UrlsEntity.CREATOR);
                    i2 = 28;
                    hashSet.add(Integer.valueOf(i2));
                    imageEntity2 = imageEntity;
                    break;
                case 29:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa);
                    i = 29;
                    hashSet.add(Integer.valueOf(i));
                    break;
            }
        }
        PersonEntity.ImageEntity imageEntity3 = imageEntity2;
        if (parcel.dataPosition() == iZzab) {
            return new PersonEntity(hashSet, iZzg, strZzo, ageRangeEntity, strZzo2, strZzo3, iZzg2, coverEntity, strZzo4, strZzo5, iZzg3, strZzo6, imageEntity3, zZzc, strZzo7, nameEntity, strZzo8, iZzg4, arrayListZzc, arrayListZzc2, iZzg5, iZzg6, strZzo9, strZzo10, arrayListZzc3, zZzc2);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zziC, reason: merged with bridge method [inline-methods] */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
