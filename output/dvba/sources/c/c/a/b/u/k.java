package c.c.a.b.u;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f1704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1705c;

    public k(f fVar, r rVar) {
        this.f1705c = fVar;
        this.f1704b = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iI1 = this.f1705c.a0().i1() + 1;
        if (iI1 < this.f1705c.e0.getAdapter().a()) {
            this.f1705c.c0(this.f1704b.e(iI1));
        }
    }
}
