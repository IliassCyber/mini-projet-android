package c.c.b.i;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public <T> T a(Class<T> cls) {
        c.c.b.l.a<T> aVarB = b(cls);
        if (aVarB == null) {
            return null;
        }
        return aVarB.a();
    }

    public abstract <T> c.c.b.l.a<T> b(Class<T> cls);

    public <T> Set<T> c(Class<T> cls) {
        return d(cls).a();
    }

    public abstract <T> c.c.b.l.a<Set<T>> d(Class<T> cls);
}
