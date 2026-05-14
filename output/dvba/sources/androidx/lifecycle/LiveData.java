package androidx.lifecycle;

import b.c.a.b.b;
import b.n.d;
import b.n.g;
import b.n.h;
import b.n.m;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f151a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<m<? super T>, LiveData<T>.a> f152b = new b<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f153c = 0;
    public volatile Object d = i;
    public volatile Object e = i;
    public int f = -1;
    public boolean g;
    public boolean h;

    public class LifecycleBoundObserver extends LiveData<T>.a implements Object {
        public final g e;
        public final /* synthetic */ LiveData f;

        public void g(g gVar, d.a aVar) {
            if (((h) this.e.a()).f987b == d.b.DESTROYED) {
                this.f.f(this.f154a);
            } else {
                h(i());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        public boolean i() {
            return ((h) this.e.a()).f987b.compareTo(d.b.STARTED) >= 0;
        }
    }

    public abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m<? super T> f154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f156c;
        public final /* synthetic */ LiveData d;

        public void h(boolean z) {
            if (z == this.f155b) {
                return;
            }
            this.f155b = z;
            boolean z2 = this.d.f153c == 0;
            this.d.f153c += this.f155b ? 1 : -1;
            if (z2 && this.f155b) {
                this.d.d();
            }
            LiveData liveData = this.d;
            if (liveData.f153c == 0 && !this.f155b) {
                liveData.e();
            }
            if (this.f155b) {
                this.d.c(this);
            }
        }

        public abstract boolean i();
    }

    public static void a(String str) {
        if (b.c.a.a.a.b().f526a.a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void b(LiveData<T>.a aVar) {
        if (aVar.f155b) {
            if (!aVar.i()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.f156c;
            int i3 = this.f;
            if (i2 >= i3) {
                return;
            }
            aVar.f156c = i3;
            aVar.f154a.a((Object) this.d);
        }
    }

    public void c(LiveData<T>.a aVar) {
        if (this.g) {
            this.h = true;
            return;
        }
        this.g = true;
        do {
            this.h = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                b<m<? super T>, LiveData<T>.a>.d dVarB = this.f152b.b();
                while (dVarB.hasNext()) {
                    b((a) ((Map.Entry) dVarB.next()).getValue());
                    if (this.h) {
                        break;
                    }
                }
            }
        } while (this.h);
        this.g = false;
    }

    public void d() {
    }

    public void e() {
    }

    public void f(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.a aVarD = this.f152b.d(mVar);
        if (aVarD == null) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = (LifecycleBoundObserver) aVarD;
        ((h) lifecycleBoundObserver.e.a()).f986a.d(lifecycleBoundObserver);
        aVarD.h(false);
    }
}
