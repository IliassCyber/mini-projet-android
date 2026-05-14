package c.c.b.i;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<?> f1900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<n> f1901b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<n> f1902c = new HashSet();

    public n(d<?> dVar) {
        this.f1900a = dVar;
    }

    public boolean a() {
        return this.f1902c.isEmpty();
    }
}
