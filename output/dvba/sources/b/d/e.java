package b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.DeviceCredentialHandlerActivity;
import androidx.fragment.app.Fragment;
import b.i.g.a.b;
import com.app.damnvulnerablebank.SendMoney;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
public class e extends Fragment {
    public b W;
    public Executor X;
    public BiometricPrompt.b Y;
    public Handler Z;
    public boolean a0;
    public BiometricPrompt.d b0;
    public Context c0;
    public int d0;
    public b.i.i.a e0;
    public final b.a f0 = new a();

    public class a extends b.a {

        /* JADX INFO: renamed from: b.d.e$a$a, reason: collision with other inner class name */
        public class RunnableC0021a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ CharSequence f560c;

            public RunnableC0021a(int i, CharSequence charSequence) {
                this.f559b = i;
                this.f560c = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((SendMoney.a) e.this.Y) == null) {
                    throw null;
                }
            }
        }

        public a() {
        }

        public final void a(int i, CharSequence charSequence) {
            e.this.W.a(3);
            if (a.a.a.a.a.Q()) {
                return;
            }
            e.this.X.execute(new RunnableC0021a(i, charSequence));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f561a;

        public b(Handler handler) {
            this.f561a = handler;
        }

        public void a(int i) {
            this.f561a.obtainMessage(i).sendToTarget();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A(Bundle bundle) {
        super.A(bundle);
        X(true);
        this.c0 = k();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View B(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.e.B(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void Z(int i) {
        this.d0 = i;
        if (i == 1) {
            b0(10);
        }
        b.i.i.a aVar = this.e0;
        if (aVar != null) {
            synchronized (aVar) {
                if (!aVar.f765a) {
                    aVar.f765a = true;
                    Object obj = aVar.f766b;
                    if (obj != null) {
                        try {
                            ((CancellationSignal) obj).cancel();
                        } catch (Throwable th) {
                            synchronized (aVar) {
                                aVar.notifyAll();
                                throw th;
                            }
                        }
                    }
                    synchronized (aVar) {
                        aVar.notifyAll();
                    }
                }
            }
        }
        a0();
    }

    public final void a0() {
        this.a0 = false;
        b.l.a.e eVarG = g();
        b.l.a.k kVar = this.s;
        if (kVar != null) {
            b.l.a.a aVar = new b.l.a.a(kVar);
            aVar.f(this);
            aVar.e();
        }
        if (a.a.a.a.a.Q() || !(eVarG instanceof DeviceCredentialHandlerActivity) || eVarG.isFinishing()) {
            return;
        }
        eVarG.finish();
    }

    public final void b0(int i) {
        int i2;
        if (a.a.a.a.a.Q()) {
            return;
        }
        BiometricPrompt.b bVar = this.Y;
        Context context = this.c0;
        if (i != 1) {
            switch (i) {
                case 10:
                    i2 = n.fingerprint_error_user_canceled;
                    break;
                case 11:
                    i2 = n.fingerprint_error_no_fingerprints;
                    break;
                case 12:
                    i2 = n.fingerprint_error_hw_not_present;
                    break;
                default:
                    Log.e("FingerprintHelperFrag", "Unknown error code: " + i);
                    i2 = n.default_error_msg;
                    break;
            }
        } else {
            i2 = n.fingerprint_error_hw_not_available;
        }
        context.getString(i2);
        if (((SendMoney.a) bVar) == null) {
            throw null;
        }
    }

    public void c0(Handler handler) {
        this.Z = handler;
        this.W = new b(handler);
    }
}
