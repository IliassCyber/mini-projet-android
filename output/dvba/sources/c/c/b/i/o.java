package c.c.b.i;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f1903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1904b;

    public o(Class cls, boolean z, m mVar) {
        this.f1903a = cls;
        this.f1904b = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return oVar.f1903a.equals(this.f1903a) && oVar.f1904b == this.f1904b;
    }

    public int hashCode() {
        return ((this.f1903a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f1904b).hashCode();
    }
}
