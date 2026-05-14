package c.c.a.a.f.c;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public final class x<K> extends q<K> {
    public final transient o<K, ?> d;
    public final transient n<K> e;

    public x(o<K, ?> oVar, n<K> nVar) {
        this.d = oVar;
        this.e = nVar;
    }

    @Override // c.c.a.a.f.c.l
    public final int a(Object[] objArr, int i) {
        return this.e.a(objArr, i);
    }

    @Override // c.c.a.a.f.c.q, c.c.a.a.f.c.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: b */
    public final y<K> iterator() {
        return (y) this.e.iterator();
    }

    @Override // c.c.a.a.f.c.l, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.d.get(obj) != null;
    }

    @Override // c.c.a.a.f.c.q
    public final n<K> f() {
        return this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d.size();
    }
}
