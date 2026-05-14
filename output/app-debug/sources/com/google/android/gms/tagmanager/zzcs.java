package com.google.android.gms.tagmanager;

/* JADX INFO: loaded from: classes.dex */
class zzcs implements zzcd {
    private final long zzMf;
    private final int zzMg;
    private double zzMh;
    private final Object zzMj;
    private long zzaNC;

    public zzcs() {
        this(60, 2000L);
    }

    public zzcs(int i, long j) {
        this.zzMj = new Object();
        this.zzMg = i;
        this.zzMh = this.zzMg;
        this.zzMf = j;
    }

    @Override // com.google.android.gms.tagmanager.zzcd
    public boolean zzkb() {
        synchronized (this.zzMj) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.zzMh < this.zzMg) {
                double d = jCurrentTimeMillis - this.zzaNC;
                double d2 = this.zzMf;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d / d2;
                if (d3 > 0.0d) {
                    this.zzMh = Math.min(this.zzMg, this.zzMh + d3);
                }
            }
            this.zzaNC = jCurrentTimeMillis;
            if (this.zzMh >= 1.0d) {
                this.zzMh -= 1.0d;
                return true;
            }
            zzbg.zzaC("No more tokens available.");
            return false;
        }
    }
}
