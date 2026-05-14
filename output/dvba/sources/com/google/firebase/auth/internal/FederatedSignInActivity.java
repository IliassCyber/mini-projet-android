package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import b.l.a.e;
import b.p.a.a;
import c.c.a.a.c.l.q;
import c.c.b.h.d0.j;
import c.c.b.h.d0.n;
import c.c.b.h.d0.t;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class FederatedSignInActivity extends e {
    public static long o;
    public static final j p = j.f1845b;
    public static Handler q;
    public static Runnable r;
    public boolean n = false;

    @Override // b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String strValueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", strValueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(strValueOf) : new String("Could not do operation - unknown action: "));
            q();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - o < 30000) {
            Log.e("IdpSignInActivity", "Could not start operation - already in progress");
            return;
        }
        o = jCurrentTimeMillis;
        if (bundle != null) {
            this.n = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    @Override // b.l.a.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        Runnable runnable;
        super.onNewIntent(intent);
        Handler handler = q;
        if (handler != null && (runnable = r) != null) {
            handler.removeCallbacks(runnable);
            r = null;
        }
        setIntent(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    @Override // b.l.a.e, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    @Override // b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.n);
    }

    public final void q() {
        o = 0L;
        this.n = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (a.a(this).b(intent)) {
            p.a(this);
        } else {
            n.a(this, q.p0("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    public final void r(Status status) {
        o = 0L;
        this.n = false;
        Intent intent = new Intent();
        t.a(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (a.a(this).b(intent)) {
            p.a(this);
        } else {
            n.a(getApplicationContext(), status);
        }
        finish();
    }
}
