package b.b.k;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f275b;

    public class a extends b.i.m.s {
        public a() {
        }

        @Override // b.i.m.r
        public void a(View view) {
            o.this.f275b.p.setAlpha(1.0f);
            o.this.f275b.s.d(null);
            o.this.f275b.s = null;
        }

        @Override // b.i.m.s, b.i.m.r
        public void b(View view) {
            o.this.f275b.p.setVisibility(0);
        }
    }

    public o(k kVar) {
        this.f275b = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar = this.f275b;
        kVar.q.showAtLocation(kVar.p, 55, 0, 0);
        this.f275b.y();
        if (!this.f275b.L()) {
            this.f275b.p.setAlpha(1.0f);
            this.f275b.p.setVisibility(0);
            return;
        }
        this.f275b.p.setAlpha(0.0f);
        k kVar2 = this.f275b;
        b.i.m.q qVarA = b.i.m.l.a(kVar2.p);
        qVarA.a(1.0f);
        kVar2.s = qVarA;
        b.i.m.q qVar = this.f275b.s;
        a aVar = new a();
        View view = qVar.f846a.get();
        if (view != null) {
            qVar.e(view, aVar);
        }
    }
}
