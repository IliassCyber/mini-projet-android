package c.c.b.h.d0;

import com.google.firebase.auth.internal.FederatedSignInActivity;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FederatedSignInActivity f1843b;

    public h(FederatedSignInActivity federatedSignInActivity) {
        this.f1843b = federatedSignInActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1843b.q();
        FederatedSignInActivity.r = null;
    }
}
