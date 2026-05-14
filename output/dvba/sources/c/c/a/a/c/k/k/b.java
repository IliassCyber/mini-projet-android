package c.c.a.a.c.k.k;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final b f = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1304b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f1305c = new AtomicBoolean();

    @GuardedBy("sInstance")
    public final ArrayList<a> d = new ArrayList<>();

    @GuardedBy("sInstance")
    public boolean e = false;

    public interface a {
        void a(boolean z);
    }

    public static void b(Application application) {
        synchronized (f) {
            if (!f.e) {
                application.registerActivityLifecycleCallbacks(f);
                application.registerComponentCallbacks(f);
                f.e = true;
            }
        }
    }

    public final void a(a aVar) {
        synchronized (f) {
            this.d.add(aVar);
        }
    }

    public final void c(boolean z) {
        synchronized (f) {
            ArrayList<a> arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f1304b.compareAndSet(true, false);
        this.f1305c.set(true);
        if (zCompareAndSet) {
            c(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f1304b.compareAndSet(true, false);
        this.f1305c.set(true);
        if (zCompareAndSet) {
            c(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f1304b.compareAndSet(false, true)) {
            this.f1305c.set(true);
            c(true);
        }
    }
}
