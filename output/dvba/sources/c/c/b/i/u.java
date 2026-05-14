package c.c.b.i;

/* JADX INFO: loaded from: classes.dex */
public class u<T> implements c.c.b.l.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1912c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f1913a = f1912c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c.c.b.l.a<T> f1914b;

    public u(c.c.b.l.a<T> aVar) {
        this.f1914b = aVar;
    }

    @Override // c.c.b.l.a
    public T a() {
        T tA = (T) this.f1913a;
        if (tA == f1912c) {
            synchronized (this) {
                tA = (T) this.f1913a;
                if (tA == f1912c) {
                    tA = this.f1914b.a();
                    this.f1913a = tA;
                    this.f1914b = null;
                }
            }
        }
        return tA;
    }
}
