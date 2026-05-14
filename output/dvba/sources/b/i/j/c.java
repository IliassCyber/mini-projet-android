package b.i.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f788c;
    public final int f;
    public final int g;
    public final String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f786a = new Object();
    public Handler.Callback e = new a();
    public int d = 0;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c cVar = c.this;
                synchronized (cVar.f786a) {
                    if (!cVar.f788c.hasMessages(1)) {
                        cVar.f787b.quit();
                        cVar.f787b = null;
                        cVar.f788c = null;
                    }
                }
                return true;
            }
            if (i != 1) {
                return true;
            }
            c cVar2 = c.this;
            Runnable runnable = (Runnable) message.obj;
            if (cVar2 == null) {
                throw null;
            }
            runnable.run();
            synchronized (cVar2.f786a) {
                cVar2.f788c.removeMessages(0);
                cVar2.f788c.sendMessageDelayed(cVar2.f788c.obtainMessage(0), cVar2.f);
            }
            return true;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Callable f791c;
        public final /* synthetic */ ReentrantLock d;
        public final /* synthetic */ AtomicBoolean e;
        public final /* synthetic */ Condition f;

        public b(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f790b = atomicReference;
            this.f791c = callable;
            this.d = reentrantLock;
            this.e = atomicBoolean;
            this.f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f790b.set(this.f791c.call());
            } catch (Exception unused) {
            }
            this.d.lock();
            try {
                this.e.set(false);
                this.f.signal();
            } finally {
                this.d.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: b.i.j.c$c, reason: collision with other inner class name */
    public interface InterfaceC0030c<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    public final void a(Runnable runnable) {
        synchronized (this.f786a) {
            if (this.f787b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f787b = handlerThread;
                handlerThread.start();
                this.f788c = new Handler(this.f787b.getLooper(), this.e);
                this.d++;
            }
            this.f788c.removeMessages(0);
            this.f788c.sendMessage(this.f788c.obtainMessage(1, runnable));
        }
    }

    public <T> T b(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        a(new b(this, atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
