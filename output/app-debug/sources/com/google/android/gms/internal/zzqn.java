package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzqn {
    private zzqd zzaPU;
    private zzqb zzaPV;
    private zzlb zzpw;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final zzqe.zza.EnumC0156zza zzaPp;
        private final long zzaPr;
        private final Object zzaQa;

        public Object zzAH() {
            return this.zzaQa;
        }

        public zzqe.zza.EnumC0156zza zzAh() {
            return this.zzaPp;
        }

        public long zzAl() {
            return this.zzaPr;
        }
    }

    public zzqn(zzqd zzqdVar, zzqb zzqbVar) {
        this(zzqdVar, zzqbVar, zzld.zzoQ());
    }

    public zzqn(zzqd zzqdVar, zzqb zzqbVar, zzlb zzlbVar) {
        com.google.android.gms.common.internal.zzu.zzV(zzqdVar.zzAf().size() == 1);
        this.zzaPU = zzqdVar;
        this.zzaPV = zzqbVar;
        this.zzpw = zzlbVar;
    }

    protected abstract zzb zza(zzpy zzpyVar);

    protected abstract void zza(zzqe zzqeVar);

    public void zza(zza zzaVar) {
        com.google.android.gms.tagmanager.zzbg.zzaz("ResourceManager: Failed to download a resource: " + zzaVar.name());
        zzpy zzpyVar = this.zzaPU.zzAf().get(0);
        zzb zzbVarZza = zza(zzpyVar);
        zza(new zzqe((zzbVarZza == null || !(zzbVarZza.zzAH() instanceof zzqf.zzc)) ? new zzqe.zza(Status.zzXR, zzpyVar, zzqe.zza.EnumC0156zza.NETWORK) : new zzqe.zza(Status.zzXP, zzpyVar, null, (zzqf.zzc) zzbVarZza.zzAH(), zzbVarZza.zzAh(), zzbVarZza.zzAl())));
    }

    public void zzu(byte[] bArr) {
        com.google.android.gms.tagmanager.zzbg.zzaB("ResourceManager: Resource downloaded from Network: " + this.zzaPU.getId());
        zzpy zzpyVar = this.zzaPU.zzAf().get(0);
        zzqe.zza.EnumC0156zza enumC0156zzaZzAh = zzqe.zza.EnumC0156zza.NETWORK;
        Object objZzAH = null;
        long jCurrentTimeMillis = 0;
        try {
            objZzAH = this.zzaPV.zzt(bArr);
            jCurrentTimeMillis = this.zzpw.currentTimeMillis();
            if (objZzAH == null) {
                com.google.android.gms.tagmanager.zzbg.zzaA("Parsed resource from network is null");
                zzb zzbVarZza = zza(zzpyVar);
                if (zzbVarZza != null) {
                    objZzAH = zzbVarZza.zzAH();
                    enumC0156zzaZzAh = zzbVarZza.zzAh();
                    jCurrentTimeMillis = zzbVarZza.zzAl();
                }
            }
        } catch (zzqf.zzg e) {
            com.google.android.gms.tagmanager.zzbg.zzaA("Resource from network is corrupted");
            zzb zzbVarZza2 = zza(zzpyVar);
            if (zzbVarZza2 != null) {
                objZzAH = zzbVarZza2.zzAH();
                enumC0156zzaZzAh = zzbVarZza2.zzAh();
            }
        }
        zza(new zzqe(objZzAH != null ? new zzqe.zza(Status.zzXP, zzpyVar, bArr, (zzqf.zzc) objZzAH, enumC0156zzaZzAh, jCurrentTimeMillis) : new zzqe.zza(Status.zzXR, zzpyVar, zzqe.zza.EnumC0156zza.NETWORK)));
    }
}
