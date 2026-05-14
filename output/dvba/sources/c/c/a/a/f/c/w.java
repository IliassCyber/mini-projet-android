package c.c.a.a.f.c;

/* JADX INFO: loaded from: classes.dex */
public final class w extends n<Object> {
    public final transient Object[] d;
    public final transient int e;
    public final transient int f;

    public w(Object[] objArr, int i, int i2) {
        this.d = objArr;
        this.e = i;
        this.f = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        c.c.a.a.c.l.q.m0(i, this.f);
        return this.d[(i * 2) + this.e];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f;
    }
}
