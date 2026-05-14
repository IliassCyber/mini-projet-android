package c.c.a.b.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.b.t.c;
import com.google.android.material.transformation.FabTransformationBehavior;

/* JADX INFO: loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.c.a.b.t.c f1626a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.c.a.b.t.c cVar) {
        this.f1626a = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        c.e revealInfo = this.f1626a.getRevealInfo();
        revealInfo.f1681c = Float.MAX_VALUE;
        this.f1626a.setRevealInfo(revealInfo);
    }
}
