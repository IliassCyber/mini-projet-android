package b.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c<K, V> f532c;
    public WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap<>();
    public int e = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.e;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* JADX INFO: renamed from: b.c.a.b.b$b, reason: collision with other inner class name */
    public static class C0015b<K, V> extends e<K, V> {
        public C0015b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.e;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final V f534c;
        public c<K, V> d;
        public c<K, V> e;

        public c(K k, V v) {
            this.f533b = k;
            this.f534c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f533b.equals(cVar.f533b) && this.f534c.equals(cVar.f534c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f533b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f534c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f533b.hashCode() ^ this.f534c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f533b + "=" + this.f534c;
        }
    }

    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f536c = true;

        public d() {
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f535b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.e;
                this.f535b = cVar3;
                this.f536c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f536c) {
                return b.this.f531b != null;
            }
            c<K, V> cVar = this.f535b;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar;
            if (this.f536c) {
                this.f536c = false;
                cVar = b.this.f531b;
            } else {
                c<K, V> cVar2 = this.f535b;
                cVar = cVar2 != null ? cVar2.d : null;
            }
            this.f535b = cVar;
            return cVar;
        }
    }

    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<K, V> f538c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f537b = cVar2;
            this.f538c = cVar;
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVarC = null;
            if (this.f537b == cVar && cVar == this.f538c) {
                this.f538c = null;
                this.f537b = null;
            }
            c<K, V> cVar2 = this.f537b;
            if (cVar2 == cVar) {
                this.f537b = b(cVar2);
            }
            c<K, V> cVar3 = this.f538c;
            if (cVar3 == cVar) {
                c<K, V> cVar4 = this.f537b;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarC = c(cVar3);
                }
                this.f538c = cVarC;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f538c != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.f538c;
            c<K, V> cVar2 = this.f537b;
            this.f538c = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f531b;
        while (cVar != null && !cVar.f533b.equals(k)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    public b<K, V>.d b() {
        b<K, V>.d dVar = new d();
        this.d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> c(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.e++;
        c<K, V> cVar2 = this.f532c;
        if (cVar2 == null) {
            this.f531b = cVar;
        } else {
            cVar2.d = cVar;
            cVar.e = cVar2;
        }
        this.f532c = cVar;
        return cVar;
    }

    public V d(K k) {
        c<K, V> cVarA = a(k);
        if (cVarA == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            Iterator<f<K, V>> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarA);
            }
        }
        c<K, V> cVar = cVarA.e;
        if (cVar != null) {
            cVar.d = cVarA.d;
        } else {
            this.f531b = cVarA.d;
        }
        c<K, V> cVar2 = cVarA.d;
        if (cVar2 != null) {
            cVar2.e = cVarA.e;
        } else {
            this.f532c = cVarA.e;
        }
        cVarA.d = null;
        cVarA.e = null;
        return cVarA.f534c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((b.c.a.b.b.e) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof b.c.a.b.b
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            b.c.a.b.b r7 = (b.c.a.b.b) r7
            int r1 = r6.e
            int r3 = r7.e
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            b.c.a.b.b$e r3 = (b.c.a.b.b.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            b.c.a.b.b$e r4 = (b.c.a.b.b.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            b.c.a.b.b$e r7 = (b.c.a.b.b.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = 0
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.b.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f531b, this.f532c);
        this.d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sbE.append("]");
                return sbE.toString();
            }
            sbE.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sbE.append(", ");
            }
        }
    }
}
