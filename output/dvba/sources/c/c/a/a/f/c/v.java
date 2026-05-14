package c.c.a.a.f.c;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class v<K, V> extends q<Map.Entry<K, V>> {
    public final transient o<K, V> d;
    public final transient Object[] e;
    public final transient int f;

    public v(o oVar, Object[] objArr, int i) {
        this.d = oVar;
        this.e = objArr;
        this.f = i;
    }

    @Override // c.c.a.a.f.c.l
    public final int a(Object[] objArr, int i) {
        return f().a(objArr, i);
    }

    @Override // c.c.a.a.f.c.q, c.c.a.a.f.c.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: b */
    public final y<Map.Entry<K, V>> iterator() {
        return f().iterator();
    }

    @Override // c.c.a.a.f.c.l, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f;
    }
}
