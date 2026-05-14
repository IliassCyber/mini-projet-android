package c.c.a.b.g0;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f1599a;

    public e(a aVar) {
        this.f1599a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f1599a.f1613c.setScaleX(fFloatValue);
        this.f1599a.f1613c.setScaleY(fFloatValue);
    }
}
