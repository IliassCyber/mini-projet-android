package c.a.b.w;

import c.a.b.l;
import c.a.b.o;
import c.a.b.q;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class j extends o<String> {
    public final Object q;
    public q.b<String> r;

    public j(int i, String str, q.b<String> bVar, q.a aVar) {
        super(i, str, aVar);
        this.q = new Object();
        this.r = bVar;
    }

    @Override // c.a.b.o
    public void b(String str) {
        q.b<String> bVar;
        String str2 = str;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(str2);
        }
    }

    @Override // c.a.b.o
    public q<String> l(l lVar) {
        String str;
        try {
            str = new String(lVar.f1206a, a.a.a.a.a.j0(lVar.f1207b, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(lVar.f1206a);
        }
        return new q<>(str, a.a.a.a.a.i0(lVar));
    }
}
