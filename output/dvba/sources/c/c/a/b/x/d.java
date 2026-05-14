package c.c.a.b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.b.x.e;

/* JADX INFO: loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e.f f1730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f1731c;

    public d(e eVar, boolean z, e.f fVar) {
        this.f1731c = eVar;
        this.f1729a = z;
        this.f1730b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e eVar = this.f1731c;
        eVar.p = 0;
        eVar.k = null;
        e.f fVar = this.f1730b;
        if (fVar != null) {
            b bVar = (b) fVar;
            bVar.f1724a.b(bVar.f1725b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1731c.t.b(0, this.f1729a);
        e eVar = this.f1731c;
        eVar.p = 2;
        eVar.k = animator;
    }
}
