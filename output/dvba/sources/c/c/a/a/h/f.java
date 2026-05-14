package c.c.a.a.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f1501a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f1502b = new s();

    public static final class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f1503a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f1503a.post(runnable);
        }
    }
}
