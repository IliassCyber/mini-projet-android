package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import b.b.p.f;
import b.i.m.l;
import c.c.a.a.c.l.q;
import c.c.a.b.d0.g;
import c.c.a.b.d0.n;
import c.c.a.b.j;
import c.c.a.b.k;
import c.c.a.b.y.i;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {
    public static final int[] p = {R.attr.state_checkable};
    public static final int[] q = {R.attr.state_checked};
    public static final int r = j.Widget_MaterialComponents_Button;
    public final c.c.a.b.p.a d;
    public final LinkedHashSet<a> e;
    public b f;
    public PorterDuff.Mode g;
    public ColorStateList h;
    public Drawable i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        int i = c.c.a.b.b.materialButtonStyle;
        super(i.d(context, attributeSet, i, r), attributeSet, i);
        this.e = new LinkedHashSet<>();
        this.m = false;
        this.n = false;
        Context context2 = getContext();
        TypedArray typedArrayE = i.e(context2, attributeSet, k.MaterialButton, i, r, new int[0]);
        this.l = typedArrayE.getDimensionPixelSize(k.MaterialButton_iconPadding, 0);
        this.g = q.M(typedArrayE.getInt(k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.h = q.z(getContext(), typedArrayE, k.MaterialButton_iconTint);
        this.i = q.C(getContext(), typedArrayE, k.MaterialButton_icon);
        this.o = typedArrayE.getInteger(k.MaterialButton_iconGravity, 1);
        this.j = typedArrayE.getDimensionPixelSize(k.MaterialButton_iconSize, 0);
        c.c.a.b.p.a aVar = new c.c.a.b.p.a(this, c.c.a.b.d0.j.b(context2, attributeSet, i, r).a());
        this.d = aVar;
        aVar.f1672c = typedArrayE.getDimensionPixelOffset(k.MaterialButton_android_insetLeft, 0);
        aVar.d = typedArrayE.getDimensionPixelOffset(k.MaterialButton_android_insetRight, 0);
        aVar.e = typedArrayE.getDimensionPixelOffset(k.MaterialButton_android_insetTop, 0);
        aVar.f = typedArrayE.getDimensionPixelOffset(k.MaterialButton_android_insetBottom, 0);
        if (typedArrayE.hasValue(k.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArrayE.getDimensionPixelSize(k.MaterialButton_cornerRadius, -1);
            aVar.g = dimensionPixelSize;
            aVar.e(aVar.f1671b.e(dimensionPixelSize));
            aVar.p = true;
        }
        aVar.h = typedArrayE.getDimensionPixelSize(k.MaterialButton_strokeWidth, 0);
        aVar.i = q.M(typedArrayE.getInt(k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.j = q.z(aVar.f1670a.getContext(), typedArrayE, k.MaterialButton_backgroundTint);
        aVar.k = q.z(aVar.f1670a.getContext(), typedArrayE, k.MaterialButton_strokeColor);
        aVar.l = q.z(aVar.f1670a.getContext(), typedArrayE, k.MaterialButton_rippleColor);
        aVar.q = typedArrayE.getBoolean(k.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArrayE.getDimensionPixelSize(k.MaterialButton_elevation, 0);
        int iV = l.v(aVar.f1670a);
        int paddingTop = aVar.f1670a.getPaddingTop();
        int paddingEnd = aVar.f1670a.getPaddingEnd();
        int paddingBottom = aVar.f1670a.getPaddingBottom();
        MaterialButton materialButton = aVar.f1670a;
        g gVar = new g(aVar.f1671b);
        gVar.o(aVar.f1670a.getContext());
        gVar.setTintList(aVar.j);
        PorterDuff.Mode mode = aVar.i;
        if (mode != null) {
            gVar.setTintMode(mode);
        }
        gVar.t(aVar.h, aVar.k);
        g gVar2 = new g(aVar.f1671b);
        gVar2.setTint(0);
        gVar2.s(aVar.h, aVar.n ? q.y(aVar.f1670a, c.c.a.b.b.colorSurface) : 0);
        g gVar3 = new g(aVar.f1671b);
        aVar.m = gVar3;
        gVar3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(c.c.a.b.b0.a.a(aVar.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), aVar.f1672c, aVar.e, aVar.d, aVar.f), aVar.m);
        aVar.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        g gVarB = aVar.b();
        if (gVarB != null) {
            gVarB.p(dimensionPixelSize2);
        }
        aVar.f1670a.setPaddingRelative(iV + aVar.f1672c, paddingTop + aVar.e, paddingEnd + aVar.d, paddingBottom + aVar.f);
        typedArrayE.recycle();
        setCompoundDrawablePadding(this.l);
        c(this.i != null);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        c.c.a.b.p.a aVar = this.d;
        return aVar != null && aVar.q;
    }

    public final boolean b() {
        c.c.a.b.p.a aVar = this.d;
        return (aVar == null || aVar.o) ? false : true;
    }

    public final void c(boolean z) {
        Drawable drawable = this.i;
        boolean z2 = false;
        if (drawable != null) {
            Drawable drawableMutate = a.a.a.a.a.C0(drawable).mutate();
            this.i = drawableMutate;
            drawableMutate.setTintList(this.h);
            PorterDuff.Mode mode = this.g;
            if (mode != null) {
                this.i.setTintMode(mode);
            }
            int intrinsicWidth = this.j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.i;
            int i = this.k;
            drawable2.setBounds(i, 0, intrinsicWidth + i, intrinsicHeight);
        }
        int i2 = this.o;
        boolean z3 = i2 == 1 || i2 == 2;
        if (z) {
            Drawable drawable3 = this.i;
            if (z3) {
                setCompoundDrawablesRelative(drawable3, null, null, null);
                return;
            } else {
                setCompoundDrawablesRelative(null, null, drawable3, null);
                return;
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable4 = compoundDrawablesRelative[0];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((z3 && drawable4 != this.i) || (!z3 && drawable5 != this.i)) {
            z2 = true;
        }
        if (z2) {
            Drawable drawable6 = this.i;
            if (z3) {
                setCompoundDrawablesRelative(drawable6, null, null, null);
            } else {
                setCompoundDrawablesRelative(null, null, drawable6, null);
            }
        }
    }

    public final void d() {
        if (this.i == null || getLayout() == null) {
            return;
        }
        int i = this.o;
        if (i == 1 || i == 3) {
            this.k = 0;
            c(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.i.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - l.u(this)) - intrinsicWidth) - this.l) - getPaddingStart()) / 2;
        if ((l.r(this) == 1) != (this.o == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.k != measuredWidth) {
            this.k = measuredWidth;
            c(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.d.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.o;
    }

    public int getIconPadding() {
        return this.l;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.g;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.d.l;
        }
        return null;
    }

    public c.c.a.b.d0.j getShapeAppearanceModel() {
        if (b()) {
            return this.d.f1671b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.d.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.d.h;
        }
        return 0;
    }

    @Override // b.b.p.f
    public ColorStateList getSupportBackgroundTintList() {
        return b() ? this.d.j : super.getSupportBackgroundTintList();
    }

    @Override // b.b.p.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return b() ? this.d.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q.Y(this, this.d.b());
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, p);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // b.b.p.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // b.b.p.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // b.b.p.f, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c.c.a.b.p.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.d) == null) {
            return;
        }
        int i5 = i4 - i2;
        int i6 = i3 - i;
        Drawable drawable = aVar.m;
        if (drawable != null) {
            drawable.setBounds(aVar.f1672c, aVar.e, i6 - aVar.d, i5 - aVar.f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }

    @Override // b.b.p.f, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        d();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!b()) {
            super.setBackgroundColor(i);
            return;
        }
        c.c.a.b.p.a aVar = this.d;
        if (aVar.b() != null) {
            aVar.b().setTint(i);
        }
    }

    @Override // b.b.p.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            c.c.a.b.p.a aVar = this.d;
            aVar.o = true;
            aVar.f1670a.setSupportBackgroundTintList(aVar.j);
            aVar.f1670a.setSupportBackgroundTintMode(aVar.i);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // b.b.p.f, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (b()) {
            this.d.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.m != z) {
            this.m = z;
            refreshDrawableState();
            if (this.n) {
                return;
            }
            this.n = true;
            Iterator<a> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.m);
            }
            this.n = false;
        }
    }

    public void setCornerRadius(int i) {
        if (b()) {
            c.c.a.b.p.a aVar = this.d;
            if (aVar.p && aVar.g == i) {
                return;
            }
            aVar.g = i;
            aVar.p = true;
            aVar.e(aVar.f1671b.e(i));
        }
    }

    public void setCornerRadiusResource(int i) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (b()) {
            g gVarB = this.d.b();
            g.b bVar = gVarB.f1555b;
            if (bVar.o != f) {
                bVar.o = f;
                gVarB.x();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            c(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.o != i) {
            this.o = i;
            d();
        }
    }

    public void setIconPadding(int i) {
        if (this.l != i) {
            this.l = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.j != i) {
            this.j = i;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.g != mode) {
            this.g = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(b.b.l.a.a.a(getContext(), i));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            c.c.a.b.p.a aVar = this.d;
            if (aVar.l != colorStateList) {
                aVar.l = colorStateList;
                if (aVar.f1670a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) aVar.f1670a.getBackground()).setColor(c.c.a.b.b0.a.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (b()) {
            setRippleColor(b.b.l.a.a.a(getContext(), i));
        }
    }

    @Override // c.c.a.b.d0.n
    public void setShapeAppearanceModel(c.c.a.b.d0.j jVar) {
        if (!b()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.d.e(jVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (b()) {
            c.c.a.b.p.a aVar = this.d;
            aVar.n = z;
            aVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            c.c.a.b.p.a aVar = this.d;
            if (aVar.k != colorStateList) {
                aVar.k = colorStateList;
                aVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (b()) {
            setStrokeColor(b.b.l.a.a.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (b()) {
            c.c.a.b.p.a aVar = this.d;
            if (aVar.h != i) {
                aVar.h = i;
                aVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // b.b.p.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!b()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        c.c.a.b.p.a aVar = this.d;
        if (aVar.j != colorStateList) {
            aVar.j = colorStateList;
            if (aVar.b() != null) {
                aVar.b().setTintList(aVar.j);
            }
        }
    }

    @Override // b.b.p.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!b()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        c.c.a.b.p.a aVar = this.d;
        if (aVar.i != mode) {
            aVar.i = mode;
            if (aVar.b() == null || aVar.i == null) {
                return;
            }
            aVar.b().setTintMode(aVar.i);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.m);
    }
}
