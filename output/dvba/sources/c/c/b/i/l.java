package c.c.b.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class l extends a {
    public static final c.c.b.l.a<Set<Object>> e = new c.c.b.l.a() { // from class: c.c.b.i.k
        @Override // c.c.b.l.a
        public Object a() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d<?>, u<?>> f1897a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, u<?>> f1898b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, u<Set<?>>> f1899c = new HashMap();
    public final t d;

    public l(Executor executor, Iterable<h> iterable, d<?>... dVarArr) {
        Set<n> set;
        this.d = new t(executor);
        ArrayList<d> arrayList = new ArrayList();
        arrayList.add(d.c(this.d, t.class, c.c.b.j.d.class, c.c.b.j.c.class));
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        for (d dVar2 : arrayList) {
            n nVar = new n(dVar2);
            Iterator it2 = dVar2.f1886a.iterator();
            while (it2.hasNext()) {
                Class cls = (Class) it2.next();
                o oVar = new o(cls, !dVar2.b(), null);
                if (!map.containsKey(oVar)) {
                    map.put(oVar, new HashSet());
                }
                Set set2 = (Set) map.get(oVar);
                if (!set2.isEmpty() && !oVar.f1904b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(nVar);
            }
        }
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            for (n nVar2 : (Set) it3.next()) {
                for (p pVar : nVar2.f1900a.f1887b) {
                    if ((pVar.f1907c == 0) && (set = (Set) map.get(new o(pVar.f1905a, pVar.a(), null))) != null) {
                        for (n nVar3 : set) {
                            nVar2.f1901b.add(nVar3);
                            nVar3.f1902c.add(nVar2);
                        }
                    }
                }
            }
        }
        HashSet<n> hashSet = new HashSet();
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll((Set) it4.next());
        }
        HashSet hashSet2 = new HashSet();
        for (n nVar4 : hashSet) {
            if (nVar4.a()) {
                hashSet2.add(nVar4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            n nVar5 = (n) hashSet2.iterator().next();
            hashSet2.remove(nVar5);
            i++;
            for (n nVar6 : nVar5.f1901b) {
                nVar6.f1902c.remove(nVar5);
                if (nVar6.a()) {
                    hashSet2.add(nVar6);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (n nVar7 : hashSet) {
                if (!nVar7.a() && !nVar7.f1901b.isEmpty()) {
                    arrayList2.add(nVar7.f1900a);
                }
            }
            throw new q(arrayList2);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            final d<?> dVar3 = (d) it5.next();
            this.f1897a.put(dVar3, new u<>(new c.c.b.l.a(this, dVar3) { // from class: c.c.b.i.i

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final l f1893a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final d f1894b;

                {
                    this.f1893a = this;
                    this.f1894b = dVar3;
                }

                @Override // c.c.b.l.a
                public Object a() {
                    return l.e(this.f1893a, this.f1894b);
                }
            }));
        }
        for (Map.Entry<d<?>, u<?>> entry : this.f1897a.entrySet()) {
            d<?> key = entry.getKey();
            if (key.b()) {
                u<?> value = entry.getValue();
                Iterator<Class<? super Object>> it6 = key.f1886a.iterator();
                while (it6.hasNext()) {
                    this.f1898b.put(it6.next(), value);
                }
            }
        }
        for (d<?> dVar4 : this.f1897a.keySet()) {
            for (p pVar2 : dVar4.f1887b) {
                if ((pVar2.f1906b == 1) && !this.f1898b.containsKey(pVar2.f1905a)) {
                    throw new v(String.format("Unsatisfied dependency for component %s: %s", dVar4, pVar2.f1905a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<d<?>, u<?>> entry2 : this.f1897a.entrySet()) {
            d<?> key2 = entry2.getKey();
            if (!key2.b()) {
                u<?> value2 = entry2.getValue();
                for (Class<? super Object> cls2 : key2.f1886a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            final Set set3 = (Set) entry3.getValue();
            this.f1899c.put((Class) entry3.getKey(), new u<>(new c.c.b.l.a(set3) { // from class: c.c.b.i.j

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Set f1895a;

                {
                    this.f1895a = set3;
                }

                @Override // c.c.b.l.a
                public Object a() {
                    return l.f(this.f1895a);
                }
            }));
        }
    }

    public static Object e(l lVar, d dVar) {
        return dVar.e.a(new w(dVar, lVar));
    }

    public static /* synthetic */ Set f(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((u) it.next()).a());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // c.c.b.i.a
    public <T> c.c.b.l.a<T> b(Class<T> cls) {
        c.c.a.a.c.l.q.h(cls, "Null interface requested.");
        return this.f1898b.get(cls);
    }

    @Override // c.c.b.i.a
    public <T> c.c.b.l.a<Set<T>> d(Class<T> cls) {
        u<Set<?>> uVar = this.f1899c.get(cls);
        return uVar != null ? uVar : (c.c.b.l.a<Set<T>>) e;
    }
}
