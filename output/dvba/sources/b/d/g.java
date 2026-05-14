package b.d;

import androidx.biometric.BiometricPrompt;
import b.d.e;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BiometricPrompt.c f564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.a f565c;

    public g(e.a aVar, BiometricPrompt.c cVar) {
        this.f565c = aVar;
        this.f564b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.this.Y.a(this.f564b);
    }
}
