package c.c.b.h.d0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f1845b = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f1846a;

    public j() {
        n nVar = n.f1850b;
        if (g.f1840a == null) {
            g.f1840a = new g();
        }
        this.f1846a = nVar;
    }

    public final void a(Context context) {
        if (this.f1846a == null) {
            throw null;
        }
        c.c.a.a.c.l.q.f(context);
        n.c(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
    }
}
