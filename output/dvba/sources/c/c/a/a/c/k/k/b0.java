package c.c.a.a.c.k.k;

import android.util.Log;
import c.c.a.a.c.k.k.d;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.c.a.a.g.b.l f1306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f1307c;

    public b0(z zVar, c.c.a.a.g.b.l lVar) {
        this.f1307c = zVar;
        this.f1306b = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z zVar = this.f1307c;
        c.c.a.a.g.b.l lVar = this.f1306b;
        if (zVar == null) {
            throw null;
        }
        c.c.a.a.c.a aVar = lVar.f1496c;
        if (aVar.h()) {
            c.c.a.a.c.l.s sVar = lVar.d;
            aVar = sVar.d;
            if (aVar.h()) {
                a0 a0Var = zVar.g;
                c.c.a.a.c.l.k kVarH = sVar.h();
                Set<Scope> set = zVar.d;
                d.b bVar = (d.b) a0Var;
                if (bVar == null) {
                    throw null;
                }
                if (kVarH == null || set == null) {
                    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                    bVar.b(new c.c.a.a.c.a(4));
                } else {
                    bVar.f1316c = kVarH;
                    bVar.d = set;
                    if (bVar.e) {
                        bVar.f1314a.n(kVarH, set);
                    }
                }
            } else {
                String strValueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(strValueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                ((d.b) zVar.g).b(aVar);
            }
        } else {
            ((d.b) zVar.g).b(aVar);
        }
        zVar.f.g();
    }
}
