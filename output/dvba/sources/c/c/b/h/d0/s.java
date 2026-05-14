package c.c.b.h.d0;

import c.c.a.a.c.k.k.b;

/* JADX INFO: loaded from: classes.dex */
public final class s implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1859a;

    public s(o oVar) {
        this.f1859a = oVar;
    }

    @Override // c.c.a.a.c.k.k.b.a
    public final void a(boolean z) {
        if (z) {
            this.f1859a.f1853c = true;
            c cVar = this.f1859a.f1852b;
            cVar.f.removeCallbacks(cVar.g);
        } else {
            this.f1859a.f1853c = false;
            o oVar = this.f1859a;
            if (oVar.f1851a > 0 && !oVar.f1853c) {
                this.f1859a.f1852b.a();
            }
        }
    }
}
