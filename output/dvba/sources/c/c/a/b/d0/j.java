package c.c.a.b.d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import c.c.a.a.c.l.q;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f1564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f1565c;
    public d d;
    public c e;
    public c f;
    public c g;
    public c h;
    public f i;
    public f j;
    public f k;
    public f l;

    public j() {
        this.f1563a = new i();
        this.f1564b = new i();
        this.f1565c = new i();
        this.d = new i();
        this.e = new c.c.a.b.d0.a(0.0f);
        this.f = new c.c.a.b.d0.a(0.0f);
        this.g = new c.c.a.b.d0.a(0.0f);
        this.h = new c.c.a.b.d0.a(0.0f);
        this.i = new f();
        this.j = new f();
        this.k = new f();
        this.l = new f();
    }

    public static b a(Context context, int i, int i2, c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, c.c.a.b.k.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(c.c.a.b.k.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(c.c.a.b.k.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(c.c.a.b.k.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(c.c.a.b.k.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(c.c.a.b.k.ShapeAppearance_cornerFamilyBottomLeft, i3);
            c cVarC = c(typedArrayObtainStyledAttributes, c.c.a.b.k.ShapeAppearance_cornerSize, cVar);
            c cVarC2 = c(typedArrayObtainStyledAttributes, c.c.a.b.k.ShapeAppearance_cornerSizeTopLeft, cVarC);
            c cVarC3 = c(typedArrayObtainStyledAttributes, c.c.a.b.k.ShapeAppearance_cornerSizeTopRight, cVarC);
            c cVarC4 = c(typedArrayObtainStyledAttributes, c.c.a.b.k.ShapeAppearance_cornerSizeBottomRight, cVarC);
            c cVarC5 = c(typedArrayObtainStyledAttributes, c.c.a.b.k.ShapeAppearance_cornerSizeBottomLeft, cVarC);
            b bVar = new b();
            d dVarM = q.m(i4);
            bVar.f1566a = dVarM;
            float fB = b.b(dVarM);
            if (fB != -1.0f) {
                bVar.e(fB);
            }
            bVar.e = cVarC2;
            d dVarM2 = q.m(i5);
            bVar.f1567b = dVarM2;
            float fB2 = b.b(dVarM2);
            if (fB2 != -1.0f) {
                bVar.f(fB2);
            }
            bVar.f = cVarC3;
            d dVarM3 = q.m(i6);
            bVar.f1568c = dVarM3;
            float fB3 = b.b(dVarM3);
            if (fB3 != -1.0f) {
                bVar.d(fB3);
            }
            bVar.g = cVarC4;
            d dVarM4 = q.m(i7);
            bVar.d = dVarM4;
            float fB4 = b.b(dVarM4);
            if (fB4 != -1.0f) {
                bVar.c(fB4);
            }
            bVar.h = cVarC5;
            return bVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i, int i2) {
        c.c.a.b.d0.a aVar = new c.c.a.b.d0.a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.b.k.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(c.c.a.b.k.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i, c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i2 = typedValuePeekValue.type;
        return i2 == 5 ? new c.c.a.b.d0.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new h(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public boolean d(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f1564b instanceof i) && (this.f1563a instanceof i) && (this.f1565c instanceof i) && (this.d instanceof i));
    }

    public j e(float f) {
        b bVar = new b(this);
        bVar.e = new c.c.a.b.d0.a(f);
        bVar.f = new c.c.a.b.d0.a(f);
        bVar.g = new c.c.a.b.d0.a(f);
        bVar.h = new c.c.a.b.d0.a(f);
        return bVar.a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f1566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f1567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f1568c;
        public d d;
        public c e;
        public c f;
        public c g;
        public c h;
        public f i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.f1566a = new i();
            this.f1567b = new i();
            this.f1568c = new i();
            this.d = new i();
            this.e = new c.c.a.b.d0.a(0.0f);
            this.f = new c.c.a.b.d0.a(0.0f);
            this.g = new c.c.a.b.d0.a(0.0f);
            this.h = new c.c.a.b.d0.a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
        }

        public static float b(d dVar) {
            if (dVar instanceof i) {
                return ((i) dVar).f1562a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f1554a;
            }
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b c(float f) {
            this.h = new c.c.a.b.d0.a(f);
            return this;
        }

        public b d(float f) {
            this.g = new c.c.a.b.d0.a(f);
            return this;
        }

        public b e(float f) {
            this.e = new c.c.a.b.d0.a(f);
            return this;
        }

        public b f(float f) {
            this.f = new c.c.a.b.d0.a(f);
            return this;
        }

        public b(j jVar) {
            this.f1566a = new i();
            this.f1567b = new i();
            this.f1568c = new i();
            this.d = new i();
            this.e = new c.c.a.b.d0.a(0.0f);
            this.f = new c.c.a.b.d0.a(0.0f);
            this.g = new c.c.a.b.d0.a(0.0f);
            this.h = new c.c.a.b.d0.a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
            this.f1566a = jVar.f1563a;
            this.f1567b = jVar.f1564b;
            this.f1568c = jVar.f1565c;
            this.d = jVar.d;
            this.e = jVar.e;
            this.f = jVar.f;
            this.g = jVar.g;
            this.h = jVar.h;
            this.i = jVar.i;
            this.j = jVar.j;
            this.k = jVar.k;
            this.l = jVar.l;
        }
    }

    public j(b bVar, a aVar) {
        this.f1563a = bVar.f1566a;
        this.f1564b = bVar.f1567b;
        this.f1565c = bVar.f1568c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
