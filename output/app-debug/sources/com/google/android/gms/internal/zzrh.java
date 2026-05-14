package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrh;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzrh<M extends zzrh<M>> extends zzrn {
    protected zzrj zzaVU;

    @Override // com.google.android.gms.internal.zzrn
    protected int zzB() {
        if (this.zzaVU == null) {
            return 0;
        }
        int iZzB = 0;
        for (int i = 0; i < this.zzaVU.size(); i++) {
            iZzB += this.zzaVU.zzkS(i).zzB();
        }
        return iZzB;
    }

    protected final int zzBI() {
        zzrj zzrjVar = this.zzaVU;
        if (zzrjVar == null || zzrjVar.isEmpty()) {
            return 0;
        }
        return this.zzaVU.hashCode();
    }

    @Override // com.google.android.gms.internal.zzrn
    /* JADX INFO: renamed from: zzBJ, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzrl.zza(this, m);
        return m;
    }

    public final <T> T zza(zzri<M, T> zzriVar) {
        zzrk zzrkVarZzkR;
        zzrj zzrjVar = this.zzaVU;
        if (zzrjVar == null || (zzrkVarZzkR = zzrjVar.zzkR(zzrq.zzkV(zzriVar.tag))) == null) {
            return null;
        }
        return (T) zzrkVarZzkR.zzb(zzriVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        if (this.zzaVU == null) {
            return;
        }
        for (int i = 0; i < this.zzaVU.size(); i++) {
            this.zzaVU.zzkS(i).zza(zzrgVar);
        }
    }

    protected final boolean zza(zzrf zzrfVar, int i) throws IOException {
        int position = zzrfVar.getPosition();
        if (!zzrfVar.zzkA(i)) {
            return false;
        }
        int iZzkV = zzrq.zzkV(i);
        zzrp zzrpVar = new zzrp(i, zzrfVar.zzx(position, zzrfVar.getPosition() - position));
        zzrk zzrkVarZzkR = null;
        zzrj zzrjVar = this.zzaVU;
        if (zzrjVar == null) {
            this.zzaVU = new zzrj();
        } else {
            zzrkVarZzkR = zzrjVar.zzkR(iZzkV);
        }
        if (zzrkVarZzkR == null) {
            zzrkVarZzkR = new zzrk();
            this.zzaVU.zza(iZzkV, zzrkVarZzkR);
        }
        zzrkVarZzkR.zza(zzrpVar);
        return true;
    }

    protected final boolean zza(M m) {
        zzrj zzrjVar = this.zzaVU;
        if (zzrjVar != null && !zzrjVar.isEmpty()) {
            return this.zzaVU.equals(m.zzaVU);
        }
        zzrj zzrjVar2 = m.zzaVU;
        return zzrjVar2 == null || zzrjVar2.isEmpty();
    }
}
