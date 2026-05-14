package c.c.a.a.c.k.k;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.c.a.a.c.k.k.d;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0<T> extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.c.a.a.h.e<T> f1322a;

    public g0(int i, c.c.a.a.h.e<T> eVar) {
        super(i);
        this.f1322a = eVar;
    }

    @Override // c.c.a.a.c.k.k.x
    public void a(Status status) {
        this.f1322a.a(new c.c.a.a.c.k.b(status));
    }

    @Override // c.c.a.a.c.k.k.x
    public void c(RuntimeException runtimeException) {
        this.f1322a.a(runtimeException);
    }

    @Override // c.c.a.a.c.k.k.x
    public final void e(d.a<?> aVar) throws DeadObjectException {
        try {
            h(aVar);
        } catch (DeadObjectException e) {
            this.f1322a.a(new c.c.a.a.c.k.b(x.d(e)));
            throw e;
        } catch (RemoteException e2) {
            this.f1322a.a(new c.c.a.a.c.k.b(x.d(e2)));
        } catch (RuntimeException e3) {
            this.f1322a.a(e3);
        }
    }

    public abstract void h(d.a<?> aVar);
}
