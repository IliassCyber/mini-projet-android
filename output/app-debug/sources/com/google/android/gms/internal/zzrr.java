package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public interface zzrr {

    public static final class zza extends zzrh<zza> {
        public String[] zzaWp;
        public String[] zzaWq;
        public int[] zzaWr;
        public int[] zzaWs;

        public zza() {
            zzBW();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (zzrl.equals(this.zzaWp, zzaVar.zzaWp) && zzrl.equals(this.zzaWq, zzaVar.zzaWq) && zzrl.equals(this.zzaWr, zzaVar.zzaWr) && zzrl.equals(this.zzaWs, zzaVar.zzaWs)) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + zzrl.hashCode(this.zzaWp)) * 31) + zzrl.hashCode(this.zzaWq)) * 31) + zzrl.hashCode(this.zzaWr)) * 31) + zzrl.hashCode(this.zzaWs)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int[] iArr;
            int iZzB = super.zzB();
            String[] strArr = this.zzaWp;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iZzfj = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.zzaWp;
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
            String[] strArr3 = this.zzaWq;
            if (strArr3 != null && strArr3.length > 0) {
                int i4 = 0;
                int iZzfj2 = 0;
                int i5 = 0;
                while (true) {
                    String[] strArr4 = this.zzaWq;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i4];
                    if (str2 != null) {
                        i5++;
                        iZzfj2 += zzrg.zzfj(str2);
                    }
                    i4++;
                }
                iZzB = iZzB + iZzfj2 + (i5 * 1);
            }
            int[] iArr2 = this.zzaWr;
            if (iArr2 != null && iArr2.length > 0) {
                int i6 = 0;
                int iZzkJ = 0;
                while (true) {
                    iArr = this.zzaWr;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    iZzkJ += zzrg.zzkJ(iArr[i6]);
                    i6++;
                }
                iZzB = iZzB + iZzkJ + (iArr.length * 1);
            }
            int[] iArr3 = this.zzaWs;
            if (iArr3 == null || iArr3.length <= 0) {
                return iZzB;
            }
            int iZzkJ2 = 0;
            while (true) {
                int[] iArr4 = this.zzaWs;
                if (i >= iArr4.length) {
                    return iZzB + iZzkJ2 + (iArr4.length * 1);
                }
                iZzkJ2 += zzrg.zzkJ(iArr4[i]);
                i++;
            }
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            int iZzkC;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    int iZzb = zzrq.zzb(zzrfVar, 10);
                    String[] strArr = this.zzaWp;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzaWp, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = zzrfVar.readString();
                        zzrfVar.zzBr();
                        length++;
                    }
                    strArr2[length] = zzrfVar.readString();
                    this.zzaWp = strArr2;
                } else if (iZzBr == 18) {
                    int iZzb2 = zzrq.zzb(zzrfVar, 18);
                    String[] strArr3 = this.zzaWq;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[iZzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaWq, 0, strArr4, 0, length2);
                    }
                    while (length2 < strArr4.length - 1) {
                        strArr4[length2] = zzrfVar.readString();
                        zzrfVar.zzBr();
                        length2++;
                    }
                    strArr4[length2] = zzrfVar.readString();
                    this.zzaWq = strArr4;
                } else if (iZzBr != 24) {
                    if (iZzBr == 26) {
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i++;
                        }
                        zzrfVar.zzkE(position);
                        int[] iArr = this.zzaWr;
                        int length3 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[i + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzaWr, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzrfVar.zzBu();
                            length3++;
                        }
                        this.zzaWr = iArr2;
                    } else if (iZzBr == 32) {
                        int iZzb3 = zzrq.zzb(zzrfVar, 32);
                        int[] iArr3 = this.zzaWs;
                        int length4 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[iZzb3 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzaWs, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length - 1) {
                            iArr4[length4] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length4++;
                        }
                        iArr4[length4] = zzrfVar.zzBu();
                        this.zzaWs = iArr4;
                    } else if (iZzBr == 34) {
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position2);
                        int[] iArr5 = this.zzaWs;
                        int length5 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[i2 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzaWs, 0, iArr6, 0, length5);
                        }
                        while (length5 < iArr6.length) {
                            iArr6[length5] = zzrfVar.zzBu();
                            length5++;
                        }
                        this.zzaWs = iArr6;
                    } else if (!zza(zzrfVar, iZzBr)) {
                        return this;
                    }
                    zzrfVar.zzkD(iZzkC);
                } else {
                    int iZzb4 = zzrq.zzb(zzrfVar, 24);
                    int[] iArr7 = this.zzaWr;
                    int length6 = iArr7 == null ? 0 : iArr7.length;
                    int[] iArr8 = new int[iZzb4 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.zzaWr, 0, iArr8, 0, length6);
                    }
                    while (length6 < iArr8.length - 1) {
                        iArr8[length6] = zzrfVar.zzBu();
                        zzrfVar.zzBr();
                        length6++;
                    }
                    iArr8[length6] = zzrfVar.zzBu();
                    this.zzaWr = iArr8;
                }
            }
        }

        public zza zzBW() {
            this.zzaWp = zzrq.zzaWm;
            this.zzaWq = zzrq.zzaWm;
            this.zzaWr = zzrq.zzaWh;
            this.zzaWs = zzrq.zzaWh;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            String[] strArr = this.zzaWp;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.zzaWp;
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
            String[] strArr3 = this.zzaWq;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr4 = this.zzaWq;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        zzrgVar.zzb(2, str2);
                    }
                    i3++;
                }
            }
            int[] iArr = this.zzaWr;
            if (iArr != null && iArr.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.zzaWr;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    zzrgVar.zzy(3, iArr2[i4]);
                    i4++;
                }
            }
            int[] iArr3 = this.zzaWs;
            if (iArr3 != null && iArr3.length > 0) {
                while (true) {
                    int[] iArr4 = this.zzaWs;
                    if (i >= iArr4.length) {
                        break;
                    }
                    zzrgVar.zzy(4, iArr4[i]);
                    i++;
                }
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzb extends zzrh<zzb> {
        public String version;
        public int zzaWt;
        public String zzaWu;

        public zzb() {
            zzBX();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.zzaWt != zzbVar.zzaWt) {
                return false;
            }
            String str = this.zzaWu;
            if (str == null) {
                if (zzbVar.zzaWu != null) {
                    return false;
                }
            } else if (!str.equals(zzbVar.zzaWu)) {
                return false;
            }
            String str2 = this.version;
            if (str2 == null) {
                if (zzbVar.version != null) {
                    return false;
                }
            } else if (!str2.equals(zzbVar.version)) {
                return false;
            }
            return zza(zzbVar);
        }

        public int hashCode() {
            int i = (527 + this.zzaWt) * 31;
            String str = this.zzaWu;
            int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.version;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            int i = this.zzaWt;
            if (i != 0) {
                iZzB += zzrg.zzA(1, i);
            }
            if (!this.zzaWu.equals("")) {
                iZzB += zzrg.zzk(2, this.zzaWu);
            }
            return !this.version.equals("") ? iZzB + zzrg.zzk(3, this.version) : iZzB;
        }

        public zzb zzBX() {
            this.zzaWt = 0;
            this.zzaWu = "";
            this.version = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 8) {
                    int iZzBu = zzrfVar.zzBu();
                    switch (iZzBu) {
                        case 0:
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
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                            this.zzaWt = iZzBu;
                            break;
                    }
                } else if (iZzBr == 18) {
                    this.zzaWu = zzrfVar.readString();
                } else if (iZzBr == 26) {
                    this.version = zzrfVar.readString();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            int i = this.zzaWt;
            if (i != 0) {
                zzrgVar.zzy(1, i);
            }
            if (!this.zzaWu.equals("")) {
                zzrgVar.zzb(2, this.zzaWu);
            }
            if (!this.version.equals("")) {
                zzrgVar.zzb(3, this.version);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public byte[] zzaWv;
        public byte[][] zzaWw;
        public boolean zzaWx;

        public zzc() {
            zzBY();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (Arrays.equals(this.zzaWv, zzcVar.zzaWv) && zzrl.zza(this.zzaWw, zzcVar.zzaWw) && this.zzaWx == zzcVar.zzaWx) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + Arrays.hashCode(this.zzaWv)) * 31) + zzrl.zza(this.zzaWw)) * 31) + (this.zzaWx ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!Arrays.equals(this.zzaWv, zzrq.zzaWo)) {
                iZzB += zzrg.zzb(1, this.zzaWv);
            }
            byte[][] bArr = this.zzaWw;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                int iZzC = 0;
                int i2 = 0;
                while (true) {
                    byte[][] bArr2 = this.zzaWw;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        i2++;
                        iZzC += zzrg.zzC(bArr3);
                    }
                    i++;
                }
                iZzB = iZzB + iZzC + (i2 * 1);
            }
            boolean z = this.zzaWx;
            return z ? iZzB + zzrg.zzc(3, z) : iZzB;
        }

        public zzc zzBY() {
            this.zzaWv = zzrq.zzaWo;
            this.zzaWw = zzrq.zzaWn;
            this.zzaWx = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.zzaWv = zzrfVar.readBytes();
                } else if (iZzBr == 18) {
                    int iZzb = zzrq.zzb(zzrfVar, 18);
                    byte[][] bArr = this.zzaWw;
                    int length = bArr == null ? 0 : bArr.length;
                    byte[][] bArr2 = new byte[iZzb + length][];
                    if (length != 0) {
                        System.arraycopy(this.zzaWw, 0, bArr2, 0, length);
                    }
                    while (length < bArr2.length - 1) {
                        bArr2[length] = zzrfVar.readBytes();
                        zzrfVar.zzBr();
                        length++;
                    }
                    bArr2[length] = zzrfVar.readBytes();
                    this.zzaWw = bArr2;
                } else if (iZzBr == 24) {
                    this.zzaWx = zzrfVar.zzBv();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!Arrays.equals(this.zzaWv, zzrq.zzaWo)) {
                zzrgVar.zza(1, this.zzaWv);
            }
            byte[][] bArr = this.zzaWw;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                while (true) {
                    byte[][] bArr2 = this.zzaWw;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        zzrgVar.zza(2, bArr3);
                    }
                    i++;
                }
            }
            boolean z = this.zzaWx;
            if (z) {
                zzrgVar.zzb(3, z);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String tag;
        public int zzaWA;
        public int zzaWB;
        public boolean zzaWC;
        public zze[] zzaWD;
        public zzb zzaWE;
        public byte[] zzaWF;
        public byte[] zzaWG;
        public byte[] zzaWH;
        public zza zzaWI;
        public String zzaWJ;
        public long zzaWK;
        public zzc zzaWL;
        public byte[] zzaWM;
        public long zzaWy;
        public long zzaWz;

        public zzd() {
            zzBZ();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzaWy != zzdVar.zzaWy || this.zzaWz != zzdVar.zzaWz) {
                return false;
            }
            String str = this.tag;
            if (str == null) {
                if (zzdVar.tag != null) {
                    return false;
                }
            } else if (!str.equals(zzdVar.tag)) {
                return false;
            }
            if (this.zzaWA != zzdVar.zzaWA || this.zzaWB != zzdVar.zzaWB || this.zzaWC != zzdVar.zzaWC || !zzrl.equals(this.zzaWD, zzdVar.zzaWD)) {
                return false;
            }
            zzb zzbVar = this.zzaWE;
            if (zzbVar == null) {
                if (zzdVar.zzaWE != null) {
                    return false;
                }
            } else if (!zzbVar.equals(zzdVar.zzaWE)) {
                return false;
            }
            if (!Arrays.equals(this.zzaWF, zzdVar.zzaWF) || !Arrays.equals(this.zzaWG, zzdVar.zzaWG) || !Arrays.equals(this.zzaWH, zzdVar.zzaWH)) {
                return false;
            }
            zza zzaVar = this.zzaWI;
            if (zzaVar == null) {
                if (zzdVar.zzaWI != null) {
                    return false;
                }
            } else if (!zzaVar.equals(zzdVar.zzaWI)) {
                return false;
            }
            String str2 = this.zzaWJ;
            if (str2 == null) {
                if (zzdVar.zzaWJ != null) {
                    return false;
                }
            } else if (!str2.equals(zzdVar.zzaWJ)) {
                return false;
            }
            if (this.zzaWK != zzdVar.zzaWK) {
                return false;
            }
            zzc zzcVar = this.zzaWL;
            if (zzcVar == null) {
                if (zzdVar.zzaWL != null) {
                    return false;
                }
            } else if (!zzcVar.equals(zzdVar.zzaWL)) {
                return false;
            }
            if (Arrays.equals(this.zzaWM, zzdVar.zzaWM)) {
                return zza(zzdVar);
            }
            return false;
        }

        public int hashCode() {
            long j = this.zzaWy;
            long j2 = this.zzaWz;
            int i = (((527 + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            String str = this.tag;
            int iHashCode = (((((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzaWA) * 31) + this.zzaWB) * 31) + (this.zzaWC ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zzaWD)) * 31;
            zzb zzbVar = this.zzaWE;
            int iHashCode2 = (((((((iHashCode + (zzbVar == null ? 0 : zzbVar.hashCode())) * 31) + Arrays.hashCode(this.zzaWF)) * 31) + Arrays.hashCode(this.zzaWG)) * 31) + Arrays.hashCode(this.zzaWH)) * 31;
            zza zzaVar = this.zzaWI;
            int iHashCode3 = (iHashCode2 + (zzaVar == null ? 0 : zzaVar.hashCode())) * 31;
            String str2 = this.zzaWJ;
            int iHashCode4 = str2 == null ? 0 : str2.hashCode();
            long j3 = this.zzaWK;
            int i2 = (((iHashCode3 + iHashCode4) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31;
            zzc zzcVar = this.zzaWL;
            return ((((i2 + (zzcVar != null ? zzcVar.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzaWM)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            long j = this.zzaWy;
            if (j != 0) {
                iZzB += zzrg.zzd(1, j);
            }
            if (!this.tag.equals("")) {
                iZzB += zzrg.zzk(2, this.tag);
            }
            zze[] zzeVarArr = this.zzaWD;
            if (zzeVarArr != null && zzeVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zze[] zzeVarArr2 = this.zzaWD;
                    if (i >= zzeVarArr2.length) {
                        break;
                    }
                    zze zzeVar = zzeVarArr2[i];
                    if (zzeVar != null) {
                        iZzB += zzrg.zzc(3, zzeVar);
                    }
                    i++;
                }
            }
            if (!Arrays.equals(this.zzaWF, zzrq.zzaWo)) {
                iZzB += zzrg.zzb(6, this.zzaWF);
            }
            zza zzaVar = this.zzaWI;
            if (zzaVar != null) {
                iZzB += zzrg.zzc(7, zzaVar);
            }
            if (!Arrays.equals(this.zzaWG, zzrq.zzaWo)) {
                iZzB += zzrg.zzb(8, this.zzaWG);
            }
            zzb zzbVar = this.zzaWE;
            if (zzbVar != null) {
                iZzB += zzrg.zzc(9, zzbVar);
            }
            boolean z = this.zzaWC;
            if (z) {
                iZzB += zzrg.zzc(10, z);
            }
            int i2 = this.zzaWA;
            if (i2 != 0) {
                iZzB += zzrg.zzA(11, i2);
            }
            int i3 = this.zzaWB;
            if (i3 != 0) {
                iZzB += zzrg.zzA(12, i3);
            }
            if (!Arrays.equals(this.zzaWH, zzrq.zzaWo)) {
                iZzB += zzrg.zzb(13, this.zzaWH);
            }
            if (!this.zzaWJ.equals("")) {
                iZzB += zzrg.zzk(14, this.zzaWJ);
            }
            long j2 = this.zzaWK;
            if (j2 != 180000) {
                iZzB += zzrg.zze(15, j2);
            }
            zzc zzcVar = this.zzaWL;
            if (zzcVar != null) {
                iZzB += zzrg.zzc(16, zzcVar);
            }
            long j3 = this.zzaWz;
            if (j3 != 0) {
                iZzB += zzrg.zzd(17, j3);
            }
            return !Arrays.equals(this.zzaWM, zzrq.zzaWo) ? iZzB + zzrg.zzb(18, this.zzaWM) : iZzB;
        }

        public zzd zzBZ() {
            this.zzaWy = 0L;
            this.zzaWz = 0L;
            this.tag = "";
            this.zzaWA = 0;
            this.zzaWB = 0;
            this.zzaWC = false;
            this.zzaWD = zze.zzCa();
            this.zzaWE = null;
            this.zzaWF = zzrq.zzaWo;
            this.zzaWG = zzrq.zzaWo;
            this.zzaWH = zzrq.zzaWo;
            this.zzaWI = null;
            this.zzaWJ = "";
            this.zzaWK = 180000L;
            this.zzaWL = null;
            this.zzaWM = zzrq.zzaWo;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzE, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            zzrn zzrnVar;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        return this;
                    case 8:
                        this.zzaWy = zzrfVar.zzBt();
                        continue;
                    case 18:
                        this.tag = zzrfVar.readString();
                        continue;
                    case 26:
                        int iZzb = zzrq.zzb(zzrfVar, 26);
                        zze[] zzeVarArr = this.zzaWD;
                        int length = zzeVarArr == null ? 0 : zzeVarArr.length;
                        zze[] zzeVarArr2 = new zze[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaWD, 0, zzeVarArr2, 0, length);
                        }
                        while (length < zzeVarArr2.length - 1) {
                            zzeVarArr2[length] = new zze();
                            zzrfVar.zza(zzeVarArr2[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzeVarArr2[length] = new zze();
                        zzrfVar.zza(zzeVarArr2[length]);
                        this.zzaWD = zzeVarArr2;
                        continue;
                    case 50:
                        this.zzaWF = zzrfVar.readBytes();
                        continue;
                    case 58:
                        if (this.zzaWI == null) {
                            this.zzaWI = new zza();
                        }
                        zzrnVar = this.zzaWI;
                        break;
                    case 66:
                        this.zzaWG = zzrfVar.readBytes();
                        continue;
                    case 74:
                        if (this.zzaWE == null) {
                            this.zzaWE = new zzb();
                        }
                        zzrnVar = this.zzaWE;
                        break;
                    case 80:
                        this.zzaWC = zzrfVar.zzBv();
                        continue;
                    case Place.TYPE_STORE /* 88 */:
                        this.zzaWA = zzrfVar.zzBu();
                        continue;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zzaWB = zzrfVar.zzBu();
                        continue;
                    case 106:
                        this.zzaWH = zzrfVar.readBytes();
                        continue;
                    case 114:
                        this.zzaWJ = zzrfVar.readString();
                        continue;
                    case 120:
                        this.zzaWK = zzrfVar.zzBx();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        if (this.zzaWL == null) {
                            this.zzaWL = new zzc();
                        }
                        zzrnVar = this.zzaWL;
                        break;
                    case 136:
                        this.zzaWz = zzrfVar.zzBt();
                        continue;
                    case 146:
                        this.zzaWM = zzrfVar.readBytes();
                        continue;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                            return this;
                        }
                        continue;
                        break;
                }
                zzrfVar.zza(zzrnVar);
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            long j = this.zzaWy;
            if (j != 0) {
                zzrgVar.zzb(1, j);
            }
            if (!this.tag.equals("")) {
                zzrgVar.zzb(2, this.tag);
            }
            zze[] zzeVarArr = this.zzaWD;
            if (zzeVarArr != null && zzeVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zze[] zzeVarArr2 = this.zzaWD;
                    if (i >= zzeVarArr2.length) {
                        break;
                    }
                    zze zzeVar = zzeVarArr2[i];
                    if (zzeVar != null) {
                        zzrgVar.zza(3, zzeVar);
                    }
                    i++;
                }
            }
            if (!Arrays.equals(this.zzaWF, zzrq.zzaWo)) {
                zzrgVar.zza(6, this.zzaWF);
            }
            zza zzaVar = this.zzaWI;
            if (zzaVar != null) {
                zzrgVar.zza(7, zzaVar);
            }
            if (!Arrays.equals(this.zzaWG, zzrq.zzaWo)) {
                zzrgVar.zza(8, this.zzaWG);
            }
            zzb zzbVar = this.zzaWE;
            if (zzbVar != null) {
                zzrgVar.zza(9, zzbVar);
            }
            boolean z = this.zzaWC;
            if (z) {
                zzrgVar.zzb(10, z);
            }
            int i2 = this.zzaWA;
            if (i2 != 0) {
                zzrgVar.zzy(11, i2);
            }
            int i3 = this.zzaWB;
            if (i3 != 0) {
                zzrgVar.zzy(12, i3);
            }
            if (!Arrays.equals(this.zzaWH, zzrq.zzaWo)) {
                zzrgVar.zza(13, this.zzaWH);
            }
            if (!this.zzaWJ.equals("")) {
                zzrgVar.zzb(14, this.zzaWJ);
            }
            long j2 = this.zzaWK;
            if (j2 != 180000) {
                zzrgVar.zzc(15, j2);
            }
            zzc zzcVar = this.zzaWL;
            if (zzcVar != null) {
                zzrgVar.zza(16, zzcVar);
            }
            long j3 = this.zzaWz;
            if (j3 != 0) {
                zzrgVar.zzb(17, j3);
            }
            if (!Arrays.equals(this.zzaWM, zzrq.zzaWo)) {
                zzrgVar.zza(18, this.zzaWM);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zze extends zzrh<zze> {
        private static volatile zze[] zzaWN;
        public String value;
        public String zzaC;

        public zze() {
            zzCb();
        }

        public static zze[] zzCa() {
            if (zzaWN == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzaWN == null) {
                        zzaWN = new zze[0];
                    }
                }
            }
            return zzaWN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            String str = this.zzaC;
            if (str == null) {
                if (zzeVar.zzaC != null) {
                    return false;
                }
            } else if (!str.equals(zzeVar.zzaC)) {
                return false;
            }
            String str2 = this.value;
            if (str2 == null) {
                if (zzeVar.value != null) {
                    return false;
                }
            } else if (!str2.equals(zzeVar.value)) {
                return false;
            }
            return zza(zzeVar);
        }

        public int hashCode() {
            String str = this.zzaC;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.value;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.zzaC.equals("")) {
                iZzB += zzrg.zzk(1, this.zzaC);
            }
            return !this.value.equals("") ? iZzB + zzrg.zzk(2, this.value) : iZzB;
        }

        public zze zzCb() {
            this.zzaC = "";
            this.value = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.zzaC = zzrfVar.readString();
                } else if (iZzBr == 18) {
                    this.value = zzrfVar.readString();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.zzaC.equals("")) {
                zzrgVar.zzb(1, this.zzaC);
            }
            if (!this.value.equals("")) {
                zzrgVar.zzb(2, this.value);
            }
            super.zza(zzrgVar);
        }
    }
}
