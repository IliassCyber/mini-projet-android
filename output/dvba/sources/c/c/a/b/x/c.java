package c.c.a.b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.b.x.e;

/* JADX INFO: loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.f f1728c;
    public final /* synthetic */ e d;

    public c(e eVar, boolean z, e.f fVar) {
        this.d = eVar;
        this.f1727b = z;
        this.f1728c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1726a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e eVar = this.d;
        eVar.p = 0;
        eVar.k = null;
        if (this.f1726a) {
            return;
        }
        eVar.t.b(this.f1727b ? 8 : 4, this.f1727b);
        e.f fVar = this.f1728c;
        if (fVar != null) {
            b bVar = (b) fVar;
            bVar.f1724a.a(bVar.f1725b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.t.b(0, this.f1727b);
        e eVar = this.d;
        eVar.p = 1;
        eVar.k = animator;
        this.f1726a = false;
    }
}
