package b.b.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import b.b.p.n0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f297a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0008a>> f298b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f299c = new Object();

    /* JADX INFO: renamed from: b.b.l.a.a$a, reason: collision with other inner class name */
    public static class C0008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f301b;

        public C0008a(ColorStateList colorStateList, Configuration configuration) {
            this.f300a = colorStateList;
            this.f301b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        ColorStateList colorStateListS;
        ColorStateList colorStateList;
        C0008a c0008a;
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        synchronized (f299c) {
            SparseArray<C0008a> sparseArray = f298b.get(context);
            colorStateListS = null;
            if (sparseArray == null || sparseArray.size() <= 0 || (c0008a = sparseArray.get(i)) == null) {
                colorStateList = null;
            } else if (c0008a.f301b.equals(context.getResources().getConfiguration())) {
                colorStateList = c0008a.f300a;
            } else {
                sparseArray.remove(i);
                colorStateList = null;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        Resources resources = context.getResources();
        TypedValue typedValue = f297a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f297a.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (!(i2 >= 28 && i2 <= 31)) {
            Resources resources2 = context.getResources();
            try {
                colorStateListS = a.a.a.a.a.s(resources2, resources2.getXml(i), context.getTheme());
            } catch (Exception e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateListS == null) {
            return b.i.e.a.b(context, i);
        }
        synchronized (f299c) {
            SparseArray<C0008a> sparseArray2 = f298b.get(context);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray<>();
                f298b.put(context, sparseArray2);
            }
            sparseArray2.append(i, new C0008a(colorStateListS, context.getResources().getConfiguration()));
        }
        return colorStateListS;
    }

    public static Drawable b(Context context, int i) {
        return n0.d().f(context, i);
    }
}
