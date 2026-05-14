package c.c.a.a.h;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class i<TResult> implements q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1510b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public g f1511c;

    public i(Executor executor, g gVar) {
        this.f1509a = executor;
        this.f1511c = gVar;
    }

    @Override // c.c.a.a.h.q
    public final void a(d dVar) {
        if (((t) dVar).d) {
            synchronized (this.f1510b) {
                if (this.f1511c == null) {
                    return;
                }
                this.f1509a.execute(new j(this));
            }
        }
    }
}
