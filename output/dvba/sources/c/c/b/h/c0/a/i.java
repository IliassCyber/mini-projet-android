package c.c.b.h.c0.a;

import android.text.TextUtils;
import c.c.a.a.c.k.k.k;

/* JADX INFO: loaded from: classes.dex */
public final class i extends u0<c.c.b.h.p, c.c.b.h.d0.r> {
    public final c.c.a.a.f.c.b0 w;

    public i(String str) {
        super(1);
        c.c.a.a.c.l.q.e(str, "refresh token cannot be null");
        this.w = new c.c.a.a.f.c.b0(str);
    }

    @Override // c.c.b.h.c0.a.f
    public final String a() {
        return "getAccessToken";
    }

    @Override // c.c.b.h.c0.a.f
    public final c.c.a.a.c.k.k.k<l0, c.c.b.h.p> b() {
        k.a aVarA = c.c.a.a.c.k.k.k.a();
        aVarA.f1330b = false;
        aVarA.f1331c = (this.t || this.u) ? null : new c.c.a.a.c.c[]{c.c.a.a.f.c.r0.f1477b};
        aVarA.f1329a = new c.c.a.a.c.k.k.i(this) { // from class: c.c.b.h.c0.a.k

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final i f1802a;

            {
                this.f1802a = this;
            }

            @Override // c.c.a.a.c.k.k.i
            public final void a(Object obj, Object obj2) {
                i iVar = this.f1802a;
                iVar.g = new b1<>(iVar, (c.c.a.a.h.e) obj2);
                boolean z = iVar.t;
                p0 p0VarA = ((l0) obj).a();
                if (z) {
                    p0VarA.n(iVar.w.f1433b, iVar.f1816b);
                } else {
                    p0VarA.j(iVar.w, iVar.f1816b);
                }
            }
        };
        return aVarA.a();
    }

    @Override // c.c.b.h.c0.a.u0
    public final void h() {
        if (TextUtils.isEmpty(this.j.f1430b)) {
            c.c.a.a.f.c.a1 a1Var = this.j;
            String str = this.w.f1433b;
            if (a1Var == null) {
                throw null;
            }
            c.c.a.a.c.l.q.d(str);
            a1Var.f1430b = str;
        }
        ((c.c.b.h.d0.r) this.e).a(this.j, this.d);
        c.c.b.h.p pVarA = c.c.b.h.d0.i.a(this.j.f1431c);
        this.v = true;
        this.g.a(pVarA, null);
    }
}
