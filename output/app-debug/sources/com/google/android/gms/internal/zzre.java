package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;

/* JADX INFO: loaded from: classes.dex */
public class zzre {
    private final byte[] zzaVH = new byte[256];
    private int zzaVI;
    private int zzaVJ;

    public zzre(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzaVH[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zzaVH;
            i2 = (i2 + bArr2[i3] + bArr[i3 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = bArr2[i3];
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
        }
        this.zzaVI = 0;
        this.zzaVJ = 0;
    }

    public void zzy(byte[] bArr) {
        int i = this.zzaVI;
        int i2 = this.zzaVJ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            byte[] bArr2 = this.zzaVH;
            i2 = (i2 + bArr2[i]) & MotionEventCompat.ACTION_MASK;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & MotionEventCompat.ACTION_MASK] ^ bArr[i3]);
        }
        this.zzaVI = i;
        this.zzaVJ = i2;
    }
}
