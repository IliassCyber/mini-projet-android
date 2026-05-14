package c.c.a.a.g;

import c.c.a.a.c.k.a;
import c.c.a.a.c.l.q;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g<c.c.a.a.g.b.a> f1497a = new a.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g<c.c.a.a.g.b.a> f1498b = new a.g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0053a<c.c.a.a.g.b.a, a> f1499c = new c();
    public static final a.AbstractC0053a<c.c.a.a.g.b.a, Object> d = new f();

    static {
        q.e("profile", "scopeUri must not be null or empty");
        q.e("email", "scopeUri must not be null or empty");
        a.AbstractC0053a<c.c.a.a.g.b.a, a> abstractC0053a = f1499c;
        a.g<c.c.a.a.g.b.a> gVar = f1497a;
        q.g(abstractC0053a, "Cannot construct an Api with a null ClientBuilder");
        q.g(gVar, "Cannot construct an Api with a null ClientKey");
        a.AbstractC0053a<c.c.a.a.g.b.a, Object> abstractC0053a2 = d;
        a.g<c.c.a.a.g.b.a> gVar2 = f1498b;
        q.g(abstractC0053a2, "Cannot construct an Api with a null ClientBuilder");
        q.g(gVar2, "Cannot construct an Api with a null ClientKey");
    }
}
