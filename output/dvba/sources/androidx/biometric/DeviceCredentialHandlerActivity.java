package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import b.b.k.h;
import b.d.b;
import b.d.m;
import b.d.o;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SyntheticAccessor"})
public class DeviceCredentialHandlerActivity extends h {
    public boolean p;

    @Override // b.l.a.e, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        u(i2);
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        BiometricPrompt.b bVar;
        b bVarA = b.a();
        int i = bVarA.f549a;
        if (i != 0) {
            setTheme(i);
            getTheme().applyStyle(o.TransparentStyle, true);
        }
        super.onCreate(bundle);
        boolean z = bundle != null && bundle.getBoolean("did_change_configuration", false);
        this.p = z;
        if (z) {
            this.p = false;
        } else {
            bVarA.i = 0;
        }
        setTitle((CharSequence) null);
        setContentView(m.device_credential_handler_activity);
        Executor executor = bVarA.e;
        if (executor != null && (bVar = bVarA.f) != null) {
            new BiometricPrompt(this, executor, bVar).b(new BiometricPrompt.e(getIntent().getBundleExtra("prompt_info_bundle")));
        } else {
            Log.e("DeviceCredentialHandler", "onCreate: Executor and/or callback was null!");
            finish();
        }
    }

    @Override // b.l.a.e, android.app.Activity
    public void onPause() {
        super.onPause();
        b bVar = b.j;
        if (!isChangingConfigurations() || bVar == null) {
            return;
        }
        if (bVar.i == 0) {
            bVar.i = 1;
        }
        this.p = true;
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("did_change_configuration", this.p);
    }

    public void u(int i) {
        b bVar = b.j;
        if (bVar == null) {
            Log.e("DeviceCredentialHandler", "onActivityResult: Bridge or callback was null!");
        } else {
            if (i == -1) {
                bVar.h = 1;
            } else {
                bVar.h = 2;
            }
            bVar.g = false;
            bVar.i = 2;
        }
        finish();
    }
}
