package c.c.a.a.c.l;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import c.c.a.a.c.k.a;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes.dex */
public abstract class g<T extends IInterface> extends b<T> implements a.f {
    public final Set<Scope> v;
    public final Account w;

    /* JADX WARN: Illegal instructions before constructor call */
    public g(Context context, Looper looper, int i, c cVar, c.c.a.a.c.k.k.c cVar2, c.c.a.a.c.k.k.h hVar) {
        synchronized (h.f1381a) {
            if (h.f1382b == null) {
                h.f1382b = new d0(context.getApplicationContext());
            }
        }
        h hVar2 = h.f1382b;
        c.c.a.a.c.d dVar = c.c.a.a.c.d.d;
        q.f(cVar2);
        q.f(hVar);
        super(context, looper, hVar2, dVar, i, new w(cVar2), new x(hVar), cVar.f);
        this.w = cVar.f1364a;
        Set<Scope> set = cVar.f1366c;
        Iterator<Scope> it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.v = set;
    }

    @Override // c.c.a.a.c.k.a.f
    public Set<Scope> m() {
        return j() ? this.v : Collections.emptySet();
    }

    @Override // c.c.a.a.c.k.a.f
    public int o() {
        return c.c.a.a.c.e.f1287a;
    }
}
