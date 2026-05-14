package b.i.g.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f761a;

    public static abstract class a {
    }

    /* JADX INFO: renamed from: b.i.g.a.b$b, reason: collision with other inner class name */
    public static class C0028b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Signature f762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Cipher f763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Mac f764c;

        public C0028b(Signature signature) {
            this.f762a = signature;
            this.f763b = null;
            this.f764c = null;
        }

        public C0028b(Cipher cipher) {
            this.f763b = cipher;
            this.f762a = null;
            this.f764c = null;
        }

        public C0028b(Mac mac) {
            this.f764c = mac;
            this.f763b = null;
            this.f762a = null;
        }
    }

    public b(Context context) {
        this.f761a = context;
    }

    public static FingerprintManager a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i != 23 && (i <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint"))) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public boolean b() {
        FingerprintManager fingerprintManagerA;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerA = a(this.f761a)) != null && fingerprintManagerA.hasEnrolledFingerprints();
    }

    public boolean c() {
        FingerprintManager fingerprintManagerA;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerA = a(this.f761a)) != null && fingerprintManagerA.isHardwareDetected();
    }
}
