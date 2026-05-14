package c.c.a.b.x;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {
    public h(FloatingActionButton floatingActionButton, c.c.a.b.c0.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // c.c.a.b.x.e
    public float c() {
        return this.t.getElevation();
    }

    @Override // c.c.a.b.x.e
    public void d(Rect rect) {
        if (FloatingActionButton.this.k) {
            super.d(rect);
        } else {
            int sizeDimension = r() ? 0 : (0 - this.t.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // c.c.a.b.x.e
    public void g() {
    }

    @Override // c.c.a.b.x.e
    public void h() {
        t();
    }

    @Override // c.c.a.b.x.e
    public void i(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.t.isEnabled()) {
                this.t.setElevation(this.e);
                if (this.t.isPressed()) {
                    floatingActionButton = this.t;
                    f = this.g;
                } else if (this.t.isFocused() || this.t.isHovered()) {
                    floatingActionButton = this.t;
                    f = this.f;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.t.setElevation(0.0f);
            floatingActionButton = this.t;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // c.c.a.b.x.e
    public void j(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.t.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(e.B, u(f, f3));
            stateListAnimator.addState(e.C, u(f, f2));
            stateListAnimator.addState(e.D, u(f, f2));
            stateListAnimator.addState(e.E, u(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.t, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.t;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.t, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(e.A);
            stateListAnimator.addState(e.F, animatorSet);
            stateListAnimator.addState(e.G, u(0.0f, 0.0f));
            this.t.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            t();
        }
    }

    @Override // c.c.a.b.x.e
    public boolean m() {
        return false;
    }

    @Override // c.c.a.b.x.e
    public void o(ColorStateList colorStateList) {
    }

    @Override // c.c.a.b.x.e
    public boolean p() {
        return FloatingActionButton.this.k || !r();
    }

    @Override // c.c.a.b.x.e
    public void s() {
    }

    public final Animator u(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.t, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.t, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(e.A);
        return animatorSet;
    }
}
