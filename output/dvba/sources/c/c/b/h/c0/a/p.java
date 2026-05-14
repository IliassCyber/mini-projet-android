package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class p extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.b.h.c w;

    public p(c.c.b.h.c cVar) {
        super(2);
        c.c.a.a.c.l.q.g(cVar, "credential cannot be null");
        this.w = cVar;
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "linkEmailAuthCredential";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, Object> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.r

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final p f1809a;

            {
                this.f1809a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                p pVar = this.f1809a;
                l0 l0Var = (l0) obj;
                pVar.g = new b1<>(pVar, (c.c.a.a.h.e) obj2);
                c.c.b.h.c cVar = pVar.w;
                c.c.b.h.o oVar = pVar.d;
                if (cVar == null) {
                    throw null;
                }
                cVar.e = oVar.m();
                cVar.f = true;
                c.c.a.a.f.c.o0 o0Var = new c.c.a.a.f.c.o0(cVar);
                boolean z = pVar.t;
                p0 p0VarA = l0Var.a();
                if (z) {
                    p0VarA.p(o0Var.f1470b, pVar.f1816b);
                } else {
                    p0VarA.u(o0Var, pVar.f1816b);
                }
            }
        };
        return aVarA.a();
    }

    @Override // c.c.b.h.c0.a.u0
    public final void h() {
        c.c.b.h.d0.c0 c0VarF = g.f(this.f1817c, this.k);
        ((c.c.b.h.d0.r) this.e).a(this.j, c0VarF);
        c.c.b.h.d0.x xVar = new c.c.b.h.d0.x(c0VarF);
        this.v = true;
        this.g.a(xVar, null);
    }
}
