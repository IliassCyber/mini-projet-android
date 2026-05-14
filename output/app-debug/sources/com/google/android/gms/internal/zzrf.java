package com.google.android.gms.internal;

import android.support.v7.internal.widget.ActivityChooserView;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzrf {
    private final byte[] buffer;
    private int zzaVK;
    private int zzaVL;
    private int zzaVM;
    private int zzaVN;
    private int zzaVO;
    private int zzaVQ;
    private int zzaVP = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzaVR = 64;
    private int zzaVS = 67108864;

    private zzrf(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzaVK = i;
        this.zzaVL = i2 + i;
        this.zzaVN = i;
    }

    private void zzBC() {
        this.zzaVL += this.zzaVM;
        int i = this.zzaVL;
        int i2 = this.zzaVP;
        if (i <= i2) {
            this.zzaVM = 0;
        } else {
            this.zzaVM = i - i2;
            this.zzaVL = i - this.zzaVM;
        }
    }

    public static long zzV(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzrf zza(byte[] bArr, int i, int i2) {
        return new zzrf(bArr, i, i2);
    }

    public static int zzkB(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static zzrf zzz(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public int getPosition() {
        return this.zzaVN - this.zzaVK;
    }

    public byte[] readBytes() throws IOException {
        int iZzBy = zzBy();
        int i = this.zzaVL;
        int i2 = this.zzaVN;
        if (iZzBy > i - i2 || iZzBy <= 0) {
            return zzkF(iZzBy);
        }
        byte[] bArr = new byte[iZzBy];
        System.arraycopy(this.buffer, i2, bArr, 0, iZzBy);
        this.zzaVN += iZzBy;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzBB());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzBA());
    }

    public String readString() throws IOException {
        int iZzBy = zzBy();
        int i = this.zzaVL;
        int i2 = this.zzaVN;
        if (iZzBy > i - i2 || iZzBy <= 0) {
            return new String(zzkF(iZzBy), "UTF-8");
        }
        String str = new String(this.buffer, i2, iZzBy, "UTF-8");
        this.zzaVN += iZzBy;
        return str;
    }

    public int zzBA() throws IOException {
        return (zzBF() & 255) | ((zzBF() & 255) << 8) | ((zzBF() & 255) << 16) | ((zzBF() & 255) << 24);
    }

    public long zzBB() throws IOException {
        byte bZzBF = zzBF();
        return ((((long) zzBF()) & 255) << 8) | (((long) bZzBF) & 255) | ((((long) zzBF()) & 255) << 16) | ((((long) zzBF()) & 255) << 24) | ((((long) zzBF()) & 255) << 32) | ((((long) zzBF()) & 255) << 40) | ((((long) zzBF()) & 255) << 48) | ((((long) zzBF()) & 255) << 56);
    }

    public int zzBD() {
        int i = this.zzaVP;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzaVN;
    }

    public boolean zzBE() {
        return this.zzaVN == this.zzaVL;
    }

    public byte zzBF() throws IOException {
        int i = this.zzaVN;
        if (i == this.zzaVL) {
            throw zzrm.zzBN();
        }
        byte[] bArr = this.buffer;
        this.zzaVN = i + 1;
        return bArr[i];
    }

    public int zzBr() throws IOException {
        if (zzBE()) {
            this.zzaVO = 0;
            return 0;
        }
        this.zzaVO = zzBy();
        int i = this.zzaVO;
        if (i != 0) {
            return i;
        }
        throw zzrm.zzBQ();
    }

    public void zzBs() throws IOException {
        int iZzBr;
        do {
            iZzBr = zzBr();
            if (iZzBr == 0) {
                return;
            }
        } while (zzkA(iZzBr));
    }

    public long zzBt() throws IOException {
        return zzBz();
    }

    public int zzBu() throws IOException {
        return zzBy();
    }

    public boolean zzBv() throws IOException {
        return zzBy() != 0;
    }

    public int zzBw() throws IOException {
        return zzkB(zzBy());
    }

    public long zzBx() throws IOException {
        return zzV(zzBz());
    }

    public int zzBy() throws IOException {
        int i;
        byte bZzBF = zzBF();
        if (bZzBF >= 0) {
            return bZzBF;
        }
        int i2 = bZzBF & 127;
        byte bZzBF2 = zzBF();
        if (bZzBF2 >= 0) {
            i = bZzBF2 << 7;
        } else {
            i2 |= (bZzBF2 & 127) << 7;
            byte bZzBF3 = zzBF();
            if (bZzBF3 >= 0) {
                i = bZzBF3 << 14;
            } else {
                i2 |= (bZzBF3 & 127) << 14;
                byte bZzBF4 = zzBF();
                if (bZzBF4 < 0) {
                    int i3 = i2 | ((bZzBF4 & 127) << 21);
                    byte bZzBF5 = zzBF();
                    int i4 = i3 | (bZzBF5 << 28);
                    if (bZzBF5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzBF() >= 0) {
                            return i4;
                        }
                    }
                    throw zzrm.zzBP();
                }
                i = bZzBF4 << 21;
            }
        }
        return i2 | i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long zzBz() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzBF = zzBF();
            j |= ((long) (bZzBF & 127)) << i;
            if ((bZzBF & 128) == 0) {
                return j;
            }
        }
        throw zzrm.zzBP();
    }

    public void zza(zzrn zzrnVar) throws IOException {
        int iZzBy = zzBy();
        if (this.zzaVQ >= this.zzaVR) {
            throw zzrm.zzBT();
        }
        int iZzkC = zzkC(iZzBy);
        this.zzaVQ++;
        zzrnVar.zzb(this);
        zzkz(0);
        this.zzaVQ--;
        zzkD(iZzkC);
    }

    public void zza(zzrn zzrnVar, int i) throws IOException {
        int i2 = this.zzaVQ;
        if (i2 >= this.zzaVR) {
            throw zzrm.zzBT();
        }
        this.zzaVQ = i2 + 1;
        zzrnVar.zzb(this);
        zzkz(zzrq.zzD(i, 4));
        this.zzaVQ--;
    }

    public boolean zzkA(int i) throws IOException {
        switch (zzrq.zzkU(i)) {
            case 0:
                zzBu();
                return true;
            case 1:
                zzBB();
                return true;
            case 2:
                zzkG(zzBy());
                return true;
            case 3:
                zzBs();
                zzkz(zzrq.zzD(zzrq.zzkV(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzBA();
                return true;
            default:
                throw zzrm.zzBS();
        }
    }

    public int zzkC(int i) throws zzrm {
        if (i < 0) {
            throw zzrm.zzBO();
        }
        int i2 = i + this.zzaVN;
        int i3 = this.zzaVP;
        if (i2 > i3) {
            throw zzrm.zzBN();
        }
        this.zzaVP = i2;
        zzBC();
        return i3;
    }

    public void zzkD(int i) {
        this.zzaVP = i;
        zzBC();
    }

    public void zzkE(int i) {
        int i2 = this.zzaVN;
        int i3 = this.zzaVK;
        if (i > i2 - i3) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzaVN - this.zzaVK));
        }
        if (i >= 0) {
            this.zzaVN = i3 + i;
            return;
        }
        throw new IllegalArgumentException("Bad position " + i);
    }

    public byte[] zzkF(int i) throws IOException {
        if (i < 0) {
            throw zzrm.zzBO();
        }
        int i2 = this.zzaVN;
        int i3 = i2 + i;
        int i4 = this.zzaVP;
        if (i3 > i4) {
            zzkG(i4 - i2);
            throw zzrm.zzBN();
        }
        if (i > this.zzaVL - i2) {
            throw zzrm.zzBN();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i);
        this.zzaVN += i;
        return bArr;
    }

    public void zzkG(int i) throws IOException {
        if (i < 0) {
            throw zzrm.zzBO();
        }
        int i2 = this.zzaVN;
        int i3 = i2 + i;
        int i4 = this.zzaVP;
        if (i3 > i4) {
            zzkG(i4 - i2);
            throw zzrm.zzBN();
        }
        if (i > this.zzaVL - i2) {
            throw zzrm.zzBN();
        }
        this.zzaVN = i2 + i;
    }

    public void zzkz(int i) throws zzrm {
        if (this.zzaVO != i) {
            throw zzrm.zzBR();
        }
    }

    public byte[] zzx(int i, int i2) {
        if (i2 == 0) {
            return zzrq.zzaWo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzaVK + i, bArr, 0, i2);
        return bArr;
    }
}
