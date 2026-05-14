package b.i.f;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f745c;
    public final int d;

    public b(int i, int i2, int i3, int i4) {
        this.f743a = i;
        this.f744b = i2;
        this.f745c = i3;
        this.d = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new b(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.f743a == bVar.f743a && this.f745c == bVar.f745c && this.f744b == bVar.f744b;
    }

    public int hashCode() {
        return (((((this.f743a * 31) + this.f744b) * 31) + this.f745c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("Insets{left=");
        sbE.append(this.f743a);
        sbE.append(", top=");
        sbE.append(this.f744b);
        sbE.append(", right=");
        sbE.append(this.f745c);
        sbE.append(", bottom=");
        sbE.append(this.d);
        sbE.append('}');
        return sbE.toString();
    }
}
