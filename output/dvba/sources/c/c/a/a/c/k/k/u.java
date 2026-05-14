package c.c.a.a.c.k.k;

import android.util.Log;
import c.c.a.a.c.k.k.d;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.c.a.a.c.a f1341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.b f1342c;

    public u(d.b bVar, c.c.a.a.c.a aVar) {
        this.f1342c = bVar;
        this.f1341b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.c.a.a.c.a aVar;
        c.c.a.a.c.l.k kVar;
        d.b bVar = this.f1342c;
        d.a<?> aVar2 = d.this.i.get(bVar.f1315b);
        if (aVar2 == null) {
            return;
        }
        if (this.f1341b.h()) {
            d.b bVar2 = this.f1342c;
            bVar2.e = true;
            if (bVar2.f1314a.j()) {
                d.b bVar3 = this.f1342c;
                if (!bVar3.e || (kVar = bVar3.f1316c) == null) {
                    return;
                }
                bVar3.f1314a.n(kVar, bVar3.d);
                return;
            }
            try {
                this.f1342c.f1314a.n(null, this.f1342c.f1314a.m());
                return;
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                aVar = new c.c.a.a.c.a(10);
            }
        } else {
            aVar = this.f1341b;
        }
        aVar2.t(aVar);
    }
}
