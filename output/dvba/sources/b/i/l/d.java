package b.i.l;

/* JADX INFO: loaded from: classes.dex */
public class d<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f818c;

    public d(int i) {
        super(i);
        this.f818c = new Object();
    }

    @Override // b.i.l.c
    public T a() {
        T t;
        synchronized (this.f818c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // b.i.l.c
    public boolean b(T t) {
        boolean zB;
        synchronized (this.f818c) {
            zB = super.b(t);
        }
        return zB;
    }
}
