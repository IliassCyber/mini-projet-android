package c.c.a.b.m;

import android.animation.ValueAnimator;
import c.c.a.b.d0.g;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1646a;

    public a(AppBarLayout appBarLayout, g gVar) {
        this.f1646a = gVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1646a.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
