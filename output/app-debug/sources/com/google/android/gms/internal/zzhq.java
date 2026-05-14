package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzhq {
    private long zzGC;
    private long zzGD = Long.MIN_VALUE;
    private Object zzqt = new Object();

    public zzhq(long j) {
        this.zzGC = j;
    }

    public boolean tryAcquire() {
        synchronized (this.zzqt) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzo.zzbz().elapsedRealtime();
            if (this.zzGD + this.zzGC > jElapsedRealtime) {
                return false;
            }
            this.zzGD = jElapsedRealtime;
            return true;
        }
    }
}
