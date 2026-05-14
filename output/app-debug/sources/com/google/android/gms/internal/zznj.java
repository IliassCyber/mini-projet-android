package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zznj {

    public static final class zza extends zzrh<zza> {
        public C0140zza[] zzawk;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zznj$zza$zza, reason: collision with other inner class name */
        public static final class C0140zza extends zzrh<C0140zza> {
            private static volatile C0140zza[] zzawl;
            public int viewId;
            public String zzawm;
            public String zzawn;

            public C0140zza() {
                zztW();
            }

            public static C0140zza[] zztV() {
                if (zzawl == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzawl == null) {
                            zzawl = new C0140zza[0];
                        }
                    }
                }
                return zzawl;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0140zza)) {
                    return false;
                }
                C0140zza c0140zza = (C0140zza) obj;
                String str = this.zzawm;
                if (str == null) {
                    if (c0140zza.zzawm != null) {
                        return false;
                    }
                } else if (!str.equals(c0140zza.zzawm)) {
                    return false;
                }
                String str2 = this.zzawn;
                if (str2 == null) {
                    if (c0140zza.zzawn != null) {
                        return false;
                    }
                } else if (!str2.equals(c0140zza.zzawn)) {
                    return false;
                }
                if (this.viewId != c0140zza.viewId) {
                    return false;
                }
                return zza(c0140zza);
            }

            public int hashCode() {
                String str = this.zzawm;
                int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.zzawn;
                return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.viewId) * 31) + zzBI();
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            protected int zzB() {
                int iZzB = super.zzB();
                if (!this.zzawm.equals("")) {
                    iZzB += zzrg.zzk(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    iZzB += zzrg.zzk(2, this.zzawn);
                }
                int i = this.viewId;
                return i != 0 ? iZzB + zzrg.zzA(3, i) : iZzB;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrgVar) throws IOException {
                if (!this.zzawm.equals("")) {
                    zzrgVar.zzb(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzrgVar.zzb(2, this.zzawn);
                }
                int i = this.viewId;
                if (i != 0) {
                    zzrgVar.zzy(3, i);
                }
                super.zza(zzrgVar);
            }

            @Override // com.google.android.gms.internal.zzrn
            /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
            public C0140zza zzb(zzrf zzrfVar) throws IOException {
                while (true) {
                    int iZzBr = zzrfVar.zzBr();
                    if (iZzBr == 0) {
                        return this;
                    }
                    if (iZzBr == 10) {
                        this.zzawm = zzrfVar.readString();
                    } else if (iZzBr == 18) {
                        this.zzawn = zzrfVar.readString();
                    } else if (iZzBr == 24) {
                        this.viewId = zzrfVar.zzBu();
                    } else if (!zza(zzrfVar, iZzBr)) {
                        return this;
                    }
                }
            }

            public C0140zza zztW() {
                this.zzawm = "";
                this.zzawn = "";
                this.viewId = 0;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }
        }

        public zza() {
            zztU();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (zzrl.equals(this.zzawk, zzaVar.zzawk)) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((527 + zzrl.hashCode(this.zzawk)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            C0140zza[] c0140zzaArr = this.zzawk;
            if (c0140zzaArr != null && c0140zzaArr.length > 0) {
                int i = 0;
                while (true) {
                    C0140zza[] c0140zzaArr2 = this.zzawk;
                    if (i >= c0140zzaArr2.length) {
                        break;
                    }
                    C0140zza c0140zza = c0140zzaArr2[i];
                    if (c0140zza != null) {
                        iZzB += zzrg.zzc(1, c0140zza);
                    }
                    i++;
                }
            }
            return iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            C0140zza[] c0140zzaArr = this.zzawk;
            if (c0140zzaArr != null && c0140zzaArr.length > 0) {
                int i = 0;
                while (true) {
                    C0140zza[] c0140zzaArr2 = this.zzawk;
                    if (i >= c0140zzaArr2.length) {
                        break;
                    }
                    C0140zza c0140zza = c0140zzaArr2[i];
                    if (c0140zza != null) {
                        zzrgVar.zza(1, c0140zza);
                    }
                    i++;
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    int iZzb = zzrq.zzb(zzrfVar, 10);
                    C0140zza[] c0140zzaArr = this.zzawk;
                    int length = c0140zzaArr == null ? 0 : c0140zzaArr.length;
                    C0140zza[] c0140zzaArr2 = new C0140zza[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzawk, 0, c0140zzaArr2, 0, length);
                    }
                    while (length < c0140zzaArr2.length - 1) {
                        c0140zzaArr2[length] = new C0140zza();
                        zzrfVar.zza(c0140zzaArr2[length]);
                        zzrfVar.zzBr();
                        length++;
                    }
                    c0140zzaArr2[length] = new C0140zza();
                    zzrfVar.zza(c0140zzaArr2[length]);
                    this.zzawk = c0140zzaArr2;
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        public zza zztU() {
            this.zzawk = C0140zza.zztV();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzawo;
        public String name;
        public zzd zzawp;

        public zzb() {
            zztY();
        }

        public static zzb[] zztX() {
            if (zzawo == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzawo == null) {
                        zzawo = new zzb[0];
                    }
                }
            }
            return zzawo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            String str = this.name;
            if (str == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!str.equals(zzbVar.name)) {
                return false;
            }
            zzd zzdVar = this.zzawp;
            if (zzdVar == null) {
                if (zzbVar.zzawp != null) {
                    return false;
                }
            } else if (!zzdVar.equals(zzbVar.zzawp)) {
                return false;
            }
            return zza(zzbVar);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            zzd zzdVar = this.zzawp;
            return ((iHashCode + (zzdVar != null ? zzdVar.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.name.equals("")) {
                iZzB += zzrg.zzk(1, this.name);
            }
            zzd zzdVar = this.zzawp;
            return zzdVar != null ? iZzB + zzrg.zzc(2, zzdVar) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.name.equals("")) {
                zzrgVar.zzb(1, this.name);
            }
            zzd zzdVar = this.zzawp;
            if (zzdVar != null) {
                zzrgVar.zza(2, zzdVar);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.name = zzrfVar.readString();
                } else if (iZzBr == 18) {
                    if (this.zzawp == null) {
                        this.zzawp = new zzd();
                    }
                    zzrfVar.zza(this.zzawp);
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        public zzb zztY() {
            this.name = "";
            this.zzawp = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public String type;
        public zzb[] zzawq;

        public zzc() {
            zztZ();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            String str = this.type;
            if (str == null) {
                if (zzcVar.type != null) {
                    return false;
                }
            } else if (!str.equals(zzcVar.type)) {
                return false;
            }
            if (zzrl.equals(this.zzawq, zzcVar.zzawq)) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            String str = this.type;
            return ((((527 + (str == null ? 0 : str.hashCode())) * 31) + zzrl.hashCode(this.zzawq)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.type.equals("")) {
                iZzB += zzrg.zzk(1, this.type);
            }
            zzb[] zzbVarArr = this.zzawq;
            if (zzbVarArr != null && zzbVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zzb[] zzbVarArr2 = this.zzawq;
                    if (i >= zzbVarArr2.length) {
                        break;
                    }
                    zzb zzbVar = zzbVarArr2[i];
                    if (zzbVar != null) {
                        iZzB += zzrg.zzc(2, zzbVar);
                    }
                    i++;
                }
            }
            return iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.type.equals("")) {
                zzrgVar.zzb(1, this.type);
            }
            zzb[] zzbVarArr = this.zzawq;
            if (zzbVarArr != null && zzbVarArr.length > 0) {
                int i = 0;
                while (true) {
                    zzb[] zzbVarArr2 = this.zzawq;
                    if (i >= zzbVarArr2.length) {
                        break;
                    }
                    zzb zzbVar = zzbVarArr2[i];
                    if (zzbVar != null) {
                        zzrgVar.zza(2, zzbVar);
                    }
                    i++;
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 10) {
                    this.type = zzrfVar.readString();
                } else if (iZzBr == 18) {
                    int iZzb = zzrq.zzb(zzrfVar, 18);
                    zzb[] zzbVarArr = this.zzawq;
                    int length = zzbVarArr == null ? 0 : zzbVarArr.length;
                    zzb[] zzbVarArr2 = new zzb[iZzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzawq, 0, zzbVarArr2, 0, length);
                    }
                    while (length < zzbVarArr2.length - 1) {
                        zzbVarArr2[length] = new zzb();
                        zzrfVar.zza(zzbVarArr2[length]);
                        zzrfVar.zzBr();
                        length++;
                    }
                    zzbVarArr2[length] = new zzb();
                    zzrfVar.zza(zzbVarArr2[length]);
                    this.zzawq = zzbVarArr2;
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        public zzc zztZ() {
            this.type = "";
            this.zzawq = zzb.zztX();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String zzabE;
        public boolean zzawr;
        public long zzaws;
        public double zzawt;
        public zzc zzawu;

        public zzd() {
            zzua();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzawr != zzdVar.zzawr) {
                return false;
            }
            String str = this.zzabE;
            if (str == null) {
                if (zzdVar.zzabE != null) {
                    return false;
                }
            } else if (!str.equals(zzdVar.zzabE)) {
                return false;
            }
            if (this.zzaws != zzdVar.zzaws || Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(zzdVar.zzawt)) {
                return false;
            }
            zzc zzcVar = this.zzawu;
            if (zzcVar == null) {
                if (zzdVar.zzawu != null) {
                    return false;
                }
            } else if (!zzcVar.equals(zzdVar.zzawu)) {
                return false;
            }
            return zza(zzdVar);
        }

        public int hashCode() {
            int i = (527 + (this.zzawr ? 1231 : 1237)) * 31;
            String str = this.zzabE;
            int iHashCode = str == null ? 0 : str.hashCode();
            long j = this.zzaws;
            int i2 = ((i + iHashCode) * 31) + ((int) (j ^ (j >>> 32)));
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzawt);
            int i3 = ((i2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
            zzc zzcVar = this.zzawu;
            return ((i3 + (zzcVar != null ? zzcVar.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            boolean z = this.zzawr;
            if (z) {
                iZzB += zzrg.zzc(1, z);
            }
            if (!this.zzabE.equals("")) {
                iZzB += zzrg.zzk(2, this.zzabE);
            }
            long j = this.zzaws;
            if (j != 0) {
                iZzB += zzrg.zzd(3, j);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                iZzB += zzrg.zzb(4, this.zzawt);
            }
            zzc zzcVar = this.zzawu;
            return zzcVar != null ? iZzB + zzrg.zzc(5, zzcVar) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            boolean z = this.zzawr;
            if (z) {
                zzrgVar.zzb(1, z);
            }
            if (!this.zzabE.equals("")) {
                zzrgVar.zzb(2, this.zzabE);
            }
            long j = this.zzaws;
            if (j != 0) {
                zzrgVar.zzb(3, j);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzrgVar.zza(4, this.zzawt);
            }
            zzc zzcVar = this.zzawu;
            if (zzcVar != null) {
                zzrgVar.zza(5, zzcVar);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr == 8) {
                    this.zzawr = zzrfVar.zzBv();
                } else if (iZzBr == 18) {
                    this.zzabE = zzrfVar.readString();
                } else if (iZzBr == 24) {
                    this.zzaws = zzrfVar.zzBt();
                } else if (iZzBr == 33) {
                    this.zzawt = zzrfVar.readDouble();
                } else if (iZzBr == 42) {
                    if (this.zzawu == null) {
                        this.zzawu = new zzc();
                    }
                    zzrfVar.zza(this.zzawu);
                } else if (!zza(zzrfVar, iZzBr)) {
                    return this;
                }
            }
        }

        public zzd zzua() {
            this.zzawr = false;
            this.zzabE = "";
            this.zzaws = 0L;
            this.zzawt = 0.0d;
            this.zzawu = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
