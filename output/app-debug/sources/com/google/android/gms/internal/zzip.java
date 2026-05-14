package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzip extends zznq<zzip> {
    private String zzEO;
    private String zzJc;
    private String zzJd;
    private String zzJe;
    private boolean zzJf;
    private String zzJg;
    private boolean zzJh;
    private double zzJi;

    public String getClientId() {
        return this.zzJd;
    }

    public String getUserId() {
        return this.zzEO;
    }

    public void setClientId(String str) {
        this.zzJd = str;
    }

    public void setSampleRate(double d) {
        com.google.android.gms.common.internal.zzu.zzb(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
        this.zzJi = d;
    }

    public void setUserId(String str) {
        this.zzEO = str;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("hitType", this.zzJc);
        map.put("clientId", this.zzJd);
        map.put("userId", this.zzEO);
        map.put("androidAdId", this.zzJe);
        map.put("AdTargetingEnabled", Boolean.valueOf(this.zzJf));
        map.put("sessionControl", this.zzJg);
        map.put("nonInteraction", Boolean.valueOf(this.zzJh));
        map.put("sampleRate", Double.valueOf(this.zzJi));
        return zzy(map);
    }

    public void zzE(boolean z) {
        this.zzJf = z;
    }

    public void zzF(boolean z) {
        this.zzJh = z;
    }

    @Override // com.google.android.gms.internal.zznq
    public void zza(zzip zzipVar) {
        if (!TextUtils.isEmpty(this.zzJc)) {
            zzipVar.zzaN(this.zzJc);
        }
        if (!TextUtils.isEmpty(this.zzJd)) {
            zzipVar.setClientId(this.zzJd);
        }
        if (!TextUtils.isEmpty(this.zzEO)) {
            zzipVar.setUserId(this.zzEO);
        }
        if (!TextUtils.isEmpty(this.zzJe)) {
            zzipVar.zzaO(this.zzJe);
        }
        if (this.zzJf) {
            zzipVar.zzE(true);
        }
        if (!TextUtils.isEmpty(this.zzJg)) {
            zzipVar.zzaP(this.zzJg);
        }
        boolean z = this.zzJh;
        if (z) {
            zzipVar.zzF(z);
        }
        double d = this.zzJi;
        if (d != 0.0d) {
            zzipVar.setSampleRate(d);
        }
    }

    public void zzaN(String str) {
        this.zzJc = str;
    }

    public void zzaO(String str) {
        this.zzJe = str;
    }

    public void zzaP(String str) {
        this.zzJg = str;
    }

    public boolean zzhA() {
        return this.zzJh;
    }

    public double zzhB() {
        return this.zzJi;
    }

    public String zzhw() {
        return this.zzJc;
    }

    public String zzhx() {
        return this.zzJe;
    }

    public boolean zzhy() {
        return this.zzJf;
    }

    public String zzhz() {
        return this.zzJg;
    }
}
