package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1026c;

    public c(k kVar, ArrayList arrayList) {
        this.f1026c = kVar;
        this.f1025b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (k.b bVar : this.f1025b) {
            k kVar = this.f1026c;
            RecyclerView.d0 d0Var = bVar.f1049a;
            int i = bVar.f1050b;
            int i2 = bVar.f1051c;
            int i3 = bVar.d;
            int i4 = bVar.e;
            if (kVar == null) {
                throw null;
            }
            View view = d0Var.f184a;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i6 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.p.add(d0Var);
            viewPropertyAnimatorAnimate.setDuration(kVar.e).setListener(new h(kVar, d0Var, i5, view, i6, viewPropertyAnimatorAnimate)).start();
        }
        this.f1025b.clear();
        this.f1026c.m.remove(this.f1025b);
    }
}
