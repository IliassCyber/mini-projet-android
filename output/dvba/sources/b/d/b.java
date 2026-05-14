package b.d;

import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f551c;
    public e d;
    public Executor e;
    public BiometricPrompt.b f;
    public boolean g;
    public int h = 0;
    public int i = 0;

    public static b a() {
        if (j == null) {
            j = new b();
        }
        return j;
    }

    public void b() {
        int i = this.i;
        if (i == 2) {
            return;
        }
        if (i == 1) {
            this.i = 0;
            return;
        }
        this.f549a = 0;
        this.f550b = null;
        this.f551c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = 0;
        this.g = false;
        j = null;
    }
}
