package c.c.a.b.s;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import c.c.a.a.c.l.q;
import c.c.a.b.a0.c;
import c.c.a.b.a0.d;
import c.c.a.b.d0.g;
import c.c.a.b.d0.j;
import c.c.a.b.y.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b extends g implements b.i.f.k.a, Drawable.Callback, h.b {
    public static final int[] G0 = {R.attr.state_enabled};
    public static final ShapeDrawable H0 = new ShapeDrawable(new OvalShape());
    public float A;
    public ColorStateList A0;
    public ColorStateList B;
    public WeakReference<a> B0;
    public float C;
    public TextUtils.TruncateAt C0;
    public ColorStateList D;
    public boolean D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public boolean F0;
    public Drawable G;
    public ColorStateList H;
    public float I;
    public boolean J;
    public boolean K;
    public Drawable L;
    public Drawable M;
    public ColorStateList N;
    public float O;
    public CharSequence P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public c.c.a.b.l.g T;
    public c.c.a.b.l.g U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public final Context d0;
    public final Paint e0;
    public final Paint f0;
    public final Paint.FontMetrics g0;
    public final RectF h0;
    public final PointF i0;
    public final Path j0;
    public final h k0;
    public int l0;
    public int m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public boolean r0;
    public int s0;
    public int t0;
    public ColorFilter u0;
    public PorterDuffColorFilter v0;
    public ColorStateList w0;
    public ColorStateList x;
    public PorterDuff.Mode x0;
    public ColorStateList y;
    public int[] y0;
    public float z;
    public boolean z0;

    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(j.b(context, attributeSet, i, i2).a());
        this.e0 = new Paint(1);
        this.g0 = new Paint.FontMetrics();
        this.h0 = new RectF();
        this.i0 = new PointF();
        this.j0 = new Path();
        this.t0 = 255;
        this.x0 = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.B0 = new WeakReference<>(null);
        this.f1555b.f1559b = new c.c.a.b.v.a(context);
        x();
        this.d0 = context;
        h hVar = new h(this);
        this.k0 = hVar;
        this.E = "";
        hVar.f1754a.density = context.getResources().getDisplayMetrics().density;
        this.f0 = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(G0);
        c0(G0);
        this.D0 = true;
        boolean z = c.c.a.b.b0.a.f1545a;
        H0.setTint(-1);
    }

    public static boolean G(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean H(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public float A() {
        if (o0() || n0()) {
            return this.W + this.I + this.X;
        }
        return 0.0f;
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (p0()) {
            float f = this.c0 + this.b0;
            if (a.a.a.a.a.B(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.O;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.O;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.O;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public final void C(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (p0()) {
            float f = this.c0 + this.b0 + this.O + this.a0 + this.Z;
            if (a.a.a.a.a.B(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public float D() {
        if (p0()) {
            return this.a0 + this.O + this.b0;
        }
        return 0.0f;
    }

    public float E() {
        return this.F0 ? m() : this.A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable F() {
        Drawable drawable = this.L;
        if (drawable != 0) {
            return drawable instanceof b.i.f.k.b ? ((b.i.f.k.b) drawable).a() : drawable;
        }
        return null;
    }

    public void I() {
        a aVar = this.B0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public final boolean J(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.x;
        int colorForState = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.l0) : 0;
        boolean state = true;
        if (this.l0 != colorForState) {
            this.l0 = colorForState;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.y;
        int colorForState2 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.m0) : 0;
        if (this.m0 != colorForState2) {
            this.m0 = colorForState2;
            zOnStateChange = true;
        }
        int iA = b.i.f.a.a(colorForState2, colorForState);
        if ((this.n0 != iA) | (this.f1555b.d == null)) {
            this.n0 = iA;
            q(ColorStateList.valueOf(iA));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.B;
        int colorForState3 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.o0) : 0;
        if (this.o0 != colorForState3) {
            this.o0 = colorForState3;
            zOnStateChange = true;
        }
        int colorForState4 = (this.A0 == null || !c.c.a.b.b0.a.b(iArr)) ? 0 : this.A0.getColorForState(iArr, this.p0);
        if (this.p0 != colorForState4) {
            this.p0 = colorForState4;
            if (this.z0) {
                zOnStateChange = true;
            }
        }
        c.c.a.b.a0.b bVar = this.k0.f;
        int colorForState5 = (bVar == null || (colorStateList = bVar.f1538b) == null) ? 0 : colorStateList.getColorForState(iArr, this.q0);
        if (this.q0 != colorForState5) {
            this.q0 = colorForState5;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z = false;
        } else {
            for (int i : state2) {
                if (i == 16842912) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        boolean z3 = z && this.Q;
        if (this.r0 == z3 || this.S == null) {
            z2 = false;
        } else {
            float fA = A();
            this.r0 = z3;
            if (fA != A()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                zOnStateChange = true;
                z2 = false;
            }
        }
        ColorStateList colorStateList5 = this.w0;
        int colorForState6 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.s0) : 0;
        if (this.s0 != colorForState6) {
            this.s0 = colorForState6;
            this.v0 = q.a0(this, this.w0, this.x0);
        } else {
            state = zOnStateChange;
        }
        if (H(this.G)) {
            state |= this.G.setState(iArr);
        }
        if (H(this.S)) {
            state |= this.S.setState(iArr);
        }
        if (H(this.L)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.L.setState(iArr3);
        }
        boolean z4 = c.c.a.b.b0.a.f1545a;
        if (H(this.M)) {
            state |= this.M.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            I();
        }
        return state;
    }

    public void K(boolean z) {
        if (this.Q != z) {
            this.Q = z;
            float fA = A();
            if (!z && this.r0) {
                this.r0 = false;
            }
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    public void L(Drawable drawable) {
        if (this.S != drawable) {
            float fA = A();
            this.S = drawable;
            float fA2 = A();
            q0(this.S);
            y(this.S);
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    public void M(boolean z) {
        if (this.R != z) {
            boolean zN0 = n0();
            this.R = z;
            boolean zN02 = n0();
            if (zN0 != zN02) {
                if (zN02) {
                    y(this.S);
                } else {
                    q0(this.S);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void N(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void O(float f) {
        if (this.A != f) {
            this.A = f;
            this.f1555b.f1558a = this.f1555b.f1558a.e(f);
            invalidateSelf();
        }
    }

    public void P(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            I();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [c.c.a.b.d0.g, c.c.a.b.s.b] */
    public void Q(Drawable drawable) {
        ?? A;
        Object obj = this.G;
        if (obj != null) {
            boolean z = obj instanceof b.i.f.k.b;
            A = obj;
            if (z) {
                A = ((b.i.f.k.b) obj).a();
            }
        } else {
            A = 0;
        }
        if (A != drawable) {
            float fA = A();
            this.G = drawable != null ? a.a.a.a.a.C0(drawable).mutate() : null;
            float fA2 = A();
            q0(A);
            if (o0()) {
                y(this.G);
            }
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    public void R(float f) {
        if (this.I != f) {
            float fA = A();
            this.I = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    public void S(ColorStateList colorStateList) {
        this.J = true;
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (o0()) {
                this.G.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void T(boolean z) {
        if (this.F != z) {
            boolean zO0 = o0();
            this.F = z;
            boolean zO02 = o0();
            if (zO0 != zO02) {
                if (zO02) {
                    y(this.G);
                } else {
                    q0(this.G);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void U(float f) {
        if (this.z != f) {
            this.z = f;
            invalidateSelf();
            I();
        }
    }

    public void V(float f) {
        if (this.V != f) {
            this.V = f;
            invalidateSelf();
            I();
        }
    }

    public void W(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (this.F0) {
                u(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void X(float f) {
        if (this.C != f) {
            this.C = f;
            this.e0.setStrokeWidth(f);
            if (this.F0) {
                this.f1555b.l = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void Y(Drawable drawable) {
        Drawable drawableF = F();
        if (drawableF != drawable) {
            float fD = D();
            this.L = drawable != null ? a.a.a.a.a.C0(drawable).mutate() : null;
            boolean z = c.c.a.b.b0.a.f1545a;
            this.M = new RippleDrawable(c.c.a.b.b0.a.a(this.D), this.L, H0);
            float fD2 = D();
            q0(drawableF);
            if (p0()) {
                y(this.L);
            }
            invalidateSelf();
            if (fD != fD2) {
                I();
            }
        }
    }

    public void Z(float f) {
        if (this.b0 != f) {
            this.b0 = f;
            invalidateSelf();
            if (p0()) {
                I();
            }
        }
    }

    @Override // c.c.a.b.y.h.b
    public void a() {
        I();
        invalidateSelf();
    }

    public void a0(float f) {
        if (this.O != f) {
            this.O = f;
            invalidateSelf();
            if (p0()) {
                I();
            }
        }
    }

    public void b0(float f) {
        if (this.a0 != f) {
            this.a0 = f;
            invalidateSelf();
            if (p0()) {
                I();
            }
        }
    }

    public boolean c0(int[] iArr) {
        if (Arrays.equals(this.y0, iArr)) {
            return false;
        }
        this.y0 = iArr;
        if (p0()) {
            return J(getState(), iArr);
        }
        return false;
    }

    public void d0(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (p0()) {
                this.L.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int iSaveLayerAlpha;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iSave;
        float f;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.t0) == 0) {
            return;
        }
        if (i < 255) {
            float f2 = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            iSaveLayerAlpha = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i) : canvas.saveLayerAlpha(f2, f3, f4, f5, i, 31);
        } else {
            iSaveLayerAlpha = 0;
        }
        if (!this.F0) {
            this.e0.setColor(this.l0);
            this.e0.setStyle(Paint.Style.FILL);
            this.h0.set(bounds);
            canvas.drawRoundRect(this.h0, E(), E(), this.e0);
        }
        if (!this.F0) {
            this.e0.setColor(this.m0);
            this.e0.setStyle(Paint.Style.FILL);
            Paint paint = this.e0;
            ColorFilter colorFilter = this.u0;
            if (colorFilter == null) {
                colorFilter = this.v0;
            }
            paint.setColorFilter(colorFilter);
            this.h0.set(bounds);
            canvas.drawRoundRect(this.h0, E(), E(), this.e0);
        }
        if (this.F0) {
            super.draw(canvas);
        }
        if (this.C > 0.0f && !this.F0) {
            this.e0.setColor(this.o0);
            this.e0.setStyle(Paint.Style.STROKE);
            if (!this.F0) {
                Paint paint2 = this.e0;
                ColorFilter colorFilter2 = this.u0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.v0;
                }
                paint2.setColorFilter(colorFilter2);
            }
            RectF rectF = this.h0;
            float f6 = bounds.left;
            float f7 = this.C / 2.0f;
            rectF.set(f6 + f7, bounds.top + f7, bounds.right - f7, bounds.bottom - f7);
            float f8 = this.A - (this.C / 2.0f);
            canvas.drawRoundRect(this.h0, f8, f8, this.e0);
        }
        this.e0.setColor(this.p0);
        this.e0.setStyle(Paint.Style.FILL);
        this.h0.set(bounds);
        if (this.F0) {
            c(new RectF(bounds), this.j0);
            i2 = 0;
            g(canvas, this.e0, this.j0, this.f1555b.f1558a, h());
        } else {
            canvas.drawRoundRect(this.h0, E(), E(), this.e0);
            i2 = 0;
        }
        if (o0()) {
            z(bounds, this.h0);
            RectF rectF2 = this.h0;
            float f9 = rectF2.left;
            float f10 = rectF2.top;
            canvas.translate(f9, f10);
            this.G.setBounds(i2, i2, (int) this.h0.width(), (int) this.h0.height());
            this.G.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (n0()) {
            z(bounds, this.h0);
            RectF rectF3 = this.h0;
            float f11 = rectF3.left;
            float f12 = rectF3.top;
            canvas.translate(f11, f12);
            this.S.setBounds(i2, i2, (int) this.h0.width(), (int) this.h0.height());
            this.S.draw(canvas);
            canvas.translate(-f11, -f12);
        }
        if (!this.D0 || this.E == null) {
            i3 = iSaveLayerAlpha;
            i4 = 0;
        } else {
            PointF pointF = this.i0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.E != null) {
                float fA = A() + this.V + this.Y;
                if (a.a.a.a.a.B(this) == 0) {
                    pointF.x = bounds.left + fA;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - fA;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                this.k0.f1754a.getFontMetrics(this.g0);
                Paint.FontMetrics fontMetrics = this.g0;
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF4 = this.h0;
            rectF4.setEmpty();
            if (this.E != null) {
                float fA2 = A() + this.V + this.Y;
                float fD = D() + this.c0 + this.Z;
                if (a.a.a.a.a.B(this) == 0) {
                    rectF4.left = bounds.left + fA2;
                    f = bounds.right - fD;
                } else {
                    rectF4.left = bounds.left + fD;
                    f = bounds.right - fA2;
                }
                rectF4.right = f;
                rectF4.top = bounds.top;
                rectF4.bottom = bounds.bottom;
            }
            h hVar = this.k0;
            if (hVar.f != null) {
                hVar.f1754a.drawableState = getState();
                h hVar2 = this.k0;
                hVar2.f.c(this.d0, hVar2.f1754a, hVar2.f1755b);
            }
            this.k0.f1754a.setTextAlign(align);
            boolean z = Math.round(this.k0.a(this.E.toString())) > Math.round(this.h0.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.h0);
            } else {
                iSave = 0;
            }
            CharSequence charSequenceEllipsize = this.E;
            if (z && this.C0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.k0.f1754a, this.h0.width(), this.C0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF2 = this.i0;
            i4 = 0;
            i3 = iSaveLayerAlpha;
            canvas.drawText(charSequence, 0, length, pointF2.x, pointF2.y, this.k0.f1754a);
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
        if (p0()) {
            B(bounds, this.h0);
            RectF rectF5 = this.h0;
            float f13 = rectF5.left;
            float f14 = rectF5.top;
            canvas.translate(f13, f14);
            this.L.setBounds(i4, i4, (int) this.h0.width(), (int) this.h0.height());
            boolean z2 = c.c.a.b.b0.a.f1545a;
            this.M.setBounds(this.L.getBounds());
            this.M.jumpToCurrentState();
            this.M.draw(canvas);
            canvas.translate(-f13, -f14);
        }
        Paint paint3 = this.f0;
        if (paint3 != null) {
            paint3.setColor(b.i.f.a.c(-16777216, 127));
            canvas.drawRect(bounds, this.f0);
            if (o0() || n0()) {
                z(bounds, this.h0);
                canvas.drawRect(this.h0, this.f0);
            }
            if (this.E != null) {
                i5 = i3;
                i6 = 255;
                canvas.drawLine(bounds.left, bounds.exactCenterY(), bounds.right, bounds.exactCenterY(), this.f0);
            } else {
                i5 = i3;
                i6 = 255;
            }
            if (p0()) {
                B(bounds, this.h0);
                canvas.drawRect(this.h0, this.f0);
            }
            this.f0.setColor(b.i.f.a.c(-65536, 127));
            RectF rectF6 = this.h0;
            rectF6.set(bounds);
            if (p0()) {
                float f15 = this.c0 + this.b0 + this.O + this.a0 + this.Z;
                if (a.a.a.a.a.B(this) == 0) {
                    rectF6.right = bounds.right - f15;
                } else {
                    rectF6.left = bounds.left + f15;
                }
            }
            canvas.drawRect(this.h0, this.f0);
            this.f0.setColor(b.i.f.a.c(-16711936, 127));
            C(bounds, this.h0);
            canvas.drawRect(this.h0, this.f0);
        } else {
            i5 = i3;
            i6 = 255;
        }
        if (this.t0 < i6) {
            canvas.restoreToCount(i5);
        }
    }

    public void e0(boolean z) {
        if (this.K != z) {
            boolean zP0 = p0();
            this.K = z;
            boolean zP02 = p0();
            if (zP0 != zP02) {
                if (zP02) {
                    y(this.L);
                } else {
                    q0(this.L);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void f0(float f) {
        if (this.X != f) {
            float fA = A();
            this.X = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    public void g0(float f) {
        if (this.W != f) {
            float fA = A();
            this.W = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                I();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.t0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.u0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(D() + this.k0.a(this.E.toString()) + A() + this.V + this.Y + this.Z + this.c0), this.E0);
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.F0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.z, this.A);
        } else {
            outline.setRoundRect(bounds, this.A);
        }
        outline.setAlpha(this.t0 / 255.0f);
    }

    public void h0(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            this.A0 = this.z0 ? c.c.a.b.b0.a.a(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void i0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.E, charSequence)) {
            return;
        }
        this.E = charSequence;
        this.k0.d = true;
        invalidateSelf();
        I();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (!G(this.x) && !G(this.y) && !G(this.B) && (!this.z0 || !G(this.A0))) {
            c.c.a.b.a0.b bVar = this.k0.f;
            if (!((bVar == null || (colorStateList = bVar.f1538b) == null || !colorStateList.isStateful()) ? false : true)) {
                if (!(this.R && this.S != null && this.Q) && !H(this.G) && !H(this.S) && !G(this.w0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void j0(c.c.a.b.a0.b bVar) {
        h hVar = this.k0;
        Context context = this.d0;
        if (hVar.f != bVar) {
            hVar.f = bVar;
            if (bVar != null) {
                TextPaint textPaint = hVar.f1754a;
                d dVar = hVar.f1755b;
                bVar.a();
                bVar.d(textPaint, bVar.l);
                bVar.b(context, new c(bVar, textPaint, dVar));
                h.b bVar2 = hVar.e.get();
                if (bVar2 != null) {
                    hVar.f1754a.drawableState = bVar2.getState();
                }
                bVar.c(context, hVar.f1754a, hVar.f1755b);
                hVar.d = true;
            }
            h.b bVar3 = hVar.e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }

    public void k0(float f) {
        if (this.Z != f) {
            this.Z = f;
            invalidateSelf();
            I();
        }
    }

    public void l0(float f) {
        if (this.Y != f) {
            this.Y = f;
            invalidateSelf();
            I();
        }
    }

    public void m0(boolean z) {
        if (this.z0 != z) {
            this.z0 = z;
            this.A0 = z ? c.c.a.b.b0.a.a(this.D) : null;
            onStateChange(getState());
        }
    }

    public final boolean n0() {
        return this.R && this.S != null && this.r0;
    }

    public final boolean o0() {
        return this.F && this.G != null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (o0()) {
            zOnLayoutDirectionChanged |= a.a.a.a.a.o0(this.G, i);
        }
        if (n0()) {
            zOnLayoutDirectionChanged |= a.a.a.a.a.o0(this.S, i);
        }
        if (p0()) {
            zOnLayoutDirectionChanged |= a.a.a.a.a.o0(this.L, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (o0()) {
            zOnLevelChange |= this.G.setLevel(i);
        }
        if (n0()) {
            zOnLevelChange |= this.S.setLevel(i);
        }
        if (p0()) {
            zOnLevelChange |= this.L.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.F0) {
            super.onStateChange(iArr);
        }
        return J(iArr, this.y0);
    }

    public final boolean p0() {
        return this.K && this.L != null;
    }

    public final void q0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.t0 != i) {
            this.t0 = i;
            invalidateSelf();
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.u0 != colorFilter) {
            this.u0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            this.w0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.x0 != mode) {
            this.x0 = mode;
            this.v0 = q.a0(this, this.w0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (o0()) {
            visible |= this.G.setVisible(z, z2);
        }
        if (n0()) {
            visible |= this.S.setVisible(z, z2);
        }
        if (p0()) {
            visible |= this.L.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void y(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        a.a.a.a.a.o0(drawable, a.a.a.a.a.B(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.L) {
            if (drawable.isStateful()) {
                drawable.setState(this.y0);
            }
            drawable.setTintList(this.N);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.G;
        if (drawable == drawable2 && this.J) {
            drawable2.setTintList(this.H);
        }
    }

    public final void z(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (o0() || n0()) {
            float f = this.V + this.W;
            if (a.a.a.a.a.B(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + this.I;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - this.I;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.I;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }
}
