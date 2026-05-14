package c.c.b.h.d0;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f1851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1853c;

    public o(c.c.b.b bVar) {
        bVar.a();
        Context context = bVar.f1762a;
        c cVar = new c(bVar);
        this.f1853c = false;
        this.f1851a = 0;
        this.f1852b = cVar;
        c.c.a.a.c.k.k.b.b((Application) context.getApplicationContext());
        c.c.a.a.c.k.k.b.f.a(new s(this));
    }
}
