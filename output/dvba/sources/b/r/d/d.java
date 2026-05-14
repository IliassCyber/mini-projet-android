package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1028c;

    public d(k kVar, ArrayList arrayList) {
        this.f1028c = kVar;
        this.f1027b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (k.a aVar : this.f1027b) {
            k kVar = this.f1028c;
            if (kVar == null) {
                throw null;
            }
            RecyclerView.d0 d0Var = aVar.f1046a;
            View view = d0Var == null ? null : d0Var.f184a;
            RecyclerView.d0 d0Var2 = aVar.f1047b;
            View view2 = d0Var2 != null ? d0Var2.f184a : null;
            if (view != null) {
                ViewPropertyAnimator duration = view.animate().setDuration(kVar.f);
                kVar.r.add(aVar.f1046a);
                duration.translationX(aVar.e - aVar.f1048c);
                duration.translationY(aVar.f - aVar.d);
                duration.alpha(0.0f).setListener(new i(kVar, aVar, duration, view)).start();
            }
            if (view2 != null) {
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                kVar.r.add(aVar.f1047b);
                viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(kVar.f).alpha(1.0f).setListener(new j(kVar, aVar, viewPropertyAnimatorAnimate, view2)).start();
            }
        }
        this.f1027b.clear();
        this.f1028c.n.remove(this.f1027b);
    }
}
