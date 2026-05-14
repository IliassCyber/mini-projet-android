package c.c.b.i;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f1905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1907c;

    public p(Class<?> cls, int i, int i2) {
        c.c.a.a.c.l.q.h(cls, "Null dependency anInterface.");
        this.f1905a = cls;
        this.f1906b = i;
        this.f1907c = i2;
    }

    public boolean a() {
        return this.f1906b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1905a == pVar.f1905a && this.f1906b == pVar.f1906b && this.f1907c == pVar.f1907c;
    }

    public int hashCode() {
        return ((((this.f1905a.hashCode() ^ 1000003) * 1000003) ^ this.f1906b) * 1000003) ^ this.f1907c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f1905a);
        sb.append(", type=");
        int i = this.f1906b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f1907c == 0);
        sb.append("}");
        return sb.toString();
    }
}
