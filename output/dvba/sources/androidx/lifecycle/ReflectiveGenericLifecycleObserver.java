package androidx.lifecycle;

import b.n.a;
import b.n.d;
import b.n.e;
import b.n.g;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.C0039a f158b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f157a = obj;
        this.f158b = a.f977c.b(obj.getClass());
    }

    @Override // b.n.e
    public void g(g gVar, d.a aVar) {
        a.C0039a c0039a = this.f158b;
        Object obj = this.f157a;
        a.C0039a.a(c0039a.f980a.get(aVar), gVar, aVar, obj);
        a.C0039a.a(c0039a.f980a.get(d.a.ON_ANY), gVar, aVar, obj);
    }
}
