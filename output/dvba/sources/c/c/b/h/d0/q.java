package c.c.b.h.d0;

import android.os.Handler;
import android.os.Looper;
import c.c.a.a.f.c.o1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f1857b = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1858a = new o1(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1858a.post(runnable);
    }
}
