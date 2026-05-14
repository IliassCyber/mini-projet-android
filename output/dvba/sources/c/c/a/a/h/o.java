package c.c.a.a.h;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class o<TResult> implements q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1524b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public b<? super TResult> f1525c;

    public o(Executor executor, b<? super TResult> bVar) {
        this.f1523a = executor;
        this.f1525c = bVar;
    }

    @Override // c.c.a.a.h.q
    public final void a(d<TResult> dVar) {
        if (dVar.b()) {
            synchronized (this.f1524b) {
                if (this.f1525c == null) {
                    return;
                }
                this.f1523a.execute(new p(this, dVar));
            }
        }
    }
}
