package b.f;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
public class b<E> extends g<E, E> {
    public final /* synthetic */ c d;

    public b(c cVar) {
        this.d = cVar;
    }

    @Override // b.f.g
    public void a() {
        this.d.clear();
    }

    @Override // b.f.g
    public Object b(int i, int i2) {
        return this.d.f572c[i];
    }

    @Override // b.f.g
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // b.f.g
    public int d() {
        return this.d.d;
    }

    @Override // b.f.g
    public int e(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // b.f.g
    public int f(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // b.f.g
    public void g(E e, E e2) {
        this.d.add(e);
    }

    @Override // b.f.g
    public void h(int i) {
        this.d.e(i);
    }

    @Override // b.f.g
    public E i(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
