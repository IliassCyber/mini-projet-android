package c.c.a.b.d0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c.c.a.b.d0.m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m[] f1569a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f1570b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f1571c = new Matrix[4];
    public final PointF d = new PointF();
    public final m e = new m();
    public final float[] f = new float[2];
    public final float[] g = new float[2];

    public interface a {
    }

    public k() {
        for (int i = 0; i < 4; i++) {
            this.f1569a[i] = new m();
            this.f1570b[i] = new Matrix();
            this.f1571c[i] = new Matrix();
        }
    }

    public void a(j jVar, float f, RectF rectF, a aVar, Path path) {
        float fCenterX;
        float f2;
        float f3;
        float f4;
        path.rewind();
        char c2 = 0;
        int i = 0;
        while (i < 4) {
            c cVar = i != 1 ? i != 2 ? i != 3 ? jVar.f : jVar.e : jVar.h : jVar.g;
            d dVar = i != 1 ? i != 2 ? i != 3 ? jVar.f1564b : jVar.f1563a : jVar.d : jVar.f1565c;
            m mVar = this.f1569a[i];
            if (dVar == null) {
                throw null;
            }
            dVar.a(mVar, 90.0f, f, cVar.a(rectF));
            int i2 = i + 1;
            float f5 = i2 * 90;
            this.f1570b[i].reset();
            PointF pointF = this.d;
            if (i == 1) {
                f3 = rectF.right;
            } else if (i != 2) {
                f3 = i != 3 ? rectF.right : rectF.left;
                f4 = rectF.top;
                pointF.set(f3, f4);
                Matrix matrix = this.f1570b[i];
                PointF pointF2 = this.d;
                matrix.setTranslate(pointF2.x, pointF2.y);
                this.f1570b[i].preRotate(f5);
                float[] fArr = this.f;
                m[] mVarArr = this.f1569a;
                fArr[0] = mVarArr[i].f1576c;
                fArr[1] = mVarArr[i].d;
                this.f1570b[i].mapPoints(fArr);
                this.f1571c[i].reset();
                Matrix matrix2 = this.f1571c[i];
                float[] fArr2 = this.f;
                matrix2.setTranslate(fArr2[0], fArr2[1]);
                this.f1571c[i].preRotate(f5);
                i = i2;
            } else {
                f3 = rectF.left;
            }
            f4 = rectF.bottom;
            pointF.set(f3, f4);
            Matrix matrix3 = this.f1570b[i];
            PointF pointF22 = this.d;
            matrix3.setTranslate(pointF22.x, pointF22.y);
            this.f1570b[i].preRotate(f5);
            float[] fArr3 = this.f;
            m[] mVarArr2 = this.f1569a;
            fArr3[0] = mVarArr2[i].f1576c;
            fArr3[1] = mVarArr2[i].d;
            this.f1570b[i].mapPoints(fArr3);
            this.f1571c[i].reset();
            Matrix matrix22 = this.f1571c[i];
            float[] fArr22 = this.f;
            matrix22.setTranslate(fArr22[0], fArr22[1]);
            this.f1571c[i].preRotate(f5);
            i = i2;
        }
        int i3 = 0;
        while (i3 < 4) {
            float[] fArr4 = this.f;
            m[] mVarArr3 = this.f1569a;
            fArr4[c2] = mVarArr3[i3].f1574a;
            fArr4[1] = mVarArr3[i3].f1575b;
            this.f1570b[i3].mapPoints(fArr4);
            float[] fArr5 = this.f;
            if (i3 == 0) {
                path.moveTo(fArr5[c2], fArr5[1]);
            } else {
                path.lineTo(fArr5[c2], fArr5[1]);
            }
            this.f1569a[i3].c(this.f1570b[i3], path);
            if (aVar != null) {
                m mVar2 = this.f1569a[i3];
                Matrix matrix4 = this.f1570b[i3];
                m.f[] fVarArr = g.this.f1556c;
                mVar2.b(mVar2.f);
                fVarArr[i3] = new l(mVar2, new ArrayList(mVar2.h), matrix4);
            }
            int i4 = i3 + 1;
            int i5 = i4 % 4;
            float[] fArr6 = this.f;
            m[] mVarArr4 = this.f1569a;
            fArr6[c2] = mVarArr4[i3].f1576c;
            fArr6[1] = mVarArr4[i3].d;
            this.f1570b[i3].mapPoints(fArr6);
            float[] fArr7 = this.g;
            m[] mVarArr5 = this.f1569a;
            fArr7[c2] = mVarArr5[i5].f1574a;
            fArr7[1] = mVarArr5[i5].f1575b;
            this.f1570b[i5].mapPoints(fArr7);
            float f6 = this.f[c2];
            float[] fArr8 = this.g;
            float fMax = Math.max(((float) Math.hypot(f6 - fArr8[c2], r12[1] - fArr8[1])) - 0.001f, 0.0f);
            float[] fArr9 = this.f;
            m[] mVarArr6 = this.f1569a;
            fArr9[c2] = mVarArr6[i3].f1576c;
            fArr9[1] = mVarArr6[i3].d;
            this.f1570b[i3].mapPoints(fArr9);
            if (i3 == 1 || i3 == 3) {
                fCenterX = rectF.centerX();
                f2 = this.f[c2];
            } else {
                fCenterX = rectF.centerY();
                f2 = this.f[1];
            }
            float fAbs = Math.abs(fCenterX - f2);
            this.e.e(0.0f, 0.0f, 270.0f, 0.0f);
            (i3 != 1 ? i3 != 2 ? i3 != 3 ? jVar.j : jVar.i : jVar.l : jVar.k).a(fMax, fAbs, f, this.e);
            this.e.c(this.f1571c[i3], path);
            if (aVar != null) {
                m mVar3 = this.e;
                Matrix matrix5 = this.f1571c[i3];
                m.f[] fVarArr2 = g.this.d;
                mVar3.b(mVar3.f);
                fVarArr2[i3] = new l(mVar3, new ArrayList(mVar3.h), matrix5);
            }
            i3 = i4;
            c2 = 0;
        }
        path.close();
    }
}
