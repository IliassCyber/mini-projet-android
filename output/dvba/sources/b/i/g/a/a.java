package b.i.g.a;

import android.hardware.fingerprint.FingerprintManager;
import android.util.Log;
import b.d.c;
import b.d.e;
import b.d.f;
import b.d.h;
import b.d.n;
import b.i.g.a.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends FingerprintManager.AuthenticationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f760a;

    public a(b.a aVar) {
        this.f760a = aVar;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        boolean z;
        e.a aVar = (e.a) this.f760a;
        if (aVar == null) {
            throw null;
        }
        if (i == 5) {
            if (e.this.d0 == 0) {
            }
            e.this.a0();
        }
        if (i != 7 && i != 9) {
            if (charSequence == null) {
                Log.e("FingerprintHelperFrag", "Got null string for error message: " + i);
                charSequence = e.this.c0.getResources().getString(n.default_error_msg);
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    z = false;
                    break;
                case 6:
                default:
                    z = true;
                    break;
            }
            if (z) {
                i = 8;
            }
            e.this.W.f561a.obtainMessage(2, i, 0, charSequence).sendToTarget();
            e.this.Z.postDelayed(new f(aVar, i, charSequence), c.d0(e.this.k()));
            return;
        }
        aVar.a(i, charSequence);
        e.this.a0();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        e.a aVar = (e.a) this.f760a;
        e eVar = e.this;
        e.b bVar = eVar.W;
        bVar.f561a.obtainMessage(1, eVar.c0.getResources().getString(n.fingerprint_not_recognized)).sendToTarget();
        e.this.X.execute(new h(aVar));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        e.this.W.f561a.obtainMessage(1, charSequence).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult r5) {
        /*
            r4 = this;
            b.i.g.a.b$a r0 = r4.f760a
            android.hardware.fingerprint.FingerprintManager$CryptoObject r5 = r5.getCryptoObject()
            r1 = 0
            if (r5 != 0) goto La
            goto L3a
        La:
            javax.crypto.Cipher r2 = r5.getCipher()
            if (r2 == 0) goto L1a
            b.i.g.a.b$b r2 = new b.i.g.a.b$b
            javax.crypto.Cipher r5 = r5.getCipher()
            r2.<init>(r5)
            goto L3b
        L1a:
            java.security.Signature r2 = r5.getSignature()
            if (r2 == 0) goto L2a
            b.i.g.a.b$b r2 = new b.i.g.a.b$b
            java.security.Signature r5 = r5.getSignature()
            r2.<init>(r5)
            goto L3b
        L2a:
            javax.crypto.Mac r2 = r5.getMac()
            if (r2 == 0) goto L3a
            b.i.g.a.b$b r2 = new b.i.g.a.b$b
            javax.crypto.Mac r5 = r5.getMac()
            r2.<init>(r5)
            goto L3b
        L3a:
            r2 = r1
        L3b:
            b.d.e$a r0 = (b.d.e.a) r0
            b.d.e r5 = b.d.e.this
            b.d.e$b r5 = r5.W
            r3 = 5
            r5.a(r3)
            androidx.biometric.BiometricPrompt$c r5 = new androidx.biometric.BiometricPrompt$c
            if (r2 != 0) goto L4a
            goto L67
        L4a:
            javax.crypto.Cipher r3 = r2.f763b
            if (r3 == 0) goto L54
            androidx.biometric.BiometricPrompt$d r1 = new androidx.biometric.BiometricPrompt$d
            r1.<init>(r3)
            goto L67
        L54:
            java.security.Signature r3 = r2.f762a
            if (r3 == 0) goto L5e
            androidx.biometric.BiometricPrompt$d r1 = new androidx.biometric.BiometricPrompt$d
            r1.<init>(r3)
            goto L67
        L5e:
            javax.crypto.Mac r2 = r2.f764c
            if (r2 == 0) goto L67
            androidx.biometric.BiometricPrompt$d r1 = new androidx.biometric.BiometricPrompt$d
            r1.<init>(r2)
        L67:
            r5.<init>(r1)
            b.d.e r1 = b.d.e.this
            java.util.concurrent.Executor r1 = r1.X
            b.d.g r2 = new b.d.g
            r2.<init>(r0, r5)
            r1.execute(r2)
            b.d.e r5 = b.d.e.this
            r5.a0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.g.a.a.onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager$AuthenticationResult):void");
    }
}
