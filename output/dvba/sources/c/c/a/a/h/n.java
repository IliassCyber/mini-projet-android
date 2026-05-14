package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f1522c;

    public n(m mVar, d dVar) {
        this.f1522c = mVar;
        this.f1521b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Exception exc;
        synchronized (this.f1522c.f1519b) {
            if (this.f1522c.f1520c != null) {
                a aVar = this.f1522c.f1520c;
                t tVar = (t) this.f1521b;
                synchronized (tVar.f1531a) {
                    exc = tVar.f;
                }
                aVar.b(exc);
            }
        }
    }
}
