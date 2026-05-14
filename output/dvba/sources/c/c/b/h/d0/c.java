package c.c.b.h.d0;

import android.os.Handler;
import android.os.HandlerThread;
import c.c.a.a.f.c.o1;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static c.c.a.a.c.m.a h = new c.c.a.a.c.m.a("TokenRefresher", "FirebaseAuth:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.c.b.b f1828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f1829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f1830c;
    public long d;
    public HandlerThread e;
    public Handler f;
    public Runnable g;

    public c(c.c.b.b bVar) {
        h.c("Initializing TokenRefresher", new Object[0]);
        c.c.a.a.c.l.q.f(bVar);
        this.f1828a = bVar;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new o1(this.e.getLooper());
        c.c.b.b bVar2 = this.f1828a;
        bVar2.a();
        this.g = new e(this, bVar2.f1763b);
        this.d = 300000L;
    }

    public final void a() {
        c.c.a.a.c.m.a aVar = h;
        long j = this.f1829b - this.d;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        aVar.c(sb.toString(), new Object[0]);
        this.f.removeCallbacks(this.g);
        this.f1830c = Math.max((this.f1829b - System.currentTimeMillis()) - this.d, 0L) / 1000;
        this.f.postDelayed(this.g, this.f1830c * 1000);
    }
}
