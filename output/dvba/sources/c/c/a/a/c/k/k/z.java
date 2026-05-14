package c.c.a.a.c.k.k;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import c.c.a.a.c.k.a;
import c.c.a.a.c.k.k.d;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class z extends c.c.a.a.g.b.e implements c.c.a.a.c.k.d, c.c.a.a.c.k.e {
    public static a.AbstractC0053a<? extends c.c.a.a.g.e, c.c.a.a.g.a> h = c.c.a.a.g.d.f1499c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.AbstractC0053a<? extends c.c.a.a.g.e, c.c.a.a.g.a> f1349c;
    public Set<Scope> d;
    public c.c.a.a.c.l.c e;
    public c.c.a.a.g.e f;
    public a0 g;

    public z(Context context, Handler handler, c.c.a.a.c.l.c cVar) {
        a.AbstractC0053a<? extends c.c.a.a.g.e, c.c.a.a.g.a> abstractC0053a = h;
        this.f1347a = context;
        this.f1348b = handler;
        c.c.a.a.c.l.q.g(cVar, "ClientSettings must not be null");
        this.e = cVar;
        this.d = cVar.f1365b;
        this.f1349c = abstractC0053a;
    }

    @Override // c.c.a.a.c.k.k.c
    public final void c(int i) {
        this.f.g();
    }

    @Override // c.c.a.a.c.k.k.h
    public final void t(c.c.a.a.c.a aVar) {
        ((d.b) this.g).b(aVar);
    }

    @Override // c.c.a.a.c.k.k.c
    public final void y(Bundle bundle) {
        this.f.k(this);
    }
}
