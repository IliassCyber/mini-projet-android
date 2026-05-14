package c.c.b.h;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.c.b.m.a f1870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f1871c;

    public k0(FirebaseAuth firebaseAuth, c.c.b.m.a aVar) {
        this.f1871c = firebaseAuth;
        this.f1870b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<c.c.b.h.d0.a> it = this.f1871c.f2027c.iterator();
        while (it.hasNext()) {
            it.next().a(this.f1870b);
        }
        Iterator<FirebaseAuth.b> it2 = this.f1871c.f2026b.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.f1871c);
        }
    }
}
