package c.c.a.a.f.c;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
public final class u<K, V> extends n<Map.Entry<K, V>> {
    public final /* synthetic */ v d;

    public u(v vVar) {
        this.d = vVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        c.c.a.a.c.l.q.m0(i, this.d.f);
        Object[] objArr = this.d.e;
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(objArr[i2], objArr[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d.f;
    }
}
