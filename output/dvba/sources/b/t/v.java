package b.t;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f1155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f1156b;

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(v.b(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            float fFloatValue = f.floatValue();
            v.f1155a.e(view, fFloatValue);
        }
    }

    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect get(View view) {
            return b.i.m.l.k(view);
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            b.i.m.l.a0(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f1155a = i >= 29 ? new a0() : i >= 23 ? new z() : i >= 22 ? new y() : new x();
        f1156b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    public static u a(View view) {
        return new t(view);
    }

    public static float b(View view) {
        return f1155a.b(view);
    }

    public static f0 c(View view) {
        return new e0(view);
    }

    public static void d(View view, int i, int i2, int i3, int i4) {
        f1155a.d(view, i, i2, i3, i4);
    }
}
