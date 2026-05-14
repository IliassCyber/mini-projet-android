package c.c.a.a.d;

import android.os.IBinder;
import c.c.a.a.d.a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> extends a.AbstractBinderC0057a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f1427a;

    public b(T t) {
        this.f1427a = t;
    }

    public static <T> T t(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f1427a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
