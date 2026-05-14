package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.a.a.f.c.m0 w;

    public c0(String str, String str2, String str3) {
        super(2);
        c.c.a.a.c.l.q.e(str, "email cannot be null or empty");
        c.c.a.a.c.l.q.e(str2, "password cannot be null or empty");
        this.w = new c.c.a.a.f.c.m0(str, str2, str3);
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "signInWithEmailAndPassword";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, Object> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.e0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c0 f1792a;

            {
                this.f1792a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                c0 c0Var = this.f1792a;
                c0Var.g = new b1<>(c0Var, (c.c.a.a.h.e) obj2);
                boolean z = c0Var.t;
                p0 p0VarA = ((l0) obj).a();
                if (!z) {
                    p0VarA.o(c0Var.w, c0Var.f1816b);
                } else {
                    c.c.a.a.f.c.m0 m0Var = c0Var.w;
                    p0VarA.A(m0Var.f1463b, m0Var.f1464c, c0Var.f1816b);
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
