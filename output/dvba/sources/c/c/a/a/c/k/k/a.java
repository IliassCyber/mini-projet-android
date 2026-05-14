package c.c.a.a.c.k.k;

import c.c.a.a.c.k.a;
import c.c.a.a.c.k.a.d;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a<O extends a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1301a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.a.a.c.k.a<O> f1303c;
    public final O d;

    public a(c.c.a.a.c.k.a<O> aVar, O o) {
        this.f1303c = aVar;
        this.d = o;
        this.f1302b = Arrays.hashCode(new Object[]{aVar, o});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return !this.f1301a && !aVar.f1301a && a.a.a.a.a.y(this.f1303c, aVar.f1303c) && a.a.a.a.a.y(this.d, aVar.d);
    }

    public final int hashCode() {
        return this.f1302b;
    }
}
