package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.a.a.f.c.o0 w;

    public d0(c.c.b.h.c cVar) {
        super(2);
        c.c.a.a.c.l.q.g(cVar, "credential cannot be null");
        this.w = new c.c.a.a.f.c.o0(cVar);
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "sendSignInLinkToEmail";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, Object> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.g0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final d0 f1794a;

            {
                this.f1794a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                d0 d0Var = this.f1794a;
                d0Var.g = new b1<>(d0Var, (c.c.a.a.h.e) obj2);
                boolean z = d0Var.t;
                p0 p0VarA = ((l0) obj).a();
                if (z) {
                    p0VarA.p(d0Var.w.f1470b, d0Var.f1816b);
                } else {
                    p0VarA.u(d0Var.w, d0Var.f1816b);
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
