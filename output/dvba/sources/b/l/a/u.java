package b.l.a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f952c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ b.f.a e;
    public final /* synthetic */ View f;
    public final /* synthetic */ b0 g;
    public final /* synthetic */ Rect h;

    public u(Fragment fragment, Fragment fragment2, boolean z, b.f.a aVar, View view, b0 b0Var, Rect rect) {
        this.f951b = fragment;
        this.f952c = fragment2;
        this.d = z;
        this.e = aVar;
        this.f = view;
        this.g = b0Var;
        this.h = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.c(this.f951b, this.f952c, this.d, this.e, false);
        View view = this.f;
        if (view != null) {
            this.g.j(view, this.h);
        }
    }
}
