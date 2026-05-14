package c.a.b.w;

import android.util.Log;
import c.a.b.o;
import c.a.b.q;
import c.a.b.v;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<T> extends o<T> {
    public static final String t = String.format("application/json; charset=%s", "utf-8");
    public final Object q;
    public q.b<T> r;
    public final String s;

    public h(int i, String str, String str2, q.b<T> bVar, q.a aVar) {
        super(i, str, aVar);
        this.q = new Object();
        this.r = bVar;
        this.s = str2;
    }

    @Override // c.a.b.o
    public void b(T t2) {
        q.b<T> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(t2);
        }
    }

    @Override // c.a.b.o
    public byte[] d() {
        try {
            if (this.s == null) {
                return null;
            }
            return this.s.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", v.a("Unsupported Encoding while trying to get the bytes of %s using %s", this.s, "utf-8"));
            return null;
        }
    }

    @Override // c.a.b.o
    public String e() {
        return t;
    }

    @Override // c.a.b.o
    @Deprecated
    public byte[] h() {
        return d();
    }
}
