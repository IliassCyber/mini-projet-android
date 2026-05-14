package b.i.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.f.f<String, Typeface> f749b;

    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto Lc
            b.i.f.i r0 = new b.i.f.i
            r0.<init>()
            goto L43
        Lc:
            r1 = 28
            if (r0 < r1) goto L16
            b.i.f.h r0 = new b.i.f.h
            r0.<init>()
            goto L43
        L16:
            r1 = 26
            if (r0 < r1) goto L20
            b.i.f.g r0 = new b.i.f.g
            r0.<init>()
            goto L43
        L20:
            r1 = 24
            if (r0 < r1) goto L3e
            java.lang.reflect.Method r0 = b.i.f.f.d
            if (r0 != 0) goto L2f
            java.lang.String r0 = "TypefaceCompatApi24Impl"
            java.lang.String r1 = "Unable to collect necessary private methods.Fallback to legacy implementation."
            android.util.Log.w(r0, r1)
        L2f:
            java.lang.reflect.Method r0 = b.i.f.f.d
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L3e
            b.i.f.f r0 = new b.i.f.f
            r0.<init>()
            goto L43
        L3e:
            b.i.f.e r0 = new b.i.f.e
            r0.<init>()
        L43:
            b.i.f.d.f748a = r0
            b.f.f r0 = new b.f.f
            r1 = 16
            r0.<init>(r1)
            b.i.f.d.f749b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.f.d.<clinit>():void");
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, b.i.e.b.b bVar, Resources resources, int i, int i2, b.i.e.b.g gVar, Handler handler, boolean z) {
        Typeface typefaceA;
        if (bVar instanceof b.i.e.b.e) {
            b.i.e.b.e eVar = (b.i.e.b.e) bVar;
            typefaceA = b.i.j.b.c(context, eVar.f731a, gVar, handler, !z ? gVar != null : eVar.f733c != 0, z ? eVar.f732b : -1, i2);
        } else {
            typefaceA = f748a.a(context, (b.i.e.b.c) bVar, resources, i2);
            if (gVar != null) {
                if (typefaceA != null) {
                    gVar.b(typefaceA, handler);
                } else {
                    gVar.a(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f749b.b(d(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface c(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceD = f748a.d(context, resources, i, str, i2);
        if (typefaceD != null) {
            f749b.b(d(resources, i, i2), typefaceD);
        }
        return typefaceD;
    }

    public static String d(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
