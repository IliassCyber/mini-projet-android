package androidx.lifecycle;

import b.n.c;
import b.n.d;
import b.n.e;
import b.n.g;
import b.n.k;

/* JADX INFO: loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f148a;

    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f148a = cVarArr;
    }

    @Override // b.n.e
    public void g(g gVar, d.a aVar) {
        k kVar = new k();
        for (c cVar : this.f148a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.f148a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
