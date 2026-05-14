package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzu {
    protected static final Comparator<byte[]> zzaw = new Comparator<byte[]>() { // from class: com.google.android.gms.internal.zzu.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> zzas = new LinkedList();
    private List<byte[]> zzat = new ArrayList(64);
    private int zzau = 0;
    private final int zzav;

    public zzu(int i) {
        this.zzav = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void zzy() {
        while (this.zzau > this.zzav) {
            byte[] bArrRemove = this.zzas.remove(0);
            this.zzat.remove(bArrRemove);
            this.zzau -= bArrRemove.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzav) {
                this.zzas.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.zzat, bArr, zzaw);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.zzat.add(iBinarySearch, bArr);
                this.zzau += bArr.length;
                zzy();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized byte[] zzb(int i) {
        for (int i2 = 0; i2 < this.zzat.size(); i2++) {
            byte[] bArr = this.zzat.get(i2);
            if (bArr.length >= i) {
                this.zzau -= bArr.length;
                this.zzat.remove(i2);
                this.zzas.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
