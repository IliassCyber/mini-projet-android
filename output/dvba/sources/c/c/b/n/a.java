package c.c.b.n;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1922b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f1921a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f1922b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        a aVar = (a) ((e) obj);
        return this.f1921a.equals(aVar.f1921a) && this.f1922b.equals(aVar.f1922b);
    }

    public int hashCode() {
        return ((this.f1921a.hashCode() ^ 1000003) * 1000003) ^ this.f1922b.hashCode();
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("LibraryVersion{libraryName=");
        sbE.append(this.f1921a);
        sbE.append(", version=");
        sbE.append(this.f1922b);
        sbE.append("}");
        return sbE.toString();
    }
}
