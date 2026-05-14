package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.n.d;
import b.n.e;
import b.n.g;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f33b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f34c;
    public static Field d;
    public static Field e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f35a;

    public ImmLeaksCleaner(Activity activity) {
        this.f35a = activity;
    }

    @Override // b.n.e
    public void g(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY) {
            return;
        }
        if (f33b == 0) {
            try {
                f33b = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                e = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f34c = declaredField3;
                declaredField3.setAccessible(true);
                f33b = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f33b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f35a.getSystemService("input_method");
            try {
                Object obj = f34c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
