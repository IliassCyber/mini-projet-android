package c.c.a.a.h;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class k<TResult> implements q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1514b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public c.c.a.a.c.k.k.l<TResult> f1515c;

    public k(Executor executor, c.c.a.a.c.k.k.l<TResult> lVar) {
        this.f1513a = executor;
        this.f1515c = lVar;
    }

    @Override // c.c.a.a.h.q
    public final void a(d<TResult> dVar) {
        synchronized (this.f1514b) {
            if (this.f1515c == null) {
                return;
            }
            this.f1513a.execute(new l(this, dVar));
        }
    }
}
