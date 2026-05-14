package c.c.a.a.f.c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public abstract class o<K, V> implements Serializable, Map<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient q<Map.Entry<K, V>> f1468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient q<K> f1469c;
    public transient l<V> d;

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((l) values()).contains(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        q<Map.Entry<K, V>> qVar = this.f1468b;
        if (qVar != null) {
            return qVar;
        }
        s sVar = (s) this;
        v vVar = new v(sVar, sVar.f, sVar.g);
        this.f1468b = vVar;
        return vVar;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return c.c.a.a.c.l.q.o0((q) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        q<K> qVar = this.f1469c;
        if (qVar != null) {
            return qVar;
        }
        s sVar = (s) this;
        x xVar = new x(sVar, new w(sVar.f, 0, sVar.g));
        this.f1469c = xVar;
        return xVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size < 0) {
            StringBuilder sb = new StringBuilder("size".length() + 40);
            sb.append("size");
            sb.append(" cannot be negative but was: ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824L));
        sb2.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb2.append(", ");
            }
            z = false;
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Map
    public Collection values() {
        l<V> lVar = this.d;
        if (lVar != null) {
            return lVar;
        }
        s sVar = (s) this;
        w wVar = new w(sVar.f, 1, sVar.g);
        this.d = wVar;
        return wVar;
    }
}
