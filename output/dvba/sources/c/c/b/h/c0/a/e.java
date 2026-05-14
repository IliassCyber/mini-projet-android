package c.c.b.h.c0.a;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f1791c;

    public e(int i, int i2, Map<String, Integer> map) {
        this.f1789a = a() ? 0 : i;
        this.f1790b = i2;
        c.c.a.a.c.l.q.f(map);
        this.f1791c = map;
        a();
    }

    public static boolean a() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, "firebear.preference");
            if (objInvoke != null && String.class.isAssignableFrom(objInvoke.getClass())) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        boolean zEquals = "local".equals(str);
        if (zEquals) {
            Log.e("BiChannelGoogleApi", "Found local preference, will always use local service instance");
        }
        return zEquals;
    }
}
