package c.c.a.b.o;

import android.animation.ValueAnimator;
import c.c.a.b.d0.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f1669a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f1669a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        g gVar = this.f1669a.h;
        if (gVar != null) {
            gVar.r(fFloatValue);
        }
    }
}
