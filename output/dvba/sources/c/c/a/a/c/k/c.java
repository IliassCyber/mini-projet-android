package c.c.a.a.c.k;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.c.a.a.c.k.a;
import c.c.a.a.c.k.a.d;
import c.c.a.a.c.k.k.h0;
import c.c.a.a.c.k.k.k;
import c.c.a.a.c.k.k.v;
import c.c.a.a.c.l.c;
import c.c.a.a.c.l.q;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<O>] */
/* JADX INFO: loaded from: classes.dex */
public class c<O extends a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.a.a.c.k.a<O> f1296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O f1297c;
    public final c.c.a.a.c.k.k.a<O> d;
    public final int e;
    public final c.c.a.a.c.k.k.j f;
    public final c.c.a.a.c.k.k.d g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.c.a.a.c.k.k.j f1298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f1299b;

        static {
            Looper.getMainLooper();
        }

        public a(c.c.a.a.c.k.k.j jVar, Account account, Looper looper) {
            this.f1298a = jVar;
            this.f1299b = looper;
        }
    }

    @Deprecated
    public c(Context context, c.c.a.a.c.k.a<O> aVar, O o, c.c.a.a.c.k.k.j jVar) {
        q.g(jVar, "StatusExceptionMapper must not be null.");
        a aVar2 = new a(jVar, null, Looper.getMainLooper());
        q.g(context, "Null context is not permitted.");
        q.g(aVar, "Api must not be null.");
        q.g(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f1295a = context.getApplicationContext();
        this.f1296b = aVar;
        this.f1297c = o;
        this.d = new c.c.a.a.c.k.k.a<>(aVar, o);
        c.c.a.a.c.k.k.d dVarA = c.c.a.a.c.k.k.d.a(this.f1295a);
        this.g = dVarA;
        this.e = dVarA.g.getAndIncrement();
        this.f = aVar2.f1298a;
        Handler handler = this.g.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    public c.a a() {
        GoogleSignInAccount googleSignInAccountB;
        GoogleSignInAccount googleSignInAccountB2;
        c.a aVar = new c.a();
        O o = this.f1297c;
        Account accountA = null;
        if (!(o instanceof a.d.b) || (googleSignInAccountB2 = ((a.d.b) o).b()) == null) {
            O o2 = this.f1297c;
            if (o2 instanceof a.d.InterfaceC0054a) {
                accountA = ((a.d.InterfaceC0054a) o2).a();
            }
        } else if (googleSignInAccountB2.e != null) {
            accountA = new Account(googleSignInAccountB2.e, "com.google");
        }
        aVar.f1367a = accountA;
        O o3 = this.f1297c;
        Set<Scope> setEmptySet = (!(o3 instanceof a.d.b) || (googleSignInAccountB = ((a.d.b) o3).b()) == null) ? Collections.emptySet() : googleSignInAccountB.h();
        if (aVar.f1368b == null) {
            aVar.f1368b = new b.f.c<>();
        }
        aVar.f1368b.addAll(setEmptySet);
        aVar.e = this.f1295a.getClass().getName();
        aVar.d = this.f1295a.getPackageName();
        return aVar;
    }

    public final <TResult, A extends a.b> c.c.a.a.h.d<TResult> b(int i, k<A, TResult> kVar) {
        c.c.a.a.h.e eVar = new c.c.a.a.h.e();
        c.c.a.a.c.k.k.d dVar = this.g;
        h0 h0Var = new h0(i, kVar, eVar, this.f);
        Handler handler = dVar.m;
        handler.sendMessage(handler.obtainMessage(4, new v(h0Var, dVar.h.get(), this)));
        return eVar.f1500a;
    }
}
