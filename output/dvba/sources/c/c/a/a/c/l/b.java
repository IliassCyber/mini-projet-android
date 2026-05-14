package c.c.a.a.c.l;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.a.c.l.h;
import c.c.a.a.c.l.l;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends IInterface> {
    public static final c.c.a.a.c.c[] u = new c.c.a.a.c.c[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f1352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.a.a.c.l.h f1354c;
    public final Handler d;

    @GuardedBy("mServiceBrokerLock")
    public n g;
    public c h;

    @GuardedBy("mLock")
    public T i;

    @GuardedBy("mLock")
    public j k;
    public final a m;
    public final InterfaceC0055b n;
    public final int o;
    public final String p;
    public final Object e = new Object();
    public final Object f = new Object();
    public final ArrayList<h<?>> j = new ArrayList<>();

    @GuardedBy("mLock")
    public int l = 1;
    public c.c.a.a.c.a q = null;
    public boolean r = false;
    public volatile a0 s = null;
    public AtomicInteger t = new AtomicInteger(0);

    public interface a {
    }

    /* JADX INFO: renamed from: c.c.a.a.c.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0055b {
    }

    public interface c {
        void a(c.c.a.a.c.a aVar);
    }

    public class d implements c {
        public d() {
        }

        @Override // c.c.a.a.c.l.b.c
        public void a(c.c.a.a.c.a aVar) {
            if (aVar.h()) {
                b bVar = b.this;
                bVar.n(null, ((c.c.a.a.c.l.g) bVar).v);
            } else {
                InterfaceC0055b interfaceC0055b = b.this.n;
                if (interfaceC0055b != null) {
                    ((x) interfaceC0055b).f1409a.t(aVar);
                }
            }
        }
    }

    public interface e {
    }

    public abstract class f extends h<Boolean> {
        public final int d;
        public final Bundle e;

        public f(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.d = i;
            this.e = bundle;
        }

        @Override // c.c.a.a.c.l.b.h
        public final /* synthetic */ void b(Boolean bool) {
            c.c.a.a.c.a aVar;
            int i = this.d;
            if (i != 0) {
                if (i == 10) {
                    b.this.x(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), b.this.u(), b.this.t()));
                }
                b.this.x(1, null);
                Bundle bundle = this.e;
                aVar = new c.c.a.a.c.a(this.d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            } else {
                if (d()) {
                    return;
                }
                b.this.x(1, null);
                aVar = new c.c.a.a.c.a(8, null);
            }
            c(aVar);
        }

        public abstract void c(c.c.a.a.c.a aVar);

        public abstract boolean d();
    }

    public final class g extends c.c.a.a.f.b.d {
        public g(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            h hVar = (h) message.obj;
            if (((f) hVar) == null) {
                throw null;
            }
            hVar.a();
        }

        public static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void handleMessage(android.os.Message r8) {
            /*
                Method dump skipped, instruction units count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.c.l.b.g.handleMessage(android.os.Message):void");
        }
    }

    public abstract class h<TListener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TListener f1357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1358b = false;

        public h(TListener tlistener) {
            this.f1357a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f1357a = null;
            }
            synchronized (b.this.j) {
                b.this.j.remove(this);
            }
        }

        public abstract void b(TListener tlistener);
    }

    public static final class i extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f1360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1361b;

        public i(b bVar, int i) {
            this.f1360a = bVar;
            this.f1361b = i;
        }

        public final void t(int i, IBinder iBinder, Bundle bundle) {
            q.g(this.f1360a, "onPostInitComplete can be called only once per call to getRemoteService");
            b bVar = this.f1360a;
            int i2 = this.f1361b;
            Handler handler = bVar.d;
            handler.sendMessage(handler.obtainMessage(1, i2, -1, new k(i, iBinder, bundle)));
            this.f1360a = null;
        }
    }

    public final class j implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1362a;

        public j(int i) {
            this.f1362a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                b.y(bVar);
                return;
            }
            synchronized (bVar.f) {
                b bVar2 = b.this;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.g = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof n)) ? new m(iBinder) : (n) iInterfaceQueryLocalInterface;
            }
            b bVar3 = b.this;
            int i = this.f1362a;
            Handler handler = bVar3.d;
            handler.sendMessage(handler.obtainMessage(7, i, -1, new l(0)));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.f) {
                b.this.g = null;
            }
            Handler handler = b.this.d;
            handler.sendMessage(handler.obtainMessage(6, this.f1362a, 1));
        }
    }

    public final class k extends f {
        public final IBinder g;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        @Override // c.c.a.a.c.l.b.f
        public final void c(c.c.a.a.c.a aVar) {
            InterfaceC0055b interfaceC0055b = b.this.n;
            if (interfaceC0055b != null) {
                ((x) interfaceC0055b).f1409a.t(aVar);
            }
            if (b.this == null) {
                throw null;
            }
            System.currentTimeMillis();
        }

        @Override // c.c.a.a.c.l.b.f
        public final boolean d() {
            try {
                String interfaceDescriptor = this.g.getInterfaceDescriptor();
                if (!b.this.t().equals(interfaceDescriptor)) {
                    String strT = b.this.t();
                    StringBuilder sb = new StringBuilder(String.valueOf(interfaceDescriptor).length() + String.valueOf(strT).length() + 34);
                    sb.append("service descriptor mismatch: ");
                    sb.append(strT);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface iInterfaceP = b.this.p(this.g);
                if (iInterfaceP == null || !(b.z(b.this, 2, 4, iInterfaceP) || b.z(b.this, 3, 4, iInterfaceP))) {
                    return false;
                }
                b bVar = b.this;
                bVar.q = null;
                a aVar = bVar.m;
                if (aVar == null) {
                    return true;
                }
                ((w) aVar).f1408a.y(null);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class l extends f {
        public l(int i) {
            super(i, null);
        }

        @Override // c.c.a.a.c.l.b.f
        public final void c(c.c.a.a.c.a aVar) {
            b bVar = b.this;
            if (bVar == null) {
                throw null;
            }
            bVar.h.a(aVar);
            if (b.this == null) {
                throw null;
            }
            System.currentTimeMillis();
        }

        @Override // c.c.a.a.c.l.b.f
        public final boolean d() {
            b.this.h.a(c.c.a.a.c.a.f);
            return true;
        }
    }

    public b(Context context, Looper looper, c.c.a.a.c.l.h hVar, c.c.a.a.c.e eVar, int i2, a aVar, InterfaceC0055b interfaceC0055b, String str) {
        q.g(context, "Context must not be null");
        this.f1353b = context;
        q.g(looper, "Looper must not be null");
        q.g(hVar, "Supervisor must not be null");
        this.f1354c = hVar;
        q.g(eVar, "API availability must not be null");
        this.d = new g(looper);
        this.o = i2;
        this.m = aVar;
        this.n = interfaceC0055b;
        this.p = str;
    }

    public static boolean A(b bVar) {
        if (bVar.r || TextUtils.isEmpty(bVar.t()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(bVar.t());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void y(b bVar) {
        boolean z;
        int i2;
        synchronized (bVar.e) {
            z = bVar.l == 3;
        }
        if (z) {
            i2 = 5;
            bVar.r = true;
        } else {
            i2 = 4;
        }
        Handler handler = bVar.d;
        handler.sendMessage(handler.obtainMessage(i2, bVar.t.get(), 16));
    }

    public static boolean z(b bVar, int i2, int i3, IInterface iInterface) {
        boolean z;
        synchronized (bVar.e) {
            if (bVar.l != i2) {
                z = false;
            } else {
                bVar.x(i3, iInterface);
                z = true;
            }
        }
        return z;
    }

    public final String B() {
        String str = this.p;
        return str == null ? this.f1353b.getClass().getName() : str;
    }

    public void b(e eVar) {
        c.c.a.a.c.k.k.t tVar = (c.c.a.a.c.k.k.t) eVar;
        c.c.a.a.c.k.k.d.this.m.post(new c.c.a.a.c.k.k.s(tVar));
    }

    public void c(c cVar) {
        q.g(cVar, "Connection progress callbacks cannot be null.");
        this.h = cVar;
        x(2, null);
    }

    public boolean d() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 2 || this.l == 3;
        }
        return z;
    }

    public final c.c.a.a.c.c[] e() {
        a0 a0Var = this.s;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f1351c;
    }

    public boolean f() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 4;
        }
        return z;
    }

    public void g() {
        this.t.incrementAndGet();
        synchronized (this.j) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                h<?> hVar = this.j.get(i2);
                synchronized (hVar) {
                    hVar.f1357a = null;
                }
            }
            this.j.clear();
        }
        synchronized (this.f) {
            this.g = null;
        }
        x(1, null);
    }

    public String i() {
        g0 g0Var;
        if (!f() || (g0Var = this.f1352a) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return g0Var.f1379b;
    }

    public boolean j() {
        return false;
    }

    public boolean l() {
        return true;
    }

    public void n(c.c.a.a.c.l.k kVar, Set<Scope> set) {
        Bundle bundleR = r();
        c.c.a.a.c.l.f fVar = new c.c.a.a.c.l.f(this.o);
        fVar.e = this.f1353b.getPackageName();
        fVar.h = bundleR;
        if (set != null) {
            fVar.g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (j()) {
            Account account = ((c.c.a.a.c.l.g) this).w;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            fVar.i = account;
            if (kVar != null) {
                fVar.f = kVar.asBinder();
            }
        }
        fVar.j = u;
        fVar.k = q();
        try {
            synchronized (this.f) {
                if (this.g != null) {
                    this.g.q(new i(this, this.t.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Handler handler = this.d;
            handler.sendMessage(handler.obtainMessage(6, this.t.get(), 1));
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i2 = this.t.get();
            Handler handler2 = this.d;
            handler2.sendMessage(handler2.obtainMessage(1, i2, -1, new k(8, null, null)));
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i22 = this.t.get();
            Handler handler22 = this.d;
            handler22.sendMessage(handler22.obtainMessage(1, i22, -1, new k(8, null, null)));
        }
    }

    public abstract T p(IBinder iBinder);

    public c.c.a.a.c.c[] q() {
        return u;
    }

    public Bundle r() {
        return new Bundle();
    }

    public final T s() {
        T t;
        synchronized (this.e) {
            if (this.l == 5) {
                throw new DeadObjectException();
            }
            if (!f()) {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
            q.i(this.i != null, "Client is connected but service is null");
            t = this.i;
        }
        return t;
    }

    public abstract String t();

    public abstract String u();

    public String v() {
        return "com.google.android.gms";
    }

    public void w(int i2, T t) {
    }

    public final void x(int i2, T t) {
        q.b((i2 == 4) == (t != null));
        synchronized (this.e) {
            this.l = i2;
            this.i = t;
            w(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.k != null && this.f1352a != null) {
                        String str = this.f1352a.f1378a;
                        String str2 = this.f1352a.f1379b;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 70 + String.valueOf(str2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str);
                        sb.append(" on ");
                        sb.append(str2);
                        Log.e("GmsClient", sb.toString());
                        this.f1354c.a(this.f1352a.f1378a, this.f1352a.f1379b, this.f1352a.f1380c, this.k, B());
                        this.t.incrementAndGet();
                    }
                    this.k = new j(this.t.get());
                    g0 g0Var = new g0(v(), u(), false);
                    this.f1352a = g0Var;
                    if (!this.f1354c.b(new h.a(g0Var.f1378a, g0Var.f1379b, g0Var.f1380c), this.k, B())) {
                        String str3 = this.f1352a.f1378a;
                        String str4 = this.f1352a.f1379b;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 34 + String.valueOf(str4).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str3);
                        sb2.append(" on ");
                        sb2.append(str4);
                        Log.e("GmsClient", sb2.toString());
                        int i3 = this.t.get();
                        Handler handler = this.d;
                        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(16)));
                    }
                } else if (i2 == 4) {
                    System.currentTimeMillis();
                }
            } else if (this.k != null) {
                this.f1354c.a(this.f1352a.f1378a, this.f1352a.f1379b, this.f1352a.f1380c, this.k, B());
                this.k = null;
            }
        }
    }
}
