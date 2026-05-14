package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzrh<zzas> {
    public long zzafV;
    public long zzafY;

    public zzas() {
        zzpI();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        if (this.zzafY == zzasVar.zzafY && this.zzafV == zzasVar.zzafV) {
            return zza(zzasVar);
        }
        return false;
    }

    public int hashCode() {
        long j = this.zzafY;
        int i = (527 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzafV;
        return ((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        return super.zzB() + zzrg.zze(1, this.zzafY) + zzrg.zze(2, this.zzafV);
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        zzrgVar.zzc(1, this.zzafY);
        zzrgVar.zzc(2, this.zzafV);
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public zzas zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int iZzBr = zzrfVar.zzBr();
            if (iZzBr == 0) {
                return this;
            }
            if (iZzBr == 8) {
                this.zzafY = zzrfVar.zzBx();
            } else if (iZzBr == 16) {
                this.zzafV = zzrfVar.zzBx();
            } else if (!zza(zzrfVar, iZzBr)) {
                return this;
            }
        }
    }

    public zzas zzpI() {
        this.zzafY = -1L;
        this.zzafV = -1L;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
