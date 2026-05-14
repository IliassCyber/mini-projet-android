package b.i.e;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f722a = new Object();

    /* JADX INFO: renamed from: b.i.e.a$a, reason: collision with other inner class name */
    public static class ExecutorC0027a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f723a;

        public ExecutorC0027a(Handler handler) {
            this.f723a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f723a.post(runnable)) {
                return;
            }
            throw new RejectedExecutionException(this.f723a + " is shutting down");
        }
    }

    public static int a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static ColorStateList b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    public static Drawable c(Context context, int i) {
        return context.getDrawable(i);
    }

    public static Executor d(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? context.getMainExecutor() : new ExecutorC0027a(new Handler(context.getMainLooper()));
    }

    public static boolean e(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }
}
