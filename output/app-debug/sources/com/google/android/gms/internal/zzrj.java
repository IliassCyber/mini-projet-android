package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public class zzrj implements Cloneable {
    private static final zzrk zzaVX = new zzrk();
    private int mSize;
    private boolean zzaVY;
    private int[] zzaVZ;
    private zzrk[] zzaWa;

    public zzrj() {
        this(10);
    }

    public zzrj(int i) {
        this.zzaVY = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.zzaVZ = new int[iIdealIntArraySize];
        this.zzaWa = new zzrk[iIdealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzaVZ;
        zzrk[] zzrkVarArr = this.zzaWa;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzrk zzrkVar = zzrkVarArr[i3];
            if (zzrkVar != zzaVX) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzrkVarArr[i2] = zzrkVar;
                    zzrkVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzaVY = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzrk[] zzrkVarArr, zzrk[] zzrkVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzrkVarArr[i2].equals(zzrkVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzkT(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzaVZ[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrj)) {
            return false;
        }
        zzrj zzrjVar = (zzrj) obj;
        return size() == zzrjVar.size() && zza(this.zzaVZ, zzrjVar.zzaVZ, this.mSize) && zza(this.zzaWa, zzrjVar.zzaWa, this.mSize);
    }

    public int hashCode() {
        if (this.zzaVY) {
            gc();
        }
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.zzaVZ[i]) * 31) + this.zzaWa[i].hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.zzaVY) {
            gc();
        }
        return this.mSize;
    }

    /* JADX INFO: renamed from: zzBL, reason: merged with bridge method [inline-methods] */
    public final zzrj clone() {
        int size = size();
        zzrj zzrjVar = new zzrj(size);
        System.arraycopy(this.zzaVZ, 0, zzrjVar.zzaVZ, 0, size);
        for (int i = 0; i < size; i++) {
            zzrk[] zzrkVarArr = this.zzaWa;
            if (zzrkVarArr[i] != null) {
                zzrjVar.zzaWa[i] = zzrkVarArr[i].clone();
            }
        }
        zzrjVar.mSize = size;
        return zzrjVar;
    }

    public void zza(int i, zzrk zzrkVar) {
        int iZzkT = zzkT(i);
        if (iZzkT >= 0) {
            this.zzaWa[iZzkT] = zzrkVar;
            return;
        }
        int iZzkT2 = iZzkT ^ (-1);
        if (iZzkT2 < this.mSize) {
            zzrk[] zzrkVarArr = this.zzaWa;
            if (zzrkVarArr[iZzkT2] == zzaVX) {
                this.zzaVZ[iZzkT2] = i;
                zzrkVarArr[iZzkT2] = zzrkVar;
                return;
            }
        }
        if (this.zzaVY && this.mSize >= this.zzaVZ.length) {
            gc();
            iZzkT2 = zzkT(i) ^ (-1);
        }
        int i2 = this.mSize;
        if (i2 >= this.zzaVZ.length) {
            int iIdealIntArraySize = idealIntArraySize(i2 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzrk[] zzrkVarArr2 = new zzrk[iIdealIntArraySize];
            int[] iArr2 = this.zzaVZ;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzrk[] zzrkVarArr3 = this.zzaWa;
            System.arraycopy(zzrkVarArr3, 0, zzrkVarArr2, 0, zzrkVarArr3.length);
            this.zzaVZ = iArr;
            this.zzaWa = zzrkVarArr2;
        }
        int i3 = this.mSize;
        if (i3 - iZzkT2 != 0) {
            int[] iArr3 = this.zzaVZ;
            int i4 = iZzkT2 + 1;
            System.arraycopy(iArr3, iZzkT2, iArr3, i4, i3 - iZzkT2);
            zzrk[] zzrkVarArr4 = this.zzaWa;
            System.arraycopy(zzrkVarArr4, iZzkT2, zzrkVarArr4, i4, this.mSize - iZzkT2);
        }
        this.zzaVZ[iZzkT2] = i;
        this.zzaWa[iZzkT2] = zzrkVar;
        this.mSize++;
    }

    public zzrk zzkR(int i) {
        int iZzkT = zzkT(i);
        if (iZzkT < 0) {
            return null;
        }
        zzrk[] zzrkVarArr = this.zzaWa;
        if (zzrkVarArr[iZzkT] == zzaVX) {
            return null;
        }
        return zzrkVarArr[iZzkT];
    }

    public zzrk zzkS(int i) {
        if (this.zzaVY) {
            gc();
        }
        return this.zzaWa[i];
    }
}
