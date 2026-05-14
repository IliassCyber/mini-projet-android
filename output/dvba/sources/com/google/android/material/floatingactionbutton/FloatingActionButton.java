package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.m.l;
import c.c.a.b.d0.n;
import c.c.a.b.k;
import c.c.a.b.l.g;
import c.c.a.b.x.e;
import c.c.a.b.x.h;
import c.c.a.b.y.d;
import c.c.a.b.y.j;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.d(Behavior.class)
public class FloatingActionButton extends j implements c.c.a.b.w.a, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f1996c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final Rect l;
    public e m;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f1997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1998b;

        public BaseBehavior() {
            this.f1998b = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.FloatingActionButton_Behavior_Layout);
            this.f1998b = typedArrayObtainStyledAttributes.getBoolean(k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean B(FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final boolean C(View view, FloatingActionButton floatingActionButton) {
            return this.f1998b && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!C(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f1997a == null) {
                this.f1997a = new Rect();
            }
            Rect rect = this.f1997a;
            d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.n(null, false);
            return true;
        }

        public final boolean E(View view, FloatingActionButton floatingActionButton) {
            if (!C(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.n(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return B((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f128a instanceof BottomSheetBehavior : false) {
                    E(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> listD = coordinatorLayout.d(floatingActionButton);
            int size = listD.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = listD.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f128a instanceof BottomSheetBehavior : false) && E(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.q(floatingActionButton, i);
            return true;
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class b implements c.c.a.b.c0.b {
        public b() {
        }
    }

    public class c<T extends FloatingActionButton> implements e.InterfaceC0066e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.c.a.b.l.j<T> f2000a;

        public c(c.c.a.b.l.j<T> jVar) {
            this.f2000a = jVar;
        }

        @Override // c.c.a.b.x.e.InterfaceC0066e
        public void a() {
            this.f2000a.a(FloatingActionButton.this);
        }

        @Override // c.c.a.b.x.e.InterfaceC0066e
        public void b() {
            this.f2000a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f2000a.equals(this.f2000a);
        }

        public int hashCode() {
            return this.f2000a.hashCode();
        }
    }

    private e getImpl() {
        if (this.m == null) {
            this.m = new h(this, new b());
        }
        return this.m;
    }

    public static int m(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // c.c.a.b.w.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        e impl = getImpl();
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        e impl = getImpl();
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(animatorListener);
    }

    public void f(c.c.a.b.l.j<? extends FloatingActionButton> jVar) {
        e impl = getImpl();
        c cVar = new c(null);
        if (impl.s == null) {
            impl.s = new ArrayList<>();
        }
        impl.s.add(cVar);
    }

    @Deprecated
    public boolean g(Rect rect) {
        if (!l.E(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f1996c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().g;
    }

    public Drawable getContentBackground() {
        if (getImpl() != null) {
            return null;
        }
        throw null;
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public g getHideMotionSpec() {
        return getImpl().m;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public c.c.a.b.d0.j getShapeAppearanceModel() {
        c.c.a.b.d0.j jVar = getImpl().f1732a;
        a.a.a.a.a.g(jVar);
        return jVar;
    }

    public g getShowMotionSpec() {
        return getImpl().l;
    }

    public int getSize() {
        return this.h;
    }

    public int getSizeDimension() {
        return h(this.h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    public final int h(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? c.c.a.b.d.design_fab_size_normal : c.c.a.b.d.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
    }

    public void i(a aVar, boolean z) {
        e impl = getImpl();
        c.c.a.b.x.b bVar = aVar == null ? null : new c.c.a.b.x.b(this, aVar);
        if (impl.e()) {
            return;
        }
        Animator animator = impl.k;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.q()) {
            impl.t.b(z ? 8 : 4, z);
            if (bVar != null) {
                bVar.f1724a.a(bVar.f1725b);
                return;
            }
            return;
        }
        g gVar = impl.m;
        if (gVar == null) {
            if (impl.j == null) {
                impl.j = g.b(impl.t.getContext(), c.c.a.b.a.design_fab_hide_motion_spec);
            }
            gVar = impl.j;
            a.a.a.a.a.g(gVar);
        }
        AnimatorSet animatorSetA = impl.a(gVar, 0.0f, 0.0f, 0.0f);
        animatorSetA.addListener(new c.c.a.b.x.c(impl, z, bVar));
        ArrayList<Animator.AnimatorListener> arrayList = impl.r;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetA.addListener(it.next());
            }
        }
        animatorSetA.start();
    }

    public boolean j() {
        return getImpl().e();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public boolean k() {
        return getImpl().f();
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            a.a.a.a.a.k(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(b.b.p.j.c(colorForState, mode));
    }

    public void n(a aVar, boolean z) {
        e impl = getImpl();
        c.c.a.b.x.b bVar = aVar == null ? null : new c.c.a.b.x.b(this, aVar);
        if (impl.f()) {
            return;
        }
        Animator animator = impl.k;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.q()) {
            impl.t.b(0, z);
            impl.t.setAlpha(1.0f);
            impl.t.setScaleY(1.0f);
            impl.t.setScaleX(1.0f);
            impl.n(1.0f);
            if (bVar != null) {
                bVar.f1724a.b(bVar.f1725b);
                return;
            }
            return;
        }
        if (impl.t.getVisibility() != 0) {
            impl.t.setAlpha(0.0f);
            impl.t.setScaleY(0.0f);
            impl.t.setScaleX(0.0f);
            impl.n(0.0f);
        }
        g gVar = impl.l;
        if (gVar == null) {
            if (impl.i == null) {
                impl.i = g.b(impl.t.getContext(), c.c.a.b.a.design_fab_show_motion_spec);
            }
            gVar = impl.i;
            a.a.a.a.a.g(gVar);
        }
        AnimatorSet animatorSetA = impl.a(gVar, 1.0f, 1.0f, 1.0f);
        animatorSetA.addListener(new c.c.a.b.x.d(impl, z, bVar));
        ArrayList<Animator.AnimatorListener> arrayList = impl.q;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetA.addListener(it.next());
            }
        }
        animatorSetA.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e impl = getImpl();
        if (impl.m()) {
            ViewTreeObserver viewTreeObserver = impl.t.getViewTreeObserver();
            if (impl.z == null) {
                impl.z = new c.c.a.b.x.g(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.z);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.t.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.z;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.z = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension + 0) / 2;
        getImpl().t();
        Math.min(m(sizeDimension, i), m(sizeDimension, i2));
        throw null;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c.c.a.b.f0.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c.c.a.b.f0.a aVar = (c.c.a.b.f0.a) parcelable;
        super.onRestoreInstanceState(aVar.f890b);
        a.a.a.a.a.g(aVar.d.getOrDefault("expandableWidgetHelper", null));
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        b.k.a.a aVar = b.k.a.a.f889c;
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            g(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1996c != colorStateList) {
            this.f1996c = colorStateList;
            if (getImpl() == null) {
                throw null;
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            if (getImpl() == null) {
                throw null;
            }
        }
    }

    public void setCompatElevation(float f) {
        e impl = getImpl();
        if (impl.e != f) {
            impl.e = f;
            impl.j(f, impl.f, impl.g);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        e impl = getImpl();
        if (impl.f != f) {
            impl.f = f;
            impl.j(impl.e, f, impl.g);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        e impl = getImpl();
        if (impl.g != f) {
            impl.g = f;
            impl.j(impl.e, impl.f, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (getImpl() == null) {
            throw null;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f1734c) {
            getImpl().f1734c = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        throw null;
    }

    public void setHideMotionSpec(g gVar) {
        getImpl().m = gVar;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(g.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            e impl = getImpl();
            impl.n(impl.o);
            if (this.e != null) {
                l();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        throw null;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().o(this.g);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().k();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().k();
    }

    public void setShadowPaddingEnabled(boolean z) {
        e impl = getImpl();
        impl.d = z;
        impl.t();
    }

    @Override // c.c.a.b.d0.n
    public void setShapeAppearanceModel(c.c.a.b.d0.j jVar) {
        getImpl().f1732a = jVar;
    }

    public void setShowMotionSpec(g gVar) {
        getImpl().l = gVar;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(g.b(getContext(), i));
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            l();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.k != z) {
            this.k = z;
            getImpl().h();
        }
    }

    @Override // c.c.a.b.y.j, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
