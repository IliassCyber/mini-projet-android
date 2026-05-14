package c.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import c.a.b.g;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class j extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<o<?>> f1204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f1205c;
    public final b d;
    public final r e;
    public volatile boolean f = false;

    public j(BlockingQueue<o<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f1204b = blockingQueue;
        this.f1205c = iVar;
        this.d = bVar;
        this.e = rVar;
    }

    public final void a() throws InterruptedException {
        g gVar;
        boolean z;
        o<?> oVarTake = this.f1204b.take();
        SystemClock.elapsedRealtime();
        try {
            oVarTake.a("network-queue-take");
            if (!oVarTake.i()) {
                TrafficStats.setThreadStatsTag(oVarTake.e);
                l lVarF = ((c.a.b.w.b) this.f1205c).f(oVarTake);
                oVarTake.a("network-http-complete");
                if (lVarF.d) {
                    synchronized (oVarTake.f) {
                        z = oVarTake.l;
                    }
                    if (z) {
                        oVarTake.c("not-modified");
                    }
                }
                q<?> qVarL = oVarTake.l(lVarF);
                oVarTake.a("network-parse-complete");
                if (oVarTake.j && qVarL.f1219b != null) {
                    ((c.a.b.w.d) this.d).e(oVarTake.f(), qVarL.f1219b);
                    oVarTake.a("network-cache-written");
                }
                synchronized (oVarTake.f) {
                    oVarTake.l = true;
                }
                ((g) this.e).a(oVarTake, qVarL, null);
                oVarTake.k(qVarL);
                return;
            }
            oVarTake.c("network-discard-cancelled");
            oVarTake.j();
        } catch (u e) {
            SystemClock.elapsedRealtime();
            if (oVarTake == null || (gVar = (g) this.e) == null) {
                throw null;
            }
            oVarTake.a("post-error");
            gVar.f1198a.execute(new g.b(oVarTake, new q(e), null));
            oVarTake.j();
        } catch (Exception e2) {
            Log.e("Volley", v.a("Unhandled exception %s", e2.toString()), e2);
            u uVar = new u(e2);
            SystemClock.elapsedRealtime();
            g gVar2 = (g) this.e;
            if (gVar2 == null) {
                throw null;
            }
            oVarTake.a("post-error");
            gVar2.f1198a.execute(new g.b(oVarTake, new q(uVar), null));
            oVarTake.j();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
