package b.i.m;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f824a;

    public c(Object obj) {
        this.f824a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f824a;
        Object obj3 = ((c) obj).f824a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f824a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("DisplayCutoutCompat{");
        sbE.append(this.f824a);
        sbE.append("}");
        return sbE.toString();
    }
}
