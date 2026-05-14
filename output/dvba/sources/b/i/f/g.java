package b.i.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b.i.j.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends e {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() throws NoSuchMethodException {
        Method methodQ;
        Method method;
        Constructor<?> constructor;
        Method methodO;
        Method methodP;
        Method method2;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            methodO = o(cls2);
            methodP = p(cls2);
            method2 = cls2.getMethod("freeze", new Class[0]);
            method = cls2.getMethod("abortCreation", new Class[0]);
            methodQ = q(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder sbE = c.a.a.a.a.e("Unable to collect necessary methods for class ");
            sbE.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", sbE.toString(), e);
            methodQ = null;
            method = null;
            constructor = null;
            methodO = null;
            methodP = null;
            method2 = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = methodO;
        this.j = methodP;
        this.k = method2;
        this.l = method;
        this.m = methodQ;
    }

    private Object n() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.i.f.e, b.i.f.j
    public Typeface a(Context context, b.i.e.b.c cVar, Resources resources, int i) {
        if (!m()) {
            return super.a(context, cVar, resources, i);
        }
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (b.i.e.b.d dVar : cVar.f727a) {
            if (!j(context, objN, dVar.f728a, dVar.e, dVar.f729b, dVar.f730c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d))) {
                i(objN);
                return null;
            }
        }
        if (l(objN)) {
            return k(objN);
        }
        return null;
    }

    @Override // b.i.f.e, b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Typeface typefaceK;
        boolean zBooleanValue;
        if (fVarArr.length < 1) {
            return null;
        }
        if (!m()) {
            b.f fVarF = f(fVarArr, i);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(fVarF.f781a, "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(fVarF.f783c).setItalic(fVarF.d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapD = b.i.j.b.d(context, fVarArr, cancellationSignal);
        Object objN = n();
        if (objN == null) {
            return null;
        }
        boolean z = false;
        for (b.f fVar : fVarArr) {
            ByteBuffer byteBuffer = mapD.get(fVar.f781a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.j.invoke(objN, byteBuffer, Integer.valueOf(fVar.f782b), null, Integer.valueOf(fVar.f783c), Integer.valueOf(fVar.d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    i(objN);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            i(objN);
            return null;
        }
        if (l(objN) && (typefaceK = k(objN)) != null) {
            return Typeface.create(typefaceK, i);
        }
        return null;
    }

    @Override // b.i.f.j
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (!m()) {
            return super.d(context, resources, i, str, i2);
        }
        Object objN = n();
        if (objN == null) {
            return null;
        }
        if (!j(context, objN, str, 0, -1, -1, null)) {
            i(objN);
            return null;
        }
        if (l(objN)) {
            return k(objN);
        }
        return null;
    }

    public final void i(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean j(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface k(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean l(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean m() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method o(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method p(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method q(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
