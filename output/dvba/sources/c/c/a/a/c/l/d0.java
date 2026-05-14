package c.c.a.a.c.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import c.c.a.a.c.l.h;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends h implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mConnectionStatus")
    public final HashMap<h.a, e0> f1372c = new HashMap<>();
    public final Context d;
    public final Handler e;
    public final c.c.a.a.c.n.a f;
    public final long g;
    public final long h;

    public d0(Context context) {
        this.d = context.getApplicationContext();
        this.e = new c.c.a.a.f.b.d(context.getMainLooper(), this);
        if (c.c.a.a.c.n.a.f1414b == null) {
            synchronized (c.c.a.a.c.n.a.f1413a) {
                if (c.c.a.a.c.n.a.f1414b == null) {
                    c.c.a.a.c.n.a.f1414b = new c.c.a.a.c.n.a();
                }
            }
        }
        this.f = c.c.a.a.c.n.a.f1414b;
        this.g = 5000L;
        this.h = 300000L;
    }

    @Override // c.c.a.a.c.l.h
    public final boolean b(h.a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        q.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1372c) {
            e0 e0Var = this.f1372c.get(aVar);
            if (e0Var == null) {
                e0Var = new e0(this, aVar);
                c.c.a.a.c.n.a aVar2 = e0Var.g.f;
                e0Var.e.a();
                e0Var.f1373a.add(serviceConnection);
                e0Var.a(str);
                this.f1372c.put(aVar, e0Var);
            } else {
                this.e.removeMessages(0, aVar);
                if (e0Var.f1373a.contains(serviceConnection)) {
                    String strValueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                }
                c.c.a.a.c.n.a aVar3 = e0Var.g.f;
                e0Var.e.a();
                e0Var.f1373a.add(serviceConnection);
                int i = e0Var.f1374b;
                if (i == 1) {
                    serviceConnection.onServiceConnected(e0Var.f, e0Var.d);
                } else if (i == 2) {
                    e0Var.a(str);
                }
            }
            z = e0Var.f1375c;
        }
        return z;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f1372c) {
                h.a aVar = (h.a) message.obj;
                e0 e0Var = this.f1372c.get(aVar);
                if (e0Var != null && e0Var.f1373a.isEmpty()) {
                    if (e0Var.f1375c) {
                        e0Var.g.e.removeMessages(1, e0Var.e);
                        d0 d0Var = e0Var.g;
                        c.c.a.a.c.n.a aVar2 = d0Var.f;
                        Context context = d0Var.d;
                        if (aVar2 == null) {
                            throw null;
                        }
                        context.unbindService(e0Var);
                        e0Var.f1375c = false;
                        e0Var.f1374b = 2;
                    }
                    this.f1372c.remove(aVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f1372c) {
            h.a aVar3 = (h.a) message.obj;
            e0 e0Var2 = this.f1372c.get(aVar3);
            if (e0Var2 != null && e0Var2.f1374b == 3) {
                String strValueOf = String.valueOf(aVar3);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(strValueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName componentName = e0Var2.f;
                if (componentName == null) {
                    componentName = aVar3.f1385c;
                }
                if (componentName == null) {
                    componentName = new ComponentName(aVar3.f1384b, "unknown");
                }
                e0Var2.onServiceDisconnected(componentName);
            }
        }
        return true;
    }
}
