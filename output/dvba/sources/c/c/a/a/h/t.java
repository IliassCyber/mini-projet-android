package c.c.a.a.h;

import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class t<TResult> extends d<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1531a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r<TResult> f1532b = new r<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public boolean f1533c;
    public volatile boolean d;

    @GuardedBy("mLock")
    public TResult e;

    @GuardedBy("mLock")
    public Exception f;

    @Override // c.c.a.a.h.d
    public final TResult a() {
        TResult tresult;
        synchronized (this.f1531a) {
            c.c.a.a.c.l.q.i(this.f1533c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            }
            if (this.f != null) {
                throw new c(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // c.c.a.a.h.d
    public final boolean b() {
        boolean z;
        synchronized (this.f1531a) {
            z = this.f1533c && !this.d && this.f == null;
        }
        return z;
    }

    public final void c(Exception exc) {
        c.c.a.a.c.l.q.g(exc, "Exception must not be null");
        synchronized (this.f1531a) {
            c.c.a.a.c.l.q.i(!this.f1533c, "Task is already complete");
            this.f1533c = true;
            this.f = exc;
        }
        this.f1532b.a(this);
    }

    public final void d(TResult tresult) {
        synchronized (this.f1531a) {
            c.c.a.a.c.l.q.i(!this.f1533c, "Task is already complete");
            this.f1533c = true;
            this.e = tresult;
        }
        this.f1532b.a(this);
    }

    public final void e() {
        synchronized (this.f1531a) {
            if (this.f1533c) {
                this.f1532b.a(this);
            }
        }
    }
}
