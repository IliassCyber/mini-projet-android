package b.i.e.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f736b;

        public a(Typeface typeface) {
            this.f736b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d(this.f736b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f738b;

        public b(int i) {
            this.f738b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.c(this.f738b);
        }
    }

    public final void a(int i, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new b(i));
    }

    public final void b(Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new a(typeface));
    }

    public abstract void c(int i);

    public abstract void d(Typeface typeface);
}
