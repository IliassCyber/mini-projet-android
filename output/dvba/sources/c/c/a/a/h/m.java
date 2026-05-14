package c.c.a.a.h;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class m<TResult> implements q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1519b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public a f1520c;

    public m(Executor executor, a aVar) {
        this.f1518a = executor;
        this.f1520c = aVar;
    }

    @Override // c.c.a.a.h.q
    public final void a(d<TResult> dVar) {
        if (dVar.b() || ((t) dVar).d) {
            return;
        }
        synchronized (this.f1519b) {
            if (this.f1520c == null) {
                return;
            }
            this.f1518a.execute(new n(this, dVar));
        }
    }
}
