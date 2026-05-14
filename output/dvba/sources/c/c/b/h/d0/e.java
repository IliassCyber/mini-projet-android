package c.c.b.h.d0;

import c.c.a.a.f.c.a1;
import c.c.b.h.l0;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f1835c;

    public e(c cVar, String str) {
        this.f1835c = cVar;
        c.c.a.a.c.l.q.d(str);
        this.f1834b = str;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(c.c.b.b.d(this.f1834b));
        c.c.b.h.o oVar = firebaseAuth.f;
        if (oVar != null) {
            a1 a1Var = ((c0) oVar).f1831b;
            int i = ((System.currentTimeMillis() + 300000) > ((a1Var.d.longValue() * 1000) + a1Var.f.longValue()) ? 1 : ((System.currentTimeMillis() + 300000) == ((a1Var.d.longValue() * 1000) + a1Var.f.longValue()) ? 0 : -1));
            c.c.b.h.c0.a.g gVar = firebaseAuth.e;
            c.c.b.b bVar = firebaseAuth.f2025a;
            String str = a1Var.f1430b;
            l0 l0Var = new l0(firebaseAuth);
            if (gVar == null) {
                throw null;
            }
            c.c.b.h.c0.a.i iVar = new c.c.b.h.c0.a.i(str);
            iVar.c(bVar);
            iVar.d(oVar);
            iVar.f(l0Var);
            iVar.e(l0Var);
            c.c.a.a.h.d dVarE = gVar.e(gVar.b(iVar), iVar);
            c.h.c("Token refreshing started", new Object[0]);
            d dVar = new d(this);
            c.c.a.a.h.t tVar = (c.c.a.a.h.t) dVarE;
            tVar.f1532b.b(new c.c.a.a.h.m(c.c.a.a.h.f.f1501a, dVar));
            tVar.e();
        }
    }
}
