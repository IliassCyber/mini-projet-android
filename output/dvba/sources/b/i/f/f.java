package b.i.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b.i.j.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f753c;
    public static final Method d;
    public static final Method e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f753c = constructor;
        f752b = cls;
        d = method2;
        e = method;
    }

    public static boolean g(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface h(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f752b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.i.f.j
    public Typeface a(Context context, b.i.e.b.c cVar, Resources resources, int i) {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = f753c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (b.i.e.b.d dVar : cVar.f727a) {
            int i2 = dVar.f;
            File fileL = a.a.a.a.a.L(context);
            if (fileL == null) {
                map = null;
            } else {
                try {
                    if (a.a.a.a.a.p(fileL, resources, i2)) {
                        try {
                            fileInputStream = new FileInputStream(fileL);
                        } catch (IOException unused2) {
                            map = null;
                        }
                        try {
                            FileChannel channel = fileInputStream.getChannel();
                            map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                            fileInputStream.close();
                        } finally {
                        }
                    } else {
                        map = null;
                    }
                } finally {
                    fileL.delete();
                }
            }
            if (map == null || !g(objNewInstance, map, dVar.e, dVar.f729b, dVar.f730c)) {
                return null;
            }
        }
        return h(objNewInstance);
    }

    @Override // b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = f753c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        b.f.h hVar = new b.f.h();
        for (b.f fVar : fVarArr) {
            Uri uri = fVar.f781a;
            ByteBuffer byteBufferY = (ByteBuffer) hVar.get(uri);
            if (byteBufferY == null) {
                byteBufferY = a.a.a.a.a.Y(context, cancellationSignal, uri);
                hVar.put(uri, byteBufferY);
            }
            if (byteBufferY == null || !g(objNewInstance, byteBufferY, fVar.f782b, fVar.f783c, fVar.d)) {
                return null;
            }
        }
        Typeface typefaceH = h(objNewInstance);
        if (typefaceH == null) {
            return null;
        }
        return Typeface.create(typefaceH, i);
    }
}
