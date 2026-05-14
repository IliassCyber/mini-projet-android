package c.c.a.a.h;

import java.util.concurrent.Executor;

/* JADX WARN: Unexpected interfaces in signature: [c.c.a.a.h.q<TResult>] */
/* JADX INFO: loaded from: classes.dex */
public final class g<TResult, TContinuationResult> implements g, a, b<TContinuationResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.b.h.c0.a.h<TResult, d<TContinuationResult>> f1505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t<TContinuationResult> f1506c;

    public g(Executor executor, c.c.b.h.c0.a.h<TResult, d<TContinuationResult>> hVar, t<TContinuationResult> tVar) {
        this.f1504a = executor;
        this.f1505b = hVar;
        this.f1506c = tVar;
    }

    public final void a(d<TResult> dVar) {
        this.f1504a.execute(new h(this, dVar));
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // c.c.a.a.h.g, c.c.a.a.h.a
    public final void b(java.lang.Exception r2) {
        /*
            r1 = this;
            c.c.a.a.h.t<TContinuationResult> r0 = r1.f1506c
            r0.c(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.h.g.b(java.lang.Exception):void");
    }
}
