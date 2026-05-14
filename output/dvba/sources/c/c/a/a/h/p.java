package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f1527c;

    public p(o oVar, d dVar) {
        this.f1527c = oVar;
        this.f1526b = dVar;
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
            r3 = this;
            c.c.a.a.h.o r0 = r3.f1527c
            java.lang.Object r0 = r0.f1524b
            monitor-enter(r0)
            c.c.a.a.h.o r1 = r3.f1527c     // Catch: java.lang.Throwable -> L1e
            c.c.a.a.h.b<? super TResult> r1 = r1.f1525c     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L1c
            c.c.a.a.h.o r1 = r3.f1527c     // Catch: java.lang.Throwable -> L1e
            c.c.a.a.h.b<? super TResult> r1 = r1.f1525c     // Catch: java.lang.Throwable -> L1e
            c.c.a.a.h.d r2 = r3.f1526b     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L1e
            c.c.a.a.h.g r1 = (c.c.a.a.h.g) r1     // Catch: java.lang.Throwable -> L1e
            c.c.a.a.h.t<TContinuationResult> r1 = r1.f1506c     // Catch: java.lang.Throwable -> L1e
            r1.d(r2)     // Catch: java.lang.Throwable -> L1e
        L1c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1e
            return
        L1e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.h.p.run():void");
    }
}
