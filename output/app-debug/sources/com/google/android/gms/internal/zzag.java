package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzag {

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zziQ;
        public int type;
        public String zziR;
        public zza[] zziS;
        public zza[] zziT;
        public zza[] zziU;
        public String zziV;
        public String zziW;
        public long zziX;
        public boolean zziY;
        public zza[] zziZ;
        public int[] zzja;
        public boolean zzjb;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziQ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziQ == null) {
                        zziQ = new zza[0];
                    }
                }
            }
            return zziQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.type != zzaVar.type) {
                return false;
            }
            String str = this.zziR;
            if (str == null) {
                if (zzaVar.zziR != null) {
                    return false;
                }
            } else if (!str.equals(zzaVar.zziR)) {
                return false;
            }
            if (!zzrl.equals(this.zziS, zzaVar.zziS) || !zzrl.equals(this.zziT, zzaVar.zziT) || !zzrl.equals(this.zziU, zzaVar.zziU)) {
                return false;
            }
            String str2 = this.zziV;
            if (str2 == null) {
                if (zzaVar.zziV != null) {
                    return false;
                }
            } else if (!str2.equals(zzaVar.zziV)) {
                return false;
            }
            String str3 = this.zziW;
            if (str3 == null) {
                if (zzaVar.zziW != null) {
                    return false;
                }
            } else if (!str3.equals(zzaVar.zziW)) {
                return false;
            }
            if (this.zziX == zzaVar.zziX && this.zziY == zzaVar.zziY && zzrl.equals(this.zziZ, zzaVar.zziZ) && zzrl.equals(this.zzja, zzaVar.zzja) && this.zzjb == zzaVar.zzjb) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            int i = (527 + this.type) * 31;
            String str = this.zziR;
            int iHashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + zzrl.hashCode(this.zziS)) * 31) + zzrl.hashCode(this.zziT)) * 31) + zzrl.hashCode(this.zziU)) * 31;
            String str2 = this.zziV;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zziW;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            long j = this.zziX;
            return ((((((((((iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31) + (this.zziY ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zziZ)) * 31) + zzrl.hashCode(this.zzja)) * 31) + (this.zzjb ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int[] iArr;
            int iZzB = super.zzB() + zzrg.zzA(1, this.type);
            if (!this.zziR.equals("")) {
                iZzB += zzrg.zzk(2, this.zziR);
            }
            zza[] zzaVarArr = this.zziS;
            int i = 0;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int iZzc = iZzB;
                int i2 = 0;
                while (true) {
                    zza[] zzaVarArr2 = this.zziS;
                    if (i2 >= zzaVarArr2.length) {
                        break;
                    }
                    zza zzaVar = zzaVarArr2[i2];
                    if (zzaVar != null) {
                        iZzc += zzrg.zzc(3, zzaVar);
                    }
                    i2++;
                }
                iZzB = iZzc;
            }
            zza[] zzaVarArr3 = this.zziT;
            if (zzaVarArr3 != null && zzaVarArr3.length > 0) {
                int iZzc2 = iZzB;
                int i3 = 0;
                while (true) {
                    zza[] zzaVarArr4 = this.zziT;
                    if (i3 >= zzaVarArr4.length) {
                        break;
                    }
                    zza zzaVar2 = zzaVarArr4[i3];
                    if (zzaVar2 != null) {
                        iZzc2 += zzrg.zzc(4, zzaVar2);
                    }
                    i3++;
                }
                iZzB = iZzc2;
            }
            zza[] zzaVarArr5 = this.zziU;
            if (zzaVarArr5 != null && zzaVarArr5.length > 0) {
                int iZzc3 = iZzB;
                int i4 = 0;
                while (true) {
                    zza[] zzaVarArr6 = this.zziU;
                    if (i4 >= zzaVarArr6.length) {
                        break;
                    }
                    zza zzaVar3 = zzaVarArr6[i4];
                    if (zzaVar3 != null) {
                        iZzc3 += zzrg.zzc(5, zzaVar3);
                    }
                    i4++;
                }
                iZzB = iZzc3;
            }
            if (!this.zziV.equals("")) {
                iZzB += zzrg.zzk(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                iZzB += zzrg.zzk(7, this.zziW);
            }
            long j = this.zziX;
            if (j != 0) {
                iZzB += zzrg.zzd(8, j);
            }
            boolean z = this.zzjb;
            if (z) {
                iZzB += zzrg.zzc(9, z);
            }
            int[] iArr2 = this.zzja;
            if (iArr2 != null && iArr2.length > 0) {
                int i5 = 0;
                int iZzkJ = 0;
                while (true) {
                    iArr = this.zzja;
                    if (i5 >= iArr.length) {
                        break;
                    }
                    iZzkJ += zzrg.zzkJ(iArr[i5]);
                    i5++;
                }
                iZzB = iZzB + iZzkJ + (iArr.length * 1);
            }
            zza[] zzaVarArr7 = this.zziZ;
            if (zzaVarArr7 != null && zzaVarArr7.length > 0) {
                while (true) {
                    zza[] zzaVarArr8 = this.zziZ;
                    if (i >= zzaVarArr8.length) {
                        break;
                    }
                    zza zzaVar4 = zzaVarArr8[i];
                    if (zzaVar4 != null) {
                        iZzB += zzrg.zzc(11, zzaVar4);
                    }
                    i++;
                }
            }
            boolean z2 = this.zziY;
            return z2 ? iZzB + zzrg.zzc(12, z2) : iZzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziR = "";
            this.zziS = zzQ();
            this.zziT = zzQ();
            this.zziU = zzQ();
            this.zziV = "";
            this.zziW = "";
            this.zziX = 0L;
            this.zziY = false;
            this.zziZ = zzQ();
            this.zzja = zzrq.zzaWh;
            this.zzjb = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzy(1, this.type);
            if (!this.zziR.equals("")) {
                zzrgVar.zzb(2, this.zziR);
            }
            zza[] zzaVarArr = this.zziS;
            int i = 0;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zza[] zzaVarArr2 = this.zziS;
                    if (i2 >= zzaVarArr2.length) {
                        break;
                    }
                    zza zzaVar = zzaVarArr2[i2];
                    if (zzaVar != null) {
                        zzrgVar.zza(3, zzaVar);
                    }
                    i2++;
                }
            }
            zza[] zzaVarArr3 = this.zziT;
            if (zzaVarArr3 != null && zzaVarArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    zza[] zzaVarArr4 = this.zziT;
                    if (i3 >= zzaVarArr4.length) {
                        break;
                    }
                    zza zzaVar2 = zzaVarArr4[i3];
                    if (zzaVar2 != null) {
                        zzrgVar.zza(4, zzaVar2);
                    }
                    i3++;
                }
            }
            zza[] zzaVarArr5 = this.zziU;
            if (zzaVarArr5 != null && zzaVarArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    zza[] zzaVarArr6 = this.zziU;
                    if (i4 >= zzaVarArr6.length) {
                        break;
                    }
                    zza zzaVar3 = zzaVarArr6[i4];
                    if (zzaVar3 != null) {
                        zzrgVar.zza(5, zzaVar3);
                    }
                    i4++;
                }
            }
            if (!this.zziV.equals("")) {
                zzrgVar.zzb(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                zzrgVar.zzb(7, this.zziW);
            }
            long j = this.zziX;
            if (j != 0) {
                zzrgVar.zzb(8, j);
            }
            boolean z = this.zzjb;
            if (z) {
                zzrgVar.zzb(9, z);
            }
            int[] iArr = this.zzja;
            if (iArr != null && iArr.length > 0) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = this.zzja;
                    if (i5 >= iArr2.length) {
                        break;
                    }
                    zzrgVar.zzy(10, iArr2[i5]);
                    i5++;
                }
            }
            zza[] zzaVarArr7 = this.zziZ;
            if (zzaVarArr7 != null && zzaVarArr7.length > 0) {
                while (true) {
                    zza[] zzaVarArr8 = this.zziZ;
                    if (i >= zzaVarArr8.length) {
                        break;
                    }
                    zza zzaVar4 = zzaVarArr8[i];
                    if (zzaVar4 != null) {
                        zzrgVar.zza(11, zzaVar4);
                    }
                    i++;
                }
            }
            boolean z2 = this.zziY;
            if (z2) {
                zzrgVar.zzb(12, z2);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        return this;
                    case 8:
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
                                this.type = iZzBu;
                                break;
                        }
                        break;
                    case 18:
                        this.zziR = zzrfVar.readString();
                        break;
                    case 26:
                        int iZzb = zzrq.zzb(zzrfVar, 26);
                        zza[] zzaVarArr = this.zziS;
                        int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                        zza[] zzaVarArr2 = new zza[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zziS, 0, zzaVarArr2, 0, length);
                        }
                        while (length < zzaVarArr2.length - 1) {
                            zzaVarArr2[length] = new zza();
                            zzrfVar.zza(zzaVarArr2[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzaVarArr2[length] = new zza();
                        zzrfVar.zza(zzaVarArr2[length]);
                        this.zziS = zzaVarArr2;
                        break;
                    case 34:
                        int iZzb2 = zzrq.zzb(zzrfVar, 34);
                        zza[] zzaVarArr3 = this.zziT;
                        int length2 = zzaVarArr3 == null ? 0 : zzaVarArr3.length;
                        zza[] zzaVarArr4 = new zza[iZzb2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziT, 0, zzaVarArr4, 0, length2);
                        }
                        while (length2 < zzaVarArr4.length - 1) {
                            zzaVarArr4[length2] = new zza();
                            zzrfVar.zza(zzaVarArr4[length2]);
                            zzrfVar.zzBr();
                            length2++;
                        }
                        zzaVarArr4[length2] = new zza();
                        zzrfVar.zza(zzaVarArr4[length2]);
                        this.zziT = zzaVarArr4;
                        break;
                    case 42:
                        int iZzb3 = zzrq.zzb(zzrfVar, 42);
                        zza[] zzaVarArr5 = this.zziU;
                        int length3 = zzaVarArr5 == null ? 0 : zzaVarArr5.length;
                        zza[] zzaVarArr6 = new zza[iZzb3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziU, 0, zzaVarArr6, 0, length3);
                        }
                        while (length3 < zzaVarArr6.length - 1) {
                            zzaVarArr6[length3] = new zza();
                            zzrfVar.zza(zzaVarArr6[length3]);
                            zzrfVar.zzBr();
                            length3++;
                        }
                        zzaVarArr6[length3] = new zza();
                        zzrfVar.zza(zzaVarArr6[length3]);
                        this.zziU = zzaVarArr6;
                        break;
                    case 50:
                        this.zziV = zzrfVar.readString();
                        break;
                    case 58:
                        this.zziW = zzrfVar.readString();
                        break;
                    case 64:
                        this.zziX = zzrfVar.zzBt();
                        break;
                    case 72:
                        this.zzjb = zzrfVar.zzBv();
                        break;
                    case 80:
                        int iZzb4 = zzrq.zzb(zzrfVar, 80);
                        int[] iArr = new int[iZzb4];
                        int i = 0;
                        for (int i2 = 0; i2 < iZzb4; i2++) {
                            if (i2 != 0) {
                                zzrfVar.zzBr();
                            }
                            int iZzBu2 = zzrfVar.zzBu();
                            switch (iZzBu2) {
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
                                    iArr[i] = iZzBu2;
                                    i++;
                                    break;
                            }
                        }
                        if (i != 0) {
                            int[] iArr2 = this.zzja;
                            int length4 = iArr2 == null ? 0 : iArr2.length;
                            if (length4 == 0 && i == iArr.length) {
                                this.zzja = iArr;
                            } else {
                                int[] iArr3 = new int[length4 + i];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzja, 0, iArr3, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr3, length4, i);
                                this.zzja = iArr3;
                            }
                        }
                        break;
                    case 82:
                        int iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i3 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            switch (zzrfVar.zzBu()) {
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
                                    i3++;
                                    break;
                            }
                        }
                        if (i3 != 0) {
                            zzrfVar.zzkE(position);
                            int[] iArr4 = this.zzja;
                            int length5 = iArr4 == null ? 0 : iArr4.length;
                            int[] iArr5 = new int[i3 + length5];
                            if (length5 != 0) {
                                System.arraycopy(this.zzja, 0, iArr5, 0, length5);
                            }
                            while (zzrfVar.zzBD() > 0) {
                                int iZzBu3 = zzrfVar.zzBu();
                                switch (iZzBu3) {
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
                                        iArr5[length5] = iZzBu3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzja = iArr5;
                        }
                        zzrfVar.zzkD(iZzkC);
                        break;
                    case 90:
                        int iZzb5 = zzrq.zzb(zzrfVar, 90);
                        zza[] zzaVarArr7 = this.zziZ;
                        int length6 = zzaVarArr7 == null ? 0 : zzaVarArr7.length;
                        zza[] zzaVarArr8 = new zza[iZzb5 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziZ, 0, zzaVarArr8, 0, length6);
                        }
                        while (length6 < zzaVarArr8.length - 1) {
                            zzaVarArr8[length6] = new zza();
                            zzrfVar.zza(zzaVarArr8[length6]);
                            zzrfVar.zzBr();
                            length6++;
                        }
                        zzaVarArr8[length6] = new zza();
                        zzrfVar.zza(zzaVarArr8[length6]);
                        this.zziZ = zzaVarArr8;
                        break;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zziY = zzrfVar.zzBv();
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
}
