package c.a.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.a.b.b;
import c.a.b.d;
import c.a.b.p;
import c.a.b.q;
import c.a.b.v;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class o<T> implements Comparable<o<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v.a f1209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1210c;
    public final String d;
    public final int e;
    public final Object f;
    public q.a g;
    public Integer h;
    public p i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public f n;
    public b.a o;
    public b p;

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f1212c;

        public a(String str, long j) {
            this.f1211b = str;
            this.f1212c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.f1209b.a(this.f1211b, this.f1212c);
            o oVar = o.this;
            oVar.f1209b.b(oVar.toString());
        }
    }

    public interface b {
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public o(int i, String str, q.a aVar) {
        Uri uri;
        String host;
        this.f1209b = v.a.f1223c ? new v.a() : null;
        this.f = new Object();
        this.j = true;
        int iHashCode = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = null;
        this.f1210c = i;
        this.d = str;
        this.g = aVar;
        this.n = new f();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.e = iHashCode;
    }

    public void a(String str) {
        if (v.a.f1223c) {
            this.f1209b.a(str, Thread.currentThread().getId());
        }
    }

    public abstract void b(T t);

    public void c(String str) {
        p pVar = this.i;
        if (pVar != null) {
            synchronized (pVar.f1216b) {
                pVar.f1216b.remove(this);
            }
            synchronized (pVar.j) {
                Iterator<p.a> it = pVar.j.iterator();
                while (it.hasNext()) {
                    it.next().a(this);
                }
            }
        }
        if (v.a.f1223c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.f1209b.a(str, id);
                this.f1209b.b(toString());
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        o oVar = (o) obj;
        if (oVar != null) {
            return this.h.intValue() - oVar.h.intValue();
        }
        throw null;
    }

    public byte[] d() {
        return null;
    }

    public String e() {
        return c.a.a.a.a.c("application/x-www-form-urlencoded; charset=", "UTF-8");
    }

    public String f() {
        String str = this.d;
        int i = this.f1210c;
        if (i == 0 || i == -1) {
            return str;
        }
        return Integer.toString(i) + '-' + str;
    }

    public Map<String, String> g() {
        return Collections.emptyMap();
    }

    @Deprecated
    public byte[] h() {
        return null;
    }

    public boolean i() {
        boolean z;
        synchronized (this.f) {
            z = this.k;
        }
        return z;
    }

    public void j() {
        b bVar;
        synchronized (this.f) {
            bVar = this.p;
        }
        if (bVar != null) {
            ((d.a) bVar).b(this);
        }
    }

    public void k(q<?> qVar) {
        b bVar;
        List<o<?>> listRemove;
        synchronized (this.f) {
            bVar = this.p;
        }
        if (bVar != null) {
            d.a aVar = (d.a) bVar;
            b.a aVar2 = qVar.f1219b;
            if (aVar2 != null) {
                if (!(aVar2.e < System.currentTimeMillis())) {
                    String strF = f();
                    synchronized (aVar) {
                        listRemove = aVar.f1193a.remove(strF);
                    }
                    if (listRemove != null) {
                        if (v.f1221a) {
                            v.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strF);
                        }
                        Iterator<o<?>> it = listRemove.iterator();
                        while (it.hasNext()) {
                            ((g) aVar.f1194b.e).a(it.next(), qVar, null);
                        }
                        return;
                    }
                    return;
                }
            }
            aVar.b(this);
        }
    }

    public abstract q<T> l(l lVar);

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("0x");
        sbE.append(Integer.toHexString(this.e));
        String string = sbE.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(i() ? "[X] " : "[ ] ");
        sb.append(this.d);
        sb.append(" ");
        sb.append(string);
        sb.append(" ");
        sb.append(c.NORMAL);
        sb.append(" ");
        sb.append(this.h);
        return sb.toString();
    }
}
