package c.c.a.b.y;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import b.i.k.d;
import b.i.m.l;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final Paint Q = null;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int[] G;
    public boolean H;
    public TimeInterpolator K;
    public TimeInterpolator L;
    public float M;
    public float N;
    public float O;
    public ColorStateList P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f1741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1743c;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public c.c.a.b.a0.a v;
    public CharSequence w;
    public CharSequence x;
    public boolean y;
    public boolean z;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public final TextPaint I = new TextPaint(129);
    public final TextPaint J = new TextPaint(this.I);
    public final Rect e = new Rect();
    public final Rect d = new Rect();
    public final RectF f = new RectF();

    static {
        Paint paint = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            Q.setColor(-65281);
        }
    }

    public c(View view) {
        this.f1741a = view;
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), (int) ((Color.red(i2) * f) + (Color.red(i) * f2)), (int) ((Color.green(i2) * f) + (Color.green(i) * f2)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float i(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return c.c.a.b.l.a.a(f, f2, f3);
    }

    public static boolean l(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public float b() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.J;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        TextPaint textPaint2 = this.J;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        return ((d.c) (l.r(this.f1741a) == 1 ? b.i.k.d.d : b.i.k.d.f807c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f) {
        TextPaint textPaint;
        int iG;
        this.f.left = i(this.d.left, this.e.left, f, this.K);
        this.f.top = i(this.m, this.n, f, this.K);
        this.f.right = i(this.d.right, this.e.right, f, this.K);
        this.f.bottom = i(this.d.bottom, this.e.bottom, f, this.K);
        this.q = i(this.o, this.p, f, this.K);
        this.r = i(this.m, this.n, f, this.K);
        o(i(this.i, this.j, f, this.L));
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint = this.I;
            iG = a(h(colorStateList2), g(), f);
        } else {
            textPaint = this.I;
            iG = g();
        }
        textPaint.setColor(iG);
        this.I.setShadowLayer(i(0.0f, this.M, f, null), i(0.0f, this.N, f, null), i(0.0f, this.O, f, null), a(h(null), h(this.P), f));
        l.O(this.f1741a);
    }

    public final void e(float f) {
        boolean z;
        float f2;
        if (this.w == null) {
            return;
        }
        float fWidth = this.e.width();
        float fWidth2 = this.d.width();
        if (Math.abs(f - this.j) < 0.001f) {
            f2 = this.j;
            this.E = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z = true;
            } else {
                z = false;
            }
        } else {
            float f3 = this.i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (Math.abs(f - this.i) < 0.001f) {
                this.E = 1.0f;
            } else {
                this.E = f / this.i;
            }
            float f4 = this.j / this.i;
            fWidth = fWidth2 * f4 > fWidth ? Math.min(fWidth / f4, fWidth2) : fWidth2;
            f2 = f3;
        }
        if (fWidth > 0.0f) {
            z = this.F != f2 || this.H || z;
            this.F = f2;
            this.H = false;
        }
        if (this.x == null || z) {
            this.I.setTextSize(this.F);
            this.I.setTypeface(this.u);
            this.I.setLinearText(this.E != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.w, this.I, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.x)) {
                return;
            }
            this.x = charSequenceEllipsize;
            this.y = c(charSequenceEllipsize);
        }
    }

    public float f() {
        TextPaint textPaint = this.J;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        return -this.J.ascent();
    }

    public int g() {
        return h(this.l);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.G;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void j() {
        this.f1742b = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.y.c.k():void");
    }

    public void m(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            k();
        }
    }

    public void n(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f1743c) {
            this.f1743c = f;
            d(f);
        }
    }

    public final void o(float f) {
        e(f);
        this.z = false;
        if (0 != 0 && this.A == null && !this.d.isEmpty() && !TextUtils.isEmpty(this.x)) {
            d(0.0f);
            this.C = this.I.ascent();
            this.D = this.I.descent();
            TextPaint textPaint = this.I;
            CharSequence charSequence = this.x;
            int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int iRound2 = Math.round(this.D - this.C);
            if (iRound > 0 && iRound2 > 0) {
                this.A = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.A);
                CharSequence charSequence2 = this.x;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.I.descent(), this.I);
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
        l.O(this.f1741a);
    }

    public void p(Typeface typeface) {
        boolean z;
        c.c.a.b.a0.a aVar = this.v;
        boolean z2 = true;
        if (aVar != null) {
            aVar.f1536c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z = true;
        } else {
            z = false;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            k();
        }
    }
}
