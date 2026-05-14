package c.a.b;

import android.os.Handler;
import c.a.b.q;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class g implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1198a;

    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f1199a;

        public a(g gVar, Handler handler) {
            this.f1199a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1199a.post(runnable);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f1200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q f1201c;
        public final Runnable d;

        public b(o oVar, q qVar, Runnable runnable) {
            this.f1200b = oVar;
            this.f1201c = qVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.a aVar;
            if (this.f1200b.i()) {
                this.f1200b.c("canceled-at-delivery");
                return;
            }
            if (this.f1201c.f1220c == null) {
                this.f1200b.b(this.f1201c.f1218a);
            } else {
                o oVar = this.f1200b;
                u uVar = this.f1201c.f1220c;
                synchronized (oVar.f) {
                    aVar = oVar.g;
                }
                if (aVar != null) {
                    aVar.a(uVar);
                }
            }
            if (this.f1201c.d) {
                this.f1200b.a("intermediate-response");
            } else {
                this.f1200b.c("done");
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(Handler handler) {
        this.f1198a = new a(this, handler);
    }

    public void a(o<?> oVar, q<?> qVar, Runnable runnable) {
        synchronized (oVar.f) {
            oVar.l = true;
        }
        oVar.a("post-response");
        this.f1198a.execute(new b(oVar, qVar, runnable));
    }
}
