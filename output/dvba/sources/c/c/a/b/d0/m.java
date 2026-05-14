package c.c.a.b.d0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f1574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f1575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f1576c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;
    public final List<e> g = new ArrayList();
    public final List<f> h = new ArrayList();

    public static class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f1577b;

        public a(c cVar) {
            this.f1577b = cVar;
        }

        @Override // c.c.a.b.d0.m.f
        public void a(Matrix matrix, c.c.a.b.c0.a aVar, int i, Canvas canvas) {
            c cVar = this.f1577b;
            float f = cVar.f;
            float f2 = cVar.g;
            c cVar2 = this.f1577b;
            RectF rectF = new RectF(cVar2.f1580b, cVar2.f1581c, cVar2.d, cVar2.e);
            boolean z = f2 < 0.0f;
            Path path = aVar.g;
            if (z) {
                int[] iArr = c.c.a.b.c0.a.j;
                iArr[0] = 0;
                iArr[1] = aVar.f;
                iArr[2] = aVar.e;
                iArr[3] = aVar.d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -i;
                rectF.inset(f3, f3);
                int[] iArr2 = c.c.a.b.c0.a.j;
                iArr2[0] = 0;
                iArr2[1] = aVar.d;
                iArr2[2] = aVar.e;
                iArr2[3] = aVar.f;
            }
            float fWidth = 1.0f - (i / (rectF.width() / 2.0f));
            float[] fArr = c.c.a.b.c0.a.k;
            fArr[1] = fWidth;
            fArr[2] = ((1.0f - fWidth) / 2.0f) + fWidth;
            aVar.f1549b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, c.c.a.b.c0.a.j, c.c.a.b.c0.a.k, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
            }
            canvas.drawArc(rectF, f, f2, true, aVar.f1549b);
            canvas.restore();
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f1578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1579c;
        public final float d;

        public b(d dVar, float f, float f2) {
            this.f1578b = dVar;
            this.f1579c = f;
            this.d = f2;
        }

        @Override // c.c.a.b.d0.m.f
        public void a(Matrix matrix, c.c.a.b.c0.a aVar, int i, Canvas canvas) {
            d dVar = this.f1578b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(dVar.f1583c - this.d, dVar.f1582b - this.f1579c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f1579c, this.d);
            matrix2.preRotate(b());
            if (aVar == null) {
                throw null;
            }
            rectF.bottom += i;
            rectF.offset(0.0f, -i);
            int[] iArr = c.c.a.b.c0.a.h;
            iArr[0] = aVar.f;
            iArr[1] = aVar.e;
            iArr[2] = aVar.d;
            Paint paint = aVar.f1550c;
            float f = rectF.left;
            paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, c.c.a.b.c0.a.h, c.c.a.b.c0.a.i, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.f1550c);
            canvas.restore();
        }

        public float b() {
            d dVar = this.f1578b;
            return (float) Math.toDegrees(Math.atan((dVar.f1583c - this.d) / (dVar.f1582b - this.f1579c)));
        }
    }

    public static class c extends e {
        public static final RectF h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f1580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f1581c;

        @Deprecated
        public float d;

        @Deprecated
        public float e;

        @Deprecated
        public float f;

        @Deprecated
        public float g;

        public c(float f, float f2, float f3, float f4) {
            this.f1580b = f;
            this.f1581c = f2;
            this.d = f3;
            this.e = f4;
        }

        @Override // c.c.a.b.d0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1584a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.f1580b, this.f1581c, this.d, this.e);
            path.arcTo(h, this.f, this.g, false);
            path.transform(matrix);
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1583c;

        @Override // c.c.a.b.d0.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1584a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1582b, this.f1583c);
            path.transform(matrix);
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f1584a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Matrix f1585a = new Matrix();

        public abstract void a(Matrix matrix, c.c.a.b.c0.a aVar, int i, Canvas canvas);
    }

    public m() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f = f6;
        cVar.g = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.e = f9;
        double d2 = f8;
        this.f1576c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.e;
        if (f3 == f2) {
            return;
        }
        float f4 = ((f2 - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f1576c;
        float f6 = this.d;
        c cVar = new c(f5, f6, f5, f6);
        cVar.f = this.e;
        cVar.g = f4;
        this.h.add(new a(cVar));
        this.e = f2;
    }

    public void c(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.f1582b = f2;
        dVar.f1583c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.f1576c, this.d);
        float fB = bVar.b() + 270.0f;
        float fB2 = bVar.b() + 270.0f;
        b(fB);
        this.h.add(bVar);
        this.e = fB2;
        this.f1576c = f2;
        this.d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.f1574a = f2;
        this.f1575b = f3;
        this.f1576c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
