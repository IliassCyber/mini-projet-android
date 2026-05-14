package c.c.a.a.f.c;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public abstract class q<E> extends l<E> implements Set<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NullableDecl
    public transient n<E> f1471c;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this || this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public n<E> f() {
        n<E> nVar = this.f1471c;
        if (nVar != null) {
            return nVar;
        }
        u uVar = new u((v) this);
        this.f1471c = uVar;
        return uVar;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return c.c.a.a.c.l.q.o0(this);
    }

    @Override // c.c.a.a.f.c.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
