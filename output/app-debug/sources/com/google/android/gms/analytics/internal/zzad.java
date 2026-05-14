package com.google.android.gms.analytics.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzad {
    private final long zzMf;
    private final int zzMg;
    private double zzMh;
    private long zzMi;
    private final Object zzMj;
    private final String zzuO;

    public zzad(int i, long j, String str) {
        this.zzMj = new Object();
        this.zzMg = i;
        this.zzMh = this.zzMg;
        this.zzMf = j;
        this.zzuO = str;
    }

    public zzad(String str) {
        this(60, 2000L, str);
    }

    public boolean zzkb() {
        synchronized (this.zzMj) {
            long jCurrentTimeMillis = System.currentTimeMillis();
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
            zzae.zzaC("Excessive " + this.zzuO + " detected; call ignored.");
            return false;
        }
    }
}
