package c.c.a.a.c.l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.c.a.a.c.l.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<ServiceConnection> f1373a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1374b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1375c;
    public IBinder d;
    public final h.a e;
    public ComponentName f;
    public final /* synthetic */ d0 g;

    public e0(d0 d0Var, h.a aVar) {
        this.g = d0Var;
        this.e = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r8) {
        /*
            r7 = this;
            r8 = 3
            r7.f1374b = r8
            c.c.a.a.c.l.d0 r8 = r7.g
            c.c.a.a.c.n.a r0 = r8.f
            android.content.Context r8 = r8.d
            c.c.a.a.c.l.h$a r1 = r7.e
            android.content.Intent r1 = r1.a()
            c.c.a.a.c.l.h$a r2 = r7.e
            int r2 = r2.d
            r3 = 0
            if (r0 == 0) goto L79
            android.content.ComponentName r0 = r1.getComponent()
            r4 = 0
            r5 = 1
            if (r0 != 0) goto L1f
            goto L3f
        L1f:
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r6 = "com.google.android.gms"
            r6.equals(r0)
            c.c.a.a.c.p.a r6 = c.c.a.a.c.p.b.a(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            android.content.Context r6 = r6.f1418a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            android.content.pm.ApplicationInfo r0 = r6.getApplicationInfo(r0, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            int r0 = r0.flags     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            r6 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r6
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L4a
            java.lang.String r8 = "ConnectionTracker"
            java.lang.String r0 = "Attempted to bind to a service in a STOPPED package."
            android.util.Log.w(r8, r0)
            goto L4e
        L4a:
            boolean r4 = r8.bindService(r1, r7, r2)
        L4e:
            r7.f1375c = r4
            if (r4 == 0) goto L66
            c.c.a.a.c.l.d0 r8 = r7.g
            android.os.Handler r8 = r8.e
            c.c.a.a.c.l.h$a r0 = r7.e
            android.os.Message r8 = r8.obtainMessage(r5, r0)
            c.c.a.a.c.l.d0 r0 = r7.g
            android.os.Handler r1 = r0.e
            long r2 = r0.h
            r1.sendMessageDelayed(r8, r2)
            return
        L66:
            r8 = 2
            r7.f1374b = r8
            c.c.a.a.c.l.d0 r8 = r7.g     // Catch: java.lang.IllegalArgumentException -> L78
            c.c.a.a.c.n.a r8 = r8.f     // Catch: java.lang.IllegalArgumentException -> L78
            c.c.a.a.c.l.d0 r0 = r7.g     // Catch: java.lang.IllegalArgumentException -> L78
            android.content.Context r0 = r0.d     // Catch: java.lang.IllegalArgumentException -> L78
            if (r8 == 0) goto L77
            r0.unbindService(r7)     // Catch: java.lang.IllegalArgumentException -> L78
            return
        L77:
            throw r3     // Catch: java.lang.IllegalArgumentException -> L78
        L78:
            return
        L79:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.c.l.e0.a(java.lang.String):void");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f1372c) {
            this.g.e.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.f1373a.iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f1374b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f1372c) {
            this.g.e.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.f1373a.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f1374b = 2;
        }
    }
}
