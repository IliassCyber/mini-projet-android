package c.c.a.b.g0;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1610a;

    public m(h hVar) {
        this.f1610a = hVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1610a.f1613c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
