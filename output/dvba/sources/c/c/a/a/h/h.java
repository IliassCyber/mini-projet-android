package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f1508c;

    public h(g gVar, d dVar) {
        this.f1508c = gVar;
        this.f1507b = dVar;
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // java.lang.Runnable
    public final void run() {
        /*
            r5 = this;
            c.c.a.a.h.g r0 = r5.f1508c     // Catch: java.lang.Exception -> L53 c.c.a.a.h.c -> L5c
            c.c.b.h.c0.a.h<TResult, c.c.a.a.h.d<TContinuationResult>> r0 = r0.f1505b     // Catch: java.lang.Exception -> L53 c.c.a.a.h.c -> L5c
            c.c.a.a.h.d r1 = r5.f1507b     // Catch: java.lang.Exception -> L53 c.c.a.a.h.c -> L5c
            java.lang.Object r0 = r0.a(r1)     // Catch: java.lang.Exception -> L53 c.c.a.a.h.c -> L5c
            c.c.a.a.h.d r0 = (c.c.a.a.h.d) r0     // Catch: java.lang.Exception -> L53 c.c.a.a.h.c -> L5c
            if (r0 != 0) goto L1d
            c.c.a.a.h.g r0 = r5.f1508c
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Continuation returned null"
            r1.<init>(r2)
            c.c.a.a.h.t<TContinuationResult> r0 = r0.f1506c
            r0.c(r1)
            return
        L1d:
            java.util.concurrent.Executor r1 = c.c.a.a.h.f.f1502b
            c.c.a.a.h.g r2 = r5.f1508c
            c.c.a.a.h.t r0 = (c.c.a.a.h.t) r0
            c.c.a.a.h.r<TResult> r3 = r0.f1532b
            c.c.a.a.h.o r4 = new c.c.a.a.h.o
            r4.<init>(r1, r2)
            r3.b(r4)
            r0.e()
            java.util.concurrent.Executor r1 = c.c.a.a.h.f.f1502b
            c.c.a.a.h.g r2 = r5.f1508c
            c.c.a.a.h.r<TResult> r3 = r0.f1532b
            c.c.a.a.h.m r4 = new c.c.a.a.h.m
            r4.<init>(r1, r2)
            r3.b(r4)
            r0.e()
            java.util.concurrent.Executor r1 = c.c.a.a.h.f.f1502b
            c.c.a.a.h.g r2 = r5.f1508c
            c.c.a.a.h.r<TResult> r3 = r0.f1532b
            c.c.a.a.h.i r4 = new c.c.a.a.h.i
            r4.<init>(r1, r2)
            r3.b(r4)
            r0.e()
            return
        L53:
            r0 = move-exception
            c.c.a.a.h.g r1 = r5.f1508c
            c.c.a.a.h.t<TContinuationResult> r1 = r1.f1506c
            r1.c(r0)
            return
        L5c:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.Exception
            if (r1 == 0) goto L73
            c.c.a.a.h.g r1 = r5.f1508c
            c.c.a.a.h.t<TContinuationResult> r1 = r1.f1506c
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Exception r0 = (java.lang.Exception) r0
            r1.c(r0)
            return
        L73:
            c.c.a.a.h.g r1 = r5.f1508c
            c.c.a.a.h.t<TContinuationResult> r1 = r1.f1506c
            r1.c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.h.h.run():void");
    }
}
