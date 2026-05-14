package c.c.b.h;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f1869b;

    public j0(FirebaseAuth firebaseAuth) {
        this.f1869b = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<FirebaseAuth.a> it = this.f1869b.d.iterator();
        while (it.hasNext()) {
            it.next().a(this.f1869b);
        }
    }
}
