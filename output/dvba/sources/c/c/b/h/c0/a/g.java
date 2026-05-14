package c.c.b.h.c0.a;

import android.content.Context;
import c.c.a.a.f.c.d1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a<t0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1793c;
    public final t0 d;
    public final Future<c<t0>> e = c();

    public g(Context context, t0 t0Var) {
        this.f1793c = context;
        this.d = t0Var;
    }

    public static c.c.b.h.d0.c0 f(c.c.b.b bVar, c.c.a.a.f.c.z0 z0Var) {
        c.c.a.a.c.l.q.f(bVar);
        c.c.a.a.c.l.q.f(z0Var);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.c.b.h.d0.z(z0Var, "firebase"));
        List<d1> list = z0Var.g.f1445b;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new c.c.b.h.d0.z(list.get(i)));
            }
        }
        c.c.b.h.d0.c0 c0Var = new c.c.b.h.d0.c0(bVar, arrayList);
        c0Var.j = new c.c.b.h.d0.e0(z0Var.k, z0Var.j);
        c0Var.k = z0Var.l;
        c0Var.l = z0Var.m;
        c0Var.l(c.c.a.a.c.l.q.t0(z0Var.n));
        return c0Var;
    }

    @Override // c.c.b.h.c0.a.a
    public final Future<c<t0>> c() {
        Future<c<t0>> future = this.e;
        if (future != null) {
            return future;
        }
        j0 j0Var = new j0(this.d, this.f1793c);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor).submit(j0Var);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final <ResultT> c.c.a.a.h.d<ResultT> e(c.c.a.a.h.d<ResultT> dVar, f<l0, ResultT> fVar) {
        h hVar = new h(this, fVar);
        c.c.a.a.h.t tVar = (c.c.a.a.h.t) dVar;
        if (tVar == null) {
            throw null;
        }
        Executor executor = c.c.a.a.h.f.f1501a;
        c.c.a.a.h.t tVar2 = new c.c.a.a.h.t();
        tVar.f1532b.b(new c.c.a.a.h.g(executor, hVar, tVar2));
        tVar.e();
        return tVar2;
    }
}
