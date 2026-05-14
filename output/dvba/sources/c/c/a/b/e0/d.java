package c.c.a.b.e0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import b.i.m.l;
import c.c.a.b.k;
import c.c.a.b.y.i;

/* JADX INFO: loaded from: classes.dex */
public class d extends FrameLayout {
    public static final View.OnTouchListener g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f1587c;
    public int d;
    public final float e;
    public final float f;

    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        super(i.d(context, attributeSet, 0, 0), attributeSet);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        if (typedArrayObtainStyledAttributes.hasValue(k.SnackbarLayout_elevation)) {
            l.b0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_elevation, 0));
        }
        this.d = typedArrayObtainStyledAttributes.getInt(k.SnackbarLayout_animationMode, 0);
        this.e = typedArrayObtainStyledAttributes.getFloat(k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        this.f = typedArrayObtainStyledAttributes.getFloat(k.SnackbarLayout_actionTextColorAlpha, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(g);
        setFocusable(true);
    }

    public float getActionTextColorAlpha() {
        return this.f;
    }

    public int getAnimationMode() {
        return this.d;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f1587c;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        l.U(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f1587c;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.f1586b;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    public void setAnimationMode(int i) {
        this.d = i;
    }

    public void setOnAttachStateChangeListener(b bVar) {
        this.f1587c = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : g);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(c cVar) {
        this.f1586b = cVar;
    }
}
