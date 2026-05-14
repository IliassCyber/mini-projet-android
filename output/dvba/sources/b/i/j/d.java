package b.i.j;

import android.os.Handler;
import b.i.j.c;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Handler f793c;
    public final /* synthetic */ c.InterfaceC0030c d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f794b;

        public a(Object obj) {
            this.f794b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.d.a(this.f794b);
        }
    }

    public d(c cVar, Callable callable, Handler handler, c.InterfaceC0030c interfaceC0030c) {
        this.f792b = callable;
        this.f793c = handler;
        this.d = interfaceC0030c;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object objCall;
        try {
            objCall = this.f792b.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f793c.post(new a(objCall));
    }
}
