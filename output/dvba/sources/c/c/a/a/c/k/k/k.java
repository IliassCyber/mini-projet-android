package c.c.a.a.c.k.k;

import c.c.a.a.c.k.a;
import c.c.a.a.c.k.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class k<A extends a.b, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.c.a.a.c.c[] f1327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1328b;

    public static class a<A extends a.b, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i<A, c.c.a.a.h.e<ResultT>> f1329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1330b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c.c.a.a.c.c[] f1331c;

        public a(c0 c0Var) {
        }

        public k<A, ResultT> a() {
            if (this.f1329a != null) {
                return new d0(this, this.f1331c, this.f1330b);
            }
            throw new IllegalArgumentException("execute parameter required");
        }
    }

    public k(c.c.a.a.c.c[] cVarArr, boolean z, c0 c0Var) {
        this.f1327a = cVarArr;
        this.f1328b = z;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }
}
