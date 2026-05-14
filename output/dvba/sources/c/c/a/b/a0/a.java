package c.c.a.b.a0;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f1534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0058a f1535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1536c;

    /* JADX INFO: renamed from: c.c.a.b.a0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0058a {
    }

    public a(InterfaceC0058a interfaceC0058a, Typeface typeface) {
        this.f1534a = typeface;
        this.f1535b = interfaceC0058a;
    }

    @Override // c.c.a.b.a0.d
    public void a(int i) {
        c(this.f1534a);
    }

    @Override // c.c.a.b.a0.d
    public void b(Typeface typeface, boolean z) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (this.f1536c) {
            return;
        }
        c.c.a.b.y.c cVar = ((c.c.a.b.y.b) this.f1535b).f1740a;
        a aVar = cVar.v;
        boolean z = true;
        if (aVar != null) {
            aVar.f1536c = true;
        }
        if (cVar.s != typeface) {
            cVar.s = typeface;
        } else {
            z = false;
        }
        if (z) {
            cVar.k();
        }
    }
}
