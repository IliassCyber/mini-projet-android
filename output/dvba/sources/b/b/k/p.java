package b.b.k;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class p extends b.i.m.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f277a;

    public p(k kVar) {
        this.f277a = kVar;
    }

    @Override // b.i.m.r
    public void a(View view) {
        this.f277a.p.setAlpha(1.0f);
        this.f277a.s.d(null);
        this.f277a.s = null;
    }

    @Override // b.i.m.s, b.i.m.r
    public void b(View view) {
        this.f277a.p.setVisibility(0);
        this.f277a.p.sendAccessibilityEvent(32);
        if (this.f277a.p.getParent() instanceof View) {
            b.i.m.l.U((View) this.f277a.p.getParent());
        }
    }
}
