package c.c.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1512b;

    public j(i iVar) {
        this.f1512b = iVar;
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
            r4 = this;
            c.c.a.a.h.i r0 = r4.f1512b
            java.lang.Object r0 = r0.f1510b
            monitor-enter(r0)
            c.c.a.a.h.i r1 = r4.f1512b     // Catch: java.lang.Throwable -> L2b
            c.c.a.a.h.g r1 = r1.f1511c     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L29
            c.c.a.a.h.i r1 = r4.f1512b     // Catch: java.lang.Throwable -> L2b
            c.c.a.a.h.g r1 = r1.f1511c     // Catch: java.lang.Throwable -> L2b
            c.c.a.a.h.t<TContinuationResult> r1 = r1.f1506c     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r2 = r1.f1531a     // Catch: java.lang.Throwable -> L2b
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r3 = r1.f1533c     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L1a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26
            goto L29
        L1a:
            r3 = 1
            r1.f1533c = r3     // Catch: java.lang.Throwable -> L26
            r1.d = r3     // Catch: java.lang.Throwable -> L26
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26
            c.c.a.a.h.r<TResult> r2 = r1.f1532b     // Catch: java.lang.Throwable -> L2b
            r2.a(r1)     // Catch: java.lang.Throwable -> L2b
            goto L29
        L26:
            r1 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26
            throw r1     // Catch: java.lang.Throwable -> L2b
        L29:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            return
        L2b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.h.j.run():void");
    }
}
