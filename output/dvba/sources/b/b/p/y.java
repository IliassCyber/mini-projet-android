package b.b.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0 f510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0 f511c;
    public v0 d;
    public v0 e;
    public v0 f;
    public v0 g;
    public v0 h;
    public final a0 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public class a extends b.i.e.b.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f514c;

        public a(int i, int i2, WeakReference weakReference) {
            this.f512a = i;
            this.f513b = i2;
            this.f514c = weakReference;
        }

        @Override // b.i.e.b.g
        public void c(int i) {
        }

        @Override // b.i.e.b.g
        public void d(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f512a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f513b & 2) != 0);
            }
            y yVar = y.this;
            WeakReference weakReference = this.f514c;
            if (yVar.m) {
                yVar.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    textView.setTypeface(typeface, yVar.j);
                }
            }
        }
    }

    public y(TextView textView) {
        this.f509a = textView;
        this.i = new a0(this.f509a);
    }

    public static v0 c(Context context, j jVar, int i) {
        ColorStateList colorStateListD = jVar.d(context, i);
        if (colorStateListD == null) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.d = true;
        v0Var.f489a = colorStateListD;
        return v0Var;
    }

    public final void a(Drawable drawable, v0 v0Var) {
        if (drawable == null || v0Var == null) {
            return;
        }
        j.f(drawable, v0Var, this.f509a.getDrawableState());
    }

    public void b() {
        if (this.f510b != null || this.f511c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f509a.getCompoundDrawables();
            a(compoundDrawables[0], this.f510b);
            a(compoundDrawables[1], this.f511c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f509a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public boolean d() {
        a0 a0Var = this.i;
        return a0Var.i() && a0Var.f395a != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    public void e(AttributeSet attributeSet, int i) {
        boolean zA;
        String strM;
        boolean z;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        String strM2;
        ColorStateList colorStateListC3;
        j jVar;
        int i2;
        j jVar2;
        Drawable drawableB;
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        Context context = this.f509a.getContext();
        j jVarA = j.a();
        x0 x0VarQ = x0.q(context, attributeSet, b.b.j.AppCompatTextHelper, i, 0);
        TextView textView = this.f509a;
        b.i.m.l.V(textView, textView.getContext(), b.b.j.AppCompatTextHelper, attributeSet, x0VarQ.f507b, i, 0);
        int iL = x0VarQ.l(b.b.j.AppCompatTextHelper_android_textAppearance, -1);
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f510b = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableTop)) {
            this.f511c = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableStart)) {
            this.f = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (x0VarQ.o(b.b.j.AppCompatTextHelper_android_drawableEnd)) {
            this.g = c(context, jVarA, x0VarQ.l(b.b.j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        x0VarQ.f507b.recycle();
        boolean z2 = this.f509a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iL != -1) {
            x0 x0Var = new x0(context, context.obtainStyledAttributes(iL, b.b.j.TextAppearance));
            if (z2 || !x0Var.o(b.b.j.TextAppearance_textAllCaps)) {
                zA = false;
                z = false;
            } else {
                zA = x0Var.a(b.b.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            l(context, x0Var);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateListC = x0Var.o(b.b.j.TextAppearance_android_textColor) ? x0Var.c(b.b.j.TextAppearance_android_textColor) : null;
                colorStateListC3 = x0Var.o(b.b.j.TextAppearance_android_textColorHint) ? x0Var.c(b.b.j.TextAppearance_android_textColorHint) : null;
                colorStateListC2 = x0Var.o(b.b.j.TextAppearance_android_textColorLink) ? x0Var.c(b.b.j.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
                colorStateListC3 = null;
            }
            strM2 = x0Var.o(b.b.j.TextAppearance_textLocale) ? x0Var.m(b.b.j.TextAppearance_textLocale) : null;
            strM = (Build.VERSION.SDK_INT < 26 || !x0Var.o(b.b.j.TextAppearance_fontVariationSettings)) ? null : x0Var.m(b.b.j.TextAppearance_fontVariationSettings);
            x0Var.f507b.recycle();
        } else {
            zA = false;
            strM = null;
            z = false;
            colorStateListC = null;
            colorStateListC2 = null;
            strM2 = null;
            colorStateListC3 = null;
        }
        x0 x0Var2 = new x0(context, context.obtainStyledAttributes(attributeSet, b.b.j.TextAppearance, i, 0));
        if (!z2 && x0Var2.o(b.b.j.TextAppearance_textAllCaps)) {
            zA = x0Var2.a(b.b.j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (x0Var2.o(b.b.j.TextAppearance_android_textColor)) {
                colorStateListC = x0Var2.c(b.b.j.TextAppearance_android_textColor);
            }
            if (x0Var2.o(b.b.j.TextAppearance_android_textColorHint)) {
                colorStateListC3 = x0Var2.c(b.b.j.TextAppearance_android_textColorHint);
            }
            if (x0Var2.o(b.b.j.TextAppearance_android_textColorLink)) {
                colorStateListC2 = x0Var2.c(b.b.j.TextAppearance_android_textColorLink);
            }
        }
        if (x0Var2.o(b.b.j.TextAppearance_textLocale)) {
            strM2 = x0Var2.m(b.b.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && x0Var2.o(b.b.j.TextAppearance_fontVariationSettings)) {
            strM = x0Var2.m(b.b.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && x0Var2.o(b.b.j.TextAppearance_android_textSize) && x0Var2.f(b.b.j.TextAppearance_android_textSize, -1) == 0) {
            jVar = jVarA;
            this.f509a.setTextSize(0, 0.0f);
        } else {
            jVar = jVarA;
        }
        l(context, x0Var2);
        x0Var2.f507b.recycle();
        if (colorStateListC != null) {
            this.f509a.setTextColor(colorStateListC);
        }
        if (colorStateListC3 != null) {
            this.f509a.setHintTextColor(colorStateListC3);
        }
        if (colorStateListC2 != null) {
            this.f509a.setLinkTextColor(colorStateListC2);
        }
        if (!z2 && z) {
            this.f509a.setAllCaps(zA);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f509a.setTypeface(typeface, this.j);
            } else {
                this.f509a.setTypeface(typeface);
            }
        }
        if (strM != null) {
            this.f509a.setFontVariationSettings(strM);
        }
        if (strM2 == null) {
            i2 = 0;
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.f509a.setTextLocales(LocaleList.forLanguageTags(strM2));
            i2 = 0;
        } else {
            i2 = 0;
            this.f509a.setTextLocale(Locale.forLanguageTag(strM2.substring(0, strM2.indexOf(44))));
        }
        a0 a0Var = this.i;
        TypedArray typedArrayObtainStyledAttributes = a0Var.j.obtainStyledAttributes(attributeSet, b.b.j.AppCompatTextView, i, i2);
        TextView textView2 = a0Var.i;
        b.i.m.l.V(textView2, textView2.getContext(), b.b.j.AppCompatTextView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTextView_autoSizeTextType)) {
            a0Var.f395a = typedArrayObtainStyledAttributes.getInt(b.b.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(b.b.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(b.b.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(b.b.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(b.b.j.AppCompatTextView_autoSizePresetSizes) && (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(b.b.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr = new int[length];
            if (length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = typedArrayObtainTypedArray.getDimensionPixelSize(i3, -1);
                }
                a0Var.f = a0Var.b(iArr);
                a0Var.h();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!a0Var.i()) {
            a0Var.f395a = 0;
        } else if (a0Var.f395a == 1) {
            if (!a0Var.g) {
                DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a0Var.j(dimension2, dimension3, dimension);
            }
            a0Var.g();
        }
        if (b.i.n.b.f880a) {
            a0 a0Var2 = this.i;
            if (a0Var2.f395a != 0) {
                int[] iArr2 = a0Var2.f;
                if (iArr2.length > 0) {
                    if (this.f509a.getAutoSizeStepGranularity() != -1.0f) {
                        this.f509a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.i.d), Math.round(this.i.e), Math.round(this.i.f397c), 0);
                    } else {
                        this.f509a.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
                    }
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.b.j.AppCompatTextView);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId3 != -1) {
            jVar2 = jVar;
            drawableB = jVar2.b(context, resourceId3);
        } else {
            jVar2 = jVar;
            drawableB = null;
        }
        int resourceId4 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableB2 = resourceId4 != -1 ? jVar2.b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableB3 = resourceId5 != -1 ? jVar2.b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableB4 = resourceId6 != -1 ? jVar2.b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableB5 = resourceId7 != -1 ? jVar2.b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes2.getResourceId(b.b.j.AppCompatTextView_drawableEndCompat, -1);
        Drawable drawableB6 = resourceId8 != -1 ? jVar2.b(context, resourceId8) : null;
        if (drawableB5 != null || drawableB6 != null) {
            Drawable[] compoundDrawablesRelative = this.f509a.getCompoundDrawablesRelative();
            TextView textView3 = this.f509a;
            if (drawableB5 == null) {
                drawableB5 = compoundDrawablesRelative[0];
            }
            if (drawableB2 == null) {
                drawableB2 = compoundDrawablesRelative[1];
            }
            if (drawableB6 == null) {
                drawableB6 = compoundDrawablesRelative[2];
            }
            if (drawableB4 == null) {
                drawableB4 = compoundDrawablesRelative[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableB5, drawableB2, drawableB6, drawableB4);
        } else if (drawableB != null || drawableB2 != null || drawableB3 != null || drawableB4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.f509a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f509a.getCompoundDrawables();
                TextView textView4 = this.f509a;
                if (drawableB == null) {
                    drawableB = compoundDrawables[0];
                }
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawables[1];
                }
                if (drawableB3 == null) {
                    drawableB3 = compoundDrawables[2];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(drawableB, drawableB2, drawableB3, drawableB4);
            } else {
                TextView textView5 = this.f509a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawablesRelative2[3];
                }
                textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableB2, drawable2, drawableB4);
            }
        }
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTextView_drawableTint)) {
            int i4 = b.b.j.AppCompatTextView_drawableTint;
            if (!typedArrayObtainStyledAttributes2.hasValue(i4) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(i4, 0)) == 0 || (colorStateList = b.b.l.a.a.a(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(i4);
            }
            TextView textView6 = this.f509a;
            if (textView6 == 0) {
                throw null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                textView6.setCompoundDrawableTintList(colorStateList);
            } else if (textView6 instanceof b.i.n.e) {
                ((b.i.n.e) textView6).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (typedArrayObtainStyledAttributes2.hasValue(b.b.j.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode modeC = e0.c(typedArrayObtainStyledAttributes2.getInt(b.b.j.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView7 = this.f509a;
            if (textView7 == 0) {
                throw null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                textView7.setCompoundDrawableTintMode(modeC);
            } else if (textView7 instanceof b.i.n.e) {
                ((b.i.n.e) textView7).setSupportCompoundDrawablesTintMode(modeC);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(b.b.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(b.b.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(b.b.j.AppCompatTextView_lineHeight, -1);
        typedArrayObtainStyledAttributes2.recycle();
        if (dimensionPixelSize != -1) {
            a.a.a.a.a.m0(this.f509a, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            a.a.a.a.a.n0(this.f509a, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            a.a.a.a.a.p0(this.f509a, dimensionPixelSize3);
        }
    }

    public void f(Context context, int i) {
        String strM;
        ColorStateList colorStateListC;
        x0 x0Var = new x0(context, context.obtainStyledAttributes(i, b.b.j.TextAppearance));
        if (x0Var.o(b.b.j.TextAppearance_textAllCaps)) {
            this.f509a.setAllCaps(x0Var.a(b.b.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && x0Var.o(b.b.j.TextAppearance_android_textColor) && (colorStateListC = x0Var.c(b.b.j.TextAppearance_android_textColor)) != null) {
            this.f509a.setTextColor(colorStateListC);
        }
        if (x0Var.o(b.b.j.TextAppearance_android_textSize) && x0Var.f(b.b.j.TextAppearance_android_textSize, -1) == 0) {
            this.f509a.setTextSize(0, 0.0f);
        }
        l(context, x0Var);
        if (Build.VERSION.SDK_INT >= 26 && x0Var.o(b.b.j.TextAppearance_fontVariationSettings) && (strM = x0Var.m(b.b.j.TextAppearance_fontVariationSettings)) != null) {
            this.f509a.setFontVariationSettings(strM);
        }
        x0Var.f507b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f509a.setTypeface(typeface, this.j);
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        a0 a0Var = this.i;
        if (a0Var.i()) {
            DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
            a0Var.j(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (a0Var.g()) {
                a0Var.a();
            }
        }
    }

    public void h(int[] iArr, int i) {
        a0 a0Var = this.i;
        if (a0Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                a0Var.f = a0Var.b(iArrCopyOf);
                if (!a0Var.h()) {
                    StringBuilder sbE = c.a.a.a.a.e("None of the preset sizes is valid: ");
                    sbE.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(sbE.toString());
                }
            } else {
                a0Var.g = false;
            }
            if (a0Var.g()) {
                a0Var.a();
            }
        }
    }

    public void i(int i) {
        a0 a0Var = this.i;
        if (a0Var.i()) {
            if (i == 0) {
                a0Var.f395a = 0;
                a0Var.d = -1.0f;
                a0Var.e = -1.0f;
                a0Var.f397c = -1.0f;
                a0Var.f = new int[0];
                a0Var.f396b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
            a0Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (a0Var.g()) {
                a0Var.a();
            }
        }
    }

    public void j(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f489a = colorStateList;
        v0Var.d = colorStateList != null;
        v0 v0Var2 = this.h;
        this.f510b = v0Var2;
        this.f511c = v0Var2;
        this.d = v0Var2;
        this.e = v0Var2;
        this.f = v0Var2;
        this.g = v0Var2;
    }

    public void k(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f490b = mode;
        v0Var.f491c = mode != null;
        v0 v0Var2 = this.h;
        this.f510b = v0Var2;
        this.f511c = v0Var2;
        this.d = v0Var2;
        this.e = v0Var2;
        this.f = v0Var2;
        this.g = v0Var2;
    }

    public final void l(Context context, x0 x0Var) {
        String strM;
        Typeface typefaceCreate;
        Typeface typeface;
        this.j = x0Var.j(b.b.j.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            int iJ = x0Var.j(b.b.j.TextAppearance_android_textFontWeight, -1);
            this.k = iJ;
            if (iJ != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (!x0Var.o(b.b.j.TextAppearance_android_fontFamily) && !x0Var.o(b.b.j.TextAppearance_fontFamily)) {
            if (x0Var.o(b.b.j.TextAppearance_android_typeface)) {
                this.m = false;
                int iJ2 = x0Var.j(b.b.j.TextAppearance_android_typeface, 1);
                if (iJ2 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (iJ2 == 2) {
                    typeface = Typeface.SERIF;
                } else if (iJ2 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.l = typeface;
                return;
            }
            return;
        }
        this.l = null;
        int i = x0Var.o(b.b.j.TextAppearance_fontFamily) ? b.b.j.TextAppearance_fontFamily : b.b.j.TextAppearance_android_fontFamily;
        int i2 = this.k;
        int i3 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = x0Var.i(i, this.j, new a(i2, i3, new WeakReference(this.f509a)));
                if (typefaceI != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                        typefaceI = Typeface.create(Typeface.create(typefaceI, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = typefaceI;
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strM = x0Var.m(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            typefaceCreate = Typeface.create(strM, this.j);
        } else {
            typefaceCreate = Typeface.create(Typeface.create(strM, 0), this.k, (this.j & 2) != 0);
        }
        this.l = typefaceCreate;
    }
}
