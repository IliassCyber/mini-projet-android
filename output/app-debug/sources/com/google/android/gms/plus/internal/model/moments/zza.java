package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int iZzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set<Integer> set = itemScopeEntity.zzaHQ;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, itemScopeEntity.zzCY);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) itemScopeEntity.zzaHR, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, itemScopeEntity.zzaHS, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) itemScopeEntity.zzaHT, i, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, itemScopeEntity.zzaHU, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, itemScopeEntity.zzaHV, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, itemScopeEntity.zzaHW, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, itemScopeEntity.zzaHX, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, itemScopeEntity.zzaHY);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, itemScopeEntity.zzaHZ, true);
        }
        if (set.contains(11)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) itemScopeEntity.zzaIa, i, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, itemScopeEntity.zzaIb, true);
        }
        if (set.contains(13)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, itemScopeEntity.zzaIc, true);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, itemScopeEntity.zzaId, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) itemScopeEntity.zzaIe, i, true);
        }
        if (set.contains(17)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, itemScopeEntity.zzaIg, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, itemScopeEntity.zzaIf, true);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, itemScopeEntity.zzaIh, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, itemScopeEntity.zzsB, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 21, itemScopeEntity.zzaIj, true);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, itemScopeEntity.zzaIi, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 23, itemScopeEntity.zzakM, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 22, itemScopeEntity.zzaIk, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 25, itemScopeEntity.zzaIm, true);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 24, itemScopeEntity.zzaIl, true);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, itemScopeEntity.zzaIo, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, itemScopeEntity.zzaIn, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, (Parcelable) itemScopeEntity.zzaIq, i, true);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 28, itemScopeEntity.zzaIp, true);
        }
        if (set.contains(31)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 31, itemScopeEntity.zzaIs, true);
        }
        if (set.contains(30)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 30, itemScopeEntity.zzaIr, true);
        }
        if (set.contains(34)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 34, (Parcelable) itemScopeEntity.zzaIu, i, true);
        }
        if (set.contains(32)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 32, itemScopeEntity.zzKI, true);
        }
        if (set.contains(33)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 33, itemScopeEntity.zzaIt, true);
        }
        if (set.contains(38)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 38, itemScopeEntity.zzaxC);
        }
        if (set.contains(39)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(36)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 36, itemScopeEntity.zzaxB);
        }
        if (set.contains(37)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 37, (Parcelable) itemScopeEntity.zzaIv, i, true);
        }
        if (set.contains(42)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 42, itemScopeEntity.zzaIy, true);
        }
        if (set.contains(43)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 43, itemScopeEntity.zzaIz, true);
        }
        if (set.contains(40)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 40, (Parcelable) itemScopeEntity.zzaIw, i, true);
        }
        if (set.contains(41)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 41, itemScopeEntity.zzaIx, true);
        }
        if (set.contains(46)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 46, (Parcelable) itemScopeEntity.zzaIC, i, true);
        }
        if (set.contains(47)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 47, itemScopeEntity.zzaID, true);
        }
        if (set.contains(44)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 44, itemScopeEntity.zzaIA, true);
        }
        if (set.contains(45)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 45, itemScopeEntity.zzaIB, true);
        }
        if (set.contains(51)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 51, itemScopeEntity.zzaIH, true);
        }
        if (set.contains(50)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 50, (Parcelable) itemScopeEntity.zzaIG, i, true);
        }
        if (set.contains(49)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 49, itemScopeEntity.zzaIF, true);
        }
        if (set.contains(48)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 48, itemScopeEntity.zzaIE, true);
        }
        if (set.contains(55)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 55, itemScopeEntity.zzaIJ, true);
        }
        if (set.contains(54)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(53)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 53, itemScopeEntity.zzEl, true);
        }
        if (set.contains(52)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 52, itemScopeEntity.zzaII, true);
        }
        if (set.contains(56)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 56, itemScopeEntity.zzaIK, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, iZzac);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfK, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int i;
        ArrayList arrayList;
        int i2;
        int iZzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        ArrayList<String> arrayListZzC = null;
        double dZzm = 0.0d;
        double dZzm2 = 0.0d;
        ItemScopeEntity itemScopeEntity = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String strZzo = null;
        String strZzo2 = null;
        String strZzo3 = null;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        ArrayList arrayListZzc3 = null;
        String strZzo4 = null;
        String strZzo5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String strZzo6 = null;
        String strZzo7 = null;
        String strZzo8 = null;
        ArrayList arrayListZzc4 = null;
        String strZzo9 = null;
        String strZzo10 = null;
        String strZzo11 = null;
        String strZzo12 = null;
        String strZzo13 = null;
        String strZzo14 = null;
        String strZzo15 = null;
        String strZzo16 = null;
        String strZzo17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String strZzo18 = null;
        String strZzo19 = null;
        String strZzo20 = null;
        String strZzo21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        ItemScopeEntity itemScopeEntity7 = null;
        String strZzo22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        ArrayList arrayListZzc5 = null;
        String strZzo23 = null;
        String strZzo24 = null;
        String strZzo25 = null;
        String strZzo26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String strZzo27 = null;
        String strZzo28 = null;
        String strZzo29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String strZzo30 = null;
        String strZzo31 = null;
        String strZzo32 = null;
        String strZzo33 = null;
        String strZzo34 = null;
        String strZzo35 = null;
        int iZzg = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzab) {
            int iZzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(iZzaa)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 1;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 2:
                    itemScopeEntity = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 2;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 3:
                    arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzaa);
                    i = 3;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 4:
                    itemScopeEntity2 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 4;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 5:
                    strZzo = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 5;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 6:
                    strZzo2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 6;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 7:
                    strZzo3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 7;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 8:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 8;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 9:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzaa);
                    i = 9;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 10:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 10;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 11:
                    itemScopeEntity3 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 11;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 12:
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i = 12;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 13:
                    strZzo4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 13;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 14:
                    strZzo5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 14;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 15:
                    arrayList = arrayListZzc3;
                    itemScopeEntity4 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 15;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 16:
                    strZzo6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 16;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 17:
                    strZzo7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 17;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 18:
                    strZzo8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 18;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 19:
                    arrayList = arrayListZzc3;
                    arrayListZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 19;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 20:
                    strZzo9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 20;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 21:
                    strZzo10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 21;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 22:
                    strZzo11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 22;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 23:
                    strZzo12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 23;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 24:
                    strZzo13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 24;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 25:
                    strZzo14 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 25;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 26:
                    strZzo15 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 26;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 27:
                    strZzo16 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 27;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 28:
                    strZzo17 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 28;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 29:
                    arrayList = arrayListZzc3;
                    itemScopeEntity5 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 29;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 30:
                    strZzo18 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 30;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 31:
                    strZzo19 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 31;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 32:
                    strZzo20 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 32;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 33:
                    strZzo21 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 33;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 34:
                    arrayList = arrayListZzc3;
                    itemScopeEntity6 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 34;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 35:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzaa);
                    break;
                case 36:
                    dZzm = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, iZzaa);
                    i = 36;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 37:
                    arrayList = arrayListZzc3;
                    itemScopeEntity7 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 37;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 38:
                    dZzm2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, iZzaa);
                    i = 38;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 39:
                    strZzo22 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 39;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 40:
                    arrayList = arrayListZzc3;
                    itemScopeEntity8 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 40;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 41:
                    arrayList = arrayListZzc3;
                    arrayListZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 41;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 42:
                    strZzo23 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 42;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 43:
                    strZzo24 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 43;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 44:
                    strZzo25 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 44;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 45:
                    strZzo26 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 45;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 46:
                    arrayList = arrayListZzc3;
                    itemScopeEntity9 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 46;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 47:
                    strZzo27 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 47;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 48:
                    strZzo28 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 48;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 49:
                    strZzo29 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 49;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 50:
                    arrayList = arrayListZzc3;
                    itemScopeEntity10 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzaa, ItemScopeEntity.CREATOR);
                    i2 = 50;
                    hashSet.add(Integer.valueOf(i2));
                    arrayListZzc3 = arrayList;
                    break;
                case 51:
                    strZzo30 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 51;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 52:
                    strZzo31 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 52;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 53:
                    strZzo32 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 53;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 54:
                    strZzo33 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 54;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 55:
                    strZzo34 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 55;
                    hashSet.add(Integer.valueOf(i));
                    break;
                case 56:
                    strZzo35 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, iZzaa);
                    i = 56;
                    hashSet.add(Integer.valueOf(i));
                    break;
            }
        }
        ArrayList arrayList2 = arrayListZzc3;
        if (parcel.dataPosition() == iZzab) {
            return new ItemScopeEntity(hashSet, iZzg, itemScopeEntity, arrayListZzC, itemScopeEntity2, strZzo, strZzo2, strZzo3, arrayListZzc, iZzg2, arrayListZzc2, itemScopeEntity3, arrayList2, strZzo4, strZzo5, itemScopeEntity4, strZzo6, strZzo7, strZzo8, arrayListZzc4, strZzo9, strZzo10, strZzo11, strZzo12, strZzo13, strZzo14, strZzo15, strZzo16, strZzo17, itemScopeEntity5, strZzo18, strZzo19, strZzo20, strZzo21, itemScopeEntity6, dZzm, itemScopeEntity7, dZzm2, strZzo22, itemScopeEntity8, arrayListZzc5, strZzo23, strZzo24, strZzo25, strZzo26, itemScopeEntity9, strZzo27, strZzo28, strZzo29, itemScopeEntity10, strZzo30, strZzo31, strZzo32, strZzo33, strZzo34, strZzo35);
        }
        throw new zza.C0036zza("Overread allowed size end=" + iZzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zziA, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
