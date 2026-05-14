package c.c.b.h.c0.a;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class w0 extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f1820a;

    public w0(u0 u0Var) {
        this.f1820a = u0Var;
    }

    public final void t(Status status, c.c.b.h.b bVar, String str, String str2) {
        c.c.b.h.d0.f fVar = this.f1820a.f;
        if (fVar != null) {
            fVar.b(status);
        }
        u0 u0Var = this.f1820a;
        u0Var.p = bVar;
        u0Var.q = str;
        u0Var.r = str2;
        c.c.b.h.d0.f fVar2 = u0Var.f;
        if (fVar2 != null) {
            fVar2.b(status);
        }
        u0 u0Var2 = this.f1820a;
        u0Var2.v = true;
        u0Var2.g.a(null, status);
    }
}
