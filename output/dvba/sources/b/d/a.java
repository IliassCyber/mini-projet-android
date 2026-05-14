package b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.DeviceCredentialHandlerActivity;
import androidx.fragment.app.Fragment;
import com.app.damnvulnerablebank.SendMoney;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
public class a extends Fragment {
    public Context W;
    public Bundle X;
    public Executor Y;
    public DialogInterface.OnClickListener Z;
    public BiometricPrompt.b a0;
    public BiometricPrompt.d b0;
    public CharSequence c0;
    public boolean d0;
    public android.hardware.biometrics.BiometricPrompt e0;
    public CancellationSignal f0;
    public boolean g0;
    public final Handler h0 = new Handler(Looper.getMainLooper());
    public final Executor i0 = new ExecutorC0016a();
    public final BiometricPrompt.AuthenticationCallback j0 = new b();
    public final DialogInterface.OnClickListener k0 = new c();
    public final DialogInterface.OnClickListener l0 = new d();

    /* JADX INFO: renamed from: b.d.a$a, reason: collision with other inner class name */
    public class ExecutorC0016a implements Executor {
        public ExecutorC0016a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.this.h0.post(runnable);
        }
    }

    public class b extends BiometricPrompt.AuthenticationCallback {

        /* JADX INFO: renamed from: b.d.a$b$a, reason: collision with other inner class name */
        public class RunnableC0017a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CharSequence f541b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f542c;

            public RunnableC0017a(CharSequence charSequence, int i) {
                this.f541b = charSequence;
                this.f542c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f541b == null) {
                    a.this.W.getString(n.default_error_msg);
                }
                if (((SendMoney.a) a.this.a0) == null) {
                    throw null;
                }
            }
        }

        /* JADX INFO: renamed from: b.d.a$b$b, reason: collision with other inner class name */
        public class RunnableC0018b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BiometricPrompt.c f543b;

            public RunnableC0018b(BiometricPrompt.c cVar) {
                this.f543b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a0.a(this.f543b);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((SendMoney.a) a.this.a0) == null) {
                    throw null;
                }
            }
        }

        public b() {
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            if (a.a.a.a.a.Q()) {
                return;
            }
            a.this.Y.execute(new RunnableC0017a(charSequence, i));
            a.this.a0();
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            a.this.Y.execute(new c());
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            BiometricPrompt.c cVar;
            BiometricPrompt.d dVar = null;
            if (authenticationResult != null) {
                BiometricPrompt.CryptoObject cryptoObject = authenticationResult.getCryptoObject();
                if (cryptoObject != null) {
                    if (cryptoObject.getCipher() != null) {
                        dVar = new BiometricPrompt.d(cryptoObject.getCipher());
                    } else if (cryptoObject.getSignature() != null) {
                        dVar = new BiometricPrompt.d(cryptoObject.getSignature());
                    } else if (cryptoObject.getMac() != null) {
                        dVar = new BiometricPrompt.d(cryptoObject.getMac());
                    }
                }
                cVar = new BiometricPrompt.c(dVar);
            } else {
                cVar = new BiometricPrompt.c(null);
            }
            a.this.Y.execute(new RunnableC0018b(cVar));
            a.this.a0();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.Z.onClick(dialogInterface, i);
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                a.a.a.a.a.T("BiometricFragment", a.this.g(), a.this.X, null);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A(Bundle bundle) {
        super.A(bundle);
        X(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View B(android.view.LayoutInflater r5, android.view.ViewGroup r6, android.os.Bundle r7) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.B(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void Z() {
        if (Build.VERSION.SDK_INT >= 29) {
            Bundle bundle = this.X;
            boolean z = false;
            if (bundle != null && bundle.getBoolean("allow_device_credential", false)) {
                z = true;
            }
            if (z && !this.g0) {
                Log.w("BiometricFragment", "Ignoring fast cancel signal");
                return;
            }
        }
        CancellationSignal cancellationSignal = this.f0;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        a0();
    }

    public void a0() {
        this.d0 = false;
        b.l.a.e eVarG = g();
        b.l.a.k kVar = this.s;
        if (kVar != null) {
            b.l.a.a aVar = new b.l.a.a(kVar);
            aVar.f(this);
            aVar.e();
        }
        if (!(eVarG instanceof DeviceCredentialHandlerActivity) || eVarG.isFinishing()) {
            return;
        }
        eVarG.finish();
    }

    public void b0(Executor executor, DialogInterface.OnClickListener onClickListener, BiometricPrompt.b bVar) {
        this.Y = executor;
        this.Z = onClickListener;
        this.a0 = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void z(Context context) {
        super.z(context);
        this.W = context;
    }
}
