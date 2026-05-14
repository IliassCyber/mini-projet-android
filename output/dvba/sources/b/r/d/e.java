package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1030c;

    public e(k kVar, ArrayList arrayList) {
        this.f1030c = kVar;
        this.f1029b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (RecyclerView.d0 d0Var : this.f1029b) {
            k kVar = this.f1030c;
            if (kVar == null) {
                throw null;
            }
            View view = d0Var.f184a;
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.o.add(d0Var);
            viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(kVar.f193c).setListener(new g(kVar, d0Var, view, viewPropertyAnimatorAnimate)).start();
        }
        this.f1029b.clear();
        this.f1030c.l.remove(this.f1029b);
    }
}
