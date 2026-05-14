package b.u.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class f extends b.u.a.a.e {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f1169c;
    public PorterDuffColorFilter d;
    public ColorFilter e;
    public boolean f;
    public boolean g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    public static class b extends AbstractC0049f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // b.u.a.a.f.AbstractC0049f
        public boolean c() {
            return true;
        }
    }

    public static class c extends AbstractC0049f {
        public int[] e;
        public b.i.e.b.a f;
        public float g;
        public b.i.e.b.a h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.f1175c = cVar.f1175c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // b.u.a.a.f.e
        public boolean a() {
            return this.h.c() || this.f.c();
        }

        @Override // b.u.a.a.f.e
        public boolean b(int[] iArr) {
            return this.f.d(iArr) | this.h.d(iArr);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.h.f726c;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public int getStrokeColor() {
            return this.f.f726c;
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f) {
            this.j = f;
        }

        public void setFillColor(int i) {
            this.h.f726c = i;
        }

        public void setStrokeAlpha(float f) {
            this.i = f;
        }

        public void setStrokeColor(int i) {
            this.f.f726c = i;
        }

        public void setStrokeWidth(float f) {
            this.g = f;
        }

        public void setTrimPathEnd(float f) {
            this.l = f;
        }

        public void setTrimPathOffset(float f) {
            this.m = f;
        }

        public void setTrimPathStart(float f) {
            this.k = f;
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f1170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f1171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1172c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d() {
            super(null);
            this.f1170a = new Matrix();
            this.f1171b = new ArrayList<>();
            this.f1172c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, b.f.a<String, Object> aVar) {
            AbstractC0049f bVar;
            super(null);
            this.f1170a = new Matrix();
            this.f1171b = new ArrayList<>();
            this.f1172c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f1172c = dVar.f1172c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f1171b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f1171b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f1171b.add(bVar);
                    String str2 = bVar.f1174b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // b.u.a.a.f.e
        public boolean a() {
            for (int i = 0; i < this.f1171b.size(); i++) {
                if (this.f1171b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // b.u.a.a.f.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i = 0; i < this.f1171b.size(); i++) {
                zB |= this.f1171b.get(i).b(iArr);
            }
            return zB;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f1172c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f1172c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                c();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                c();
            }
        }

        public void setRotation(float f) {
            if (f != this.f1172c) {
                this.f1172c = f;
                c();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                c();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                c();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                c();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                c();
            }
        }
    }

    public static abstract class e {
        public e() {
        }

        public e(a aVar) {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b.u.a.a.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0049f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b.i.f.c[] f1173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1175c;
        public int d;

        public AbstractC0049f() {
            super(null);
            this.f1173a = null;
            this.f1175c = 0;
        }

        public AbstractC0049f(AbstractC0049f abstractC0049f) {
            super(null);
            this.f1173a = null;
            this.f1175c = 0;
            this.f1174b = abstractC0049f.f1174b;
            this.d = abstractC0049f.d;
            this.f1173a = a.a.a.a.a.x(abstractC0049f.f1173a);
        }

        public boolean c() {
            return false;
        }

        public b.i.f.c[] getPathData() {
            return this.f1173a;
        }

        public String getPathName() {
            return this.f1174b;
        }

        public void setPathData(b.i.f.c[] cVarArr) {
            if (!a.a.a.a.a.e(this.f1173a, cVarArr)) {
                this.f1173a = a.a.a.a.a.x(cVarArr);
                return;
            }
            b.i.f.c[] cVarArr2 = this.f1173a;
            for (int i = 0; i < cVarArr.length; i++) {
                cVarArr2[i].f746a = cVarArr[i].f746a;
                for (int i2 = 0; i2 < cVarArr[i].f747b.length; i2++) {
                    cVarArr2[i].f747b[i2] = cVarArr[i].f747b[i2];
                }
            }
        }
    }

    public static class g {
        public static final Matrix q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f1176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f1177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f1178c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public int g;
        public final d h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final b.f.a<String, Object> p;

        public g() {
            this.f1178c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new b.f.a<>();
            this.h = new d();
            this.f1176a = new Path();
            this.f1177b = new Path();
        }

        public g(g gVar) {
            this.f1178c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            b.f.a<String, Object> aVar = new b.f.a<>();
            this.p = aVar;
            this.h = new d(gVar.h, aVar);
            this.f1176a = new Path(gVar.f1176a);
            this.f1177b = new Path(gVar.f1177b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v11 */
        public final void a(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            g gVar;
            g gVar2 = this;
            dVar.f1170a.set(matrix);
            dVar.f1170a.preConcat(dVar.j);
            canvas.save();
            ?? r11 = 0;
            int i3 = 0;
            while (i3 < dVar.f1171b.size()) {
                e eVar = dVar.f1171b.get(i3);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.f1170a, canvas, i, i2, colorFilter);
                } else {
                    if (eVar instanceof AbstractC0049f) {
                        AbstractC0049f abstractC0049f = (AbstractC0049f) eVar;
                        float f = i / gVar2.k;
                        float f2 = i2 / gVar2.l;
                        float fMin = Math.min(f, f2);
                        Matrix matrix2 = dVar.f1170a;
                        gVar2.f1178c.set(matrix2);
                        gVar2.f1178c.postScale(f, f2);
                        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float fHypot = (float) Math.hypot(fArr[r11], fArr[1]);
                        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                        float f3 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                        float fMax = Math.max(fHypot, fHypot2);
                        float fAbs = fMax > 0.0f ? Math.abs(f3) / fMax : 0.0f;
                        if (fAbs == 0.0f) {
                            gVar = this;
                        } else {
                            gVar = this;
                            Path path = gVar.f1176a;
                            if (abstractC0049f == null) {
                                throw null;
                            }
                            path.reset();
                            b.i.f.c[] cVarArr = abstractC0049f.f1173a;
                            if (cVarArr != null) {
                                b.i.f.c.b(cVarArr, path);
                            }
                            Path path2 = gVar.f1176a;
                            gVar.f1177b.reset();
                            if (abstractC0049f.c()) {
                                gVar.f1177b.setFillType(abstractC0049f.f1175c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                gVar.f1177b.addPath(path2, gVar.f1178c);
                                canvas.clipPath(gVar.f1177b);
                            } else {
                                c cVar = (c) abstractC0049f;
                                if (cVar.k != 0.0f || cVar.l != 1.0f) {
                                    float f4 = cVar.k;
                                    float f5 = cVar.m;
                                    float f6 = (f4 + f5) % 1.0f;
                                    float f7 = (cVar.l + f5) % 1.0f;
                                    if (gVar.f == null) {
                                        gVar.f = new PathMeasure();
                                    }
                                    gVar.f.setPath(gVar.f1176a, r11);
                                    float length = gVar.f.getLength();
                                    float f8 = f6 * length;
                                    float f9 = f7 * length;
                                    path2.reset();
                                    if (f8 > f9) {
                                        gVar.f.getSegment(f8, length, path2, true);
                                        gVar.f.getSegment(0.0f, f9, path2, true);
                                    } else {
                                        gVar.f.getSegment(f8, f9, path2, true);
                                    }
                                    path2.rLineTo(0.0f, 0.0f);
                                }
                                gVar.f1177b.addPath(path2, gVar.f1178c);
                                b.i.e.b.a aVar = cVar.h;
                                if (aVar.b() || aVar.f726c != 0) {
                                    b.i.e.b.a aVar2 = cVar.h;
                                    if (gVar.e == null) {
                                        Paint paint = new Paint(1);
                                        gVar.e = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    }
                                    Paint paint2 = gVar.e;
                                    if (aVar2.b()) {
                                        Shader shader = aVar2.f724a;
                                        shader.setLocalMatrix(gVar.f1178c);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(cVar.j * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        paint2.setColor(f.a(aVar2.f726c, cVar.j));
                                    }
                                    paint2.setColorFilter(colorFilter);
                                    gVar.f1177b.setFillType(cVar.f1175c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(gVar.f1177b, paint2);
                                }
                                b.i.e.b.a aVar3 = cVar.f;
                                if (aVar3.b() || aVar3.f726c != 0) {
                                    b.i.e.b.a aVar4 = cVar.f;
                                    if (gVar.d == null) {
                                        Paint paint3 = new Paint(1);
                                        gVar.d = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = gVar.d;
                                    Paint.Join join = cVar.o;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = cVar.n;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(cVar.p);
                                    if (aVar4.b()) {
                                        Shader shader2 = aVar4.f724a;
                                        shader2.setLocalMatrix(gVar.f1178c);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(cVar.i * 255.0f));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        paint4.setColor(f.a(aVar4.f726c, cVar.i));
                                    }
                                    paint4.setColorFilter(colorFilter);
                                    paint4.setStrokeWidth(cVar.g * fAbs * fMin);
                                    canvas.drawPath(gVar.f1177b, paint4);
                                }
                            }
                        }
                    }
                    i3++;
                    gVar2 = gVar;
                    r11 = 0;
                }
                gVar = gVar2;
                i3++;
                gVar2 = gVar;
                r11 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f1180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f1181c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h() {
            this.f1181c = null;
            this.d = f.k;
            this.f1180b = new g();
        }

        public h(h hVar) {
            this.f1181c = null;
            this.d = f.k;
            if (hVar != null) {
                this.f1179a = hVar.f1179a;
                g gVar = new g(hVar.f1180b);
                this.f1180b = gVar;
                if (hVar.f1180b.e != null) {
                    gVar.e = new Paint(hVar.f1180b.e);
                }
                if (hVar.f1180b.d != null) {
                    this.f1180b.d = new Paint(hVar.f1180b.d);
                }
                this.f1181c = hVar.f1181c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public boolean a() {
            g gVar = this.f1180b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i, int i2) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            g gVar = this.f1180b;
            gVar.a(gVar.h, g.q, canvas, i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1179a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f1182a;

        public i(Drawable.ConstantState constantState) {
            this.f1182a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1182a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1182a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f1168b = (VectorDrawable) this.f1182a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f1168b = (VectorDrawable) this.f1182a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f1168b = (VectorDrawable) this.f1182a.newDrawable(resources, theme);
            return fVar;
        }
    }

    public f() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1169c = new h();
    }

    public f(h hVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1169c = hVar;
        this.d = d(hVar.f1181c, hVar.d);
    }

    public static int a(int i2, float f) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f)) << 24);
    }

    public static f b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            f fVar = new f();
            fVar.f1168b = resources.getDrawable(i2, theme);
            new i(fVar.f1168b.getConstantState());
            return fVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static f c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1168b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    public PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.u.a.a.f.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getAlpha() : this.f1169c.f1180b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1169c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getColorFilter() : this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1168b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f1168b.getConstantState());
        }
        this.f1169c.f1179a = getChangingConfigurations();
        return this.f1169c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1169c.f1180b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1169c.f1180b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ColorStateList colorStateListS;
        g gVar;
        int i2;
        ArrayDeque arrayDeque;
        g gVar2;
        d dVar;
        c cVar;
        TypedArray typedArray;
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f1169c;
        hVar.f1180b = new g();
        TypedArray typedArrayA0 = a.a.a.a.a.a0(resources, theme, attributeSet, b.u.a.a.a.f1157a);
        h hVar2 = this.f1169c;
        g gVar3 = hVar2.f1180b;
        int iF = a.a.a.a.a.F(typedArrayA0, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i3 = 3;
        if (iF == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (iF != 5) {
            if (iF != 9) {
                switch (iF) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        hVar2.d = mode;
        int i4 = 1;
        if (a.a.a.a.a.N(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayA0.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i5 < 28 || i5 > 31) {
                Resources resources2 = typedArrayA0.getResources();
                try {
                    colorStateListS = a.a.a.a.a.s(resources2, resources2.getXml(typedArrayA0.getResourceId(1, 0)), theme);
                } catch (Exception e2) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
                    colorStateListS = null;
                }
            } else {
                colorStateListS = ColorStateList.valueOf(typedValue.data);
            }
        } else {
            colorStateListS = null;
        }
        if (colorStateListS != null) {
            hVar2.f1181c = colorStateListS;
        }
        boolean z = hVar2.e;
        if (a.a.a.a.a.N(xmlPullParser, "autoMirrored")) {
            z = typedArrayA0.getBoolean(5, z);
        }
        hVar2.e = z;
        gVar3.k = a.a.a.a.a.E(typedArrayA0, xmlPullParser, "viewportWidth", 7, gVar3.k);
        float fE = a.a.a.a.a.E(typedArrayA0, xmlPullParser, "viewportHeight", 8, gVar3.l);
        gVar3.l = fE;
        if (gVar3.k <= 0.0f) {
            throw new XmlPullParserException(typedArrayA0.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fE <= 0.0f) {
            throw new XmlPullParserException(typedArrayA0.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar3.i = typedArrayA0.getDimension(3, gVar3.i);
        float dimension = typedArrayA0.getDimension(2, gVar3.j);
        gVar3.j = dimension;
        if (gVar3.i <= 0.0f) {
            throw new XmlPullParserException(typedArrayA0.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayA0.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar3.setAlpha(a.a.a.a.a.E(typedArrayA0, xmlPullParser, "alpha", 4, gVar3.getAlpha()));
        String string = typedArrayA0.getString(0);
        if (string != null) {
            gVar3.n = string;
            gVar3.p.put(string, gVar3);
        }
        typedArrayA0.recycle();
        hVar.f1179a = getChangingConfigurations();
        hVar.k = true;
        h hVar3 = this.f1169c;
        g gVar4 = hVar3.f1180b;
        ArrayDeque arrayDeque2 = new ArrayDeque();
        arrayDeque2.push(gVar4.h);
        int eventType = xmlPullParser.getEventType();
        boolean z2 = true;
        for (int depth = xmlPullParser.getDepth() + 1; eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != i3); depth = i2) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar2 = (d) arrayDeque2.peek();
                if ("path".equals(name)) {
                    c cVar2 = new c();
                    TypedArray typedArrayA02 = a.a.a.a.a.a0(resources, theme, attributeSet, b.u.a.a.a.f1159c);
                    cVar2.e = null;
                    if (a.a.a.a.a.N(xmlPullParser, "pathData")) {
                        String string2 = typedArrayA02.getString(0);
                        if (string2 != null) {
                            cVar2.f1174b = string2;
                        }
                        String string3 = typedArrayA02.getString(2);
                        if (string3 != null) {
                            cVar2.f1173a = a.a.a.a.a.v(string3);
                        }
                        arrayDeque = arrayDeque2;
                        gVar2 = gVar4;
                        i2 = depth;
                        dVar = dVar2;
                        cVar = cVar2;
                        cVar.h = a.a.a.a.a.D(typedArrayA02, xmlPullParser, theme, "fillColor", 1, 0);
                        cVar.j = a.a.a.a.a.E(typedArrayA02, xmlPullParser, "fillAlpha", 12, cVar.j);
                        int iF2 = a.a.a.a.a.F(typedArrayA02, xmlPullParser, "strokeLineCap", 8, -1);
                        Paint.Cap cap = cVar.n;
                        if (iF2 == 0) {
                            cap = Paint.Cap.BUTT;
                        } else if (iF2 == 1) {
                            cap = Paint.Cap.ROUND;
                        } else if (iF2 == 2) {
                            cap = Paint.Cap.SQUARE;
                        }
                        cVar.n = cap;
                        int iF3 = a.a.a.a.a.F(typedArrayA02, xmlPullParser, "strokeLineJoin", 9, -1);
                        Paint.Join join = cVar.o;
                        if (iF3 == 0) {
                            join = Paint.Join.MITER;
                        } else if (iF3 == 1) {
                            join = Paint.Join.ROUND;
                        } else if (iF3 == 2) {
                            join = Paint.Join.BEVEL;
                        }
                        cVar.o = join;
                        cVar.p = a.a.a.a.a.E(typedArrayA02, xmlPullParser, "strokeMiterLimit", 10, cVar.p);
                        typedArray = typedArrayA02;
                        cVar.f = a.a.a.a.a.D(typedArrayA02, xmlPullParser, theme, "strokeColor", 3, 0);
                        cVar.i = a.a.a.a.a.E(typedArray, xmlPullParser, "strokeAlpha", 11, cVar.i);
                        cVar.g = a.a.a.a.a.E(typedArray, xmlPullParser, "strokeWidth", 4, cVar.g);
                        cVar.l = a.a.a.a.a.E(typedArray, xmlPullParser, "trimPathEnd", 6, cVar.l);
                        cVar.m = a.a.a.a.a.E(typedArray, xmlPullParser, "trimPathOffset", 7, cVar.m);
                        cVar.k = a.a.a.a.a.E(typedArray, xmlPullParser, "trimPathStart", 5, cVar.k);
                        cVar.f1175c = a.a.a.a.a.F(typedArray, xmlPullParser, "fillType", 13, cVar.f1175c);
                    } else {
                        arrayDeque = arrayDeque2;
                        gVar2 = gVar4;
                        typedArray = typedArrayA02;
                        cVar = cVar2;
                        i2 = depth;
                        dVar = dVar2;
                    }
                    typedArray.recycle();
                    dVar.f1171b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar = gVar2;
                        gVar.p.put(cVar.getPathName(), cVar);
                    } else {
                        gVar = gVar2;
                    }
                    hVar3.f1179a |= cVar.d;
                    arrayDeque2 = arrayDeque;
                    z2 = false;
                } else {
                    ArrayDeque arrayDeque3 = arrayDeque2;
                    gVar = gVar4;
                    i2 = depth;
                    if ("clip-path".equals(name)) {
                        b bVar = new b();
                        if (a.a.a.a.a.N(xmlPullParser, "pathData")) {
                            TypedArray typedArrayA03 = a.a.a.a.a.a0(resources, theme, attributeSet, b.u.a.a.a.d);
                            String string4 = typedArrayA03.getString(0);
                            if (string4 != null) {
                                bVar.f1174b = string4;
                            }
                            String string5 = typedArrayA03.getString(1);
                            if (string5 != null) {
                                bVar.f1173a = a.a.a.a.a.v(string5);
                            }
                            bVar.f1175c = a.a.a.a.a.F(typedArrayA03, xmlPullParser, "fillType", 2, 0);
                            typedArrayA03.recycle();
                        }
                        dVar2.f1171b.add(bVar);
                        if (bVar.getPathName() != null) {
                            gVar.p.put(bVar.getPathName(), bVar);
                        }
                        hVar3.f1179a = bVar.d | hVar3.f1179a;
                    } else if ("group".equals(name)) {
                        d dVar3 = new d();
                        TypedArray typedArrayA04 = a.a.a.a.a.a0(resources, theme, attributeSet, b.u.a.a.a.f1158b);
                        dVar3.l = null;
                        dVar3.f1172c = a.a.a.a.a.E(typedArrayA04, xmlPullParser, "rotation", 5, dVar3.f1172c);
                        dVar3.d = typedArrayA04.getFloat(1, dVar3.d);
                        dVar3.e = typedArrayA04.getFloat(2, dVar3.e);
                        dVar3.f = a.a.a.a.a.E(typedArrayA04, xmlPullParser, "scaleX", 3, dVar3.f);
                        dVar3.g = a.a.a.a.a.E(typedArrayA04, xmlPullParser, "scaleY", 4, dVar3.g);
                        dVar3.h = a.a.a.a.a.E(typedArrayA04, xmlPullParser, "translateX", 6, dVar3.h);
                        dVar3.i = a.a.a.a.a.E(typedArrayA04, xmlPullParser, "translateY", 7, dVar3.i);
                        String string6 = typedArrayA04.getString(0);
                        if (string6 != null) {
                            dVar3.m = string6;
                        }
                        dVar3.c();
                        typedArrayA04.recycle();
                        dVar2.f1171b.add(dVar3);
                        arrayDeque2 = arrayDeque3;
                        arrayDeque2.push(dVar3);
                        if (dVar3.getGroupName() != null) {
                            gVar.p.put(dVar3.getGroupName(), dVar3);
                        }
                        hVar3.f1179a = dVar3.k | hVar3.f1179a;
                    }
                    arrayDeque2 = arrayDeque3;
                }
            } else {
                gVar = gVar4;
                i2 = depth;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque2.pop();
                }
            }
            eventType = xmlPullParser.next();
            i3 = 3;
            i4 = 1;
            gVar4 = gVar;
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
        this.d = d(hVar.f1181c, hVar.d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.isAutoMirrored() : this.f1169c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f1169c) != null && (hVar.a() || ((colorStateList = this.f1169c.f1181c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f1169c = new h(this.f1169c);
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f1169c;
        ColorStateList colorStateList = hVar.f1181c;
        if (colorStateList != null && (mode = hVar.d) != null) {
            this.d = d(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean zB = hVar.f1180b.h.b(iArr);
            hVar.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f1169c.f1180b.getRootAlpha() != i2) {
            this.f1169c.f1180b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f1169c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.t0(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.u0(drawable, colorStateList);
            return;
        }
        h hVar = this.f1169c;
        if (hVar.f1181c != colorStateList) {
            hVar.f1181c = colorStateList;
            this.d = d(colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            a.a.a.a.a.v0(drawable, mode);
            return;
        }
        h hVar = this.f1169c;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.d = d(hVar.f1181c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1168b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1168b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
