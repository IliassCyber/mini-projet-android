package c.a.b;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f1189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f1190c;

    public c(d dVar, o oVar) {
        this.f1190c = dVar;
        this.f1189b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1190c.f1192c.put(this.f1189b);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
