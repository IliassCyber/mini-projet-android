package c.c.b.h.c0.a;

import c.c.a.a.c.k.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends b implements a.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1814c;

    public t0(String str, r0 r0Var) {
        c.c.a.a.c.l.q.e(str, "A valid API key must be provided");
        this.f1814c = str;
    }

    @Override // c.c.b.h.c0.a.b
    public final Object clone() {
        String str = this.f1814c;
        c.c.a.a.c.l.q.d(str);
        return new t0(str, null);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return a.a.a.a.a.y(this.f1814c, t0Var.f1814c) && this.f1782b == t0Var.f1782b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1814c}) + (1 ^ (this.f1782b ? 1 : 0));
    }
}
