package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzpx {

    public static final class zza extends zzrh<zza> {
        public long zzaOZ;
        public zzaf.zzj zzaPa;
        public zzaf.zzf zziO;

        public zza() {
            zzzY();
        }

        public static zza zzs(byte[] bArr) throws zzrm {
            return (zza) zzrn.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.zzaOZ != zzaVar.zzaOZ) {
                return false;
            }
            zzaf.zzf zzfVar = this.zziO;
            if (zzfVar == null) {
                if (zzaVar.zziO != null) {
                    return false;
                }
            } else if (!zzfVar.equals(zzaVar.zziO)) {
                return false;
            }
            zzaf.zzj zzjVar = this.zzaPa;
            if (zzjVar == null) {
                if (zzaVar.zzaPa != null) {
                    return false;
                }
            } else if (!zzjVar.equals(zzaVar.zzaPa)) {
                return false;
            }
            return zza(zzaVar);
        }

        public int hashCode() {
            long j = this.zzaOZ;
            int i = (527 + ((int) (j ^ (j >>> 32)))) * 31;
            zzaf.zzf zzfVar = this.zziO;
            int iHashCode = (i + (zzfVar == null ? 0 : zzfVar.hashCode())) * 31;
            zzaf.zzj zzjVar = this.zzaPa;
            return ((iHashCode + (zzjVar != null ? zzjVar.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB() + zzrg.zzd(1, this.zzaOZ);
            zzaf.zzf zzfVar = this.zziO;
            if (zzfVar != null) {
                iZzB += zzrg.zzc(2, zzfVar);
            }
            zzaf.zzj zzjVar = this.zzaPa;
            return zzjVar != null ? iZzB + zzrg.zzc(3, zzjVar) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzb(1, this.zzaOZ);
            zzaf.zzf zzfVar = this.zziO;
            if (zzfVar != null) {
                zzrgVar.zza(2, zzfVar);
            }
            zzaf.zzj zzjVar = this.zzaPa;
            if (zzjVar != null) {
                zzrgVar.zza(3, zzjVar);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            zzrn zzrnVar;
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                if (iZzBr == 0) {
                    return this;
                }
                if (iZzBr != 8) {
                    if (iZzBr == 18) {
                        if (this.zziO == null) {
                            this.zziO = new zzaf.zzf();
                        }
                        zzrnVar = this.zziO;
                    } else if (iZzBr == 26) {
                        if (this.zzaPa == null) {
                            this.zzaPa = new zzaf.zzj();
                        }
                        zzrnVar = this.zzaPa;
                    } else if (!zza(zzrfVar, iZzBr)) {
                        return this;
                    }
                    zzrfVar.zza(zzrnVar);
                } else {
                    this.zzaOZ = zzrfVar.zzBt();
                }
            }
        }

        public zza zzzY() {
            this.zzaOZ = 0L;
            this.zziO = null;
            this.zzaPa = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
