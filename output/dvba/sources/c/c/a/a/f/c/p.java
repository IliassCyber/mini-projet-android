package c.c.a.a.f.c;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
public final class p<E> extends n<E> {
    public final transient int d;
    public final transient int e;
    public final /* synthetic */ n f;

    public p(n nVar, int i, int i2) {
        this.f = nVar;
        this.d = i;
        this.e = i2;
    }

    @Override // c.c.a.a.f.c.l
    public final Object[] c() {
        return this.f.c();
    }

    @Override // c.c.a.a.f.c.l
    public final int d() {
        return this.f.d() + this.d;
    }

    @Override // c.c.a.a.f.c.l
    public final int e() {
        return this.f.d() + this.d + this.e;
    }

    @Override // c.c.a.a.f.c.n, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final n<E> subList(int i, int i2) {
        c.c.a.a.c.l.q.u0(i, i2, this.e);
        n nVar = this.f;
        int i3 = this.d;
        return (n) nVar.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List
    public final E get(int i) {
        c.c.a.a.c.l.q.m0(i, this.e);
        return this.f.get(i + this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
