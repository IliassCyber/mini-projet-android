package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzlb;

/* JADX INFO: loaded from: classes.dex */
class zzbe implements zzcd {
    private final long zzMf;
    private final int zzMg;
    private double zzMh;
    private long zzMi;
    private final Object zzMj = new Object();
    private final long zzaMh;
    private final zzlb zzpw;
    private final String zzuO;

    public zzbe(int i, long j, long j2, String str, zzlb zzlbVar) {
        this.zzMg = i;
        this.zzMh = this.zzMg;
        this.zzMf = j;
        this.zzaMh = j2;
        this.zzuO = str;
        this.zzpw = zzlbVar;
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public boolean zzkb() {
        synchronized (this.zzMj) {
            long jCurrentTimeMillis = this.zzpw.currentTimeMillis();
            if (jCurrentTimeMillis - this.zzMi < this.zzaMh) {
                zzbg.zzaC("Excessive " + this.zzuO + " detected; call ignored.");
                return false;
            }
            if (this.zzMh < this.zzMg) {
                double d = jCurrentTimeMillis - this.zzMi;
                double d2 = this.zzMf;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d / d2;
                if (d3 > 0.0d) {
                    this.zzMh = Math.min(this.zzMg, this.zzMh + d3);
                }
            }
            this.zzMi = jCurrentTimeMillis;
            if (this.zzMh >= 1.0d) {
                this.zzMh -= 1.0d;
                return true;
            }
            zzbg.zzaC("Excessive " + this.zzuO + " detected; call ignored.");
            return false;
        }
    }
}
