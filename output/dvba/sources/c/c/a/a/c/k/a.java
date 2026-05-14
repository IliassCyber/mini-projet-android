package c.c.a.a.c.k;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import c.c.a.a.c.k.a.d;
import c.c.a.a.c.l.b;
import c.c.a.a.c.l.k;
import c.c.a.a.c.l.q;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a<O extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0053a<?, O> f1293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1294b;

    /* JADX INFO: renamed from: c.c.a.a.c.k.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0053a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, c.c.a.a.c.l.c cVar, O o, c.c.a.a.c.k.d dVar, c.c.a.a.c.k.e eVar) {
            return (T) b(context, looper, cVar, o, dVar, eVar);
        }

        public T b(Context context, Looper looper, c.c.a.a.c.l.c cVar, O o, c.c.a.a.c.k.k.c cVar2, c.c.a.a.c.k.k.h hVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* JADX INFO: renamed from: c.c.a.a.c.k.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0054a extends d {
            Account a();
        }

        public interface b extends d {
            GoogleSignInAccount b();
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void b(b.e eVar);

        void c(b.c cVar);

        boolean d();

        c.c.a.a.c.c[] e();

        boolean f();

        void g();

        String i();

        boolean j();

        boolean l();

        Set<Scope> m();

        void n(k kVar, Set<Scope> set);

        int o();
    }

    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0053a<C, O> abstractC0053a, g<C> gVar) {
        q.g(abstractC0053a, "Cannot construct an Api with a null ClientBuilder");
        q.g(gVar, "Cannot construct an Api with a null ClientKey");
        this.f1294b = str;
        this.f1293a = abstractC0053a;
    }
}
