package c.c.b.i;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Class<? super T>> f1886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<p> f1887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1888c;
    public final int d;
    public final g<T> e;
    public final Set<Class<?>> f;

    public static class b<T> {
        public g<T> e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Class<? super T>> f1889a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<p> f1890b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1891c = 0;
        public int d = 0;
        public Set<Class<?>> f = new HashSet();

        public b(Class cls, Class[] clsArr, a aVar) {
            c.c.a.a.c.l.q.h(cls, "Null interface");
            this.f1889a.add(cls);
            for (Class cls2 : clsArr) {
                c.c.a.a.c.l.q.h(cls2, "Null interface");
            }
            Collections.addAll(this.f1889a, clsArr);
        }

        public b<T> a(p pVar) {
            c.c.a.a.c.l.q.h(pVar, "Null dependency");
            if (!(!this.f1889a.contains(pVar.f1905a))) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f1890b.add(pVar);
            return this;
        }

        public d<T> b() {
            if (this.e != null) {
                return new d<>(new HashSet(this.f1889a), new HashSet(this.f1890b), this.f1891c, this.d, this.e, this.f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(g<T> gVar) {
            c.c.a.a.c.l.q.h(gVar, "Null factory");
            this.e = gVar;
            return this;
        }
    }

    public d(Set set, Set set2, int i, int i2, g gVar, Set set3, a aVar) {
        this.f1886a = Collections.unmodifiableSet(set);
        this.f1887b = Collections.unmodifiableSet(set2);
        this.f1888c = i;
        this.d = i2;
        this.e = gVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(final T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.c(new g(t) { // from class: c.c.b.i.b

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f1884a;

            {
                this.f1884a = t;
            }

            @Override // c.c.b.i.g
            public Object a(a aVar) {
                return this.f1884a;
            }
        });
        return bVar.b();
    }

    public boolean b() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f1886a.toArray()) + ">{" + this.f1888c + ", type=" + this.d + ", deps=" + Arrays.toString(this.f1887b.toArray()) + "}";
    }
}
