package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzaf {

    public static final class zza extends zzrh<zza> {
        public int level;
        public int zzhK;
        public int zzhL;

        public zza() {
            zzA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.level == zzaVar.level && this.zzhK == zzaVar.zzhK && this.zzhL == zzaVar.zzhL) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + this.level) * 31) + this.zzhK) * 31) + this.zzhL) * 31) + zzBI();
        }

        public zza zzA() {
            this.level = 1;
            this.zzhK = 0;
            this.zzhL = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            int i = this.level;
            if (i != 1) {
                iZzB += zzrg.zzA(1, i);
            }
            int i2 = this.zzhK;
            if (i2 != 0) {
                iZzB += zzrg.zzA(2, i2);
            }
            int i3 = this.zzhL;
            return i3 != 0 ? iZzB + zzrg.zzA(3, i3) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
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
                            this.level = iZzBu;
                            break;
                    }
                } else if (iZzBr == 16) {
                    this.zzhK = zzrfVar.zzBu();
                } else if (iZzBr == 24) {
                    this.zzhL = zzrfVar.zzBu();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            int i = this.level;
            if (i != 1) {
                zzrgVar.zzy(1, i);
            }
            int i2 = this.zzhK;
            if (i2 != 0) {
                zzrgVar.zzy(2, i2);
            }
            int i3 = this.zzhL;
            if (i3 != 0) {
                zzrgVar.zzy(3, i3);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzhM;
        public int name;
        public int[] zzhN;
        public int zzhO;
        public boolean zzhP;
        public boolean zzhQ;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhM == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhM == null) {
                        zzhM = new zzb[0];
                    }
                }
            }
            return zzhM;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (zzrl.equals(this.zzhN, zzbVar.zzhN) && this.zzhO == zzbVar.zzhO && this.name == zzbVar.name && this.zzhP == zzbVar.zzhP && this.zzhQ == zzbVar.zzhQ) {
                return zza(zzbVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((527 + zzrl.hashCode(this.zzhN)) * 31) + this.zzhO) * 31) + this.name) * 31) + (this.zzhP ? 1231 : 1237)) * 31) + (this.zzhQ ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int[] iArr;
            int iZzB = super.zzB();
            boolean z = this.zzhQ;
            if (z) {
                iZzB += zzrg.zzc(1, z);
            }
            int iZzA = iZzB + zzrg.zzA(2, this.zzhO);
            int[] iArr2 = this.zzhN;
            if (iArr2 != null && iArr2.length > 0) {
                int i = 0;
                int iZzkJ = 0;
                while (true) {
                    iArr = this.zzhN;
                    if (i >= iArr.length) {
                        break;
                    }
                    iZzkJ += zzrg.zzkJ(iArr[i]);
                    i++;
                }
                iZzA = iZzA + iZzkJ + (iArr.length * 1);
            }
            int i2 = this.name;
            if (i2 != 0) {
                iZzA += zzrg.zzA(4, i2);
            }
            boolean z2 = this.zzhP;
            return z2 ? iZzA + zzrg.zzc(6, z2) : iZzA;
        }

        public zzb zzD() {
            this.zzhN = zzrq.zzaWh;
            this.zzhO = 0;
            this.name = 0;
            this.zzhP = false;
            this.zzhQ = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            boolean z = this.zzhQ;
            if (z) {
                zzrgVar.zzb(1, z);
            }
            zzrgVar.zzy(2, this.zzhO);
            int[] iArr = this.zzhN;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.zzhN;
                    if (i >= iArr2.length) {
                        break;
                    }
                    zzrgVar.zzy(3, iArr2[i]);
                    i++;
                }
            }
            int i2 = this.name;
            if (i2 != 0) {
                zzrgVar.zzy(4, i2);
            }
            boolean z2 = this.zzhP;
            if (z2) {
                zzrgVar.zzb(6, z2);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 8) {
                    this.zzhQ = zzrfVar.zzBv();
                } else if (iZzBr == 16) {
                    this.zzhO = zzrfVar.zzBu();
                } else if (iZzBr == 24) {
                    int iZzb = zzrq.zzb(zzrfVar, 24);
                    int[] iArr = this.zzhN;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzhN, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = zzrfVar.zzBu();
                        zzrfVar.zzBr();
                        length++;
                    }
                    iArr2[length] = zzrfVar.zzBu();
                    this.zzhN = iArr2;
                } else if (iZzBr == 26) {
                    int iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                    int position = zzrfVar.getPosition();
                    int i = 0;
                    while (zzrfVar.zzBD() > 0) {
                        zzrfVar.zzBu();
                        i++;
                    }
                    zzrfVar.zzkE(position);
                    int[] iArr3 = this.zzhN;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzhN, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = zzrfVar.zzBu();
                        length2++;
                    }
                    this.zzhN = iArr4;
                    zzrfVar.zzkD(iZzkC);
                } else if (iZzBr == 32) {
                    this.name = zzrfVar.zzBu();
                } else if (iZzBr == 48) {
                    this.zzhP = zzrfVar.zzBv();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }

    public static final class zzc extends zzrh<zzc> {
        private static volatile zzc[] zzhR;
        public String zzaC;
        public long zzhS;
        public long zzhT;
        public boolean zzhU;
        public long zzhV;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhR == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhR == null) {
                        zzhR = new zzc[0];
                    }
                }
            }
            return zzhR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            String str = this.zzaC;
            if (str == null) {
                if (zzcVar.zzaC != null) {
                    return false;
                }
            } else if (!str.equals(zzcVar.zzaC)) {
                return false;
            }
            if (this.zzhS == zzcVar.zzhS && this.zzhT == zzcVar.zzhT && this.zzhU == zzcVar.zzhU && this.zzhV == zzcVar.zzhV) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            String str = this.zzaC;
            int iHashCode = str == null ? 0 : str.hashCode();
            long j = this.zzhS;
            int i = (((527 + iHashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.zzhT;
            int i2 = (((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.zzhU ? 1231 : 1237)) * 31;
            long j3 = this.zzhV;
            return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.zzaC.equals("")) {
                iZzB += zzrg.zzk(1, this.zzaC);
            }
            long j = this.zzhS;
            if (j != 0) {
                iZzB += zzrg.zzd(2, j);
            }
            long j2 = this.zzhT;
            if (j2 != 2147483647L) {
                iZzB += zzrg.zzd(3, j2);
            }
            boolean z = this.zzhU;
            if (z) {
                iZzB += zzrg.zzc(4, z);
            }
            long j3 = this.zzhV;
            return j3 != 0 ? iZzB + zzrg.zzd(5, j3) : iZzB;
        }

        public zzc zzF() {
            this.zzaC = "";
            this.zzhS = 0L;
            this.zzhT = 2147483647L;
            this.zzhU = false;
            this.zzhV = 0L;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.zzaC.equals("")) {
                zzrgVar.zzb(1, this.zzaC);
            }
            long j = this.zzhS;
            if (j != 0) {
                zzrgVar.zzb(2, j);
            }
            long j2 = this.zzhT;
            if (j2 != 2147483647L) {
                zzrgVar.zzb(3, j2);
            }
            boolean z = this.zzhU;
            if (z) {
                zzrgVar.zzb(4, z);
            }
            long j3 = this.zzhV;
            if (j3 != 0) {
                zzrgVar.zzb(5, j3);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.zzaC = zzrfVar.readString();
                } else if (iZzBr == 16) {
                    this.zzhS = zzrfVar.zzBt();
                } else if (iZzBr == 24) {
                    this.zzhT = zzrfVar.zzBt();
                } else if (iZzBr == 32) {
                    this.zzhU = zzrfVar.zzBv();
                } else if (iZzBr == 40) {
                    this.zzhV = zzrfVar.zzBt();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public zzag.zza[] zzhW;
        public zzag.zza[] zzhX;
        public zzc[] zzhY;

        public zzd() {
            zzG();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (zzrl.equals(this.zzhW, zzdVar.zzhW) && zzrl.equals(this.zzhX, zzdVar.zzhX) && zzrl.equals(this.zzhY, zzdVar.zzhY)) {
                return zza(zzdVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + zzrl.hashCode(this.zzhW)) * 31) + zzrl.hashCode(this.zzhX)) * 31) + zzrl.hashCode(this.zzhY)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            zzag.zza[] zzaVarArr = this.zzhW;
            int i = 0;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int iZzc = iZzB;
                int i2 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr2 = this.zzhW;
                    if (i2 >= zzaVarArr2.length) {
                        break;
                    }
                    zzag.zza zzaVar = zzaVarArr2[i2];
                    if (zzaVar != null) {
                        iZzc += zzrg.zzc(1, zzaVar);
                    }
                    i2++;
                }
                iZzB = iZzc;
            }
            zzag.zza[] zzaVarArr3 = this.zzhX;
            if (zzaVarArr3 != null && zzaVarArr3.length > 0) {
                int iZzc2 = iZzB;
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr4 = this.zzhX;
                    if (i3 >= zzaVarArr4.length) {
                        break;
                    }
                    zzag.zza zzaVar2 = zzaVarArr4[i3];
                    if (zzaVar2 != null) {
                        iZzc2 += zzrg.zzc(2, zzaVar2);
                    }
                    i3++;
                }
                iZzB = iZzc2;
            }
            zzc[] zzcVarArr = this.zzhY;
            if (zzcVarArr != null && zzcVarArr.length > 0) {
                while (true) {
                    zzc[] zzcVarArr2 = this.zzhY;
                    if (i >= zzcVarArr2.length) {
                        break;
                    }
                    zzc zzcVar = zzcVarArr2[i];
                    if (zzcVar != null) {
                        iZzB += zzrg.zzc(3, zzcVar);
                    }
                    i++;
                }
            }
            return iZzB;
        }

        public zzd zzG() {
            this.zzhW = zzag.zza.zzQ();
            this.zzhX = zzag.zza.zzQ();
            this.zzhY = zzc.zzE();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzag.zza[] zzaVarArr = this.zzhW;
            int i = 0;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr2 = this.zzhW;
                    if (i2 >= zzaVarArr2.length) {
                        break;
                    }
                    zzag.zza zzaVar = zzaVarArr2[i2];
                    if (zzaVar != null) {
                        zzrgVar.zza(1, zzaVar);
                    }
                    i2++;
                }
            }
            zzag.zza[] zzaVarArr3 = this.zzhX;
            if (zzaVarArr3 != null && zzaVarArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr4 = this.zzhX;
                    if (i3 >= zzaVarArr4.length) {
                        break;
                    }
                    zzag.zza zzaVar2 = zzaVarArr4[i3];
                    if (zzaVar2 != null) {
                        zzrgVar.zza(2, zzaVar2);
                    }
                    i3++;
                }
            }
            zzc[] zzcVarArr = this.zzhY;
            if (zzcVarArr != null && zzcVarArr.length > 0) {
                while (true) {
                    zzc[] zzcVarArr2 = this.zzhY;
                    if (i >= zzcVarArr2.length) {
                        break;
                    }
                    zzc zzcVar = zzcVarArr2[i];
                    if (zzcVar != null) {
                        zzrgVar.zza(3, zzcVar);
                    }
                    i++;
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    int iZzb = zzrq.zzb(zzrfVar, 10);
                    zzag.zza[] zzaVarArr = this.zzhW;
                    int length = zzaVarArr == null ? 0 : zzaVarArr.length;
                    zzag.zza[] zzaVarArr2 = new zzag.zza[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzhW, 0, zzaVarArr2, 0, length);
                    }
                    while (length < zzaVarArr2.length - 1) {
                        zzaVarArr2[length] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr2[length]);
                        zzrfVar.zzBr();
                        length++;
                    }
                    zzaVarArr2[length] = new zzag.zza();
                    zzrfVar.zza(zzaVarArr2[length]);
                    this.zzhW = zzaVarArr2;
                } else if (iZzBr == 18) {
                    int iZzb2 = zzrq.zzb(zzrfVar, 18);
                    zzag.zza[] zzaVarArr3 = this.zzhX;
                    int length2 = zzaVarArr3 == null ? 0 : zzaVarArr3.length;
                    zzag.zza[] zzaVarArr4 = new zzag.zza[iZzb2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzhX, 0, zzaVarArr4, 0, length2);
                    }
                    while (length2 < zzaVarArr4.length - 1) {
                        zzaVarArr4[length2] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr4[length2]);
                        zzrfVar.zzBr();
                        length2++;
                    }
                    zzaVarArr4[length2] = new zzag.zza();
                    zzrfVar.zza(zzaVarArr4[length2]);
                    this.zzhX = zzaVarArr4;
                } else if (iZzBr == 26) {
                    int iZzb3 = zzrq.zzb(zzrfVar, 26);
                    zzc[] zzcVarArr = this.zzhY;
                    int length3 = zzcVarArr == null ? 0 : zzcVarArr.length;
                    zzc[] zzcVarArr2 = new zzc[iZzb3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzhY, 0, zzcVarArr2, 0, length3);
                    }
                    while (length3 < zzcVarArr2.length - 1) {
                        zzcVarArr2[length3] = new zzc();
                        zzrfVar.zza(zzcVarArr2[length3]);
                        zzrfVar.zzBr();
                        length3++;
                    }
                    zzcVarArr2[length3] = new zzc();
                    zzrfVar.zza(zzcVarArr2[length3]);
                    this.zzhY = zzcVarArr2;
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }

    public static final class zze extends zzrh<zze> {
        private static volatile zze[] zzhZ;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzhZ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhZ == null) {
                        zzhZ = new zze[0];
                    }
                }
            }
            return zzhZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.key == zzeVar.key && this.value == zzeVar.value) {
                return zza(zzeVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.key) * 31) + this.value) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            return super.zzB() + zzrg.zzA(1, this.key) + zzrg.zzA(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzy(1, this.key);
            zzrgVar.zzy(2, this.value);
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 8) {
                    this.key = zzrfVar.zzBu();
                } else if (iZzBr == 16) {
                    this.value = zzrfVar.zzBu();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }

    public static final class zzf extends zzrh<zzf> {
        public String version;
        public String[] zzia;
        public String[] zzib;
        public zzag.zza[] zzic;
        public zze[] zzid;
        public zzb[] zzie;
        public zzb[] zzif;
        public zzb[] zzig;
        public zzg[] zzih;
        public String zzii;
        public String zzij;
        public String zzik;
        public zza zzil;
        public float zzim;
        public boolean zzin;
        public String[] zzio;
        public int zzip;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzrm {
            return (zzf) zzrn.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (!zzrl.equals(this.zzia, zzfVar.zzia) || !zzrl.equals(this.zzib, zzfVar.zzib) || !zzrl.equals(this.zzic, zzfVar.zzic) || !zzrl.equals(this.zzid, zzfVar.zzid) || !zzrl.equals(this.zzie, zzfVar.zzie) || !zzrl.equals(this.zzif, zzfVar.zzif) || !zzrl.equals(this.zzig, zzfVar.zzig) || !zzrl.equals(this.zzih, zzfVar.zzih)) {
                return false;
            }
            String str = this.zzii;
            if (str == null) {
                if (zzfVar.zzii != null) {
                    return false;
                }
            } else if (!str.equals(zzfVar.zzii)) {
                return false;
            }
            String str2 = this.zzij;
            if (str2 == null) {
                if (zzfVar.zzij != null) {
                    return false;
                }
            } else if (!str2.equals(zzfVar.zzij)) {
                return false;
            }
            String str3 = this.zzik;
            if (str3 == null) {
                if (zzfVar.zzik != null) {
                    return false;
                }
            } else if (!str3.equals(zzfVar.zzik)) {
                return false;
            }
            String str4 = this.version;
            if (str4 == null) {
                if (zzfVar.version != null) {
                    return false;
                }
            } else if (!str4.equals(zzfVar.version)) {
                return false;
            }
            zza zzaVar = this.zzil;
            if (zzaVar == null) {
                if (zzfVar.zzil != null) {
                    return false;
                }
            } else if (!zzaVar.equals(zzfVar.zzil)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzim) == Float.floatToIntBits(zzfVar.zzim) && this.zzin == zzfVar.zzin && zzrl.equals(this.zzio, zzfVar.zzio) && this.zzip == zzfVar.zzip) {
                return zza(zzfVar);
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = (((((((((((((((527 + zzrl.hashCode(this.zzia)) * 31) + zzrl.hashCode(this.zzib)) * 31) + zzrl.hashCode(this.zzic)) * 31) + zzrl.hashCode(this.zzid)) * 31) + zzrl.hashCode(this.zzie)) * 31) + zzrl.hashCode(this.zzif)) * 31) + zzrl.hashCode(this.zzig)) * 31) + zzrl.hashCode(this.zzih)) * 31;
            String str = this.zzii;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.zzij;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzik;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.version;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            zza zzaVar = this.zzil;
            return ((((((((((iHashCode5 + (zzaVar != null ? zzaVar.hashCode() : 0)) * 31) + Float.floatToIntBits(this.zzim)) * 31) + (this.zzin ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zzio)) * 31) + this.zzip) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            String[] strArr = this.zzib;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iZzfj = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.zzib;
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
            zzag.zza[] zzaVarArr = this.zzic;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int iZzc = iZzB;
                int i4 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr2 = this.zzic;
                    if (i4 >= zzaVarArr2.length) {
                        break;
                    }
                    zzag.zza zzaVar = zzaVarArr2[i4];
                    if (zzaVar != null) {
                        iZzc += zzrg.zzc(2, zzaVar);
                    }
                    i4++;
                }
                iZzB = iZzc;
            }
            zze[] zzeVarArr = this.zzid;
            if (zzeVarArr != null && zzeVarArr.length > 0) {
                int iZzc2 = iZzB;
                int i5 = 0;
                while (true) {
                    zze[] zzeVarArr2 = this.zzid;
                    if (i5 >= zzeVarArr2.length) {
                        break;
                    }
                    zze zzeVar = zzeVarArr2[i5];
                    if (zzeVar != null) {
                        iZzc2 += zzrg.zzc(3, zzeVar);
                    }
                    i5++;
                }
                iZzB = iZzc2;
            }
            zzb[] zzbVarArr = this.zzie;
            if (zzbVarArr != null && zzbVarArr.length > 0) {
                int iZzc3 = iZzB;
                int i6 = 0;
                while (true) {
                    zzb[] zzbVarArr2 = this.zzie;
                    if (i6 >= zzbVarArr2.length) {
                        break;
                    }
                    zzb zzbVar = zzbVarArr2[i6];
                    if (zzbVar != null) {
                        iZzc3 += zzrg.zzc(4, zzbVar);
                    }
                    i6++;
                }
                iZzB = iZzc3;
            }
            zzb[] zzbVarArr3 = this.zzif;
            if (zzbVarArr3 != null && zzbVarArr3.length > 0) {
                int iZzc4 = iZzB;
                int i7 = 0;
                while (true) {
                    zzb[] zzbVarArr4 = this.zzif;
                    if (i7 >= zzbVarArr4.length) {
                        break;
                    }
                    zzb zzbVar2 = zzbVarArr4[i7];
                    if (zzbVar2 != null) {
                        iZzc4 += zzrg.zzc(5, zzbVar2);
                    }
                    i7++;
                }
                iZzB = iZzc4;
            }
            zzb[] zzbVarArr5 = this.zzig;
            if (zzbVarArr5 != null && zzbVarArr5.length > 0) {
                int iZzc5 = iZzB;
                int i8 = 0;
                while (true) {
                    zzb[] zzbVarArr6 = this.zzig;
                    if (i8 >= zzbVarArr6.length) {
                        break;
                    }
                    zzb zzbVar3 = zzbVarArr6[i8];
                    if (zzbVar3 != null) {
                        iZzc5 += zzrg.zzc(6, zzbVar3);
                    }
                    i8++;
                }
                iZzB = iZzc5;
            }
            zzg[] zzgVarArr = this.zzih;
            if (zzgVarArr != null && zzgVarArr.length > 0) {
                int iZzc6 = iZzB;
                int i9 = 0;
                while (true) {
                    zzg[] zzgVarArr2 = this.zzih;
                    if (i9 >= zzgVarArr2.length) {
                        break;
                    }
                    zzg zzgVar = zzgVarArr2[i9];
                    if (zzgVar != null) {
                        iZzc6 += zzrg.zzc(7, zzgVar);
                    }
                    i9++;
                }
                iZzB = iZzc6;
            }
            if (!this.zzii.equals("")) {
                iZzB += zzrg.zzk(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                iZzB += zzrg.zzk(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                iZzB += zzrg.zzk(12, this.zzik);
            }
            if (!this.version.equals("")) {
                iZzB += zzrg.zzk(13, this.version);
            }
            zza zzaVar2 = this.zzil;
            if (zzaVar2 != null) {
                iZzB += zzrg.zzc(14, zzaVar2);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                iZzB += zzrg.zzc(15, this.zzim);
            }
            String[] strArr3 = this.zzio;
            if (strArr3 != null && strArr3.length > 0) {
                int i10 = 0;
                int iZzfj2 = 0;
                int i11 = 0;
                while (true) {
                    String[] strArr4 = this.zzio;
                    if (i10 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i10];
                    if (str2 != null) {
                        i11++;
                        iZzfj2 += zzrg.zzfj(str2);
                    }
                    i10++;
                }
                iZzB = iZzB + iZzfj2 + (i11 * 2);
            }
            int i12 = this.zzip;
            if (i12 != 0) {
                iZzB += zzrg.zzA(17, i12);
            }
            boolean z = this.zzin;
            if (z) {
                iZzB += zzrg.zzc(18, z);
            }
            String[] strArr5 = this.zzia;
            if (strArr5 == null || strArr5.length <= 0) {
                return iZzB;
            }
            int iZzfj3 = 0;
            int i13 = 0;
            while (true) {
                String[] strArr6 = this.zzia;
                if (i >= strArr6.length) {
                    return iZzB + iZzfj3 + (i13 * 2);
                }
                String str3 = strArr6[i];
                if (str3 != null) {
                    i13++;
                    iZzfj3 += zzrg.zzfj(str3);
                }
                i++;
            }
        }

        public zzf zzJ() {
            this.zzia = zzrq.zzaWm;
            this.zzib = zzrq.zzaWm;
            this.zzic = zzag.zza.zzQ();
            this.zzid = zze.zzH();
            this.zzie = zzb.zzC();
            this.zzif = zzb.zzC();
            this.zzig = zzb.zzC();
            this.zzih = zzg.zzK();
            this.zzii = "";
            this.zzij = "";
            this.zzik = "0";
            this.version = "";
            this.zzil = null;
            this.zzim = 0.0f;
            this.zzin = false;
            this.zzio = zzrq.zzaWm;
            this.zzip = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            String[] strArr = this.zzib;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.zzib;
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
            zzag.zza[] zzaVarArr = this.zzic;
            if (zzaVarArr != null && zzaVarArr.length > 0) {
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaVarArr2 = this.zzic;
                    if (i3 >= zzaVarArr2.length) {
                        break;
                    }
                    zzag.zza zzaVar = zzaVarArr2[i3];
                    if (zzaVar != null) {
                        zzrgVar.zza(2, zzaVar);
                    }
                    i3++;
                }
            }
            zze[] zzeVarArr = this.zzid;
            if (zzeVarArr != null && zzeVarArr.length > 0) {
                int i4 = 0;
                while (true) {
                    zze[] zzeVarArr2 = this.zzid;
                    if (i4 >= zzeVarArr2.length) {
                        break;
                    }
                    zze zzeVar = zzeVarArr2[i4];
                    if (zzeVar != null) {
                        zzrgVar.zza(3, zzeVar);
                    }
                    i4++;
                }
            }
            zzb[] zzbVarArr = this.zzie;
            if (zzbVarArr != null && zzbVarArr.length > 0) {
                int i5 = 0;
                while (true) {
                    zzb[] zzbVarArr2 = this.zzie;
                    if (i5 >= zzbVarArr2.length) {
                        break;
                    }
                    zzb zzbVar = zzbVarArr2[i5];
                    if (zzbVar != null) {
                        zzrgVar.zza(4, zzbVar);
                    }
                    i5++;
                }
            }
            zzb[] zzbVarArr3 = this.zzif;
            if (zzbVarArr3 != null && zzbVarArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    zzb[] zzbVarArr4 = this.zzif;
                    if (i6 >= zzbVarArr4.length) {
                        break;
                    }
                    zzb zzbVar2 = zzbVarArr4[i6];
                    if (zzbVar2 != null) {
                        zzrgVar.zza(5, zzbVar2);
                    }
                    i6++;
                }
            }
            zzb[] zzbVarArr5 = this.zzig;
            if (zzbVarArr5 != null && zzbVarArr5.length > 0) {
                int i7 = 0;
                while (true) {
                    zzb[] zzbVarArr6 = this.zzig;
                    if (i7 >= zzbVarArr6.length) {
                        break;
                    }
                    zzb zzbVar3 = zzbVarArr6[i7];
                    if (zzbVar3 != null) {
                        zzrgVar.zza(6, zzbVar3);
                    }
                    i7++;
                }
            }
            zzg[] zzgVarArr = this.zzih;
            if (zzgVarArr != null && zzgVarArr.length > 0) {
                int i8 = 0;
                while (true) {
                    zzg[] zzgVarArr2 = this.zzih;
                    if (i8 >= zzgVarArr2.length) {
                        break;
                    }
                    zzg zzgVar = zzgVarArr2[i8];
                    if (zzgVar != null) {
                        zzrgVar.zza(7, zzgVar);
                    }
                    i8++;
                }
            }
            if (!this.zzii.equals("")) {
                zzrgVar.zzb(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                zzrgVar.zzb(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                zzrgVar.zzb(12, this.zzik);
            }
            if (!this.version.equals("")) {
                zzrgVar.zzb(13, this.version);
            }
            zza zzaVar2 = this.zzil;
            if (zzaVar2 != null) {
                zzrgVar.zza(14, zzaVar2);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                zzrgVar.zzb(15, this.zzim);
            }
            String[] strArr3 = this.zzio;
            if (strArr3 != null && strArr3.length > 0) {
                int i9 = 0;
                while (true) {
                    String[] strArr4 = this.zzio;
                    if (i9 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i9];
                    if (str2 != null) {
                        zzrgVar.zzb(16, str2);
                    }
                    i9++;
                }
            }
            int i10 = this.zzip;
            if (i10 != 0) {
                zzrgVar.zzy(17, i10);
            }
            boolean z = this.zzin;
            if (z) {
                zzrgVar.zzb(18, z);
            }
            String[] strArr5 = this.zzia;
            if (strArr5 != null && strArr5.length > 0) {
                while (true) {
                    String[] strArr6 = this.zzia;
                    if (i >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i];
                    if (str3 != null) {
                        zzrgVar.zzb(19, str3);
                    }
                    i++;
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        return this;
                    case 10:
                        int iZzb = zzrq.zzb(zzrfVar, 10);
                        String[] strArr = this.zzib;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzib, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length++;
                        }
                        strArr2[length] = zzrfVar.readString();
                        this.zzib = strArr2;
                        break;
                    case 18:
                        int iZzb2 = zzrq.zzb(zzrfVar, 18);
                        zzag.zza[] zzaVarArr = this.zzic;
                        int length2 = zzaVarArr == null ? 0 : zzaVarArr.length;
                        zzag.zza[] zzaVarArr2 = new zzag.zza[iZzb2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzic, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zzag.zza();
                            zzrfVar.zza(zzaVarArr2[length2]);
                            zzrfVar.zzBr();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr2[length2]);
                        this.zzic = zzaVarArr2;
                        break;
                    case 26:
                        int iZzb3 = zzrq.zzb(zzrfVar, 26);
                        zze[] zzeVarArr = this.zzid;
                        int length3 = zzeVarArr == null ? 0 : zzeVarArr.length;
                        zze[] zzeVarArr2 = new zze[iZzb3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzid, 0, zzeVarArr2, 0, length3);
                        }
                        while (length3 < zzeVarArr2.length - 1) {
                            zzeVarArr2[length3] = new zze();
                            zzrfVar.zza(zzeVarArr2[length3]);
                            zzrfVar.zzBr();
                            length3++;
                        }
                        zzeVarArr2[length3] = new zze();
                        zzrfVar.zza(zzeVarArr2[length3]);
                        this.zzid = zzeVarArr2;
                        break;
                    case 34:
                        int iZzb4 = zzrq.zzb(zzrfVar, 34);
                        zzb[] zzbVarArr = this.zzie;
                        int length4 = zzbVarArr == null ? 0 : zzbVarArr.length;
                        zzb[] zzbVarArr2 = new zzb[iZzb4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzie, 0, zzbVarArr2, 0, length4);
                        }
                        while (length4 < zzbVarArr2.length - 1) {
                            zzbVarArr2[length4] = new zzb();
                            zzrfVar.zza(zzbVarArr2[length4]);
                            zzrfVar.zzBr();
                            length4++;
                        }
                        zzbVarArr2[length4] = new zzb();
                        zzrfVar.zza(zzbVarArr2[length4]);
                        this.zzie = zzbVarArr2;
                        break;
                    case 42:
                        int iZzb5 = zzrq.zzb(zzrfVar, 42);
                        zzb[] zzbVarArr3 = this.zzif;
                        int length5 = zzbVarArr3 == null ? 0 : zzbVarArr3.length;
                        zzb[] zzbVarArr4 = new zzb[iZzb5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzif, 0, zzbVarArr4, 0, length5);
                        }
                        while (length5 < zzbVarArr4.length - 1) {
                            zzbVarArr4[length5] = new zzb();
                            zzrfVar.zza(zzbVarArr4[length5]);
                            zzrfVar.zzBr();
                            length5++;
                        }
                        zzbVarArr4[length5] = new zzb();
                        zzrfVar.zza(zzbVarArr4[length5]);
                        this.zzif = zzbVarArr4;
                        break;
                    case 50:
                        int iZzb6 = zzrq.zzb(zzrfVar, 50);
                        zzb[] zzbVarArr5 = this.zzig;
                        int length6 = zzbVarArr5 == null ? 0 : zzbVarArr5.length;
                        zzb[] zzbVarArr6 = new zzb[iZzb6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzig, 0, zzbVarArr6, 0, length6);
                        }
                        while (length6 < zzbVarArr6.length - 1) {
                            zzbVarArr6[length6] = new zzb();
                            zzrfVar.zza(zzbVarArr6[length6]);
                            zzrfVar.zzBr();
                            length6++;
                        }
                        zzbVarArr6[length6] = new zzb();
                        zzrfVar.zza(zzbVarArr6[length6]);
                        this.zzig = zzbVarArr6;
                        break;
                    case 58:
                        int iZzb7 = zzrq.zzb(zzrfVar, 58);
                        zzg[] zzgVarArr = this.zzih;
                        int length7 = zzgVarArr == null ? 0 : zzgVarArr.length;
                        zzg[] zzgVarArr2 = new zzg[iZzb7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzih, 0, zzgVarArr2, 0, length7);
                        }
                        while (length7 < zzgVarArr2.length - 1) {
                            zzgVarArr2[length7] = new zzg();
                            zzrfVar.zza(zzgVarArr2[length7]);
                            zzrfVar.zzBr();
                            length7++;
                        }
                        zzgVarArr2[length7] = new zzg();
                        zzrfVar.zza(zzgVarArr2[length7]);
                        this.zzih = zzgVarArr2;
                        break;
                    case 74:
                        this.zzii = zzrfVar.readString();
                        break;
                    case 82:
                        this.zzij = zzrfVar.readString();
                        break;
                    case 98:
                        this.zzik = zzrfVar.readString();
                        break;
                    case 106:
                        this.version = zzrfVar.readString();
                        break;
                    case 114:
                        if (this.zzil == null) {
                            this.zzil = new zza();
                        }
                        zzrfVar.zza(this.zzil);
                        break;
                    case 125:
                        this.zzim = zzrfVar.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        int iZzb8 = zzrq.zzb(zzrfVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        String[] strArr3 = this.zzio;
                        int length8 = strArr3 == null ? 0 : strArr3.length;
                        String[] strArr4 = new String[iZzb8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzio, 0, strArr4, 0, length8);
                        }
                        while (length8 < strArr4.length - 1) {
                            strArr4[length8] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length8++;
                        }
                        strArr4[length8] = zzrfVar.readString();
                        this.zzio = strArr4;
                        break;
                    case 136:
                        this.zzip = zzrfVar.zzBu();
                        break;
                    case 144:
                        this.zzin = zzrfVar.zzBv();
                        break;
                    case 154:
                        int iZzb9 = zzrq.zzb(zzrfVar, 154);
                        String[] strArr5 = this.zzia;
                        int length9 = strArr5 == null ? 0 : strArr5.length;
                        String[] strArr6 = new String[iZzb9 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzia, 0, strArr6, 0, length9);
                        }
                        while (length9 < strArr6.length - 1) {
                            strArr6[length9] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length9++;
                        }
                        strArr6[length9] = zzrfVar.readString();
                        this.zzia = strArr6;
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

    public static final class zzg extends zzrh<zzg> {
        private static volatile zzg[] zziq;
        public int[] zziA;
        public int[] zzir;
        public int[] zzis;
        public int[] zzit;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziq == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziq == null) {
                        zziq = new zzg[0];
                    }
                }
            }
            return zziq;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) obj;
            if (zzrl.equals(this.zzir, zzgVar.zzir) && zzrl.equals(this.zzis, zzgVar.zzis) && zzrl.equals(this.zzit, zzgVar.zzit) && zzrl.equals(this.zziu, zzgVar.zziu) && zzrl.equals(this.zziv, zzgVar.zziv) && zzrl.equals(this.zziw, zzgVar.zziw) && zzrl.equals(this.zzix, zzgVar.zzix) && zzrl.equals(this.zziy, zzgVar.zziy) && zzrl.equals(this.zziz, zzgVar.zziz) && zzrl.equals(this.zziA, zzgVar.zziA)) {
                return zza(zzgVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((527 + zzrl.hashCode(this.zzir)) * 31) + zzrl.hashCode(this.zzis)) * 31) + zzrl.hashCode(this.zzit)) * 31) + zzrl.hashCode(this.zziu)) * 31) + zzrl.hashCode(this.zziv)) * 31) + zzrl.hashCode(this.zziw)) * 31) + zzrl.hashCode(this.zzix)) * 31) + zzrl.hashCode(this.zziy)) * 31) + zzrl.hashCode(this.zziz)) * 31) + zzrl.hashCode(this.zziA)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int[] iArr5;
            int[] iArr6;
            int[] iArr7;
            int[] iArr8;
            int[] iArr9;
            int iZzB = super.zzB();
            int[] iArr10 = this.zzir;
            int i = 0;
            if (iArr10 != null && iArr10.length > 0) {
                int i2 = 0;
                int iZzkJ = 0;
                while (true) {
                    iArr9 = this.zzir;
                    if (i2 >= iArr9.length) {
                        break;
                    }
                    iZzkJ += zzrg.zzkJ(iArr9[i2]);
                    i2++;
                }
                iZzB = iZzB + iZzkJ + (iArr9.length * 1);
            }
            int[] iArr11 = this.zzis;
            if (iArr11 != null && iArr11.length > 0) {
                int i3 = 0;
                int iZzkJ2 = 0;
                while (true) {
                    iArr8 = this.zzis;
                    if (i3 >= iArr8.length) {
                        break;
                    }
                    iZzkJ2 += zzrg.zzkJ(iArr8[i3]);
                    i3++;
                }
                iZzB = iZzB + iZzkJ2 + (iArr8.length * 1);
            }
            int[] iArr12 = this.zzit;
            if (iArr12 != null && iArr12.length > 0) {
                int i4 = 0;
                int iZzkJ3 = 0;
                while (true) {
                    iArr7 = this.zzit;
                    if (i4 >= iArr7.length) {
                        break;
                    }
                    iZzkJ3 += zzrg.zzkJ(iArr7[i4]);
                    i4++;
                }
                iZzB = iZzB + iZzkJ3 + (iArr7.length * 1);
            }
            int[] iArr13 = this.zziu;
            if (iArr13 != null && iArr13.length > 0) {
                int i5 = 0;
                int iZzkJ4 = 0;
                while (true) {
                    iArr6 = this.zziu;
                    if (i5 >= iArr6.length) {
                        break;
                    }
                    iZzkJ4 += zzrg.zzkJ(iArr6[i5]);
                    i5++;
                }
                iZzB = iZzB + iZzkJ4 + (iArr6.length * 1);
            }
            int[] iArr14 = this.zziv;
            if (iArr14 != null && iArr14.length > 0) {
                int i6 = 0;
                int iZzkJ5 = 0;
                while (true) {
                    iArr5 = this.zziv;
                    if (i6 >= iArr5.length) {
                        break;
                    }
                    iZzkJ5 += zzrg.zzkJ(iArr5[i6]);
                    i6++;
                }
                iZzB = iZzB + iZzkJ5 + (iArr5.length * 1);
            }
            int[] iArr15 = this.zziw;
            if (iArr15 != null && iArr15.length > 0) {
                int i7 = 0;
                int iZzkJ6 = 0;
                while (true) {
                    iArr4 = this.zziw;
                    if (i7 >= iArr4.length) {
                        break;
                    }
                    iZzkJ6 += zzrg.zzkJ(iArr4[i7]);
                    i7++;
                }
                iZzB = iZzB + iZzkJ6 + (iArr4.length * 1);
            }
            int[] iArr16 = this.zzix;
            if (iArr16 != null && iArr16.length > 0) {
                int i8 = 0;
                int iZzkJ7 = 0;
                while (true) {
                    iArr3 = this.zzix;
                    if (i8 >= iArr3.length) {
                        break;
                    }
                    iZzkJ7 += zzrg.zzkJ(iArr3[i8]);
                    i8++;
                }
                iZzB = iZzB + iZzkJ7 + (iArr3.length * 1);
            }
            int[] iArr17 = this.zziy;
            if (iArr17 != null && iArr17.length > 0) {
                int i9 = 0;
                int iZzkJ8 = 0;
                while (true) {
                    iArr2 = this.zziy;
                    if (i9 >= iArr2.length) {
                        break;
                    }
                    iZzkJ8 += zzrg.zzkJ(iArr2[i9]);
                    i9++;
                }
                iZzB = iZzB + iZzkJ8 + (iArr2.length * 1);
            }
            int[] iArr18 = this.zziz;
            if (iArr18 != null && iArr18.length > 0) {
                int i10 = 0;
                int iZzkJ9 = 0;
                while (true) {
                    iArr = this.zziz;
                    if (i10 >= iArr.length) {
                        break;
                    }
                    iZzkJ9 += zzrg.zzkJ(iArr[i10]);
                    i10++;
                }
                iZzB = iZzB + iZzkJ9 + (iArr.length * 1);
            }
            int[] iArr19 = this.zziA;
            if (iArr19 == null || iArr19.length <= 0) {
                return iZzB;
            }
            int iZzkJ10 = 0;
            while (true) {
                int[] iArr20 = this.zziA;
                if (i >= iArr20.length) {
                    return iZzB + iZzkJ10 + (iArr20.length * 1);
                }
                iZzkJ10 += zzrg.zzkJ(iArr20[i]);
                i++;
            }
        }

        public zzg zzL() {
            this.zzir = zzrq.zzaWh;
            this.zzis = zzrq.zzaWh;
            this.zzit = zzrq.zzaWh;
            this.zziu = zzrq.zzaWh;
            this.zziv = zzrq.zzaWh;
            this.zziw = zzrq.zzaWh;
            this.zzix = zzrq.zzaWh;
            this.zziy = zzrq.zzaWh;
            this.zziz = zzrq.zzaWh;
            this.zziA = zzrq.zzaWh;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            int[] iArr = this.zzir;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zzir;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzrgVar.zzy(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zzis;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zzis;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzrgVar.zzy(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zzit;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zzit;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzrgVar.zzy(3, iArr6[i4]);
                    i4++;
                }
            }
            int[] iArr7 = this.zziu;
            if (iArr7 != null && iArr7.length > 0) {
                int i5 = 0;
                while (true) {
                    int[] iArr8 = this.zziu;
                    if (i5 >= iArr8.length) {
                        break;
                    }
                    zzrgVar.zzy(4, iArr8[i5]);
                    i5++;
                }
            }
            int[] iArr9 = this.zziv;
            if (iArr9 != null && iArr9.length > 0) {
                int i6 = 0;
                while (true) {
                    int[] iArr10 = this.zziv;
                    if (i6 >= iArr10.length) {
                        break;
                    }
                    zzrgVar.zzy(5, iArr10[i6]);
                    i6++;
                }
            }
            int[] iArr11 = this.zziw;
            if (iArr11 != null && iArr11.length > 0) {
                int i7 = 0;
                while (true) {
                    int[] iArr12 = this.zziw;
                    if (i7 >= iArr12.length) {
                        break;
                    }
                    zzrgVar.zzy(6, iArr12[i7]);
                    i7++;
                }
            }
            int[] iArr13 = this.zzix;
            if (iArr13 != null && iArr13.length > 0) {
                int i8 = 0;
                while (true) {
                    int[] iArr14 = this.zzix;
                    if (i8 >= iArr14.length) {
                        break;
                    }
                    zzrgVar.zzy(7, iArr14[i8]);
                    i8++;
                }
            }
            int[] iArr15 = this.zziy;
            if (iArr15 != null && iArr15.length > 0) {
                int i9 = 0;
                while (true) {
                    int[] iArr16 = this.zziy;
                    if (i9 >= iArr16.length) {
                        break;
                    }
                    zzrgVar.zzy(8, iArr16[i9]);
                    i9++;
                }
            }
            int[] iArr17 = this.zziz;
            if (iArr17 != null && iArr17.length > 0) {
                int i10 = 0;
                while (true) {
                    int[] iArr18 = this.zziz;
                    if (i10 >= iArr18.length) {
                        break;
                    }
                    zzrgVar.zzy(9, iArr18[i10]);
                    i10++;
                }
            }
            int[] iArr19 = this.zziA;
            if (iArr19 != null && iArr19.length > 0) {
                while (true) {
                    int[] iArr20 = this.zziA;
                    if (i >= iArr20.length) {
                        break;
                    }
                    zzrgVar.zzy(10, iArr20[i]);
                    i++;
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public zzg zzb(zzrf zzrfVar) throws IOException {
            int iZzkC;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        return this;
                    case 8:
                        int iZzb = zzrq.zzb(zzrfVar, 8);
                        int[] iArr = this.zzir;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzir, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length++;
                        }
                        iArr2[length] = zzrfVar.zzBu();
                        this.zzir = iArr2;
                        continue;
                    case 10:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i++;
                        }
                        zzrfVar.zzkE(position);
                        int[] iArr3 = this.zzir;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzir, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = zzrfVar.zzBu();
                            length2++;
                        }
                        this.zzir = iArr4;
                        break;
                    case 16:
                        int iZzb2 = zzrq.zzb(zzrfVar, 16);
                        int[] iArr5 = this.zzis;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[iZzb2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzis, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length3++;
                        }
                        iArr6[length3] = zzrfVar.zzBu();
                        this.zzis = iArr6;
                        continue;
                    case 18:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position2);
                        int[] iArr7 = this.zzis;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzis, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = zzrfVar.zzBu();
                            length4++;
                        }
                        this.zzis = iArr8;
                        break;
                    case 24:
                        int iZzb3 = zzrq.zzb(zzrfVar, 24);
                        int[] iArr9 = this.zzit;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int[] iArr10 = new int[iZzb3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzit, 0, iArr10, 0, length5);
                        }
                        while (length5 < iArr10.length - 1) {
                            iArr10[length5] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length5++;
                        }
                        iArr10[length5] = zzrfVar.zzBu();
                        this.zzit = iArr10;
                        continue;
                    case 26:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position3 = zzrfVar.getPosition();
                        int i3 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i3++;
                        }
                        zzrfVar.zzkE(position3);
                        int[] iArr11 = this.zzit;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int[] iArr12 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzit, 0, iArr12, 0, length6);
                        }
                        while (length6 < iArr12.length) {
                            iArr12[length6] = zzrfVar.zzBu();
                            length6++;
                        }
                        this.zzit = iArr12;
                        break;
                    case 32:
                        int iZzb4 = zzrq.zzb(zzrfVar, 32);
                        int[] iArr13 = this.zziu;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int[] iArr14 = new int[iZzb4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zziu, 0, iArr14, 0, length7);
                        }
                        while (length7 < iArr14.length - 1) {
                            iArr14[length7] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length7++;
                        }
                        iArr14[length7] = zzrfVar.zzBu();
                        this.zziu = iArr14;
                        continue;
                    case 34:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position4 = zzrfVar.getPosition();
                        int i4 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i4++;
                        }
                        zzrfVar.zzkE(position4);
                        int[] iArr15 = this.zziu;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int[] iArr16 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zziu, 0, iArr16, 0, length8);
                        }
                        while (length8 < iArr16.length) {
                            iArr16[length8] = zzrfVar.zzBu();
                            length8++;
                        }
                        this.zziu = iArr16;
                        break;
                    case 40:
                        int iZzb5 = zzrq.zzb(zzrfVar, 40);
                        int[] iArr17 = this.zziv;
                        int length9 = iArr17 == null ? 0 : iArr17.length;
                        int[] iArr18 = new int[iZzb5 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zziv, 0, iArr18, 0, length9);
                        }
                        while (length9 < iArr18.length - 1) {
                            iArr18[length9] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length9++;
                        }
                        iArr18[length9] = zzrfVar.zzBu();
                        this.zziv = iArr18;
                        continue;
                    case 42:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position5 = zzrfVar.getPosition();
                        int i5 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i5++;
                        }
                        zzrfVar.zzkE(position5);
                        int[] iArr19 = this.zziv;
                        int length10 = iArr19 == null ? 0 : iArr19.length;
                        int[] iArr20 = new int[i5 + length10];
                        if (length10 != 0) {
                            System.arraycopy(this.zziv, 0, iArr20, 0, length10);
                        }
                        while (length10 < iArr20.length) {
                            iArr20[length10] = zzrfVar.zzBu();
                            length10++;
                        }
                        this.zziv = iArr20;
                        break;
                    case 48:
                        int iZzb6 = zzrq.zzb(zzrfVar, 48);
                        int[] iArr21 = this.zziw;
                        int length11 = iArr21 == null ? 0 : iArr21.length;
                        int[] iArr22 = new int[iZzb6 + length11];
                        if (length11 != 0) {
                            System.arraycopy(this.zziw, 0, iArr22, 0, length11);
                        }
                        while (length11 < iArr22.length - 1) {
                            iArr22[length11] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length11++;
                        }
                        iArr22[length11] = zzrfVar.zzBu();
                        this.zziw = iArr22;
                        continue;
                    case 50:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position6 = zzrfVar.getPosition();
                        int i6 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i6++;
                        }
                        zzrfVar.zzkE(position6);
                        int[] iArr23 = this.zziw;
                        int length12 = iArr23 == null ? 0 : iArr23.length;
                        int[] iArr24 = new int[i6 + length12];
                        if (length12 != 0) {
                            System.arraycopy(this.zziw, 0, iArr24, 0, length12);
                        }
                        while (length12 < iArr24.length) {
                            iArr24[length12] = zzrfVar.zzBu();
                            length12++;
                        }
                        this.zziw = iArr24;
                        break;
                    case 56:
                        int iZzb7 = zzrq.zzb(zzrfVar, 56);
                        int[] iArr25 = this.zzix;
                        int length13 = iArr25 == null ? 0 : iArr25.length;
                        int[] iArr26 = new int[iZzb7 + length13];
                        if (length13 != 0) {
                            System.arraycopy(this.zzix, 0, iArr26, 0, length13);
                        }
                        while (length13 < iArr26.length - 1) {
                            iArr26[length13] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length13++;
                        }
                        iArr26[length13] = zzrfVar.zzBu();
                        this.zzix = iArr26;
                        continue;
                    case 58:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position7 = zzrfVar.getPosition();
                        int i7 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i7++;
                        }
                        zzrfVar.zzkE(position7);
                        int[] iArr27 = this.zzix;
                        int length14 = iArr27 == null ? 0 : iArr27.length;
                        int[] iArr28 = new int[i7 + length14];
                        if (length14 != 0) {
                            System.arraycopy(this.zzix, 0, iArr28, 0, length14);
                        }
                        while (length14 < iArr28.length) {
                            iArr28[length14] = zzrfVar.zzBu();
                            length14++;
                        }
                        this.zzix = iArr28;
                        break;
                    case 64:
                        int iZzb8 = zzrq.zzb(zzrfVar, 64);
                        int[] iArr29 = this.zziy;
                        int length15 = iArr29 == null ? 0 : iArr29.length;
                        int[] iArr30 = new int[iZzb8 + length15];
                        if (length15 != 0) {
                            System.arraycopy(this.zziy, 0, iArr30, 0, length15);
                        }
                        while (length15 < iArr30.length - 1) {
                            iArr30[length15] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length15++;
                        }
                        iArr30[length15] = zzrfVar.zzBu();
                        this.zziy = iArr30;
                        continue;
                    case 66:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position8 = zzrfVar.getPosition();
                        int i8 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i8++;
                        }
                        zzrfVar.zzkE(position8);
                        int[] iArr31 = this.zziy;
                        int length16 = iArr31 == null ? 0 : iArr31.length;
                        int[] iArr32 = new int[i8 + length16];
                        if (length16 != 0) {
                            System.arraycopy(this.zziy, 0, iArr32, 0, length16);
                        }
                        while (length16 < iArr32.length) {
                            iArr32[length16] = zzrfVar.zzBu();
                            length16++;
                        }
                        this.zziy = iArr32;
                        break;
                    case 72:
                        int iZzb9 = zzrq.zzb(zzrfVar, 72);
                        int[] iArr33 = this.zziz;
                        int length17 = iArr33 == null ? 0 : iArr33.length;
                        int[] iArr34 = new int[iZzb9 + length17];
                        if (length17 != 0) {
                            System.arraycopy(this.zziz, 0, iArr34, 0, length17);
                        }
                        while (length17 < iArr34.length - 1) {
                            iArr34[length17] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length17++;
                        }
                        iArr34[length17] = zzrfVar.zzBu();
                        this.zziz = iArr34;
                        continue;
                    case 74:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position9 = zzrfVar.getPosition();
                        int i9 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i9++;
                        }
                        zzrfVar.zzkE(position9);
                        int[] iArr35 = this.zziz;
                        int length18 = iArr35 == null ? 0 : iArr35.length;
                        int[] iArr36 = new int[i9 + length18];
                        if (length18 != 0) {
                            System.arraycopy(this.zziz, 0, iArr36, 0, length18);
                        }
                        while (length18 < iArr36.length) {
                            iArr36[length18] = zzrfVar.zzBu();
                            length18++;
                        }
                        this.zziz = iArr36;
                        break;
                    case 80:
                        int iZzb10 = zzrq.zzb(zzrfVar, 80);
                        int[] iArr37 = this.zziA;
                        int length19 = iArr37 == null ? 0 : iArr37.length;
                        int[] iArr38 = new int[iZzb10 + length19];
                        if (length19 != 0) {
                            System.arraycopy(this.zziA, 0, iArr38, 0, length19);
                        }
                        while (length19 < iArr38.length - 1) {
                            iArr38[length19] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length19++;
                        }
                        iArr38[length19] = zzrfVar.zzBu();
                        this.zziA = iArr38;
                        continue;
                    case 82:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position10 = zzrfVar.getPosition();
                        int i10 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i10++;
                        }
                        zzrfVar.zzkE(position10);
                        int[] iArr39 = this.zziA;
                        int length20 = iArr39 == null ? 0 : iArr39.length;
                        int[] iArr40 = new int[i10 + length20];
                        if (length20 != 0) {
                            System.arraycopy(this.zziA, 0, iArr40, 0, length20);
                        }
                        while (length20 < iArr40.length) {
                            iArr40[length20] = zzrfVar.zzBu();
                            length20++;
                        }
                        this.zziA = iArr40;
                        break;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                            return this;
                        }
                        continue;
                        break;
                }
                zzrfVar.zzkD(iZzkC);
            }
        }
    }

    public static final class zzh extends zzrh<zzh> {
        public static final zzri<zzag.zza, zzh> zziB = zzri.zza(11, zzh.class, 810);
        private static final zzh[] zziC = new zzh[0];
        public int[] zziD;
        public int[] zziE;
        public int[] zziF;
        public int zziG;
        public int[] zziH;
        public int zziI;
        public int zziJ;

        public zzh() {
            zzM();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzhVar = (zzh) obj;
            if (zzrl.equals(this.zziD, zzhVar.zziD) && zzrl.equals(this.zziE, zzhVar.zziE) && zzrl.equals(this.zziF, zzhVar.zziF) && this.zziG == zzhVar.zziG && zzrl.equals(this.zziH, zzhVar.zziH) && this.zziI == zzhVar.zziI && this.zziJ == zzhVar.zziJ) {
                return zza(zzhVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((527 + zzrl.hashCode(this.zziD)) * 31) + zzrl.hashCode(this.zziE)) * 31) + zzrl.hashCode(this.zziF)) * 31) + this.zziG) * 31) + zzrl.hashCode(this.zziH)) * 31) + this.zziI) * 31) + this.zziJ) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int iZzB = super.zzB();
            int[] iArr5 = this.zziD;
            int i = 0;
            if (iArr5 != null && iArr5.length > 0) {
                int i2 = 0;
                int iZzkJ = 0;
                while (true) {
                    iArr4 = this.zziD;
                    if (i2 >= iArr4.length) {
                        break;
                    }
                    iZzkJ += zzrg.zzkJ(iArr4[i2]);
                    i2++;
                }
                iZzB = iZzB + iZzkJ + (iArr4.length * 1);
            }
            int[] iArr6 = this.zziE;
            if (iArr6 != null && iArr6.length > 0) {
                int i3 = 0;
                int iZzkJ2 = 0;
                while (true) {
                    iArr3 = this.zziE;
                    if (i3 >= iArr3.length) {
                        break;
                    }
                    iZzkJ2 += zzrg.zzkJ(iArr3[i3]);
                    i3++;
                }
                iZzB = iZzB + iZzkJ2 + (iArr3.length * 1);
            }
            int[] iArr7 = this.zziF;
            if (iArr7 != null && iArr7.length > 0) {
                int i4 = 0;
                int iZzkJ3 = 0;
                while (true) {
                    iArr2 = this.zziF;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    iZzkJ3 += zzrg.zzkJ(iArr2[i4]);
                    i4++;
                }
                iZzB = iZzB + iZzkJ3 + (iArr2.length * 1);
            }
            int i5 = this.zziG;
            if (i5 != 0) {
                iZzB += zzrg.zzA(4, i5);
            }
            int[] iArr8 = this.zziH;
            if (iArr8 != null && iArr8.length > 0) {
                int iZzkJ4 = 0;
                while (true) {
                    iArr = this.zziH;
                    if (i >= iArr.length) {
                        break;
                    }
                    iZzkJ4 += zzrg.zzkJ(iArr[i]);
                    i++;
                }
                iZzB = iZzB + iZzkJ4 + (iArr.length * 1);
            }
            int i6 = this.zziI;
            if (i6 != 0) {
                iZzB += zzrg.zzA(6, i6);
            }
            int i7 = this.zziJ;
            return i7 != 0 ? iZzB + zzrg.zzA(7, i7) : iZzB;
        }

        public zzh zzM() {
            this.zziD = zzrq.zzaWh;
            this.zziE = zzrq.zzaWh;
            this.zziF = zzrq.zzaWh;
            this.zziG = 0;
            this.zziH = zzrq.zzaWh;
            this.zziI = 0;
            this.zziJ = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            int[] iArr = this.zziD;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zziD;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzrgVar.zzy(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zziE;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zziE;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzrgVar.zzy(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zziF;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zziF;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzrgVar.zzy(3, iArr6[i4]);
                    i4++;
                }
            }
            int i5 = this.zziG;
            if (i5 != 0) {
                zzrgVar.zzy(4, i5);
            }
            int[] iArr7 = this.zziH;
            if (iArr7 != null && iArr7.length > 0) {
                while (true) {
                    int[] iArr8 = this.zziH;
                    if (i >= iArr8.length) {
                        break;
                    }
                    zzrgVar.zzy(5, iArr8[i]);
                    i++;
                }
            }
            int i6 = this.zziI;
            if (i6 != 0) {
                zzrgVar.zzy(6, i6);
            }
            int i7 = this.zziJ;
            if (i7 != 0) {
                zzrgVar.zzy(7, i7);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zzh zzb(zzrf zzrfVar) throws IOException {
            int iZzkC;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        return this;
                    case 8:
                        int iZzb = zzrq.zzb(zzrfVar, 8);
                        int[] iArr = this.zziD;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zziD, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length++;
                        }
                        iArr2[length] = zzrfVar.zzBu();
                        this.zziD = iArr2;
                        continue;
                    case 10:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i++;
                        }
                        zzrfVar.zzkE(position);
                        int[] iArr3 = this.zziD;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziD, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = zzrfVar.zzBu();
                            length2++;
                        }
                        this.zziD = iArr4;
                        break;
                    case 16:
                        int iZzb2 = zzrq.zzb(zzrfVar, 16);
                        int[] iArr5 = this.zziE;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[iZzb2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziE, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length3++;
                        }
                        iArr6[length3] = zzrfVar.zzBu();
                        this.zziE = iArr6;
                        continue;
                    case 18:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position2);
                        int[] iArr7 = this.zziE;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zziE, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = zzrfVar.zzBu();
                            length4++;
                        }
                        this.zziE = iArr8;
                        break;
                    case 24:
                        int iZzb3 = zzrq.zzb(zzrfVar, 24);
                        int[] iArr9 = this.zziF;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int[] iArr10 = new int[iZzb3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zziF, 0, iArr10, 0, length5);
                        }
                        while (length5 < iArr10.length - 1) {
                            iArr10[length5] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length5++;
                        }
                        iArr10[length5] = zzrfVar.zzBu();
                        this.zziF = iArr10;
                        continue;
                    case 26:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position3 = zzrfVar.getPosition();
                        int i3 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i3++;
                        }
                        zzrfVar.zzkE(position3);
                        int[] iArr11 = this.zziF;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int[] iArr12 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziF, 0, iArr12, 0, length6);
                        }
                        while (length6 < iArr12.length) {
                            iArr12[length6] = zzrfVar.zzBu();
                            length6++;
                        }
                        this.zziF = iArr12;
                        break;
                    case 32:
                        this.zziG = zzrfVar.zzBu();
                        continue;
                    case 40:
                        int iZzb4 = zzrq.zzb(zzrfVar, 40);
                        int[] iArr13 = this.zziH;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int[] iArr14 = new int[iZzb4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zziH, 0, iArr14, 0, length7);
                        }
                        while (length7 < iArr14.length - 1) {
                            iArr14[length7] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length7++;
                        }
                        iArr14[length7] = zzrfVar.zzBu();
                        this.zziH = iArr14;
                        continue;
                    case 42:
                        iZzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position4 = zzrfVar.getPosition();
                        int i4 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i4++;
                        }
                        zzrfVar.zzkE(position4);
                        int[] iArr15 = this.zziH;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int[] iArr16 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zziH, 0, iArr16, 0, length8);
                        }
                        while (length8 < iArr16.length) {
                            iArr16[length8] = zzrfVar.zzBu();
                            length8++;
                        }
                        this.zziH = iArr16;
                        break;
                    case 48:
                        this.zziI = zzrfVar.zzBu();
                        continue;
                    case 56:
                        this.zziJ = zzrfVar.zzBu();
                        continue;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                            return this;
                        }
                        continue;
                        break;
                }
                zzrfVar.zzkD(iZzkC);
            }
        }
    }

    public static final class zzi extends zzrh<zzi> {
        private static volatile zzi[] zziK;
        public String name;
        public zzag.zza zziL;
        public zzd zziM;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziK == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziK == null) {
                        zziK = new zzi[0];
                    }
                }
            }
            return zziK;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zziVar = (zzi) obj;
            String str = this.name;
            if (str == null) {
                if (zziVar.name != null) {
                    return false;
                }
            } else if (!str.equals(zziVar.name)) {
                return false;
            }
            zzag.zza zzaVar = this.zziL;
            if (zzaVar == null) {
                if (zziVar.zziL != null) {
                    return false;
                }
            } else if (!zzaVar.equals(zziVar.zziL)) {
                return false;
            }
            zzd zzdVar = this.zziM;
            if (zzdVar == null) {
                if (zziVar.zziM != null) {
                    return false;
                }
            } else if (!zzdVar.equals(zziVar.zziM)) {
                return false;
            }
            return zza(zziVar);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            zzag.zza zzaVar = this.zziL;
            int iHashCode2 = (iHashCode + (zzaVar == null ? 0 : zzaVar.hashCode())) * 31;
            zzd zzdVar = this.zziM;
            return ((iHashCode2 + (zzdVar != null ? zzdVar.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.name.equals("")) {
                iZzB += zzrg.zzk(1, this.name);
            }
            zzag.zza zzaVar = this.zziL;
            if (zzaVar != null) {
                iZzB += zzrg.zzc(2, zzaVar);
            }
            zzd zzdVar = this.zziM;
            return zzdVar != null ? iZzB + zzrg.zzc(3, zzdVar) : iZzB;
        }

        public zzi zzO() {
            this.name = "";
            this.zziL = null;
            this.zziM = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.name.equals("")) {
                zzrgVar.zzb(1, this.name);
            }
            zzag.zza zzaVar = this.zziL;
            if (zzaVar != null) {
                zzrgVar.zza(2, zzaVar);
            }
            zzd zzdVar = this.zziM;
            if (zzdVar != null) {
                zzrgVar.zza(3, zzdVar);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zzi zzb(zzrf zzrfVar) throws IOException {
            zzrn zzrnVar;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr != 10) {
                    if (iZzBr == 18) {
                        if (this.zziL == null) {
                            this.zziL = new zzag.zza();
                        }
                        zzrnVar = this.zziL;
                    } else if (iZzBr == 26) {
                        if (this.zziM == null) {
                            this.zziM = new zzd();
                        }
                        zzrnVar = this.zziM;
                    } else if (!zza(zzrfVar, iZzBr)) {
                        return this;
                    }
                    zzrfVar.zza(zzrnVar);
                } else {
                    this.name = zzrfVar.readString();
                }
            }
        }
    }

    public static final class zzj extends zzrh<zzj> {
        public zzi[] zziN;
        public zzf zziO;
        public String zziP;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzrm {
            return (zzj) zzrn.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzjVar = (zzj) obj;
            if (!zzrl.equals(this.zziN, zzjVar.zziN)) {
                return false;
            }
            zzf zzfVar = this.zziO;
            if (zzfVar == null) {
                if (zzjVar.zziO != null) {
                    return false;
                }
            } else if (!zzfVar.equals(zzjVar.zziO)) {
                return false;
            }
            String str = this.zziP;
            if (str == null) {
                if (zzjVar.zziP != null) {
                    return false;
                }
            } else if (!str.equals(zzjVar.zziP)) {
                return false;
            }
            return zza(zzjVar);
        }

        public int hashCode() {
            int iHashCode = (527 + zzrl.hashCode(this.zziN)) * 31;
            zzf zzfVar = this.zziO;
            int iHashCode2 = (iHashCode + (zzfVar == null ? 0 : zzfVar.hashCode())) * 31;
            String str = this.zziP;
            return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            zzi[] zziVarArr = this.zziN;
            if (zziVarArr != null && zziVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zzi[] zziVarArr2 = this.zziN;
                    if (i >= zziVarArr2.length) {
                        break;
                    }
                    zzi zziVar = zziVarArr2[i];
                    if (zziVar != null) {
                        iZzB += zzrg.zzc(1, zziVar);
                    }
                    i++;
                }
            }
            zzf zzfVar = this.zziO;
            if (zzfVar != null) {
                iZzB += zzrg.zzc(2, zzfVar);
            }
            return !this.zziP.equals("") ? iZzB + zzrg.zzk(3, this.zziP) : iZzB;
        }

        public zzj zzP() {
            this.zziN = zzi.zzN();
            this.zziO = null;
            this.zziP = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzi[] zziVarArr = this.zziN;
            if (zziVarArr != null && zziVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zzi[] zziVarArr2 = this.zziN;
                    if (i >= zziVarArr2.length) {
                        break;
                    }
                    zzi zziVar = zziVarArr2[i];
                    if (zziVar != null) {
                        zzrgVar.zza(1, zziVar);
                    }
                    i++;
                }
            }
            zzf zzfVar = this.zziO;
            if (zzfVar != null) {
                zzrgVar.zza(2, zzfVar);
            }
            if (!this.zziP.equals("")) {
                zzrgVar.zzb(3, this.zziP);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public zzj zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    int iZzb = zzrq.zzb(zzrfVar, 10);
                    zzi[] zziVarArr = this.zziN;
                    int length = zziVarArr == null ? 0 : zziVarArr.length;
                    zzi[] zziVarArr2 = new zzi[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zziN, 0, zziVarArr2, 0, length);
                    }
                    while (length < zziVarArr2.length - 1) {
                        zziVarArr2[length] = new zzi();
                        zzrfVar.zza(zziVarArr2[length]);
                        zzrfVar.zzBr();
                        length++;
                    }
                    zziVarArr2[length] = new zzi();
                    zzrfVar.zza(zziVarArr2[length]);
                    this.zziN = zziVarArr2;
                } else if (iZzBr == 18) {
                    if (this.zziO == null) {
                        this.zziO = new zzf();
                    }
                    zzrfVar.zza(this.zziO);
                } else if (iZzBr == 26) {
                    this.zziP = zzrfVar.readString();
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }
    }
}
