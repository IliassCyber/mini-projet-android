package c.c.b.h;

import c.c.a.a.f.c.a1;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements c.c.b.h.d0.f, c.c.b.h.d0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f1872a;

    public l0(FirebaseAuth firebaseAuth) {
        this.f1872a = firebaseAuth;
    }

    @Override // c.c.b.h.d0.r
    public final void a(a1 a1Var, o oVar) {
        this.f1872a.b(oVar, a1Var, true, true);
    }

    @Override // c.c.b.h.d0.f
    public final void b(Status status) {
        int i = status.f1952c;
        if (i == 17011 || i == 17021 || i == 17005) {
            this.f1872a.a();
        }
    }
}
