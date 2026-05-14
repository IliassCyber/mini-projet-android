package b.i.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import b.i.j.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, b.i.e.b.c> f754a = new ConcurrentHashMap<>();

    public class a implements b<b.f> {
        public a(j jVar) {
        }

        @Override // b.i.f.j.b
        public int a(b.f fVar) {
            return fVar.f783c;
        }

        @Override // b.i.f.j.b
        public boolean b(b.f fVar) {
            return fVar.d;
        }
    }

    public interface b<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T e(T[] tArr, int i, b<T> bVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(bVar.a(t2) - i2) * 2) + (bVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    public abstract Typeface a(Context context, b.i.e.b.c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i);

    public Typeface c(Context context, InputStream inputStream) {
        File fileL = a.a.a.a.a.L(context);
        if (fileL == null) {
            return null;
        }
        try {
            if (a.a.a.a.a.q(fileL, inputStream)) {
                return Typeface.createFromFile(fileL.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileL.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File fileL = a.a.a.a.a.L(context);
        if (fileL == null) {
            return null;
        }
        try {
            if (a.a.a.a.a.p(fileL, resources, i)) {
                return Typeface.createFromFile(fileL.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileL.delete();
        }
    }

    public b.f f(b.f[] fVarArr, int i) {
        return (b.f) e(fVarArr, i, new a(this));
    }
}
