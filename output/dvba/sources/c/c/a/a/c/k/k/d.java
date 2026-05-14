package c.c.a.a.c.k.k;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.c.a.a.c.k.a;
import c.c.a.a.c.l.b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status o = new Status(4, "The user must be signed in to make this API call.");
    public static final Object p = new Object();

    @GuardedBy("lock")
    public static d q;
    public final Context d;
    public final c.c.a.a.c.d e;
    public final c.c.a.a.c.l.j f;
    public final Handler m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1308a = 5000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1309b = 120000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1310c = 10000;
    public final AtomicInteger g = new AtomicInteger(1);
    public final AtomicInteger h = new AtomicInteger(0);
    public final Map<c.c.a.a.c.k.k.a<?>, a<?>> i = new ConcurrentHashMap(5, 0.75f, 1);

    @GuardedBy("lock")
    public m j = null;

    @GuardedBy("lock")
    public final Set<c.c.a.a.c.k.k.a<?>> k = new b.f.c();
    public final Set<c.c.a.a.c.k.k.a<?>> l = new b.f.c();

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public class a<O extends a.d> implements c.c.a.a.c.k.d, c.c.a.a.c.k.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a.f f1312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a.b f1313c;
        public final c.c.a.a.c.k.k.a<O> d;
        public final m0 e;
        public final int h;
        public final z i;
        public boolean j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<x> f1311a = new LinkedList();
        public final Set<j0> f = new HashSet();
        public final Map<g<?>, w> g = new HashMap();
        public final List<c> k = new ArrayList();
        public c.c.a.a.c.a l = null;

        public a(c.c.a.a.c.k.c<O> cVar) {
            Looper looper = d.this.m.getLooper();
            c.c.a.a.c.l.c cVarA = cVar.a().a();
            c.c.a.a.c.k.a<O> aVar = cVar.f1296b;
            c.c.a.a.c.l.q.i(aVar.f1293a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
            a.f fVarA = aVar.f1293a.a(cVar.f1295a, looper, cVarA, cVar.f1297c, this, this);
            this.f1312b = fVarA;
            if (!(fVarA instanceof c.c.a.a.c.l.t)) {
                this.f1313c = fVarA;
            } else {
                if (((c.c.a.a.c.l.t) fVarA) == null) {
                    throw null;
                }
                this.f1313c = null;
            }
            this.d = cVar.d;
            this.e = new m0();
            this.h = cVar.e;
            if (this.f1312b.j()) {
                this.i = new z(d.this.d, d.this.m, cVar.a().a());
            } else {
                this.i = null;
            }
        }

        public final void a() {
            c.c.a.a.c.l.q.c(d.this.m);
            if (this.f1312b.f() || this.f1312b.d()) {
                return;
            }
            d dVar = d.this;
            c.c.a.a.c.l.j jVar = dVar.f;
            Context context = dVar.d;
            a.f fVar = this.f1312b;
            if (jVar == null) {
                throw null;
            }
            c.c.a.a.c.l.q.f(context);
            c.c.a.a.c.l.q.f(fVar);
            int iC = 0;
            if (fVar.l()) {
                int iO = fVar.o();
                int i = jVar.f1391a.get(iO, -1);
                if (i != -1) {
                    iC = i;
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jVar.f1391a.size()) {
                            iC = i;
                            break;
                        }
                        int iKeyAt = jVar.f1391a.keyAt(i2);
                        if (iKeyAt > iO && jVar.f1391a.get(iKeyAt) == 0) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (iC == -1) {
                        iC = jVar.f1392b.c(context, iO);
                    }
                    jVar.f1391a.put(iO, iC);
                }
            }
            if (iC != 0) {
                t(new c.c.a.a.c.a(iC, null));
                return;
            }
            b bVar = d.this.new b(this.f1312b, this.d);
            if (this.f1312b.j()) {
                z zVar = this.i;
                c.c.a.a.g.e eVar = zVar.f;
                if (eVar != null) {
                    eVar.g();
                }
                zVar.e.h = Integer.valueOf(System.identityHashCode(zVar));
                a.AbstractC0053a<? extends c.c.a.a.g.e, c.c.a.a.g.a> abstractC0053a = zVar.f1349c;
                Context context2 = zVar.f1347a;
                Looper looper = zVar.f1348b.getLooper();
                c.c.a.a.c.l.c cVar = zVar.e;
                zVar.f = (c.c.a.a.g.e) abstractC0053a.a(context2, looper, cVar, cVar.g, zVar, zVar);
                zVar.g = bVar;
                Set<Scope> set = zVar.d;
                if (set == null || set.isEmpty()) {
                    zVar.f1348b.post(new y(zVar));
                } else {
                    zVar.f.h();
                }
            }
            this.f1312b.c(bVar);
        }

        public final boolean b() {
            return this.f1312b.j();
        }

        @Override // c.c.a.a.c.k.k.c
        public final void c(int i) {
            if (Looper.myLooper() == d.this.m.getLooper()) {
                h();
            } else {
                d.this.m.post(new r(this));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final c.c.a.a.c.c d(c.c.a.a.c.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                return null;
            }
            c.c.a.a.c.c[] cVarArrE = this.f1312b.e();
            if (cVarArrE == null) {
                cVarArrE = new c.c.a.a.c.c[0];
            }
            b.f.a aVar = new b.f.a(cVarArrE.length);
            for (c.c.a.a.c.c cVar : cVarArrE) {
                aVar.put(cVar.f1282b, Long.valueOf(cVar.h()));
            }
            for (c.c.a.a.c.c cVar2 : cVarArr) {
                if (!aVar.containsKey(cVar2.f1282b) || ((Long) aVar.get(cVar2.f1282b)).longValue() < cVar2.h()) {
                    return cVar2;
                }
            }
            return null;
        }

        public final void e(x xVar) {
            c.c.a.a.c.l.q.c(d.this.m);
            if (this.f1312b.f()) {
                if (f(xVar)) {
                    m();
                    return;
                } else {
                    this.f1311a.add(xVar);
                    return;
                }
            }
            this.f1311a.add(xVar);
            c.c.a.a.c.a aVar = this.l;
            if (aVar != null) {
                if ((aVar.f1279c == 0 || aVar.d == null) ? false : true) {
                    t(this.l);
                    return;
                }
            }
            a();
        }

        public final boolean f(x xVar) {
            if (!(xVar instanceof o)) {
                o(xVar);
                return true;
            }
            o oVar = (o) xVar;
            c.c.a.a.c.c cVarD = d(oVar.f(this));
            if (cVarD == null) {
                o(xVar);
                return true;
            }
            if (oVar.g(this)) {
                c cVar = new c(this.d, cVarD, null);
                int iIndexOf = this.k.indexOf(cVar);
                if (iIndexOf >= 0) {
                    c cVar2 = this.k.get(iIndexOf);
                    d.this.m.removeMessages(15, cVar2);
                    Handler handler = d.this.m;
                    handler.sendMessageDelayed(Message.obtain(handler, 15, cVar2), d.this.f1308a);
                } else {
                    this.k.add(cVar);
                    Handler handler2 = d.this.m;
                    handler2.sendMessageDelayed(Message.obtain(handler2, 15, cVar), d.this.f1308a);
                    Handler handler3 = d.this.m;
                    handler3.sendMessageDelayed(Message.obtain(handler3, 16, cVar), d.this.f1309b);
                    synchronized (d.p) {
                    }
                    d dVar = d.this;
                    int i = this.h;
                    c.c.a.a.c.d dVar2 = dVar.e;
                    Context context = dVar.d;
                    if (dVar2 == null) {
                        throw null;
                    }
                    Intent intentA = dVar2.a(context, 2, null);
                    PendingIntent activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, 134217728) : null;
                    if (activity != null) {
                        dVar2.e(context, 2, GoogleApiActivity.a(context, activity, i));
                    }
                }
            } else {
                oVar.c(new c.c.a.a.c.k.j(cVarD));
            }
            return false;
        }

        public final void g() {
            k();
            q(c.c.a.a.c.a.f);
            l();
            Iterator<w> it = this.g.values().iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
            i();
            m();
        }

        public final void h() {
            k();
            this.j = true;
            this.e.a(true, e0.f1320a);
            Handler handler = d.this.m;
            handler.sendMessageDelayed(Message.obtain(handler, 9, this.d), d.this.f1308a);
            Handler handler2 = d.this.m;
            handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.d), d.this.f1309b);
            d.this.f.f1391a.clear();
        }

        public final void i() {
            ArrayList arrayList = new ArrayList(this.f1311a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                x xVar = (x) obj;
                if (!this.f1312b.f()) {
                    return;
                }
                if (f(xVar)) {
                    this.f1311a.remove(xVar);
                }
            }
        }

        public final void j() {
            c.c.a.a.c.l.q.c(d.this.m);
            n(d.n);
            m0 m0Var = this.e;
            if (m0Var == null) {
                throw null;
            }
            m0Var.a(false, d.n);
            for (g gVar : (g[]) this.g.keySet().toArray(new g[this.g.size()])) {
                e(new i0(gVar, new c.c.a.a.h.e()));
            }
            q(new c.c.a.a.c.a(4));
            if (this.f1312b.f()) {
                this.f1312b.b(new t(this));
            }
        }

        public final void k() {
            c.c.a.a.c.l.q.c(d.this.m);
            this.l = null;
        }

        public final void l() {
            if (this.j) {
                d.this.m.removeMessages(11, this.d);
                d.this.m.removeMessages(9, this.d);
                this.j = false;
            }
        }

        public final void m() {
            d.this.m.removeMessages(12, this.d);
            Handler handler = d.this.m;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.d), d.this.f1310c);
        }

        public final void n(Status status) {
            c.c.a.a.c.l.q.c(d.this.m);
            Iterator<x> it = this.f1311a.iterator();
            while (it.hasNext()) {
                it.next().a(status);
            }
            this.f1311a.clear();
        }

        public final void o(x xVar) {
            xVar.b(this.e, b());
            try {
                xVar.e(this);
            } catch (DeadObjectException unused) {
                c(1);
                this.f1312b.g();
            }
        }

        public final boolean p(boolean z) {
            c.c.a.a.c.l.q.c(d.this.m);
            if (!this.f1312b.f() || this.g.size() != 0) {
                return false;
            }
            m0 m0Var = this.e;
            if (!((m0Var.f1334a.isEmpty() && m0Var.f1335b.isEmpty()) ? false : true)) {
                this.f1312b.g();
                return true;
            }
            if (z) {
                m();
            }
            return false;
        }

        public final void q(c.c.a.a.c.a aVar) {
            Iterator<j0> it = this.f.iterator();
            if (!it.hasNext()) {
                this.f.clear();
                return;
            }
            it.next();
            if (a.a.a.a.a.y(aVar, c.c.a.a.c.a.f)) {
                this.f1312b.i();
            }
            throw null;
        }

        @Override // c.c.a.a.c.k.k.h
        public final void t(c.c.a.a.c.a aVar) {
            c.c.a.a.g.e eVar;
            c.c.a.a.c.l.q.c(d.this.m);
            z zVar = this.i;
            if (zVar != null && (eVar = zVar.f) != null) {
                eVar.g();
            }
            k();
            d.this.f.f1391a.clear();
            q(aVar);
            if (aVar.f1279c == 4) {
                n(d.o);
                return;
            }
            if (this.f1311a.isEmpty()) {
                this.l = aVar;
                return;
            }
            synchronized (d.p) {
            }
            if (d.this.c(aVar, this.h)) {
                return;
            }
            if (aVar.f1279c == 18) {
                this.j = true;
            }
            if (this.j) {
                Handler handler = d.this.m;
                handler.sendMessageDelayed(Message.obtain(handler, 9, this.d), d.this.f1308a);
                return;
            }
            String str = this.d.f1303c.f1294b;
            String strValueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + String.valueOf(str).length() + 63);
            sb.append("API: ");
            sb.append(str);
            sb.append(" is not available on this device. Connection failed with: ");
            sb.append(strValueOf);
            n(new Status(17, sb.toString()));
        }

        @Override // c.c.a.a.c.k.k.c
        public final void y(Bundle bundle) {
            if (Looper.myLooper() == d.this.m.getLooper()) {
                g();
            } else {
                d.this.m.post(new q(this));
            }
        }
    }

    public class b implements a0, b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.f f1314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.c.a.a.c.k.k.a<?> f1315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c.c.a.a.c.l.k f1316c = null;
        public Set<Scope> d = null;
        public boolean e = false;

        public b(a.f fVar, c.c.a.a.c.k.k.a<?> aVar) {
            this.f1314a = fVar;
            this.f1315b = aVar;
        }

        @Override // c.c.a.a.c.l.b.c
        public final void a(c.c.a.a.c.a aVar) {
            d.this.m.post(new u(this, aVar));
        }

        public final void b(c.c.a.a.c.a aVar) {
            a<?> aVar2 = d.this.i.get(this.f1315b);
            c.c.a.a.c.l.q.c(d.this.m);
            aVar2.f1312b.g();
            aVar2.t(aVar);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.c.a.a.c.k.k.a<?> f1317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.c.a.a.c.c f1318b;

        public c(c.c.a.a.c.k.k.a aVar, c.c.a.a.c.c cVar, p pVar) {
            this.f1317a = aVar;
            this.f1318b = cVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (a.a.a.a.a.y(this.f1317a, cVar.f1317a) && a.a.a.a.a.y(this.f1318b, cVar.f1318b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1317a, this.f1318b});
        }

        public final String toString() {
            c.c.a.a.c.l.p pVarB0 = a.a.a.a.a.B0(this);
            pVarB0.a("key", this.f1317a);
            pVarB0.a("feature", this.f1318b);
            return pVarB0.toString();
        }
    }

    public d(Context context, Looper looper, c.c.a.a.c.d dVar) {
        this.d = context;
        this.m = new c.c.a.a.f.a.c(looper, this);
        this.e = dVar;
        this.f = new c.c.a.a.c.l.j(dVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static d a(Context context) {
        d dVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new d(context.getApplicationContext(), handlerThread.getLooper(), c.c.a.a.c.d.d);
            }
            dVar = q;
        }
        return dVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(c.c.a.a.c.k.c<?> cVar) {
        c.c.a.a.c.k.k.a<O> aVar = cVar.d;
        a<?> aVar2 = this.i.get(aVar);
        if (aVar2 == null) {
            aVar2 = new a<>(cVar);
            this.i.put((c.c.a.a.c.k.k.a<?>) aVar, aVar2);
        }
        if (aVar2.b()) {
            this.l.add((c.c.a.a.c.k.k.a<?>) aVar);
        }
        aVar2.a();
    }

    public final boolean c(c.c.a.a.c.a aVar, int i) {
        c.c.a.a.c.d dVar = this.e;
        Context context = this.d;
        PendingIntent activity = null;
        if (dVar == null) {
            throw null;
        }
        if ((aVar.f1279c == 0 || aVar.d == null) ? false : true) {
            activity = aVar.d;
        } else {
            Intent intentA = dVar.a(context, aVar.f1279c, null);
            if (intentA != null) {
                activity = PendingIntent.getActivity(context, 0, intentA, 134217728);
            }
        }
        if (activity == null) {
            return false;
        }
        dVar.e(context, aVar.f1279c, GoogleApiActivity.a(context, activity, i));
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a<?> next;
        c.c.a.a.c.c[] cVarArrF;
        int i = message.what;
        int i2 = 0;
        switch (i) {
            case 1:
                this.f1310c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.m.removeMessages(12);
                for (c.c.a.a.c.k.k.a<?> aVar : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, aVar), this.f1310c);
                }
                return true;
            case 2:
                throw null;
            case 3:
                for (a<?> aVar2 : this.i.values()) {
                    aVar2.k();
                    aVar2.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                v vVar = (v) message.obj;
                a<?> aVar3 = this.i.get(vVar.f1345c.d);
                if (aVar3 == null) {
                    b(vVar.f1345c);
                    aVar3 = this.i.get(vVar.f1345c.d);
                }
                if (!aVar3.b() || this.h.get() == vVar.f1344b) {
                    aVar3.e(vVar.f1343a);
                } else {
                    vVar.f1343a.a(n);
                    aVar3.j();
                }
                return true;
            case 5:
                int i3 = message.arg1;
                c.c.a.a.c.a aVar4 = (c.c.a.a.c.a) message.obj;
                Iterator<a<?>> it = this.i.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (next.h == i3) {
                        }
                    } else {
                        next = null;
                    }
                }
                if (next != null) {
                    c.c.a.a.c.d dVar = this.e;
                    int i4 = aVar4.f1279c;
                    if (dVar == null) {
                        throw null;
                    }
                    String strA = c.c.a.a.c.g.a(i4);
                    String str = aVar4.e;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(strA).length() + 69);
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(strA);
                    sb.append(": ");
                    sb.append(str);
                    next.n(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (this.d.getApplicationContext() instanceof Application) {
                    c.c.a.a.c.k.k.b.b((Application) this.d.getApplicationContext());
                    c.c.a.a.c.k.k.b.f.a(new p(this));
                    c.c.a.a.c.k.k.b bVar = c.c.a.a.c.k.k.b.f;
                    if (!bVar.f1305c.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!bVar.f1305c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            bVar.f1304b.set(true);
                        }
                    }
                    if (!bVar.f1304b.get()) {
                        this.f1310c = 300000L;
                    }
                }
                return true;
            case 7:
                b((c.c.a.a.c.k.c) message.obj);
                return true;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar5 = this.i.get(message.obj);
                    c.c.a.a.c.l.q.c(d.this.m);
                    if (aVar5.j) {
                        aVar5.a();
                    }
                }
                return true;
            case 10:
                Iterator<c.c.a.a.c.k.k.a<?>> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    this.i.remove(it2.next()).j();
                }
                this.l.clear();
                return true;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar6 = this.i.get(message.obj);
                    c.c.a.a.c.l.q.c(d.this.m);
                    if (aVar6.j) {
                        aVar6.l();
                        d dVar2 = d.this;
                        aVar6.n(dVar2.e.b(dVar2.d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                        aVar6.f1312b.g();
                    }
                }
                return true;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).p(true);
                }
                return true;
            case 14:
                if (((n) message.obj) == null || !this.i.containsKey(null)) {
                    throw null;
                }
                this.i.get(null).p(false);
                throw null;
            case 15:
                c cVar = (c) message.obj;
                if (this.i.containsKey(cVar.f1317a)) {
                    a<?> aVar7 = this.i.get(cVar.f1317a);
                    if (aVar7.k.contains(cVar) && !aVar7.j) {
                        if (aVar7.f1312b.f()) {
                            aVar7.i();
                        } else {
                            aVar7.a();
                        }
                    }
                }
                return true;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.i.containsKey(cVar2.f1317a)) {
                    a<?> aVar8 = this.i.get(cVar2.f1317a);
                    if (aVar8.k.remove(cVar2)) {
                        d.this.m.removeMessages(15, cVar2);
                        d.this.m.removeMessages(16, cVar2);
                        c.c.a.a.c.c cVar3 = cVar2.f1318b;
                        ArrayList arrayList = new ArrayList(aVar8.f1311a.size());
                        for (x xVar : aVar8.f1311a) {
                            if ((xVar instanceof o) && (cVarArrF = ((o) xVar).f(aVar8)) != null) {
                                int length = cVarArrF.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!a.a.a.a.a.y(cVarArrF[i5], cVar3)) {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.add(xVar);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            x xVar2 = (x) obj;
                            aVar8.f1311a.remove(xVar2);
                            xVar2.c(new c.c.a.a.c.k.j(cVar3));
                        }
                    }
                }
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }
}
