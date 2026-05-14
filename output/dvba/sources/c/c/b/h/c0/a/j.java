package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class j extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.b.h.c w;

    public j(c.c.b.h.c cVar) {
        super(2);
        c.c.a.a.c.l.q.g(cVar, "credential cannot be null");
        this.w = cVar;
        c.c.a.a.c.l.q.e(cVar.f1777b, "email cannot be null");
        c.c.a.a.c.l.q.e(cVar.f1778c, "password cannot be null");
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
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.m

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final j f1803a;

            {
                this.f1803a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                j jVar = this.f1803a;
                jVar.g = new b1<>(jVar, (c.c.a.a.h.e) obj2);
                boolean z = jVar.t;
                p0 p0VarA = ((l0) obj).a();
                if (z) {
                    c.c.b.h.c cVar = jVar.w;
                    p0VarA.v(cVar.f1777b, cVar.f1778c, jVar.d.m(), jVar.f1816b);
                } else {
                    c.c.b.h.c cVar2 = jVar.w;
                    p0VarA.B(new c.c.a.a.f.c.d0(cVar2.f1777b, cVar2.f1778c, jVar.d.m()), jVar.f1816b);
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
