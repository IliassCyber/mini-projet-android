package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public class e<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t<TResult> f1500a = new t<>();

    public boolean a(Exception exc) {
        t<TResult> tVar = this.f1500a;
        if (tVar == null) {
            throw null;
        }
        c.c.a.a.c.l.q.g(exc, "Exception must not be null");
        synchronized (tVar.f1531a) {
            if (tVar.f1533c) {
                return false;
            }
            tVar.f1533c = true;
            tVar.f = exc;
            tVar.f1532b.a(tVar);
            return true;
        }
    }
}
