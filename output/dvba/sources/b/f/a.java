package b.f;

import b.f.g.b;
import b.f.g.c;
import b.f.g.e;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends h<K, V> implements Map<K, V> {
    public g<K, V> i;

    /* JADX INFO: renamed from: b.f.a$a, reason: collision with other inner class name */
    public class C0022a extends g<K, V> {
        public C0022a() {
        }

        @Override // b.f.g
        public void a() {
            a.this.clear();
        }

        @Override // b.f.g
        public Object b(int i, int i2) {
            return a.this.f592c[(i << 1) + i2];
        }

        @Override // b.f.g
        public Map<K, V> c() {
            return a.this;
        }

        @Override // b.f.g
        public int d() {
            return a.this.d;
        }

        @Override // b.f.g
        public int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // b.f.g
        public int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // b.f.g
        public void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // b.f.g
        public void h(int i) {
            a.this.i(i);
        }

        @Override // b.f.g
        public V i(int i, V v) {
            int i2 = (i << 1) + 1;
            Object[] objArr = a.this.f592c;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
    }

    public a() {
    }

    public a(int i) {
        super(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(h hVar) {
        if (hVar != null) {
            int i = hVar.d;
            b(this.d + i);
            if (this.d != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    put(hVar.h(i2), hVar.k(i2));
                }
            } else if (i > 0) {
                System.arraycopy(hVar.f591b, 0, this.f591b, 0, i);
                System.arraycopy(hVar.f592c, 0, this.f592c, 0, i << 1);
                this.d = i;
            }
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V> gVarL = l();
        if (gVarL.f581a == null) {
            gVarL.f581a = gVarL.new b();
        }
        return gVarL.f581a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        g<K, V> gVarL = l();
        if (gVarL.f582b == null) {
            gVarL.f582b = gVarL.new c();
        }
        return gVarL.f582b;
    }

    public final g<K, V> l() {
        if (this.i == null) {
            this.i = new C0022a();
        }
        return this.i;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.d);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        g<K, V> gVarL = l();
        if (gVarL.f583c == null) {
            gVarL.f583c = gVarL.new e();
        }
        return gVarL.f583c;
    }
}
