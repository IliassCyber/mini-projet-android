package c.c.a.a.f.c;

/* JADX INFO: loaded from: classes.dex */
public final class t<E> extends n<E> {
    public static final n<Object> f = new t(new Object[0], 0);
    public final transient Object[] d;
    public final transient int e;

    public t(Object[] objArr, int i) {
        this.d = objArr;
        this.e = i;
    }

    @Override // c.c.a.a.f.c.n, c.c.a.a.f.c.l
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.d, 0, objArr, i, this.e);
        return i + this.e;
    }

    @Override // c.c.a.a.f.c.l
    public final Object[] c() {
        return this.d;
    }

    @Override // c.c.a.a.f.c.l
    public final int d() {
        return 0;
    }

    @Override // c.c.a.a.f.c.l
    public final int e() {
        return this.e;
    }

    @Override // java.util.List
    public final E get(int i) {
        c.c.a.a.c.l.q.m0(i, this.e);
        return (E) this.d[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
