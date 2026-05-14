package c.c.b.h.c0.a;

/* JADX WARN: Unexpected interfaces in signature: [c.c.b.h.c0.a.h<ResultT, c.c.a.a.h.d<ResultT>>] */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f1796b;

    public h(g gVar, f fVar) {
        this.f1796b = gVar;
        this.f1795a = fVar;
    }

    public final Object a(c.c.a.a.h.d dVar) {
        Exception exc;
        c.c.a.a.h.t tVar = (c.c.a.a.h.t) dVar;
        synchronized (tVar.f1531a) {
            exc = tVar.f;
        }
        if (!(exc instanceof c.c.a.a.c.k.j)) {
            return dVar;
        }
        g gVar = this.f1796b;
        u0 u0Var = (u0) this.f1795a;
        u0Var.t = true;
        return gVar.b(u0Var);
    }
}
