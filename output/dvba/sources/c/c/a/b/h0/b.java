package c.c.a.b.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;

/* JADX INFO: loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.c.a.b.t.c f1624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f1625b;

    public b(FabTransformationBehavior fabTransformationBehavior, c.c.a.b.t.c cVar, Drawable drawable) {
        this.f1624a = cVar;
        this.f1625b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1624a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1624a.setCircularRevealOverlayDrawable(this.f1625b);
    }
}
