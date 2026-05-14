package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzar extends zzrh<zzar> {
    public int versionCode;
    public long zzafV;
    public String zzafX;
    public long zzafY;
    public int zzafZ;

    public zzar() {
        zzpH();
    }

    public static zzar zzl(byte[] bArr) throws zzrm {
        return (zzar) zzrn.zza(new zzar(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzar)) {
            return false;
        }
        zzar zzarVar = (zzar) obj;
        if (this.versionCode != zzarVar.versionCode) {
            return false;
        }
        String str = this.zzafX;
        if (str == null) {
            if (zzarVar.zzafX != null) {
                return false;
            }
        } else if (!str.equals(zzarVar.zzafX)) {
            return false;
        }
        if (this.zzafY == zzarVar.zzafY && this.zzafV == zzarVar.zzafV && this.zzafZ == zzarVar.zzafZ) {
            return zza(zzarVar);
        }
        return false;
    }

    public int hashCode() {
        int i = (527 + this.versionCode) * 31;
        String str = this.zzafX;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.zzafY;
        int i2 = (((i + iHashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzafV;
        return ((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.zzafZ) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        int iZzB = super.zzB() + zzrg.zzA(1, this.versionCode) + zzrg.zzk(2, this.zzafX) + zzrg.zze(3, this.zzafY) + zzrg.zze(4, this.zzafV);
        int i = this.zzafZ;
        return i != -1 ? iZzB + zzrg.zzA(5, i) : iZzB;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        zzrgVar.zzy(1, this.versionCode);
        zzrgVar.zzb(2, this.zzafX);
        zzrgVar.zzc(3, this.zzafY);
        zzrgVar.zzc(4, this.zzafV);
        int i = this.zzafZ;
        if (i != -1) {
            zzrgVar.zzy(5, i);
        }
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public zzar zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int iZzBr = zzrfVar.zzBr();
            if (iZzBr == 0) {
                return this;
            }
            if (iZzBr == 8) {
                this.versionCode = zzrfVar.zzBu();
            } else if (iZzBr == 18) {
                this.zzafX = zzrfVar.readString();
            } else if (iZzBr == 24) {
                this.zzafY = zzrfVar.zzBx();
            } else if (iZzBr == 32) {
                this.zzafV = zzrfVar.zzBx();
            } else if (iZzBr == 40) {
                this.zzafZ = zzrfVar.zzBu();
            } else if (!zza(zzrfVar, iZzBr)) {
                return this;
            }
        }
    }

    public zzar zzpH() {
        this.versionCode = 1;
        this.zzafX = "";
        this.zzafY = -1L;
        this.zzafV = -1L;
        this.zzafZ = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
