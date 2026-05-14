package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class n extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.b.h.w w;

    public n(c.c.b.h.w wVar) {
        super(2);
        c.c.a.a.c.l.q.g(wVar, "credential cannot be null");
        this.w = wVar;
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "linkPhoneAuthCredential";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, Object> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.q

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final n f1806a;

            {
                this.f1806a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                n nVar = this.f1806a;
                nVar.g = new b1<>(nVar, (c.c.a.a.h.e) obj2);
                boolean z = nVar.t;
                p0 p0VarA = ((l0) obj).a();
                if (z) {
                    p0VarA.h(nVar.d.m(), nVar.w, nVar.f1816b);
                } else {
                    p0VarA.e(new c.c.a.a.f.c.h0(nVar.d.m(), nVar.w), nVar.f1816b);
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
