package c.c.b.h.c0.a;

import c.c.a.a.c.k.k.k;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class u extends u0<Object, c.c.b.h.d0.r> {
    public final c.c.a.a.f.c.o0 w;

    public u(c.c.b.h.c cVar) {
        super(2);
        c.c.a.a.c.l.q.g(cVar, "credential cannot be null or empty");
        this.w = new c.c.a.a.f.c.o0(cVar);
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "reauthenticateWithEmailLinkWithData";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, Object> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.v

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final u f1818a;

            {
                this.f1818a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                u uVar = this.f1818a;
                uVar.g = new b1<>(uVar, (c.c.a.a.h.e) obj2);
                boolean z = uVar.t;
                p0 p0VarA = ((l0) obj).a();
                if (z) {
                    p0VarA.p(uVar.w.f1470b, uVar.f1816b);
                } else {
                    p0VarA.u(uVar.w, uVar.f1816b);
                }
            }
        };
        return aVarA.a();
    }

    @Override // c.c.b.h.c0.a.u0
    public final void h() {
        c.c.b.h.d0.c0 c0VarF = g.f(this.f1817c, this.k);
        if (!((c.c.b.h.d0.c0) this.d).f1832c.f1865b.equalsIgnoreCase(c0VarF.f1832c.f1865b)) {
            Status status = new Status(17024, null);
            this.v = true;
            this.g.a(null, status);
        } else {
            ((c.c.b.h.d0.r) this.e).a(this.j, c0VarF);
            c.c.b.h.d0.x xVar = new c.c.b.h.d0.x(c0VarF);
            this.v = true;
            this.g.a(xVar, null);
        }
    }
}
