package c.c.a.a.g.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.a.c.k.k.b0;
import c.c.a.a.c.k.k.z;
import c.c.a.a.c.l.b;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.r;

/* JADX INFO: loaded from: classes.dex */
public class a extends c.c.a.a.c.l.g<f> implements c.c.a.a.g.e {
    public Integer A;
    public final boolean x;
    public final c.c.a.a.c.l.c y;
    public final Bundle z;

    public a(Context context, Looper looper, c.c.a.a.c.l.c cVar, c.c.a.a.c.k.d dVar, c.c.a.a.c.k.e eVar) {
        c.c.a.a.g.a aVar = cVar.g;
        Integer num = cVar.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.f1364a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", aVar.f1487b);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", aVar.f1488c);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", aVar.d);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", aVar.e);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", aVar.f);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", aVar.g);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", aVar.h);
            Long l = aVar.i;
            if (l != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", l.longValue());
            }
            Long l2 = aVar.j;
            if (l2 != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", l2.longValue());
            }
        }
        super(context, looper, 44, cVar, dVar, eVar);
        this.x = true;
        this.y = cVar;
        this.z = bundle;
        this.A = cVar.h;
    }

    @Override // c.c.a.a.g.e
    public final void h() {
        b.d dVar = new b.d();
        q.g(dVar, "Connection progress callbacks cannot be null.");
        this.h = dVar;
        x(2, null);
    }

    @Override // c.c.a.a.c.l.b, c.c.a.a.c.k.a.f
    public boolean j() {
        return this.x;
    }

    @Override // c.c.a.a.g.e
    public final void k(d dVar) {
        q.g(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.y.f1364a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            ((f) s()).m(new j(new r(account, this.A.intValue(), "<<default account>>".equals(account.name) ? c.c.a.a.a.a.a.a.a.a(this.f1353b).b() : null)), dVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                z zVar = (z) dVar;
                zVar.f1348b.post(new b0(zVar, new l()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // c.c.a.a.c.l.g, c.c.a.a.c.k.a.f
    public int o() {
        return 12451000;
    }

    @Override // c.c.a.a.c.l.b
    public /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new h(iBinder);
    }

    @Override // c.c.a.a.c.l.b
    public Bundle r() {
        if (!this.f1353b.getPackageName().equals(this.y.e)) {
            this.z.putString("com.google.android.gms.signin.internal.realClientPackageName", this.y.e);
        }
        return this.z;
    }

    @Override // c.c.a.a.c.l.b
    public String t() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // c.c.a.a.c.l.b
    public String u() {
        return "com.google.android.gms.signin.service.START";
    }
}
