package c.c.a.a.g;

import c.c.a.a.c.k.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements a.d {
    public static final a k = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1487b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1488c = false;
    public final String d = null;
    public final boolean e = false;
    public final boolean h = false;
    public final String f = null;
    public final String g = null;
    public final Long i = null;
    public final Long j = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1487b == aVar.f1487b && this.f1488c == aVar.f1488c && a.a.a.a.a.y(this.d, aVar.d) && this.e == aVar.e && this.h == aVar.h && a.a.a.a.a.y(this.f, aVar.f) && a.a.a.a.a.y(this.g, aVar.g) && a.a.a.a.a.y(this.i, aVar.i) && a.a.a.a.a.y(this.j, aVar.j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f1487b), Boolean.valueOf(this.f1488c), this.d, Boolean.valueOf(this.e), Boolean.valueOf(this.h), this.f, this.g, this.i, this.j});
    }
}
