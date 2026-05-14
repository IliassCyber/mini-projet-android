package c.c.a.a.c.l;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1381a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f1382b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ComponentName f1385c;
        public final int d;

        public a(String str, String str2, int i) {
            q.d(str);
            this.f1383a = str;
            q.d(str2);
            this.f1384b = str2;
            this.f1385c = null;
            this.d = i;
        }

        public final Intent a() {
            return this.f1383a != null ? new Intent(this.f1383a).setPackage(this.f1384b) : new Intent().setComponent(this.f1385c);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a.a.a.a.a.y(this.f1383a, aVar.f1383a) && a.a.a.a.a.y(this.f1384b, aVar.f1384b) && a.a.a.a.a.y(this.f1385c, aVar.f1385c) && this.d == aVar.d;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1383a, this.f1384b, this.f1385c, Integer.valueOf(this.d)});
        }

        public final String toString() {
            String str = this.f1383a;
            return str == null ? this.f1385c.flattenToString() : str;
        }
    }

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        a aVar = new a(str, str2, i);
        d0 d0Var = (d0) this;
        q.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (d0Var.f1372c) {
            e0 e0Var = d0Var.f1372c.get(aVar);
            if (e0Var == null) {
                String strValueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(strValueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!e0Var.f1373a.contains(serviceConnection)) {
                String strValueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(strValueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            c.c.a.a.c.n.a aVar2 = e0Var.g.f;
            e0Var.f1373a.remove(serviceConnection);
            if (e0Var.f1373a.isEmpty()) {
                d0Var.e.sendMessageDelayed(d0Var.e.obtainMessage(0, aVar), d0Var.g);
            }
        }
    }

    public abstract boolean b(a aVar, ServiceConnection serviceConnection, String str);
}
