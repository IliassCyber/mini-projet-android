package c.c.a.a.c.l;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f1364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Scope> f1365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Scope> f1366c;
    public final Map<c.c.a.a.c.k.a<?>, b> d;
    public final String e;
    public final String f;
    public final c.c.a.a.g.a g;
    public Integer h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f1367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b.f.c<Scope> f1368b;
        public String d;
        public String e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1369c = 0;
        public c.c.a.a.g.a f = c.c.a.a.g.a.k;

        public final c a() {
            return new c(this.f1367a, this.f1368b, null, this.f1369c, null, this.d, this.e, this.f, false);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Scope> f1370a;
    }

    public c(Account account, Set<Scope> set, Map<c.c.a.a.c.k.a<?>, b> map, int i, View view, String str, String str2, c.c.a.a.g.a aVar, boolean z) {
        this.f1364a = account;
        this.f1365b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.d = Collections.emptyMap();
        this.e = str;
        this.f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(this.f1365b);
        Iterator<b> it = this.d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f1370a);
        }
        this.f1366c = Collections.unmodifiableSet(hashSet);
    }
}
