package c.c.a.b.d0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import c.c.a.a.c.l.q;
import c.c.a.b.d0.k;
import c.c.a.b.d0.m;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements b.i.f.k.a, n {
    public static final Paint w = new Paint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f1555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.f[] f1556c;
    public final m.f[] d;
    public boolean e;
    public final Matrix f;
    public final Path g;
    public final Path h;
    public final RectF i;
    public final RectF j;
    public final Region k;
    public final Region l;
    public j m;
    public final Paint n;
    public final Paint o;
    public final c.c.a.b.c0.a p;
    public final k.a q;
    public final k r;
    public PorterDuffColorFilter s;
    public PorterDuffColorFilter t;
    public Rect u;
    public final RectF v;

    public class a implements k.a {
        public a() {
        }
    }

    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f1558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.c.a.b.v.a f1559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f1560c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public b(b bVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1558a = bVar.f1558a;
            this.f1559b = bVar.f1559b;
            this.l = bVar.l;
            this.f1560c = bVar.f1560c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.h = bVar.h;
            this.g = bVar.g;
            this.m = bVar.m;
            this.j = bVar.j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f = bVar.f;
            this.v = bVar.v;
            if (bVar.i != null) {
                this.i = new Rect(bVar.i);
            }
        }

        public b(j jVar, c.c.a.b.v.a aVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1558a = jVar;
            this.f1559b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.e = true;
            return gVar;
        }
    }

    public g() {
        this(new j());
    }

    public g(b bVar) {
        this.f1556c = new m.f[4];
        this.d = new m.f[4];
        this.f = new Matrix();
        this.g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new c.c.a.b.c0.a();
        this.r = new k();
        this.v = new RectF();
        this.f1555b = bVar;
        this.o.setStyle(Paint.Style.STROKE);
        this.n.setStyle(Paint.Style.FILL);
        w.setColor(-1);
        w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        w();
        v(getState());
        this.q = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public static g f(Context context, float f) {
        int iW = q.W(context, c.c.a.b.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.f1555b.f1559b = new c.c.a.b.v.a(context);
        gVar.x();
        gVar.q(ColorStateList.valueOf(iW));
        b bVar = gVar.f1555b;
        if (bVar.o != f) {
            bVar.o = f;
            gVar.x();
        }
        return gVar;
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.f1555b.j != 1.0f) {
            this.f.reset();
            Matrix matrix = this.f;
            float f = this.f1555b.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f);
        }
        path.computeBounds(this.v, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.r;
        b bVar = this.f1555b;
        kVar.a(bVar.f1558a, bVar.k, rectF, this.q, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        int color;
        int iE;
        if (colorStateList == null || mode == null) {
            return (!z || (iE = e((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(iE, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = e(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instruction units count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.d0.g.draw(android.graphics.Canvas):void");
    }

    public final int e(int i) {
        b bVar = this.f1555b;
        float f = bVar.o + bVar.p + bVar.n;
        c.c.a.b.v.a aVar = bVar.f1559b;
        if (aVar == null || !aVar.f1718a) {
            return i;
        }
        if (!(b.i.f.a.c(i, 255) == aVar.f1720c)) {
            return i;
        }
        float fMin = 0.0f;
        if (aVar.d > 0.0f && f > 0.0f) {
            fMin = Math.min(((((float) Math.log1p(f / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return b.i.f.a.c(q.K(b.i.f.a.c(i, 255), aVar.f1719b, fMin), Color.alpha(i));
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (!jVar.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = jVar.f.a(rectF);
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1555b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        b bVar = this.f1555b;
        if (bVar.q == 2) {
            return;
        }
        if (bVar.f1558a.d(h())) {
            outline.setRoundRect(getBounds(), m());
        } else {
            b(h(), this.g);
            if (this.g.isConvex()) {
                outline.setConvexPath(this.g);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.u;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        b(h(), this.g);
        this.l.setPath(this.g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    public RectF h() {
        Rect bounds = getBounds();
        this.i.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        return this.i;
    }

    public final RectF i() {
        RectF rectFH = h();
        float fL = l();
        this.j.set(rectFH.left + fL, rectFH.top + fL, rectFH.right - fL, rectFH.bottom - fL);
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f1555b.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f1555b.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f1555b.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f1555b.d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        return (int) (Math.sin(Math.toRadians(r0.t)) * ((double) this.f1555b.s));
    }

    public int k() {
        return (int) (Math.cos(Math.toRadians(r0.t)) * ((double) this.f1555b.s));
    }

    public final float l() {
        if (n()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float m() {
        return this.f1555b.f1558a.e.a(h());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f1555b = new b(this.f1555b);
        return this;
    }

    public final boolean n() {
        Paint.Style style = this.f1555b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    public void o(Context context) {
        this.f1555b.f1559b = new c.c.a.b.v.a(context);
        x();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = v(iArr) || w();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p(float f) {
        b bVar = this.f1555b;
        if (bVar.o != f) {
            bVar.o = f;
            x();
        }
    }

    public void q(ColorStateList colorStateList) {
        b bVar = this.f1555b;
        if (bVar.d != colorStateList) {
            bVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void r(float f) {
        b bVar = this.f1555b;
        if (bVar.k != f) {
            bVar.k = f;
            this.e = true;
            invalidateSelf();
        }
    }

    public void s(float f, int i) {
        this.f1555b.l = f;
        invalidateSelf();
        u(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        b bVar = this.f1555b;
        if (bVar.m != i) {
            bVar.m = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1555b.f1560c = colorFilter;
        super.invalidateSelf();
    }

    @Override // c.c.a.b.d0.n
    public void setShapeAppearanceModel(j jVar) {
        this.f1555b.f1558a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1555b.g = colorStateList;
        w();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f1555b;
        if (bVar.h != mode) {
            bVar.h = mode;
            w();
            super.invalidateSelf();
        }
    }

    public void t(float f, ColorStateList colorStateList) {
        this.f1555b.l = f;
        invalidateSelf();
        u(colorStateList);
    }

    public void u(ColorStateList colorStateList) {
        b bVar = this.f1555b;
        if (bVar.e != colorStateList) {
            bVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean v(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f1555b.d == null || color2 == (colorForState2 = this.f1555b.d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.f1555b.e == null || color == (colorForState = this.f1555b.e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }

    public final boolean w() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        b bVar = this.f1555b;
        this.s = d(bVar.g, bVar.h, this.n, true);
        b bVar2 = this.f1555b;
        this.t = d(bVar2.f, bVar2.h, this.o, false);
        b bVar3 = this.f1555b;
        if (bVar3.u) {
            this.p.a(bVar3.g.getColorForState(getState(), 0));
        }
        return (Objects.equals(porterDuffColorFilter, this.s) && Objects.equals(porterDuffColorFilter2, this.t)) ? false : true;
    }

    public final void x() {
        b bVar = this.f1555b;
        float f = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil(0.75f * f);
        this.f1555b.s = (int) Math.ceil(f * 0.25f);
        w();
        super.invalidateSelf();
    }
}
