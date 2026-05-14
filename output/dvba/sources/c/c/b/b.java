package c.c.b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c.c.a.a.c.k.k.b;
import c.c.a.a.c.l.p;
import c.c.a.a.c.l.q;
import c.c.b.i.l;
import c.c.b.i.t;
import c.c.b.i.u;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Object h = new Object();
    public static final Executor i = new d(null);

    @GuardedBy("LOCK")
    public static final Map<String, b> j = new b.f.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f1764c;
    public final l d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final List<InterfaceC0067b> g = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c.c.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0067b {
        void a(boolean z);
    }

    @TargetApi(14)
    public static class c implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference<c> f1765a = new AtomicReference<>();

        public static void b(Context context) {
            if (context.getApplicationContext() instanceof Application) {
                Application application = (Application) context.getApplicationContext();
                if (f1765a.get() == null) {
                    c cVar = new c();
                    if (f1765a.compareAndSet(null, cVar)) {
                        c.c.a.a.c.k.k.b.b(application);
                        c.c.a.a.c.k.k.b.f.a(cVar);
                    }
                }
            }
        }

        @Override // c.c.a.a.c.k.k.b.a
        public void a(boolean z) {
            synchronized (b.h) {
                for (b bVar : new ArrayList(b.j.values())) {
                    if (bVar.e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator<InterfaceC0067b> it = bVar.g.iterator();
                        while (it.hasNext()) {
                            it.next().a(z);
                        }
                    }
                }
            }
        }
    }

    public static class d implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Handler f1766a = new Handler(Looper.getMainLooper());

        public d(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f1766a.post(runnable);
        }
    }

    @TargetApi(24)
    public static class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference<e> f1767b = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1768a;

        public e(Context context) {
            this.f1768a = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (b.h) {
                Iterator<b> it = b.j.values().iterator();
                while (it.hasNext()) {
                    it.next().f();
                }
            }
            this.f1768a.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r13, java.lang.String r14, c.c.b.f r15) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.b.<init>(android.content.Context, java.lang.String, c.c.b.f):void");
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (h) {
            for (b bVar : j.values()) {
                bVar.a();
                arrayList.add(bVar.f1763b);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static b c() {
        b bVar;
        synchronized (h) {
            bVar = j.get("[DEFAULT]");
            if (bVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + c.c.a.a.c.o.c.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return bVar;
    }

    public static b d(String str) {
        b bVar;
        String str2;
        synchronized (h) {
            bVar = j.get(str.trim());
            if (bVar == null) {
                List<String> listB = b();
                if (((ArrayList) listB).isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", listB);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return bVar;
    }

    public static b g(Context context, f fVar) {
        b bVar;
        c.b(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (h) {
            q.i(!j.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            q.g(context, "Application context cannot be null.");
            bVar = new b(context, "[DEFAULT]", fVar);
            j.put("[DEFAULT]", bVar);
        }
        bVar.f();
        return bVar;
    }

    public final void a() {
        q.i(!this.f.get(), "FirebaseApp was deleted");
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f1763b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f1764c.f1770b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        String str = this.f1763b;
        b bVar = (b) obj;
        bVar.a();
        return str.equals(bVar.f1763b);
    }

    public final void f() {
        Queue<c.c.b.j.a<?>> queue;
        Set<Map.Entry<c.c.b.j.b<Object>, Executor>> setEmptySet;
        if (!(Build.VERSION.SDK_INT >= 24 ? ((UserManager) this.f1762a.getSystemService(UserManager.class)).isUserUnlocked() : true)) {
            Context context = this.f1762a;
            if (e.f1767b.get() == null) {
                e eVar = new e(context);
                if (e.f1767b.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        l lVar = this.d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f1763b);
        for (Map.Entry<c.c.b.i.d<?>, u<?>> entry : lVar.f1897a.entrySet()) {
            c.c.b.i.d<?> key = entry.getKey();
            u<?> value = entry.getValue();
            if (!(key.f1888c == 1)) {
                if (!(key.f1888c == 2) || !zEquals) {
                }
            }
            value.a();
        }
        t tVar = lVar.d;
        synchronized (tVar) {
            if (tVar.f1911b != null) {
                queue = tVar.f1911b;
                tVar.f1911b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (final c.c.b.j.a<?> aVar : queue) {
                if (aVar == null) {
                    throw null;
                }
                synchronized (tVar) {
                    if (tVar.f1911b != null) {
                        tVar.f1911b.add(aVar);
                    } else {
                        synchronized (tVar) {
                            ConcurrentHashMap<c.c.b.j.b<Object>, Executor> concurrentHashMap = tVar.f1910a.get(null);
                            setEmptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
                        }
                        for (final Map.Entry<c.c.b.j.b<Object>, Executor> entry2 : setEmptySet) {
                            entry2.getValue().execute(new Runnable(entry2, aVar) { // from class: c.c.b.i.s

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                public final Map.Entry f1908b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                public final c.c.b.j.a f1909c;

                                {
                                    this.f1908b = entry2;
                                    this.f1909c = aVar;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Map.Entry entry3 = this.f1908b;
                                    ((c.c.b.j.b) entry3.getKey()).a(this.f1909c);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        return this.f1763b.hashCode();
    }

    public String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("name", this.f1763b);
        pVarB0.a("options", this.f1764c);
        return pVarB0.toString();
    }
}
