package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1517c;

    public l(k kVar, d dVar) {
        this.f1517c = kVar;
        this.f1516b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1517c.f1514b) {
            if (this.f1517c.f1515c != null) {
                c.c.a.a.c.k.k.l<TResult> lVar = this.f1517c.f1515c;
                lVar.f1333b.f1335b.remove(lVar.f1332a);
            }
        }
    }
}
