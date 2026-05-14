package c.c.b.h.c0.a;

import c.c.a.a.c.k.a;
import c.c.b.h.c0.a.b;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c.c.a.a.c.m.a f1779b = new c.c.a.a.c.m.a("BiChannelGoogleApi", "FirebaseAuth: ");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<T> f1780a;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.c.a.a.c.k.c<T> a(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            c.c.b.h.c0.a.c<T extends c.c.b.h.c0.a.b> r0 = r6.f1780a     // Catch: java.lang.Throwable -> Lb1
            if (r0 != 0) goto L33
            java.util.concurrent.Future r0 = r6.c()     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> Lb1
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> Lb1
            c.c.b.h.c0.a.c r0 = (c.c.b.h.c0.a.c) r0     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> Lb1
            r6.f1780a = r0     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> Lb1
            goto L33
        L12:
            r7 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = "There was an error while initializing the connection to Google Play Services: "
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> Lb1
            int r2 = r7.length()     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L2a
            java.lang.String r7 = r1.concat(r7)     // Catch: java.lang.Throwable -> Lb1
            goto L2f
        L2a:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> Lb1
            r7.<init>(r1)     // Catch: java.lang.Throwable -> Lb1
        L2f:
            r0.<init>(r7)     // Catch: java.lang.Throwable -> Lb1
            throw r0     // Catch: java.lang.Throwable -> Lb1
        L33:
            c.c.b.h.c0.a.c<T extends c.c.b.h.c0.a.b> r0 = r6.f1780a     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb1
            c.c.b.h.c0.a.e r1 = r0.f1788c
            int r2 = r1.f1789a
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L3f
            goto L63
        L3f:
            int r5 = r1.f1790b
            if (r5 > r2) goto L45
        L43:
            r3 = 0
            goto L63
        L45:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r1.f1791c
            java.lang.Object r7 = r2.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 != 0) goto L53
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
        L53:
            int r2 = r7.intValue()
            int r5 = r1.f1789a
            if (r2 <= r5) goto L43
            int r1 = r1.f1790b
            int r7 = r7.intValue()
            if (r1 < r7) goto L43
        L63:
            c.c.a.a.c.m.a r7 = c.c.b.h.c0.a.a.f1779b
            if (r3 == 0) goto L8c
            c.c.a.a.c.k.c<O extends c.c.b.h.c0.a.b> r1 = r0.f1787b
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            int r2 = r2 + 43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "getGoogleApiForMethod() returned Fallback: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r7.b(r1, r2)
            c.c.a.a.c.k.c<O extends c.c.b.h.c0.a.b> r7 = r0.f1787b
            return r7
        L8c:
            c.c.a.a.c.k.c<O extends c.c.b.h.c0.a.b> r1 = r0.f1786a
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            int r2 = r2 + 38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "getGoogleApiForMethod() returned Gms: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r7.b(r1, r2)
            c.c.a.a.c.k.c<O extends c.c.b.h.c0.a.b> r7 = r0.f1786a
            return r7
        Lb1:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.h.c0.a.a.a(java.lang.String):c.c.a.a.c.k.c");
    }

    public final <ResultT, A extends a.b> c.c.a.a.h.d<ResultT> b(f<A, ResultT> fVar) {
        c.c.a.a.c.k.c<T> cVarA = a(fVar.a());
        if (cVarA == null) {
            return c.c.a.a.c.l.q.w(m0.a(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
        }
        if (((b) cVarA.f1297c).f1782b) {
            ((u0) fVar).u = true;
        }
        return (c.c.a.a.h.d<ResultT>) cVarA.b(0, fVar.b());
    }

    public abstract Future<c<T>> c();

    public final <ResultT, A extends a.b> c.c.a.a.h.d<ResultT> d(f<A, ResultT> fVar) {
        c.c.a.a.c.k.c<T> cVarA = a(fVar.a());
        if (cVarA == null) {
            return c.c.a.a.c.l.q.w(m0.a(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
        }
        if (((b) cVarA.f1297c).f1782b) {
            ((u0) fVar).u = true;
        }
        return (c.c.a.a.h.d<ResultT>) cVarA.b(1, fVar.b());
    }
}
