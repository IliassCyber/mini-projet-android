package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.p.e0;
import b.b.p.x0;
import b.b.p.z;
import b.i.m.l;
import c.c.a.a.c.l.q;
import c.c.a.b.d0.j;
import c.c.a.b.g0.n;
import c.c.a.b.g0.o;
import c.c.a.b.g0.p;
import c.c.a.b.j;
import c.c.a.b.k;
import c.c.a.b.y.i;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int s0 = j.Widget_Design_TextInputLayout;
    public int A;
    public int B;
    public final Rect C;
    public final Rect D;
    public final RectF E;
    public Typeface F;
    public final CheckableImageButton G;
    public ColorStateList H;
    public boolean I;
    public PorterDuff.Mode J;
    public boolean K;
    public Drawable L;
    public View.OnLongClickListener M;
    public final LinkedHashSet<f> N;
    public int O;
    public final SparseArray<n> P;
    public final CheckableImageButton Q;
    public final LinkedHashSet<g> R;
    public ColorStateList S;
    public boolean T;
    public PorterDuff.Mode U;
    public boolean V;
    public Drawable W;
    public Drawable a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f2005b;
    public final CheckableImageButton b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f2006c;
    public View.OnLongClickListener c0;
    public EditText d;
    public ColorStateList d0;
    public CharSequence e;
    public ColorStateList e0;
    public final o f;
    public final int f0;
    public boolean g;
    public final int g0;
    public int h;
    public int h0;
    public boolean i;
    public int i0;
    public TextView j;
    public final int j0;
    public int k;
    public final int k0;
    public int l;
    public final int l0;
    public ColorStateList m;
    public boolean m0;
    public ColorStateList n;
    public final c.c.a.b.y.c n0;
    public boolean o;
    public boolean o0;
    public CharSequence p;
    public ValueAnimator p0;
    public boolean q;
    public boolean q0;
    public c.c.a.b.d0.g r;
    public boolean r0;
    public c.c.a.b.d0.g s;
    public c.c.a.b.d0.j t;
    public final int u;
    public int v;
    public final int w;
    public int x;
    public final int y;
    public final int z;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.v(!r0.r0, false);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.g) {
                textInputLayout.q(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.Q.performClick();
            TextInputLayout.this.Q.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.d.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.n0.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends b.i.m.a {
        public final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        @Override // b.i.m.a
        public void d(View view, b.i.m.v.b bVar) {
            this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
            EditText editText = this.d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence error = this.d.getError();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                bVar.f864a.setText(text);
            } else if (z2) {
                bVar.f864a.setText(hint);
            }
            if (z2) {
                bVar.k(hint);
                if (!z && z2) {
                    z4 = true;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    bVar.f864a.setShowingHintText(z4);
                } else {
                    bVar.h(4, z4);
                }
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                bVar.f864a.setError(error);
                bVar.f864a.setContentInvalid(true);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public static class h extends b.k.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public CharSequence d;
        public boolean e;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.e = parcel.readInt() == 1;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sbE = c.a.a.a.a.e("TextInputLayout.SavedState{");
            sbE.append(Integer.toHexString(System.identityHashCode(this)));
            sbE.append(" error=");
            sbE.append((Object) this.d);
            sbE.append("}");
            return sbE.toString();
        }

        @Override // b.k.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f890b, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeInt(this.e ? 1 : 0);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int colorForState;
        int i = c.c.a.b.b.textInputStyle;
        super(i.d(context, attributeSet, i, s0), attributeSet, i);
        this.f = new o(this);
        this.C = new Rect();
        this.D = new Rect();
        this.E = new RectF();
        this.N = new LinkedHashSet<>();
        this.O = 0;
        this.P = new SparseArray<>();
        this.R = new LinkedHashSet<>();
        this.n0 = new c.c.a.b.y.c(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2005b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f2005b);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f2006c = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 8388629));
        this.f2005b.addView(this.f2006c);
        c.c.a.b.y.c cVar = this.n0;
        cVar.L = c.c.a.b.l.a.f1627a;
        cVar.k();
        c.c.a.b.y.c cVar2 = this.n0;
        cVar2.K = c.c.a.b.l.a.f1627a;
        cVar2.k();
        c.c.a.b.y.c cVar3 = this.n0;
        if (cVar3.h != 8388659) {
            cVar3.h = 8388659;
            cVar3.k();
        }
        int[] iArr = k.TextInputLayout;
        int i2 = s0;
        int[] iArr2 = {k.TextInputLayout_counterTextAppearance, k.TextInputLayout_counterOverflowTextAppearance, k.TextInputLayout_errorTextAppearance, k.TextInputLayout_helperTextTextAppearance, k.TextInputLayout_hintTextAppearance};
        i.a(context2, attributeSet, i, i2);
        i.b(context2, attributeSet, iArr, i, i2, iArr2);
        x0 x0Var = new x0(context2, context2.obtainStyledAttributes(attributeSet, iArr, i, i2));
        this.o = x0Var.a(k.TextInputLayout_hintEnabled, true);
        setHint(x0Var.n(k.TextInputLayout_android_hint));
        this.o0 = x0Var.a(k.TextInputLayout_hintAnimationEnabled, true);
        this.t = c.c.a.b.d0.j.b(context2, attributeSet, i, s0).a();
        this.u = context2.getResources().getDimensionPixelOffset(c.c.a.b.d.mtrl_textinput_box_label_cutout_padding);
        this.w = x0Var.e(k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.y = x0Var.f(k.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(c.c.a.b.d.mtrl_textinput_box_stroke_width_default));
        this.z = x0Var.f(k.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(c.c.a.b.d.mtrl_textinput_box_stroke_width_focused));
        this.x = this.y;
        float fD = x0Var.d(k.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = x0Var.d(k.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = x0Var.d(k.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = x0Var.d(k.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        c.c.a.b.d0.j jVar = this.t;
        if (jVar == null) {
            throw null;
        }
        j.b bVar = new j.b(jVar);
        if (fD >= 0.0f) {
            bVar.e(fD);
        }
        if (fD2 >= 0.0f) {
            bVar.f(fD2);
        }
        if (fD3 >= 0.0f) {
            bVar.d(fD3);
        }
        if (fD4 >= 0.0f) {
            bVar.c(fD4);
        }
        this.t = bVar.a();
        ColorStateList colorStateListA = q.A(context2, x0Var, k.TextInputLayout_boxBackgroundColor);
        if (colorStateListA != null) {
            int defaultColor = colorStateListA.getDefaultColor();
            this.i0 = defaultColor;
            this.B = defaultColor;
            if (colorStateListA.isStateful()) {
                this.j0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            } else {
                ColorStateList colorStateListA2 = b.b.l.a.a.a(context2, c.c.a.b.c.mtrl_filled_background_color);
                this.j0 = colorStateListA2.getColorForState(new int[]{-16842910}, -1);
                colorForState = colorStateListA2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
            this.k0 = colorForState;
        } else {
            this.B = 0;
            this.i0 = 0;
            this.j0 = 0;
            this.k0 = 0;
        }
        if (x0Var.o(k.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListC = x0Var.c(k.TextInputLayout_android_textColorHint);
            this.e0 = colorStateListC;
            this.d0 = colorStateListC;
        }
        ColorStateList colorStateListA3 = q.A(context2, x0Var, k.TextInputLayout_boxStrokeColor);
        if (colorStateListA3 == null || !colorStateListA3.isStateful()) {
            this.h0 = x0Var.b(k.TextInputLayout_boxStrokeColor, 0);
            this.f0 = b.i.e.a.a(context2, c.c.a.b.c.mtrl_textinput_default_box_stroke_color);
            this.l0 = b.i.e.a.a(context2, c.c.a.b.c.mtrl_textinput_disabled_color);
            this.g0 = b.i.e.a.a(context2, c.c.a.b.c.mtrl_textinput_hovered_box_stroke_color);
        } else {
            this.f0 = colorStateListA3.getDefaultColor();
            this.l0 = colorStateListA3.getColorForState(new int[]{-16842910}, -1);
            this.g0 = colorStateListA3.getColorForState(new int[]{R.attr.state_hovered}, -1);
            this.h0 = colorStateListA3.getColorForState(new int[]{R.attr.state_focused}, -1);
        }
        if (x0Var.l(k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(x0Var.l(k.TextInputLayout_hintTextAppearance, 0));
        }
        int iL = x0Var.l(k.TextInputLayout_errorTextAppearance, 0);
        boolean zA = x0Var.a(k.TextInputLayout_errorEnabled, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.c.a.b.h.design_text_input_end_icon, (ViewGroup) this.f2005b, false);
        this.b0 = checkableImageButton;
        this.f2005b.addView(checkableImageButton);
        this.b0.setVisibility(8);
        if (x0Var.o(k.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(x0Var.g(k.TextInputLayout_errorIconDrawable));
        }
        if (x0Var.o(k.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(q.A(context2, x0Var, k.TextInputLayout_errorIconTint));
        }
        if (x0Var.o(k.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(q.M(x0Var.j(k.TextInputLayout_errorIconTintMode, -1), null));
        }
        this.b0.setContentDescription(getResources().getText(c.c.a.b.i.error_icon_content_description));
        l.d0(this.b0, 2);
        this.b0.setClickable(false);
        this.b0.setPressable(false);
        this.b0.setFocusable(false);
        int iL2 = x0Var.l(k.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = x0Var.a(k.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceN = x0Var.n(k.TextInputLayout_helperText);
        boolean zA3 = x0Var.a(k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(x0Var.j(k.TextInputLayout_counterMaxLength, -1));
        this.l = x0Var.l(k.TextInputLayout_counterTextAppearance, 0);
        this.k = x0Var.l(k.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.c.a.b.h.design_text_input_start_icon, (ViewGroup) this.f2005b, false);
        this.G = checkableImageButton2;
        this.f2005b.addView(checkableImageButton2);
        this.G.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (x0Var.o(k.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(x0Var.g(k.TextInputLayout_startIconDrawable));
            if (x0Var.o(k.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(x0Var.n(k.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(x0Var.a(k.TextInputLayout_startIconCheckable, true));
        }
        if (x0Var.o(k.TextInputLayout_startIconTint)) {
            setStartIconTintList(q.A(context2, x0Var, k.TextInputLayout_startIconTint));
        }
        if (x0Var.o(k.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(q.M(x0Var.j(k.TextInputLayout_startIconTintMode, -1), null));
        }
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceN);
        setHelperTextTextAppearance(iL2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iL);
        setCounterTextAppearance(this.l);
        setCounterOverflowTextAppearance(this.k);
        if (x0Var.o(k.TextInputLayout_errorTextColor)) {
            setErrorTextColor(x0Var.c(k.TextInputLayout_errorTextColor));
        }
        if (x0Var.o(k.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(x0Var.c(k.TextInputLayout_helperTextTextColor));
        }
        if (x0Var.o(k.TextInputLayout_hintTextColor)) {
            setHintTextColor(x0Var.c(k.TextInputLayout_hintTextColor));
        }
        if (x0Var.o(k.TextInputLayout_counterTextColor)) {
            setCounterTextColor(x0Var.c(k.TextInputLayout_counterTextColor));
        }
        if (x0Var.o(k.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(x0Var.c(k.TextInputLayout_counterOverflowTextColor));
        }
        setCounterEnabled(zA3);
        setBoxBackgroundMode(x0Var.j(k.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.c.a.b.h.design_text_input_end_icon, (ViewGroup) this.f2006c, false);
        this.Q = checkableImageButton3;
        this.f2006c.addView(checkableImageButton3);
        this.Q.setVisibility(8);
        this.P.append(-1, new c.c.a.b.g0.f(this));
        this.P.append(0, new p(this));
        this.P.append(1, new c.c.a.b.g0.q(this));
        this.P.append(2, new c.c.a.b.g0.a(this));
        this.P.append(3, new c.c.a.b.g0.h(this));
        if (x0Var.o(k.TextInputLayout_endIconMode)) {
            setEndIconMode(x0Var.j(k.TextInputLayout_endIconMode, 0));
            if (x0Var.o(k.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(x0Var.g(k.TextInputLayout_endIconDrawable));
            }
            if (x0Var.o(k.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(x0Var.n(k.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(x0Var.a(k.TextInputLayout_endIconCheckable, true));
        } else if (x0Var.o(k.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(x0Var.a(k.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(x0Var.g(k.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(x0Var.n(k.TextInputLayout_passwordToggleContentDescription));
            if (x0Var.o(k.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(q.A(context2, x0Var, k.TextInputLayout_passwordToggleTint));
            }
            if (x0Var.o(k.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(q.M(x0Var.j(k.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!x0Var.o(k.TextInputLayout_passwordToggleEnabled)) {
            if (x0Var.o(k.TextInputLayout_endIconTint)) {
                setEndIconTintList(q.A(context2, x0Var, k.TextInputLayout_endIconTint));
            }
            if (x0Var.o(k.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(q.M(x0Var.j(k.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        x0Var.f507b.recycle();
        setImportantForAccessibility(2);
    }

    private n getEndIconDelegate() {
        n nVar = this.P.get(this.O);
        return nVar != null ? nVar : this.P.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.b0.getVisibility() == 0) {
            return this.b0;
        }
        if (i() && j()) {
            return this.Q;
        }
        return null;
    }

    public static void m(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    public static void n(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zA = l.A(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zA || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zA);
        checkableImageButton.setPressable(zA);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        if (this.d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.O != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.d = editText;
        k();
        setTextInputAccessibilityDelegate(new e(this));
        this.n0.p(this.d.getTypeface());
        c.c.a.b.y.c cVar = this.n0;
        float textSize = this.d.getTextSize();
        if (cVar.i != textSize) {
            cVar.i = textSize;
            cVar.k();
        }
        int gravity = this.d.getGravity();
        c.c.a.b.y.c cVar2 = this.n0;
        int i = (gravity & (-113)) | 48;
        if (cVar2.h != i) {
            cVar2.h = i;
            cVar2.k();
        }
        c.c.a.b.y.c cVar3 = this.n0;
        if (cVar3.g != gravity) {
            cVar3.g = gravity;
            cVar3.k();
        }
        this.d.addTextChangedListener(new a());
        if (this.d0 == null) {
            this.d0 = this.d.getHintTextColors();
        }
        if (this.o) {
            if (TextUtils.isEmpty(this.p)) {
                CharSequence hint = this.d.getHint();
                this.e = hint;
                setHint(hint);
                this.d.setHint((CharSequence) null);
            }
            this.q = true;
        }
        if (this.j != null) {
            q(this.d.getText().length());
        }
        s();
        this.f.b();
        this.G.bringToFront();
        this.f2006c.bringToFront();
        this.b0.bringToFront();
        Iterator<f> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        v(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.b0.setVisibility(z ? 0 : 8);
        this.f2006c.setVisibility(z ? 8 : 0);
        if (i()) {
            return;
        }
        t();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.p)) {
            return;
        }
        this.p = charSequence;
        c.c.a.b.y.c cVar = this.n0;
        if (charSequence == null || !TextUtils.equals(cVar.w, charSequence)) {
            cVar.w = charSequence;
            cVar.x = null;
            Bitmap bitmap = cVar.A;
            if (bitmap != null) {
                bitmap.recycle();
                cVar.A = null;
            }
            cVar.k();
        }
        if (this.m0) {
            return;
        }
        l();
    }

    public void a(f fVar) {
        this.N.add(fVar);
        if (this.d != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f2005b.addView(view, layoutParams2);
        this.f2005b.setLayoutParams(layoutParams);
        u();
        setEditText((EditText) view);
    }

    public void b(float f2) {
        if (this.n0.f1743c == f2) {
            return;
        }
        if (this.p0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.p0 = valueAnimator;
            valueAnimator.setInterpolator(c.c.a.b.l.a.f1628b);
            this.p0.setDuration(167L);
            this.p0.addUpdateListener(new d());
        }
        this.p0.setFloatValues(this.n0.f1743c, f2);
        this.p0.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r6 = this;
            c.c.a.b.d0.g r0 = r6.r
            if (r0 != 0) goto L5
            return
        L5:
            c.c.a.b.d0.j r1 = r6.t
            r0.setShapeAppearanceModel(r1)
            int r0 = r6.v
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L21
            int r0 = r6.x
            if (r0 <= r2) goto L1c
            int r0 = r6.A
            if (r0 == 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L2e
            c.c.a.b.d0.g r0 = r6.r
            int r1 = r6.x
            float r1 = (float) r1
            int r5 = r6.A
            r0.s(r1, r5)
        L2e:
            int r0 = r6.B
            int r1 = r6.v
            if (r1 != r4) goto L44
            int r0 = c.c.a.b.b.colorSurface
            android.content.Context r1 = r6.getContext()
            int r0 = c.c.a.a.c.l.q.x(r1, r0, r3)
            int r1 = r6.B
            int r0 = b.i.f.a.a(r1, r0)
        L44:
            r6.B = r0
            c.c.a.b.d0.g r1 = r6.r
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.q(r0)
            int r0 = r6.O
            r1 = 3
            if (r0 != r1) goto L5d
            android.widget.EditText r0 = r6.d
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            r0.invalidateSelf()
        L5d:
            c.c.a.b.d0.g r0 = r6.s
            if (r0 != 0) goto L62
            goto L7b
        L62:
            int r0 = r6.x
            if (r0 <= r2) goto L6b
            int r0 = r6.A
            if (r0 == 0) goto L6b
            r3 = 1
        L6b:
            if (r3 == 0) goto L78
            c.c.a.b.d0.g r0 = r6.s
            int r1 = r6.A
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.q(r1)
        L78:
            r6.invalidate()
        L7b:
            r6.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.c():void");
    }

    public final void d() {
        e(this.Q, this.T, this.S, this.V, this.U);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.e == null || (editText = this.d) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.q;
        this.q = false;
        CharSequence hint = editText.getHint();
        this.d.setHint(this.e);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.d.setHint(hint);
            this.q = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.r0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.r0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float fAscent;
        super.draw(canvas);
        if (this.o) {
            c.c.a.b.y.c cVar = this.n0;
            if (cVar == null) {
                throw null;
            }
            int iSave = canvas.save();
            if (cVar.x != null && cVar.f1742b) {
                float f2 = cVar.q;
                float f3 = cVar.r;
                boolean z = cVar.z && cVar.A != null;
                if (z) {
                    fAscent = cVar.C * cVar.E;
                } else {
                    fAscent = cVar.I.ascent() * cVar.E;
                    cVar.I.descent();
                }
                if (z) {
                    f3 += fAscent;
                }
                float f4 = f3;
                float f5 = cVar.E;
                if (f5 != 1.0f) {
                    canvas.scale(f5, f5, f2, f4);
                }
                if (z) {
                    canvas.drawBitmap(cVar.A, f2, f4, cVar.B);
                } else {
                    CharSequence charSequence = cVar.x;
                    canvas.drawText(charSequence, 0, charSequence.length(), f2, f4, cVar.I);
                }
            }
            canvas.restoreToCount(iSave);
        }
        c.c.a.b.d0.g gVar = this.s;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.x;
            this.s.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        boolean z2;
        if (this.q0) {
            return;
        }
        this.q0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        c.c.a.b.y.c cVar = this.n0;
        if (cVar != null) {
            cVar.G = drawableState;
            ColorStateList colorStateList2 = cVar.l;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.k) != null && colorStateList.isStateful())) {
                cVar.k();
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2 | false;
        } else {
            z = false;
        }
        v(l.E(this) && isEnabled(), false);
        s();
        w();
        if (z) {
            invalidate();
        }
        this.q0 = false;
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = a.a.a.a.a.C0(drawable).mutate();
            if (z) {
                drawable.setTintList(colorStateList);
            }
            if (z2) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final void f() {
        e(this.G, this.I, this.H, this.K, this.J);
    }

    public final int g() {
        float f2;
        if (!this.o) {
            return 0;
        }
        int i = this.v;
        if (i == 0 || i == 1) {
            f2 = this.n0.f();
        } else {
            if (i != 2) {
                return 0;
            }
            f2 = this.n0.f() / 2.0f;
        }
        return (int) f2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.d;
        if (editText == null) {
            return super.getBaseline();
        }
        return g() + getPaddingTop() + editText.getBaseline();
    }

    public c.c.a.b.d0.g getBoxBackground() {
        int i = this.v;
        if (i == 1 || i == 2) {
            return this.r;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.B;
    }

    public int getBoxBackgroundMode() {
        return this.v;
    }

    public float getBoxCornerRadiusBottomEnd() {
        c.c.a.b.d0.g gVar = this.r;
        return gVar.f1555b.f1558a.h.a(gVar.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        c.c.a.b.d0.g gVar = this.r;
        return gVar.f1555b.f1558a.g.a(gVar.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        c.c.a.b.d0.g gVar = this.r;
        return gVar.f1555b.f1558a.f.a(gVar.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.r.m();
    }

    public int getBoxStrokeColor() {
        return this.h0;
    }

    public int getCounterMaxLength() {
        return this.h;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.g && this.i && (textView = this.j) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.m;
    }

    public ColorStateList getCounterTextColor() {
        return this.m;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.d0;
    }

    public EditText getEditText() {
        return this.d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.Q.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.Q.getDrawable();
    }

    public int getEndIconMode() {
        return this.O;
    }

    public CheckableImageButton getEndIconView() {
        return this.Q;
    }

    public CharSequence getError() {
        o oVar = this.f;
        if (oVar.l) {
            return oVar.k;
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.b0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f.g();
    }

    public CharSequence getHelperText() {
        o oVar = this.f;
        if (oVar.q) {
            return oVar.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.f.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.o) {
            return this.p;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.n0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.n0.g();
    }

    public ColorStateList getHintTextColor() {
        return this.e0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.Q.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.Q.getDrawable();
    }

    public CharSequence getStartIconContentDescription() {
        return this.G.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.G.getDrawable();
    }

    public Typeface getTypeface() {
        return this.F;
    }

    public final boolean h() {
        return this.o && !TextUtils.isEmpty(this.p) && (this.r instanceof c.c.a.b.g0.g);
    }

    public final boolean i() {
        return this.O != 0;
    }

    public boolean j() {
        return this.f2006c.getVisibility() == 0 && this.Q.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            r4 = this;
            int r0 = r4.v
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L51
            if (r0 == r2) goto L40
            r3 = 2
            if (r0 != r3) goto L27
            boolean r0 = r4.o
            if (r0 == 0) goto L1d
            c.c.a.b.d0.g r0 = r4.r
            boolean r0 = r0 instanceof c.c.a.b.g0.g
            if (r0 != 0) goto L1d
            c.c.a.b.g0.g r0 = new c.c.a.b.g0.g
            c.c.a.b.d0.j r3 = r4.t
            r0.<init>(r3)
            goto L24
        L1d:
            c.c.a.b.d0.g r0 = new c.c.a.b.d0.g
            c.c.a.b.d0.j r3 = r4.t
            r0.<init>(r3)
        L24:
            r4.r = r0
            goto L53
        L27:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r4.v
            r1.append(r2)
            java.lang.String r2 = " is illegal; only @BoxBackgroundMode constants are supported."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L40:
            c.c.a.b.d0.g r0 = new c.c.a.b.d0.g
            c.c.a.b.d0.j r1 = r4.t
            r0.<init>(r1)
            r4.r = r0
            c.c.a.b.d0.g r0 = new c.c.a.b.d0.g
            r0.<init>()
            r4.s = r0
            goto L55
        L51:
            r4.r = r1
        L53:
            r4.s = r1
        L55:
            android.widget.EditText r0 = r4.d
            if (r0 == 0) goto L68
            c.c.a.b.d0.g r1 = r4.r
            if (r1 == 0) goto L68
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 != 0) goto L68
            int r0 = r4.v
            if (r0 == 0) goto L68
            goto L69
        L68:
            r2 = 0
        L69:
            if (r2 == 0) goto L72
            android.widget.EditText r0 = r4.d
            c.c.a.b.d0.g r1 = r4.r
            b.i.m.l.Z(r0, r1)
        L72:
            r4.w()
            int r0 = r4.v
            if (r0 == 0) goto L7c
            r4.u()
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.k():void");
    }

    public final void l() {
        if (h()) {
            RectF rectF = this.E;
            c.c.a.b.y.c cVar = this.n0;
            boolean zC = cVar.c(cVar.w);
            Rect rect = cVar.e;
            float fB = !zC ? rect.left : rect.right - cVar.b();
            rectF.left = fB;
            Rect rect2 = cVar.e;
            rectF.top = rect2.top;
            rectF.right = !zC ? cVar.b() + fB : rect2.right;
            float f2 = cVar.f() + cVar.e.top;
            rectF.bottom = f2;
            float f3 = rectF.left;
            float f4 = this.u;
            rectF.left = f3 - f4;
            rectF.top -= f4;
            rectF.right += f4;
            rectF.bottom = f2 + f4;
            rectF.offset(-getPaddingLeft(), 0.0f);
            c.c.a.b.g0.g gVar = (c.c.a.b.g0.g) this.r;
            if (gVar == null) {
                throw null;
            }
            gVar.y(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            a.a.a.a.a.s0(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = c.c.a.b.j.TextAppearance_AppCompat_Caption
            a.a.a.a.a.s0(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = c.c.a.b.c.design_error
            int r4 = b.i.e.a.a(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.o(android.widget.TextView, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0136  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iMax;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.d != null && this.d.getMeasuredHeight() < (iMax = Math.max(this.Q.getMeasuredHeight(), this.G.getMeasuredHeight()))) {
            this.d.setMinimumHeight(iMax);
            z = true;
        }
        boolean zT = t();
        if (z || zT) {
            this.d.post(new c());
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f890b);
        setError(hVar.d);
        if (hVar.e) {
            this.Q.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f.e()) {
            hVar.d = getError();
        }
        hVar.e = i() && this.Q.isChecked();
        return hVar;
    }

    public final void p() {
        if (this.j != null) {
            EditText editText = this.d;
            q(editText == null ? 0 : editText.getText().length());
        }
    }

    public void q(int i) {
        boolean z = this.i;
        if (this.h == -1) {
            this.j.setText(String.valueOf(i));
            this.j.setContentDescription(null);
            this.i = false;
        } else {
            if (l.i(this.j) == 1) {
                this.j.setAccessibilityLiveRegion(0);
            }
            this.i = i > this.h;
            Context context = getContext();
            this.j.setContentDescription(context.getString(this.i ? c.c.a.b.i.character_counter_overflowed_content_description : c.c.a.b.i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.h)));
            if (z != this.i) {
                r();
                if (this.i) {
                    this.j.setAccessibilityLiveRegion(1);
                }
            }
            this.j.setText(getContext().getString(c.c.a.b.i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.h)));
        }
        if (this.d == null || z == this.i) {
            return;
        }
        v(false, false);
        w();
        s();
    }

    public final void r() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.j;
        if (textView != null) {
            o(textView, this.i ? this.k : this.l);
            if (!this.i && (colorStateList2 = this.m) != null) {
                this.j.setTextColor(colorStateList2);
            }
            if (!this.i || (colorStateList = this.n) == null) {
                return;
            }
            this.j.setTextColor(colorStateList);
        }
    }

    public void s() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.d;
        if (editText == null || this.v != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e0.a(background)) {
            background = background.mutate();
        }
        if (this.f.e()) {
            currentTextColor = this.f.g();
        } else {
            if (!this.i || (textView = this.j) == null) {
                a.a.a.a.a.k(background);
                this.d.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(b.b.p.j.c(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.B != i) {
            this.B = i;
            this.i0 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(b.i.e.a.a(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.v) {
            return;
        }
        this.v = i;
        if (this.d != null) {
            k();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.h0 != i) {
            this.h0 = i;
            w();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.g != z) {
            if (z) {
                z zVar = new z(getContext(), null);
                this.j = zVar;
                zVar.setId(c.c.a.b.f.textinput_counter);
                Typeface typeface = this.F;
                if (typeface != null) {
                    this.j.setTypeface(typeface);
                }
                this.j.setMaxLines(1);
                this.f.a(this.j, 2);
                r();
                p();
            } else {
                this.f.i(this.j, 2);
                this.j = null;
            }
            this.g = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.h != i) {
            if (i <= 0) {
                i = -1;
            }
            this.h = i;
            if (this.g) {
                p();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.k != i) {
            this.k = i;
            r();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            r();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.l != i) {
            this.l = i;
            r();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            r();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.d0 = colorStateList;
        this.e0 = colorStateList;
        if (this.d != null) {
            v(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.Q.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.Q.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.Q.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.Q.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i) {
        int i2 = this.O;
        this.O = i;
        setEndIconVisible(i != 0);
        if (!getEndIconDelegate().b(this.v)) {
            StringBuilder sbE = c.a.a.a.a.e("The current box background mode ");
            sbE.append(this.v);
            sbE.append(" is not supported by the end icon mode ");
            sbE.append(i);
            throw new IllegalStateException(sbE.toString());
        }
        getEndIconDelegate().a();
        d();
        Iterator<g> it = this.R.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.Q;
        View.OnLongClickListener onLongClickListener = this.c0;
        checkableImageButton.setOnClickListener(onClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.Q;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (j() != z) {
            this.Q.setVisibility(z ? 0 : 4);
            t();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f.l) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f.h();
            return;
        }
        o oVar = this.f;
        oVar.c();
        oVar.k = charSequence;
        oVar.m.setText(charSequence);
        if (oVar.i != 1) {
            oVar.j = 1;
        }
        oVar.k(oVar.i, oVar.j, oVar.j(oVar.m, charSequence));
    }

    public void setErrorEnabled(boolean z) {
        o oVar = this.f;
        if (oVar.l == z) {
            return;
        }
        oVar.c();
        if (z) {
            z zVar = new z(oVar.f1614a, null);
            oVar.m = zVar;
            zVar.setId(c.c.a.b.f.textinput_error);
            Typeface typeface = oVar.u;
            if (typeface != null) {
                oVar.m.setTypeface(typeface);
            }
            int i = oVar.n;
            oVar.n = i;
            TextView textView = oVar.m;
            if (textView != null) {
                oVar.f1615b.o(textView, i);
            }
            ColorStateList colorStateList = oVar.o;
            oVar.o = colorStateList;
            TextView textView2 = oVar.m;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            oVar.m.setVisibility(4);
            l.Y(oVar.m, 1);
            oVar.a(oVar.m, 0);
        } else {
            oVar.h();
            oVar.i(oVar.m, 0);
            oVar.m = null;
            oVar.f1615b.s();
            oVar.f1615b.w();
        }
        oVar.l = z;
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.b0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f.l);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b0.getDrawable();
        if (drawable != null) {
            drawable = a.a.a.a.a.C0(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.b0.getDrawable() != drawable) {
            this.b0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b0.getDrawable();
        if (drawable != null) {
            drawable = a.a.a.a.a.C0(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.b0.getDrawable() != drawable) {
            this.b0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        o oVar = this.f;
        oVar.n = i;
        TextView textView = oVar.m;
        if (textView != null) {
            oVar.f1615b.o(textView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        o oVar = this.f;
        oVar.o = colorStateList;
        TextView textView = oVar.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (this.f.q) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!this.f.q) {
            setHelperTextEnabled(true);
        }
        o oVar = this.f;
        oVar.c();
        oVar.p = charSequence;
        oVar.r.setText(charSequence);
        if (oVar.i != 2) {
            oVar.j = 2;
        }
        oVar.k(oVar.i, oVar.j, oVar.j(oVar.r, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        o oVar = this.f;
        oVar.t = colorStateList;
        TextView textView = oVar.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        o oVar = this.f;
        if (oVar.q == z) {
            return;
        }
        oVar.c();
        if (z) {
            z zVar = new z(oVar.f1614a, null);
            oVar.r = zVar;
            zVar.setId(c.c.a.b.f.textinput_helper_text);
            Typeface typeface = oVar.u;
            if (typeface != null) {
                oVar.r.setTypeface(typeface);
            }
            oVar.r.setVisibility(4);
            l.Y(oVar.r, 1);
            int i = oVar.s;
            oVar.s = i;
            TextView textView = oVar.r;
            if (textView != null) {
                a.a.a.a.a.s0(textView, i);
            }
            ColorStateList colorStateList = oVar.t;
            oVar.t = colorStateList;
            TextView textView2 = oVar.r;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            oVar.a(oVar.r, 1);
        } else {
            oVar.c();
            if (oVar.i == 2) {
                oVar.j = 0;
            }
            oVar.k(oVar.i, oVar.j, oVar.j(oVar.r, null));
            oVar.i(oVar.r, 1);
            oVar.r = null;
            oVar.f1615b.s();
            oVar.f1615b.w();
        }
        oVar.q = z;
    }

    public void setHelperTextTextAppearance(int i) {
        o oVar = this.f;
        oVar.s = i;
        TextView textView = oVar.r;
        if (textView != null) {
            a.a.a.a.a.s0(textView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.o) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.o0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.o) {
            this.o = z;
            if (z) {
                CharSequence hint = this.d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.p)) {
                        setHint(hint);
                    }
                    this.d.setHint((CharSequence) null);
                }
                this.q = true;
            } else {
                this.q = false;
                if (!TextUtils.isEmpty(this.p) && TextUtils.isEmpty(this.d.getHint())) {
                    this.d.setHint(this.p);
                }
                setHintInternal(null);
            }
            if (this.d != null) {
                u();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        c.c.a.b.y.c cVar = this.n0;
        c.c.a.b.a0.b bVar = new c.c.a.b.a0.b(cVar.f1741a.getContext(), i);
        ColorStateList colorStateList = bVar.f1538b;
        if (colorStateList != null) {
            cVar.l = colorStateList;
        }
        float f2 = bVar.f1537a;
        if (f2 != 0.0f) {
            cVar.j = f2;
        }
        ColorStateList colorStateList2 = bVar.f;
        if (colorStateList2 != null) {
            cVar.P = colorStateList2;
        }
        cVar.N = bVar.g;
        cVar.O = bVar.h;
        cVar.M = bVar.i;
        c.c.a.b.a0.a aVar = cVar.v;
        if (aVar != null) {
            aVar.f1536c = true;
        }
        c.c.a.b.y.b bVar2 = new c.c.a.b.y.b(cVar);
        bVar.a();
        cVar.v = new c.c.a.b.a0.a(bVar2, bVar.l);
        bVar.b(cVar.f1741a.getContext(), cVar.v);
        cVar.k();
        this.e0 = this.n0.l;
        if (this.d != null) {
            v(false, false);
            u();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.e0 != colorStateList) {
            if (this.d0 == null) {
                c.c.a.b.y.c cVar = this.n0;
                if (cVar.l != colorStateList) {
                    cVar.l = colorStateList;
                    cVar.k();
                }
            }
            this.e0 = colorStateList;
            if (this.d != null) {
                v(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.Q.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.Q.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.O != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.S = colorStateList;
        this.T = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.U = mode;
        this.V = true;
        d();
    }

    public void setStartIconCheckable(boolean z) {
        this.G.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.G.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? b.b.l.a.a.b(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.G.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            f();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.G;
        View.OnLongClickListener onLongClickListener = this.M;
        checkableImageButton.setOnClickListener(onClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.M = onLongClickListener;
        CheckableImageButton checkableImageButton = this.G;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            this.I = true;
            f();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.J != mode) {
            this.J = mode;
            this.K = true;
            f();
        }
    }

    public void setStartIconVisible(boolean z) {
        if ((this.G.getVisibility() == 0) != z) {
            this.G.setVisibility(z ? 0 : 8);
            t();
        }
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.d;
        if (editText != null) {
            l.W(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.F) {
            this.F = typeface;
            this.n0.p(typeface);
            o oVar = this.f;
            if (typeface != oVar.u) {
                oVar.u = typeface;
                TextView textView = oVar.m;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = oVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t() {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.t():boolean");
    }

    public final void u() {
        if (this.v != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2005b.getLayoutParams();
            int iG = g();
            if (iG != layoutParams.topMargin) {
                layoutParams.topMargin = iG;
                this.f2005b.requestLayout();
            }
        }
    }

    public final void v(boolean z, boolean z2) {
        ColorStateList textColors;
        c.c.a.b.y.c cVar;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.d;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.d;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zE = this.f.e();
        ColorStateList colorStateList = this.d0;
        if (colorStateList != null) {
            c.c.a.b.y.c cVar2 = this.n0;
            if (cVar2.l != colorStateList) {
                cVar2.l = colorStateList;
                cVar2.k();
            }
            c.c.a.b.y.c cVar3 = this.n0;
            ColorStateList colorStateList2 = this.d0;
            if (cVar3.k != colorStateList2) {
                cVar3.k = colorStateList2;
                cVar3.k();
            }
        }
        if (!zIsEnabled) {
            this.n0.m(ColorStateList.valueOf(this.l0));
            c.c.a.b.y.c cVar4 = this.n0;
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.l0);
            if (cVar4.k != colorStateListValueOf) {
                cVar4.k = colorStateListValueOf;
                cVar4.k();
            }
        } else if (zE) {
            c.c.a.b.y.c cVar5 = this.n0;
            TextView textView2 = this.f.m;
            cVar5.m(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.i && (textView = this.j) != null) {
                cVar = this.n0;
                textColors = textView.getTextColors();
            } else if (z4 && (textColors = this.e0) != null) {
                cVar = this.n0;
            }
            cVar.m(textColors);
        }
        if (z3 || (isEnabled() && (z4 || zE))) {
            if (z2 || this.m0) {
                ValueAnimator valueAnimator = this.p0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.p0.cancel();
                }
                if (z && this.o0) {
                    b(1.0f);
                } else {
                    this.n0.n(1.0f);
                }
                this.m0 = false;
                if (h()) {
                    l();
                    return;
                }
                return;
            }
            return;
        }
        if (z2 || !this.m0) {
            ValueAnimator valueAnimator2 = this.p0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.p0.cancel();
            }
            if (z && this.o0) {
                b(0.0f);
            } else {
                this.n0.n(0.0f);
            }
            if (h() && (!((c.c.a.b.g0.g) this.r).y.isEmpty()) && h()) {
                ((c.c.a.b.g0.g) this.r).y(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.m0 = true;
        }
    }

    public void w() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.r == null || this.v == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.d) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.d) != null && editText.isHovered());
        this.A = !isEnabled() ? this.l0 : this.f.e() ? this.f.g() : (!this.i || (textView = this.j) == null) ? z2 ? this.h0 : z3 ? this.g0 : this.f0 : textView.getCurrentTextColor();
        if (!(this.f.e() && getEndIconDelegate().c()) || getEndIconDrawable() == null) {
            d();
        } else {
            Drawable drawableMutate = a.a.a.a.a.C0(getEndIconDrawable()).mutate();
            drawableMutate.setTint(this.f.g());
            this.Q.setImageDrawable(drawableMutate);
        }
        if (getErrorIconDrawable() != null) {
            o oVar = this.f;
            if (oVar.l && oVar.e()) {
                z = true;
            }
        }
        setErrorIconVisible(z);
        this.x = ((z3 || z2) && isEnabled()) ? this.z : this.y;
        if (this.v == 1) {
            this.B = !isEnabled() ? this.j0 : z3 ? this.k0 : this.i0;
        }
        c();
    }
}
