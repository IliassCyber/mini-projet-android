package c.c.a.a.h;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1528a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    public Queue<q<TResult>> f1529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public boolean f1530c;

    public final void a(d<TResult> dVar) {
        q<TResult> qVarPoll;
        synchronized (this.f1528a) {
            if (this.f1529b != null && !this.f1530c) {
                this.f1530c = true;
                while (true) {
                    synchronized (this.f1528a) {
                        qVarPoll = this.f1529b.poll();
                        if (qVarPoll == null) {
                            this.f1530c = false;
                            return;
                        }
                    }
                    qVarPoll.a(dVar);
                }
            }
        }
    }

    public final void b(q<TResult> qVar) {
        synchronized (this.f1528a) {
            if (this.f1529b == null) {
                this.f1529b = new ArrayDeque();
            }
            this.f1529b.add(qVar);
        }
    }
}
