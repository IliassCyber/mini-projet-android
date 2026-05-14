package c.c.b.h.c0.a;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c1 f1825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f1826c;

    public z0(w0 w0Var, c1 c1Var) {
        this.f1826c = w0Var;
        this.f1825b = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1826c.f1820a.h) {
            if (!this.f1826c.f1820a.h.isEmpty()) {
                this.f1825b.a(this.f1826c.f1820a.h.get(0), new Object[0]);
            }
        }
    }
}
