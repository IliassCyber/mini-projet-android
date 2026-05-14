package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzrd extends zzrh<zzrd> {
    public String[] zzaVE;
    public int[] zzaVF;
    public byte[][] zzaVG;

    public zzrd() {
        zzBq();
    }

    public static zzrd zzx(byte[] bArr) throws zzrm {
        return (zzrd) zzrn.zza(new zzrd(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrd)) {
            return false;
        }
        zzrd zzrdVar = (zzrd) obj;
        if (zzrl.equals(this.zzaVE, zzrdVar.zzaVE) && zzrl.equals(this.zzaVF, zzrdVar.zzaVF) && zzrl.zza(this.zzaVG, zzrdVar.zzaVG)) {
            return zza(zzrdVar);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + zzrl.hashCode(this.zzaVE)) * 31) + zzrl.hashCode(this.zzaVF)) * 31) + zzrl.zza(this.zzaVG)) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        int[] iArr;
        int iZzB = super.zzB();
        String[] strArr = this.zzaVE;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iZzfj = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.zzaVE;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iZzfj += zzrg.zzfj(str);
                }
                i2++;
            }
            iZzB = iZzB + iZzfj + (i3 * 1);
        }
        int[] iArr2 = this.zzaVF;
        if (iArr2 != null && iArr2.length > 0) {
            int i4 = 0;
            int iZzkJ = 0;
            while (true) {
                iArr = this.zzaVF;
                if (i4 >= iArr.length) {
                    break;
                }
                iZzkJ += zzrg.zzkJ(iArr[i4]);
                i4++;
            }
            iZzB = iZzB + iZzkJ + (iArr.length * 1);
        }
        byte[][] bArr = this.zzaVG;
        if (bArr == null || bArr.length <= 0) {
            return iZzB;
        }
        int iZzC = 0;
        int i5 = 0;
        while (true) {
            byte[][] bArr2 = this.zzaVG;
            if (i >= bArr2.length) {
                return iZzB + iZzC + (i5 * 1);
            }
            byte[] bArr3 = bArr2[i];
            if (bArr3 != null) {
                i5++;
                iZzC += zzrg.zzC(bArr3);
            }
            i++;
        }
    }

    public zzrd zzBq() {
        this.zzaVE = zzrq.zzaWm;
        this.zzaVF = zzrq.zzaWh;
        this.zzaVG = zzrq.zzaWn;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        String[] strArr = this.zzaVE;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzaVE;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    zzrgVar.zzb(1, str);
                }
                i2++;
            }
        }
        int[] iArr = this.zzaVF;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.zzaVF;
                if (i3 >= iArr2.length) {
                    break;
                }
                zzrgVar.zzy(2, iArr2[i3]);
                i3++;
            }
        }
        byte[][] bArr = this.zzaVG;
        if (bArr != null && bArr.length > 0) {
            while (true) {
                byte[][] bArr2 = this.zzaVG;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    zzrgVar.zza(3, bArr3);
                }
                i++;
            }
        }
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public zzrd zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int iZzBr = zzrfVar.zzBr();
            if (iZzBr == 0) {
                return this;
            }
            if (iZzBr == 10) {
                int iZzb = zzrq.zzb(zzrfVar, 10);
                String[] strArr = this.zzaVE;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[iZzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzaVE, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzrfVar.readString();
                    zzrfVar.zzBr();
                    length++;
                }
                strArr2[length] = zzrfVar.readString();
                this.zzaVE = strArr2;
            } else if (iZzBr == 16) {
                int iZzb2 = zzrq.zzb(zzrfVar, 16);
                int[] iArr = this.zzaVF;
                int length2 = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[iZzb2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.zzaVF, 0, iArr2, 0, length2);
                }
                while (length2 < iArr2.length - 1) {
                    iArr2[length2] = zzrfVar.zzBu();
                    zzrfVar.zzBr();
                    length2++;
                }
                iArr2[length2] = zzrfVar.zzBu();
                this.zzaVF = iArr2;
            } else if (iZzBr == 18) {
                int iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                int position = zzrfVar.getPosition();
                int i = 0;
                while (zzrfVar.zzBD() > 0) {
                    zzrfVar.zzBu();
                    i++;
                }
                zzrfVar.zzkE(position);
                int[] iArr3 = this.zzaVF;
                int length3 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length3];
                if (length3 != 0) {
                    System.arraycopy(this.zzaVF, 0, iArr4, 0, length3);
                }
                while (length3 < iArr4.length) {
                    iArr4[length3] = zzrfVar.zzBu();
                    length3++;
                }
                this.zzaVF = iArr4;
                zzrfVar.zzkD(iZzkC);
            } else if (iZzBr == 26) {
                int iZzb3 = zzrq.zzb(zzrfVar, 26);
                byte[][] bArr = this.zzaVG;
                int length4 = bArr == null ? 0 : bArr.length;
                byte[][] bArr2 = new byte[iZzb3 + length4][];
                if (length4 != 0) {
                    System.arraycopy(this.zzaVG, 0, bArr2, 0, length4);
                }
                while (length4 < bArr2.length - 1) {
                    bArr2[length4] = zzrfVar.readBytes();
                    zzrfVar.zzBr();
                    length4++;
                }
                bArr2[length4] = zzrfVar.readBytes();
                this.zzaVG = bArr2;
            } else if (!zza(zzrfVar, iZzBr)) {
                return this;
            }
        }
    }
}
