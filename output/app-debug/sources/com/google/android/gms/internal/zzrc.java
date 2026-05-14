package com.google.android.gms.internal;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzrc extends zzrh<zzrc> {
    public zza[] zzaVl;

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zzaVm;
        public String name;
        public C0163zza zzaVn;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzrc$zza$zza, reason: collision with other inner class name */
        public static final class C0163zza extends zzrh<C0163zza> {
            private static volatile C0163zza[] zzaVo;
            public int type;
            public C0164zza zzaVp;

            /* JADX INFO: renamed from: com.google.android.gms.internal.zzrc$zza$zza$zza, reason: collision with other inner class name */
            public static final class C0164zza extends zzrh<C0164zza> {
                public String[] zzaVA;
                public long[] zzaVB;
                public float[] zzaVC;
                public long zzaVD;
                public byte[] zzaVq;
                public String zzaVr;
                public double zzaVs;
                public float zzaVt;
                public long zzaVu;
                public int zzaVv;
                public int zzaVw;
                public boolean zzaVx;
                public zza[] zzaVy;
                public C0163zza[] zzaVz;

                public C0164zza() {
                    zzBp();
                }

                public boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof C0164zza)) {
                        return false;
                    }
                    C0164zza c0164zza = (C0164zza) obj;
                    if (!Arrays.equals(this.zzaVq, c0164zza.zzaVq)) {
                        return false;
                    }
                    String str = this.zzaVr;
                    if (str == null) {
                        if (c0164zza.zzaVr != null) {
                            return false;
                        }
                    } else if (!str.equals(c0164zza.zzaVr)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.zzaVs) == Double.doubleToLongBits(c0164zza.zzaVs) && Float.floatToIntBits(this.zzaVt) == Float.floatToIntBits(c0164zza.zzaVt) && this.zzaVu == c0164zza.zzaVu && this.zzaVv == c0164zza.zzaVv && this.zzaVw == c0164zza.zzaVw && this.zzaVx == c0164zza.zzaVx && zzrl.equals(this.zzaVy, c0164zza.zzaVy) && zzrl.equals(this.zzaVz, c0164zza.zzaVz) && zzrl.equals(this.zzaVA, c0164zza.zzaVA) && zzrl.equals(this.zzaVB, c0164zza.zzaVB) && zzrl.equals(this.zzaVC, c0164zza.zzaVC) && this.zzaVD == c0164zza.zzaVD) {
                        return zza(c0164zza);
                    }
                    return false;
                }

                public int hashCode() {
                    int iHashCode = (527 + Arrays.hashCode(this.zzaVq)) * 31;
                    String str = this.zzaVr;
                    int iHashCode2 = str == null ? 0 : str.hashCode();
                    long jDoubleToLongBits = Double.doubleToLongBits(this.zzaVs);
                    int iFloatToIntBits = (((((iHashCode + iHashCode2) * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzaVt)) * 31;
                    long j = this.zzaVu;
                    int iHashCode3 = (((((((((((((((((iFloatToIntBits + ((int) (j ^ (j >>> 32)))) * 31) + this.zzaVv) * 31) + this.zzaVw) * 31) + (this.zzaVx ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zzaVy)) * 31) + zzrl.hashCode(this.zzaVz)) * 31) + zzrl.hashCode(this.zzaVA)) * 31) + zzrl.hashCode(this.zzaVB)) * 31) + zzrl.hashCode(this.zzaVC)) * 31;
                    long j2 = this.zzaVD;
                    return ((iHashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + zzBI();
                }

                @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
                protected int zzB() {
                    long[] jArr;
                    int iZzB = super.zzB();
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        iZzB += zzrg.zzb(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        iZzB += zzrg.zzk(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        iZzB += zzrg.zzb(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        iZzB += zzrg.zzc(4, this.zzaVt);
                    }
                    long j = this.zzaVu;
                    if (j != 0) {
                        iZzB += zzrg.zzd(5, j);
                    }
                    int i = this.zzaVv;
                    if (i != 0) {
                        iZzB += zzrg.zzA(6, i);
                    }
                    int i2 = this.zzaVw;
                    if (i2 != 0) {
                        iZzB += zzrg.zzB(7, i2);
                    }
                    boolean z = this.zzaVx;
                    if (z) {
                        iZzB += zzrg.zzc(8, z);
                    }
                    zza[] zzaVarArr = this.zzaVy;
                    int i3 = 0;
                    if (zzaVarArr != null && zzaVarArr.length > 0) {
                        int iZzc = iZzB;
                        int i4 = 0;
                        while (true) {
                            zza[] zzaVarArr2 = this.zzaVy;
                            if (i4 >= zzaVarArr2.length) {
                                break;
                            }
                            zza zzaVar = zzaVarArr2[i4];
                            if (zzaVar != null) {
                                iZzc += zzrg.zzc(9, zzaVar);
                            }
                            i4++;
                        }
                        iZzB = iZzc;
                    }
                    C0163zza[] c0163zzaArr = this.zzaVz;
                    if (c0163zzaArr != null && c0163zzaArr.length > 0) {
                        int iZzc2 = iZzB;
                        int i5 = 0;
                        while (true) {
                            C0163zza[] c0163zzaArr2 = this.zzaVz;
                            if (i5 >= c0163zzaArr2.length) {
                                break;
                            }
                            C0163zza c0163zza = c0163zzaArr2[i5];
                            if (c0163zza != null) {
                                iZzc2 += zzrg.zzc(10, c0163zza);
                            }
                            i5++;
                        }
                        iZzB = iZzc2;
                    }
                    String[] strArr = this.zzaVA;
                    if (strArr != null && strArr.length > 0) {
                        int i6 = 0;
                        int iZzfj = 0;
                        int i7 = 0;
                        while (true) {
                            String[] strArr2 = this.zzaVA;
                            if (i6 >= strArr2.length) {
                                break;
                            }
                            String str = strArr2[i6];
                            if (str != null) {
                                i7++;
                                iZzfj += zzrg.zzfj(str);
                            }
                            i6++;
                        }
                        iZzB = iZzB + iZzfj + (i7 * 1);
                    }
                    long[] jArr2 = this.zzaVB;
                    if (jArr2 != null && jArr2.length > 0) {
                        int iZzY = 0;
                        while (true) {
                            jArr = this.zzaVB;
                            if (i3 >= jArr.length) {
                                break;
                            }
                            iZzY += zzrg.zzY(jArr[i3]);
                            i3++;
                        }
                        iZzB = iZzB + iZzY + (jArr.length * 1);
                    }
                    long j2 = this.zzaVD;
                    if (j2 != 0) {
                        iZzB += zzrg.zzd(13, j2);
                    }
                    float[] fArr = this.zzaVC;
                    return (fArr == null || fArr.length <= 0) ? iZzB : iZzB + (fArr.length * 4) + (fArr.length * 1);
                }

                public C0164zza zzBp() {
                    this.zzaVq = zzrq.zzaWo;
                    this.zzaVr = "";
                    this.zzaVs = 0.0d;
                    this.zzaVt = 0.0f;
                    this.zzaVu = 0L;
                    this.zzaVv = 0;
                    this.zzaVw = 0;
                    this.zzaVx = false;
                    this.zzaVy = zza.zzBl();
                    this.zzaVz = C0163zza.zzBn();
                    this.zzaVA = zzrq.zzaWm;
                    this.zzaVB = zzrq.zzaWi;
                    this.zzaVC = zzrq.zzaWj;
                    this.zzaVD = 0L;
                    this.zzaVU = null;
                    this.zzaWf = -1;
                    return this;
                }

                @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
                public void zza(zzrg zzrgVar) throws IOException {
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        zzrgVar.zza(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        zzrgVar.zzb(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        zzrgVar.zza(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        zzrgVar.zzb(4, this.zzaVt);
                    }
                    long j = this.zzaVu;
                    if (j != 0) {
                        zzrgVar.zzb(5, j);
                    }
                    int i = this.zzaVv;
                    if (i != 0) {
                        zzrgVar.zzy(6, i);
                    }
                    int i2 = this.zzaVw;
                    if (i2 != 0) {
                        zzrgVar.zzz(7, i2);
                    }
                    boolean z = this.zzaVx;
                    if (z) {
                        zzrgVar.zzb(8, z);
                    }
                    zza[] zzaVarArr = this.zzaVy;
                    int i3 = 0;
                    if (zzaVarArr != null && zzaVarArr.length > 0) {
                        int i4 = 0;
                        while (true) {
                            zza[] zzaVarArr2 = this.zzaVy;
                            if (i4 >= zzaVarArr2.length) {
                                break;
                            }
                            zza zzaVar = zzaVarArr2[i4];
                            if (zzaVar != null) {
                                zzrgVar.zza(9, zzaVar);
                            }
                            i4++;
                        }
                    }
                    C0163zza[] c0163zzaArr = this.zzaVz;
                    if (c0163zzaArr != null && c0163zzaArr.length > 0) {
                        int i5 = 0;
                        while (true) {
                            C0163zza[] c0163zzaArr2 = this.zzaVz;
                            if (i5 >= c0163zzaArr2.length) {
                                break;
                            }
                            C0163zza c0163zza = c0163zzaArr2[i5];
                            if (c0163zza != null) {
                                zzrgVar.zza(10, c0163zza);
                            }
                            i5++;
                        }
                    }
                    String[] strArr = this.zzaVA;
                    if (strArr != null && strArr.length > 0) {
                        int i6 = 0;
                        while (true) {
                            String[] strArr2 = this.zzaVA;
                            if (i6 >= strArr2.length) {
                                break;
                            }
                            String str = strArr2[i6];
                            if (str != null) {
                                zzrgVar.zzb(11, str);
                            }
                            i6++;
                        }
                    }
                    long[] jArr = this.zzaVB;
                    if (jArr != null && jArr.length > 0) {
                        int i7 = 0;
                        while (true) {
                            long[] jArr2 = this.zzaVB;
                            if (i7 >= jArr2.length) {
                                break;
                            }
                            zzrgVar.zzb(12, jArr2[i7]);
                            i7++;
                        }
                    }
                    long j2 = this.zzaVD;
                    if (j2 != 0) {
                        zzrgVar.zzb(13, j2);
                    }
                    float[] fArr = this.zzaVC;
                    if (fArr != null && fArr.length > 0) {
                        while (true) {
                            float[] fArr2 = this.zzaVC;
                            if (i3 >= fArr2.length) {
                                break;
                            }
                            zzrgVar.zzb(14, fArr2[i3]);
                            i3++;
                        }
                    }
                    super.zza(zzrgVar);
                }

                @Override // com.google.android.gms.internal.zzrn
                /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
                public C0164zza zzb(zzrf zzrfVar) throws IOException {
                    while (true) {
                        int iZzBr = zzrfVar.zzBr();
                        switch (iZzBr) {
                            case 0:
                                return this;
                            case 10:
                                this.zzaVq = zzrfVar.readBytes();
                                break;
                            case 18:
                                this.zzaVr = zzrfVar.readString();
                                break;
                            case 25:
                                this.zzaVs = zzrfVar.readDouble();
                                break;
                            case 37:
                                this.zzaVt = zzrfVar.readFloat();
                                break;
                            case 40:
                                this.zzaVu = zzrfVar.zzBt();
                                break;
                            case 48:
                                this.zzaVv = zzrfVar.zzBu();
                                break;
                            case 56:
                                this.zzaVw = zzrfVar.zzBw();
                                break;
                            case 64:
                                this.zzaVx = zzrfVar.zzBv();
                                break;
                            case 74:
                                int iZzb = zzrq.zzb(zzrfVar, 74);
                                zza[] zzaVarArr = this.zzaVy;
                                int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                                zza[] zzaVarArr2 = new zza[iZzb + length];
                                if (length != 0) {
                                    System.arraycopy(this.zzaVy, 0, zzaVarArr2, 0, length);
                                }
                                while (length < zzaVarArr2.length - 1) {
                                    zzaVarArr2[length] = new zza();
                                    zzrfVar.zza(zzaVarArr2[length]);
                                    zzrfVar.zzBr();
                                    length++;
                                }
                                zzaVarArr2[length] = new zza();
                                zzrfVar.zza(zzaVarArr2[length]);
                                this.zzaVy = zzaVarArr2;
                                break;
                            case 82:
                                int iZzb2 = zzrq.zzb(zzrfVar, 82);
                                C0163zza[] c0163zzaArr = this.zzaVz;
                                int length2 = c0163zzaArr == null ? 0 : c0163zzaArr.length;
                                C0163zza[] c0163zzaArr2 = new C0163zza[iZzb2 + length2];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzaVz, 0, c0163zzaArr2, 0, length2);
                                }
                                while (length2 < c0163zzaArr2.length - 1) {
                                    c0163zzaArr2[length2] = new C0163zza();
                                    zzrfVar.zza(c0163zzaArr2[length2]);
                                    zzrfVar.zzBr();
                                    length2++;
                                }
                                c0163zzaArr2[length2] = new C0163zza();
                                zzrfVar.zza(c0163zzaArr2[length2]);
                                this.zzaVz = c0163zzaArr2;
                                break;
                            case 90:
                                int iZzb3 = zzrq.zzb(zzrfVar, 90);
                                String[] strArr = this.zzaVA;
                                int length3 = strArr == null ? 0 : strArr.length;
                                String[] strArr2 = new String[iZzb3 + length3];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzaVA, 0, strArr2, 0, length3);
                                }
                                while (length3 < strArr2.length - 1) {
                                    strArr2[length3] = zzrfVar.readString();
                                    zzrfVar.zzBr();
                                    length3++;
                                }
                                strArr2[length3] = zzrfVar.readString();
                                this.zzaVA = strArr2;
                                break;
                            case Place.TYPE_ZOO /* 96 */:
                                int iZzb4 = zzrq.zzb(zzrfVar, 96);
                                long[] jArr = this.zzaVB;
                                int length4 = jArr == null ? 0 : jArr.length;
                                long[] jArr2 = new long[iZzb4 + length4];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzaVB, 0, jArr2, 0, length4);
                                }
                                while (length4 < jArr2.length - 1) {
                                    jArr2[length4] = zzrfVar.zzBt();
                                    zzrfVar.zzBr();
                                    length4++;
                                }
                                jArr2[length4] = zzrfVar.zzBt();
                                this.zzaVB = jArr2;
                                break;
                            case 98:
                                int iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                                int position = zzrfVar.getPosition();
                                int i = 0;
                                while (zzrfVar.zzBD() > 0) {
                                    zzrfVar.zzBt();
                                    i++;
                                }
                                zzrfVar.zzkE(position);
                                long[] jArr3 = this.zzaVB;
                                int length5 = jArr3 == null ? 0 : jArr3.length;
                                long[] jArr4 = new long[i + length5];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzaVB, 0, jArr4, 0, length5);
                                }
                                while (length5 < jArr4.length) {
                                    jArr4[length5] = zzrfVar.zzBt();
                                    length5++;
                                }
                                this.zzaVB = jArr4;
                                zzrfVar.zzkD(iZzkC);
                                break;
                            case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                                this.zzaVD = zzrfVar.zzBt();
                                break;
                            case 114:
                                int iZzBy = zzrfVar.zzBy();
                                int iZzkC2 = zzrfVar.zzkC(iZzBy);
                                int i2 = iZzBy / 4;
                                float[] fArr = this.zzaVC;
                                int length6 = fArr == null ? 0 : fArr.length;
                                float[] fArr2 = new float[i2 + length6];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzaVC, 0, fArr2, 0, length6);
                                }
                                while (length6 < fArr2.length) {
                                    fArr2[length6] = zzrfVar.readFloat();
                                    length6++;
                                }
                                this.zzaVC = fArr2;
                                zzrfVar.zzkD(iZzkC2);
                                break;
                            case 117:
                                int iZzb5 = zzrq.zzb(zzrfVar, 117);
                                float[] fArr3 = this.zzaVC;
                                int length7 = fArr3 == null ? 0 : fArr3.length;
                                float[] fArr4 = new float[iZzb5 + length7];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzaVC, 0, fArr4, 0, length7);
                                }
                                while (length7 < fArr4.length - 1) {
                                    fArr4[length7] = zzrfVar.readFloat();
                                    zzrfVar.zzBr();
                                    length7++;
                                }
                                fArr4[length7] = zzrfVar.readFloat();
                                this.zzaVC = fArr4;
                                break;
                            default:
                                if (!zza(zzrfVar, iZzBr)) {
                                    return this;
                                }
                                break;
                                break;
                        }
                    }
                }
            }

            public C0163zza() {
                zzBo();
            }

            public static C0163zza[] zzBn() {
                if (zzaVo == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzaVo == null) {
                            zzaVo = new C0163zza[0];
                        }
                    }
                }
                return zzaVo;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0163zza)) {
                    return false;
                }
                C0163zza c0163zza = (C0163zza) obj;
                if (this.type != c0163zza.type) {
                    return false;
                }
                C0164zza c0164zza = this.zzaVp;
                if (c0164zza == null) {
                    if (c0163zza.zzaVp != null) {
                        return false;
                    }
                } else if (!c0164zza.equals(c0163zza.zzaVp)) {
                    return false;
                }
                return zza(c0163zza);
            }

            public int hashCode() {
                int i = (527 + this.type) * 31;
                C0164zza c0164zza = this.zzaVp;
                return ((i + (c0164zza == null ? 0 : c0164zza.hashCode())) * 31) + zzBI();
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            protected int zzB() {
                int iZzB = super.zzB() + zzrg.zzA(1, this.type);
                C0164zza c0164zza = this.zzaVp;
                return c0164zza != null ? iZzB + zzrg.zzc(2, c0164zza) : iZzB;
            }

            public C0163zza zzBo() {
                this.type = 1;
                this.zzaVp = null;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrgVar) throws IOException {
                zzrgVar.zzy(1, this.type);
                C0164zza c0164zza = this.zzaVp;
                if (c0164zza != null) {
                    zzrgVar.zza(2, c0164zza);
                }
                super.zza(zzrgVar);
            }

            @Override // com.google.android.gms.internal.zzrn
            /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
            public C0163zza zzb(zzrf zzrfVar) throws IOException {
                while (true) {
                    int iZzBr = zzrfVar.zzBr();
                    if (iZzBr == 0) {
                        return this;
                    }
                    if (iZzBr == 8) {
                        int iZzBu = zzrfVar.zzBu();
                        switch (iZzBu) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                this.type = iZzBu;
                                break;
                        }
                    } else if (iZzBr == 18) {
                        if (this.zzaVp == null) {
                            this.zzaVp = new C0164zza();
                        }
                        zzrfVar.zza(this.zzaVp);
                    } else if (!zza(zzrfVar, iZzBr)) {
                        return this;
                    }
                }
            }
        }

        public zza() {
            zzBm();
        }

        public static zza[] zzBl() {
            if (zzaVm == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzaVm == null) {
                        zzaVm = new zza[0];
                    }
                }
            }
            return zzaVm;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            String str = this.name;
            if (str == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!str.equals(zzaVar.name)) {
                return false;
            }
            C0163zza c0163zza = this.zzaVn;
            if (c0163zza == null) {
                if (zzaVar.zzaVn != null) {
                    return false;
                }
            } else if (!c0163zza.equals(zzaVar.zzaVn)) {
                return false;
            }
            return zza(zzaVar);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            C0163zza c0163zza = this.zzaVn;
            return ((iHashCode + (c0163zza != null ? c0163zza.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB() + zzrg.zzk(1, this.name);
            C0163zza c0163zza = this.zzaVn;
            return c0163zza != null ? iZzB + zzrg.zzc(2, c0163zza) : iZzB;
        }

        public zza zzBm() {
            this.name = "";
            this.zzaVn = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzb(1, this.name);
            C0163zza c0163zza = this.zzaVn;
            if (c0163zza != null) {
                zzrgVar.zza(2, c0163zza);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.name = zzrfVar.readString();
                } else if (iZzBr == 18) {
                    if (this.zzaVn == null) {
                        this.zzaVn = new C0163zza();
                    }
                    zzrfVar.zza(this.zzaVn);
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }

    public zzrc() {
        zzBk();
    }

    public static zzrc zzw(byte[] bArr) throws zzrm {
        return (zzrc) zzrn.zza(new zzrc(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrc)) {
            return false;
        }
        zzrc zzrcVar = (zzrc) obj;
        if (zzrl.equals(this.zzaVl, zzrcVar.zzaVl)) {
            return zza(zzrcVar);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + zzrl.hashCode(this.zzaVl)) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        int iZzB = super.zzB();
        zza[] zzaVarArr = this.zzaVl;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zza[] zzaVarArr2 = this.zzaVl;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    iZzB += zzrg.zzc(1, zzaVar);
                }
                i++;
            }
        }
        return iZzB;
    }

    public zzrc zzBk() {
        this.zzaVl = zza.zzBl();
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        zza[] zzaVarArr = this.zzaVl;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i = 0;
            while (true) {
                zza[] zzaVarArr2 = this.zzaVl;
                if (i >= zzaVarArr2.length) {
                    break;
                }
                zza zzaVar = zzaVarArr2[i];
                if (zzaVar != null) {
                    zzrgVar.zza(1, zzaVar);
                }
                i++;
            }
        }
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public zzrc zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int iZzBr = zzrfVar.zzBr();
            if (iZzBr == 0) {
                return this;
            }
            if (iZzBr == 10) {
                int iZzb = zzrq.zzb(zzrfVar, 10);
                zza[] zzaVarArr = this.zzaVl;
                int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                zza[] zzaVarArr2 = new zza[iZzb + length];
                if (length != 0) {
                    System.arraycopy(this.zzaVl, 0, zzaVarArr2, 0, length);
                }
                while (length < zzaVarArr2.length - 1) {
                    zzaVarArr2[length] = new zza();
                    zzrfVar.zza(zzaVarArr2[length]);
                    zzrfVar.zzBr();
                    length++;
                }
                zzaVarArr2[length] = new zza();
                zzrfVar.zza(zzaVarArr2[length]);
                this.zzaVl = zzaVarArr2;
            } else if (!zza(zzrfVar, iZzBr)) {
                return this;
            }
        }
    }
}
