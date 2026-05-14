package b.i.d;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a extends b.i.e.a {

    /* JADX INFO: renamed from: b.i.d.a$a, reason: collision with other inner class name */
    public interface InterfaceC0025a {
    }

    public static void f(Activity activity) {
        activity.finishAffinity();
    }

    public static InterfaceC0025a g() {
        return null;
    }

    public static void h(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && b.b(activity)) {
            return;
        }
        activity.recreate();
    }
}
