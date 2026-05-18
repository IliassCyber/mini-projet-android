package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import b.b.p.g;
import b.i.k.c;
import b.i.k.d;
import b.i.m.l;
import b.i.m.v.b;
import c.c.a.a.c.l.q;
import c.c.a.b.a0.d;
import c.c.a.b.d0.g;
import c.c.a.b.d0.j;
import c.c.a.b.d0.n;
import c.c.a.b.i;
import c.c.a.b.s.b;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends g implements b.a, n {
    public static final Rect u = new Rect();
    public static final int[] v = {R.attr.state_selected};
    public static final int[] w = {R.attr.state_checkable};
    public c.c.a.b.s.b e;
    public InsetDrawable f;
    public RippleDrawable g;
    public View.OnClickListener h;
    public CompoundButton.OnCheckedChangeListener i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public final b q;
    public final Rect r;
    public final RectF s;
    public final d t;

    public class a extends d {
        public a() {
        }

        @Override // c.c.a.b.a0.d
        public void a(int i) {
        }

        @Override // c.c.a.b.a0.d
        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            c.c.a.b.s.b bVar = chip.e;
            chip.setText(bVar.D0 ? bVar.E : chip.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends b.k.b.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // b.k.b.a
        public void m(List<Integer> list) {
            boolean z = false;
            list.add(0);
            if (Chip.this.f()) {
                c.c.a.b.s.b bVar = Chip.this.e;
                if (bVar != null && bVar.K) {
                    z = true;
                }
                if (z) {
                    list.add(1);
                }
            }
        }

        @Override // b.k.b.a
        public boolean p(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.q.s(1, 1);
                }
            }
            return z;
        }

        @Override // b.k.b.a
        public void q(int i, b.i.m.v.b bVar) {
            if (i != 1) {
                bVar.f864a.setContentDescription("");
                bVar.f864a.setBoundsInParent(Chip.u);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i2 = i.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                closeIconContentDescription = context.getString(i2, objArr).trim();
            }
            bVar.f864a.setContentDescription(closeIconContentDescription);
            bVar.f864a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            bVar.a(b.a.e);
            bVar.f864a.setEnabled(Chip.this.isEnabled());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0318  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r12, android.util.AttributeSet r13) {
        /*
            Method dump skipped, instruction units count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (f()) {
            c.c.a.b.s.b bVar = this.e;
            bVar.C(bVar.getBounds(), this.s);
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    private c.c.a.b.a0.b getTextAppearance() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.k0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    @Override // c.c.a.b.s.b.a
    public void a() {
        e(this.p);
        boolean z = c.c.a.b.b0.a.f1545a;
        j();
        k();
        requestLayout();
        invalidateOutline();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchHoverEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            java.lang.Class<b.k.b.a> r0 = b.k.b.a.class
            int r1 = r10.getAction()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 10
            r4 = 0
            r5 = 1
            if (r1 != r3) goto L51
            java.lang.String r1 = "m"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r1.setAccessible(r5)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            com.google.android.material.chip.Chip$b r6 = r9.q     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            int r1 = r1.intValue()     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            if (r1 == r2) goto L51
            java.lang.String r1 = "t"
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r6[r4] = r7     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r6)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r0.setAccessible(r5)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            com.google.android.material.chip.Chip$b r1 = r9.q     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r6[r4] = r7     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r0.invoke(r1, r6)     // Catch: java.lang.NoSuchFieldException -> L43 java.lang.reflect.InvocationTargetException -> L45 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L49
            r0 = 1
            goto L52
        L43:
            r0 = move-exception
            goto L4a
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            goto L4a
        L49:
            r0 = move-exception
        L4a:
            java.lang.String r1 = "Chip"
            java.lang.String r6 = "Unable to send Accessibility Exit event"
            android.util.Log.e(r1, r6, r0)
        L51:
            r0 = 0
        L52:
            if (r0 != 0) goto Lc2
            com.google.android.material.chip.Chip$b r0 = r9.q
            android.view.accessibility.AccessibilityManager r1 = r0.h
            boolean r1 = r1.isEnabled()
            if (r1 == 0) goto Lb9
            android.view.accessibility.AccessibilityManager r1 = r0.h
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L67
            goto Lb9
        L67:
            int r1 = r10.getAction()
            r6 = 7
            r7 = 256(0x100, float:3.59E-43)
            r8 = 128(0x80, float:1.8E-43)
            if (r1 == r6) goto L89
            r6 = 9
            if (r1 == r6) goto L89
            if (r1 == r3) goto L79
            goto Lb9
        L79:
            int r1 = r0.m
            if (r1 == r2) goto Lb9
            if (r1 != r2) goto L80
            goto Lb7
        L80:
            r0.m = r2
            r0.s(r2, r8)
            r0.s(r1, r7)
            goto Lb7
        L89:
            float r1 = r10.getX()
            float r3 = r10.getY()
            com.google.android.material.chip.Chip r6 = com.google.android.material.chip.Chip.this
            boolean r6 = b(r6)
            if (r6 == 0) goto La7
            com.google.android.material.chip.Chip r6 = com.google.android.material.chip.Chip.this
            android.graphics.RectF r6 = c(r6)
            boolean r1 = r6.contains(r1, r3)
            if (r1 == 0) goto La7
            r1 = 1
            goto La8
        La7:
            r1 = 0
        La8:
            int r3 = r0.m
            if (r3 != r1) goto Lad
            goto Lb5
        Lad:
            r0.m = r1
            r0.s(r1, r8)
            r0.s(r3, r7)
        Lb5:
            if (r1 == r2) goto Lb9
        Lb7:
            r0 = 1
            goto Lba
        Lb9:
            r0 = 0
        Lba:
            if (r0 != 0) goto Lc2
            boolean r10 = super.dispatchHoverEvent(r10)
            if (r10 == 0) goto Lc3
        Lc2:
            r4 = 1
        Lc3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            com.google.android.material.chip.Chip$b r0 = r9.q
            r1 = 0
            if (r0 == 0) goto L88
            int r2 = r10.getAction()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            r5 = 1
            if (r2 == r5) goto L7a
            int r2 = r10.getKeyCode()
            r6 = 61
            if (r2 == r6) goto L64
            r6 = 66
            if (r2 == r6) goto L4d
            switch(r2) {
                case 19: goto L1f;
                case 20: goto L1f;
                case 21: goto L1f;
                case 22: goto L1f;
                case 23: goto L4d;
                default: goto L1e;
            }
        L1e:
            goto L7a
        L1f:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L7a
            r7 = 19
            if (r2 == r7) goto L37
            r7 = 21
            if (r2 == r7) goto L34
            r7 = 22
            if (r2 == r7) goto L39
            r6 = 130(0x82, float:1.82E-43)
            goto L39
        L34:
            r6 = 17
            goto L39
        L37:
            r6 = 33
        L39:
            int r2 = r10.getRepeatCount()
            int r2 = r2 + r5
            r7 = 0
        L3f:
            if (r4 >= r2) goto L4b
            boolean r8 = r0.n(r6, r1)
            if (r8 == 0) goto L4b
            int r4 = r4 + 1
            r7 = 1
            goto L3f
        L4b:
            r4 = r7
            goto L7a
        L4d:
            boolean r2 = r10.hasNoModifiers()
            if (r2 == 0) goto L7a
            int r2 = r10.getRepeatCount()
            if (r2 != 0) goto L7a
            int r2 = r0.l
            if (r2 == r3) goto L62
            r4 = 16
            r0.p(r2, r4, r1)
        L62:
            r4 = 1
            goto L7a
        L64:
            boolean r2 = r10.hasNoModifiers()
            if (r2 == 0) goto L70
            r2 = 2
            boolean r4 = r0.n(r2, r1)
            goto L7a
        L70:
            boolean r2 = r10.hasModifiers(r5)
            if (r2 == 0) goto L7a
            boolean r4 = r0.n(r5, r1)
        L7a:
            if (r4 == 0) goto L83
            com.google.android.material.chip.Chip$b r0 = r9.q
            int r0 = r0.l
            if (r0 == r3) goto L83
            return r5
        L83:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L88:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // b.b.p.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c.c.a.b.s.b bVar = this.e;
        boolean zC0 = false;
        int i = 0;
        zC0 = false;
        if (bVar != null && c.c.a.b.s.b.H(bVar.L)) {
            c.c.a.b.s.b bVar2 = this.e;
            ?? IsEnabled = isEnabled();
            int i2 = IsEnabled;
            if (this.m) {
                i2 = IsEnabled + 1;
            }
            int i3 = i2;
            if (this.l) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.k) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.m) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.l) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.k) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            zC0 = bVar2.c0(iArr);
        }
        if (zC0) {
            invalidate();
        }
    }

    public boolean e(int i) {
        this.p = i;
        if (!this.n) {
            h();
            return false;
        }
        int iMax = Math.max(0, i - ((int) this.e.z));
        int iMax2 = Math.max(0, i - this.e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            h();
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.f != null) {
            Rect rect = new Rect();
            this.f.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.f = new InsetDrawable((Drawable) this.e, i2, i3, i2, i3);
        return true;
    }

    public final boolean f() {
        c.c.a.b.s.b bVar = this.e;
        return (bVar == null || bVar.F() == null) ? false : true;
    }

    public boolean g() {
        c.c.a.b.s.b bVar = this.e;
        return bVar != null && bVar.Q;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f;
        return insetDrawable == null ? this.e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.S;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.y;
        }
        return null;
    }

    public float getChipCornerRadius() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.E();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.e;
    }

    public float getChipEndPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || (drawable = bVar.G) == 0) {
            return null;
        }
        return drawable instanceof b.i.f.k.b ? ((b.i.f.k.b) drawable).a() : drawable;
    }

    public float getChipIconSize() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.I;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.H;
        }
        return null;
    }

    public float getChipMinHeight() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.z;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.V;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.B;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.C;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.F();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.P;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.O;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.N;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.C0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        b bVar = this.q;
        if (bVar.l == 1 || bVar.k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public c.c.a.b.l.g getHideMotionSpec() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.U;
        }
        return null;
    }

    public float getIconEndPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.X;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.W;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.D;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.e.f1555b.f1558a;
    }

    public c.c.a.b.l.g getShowMotionSpec() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.T;
        }
        return null;
    }

    public float getTextEndPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            return bVar.Y;
        }
        return 0.0f;
    }

    public final void h() {
        if (this.f != null) {
            this.f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            boolean z = c.c.a.b.b0.a.f1545a;
            j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L7
            return
        L7:
            boolean r0 = r2.f()
            if (r0 == 0) goto L1d
            c.c.a.b.s.b r0 = r2.e
            if (r0 == 0) goto L17
            boolean r0 = r0.K
            if (r0 == 0) goto L17
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            if (r0 == 0) goto L1d
            com.google.android.material.chip.Chip$b r0 = r2.q
            goto L1e
        L1d:
            r0 = 0
        L1e:
            b.i.m.l.W(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.i():void");
    }

    public final void j() {
        this.g = new RippleDrawable(c.c.a.b.b0.a.a(this.e.D), getBackgroundDrawable(), null);
        this.e.m0(false);
        l.Z(this, this.g);
    }

    public final void k() {
        c.c.a.b.s.b bVar;
        if (TextUtils.isEmpty(getText()) || (bVar = this.e) == null) {
            return;
        }
        int iD = (int) (bVar.D() + bVar.c0 + bVar.Z);
        c.c.a.b.s.b bVar2 = this.e;
        l.f0(this, (int) (bVar2.A() + bVar2.V + bVar2.Y), getPaddingTop(), iD, getPaddingBottom());
    }

    public final void l() {
        TextPaint paint = getPaint();
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        c.c.a.b.a0.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q.Y(this, this.e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, v);
        }
        if (g()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, w);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        b bVar = this.q;
        int i2 = bVar.l;
        if (i2 != Integer.MIN_VALUE) {
            bVar.k(i2);
        }
        if (z) {
            bVar.n(i, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean zContains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                zContains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(zContains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((g() || isClickable()) ? g() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.o != i) {
            this.o = i;
            k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L45
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L40
            goto L4c
        L21:
            boolean r0 = r5.k
            if (r0 == 0) goto L4c
            if (r1 != 0) goto L4a
            r5.setCloseIconPressed(r2)
            goto L4a
        L2b:
            boolean r0 = r5.k
            if (r0 == 0) goto L40
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.h
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            com.google.android.material.chip.Chip$b r0 = r5.q
            r0.s(r3, r3)
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            r5.setCloseIconPressed(r2)
            goto L4d
        L45:
            if (r1 == 0) goto L4c
            r5.setCloseIconPressed(r3)
        L4a:
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 != 0) goto L55
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L56
        L55:
            r2 = 1
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // b.b.p.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // b.b.p.g, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.K(z);
        }
    }

    public void setCheckableResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.K(bVar.d0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null) {
            this.j = z;
            return;
        }
        if (bVar.Q) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.L(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.L(b.b.l.a.a.b(bVar.d0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.M(bVar.d0.getResources().getBoolean(i));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.M(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.y == colorStateList) {
            return;
        }
        bVar.y = colorStateList;
        bVar.onStateChange(bVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.N(b.b.l.a.a.a(bVar.d0, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.O(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.O(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(c.c.a.b.s.b bVar) {
        c.c.a.b.s.b bVar2 = this.e;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.B0 = new WeakReference<>(null);
            }
            this.e = bVar;
            bVar.D0 = false;
            if (bVar == null) {
                throw null;
            }
            bVar.B0 = new WeakReference<>(this);
            e(this.p);
            boolean z = c.c.a.b.b0.a.f1545a;
            j();
        }
    }

    public void setChipEndPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.c0 == f) {
            return;
        }
        bVar.c0 = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipEndPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.P(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setChipIcon(Drawable drawable) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Q(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Q(b.b.l.a.a.b(bVar.d0, i));
        }
    }

    public void setChipIconSize(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.R(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.R(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.S(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.S(b.b.l.a.a.a(bVar.d0, i));
        }
    }

    public void setChipIconVisible(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.T(bVar.d0.getResources().getBoolean(i));
        }
    }

    public void setChipIconVisible(boolean z) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.T(z);
        }
    }

    public void setChipMinHeight(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.z == f) {
            return;
        }
        bVar.z = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipMinHeightResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.U(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.V == f) {
            return;
        }
        bVar.V = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipStartPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.V(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.W(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.W(b.b.l.a.a.a(bVar.d0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.X(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.X(bVar.d0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Y(drawable);
        }
        i();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder;
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.P == charSequence) {
            return;
        }
        b.i.k.a aVarC = b.i.k.a.c();
        c cVar = aVarC.f798c;
        if (charSequence == null) {
            spannableStringBuilder = null;
        } else {
            boolean zB = ((d.c) cVar).b(charSequence, 0, charSequence.length());
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            String str = "";
            if ((aVarC.f797b & 2) != 0) {
                boolean zB2 = ((d.c) (zB ? b.i.k.d.f806b : b.i.k.d.f805a)).b(charSequence, 0, charSequence.length());
                spannableStringBuilder2.append((CharSequence) ((aVarC.f796a || !(zB2 || b.i.k.a.a(charSequence) == 1)) ? (!aVarC.f796a || (zB2 && b.i.k.a.a(charSequence) != -1)) ? "" : b.i.k.a.f : b.i.k.a.e));
            }
            if (zB != aVarC.f796a) {
                spannableStringBuilder2.append(zB ? (char) 8235 : (char) 8234);
                spannableStringBuilder2.append(charSequence);
                spannableStringBuilder2.append((char) 8236);
            } else {
                spannableStringBuilder2.append(charSequence);
            }
            boolean zB3 = ((d.c) (zB ? b.i.k.d.f806b : b.i.k.d.f805a)).b(charSequence, 0, charSequence.length());
            if (!aVarC.f796a && (zB3 || b.i.k.a.b(charSequence) == 1)) {
                str = b.i.k.a.e;
            } else if (aVarC.f796a && (!zB3 || b.i.k.a.b(charSequence) == -1)) {
                str = b.i.k.a.f;
            }
            spannableStringBuilder2.append((CharSequence) str);
            spannableStringBuilder = spannableStringBuilder2;
        }
        bVar.P = spannableStringBuilder;
        bVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Z(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Z(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.Y(b.b.l.a.a.b(bVar.d0, i));
        }
        i();
    }

    public void setCloseIconSize(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.a0(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.a0(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.b0(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.b0(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.d0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.d0(b.b.l.a.a.a(bVar.d0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.e0(z);
        }
        i();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            g.b bVar2 = bVar.f1555b;
            if (bVar2.o != f) {
                bVar2.o = f;
                bVar.x();
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.C0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        e(this.p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(c.c.a.b.l.g gVar) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.U = gVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.U = c.c.a.b.l.g.b(bVar.d0, i);
        }
    }

    public void setIconEndPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.f0(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.f0(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.g0(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.g0(bVar.d0.getResources().getDimension(i));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.e == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.E0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.h0(colorStateList);
        }
        if (this.e.z0) {
            return;
        }
        j();
    }

    public void setRippleColorResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.h0(b.b.l.a.a.a(bVar.d0, i));
            if (this.e.z0) {
                return;
            }
            j();
        }
    }

    @Override // c.c.a.b.d0.n
    public void setShapeAppearanceModel(j jVar) {
        c.c.a.b.s.b bVar = this.e;
        bVar.f1555b.f1558a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(c.c.a.b.l.g gVar) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.T = gVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.T = c.c.a.b.l.g.b(bVar.d0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.e == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.e.D0 ? null : charSequence, bufferType);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.i0(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.j0(new c.c.a.b.a0.b(bVar.d0, i));
        }
        l();
    }

    public void setTextAppearance(c.c.a.b.a0.b bVar) {
        c.c.a.b.s.b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.j0(bVar);
        }
        l();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.Z == f) {
            return;
        }
        bVar.Z = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setTextEndPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.k0(bVar.d0.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar == null || bVar.Y == f) {
            return;
        }
        bVar.Y = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setTextStartPaddingResource(int i) {
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.l0(bVar.d0.getResources().getDimension(i));
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        c.c.a.b.s.b bVar = this.e;
        if (bVar != null) {
            bVar.j0(new c.c.a.b.a0.b(bVar.d0, i));
        }
        l();
    }
}
