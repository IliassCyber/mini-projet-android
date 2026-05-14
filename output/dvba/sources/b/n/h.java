package b.n;

import b.c.a.b.b;
import b.n.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<g> f988c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.c.a.b.a<f, a> f986a = new b.c.a.b.a<>();
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public ArrayList<d.b> g = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.b f987b = d.b.INITIALIZED;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d.b f989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f990b;

        public a(f fVar, d.b bVar) {
            this.f990b = j.d(fVar);
            this.f989a = bVar;
        }

        public void a(g gVar, d.a aVar) {
            d.b bVarC = h.c(aVar);
            this.f989a = h.e(this.f989a, bVarC);
            this.f990b.g(gVar, aVar);
            this.f989a = bVarC;
        }
    }

    public h(g gVar) {
        this.f988c = new WeakReference<>(gVar);
    }

    public static d.b c(d.a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return d.b.RESUMED;
                }
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return d.b.DESTROYED;
                        }
                        throw new IllegalArgumentException("Unexpected event value " + aVar);
                    }
                }
            }
            return d.b.STARTED;
        }
        return d.b.CREATED;
    }

    public static d.b e(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    public static d.a i(d.b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return d.a.ON_CREATE;
        }
        if (iOrdinal == 2) {
            return d.a.ON_START;
        }
        if (iOrdinal == 3) {
            return d.a.ON_RESUME;
        }
        if (iOrdinal == 4) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    @Override // b.n.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.f987b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        a aVar = new a(fVar, bVar2);
        if (this.f986a.e(fVar, aVar) == null && (gVar = this.f988c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            d.b bVarB = b(fVar);
            this.d++;
            while (aVar.f989a.compareTo(bVarB) < 0 && this.f986a.f.containsKey(fVar)) {
                this.g.add(aVar.f989a);
                aVar.a(gVar, i(aVar.f989a));
                g();
                bVarB = b(fVar);
            }
            if (!z) {
                h();
            }
            this.d--;
        }
    }

    public final d.b b(f fVar) {
        b.c.a.b.a<f, a> aVar = this.f986a;
        d.b bVar = null;
        b.c<f, a> cVar = aVar.f.containsKey(fVar) ? aVar.f.get(fVar).e : null;
        d.b bVar2 = cVar != null ? cVar.getValue().f989a : null;
        if (!this.g.isEmpty()) {
            bVar = this.g.get(r0.size() - 1);
        }
        return e(e(this.f987b, bVar2), bVar);
    }

    public void d(d.a aVar) {
        f(c(aVar));
    }

    public final void f(d.b bVar) {
        if (this.f987b == bVar) {
            return;
        }
        this.f987b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        h();
        this.e = false;
    }

    public final void g() {
        this.g.remove(r0.size() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.n.h.h():void");
    }
}
