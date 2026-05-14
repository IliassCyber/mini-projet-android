package c.c.b.h.c0.a;

import c.c.a.a.f.c.i1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class u0<ResultT, CallbackT> implements f<l0, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1815a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.c.b.b f1817c;
    public c.c.b.h.o d;
    public CallbackT e;
    public c.c.b.h.d0.f f;
    public b1<ResultT> g;
    public Executor i;
    public c.c.a.a.f.c.a1 j;
    public c.c.a.a.f.c.z0 k;
    public c.c.a.a.f.c.x0 l;
    public i1 m;
    public String n;
    public String o;
    public c.c.b.h.b p;
    public String q;
    public String r;
    public c.c.a.a.f.c.v0 s;
    public boolean t;
    public boolean u;
    public boolean v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f1816b = new w0(this);
    public final List<c.c.b.h.x> h = new ArrayList();

    public u0(int i) {
        this.f1815a = i;
    }

    public static void g(u0 u0Var) {
        u0Var.h();
        c.c.a.a.c.l.q.i(u0Var.v, "no success or failure set on method implementation");
    }

    public final u0<ResultT, CallbackT> c(c.c.b.b bVar) {
        c.c.a.a.c.l.q.g(bVar, "firebaseApp cannot be null");
        this.f1817c = bVar;
        return this;
    }

    public final u0<ResultT, CallbackT> d(c.c.b.h.o oVar) {
        c.c.a.a.c.l.q.g(oVar, "firebaseUser cannot be null");
        this.d = oVar;
        return this;
    }

    public final u0<ResultT, CallbackT> e(c.c.b.h.d0.f fVar) {
        c.c.a.a.c.l.q.g(fVar, "external failure callback cannot be null");
        this.f = fVar;
        return this;
    }

    public final u0<ResultT, CallbackT> f(CallbackT callbackt) {
        c.c.a.a.c.l.q.g(callbackt, "external callback cannot be null");
        this.e = callbackt;
        return this;
    }

    public abstract void h();
}
