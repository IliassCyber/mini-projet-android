package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.f.c.a1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends c.c.b.h.o {
    public static final Parcelable.Creator<c0> CREATOR = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a1 f1831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f1832c;
    public String d;
    public String e;
    public List<z> f;
    public List<String> g;
    public String h;
    public Boolean i;
    public e0 j;
    public boolean k;
    public c.c.b.h.g0 l;
    public m m;

    public c0(a1 a1Var, z zVar, String str, String str2, List<z> list, List<String> list2, String str3, Boolean bool, e0 e0Var, boolean z, c.c.b.h.g0 g0Var, m mVar) {
        this.f1831b = a1Var;
        this.f1832c = zVar;
        this.d = str;
        this.e = str2;
        this.f = list;
        this.g = list2;
        this.h = str3;
        this.i = bool;
        this.j = e0Var;
        this.k = z;
        this.l = g0Var;
        this.m = mVar;
    }

    public c0(c.c.b.b bVar, List<? extends c.c.b.h.b0> list) {
        c.c.a.a.c.l.q.f(bVar);
        bVar.a();
        this.d = bVar.f1763b;
        this.e = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.h = "2";
        j(list);
    }

    @Override // c.c.b.h.b0
    public String c() {
        return this.f1832c.f1866c;
    }

    @Override // c.c.b.h.o
    public String h() {
        String str;
        Map map;
        a1 a1Var = this.f1831b;
        if (a1Var == null || (str = a1Var.f1431c) == null || (map = (Map) i.a(str).f1874a.get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // c.c.b.h.o
    public boolean i() {
        String str;
        Boolean bool = this.i;
        if (bool == null || bool.booleanValue()) {
            a1 a1Var = this.f1831b;
            if (a1Var != null) {
                Map map = (Map) i.a(a1Var.f1431c).f1874a.get("firebase");
                str = map != null ? (String) map.get("sign_in_provider") : null;
            } else {
                str = "";
            }
            boolean z = true;
            if (this.f.size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.i = Boolean.valueOf(z);
        }
        return this.i.booleanValue();
    }

    @Override // c.c.b.h.o
    public final c.c.b.h.o j(List<? extends c.c.b.h.b0> list) {
        c.c.a.a.c.l.q.f(list);
        this.f = new ArrayList(list.size());
        this.g = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            c.c.b.h.b0 b0Var = list.get(i);
            if (b0Var.c().equals("firebase")) {
                this.f1832c = (z) b0Var;
            } else {
                this.g.add(b0Var.c());
            }
            this.f.add((z) b0Var);
        }
        if (this.f1832c == null) {
            this.f1832c = this.f.get(0);
        }
        return this;
    }

    @Override // c.c.b.h.o
    public final void k(a1 a1Var) {
        c.c.a.a.c.l.q.f(a1Var);
        this.f1831b = a1Var;
    }

    @Override // c.c.b.h.o
    public final void l(List<c.c.b.h.s> list) {
        m mVar;
        if (list == null || list.isEmpty()) {
            mVar = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (c.c.b.h.s sVar : list) {
                if (sVar instanceof c.c.b.h.y) {
                    arrayList.add((c.c.b.h.y) sVar);
                }
            }
            mVar = new m(arrayList);
        }
        this.m = mVar;
    }

    @Override // c.c.b.h.o
    public final String m() {
        return this.f1831b.i();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1831b, i, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1832c, i, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.k0(parcel, 5, this.f, false);
        c.c.a.a.c.l.q.i0(parcel, 6, this.g, false);
        c.c.a.a.c.l.q.h0(parcel, 7, this.h, false);
        Boolean boolValueOf = Boolean.valueOf(i());
        if (boolValueOf != null) {
            c.c.a.a.c.l.q.D0(parcel, 8, 4);
            parcel.writeInt(boolValueOf.booleanValue() ? 1 : 0);
        }
        c.c.a.a.c.l.q.g0(parcel, 9, this.j, i, false);
        c.c.a.a.c.l.q.c0(parcel, 10, this.k);
        c.c.a.a.c.l.q.g0(parcel, 11, this.l, i, false);
        c.c.a.a.c.l.q.g0(parcel, 12, this.m, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
