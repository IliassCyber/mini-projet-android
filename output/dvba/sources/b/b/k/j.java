package b.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import b.f.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.f.c<WeakReference<j>> f254b = new b.f.c<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f255c = new Object();

    public static j d(Activity activity, i iVar) {
        return new k(activity, null, iVar, activity);
    }

    public static j e(Dialog dialog, i iVar) {
        return new k(dialog.getContext(), dialog.getWindow(), iVar, dialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(j jVar) {
        synchronized (f255c) {
            Iterator<WeakReference<j>> it = f254b.iterator();
            while (true) {
                g.a aVar = (g.a) it;
                if (aVar.hasNext()) {
                    j jVar2 = (j) ((WeakReference) aVar.next()).get();
                    if (jVar2 == jVar || jVar2 == null) {
                        aVar.remove();
                    }
                }
            }
        }
    }

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void f();

    public abstract void g();

    public abstract void h(Bundle bundle);

    public abstract void i();

    public abstract boolean k(int i);

    public abstract void l(int i);

    public abstract void m(View view);

    public abstract void n(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void o(CharSequence charSequence);
}
