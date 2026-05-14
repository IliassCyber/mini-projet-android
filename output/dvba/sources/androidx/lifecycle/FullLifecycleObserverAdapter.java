package androidx.lifecycle;

import b.n.b;
import b.n.d;
import b.n.e;
import b.n.g;

/* JADX INFO: loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f150b;

    public FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.f149a = bVar;
        this.f150b = eVar;
    }

    @Override // b.n.e
    public void g(g gVar, d.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f149a.e(gVar);
                break;
            case ON_START:
                this.f149a.f(gVar);
                break;
            case ON_RESUME:
                this.f149a.a(gVar);
                break;
            case ON_PAUSE:
                this.f149a.b(gVar);
                break;
            case ON_STOP:
                this.f149a.d(gVar);
                break;
            case ON_DESTROY:
                this.f149a.c(gVar);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f150b;
        if (eVar != null) {
            eVar.g(gVar, aVar);
        }
    }
}
