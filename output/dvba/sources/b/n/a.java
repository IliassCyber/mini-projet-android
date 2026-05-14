package b.n;

import b.n.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f977c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, C0039a> f978a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class, Boolean> f979b = new HashMap();

    /* JADX INFO: renamed from: b.n.a$a, reason: collision with other inner class name */
    public static class C0039a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<d.a, List<b>> f980a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<b, d.a> f981b;

        public C0039a(Map<b, d.a> map) {
            this.f981b = map;
            for (Map.Entry<b, d.a> entry : map.entrySet()) {
                d.a value = entry.getValue();
                List<b> arrayList = this.f980a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f980a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void a(List<b> list, g gVar, d.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = list.get(size);
                    if (bVar == null) {
                        throw null;
                    }
                    try {
                        int i = bVar.f982a;
                        if (i == 0) {
                            bVar.f983b.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            bVar.f983b.invoke(obj, gVar);
                        } else if (i == 2) {
                            bVar.f983b.invoke(obj, gVar, aVar);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f983b;

        public b(int i, Method method) {
            this.f982a = i;
            this.f983b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f982a == bVar.f982a && this.f983b.getName().equals(bVar.f983b.getName());
        }

        public int hashCode() {
            return this.f983b.getName().hashCode() + (this.f982a * 31);
        }
    }

    public final C0039a a(Class cls, Method[] methodArr) {
        int i;
        C0039a c0039aB;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (c0039aB = b(superclass)) != null) {
            map.putAll(c0039aB.f981b);
        }
        for (Class cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, d.a> entry : b(cls2).f981b.entrySet()) {
                c(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                d.a aVarValue = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != d.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(map, new b(i, method), aVarValue, cls);
                z = true;
            }
        }
        C0039a c0039a = new C0039a(map);
        this.f978a.put(cls, c0039a);
        this.f979b.put(cls, Boolean.valueOf(z));
        return c0039a;
    }

    public C0039a b(Class cls) {
        C0039a c0039a = this.f978a.get(cls);
        return c0039a != null ? c0039a : a(cls, null);
    }

    public final void c(Map<b, d.a> map, b bVar, d.a aVar, Class cls) {
        d.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f983b;
        StringBuilder sbE = c.a.a.a.a.e("Method ");
        sbE.append(method.getName());
        sbE.append(" in ");
        sbE.append(cls.getName());
        sbE.append(" already declared with different @OnLifecycleEvent value: previous value ");
        sbE.append(aVar2);
        sbE.append(", new value ");
        sbE.append(aVar);
        throw new IllegalArgumentException(sbE.toString());
    }
}
