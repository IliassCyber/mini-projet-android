package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.m.l;
import c.c.a.b.n.b;
import c.c.a.b.n.c;
import c.c.a.b.n.d;
import c.c.a.b.n.e;
import c.c.a.b.n.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public Animator O;
    public Animator P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public boolean U;
    public Behavior V;
    public AnimatorListenerAdapter W;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect e;
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.f.get() == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                } else {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    Behavior.this.e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                    throw null;
                }
            }
        }

        public Behavior() {
            this.h = new a();
            this.e = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = new a();
            this.e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f = new WeakReference<>(bottomAppBar);
            View viewC = bottomAppBar.C();
            if (viewC == null || l.E(viewC)) {
                coordinatorLayout.q(bottomAppBar, i);
                this.f1965a = bottomAppBar.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar.getLayoutParams()).bottomMargin;
                return false;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewC.getLayoutParams();
            fVar.d = 49;
            this.g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (viewC instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) viewC;
                floatingActionButton.addOnLayoutChangeListener(this.h);
                floatingActionButton.d(null);
                floatingActionButton.e(new e(bottomAppBar));
                floatingActionButton.f(null);
            }
            bottomAppBar.G();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            if (bottomAppBar.getHideOnScroll()) {
                return i2 == 0 ? w(coordinatorLayout, bottomAppBar, view2, view3, i) : false;
            }
            return false;
        }
    }

    public static class a extends b.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0069a();
        public int d;
        public boolean e;

        /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a, reason: collision with other inner class name */
        public static class C0069a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new a[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt() != 0;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f890b, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return E(this.Q);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().d;
    }

    private f getTopEdgeTreatment() {
        throw null;
    }

    public static void v(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX(bottomAppBar.D(actionMenuView, i, z));
    }

    public static void y(BottomAppBar bottomAppBar) {
        bottomAppBar.T--;
    }

    public void A(int i) {
        FloatingActionButton floatingActionButtonB = B();
        if (floatingActionButtonB == null || floatingActionButtonB.j()) {
            return;
        }
        this.T++;
        floatingActionButtonB.i(new b(this, i), true);
    }

    public final FloatingActionButton B() {
        View viewC = C();
        if (viewC instanceof FloatingActionButton) {
            return (FloatingActionButton) viewC;
        }
        return null;
    }

    public final View C() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).e(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int D(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = l.r(this) == 1;
        int measuredWidth = z2 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f241a & 8388615) == 8388611) {
                measuredWidth = z2 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = measuredWidth - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft());
        if (i == 1 && z) {
            return right;
        }
        return 0;
    }

    public final float E(int i) {
        boolean z = l.r(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - 0) * (z ? -1 : 1);
        }
        return 0.0f;
    }

    public final boolean F() {
        FloatingActionButton floatingActionButtonB = B();
        return floatingActionButtonB != null && floatingActionButtonB.k();
    }

    public final void G() {
        getTopEdgeTreatment().e = getFabTranslationX();
        C();
        if (this.U) {
            F();
        }
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.V == null) {
            this.V = new Behavior();
        }
        return this.V;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d;
    }

    public int getFabAlignmentMode() {
        return this.Q;
    }

    public int getFabAnimationMode() {
        return this.R;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f1668c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f1667b;
    }

    public boolean getHideOnScroll() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z) {
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                actionMenuView.setAlpha(1.0f);
                actionMenuView.setTranslationX(!F() ? D(actionMenuView, 0, false) : D(actionMenuView, this.Q, this.U));
                return;
            }
            return;
        }
        Animator animator = this.P;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.O;
        if (animator2 != null) {
            animator2.cancel();
        }
        G();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f890b);
        this.Q = aVar.d;
        this.U = aVar.e;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.d = this.Q;
        aVar.e = this.U;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f) {
        if (f == getCradleVerticalOffset()) {
            return;
        }
        getTopEdgeTreatment().d = f;
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        if (this.Q != i && l.E(this)) {
            Animator animator = this.O;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.R == 1) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(B(), "translationX", E(i));
                objectAnimatorOfFloat.setDuration(300L);
                arrayList.add(objectAnimatorOfFloat);
            } else {
                A(i);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.O = animatorSet;
            animatorSet.addListener(new c.c.a.b.n.a(this));
            this.O.start();
        }
        boolean z = this.U;
        if (l.E(this)) {
            Animator animator2 = this.P;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (F()) {
                i2 = i;
            } else {
                z = false;
                i2 = 0;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - D(actionMenuView, i2, z)) > 1.0f) {
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    objectAnimatorOfFloat3.addListener(new d(this, actionMenuView, i2, z));
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.setDuration(150L);
                    animatorSet2.playSequentially(objectAnimatorOfFloat3, objectAnimatorOfFloat2);
                    arrayList2.add(animatorSet2);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList2.add(objectAnimatorOfFloat2);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.P = animatorSet3;
            animatorSet3.addListener(new c(this));
            this.P.start();
        }
        this.Q = i;
    }

    public void setFabAnimationMode(int i) {
        this.R = i;
    }

    public void setFabCradleMargin(float f) {
        if (f == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().f1668c = f;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().f1667b = f;
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.S = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
