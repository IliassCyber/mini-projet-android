package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import c.c.a.a.c.k.f;
import c.c.a.a.c.k.g;
import c.c.a.a.c.k.h;
import c.c.a.a.c.k.i;
import c.c.a.a.c.k.k.f0;
import c.c.a.a.c.k.k.l0;
import c.c.a.a.c.l.q;
import c.c.a.a.f.a.c;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends h> extends f<R> {
    public i<? super R> e;
    public R g;
    public Status h;
    public volatile boolean i;
    public boolean j;

    @KeepName
    public b mResultGuardian;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1953a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f1955c = new CountDownLatch(1);
    public final ArrayList<f.a> d = new ArrayList<>();
    public final AtomicReference<f0> f = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<R> f1954b = new a<>(Looper.getMainLooper());

    public static class a<R extends h> extends c {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).f(Status.g);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            i iVar = (i) pair.first;
            h hVar = (h) pair.second;
            try {
                iVar.a(hVar);
            } catch (RuntimeException e) {
                BasePendingResult.e(hVar);
                throw e;
            }
        }
    }

    public final class b {
        public b(l0 l0Var) {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.e(BasePendingResult.this.g);
            super.finalize();
        }
    }

    static {
        new l0();
    }

    @Deprecated
    public BasePendingResult() {
        new WeakReference(null);
    }

    public static void e(h hVar) {
        if (hVar instanceof g) {
            try {
                ((g) hVar).a();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(hVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    public abstract R a(Status status);

    public final boolean b() {
        return this.f1955c.getCount() == 0;
    }

    public final void c(R r) {
        synchronized (this.f1953a) {
            if (this.j) {
                e(r);
                return;
            }
            b();
            boolean z = true;
            q.i(!b(), "Results have already been set");
            if (this.i) {
                z = false;
            }
            q.i(z, "Result has already been consumed");
            d(r);
        }
    }

    public final void d(R r) {
        R r2;
        this.g = r;
        this.f1955c.countDown();
        this.h = this.g.f();
        int i = 0;
        if (this.e != null) {
            this.f1954b.removeMessages(2);
            a<R> aVar = this.f1954b;
            i<? super R> iVar = this.e;
            synchronized (this.f1953a) {
                q.i(!this.i, "Result has already been consumed.");
                q.i(b(), "Result is not ready.");
                r2 = this.g;
                this.g = null;
                this.e = null;
                this.i = true;
            }
            f0 andSet = this.f.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
            }
            if (aVar == null) {
                throw null;
            }
            aVar.sendMessage(aVar.obtainMessage(1, new Pair(iVar, r2)));
        } else if (this.g instanceof g) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<f.a> arrayList = this.d;
        int size = arrayList.size();
        while (i < size) {
            f.a aVar2 = arrayList.get(i);
            i++;
            aVar2.a(this.h);
        }
        this.d.clear();
    }

    public final void f(Status status) {
        synchronized (this.f1953a) {
            if (!b()) {
                c(a(status));
                this.j = true;
            }
        }
    }
}
