package c.c.a.a.c.k.k;

import c.c.a.a.c.k.k.d;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends g0<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<?> f1326b;

    public i0(g<?> gVar, c.c.a.a.h.e<Boolean> eVar) {
        super(4, eVar);
        this.f1326b = gVar;
    }

    @Override // c.c.a.a.c.k.k.x
    public final /* bridge */ /* synthetic */ void b(m0 m0Var, boolean z) {
    }

    @Override // c.c.a.a.c.k.k.o
    public final c.c.a.a.c.c[] f(d.a<?> aVar) {
        if (aVar.g.get(this.f1326b) == null) {
            return null;
        }
        throw null;
    }

    @Override // c.c.a.a.c.k.k.o
    public final boolean g(d.a<?> aVar) {
        if (aVar.g.get(this.f1326b) == null) {
            return false;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [TResult, java.lang.Boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // c.c.a.a.c.k.k.g0
    public final void h(d.a<?> aVar) {
        if (aVar.g.remove(this.f1326b) != null) {
            throw null;
        }
        c.c.a.a.h.e<T> eVar = this.f1322a;
        ?? r0 = Boolean.FALSE;
        c.c.a.a.h.t<TResult> tVar = eVar.f1500a;
        synchronized (tVar.f1531a) {
            if (tVar.f1533c) {
                return;
            }
            tVar.f1533c = true;
            tVar.e = r0;
            tVar.f1532b.a(tVar);
        }
    }
}
