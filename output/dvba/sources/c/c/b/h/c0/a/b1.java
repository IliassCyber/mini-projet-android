package c.c.b.h.c0.a;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

/* JADX WARN: Unexpected interfaces in signature: [c.c.b.h.c0.a.b1<ResultT>] */
/* JADX INFO: loaded from: classes.dex */
public final class b1<ResultT, CallbackT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0<ResultT, CallbackT> f1784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.a.a.h.e<ResultT> f1785b;

    public b1(u0<ResultT, CallbackT> u0Var, c.c.a.a.h.e<ResultT> eVar) {
        this.f1784a = u0Var;
        this.f1785b = eVar;
    }

    public final void a(ResultT resultt, Status status) {
        c.c.a.a.c.l.q.g(this.f1785b, "completion source cannot be null");
        if (status == null) {
            this.f1785b.f1500a.d(resultt);
            return;
        }
        u0<ResultT, CallbackT> u0Var = this.f1784a;
        if (u0Var.s != null) {
            c.c.a.a.h.e<ResultT> eVar = this.f1785b;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(u0Var.f1817c);
            u0<ResultT, CallbackT> u0Var2 = this.f1784a;
            eVar.f1500a.c(m0.c(firebaseAuth, u0Var2.s, ("reauthenticateWithCredential".equals(u0Var2.a()) || "reauthenticateWithCredentialWithData".equals(this.f1784a.a())) ? this.f1784a.d : null));
            return;
        }
        c.c.b.h.b bVar = u0Var.p;
        if (bVar != null) {
            this.f1785b.f1500a.c(m0.b(status, bVar, u0Var.q, u0Var.r));
        } else {
            this.f1785b.f1500a.c(m0.a(status));
        }
    }
}
