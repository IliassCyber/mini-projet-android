package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import b.d.c;
import b.l.a.j;
import b.l.a.k;
import b.n.d;
import b.n.f;
import b.n.n;
import com.app.damnvulnerablebank.SendMoney;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
public class BiometricPrompt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.l.a.e f101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f103c;
    public b.d.c d;
    public b.d.e e;
    public b.d.a f;
    public boolean g;
    public boolean h;
    public final DialogInterface.OnClickListener i = new a();
    public final f j;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: androidx.biometric.BiometricPrompt$a$a, reason: collision with other inner class name */
        public class RunnableC0003a implements Runnable {
            public RunnableC0003a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BiometricPrompt biometricPrompt;
                b.d.a aVar;
                if (BiometricPrompt.c() && (aVar = (biometricPrompt = BiometricPrompt.this).f) != null) {
                    CharSequence charSequence = aVar.c0;
                    if (((SendMoney.a) biometricPrompt.f103c) == null) {
                        throw null;
                    }
                    BiometricPrompt.this.f.a0();
                    return;
                }
                BiometricPrompt biometricPrompt2 = BiometricPrompt.this;
                b.d.c cVar = biometricPrompt2.d;
                if (cVar == null || biometricPrompt2.e == null) {
                    Log.e("BiometricPromptCompat", "Negative button callback not run. Fragment was null.");
                    return;
                }
                cVar.i0.getCharSequence("negative_text");
                if (((SendMoney.a) BiometricPrompt.this.f103c) == null) {
                    throw null;
                }
                BiometricPrompt.this.e.Z(2);
            }
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BiometricPrompt.this.f102b.execute(new RunnableC0003a());
        }
    }

    public static abstract class b {
        public abstract void a(c cVar);
    }

    public static class c {
        public c(d dVar) {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Signature f107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Cipher f108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Mac f109c;

        public d(Signature signature) {
            this.f107a = signature;
            this.f108b = null;
            this.f109c = null;
        }

        public d(Cipher cipher) {
            this.f108b = cipher;
            this.f107a = null;
            this.f109c = null;
        }

        public d(Mac mac) {
            this.f109c = mac;
            this.f108b = null;
            this.f107a = null;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f110a;

        public e(Bundle bundle) {
            this.f110a = bundle;
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(b.l.a.e eVar, Executor executor, b bVar) {
        f fVar = new f() { // from class: androidx.biometric.BiometricPrompt.2
            @n(d.a.ON_PAUSE)
            public void onPause() {
                b.d.e eVar2;
                b.d.a aVar;
                BiometricPrompt biometricPrompt = BiometricPrompt.this;
                boolean z = false;
                if (biometricPrompt.d() != null && biometricPrompt.d().isChangingConfigurations()) {
                    return;
                }
                if (!BiometricPrompt.c() || (aVar = BiometricPrompt.this.f) == null) {
                    BiometricPrompt biometricPrompt2 = BiometricPrompt.this;
                    b.d.c cVar = biometricPrompt2.d;
                    if (cVar != null && (eVar2 = biometricPrompt2.e) != null) {
                        cVar.c0();
                        eVar2.Z(0);
                    }
                } else {
                    Bundle bundle = aVar.X;
                    if (bundle != null && bundle.getBoolean("allow_device_credential", false)) {
                        z = true;
                    }
                    BiometricPrompt biometricPrompt3 = BiometricPrompt.this;
                    if (!z || biometricPrompt3.g) {
                        biometricPrompt3.f.Z();
                    } else {
                        biometricPrompt3.g = true;
                    }
                }
                if (BiometricPrompt.this == null) {
                    throw null;
                }
                b.d.b bVar2 = b.d.b.j;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }

            @n(d.a.ON_RESUME)
            public void onResume() {
                b.d.b bVar2;
                BiometricPrompt biometricPrompt;
                b.d.a aVar;
                BiometricPrompt.this.f = BiometricPrompt.c() ? (b.d.a) BiometricPrompt.a(BiometricPrompt.this).b("BiometricFragment") : null;
                if (!BiometricPrompt.c() || (aVar = (biometricPrompt = BiometricPrompt.this).f) == null) {
                    BiometricPrompt biometricPrompt2 = BiometricPrompt.this;
                    biometricPrompt2.d = (b.d.c) BiometricPrompt.a(biometricPrompt2).b("FingerprintDialogFragment");
                    BiometricPrompt biometricPrompt3 = BiometricPrompt.this;
                    biometricPrompt3.e = (b.d.e) BiometricPrompt.a(biometricPrompt3).b("FingerprintHelperFragment");
                    BiometricPrompt biometricPrompt4 = BiometricPrompt.this;
                    b.d.c cVar = biometricPrompt4.d;
                    if (cVar != null) {
                        cVar.q0 = biometricPrompt4.i;
                    }
                    BiometricPrompt biometricPrompt5 = BiometricPrompt.this;
                    b.d.e eVar2 = biometricPrompt5.e;
                    if (eVar2 != null) {
                        Executor executor2 = biometricPrompt5.f102b;
                        b bVar3 = biometricPrompt5.f103c;
                        eVar2.X = executor2;
                        eVar2.Y = bVar3;
                        b.d.c cVar2 = biometricPrompt5.d;
                        if (cVar2 != null) {
                            eVar2.c0(cVar2.h0);
                        }
                    }
                } else {
                    aVar.b0(biometricPrompt.f102b, biometricPrompt.i, biometricPrompt.f103c);
                }
                BiometricPrompt biometricPrompt6 = BiometricPrompt.this;
                if (!biometricPrompt6.h && (bVar2 = b.d.b.j) != null) {
                    int i = bVar2.h;
                    if (i == 1) {
                        biometricPrompt6.f103c.a(new c(null));
                    } else if (i == 2) {
                        if (biometricPrompt6.d() != null) {
                            biometricPrompt6.d().getString(b.d.n.generic_error_user_canceled);
                        }
                        if (((SendMoney.a) biometricPrompt6.f103c) == null) {
                            throw null;
                        }
                    }
                    bVar2.i = 0;
                    bVar2.b();
                }
                BiometricPrompt.this.e(false);
            }
        };
        this.j = fVar;
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("AuthenticationCallback must not be null");
        }
        this.f101a = eVar;
        this.f103c = bVar;
        this.f102b = executor;
        eVar.f28c.a(fVar);
    }

    public static j a(BiometricPrompt biometricPrompt) {
        b.l.a.e eVar = biometricPrompt.f101a;
        if (eVar != null) {
            return eVar.m();
        }
        throw null;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public void b(e eVar) {
        b.l.a.a aVar;
        Fragment fragment;
        b.l.a.a aVar2;
        b.i.g.a.b bVar;
        BiometricManager biometricManager;
        String str;
        this.h = eVar.f110a.getBoolean("handling_device_credential_result");
        b.l.a.e eVarD = d();
        if (eVar.f110a.getBoolean("allow_device_credential") && Build.VERSION.SDK_INT <= 28) {
            if (!this.h) {
                b.l.a.e eVarD2 = d();
                if (eVarD2 == null || eVarD2.isFinishing()) {
                    Log.w("BiometricPromptCompat", "Failed to start handler activity. Parent activity was null or finishing.");
                    return;
                }
                e(true);
                Bundle bundle = eVar.f110a;
                bundle.putBoolean("handling_device_credential_result", true);
                Intent intent = new Intent(eVarD2, (Class<?>) DeviceCredentialHandlerActivity.class);
                intent.putExtra("prompt_info_bundle", bundle);
                eVarD2.startActivity(intent);
                return;
            }
            if (eVarD == null) {
                str = "Failed to authenticate with device credential. Activity was null.";
            } else {
                b.d.b bVar2 = b.d.b.j;
                if (bVar2 == null) {
                    str = "Failed to authenticate with device credential. Bridge was null.";
                } else if (!bVar2.g) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        biometricManager = (BiometricManager) eVarD.getSystemService(BiometricManager.class);
                        bVar = null;
                    } else {
                        bVar = new b.i.g.a.b(eVarD);
                        biometricManager = null;
                    }
                    if ((Build.VERSION.SDK_INT >= 29 ? biometricManager.canAuthenticate() : !bVar.c() ? 12 : !bVar.b() ? 11 : 0) != 0) {
                        a.a.a.a.a.T("BiometricPromptCompat", eVarD, eVar.f110a, null);
                        return;
                    }
                }
            }
            Log.e("BiometricPromptCompat", str);
            return;
        }
        b.l.a.e eVar2 = this.f101a;
        if (eVar2 == null) {
            throw null;
        }
        j jVarM = eVar2.m();
        if (jVarM.c()) {
            Log.w("BiometricPromptCompat", "Not launching prompt. authenticate() called after onSaveInstanceState()");
            return;
        }
        Bundle bundle2 = eVar.f110a;
        this.g = false;
        if (c()) {
            b.d.a aVar3 = (b.d.a) jVarM.b("BiometricFragment");
            if (aVar3 != null) {
                this.f = aVar3;
            } else {
                this.f = new b.d.a();
            }
            this.f.b0(this.f102b, this.i, this.f103c);
            b.d.a aVar4 = this.f;
            aVar4.b0 = null;
            aVar4.X = bundle2;
            if (aVar3 == null) {
                aVar2 = new b.l.a.a((k) jVarM);
                aVar2.b(this.f, "BiometricFragment");
                aVar2.e();
            } else if (aVar4.A) {
                aVar = new b.l.a.a((k) jVarM);
                fragment = this.f;
                aVar2 = aVar;
                aVar2.d(fragment);
                aVar2.e();
            }
        } else {
            b.d.c cVar = (b.d.c) jVarM.b("FingerprintDialogFragment");
            if (cVar != null) {
                this.d = cVar;
            } else {
                this.d = new b.d.c();
            }
            b.d.c cVar2 = this.d;
            cVar2.q0 = this.i;
            cVar2.i0 = bundle2;
            if (eVarD != null && !a.a.a.a.a.y0(eVarD, Build.MODEL)) {
                b.d.c cVar3 = this.d;
                if (cVar == null) {
                    cVar3.b0(jVarM, "FingerprintDialogFragment");
                } else if (cVar3.A) {
                    b.l.a.a aVar5 = new b.l.a.a((k) jVarM);
                    aVar5.d(this.d);
                    aVar5.e();
                }
            }
            b.d.e eVar3 = (b.d.e) jVarM.b("FingerprintHelperFragment");
            if (eVar3 != null) {
                this.e = eVar3;
            } else {
                this.e = new b.d.e();
            }
            b.d.e eVar4 = this.e;
            Executor executor = this.f102b;
            b bVar3 = this.f103c;
            eVar4.X = executor;
            eVar4.Y = bVar3;
            c.HandlerC0020c handlerC0020c = this.d.h0;
            eVar4.c0(handlerC0020c);
            this.e.b0 = null;
            handlerC0020c.sendMessageDelayed(handlerC0020c.obtainMessage(6), 500L);
            if (eVar3 == null) {
                aVar2 = new b.l.a.a((k) jVarM);
                aVar2.b(this.e, "FingerprintHelperFragment");
                aVar2.e();
            } else if (this.e.A) {
                aVar = new b.l.a.a((k) jVarM);
                fragment = this.e;
                aVar2 = aVar;
                aVar2.d(fragment);
                aVar2.e();
            }
        }
        k kVar = (k) jVarM;
        kVar.P();
        kVar.U();
    }

    public final b.l.a.e d() {
        b.l.a.e eVar = this.f101a;
        if (eVar != null) {
            return eVar;
        }
        throw null;
    }

    public final void e(boolean z) {
        b.d.e eVar;
        b.d.e eVar2;
        b.d.a aVar;
        if (Build.VERSION.SDK_INT >= 29) {
            return;
        }
        b.d.b bVarA = b.d.b.a();
        if (!this.h) {
            b.l.a.e eVarD = d();
            if (eVarD != null) {
                try {
                    bVarA.f549a = eVarD.getPackageManager().getActivityInfo(eVarD.getComponentName(), 0).getThemeResource();
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e("BiometricPromptCompat", "Failed to register client theme to bridge", e2);
                }
            }
        } else if (!c() || (aVar = this.f) == null) {
            b.d.c cVar = this.d;
            if (cVar != null && (eVar2 = this.e) != null) {
                bVarA.f551c = cVar;
                bVarA.d = eVar2;
            }
        } else {
            bVarA.f550b = aVar;
        }
        Executor executor = this.f102b;
        DialogInterface.OnClickListener onClickListener = this.i;
        b bVar = this.f103c;
        bVarA.e = executor;
        bVarA.f = bVar;
        b.d.a aVar2 = bVarA.f550b;
        if (aVar2 == null || Build.VERSION.SDK_INT < 28) {
            b.d.c cVar2 = bVarA.f551c;
            if (cVar2 != null && (eVar = bVarA.d) != null) {
                cVar2.q0 = onClickListener;
                eVar.X = executor;
                eVar.Y = bVar;
                eVar.c0(cVar2.h0);
            }
        } else {
            aVar2.Y = executor;
            aVar2.Z = onClickListener;
            aVar2.a0 = bVar;
        }
        if (z) {
            bVarA.i = 2;
        }
    }
}
