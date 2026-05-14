package c.c.a.b.u;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f1706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1707c;

    public l(f fVar, r rVar) {
        this.f1707c = fVar;
        this.f1706b = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iK1 = this.f1707c.a0().k1() - 1;
        if (iK1 >= 0) {
            this.f1707c.c0(this.f1706b.e(iK1));
        }
    }
}
