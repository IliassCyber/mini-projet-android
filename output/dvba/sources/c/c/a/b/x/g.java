package c.c.a.b.x;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public class g implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f1739b;

    public g(e eVar) {
        this.f1739b = eVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        e eVar = this.f1739b;
        float rotation = eVar.t.getRotation();
        if (eVar.n == rotation) {
            return true;
        }
        eVar.n = rotation;
        eVar.s();
        return true;
    }
}
