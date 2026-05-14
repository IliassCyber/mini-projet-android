package c.c.b.m;

import c.c.a.a.c.l.p;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1920a;

    public a(String str) {
        this.f1920a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return a.a.a.a.a.y(this.f1920a, ((a) obj).f1920a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1920a});
    }

    public String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("token", this.f1920a);
        return pVarB0.toString();
    }
}
