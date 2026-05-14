package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zznz extends zznq<zznz> {
    private String zzRA;
    public int zzaEE;
    public int zzaEF;
    public int zzaEG;
    public int zzyW;
    public int zzyX;

    public String getLanguage() {
        return this.zzRA;
    }

    public void setLanguage(String str) {
        this.zzRA = str;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("language", this.zzRA);
        map.put("screenColors", Integer.valueOf(this.zzaEE));
        map.put("screenWidth", Integer.valueOf(this.zzyW));
        map.put("screenHeight", Integer.valueOf(this.zzyX));
        map.put("viewportWidth", Integer.valueOf(this.zzaEF));
        map.put("viewportHeight", Integer.valueOf(this.zzaEG));
        return zzy(map);
    }

    @Override // com.google.android.gms.internal.zznq
    public void zza(zznz zznzVar) {
        int i = this.zzaEE;
        if (i != 0) {
            zznzVar.zzhF(i);
        }
        int i2 = this.zzyW;
        if (i2 != 0) {
            zznzVar.zzhG(i2);
        }
        int i3 = this.zzyX;
        if (i3 != 0) {
            zznzVar.zzhH(i3);
        }
        int i4 = this.zzaEF;
        if (i4 != 0) {
            zznzVar.zzhI(i4);
        }
        int i5 = this.zzaEG;
        if (i5 != 0) {
            zznzVar.zzhJ(i5);
        }
        if (TextUtils.isEmpty(this.zzRA)) {
            return;
        }
        zznzVar.setLanguage(this.zzRA);
    }

    public void zzhF(int i) {
        this.zzaEE = i;
    }

    public void zzhG(int i) {
        this.zzyW = i;
    }

    public void zzhH(int i) {
        this.zzyX = i;
    }

    public void zzhI(int i) {
        this.zzaEF = i;
    }

    public void zzhJ(int i) {
        this.zzaEG = i;
    }

    public int zzwp() {
        return this.zzaEE;
    }

    public int zzwq() {
        return this.zzyW;
    }

    public int zzwr() {
        return this.zzyX;
    }

    public int zzws() {
        return this.zzaEF;
    }

    public int zzwt() {
        return this.zzaEG;
    }
}
