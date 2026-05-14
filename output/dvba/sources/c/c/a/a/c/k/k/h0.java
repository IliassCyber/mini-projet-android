package c.c.a.a.c.k.k;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.c.a.a.c.k.a;
import c.c.a.a.c.k.k.d;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class h0<ResultT> extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k<a.b, ResultT> f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.a.a.h.e<ResultT> f1324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f1325c;

    public h0(int i, k<a.b, ResultT> kVar, c.c.a.a.h.e<ResultT> eVar, j jVar) {
        super(i);
        this.f1324b = eVar;
        this.f1323a = kVar;
        this.f1325c = jVar;
    }

    @Override // c.c.a.a.c.k.k.x
    public final void a(Status status) {
        this.f1324b.a(this.f1325c.a(status));
    }

    @Override // c.c.a.a.c.k.k.x
    public final void b(m0 m0Var, boolean z) {
        c.c.a.a.h.e<ResultT> eVar = this.f1324b;
        m0Var.f1335b.put(eVar, Boolean.valueOf(z));
        c.c.a.a.h.t<ResultT> tVar = eVar.f1500a;
        l lVar = new l(m0Var, eVar);
        if (tVar == null) {
            throw null;
        }
        tVar.f1532b.b(new c.c.a.a.h.k(c.c.a.a.h.f.f1501a, lVar));
        tVar.e();
    }

    @Override // c.c.a.a.c.k.k.x
    public final void c(RuntimeException runtimeException) {
        this.f1324b.a(runtimeException);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // c.c.a.a.c.k.k.x
    public final void e(d.a<?> aVar) throws DeadObjectException {
        try {
            k<a.b, ResultT> kVar = this.f1323a;
            ((d0) kVar).f1319c.f1329a.a(aVar.f1312b, this.f1324b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            this.f1324b.a(this.f1325c.a(x.d(e2)));
        } catch (RuntimeException e3) {
            this.f1324b.a(e3);
        }
    }

    @Override // c.c.a.a.c.k.k.o
    public final c.c.a.a.c.c[] f(d.a<?> aVar) {
        return this.f1323a.f1327a;
    }

    @Override // c.c.a.a.c.k.k.o
    public final boolean g(d.a<?> aVar) {
        return this.f1323a.f1328b;
    }
}
