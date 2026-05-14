package c.c.b.i;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class w extends c.c.b.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Class<?>> f1915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f1916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Class<?>> f1917c;
    public final Set<Class<?>> d;
    public final Set<Class<?>> e;
    public final c.c.b.i.a f;

    public static class a implements c.c.b.j.c {
        public a(Set<Class<?>> set, c.c.b.j.c cVar) {
        }
    }

    public w(d<?> dVar, c.c.b.i.a aVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (p pVar : dVar.f1887b) {
            if (pVar.f1907c == 0) {
                if (pVar.a()) {
                    hashSet3.add(pVar.f1905a);
                } else {
                    hashSet.add(pVar.f1905a);
                }
            } else if (pVar.a()) {
                hashSet4.add(pVar.f1905a);
            } else {
                hashSet2.add(pVar.f1905a);
            }
        }
        if (!dVar.f.isEmpty()) {
            hashSet.add(c.c.b.j.c.class);
        }
        this.f1915a = Collections.unmodifiableSet(hashSet);
        this.f1916b = Collections.unmodifiableSet(hashSet2);
        this.f1917c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = dVar.f;
        this.f = aVar;
    }

    @Override // c.c.b.i.a
    public <T> T a(Class<T> cls) {
        if (!this.f1915a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f.a(cls);
        return !cls.equals(c.c.b.j.c.class) ? t : (T) new a(this.e, (c.c.b.j.c) t);
    }

    @Override // c.c.b.i.a
    public <T> c.c.b.l.a<T> b(Class<T> cls) {
        if (this.f1916b.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // c.c.b.i.a
    public <T> Set<T> c(Class<T> cls) {
        if (this.f1917c.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // c.c.b.i.a
    public <T> c.c.b.l.a<Set<T>> d(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
