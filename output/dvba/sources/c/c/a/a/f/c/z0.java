package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<z0> CREATOR = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1486c;
    public boolean d;
    public String e;
    public String f;
    public f1 g;
    public String h;
    public String i;
    public long j;
    public long k;
    public boolean l;
    public c.c.b.h.g0 m;
    public List<b1> n;

    public z0() {
        this.g = new f1();
    }

    public z0(String str, String str2, boolean z, String str3, String str4, f1 f1Var, String str5, String str6, long j, long j2, boolean z2, c.c.b.h.g0 g0Var, List<b1> list) {
        f1 f1Var2;
        this.f1485b = str;
        this.f1486c = str2;
        this.d = z;
        this.e = str3;
        this.f = str4;
        if (f1Var == null) {
            f1Var2 = new f1();
        } else {
            List<d1> list2 = f1Var.f1445b;
            f1 f1Var3 = new f1();
            if (list2 != null) {
                f1Var3.f1445b.addAll(list2);
            }
            f1Var2 = f1Var3;
        }
        this.g = f1Var2;
        this.h = str5;
        this.i = str6;
        this.j = j;
        this.k = j2;
        this.l = z2;
        this.m = g0Var;
        this.n = list == null ? n.h() : list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1485b, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.f1486c, false);
        c.c.a.a.c.l.q.c0(parcel, 4, this.d);
        c.c.a.a.c.l.q.h0(parcel, 5, this.e, false);
        c.c.a.a.c.l.q.h0(parcel, 6, this.f, false);
        c.c.a.a.c.l.q.g0(parcel, 7, this.g, i, false);
        c.c.a.a.c.l.q.h0(parcel, 8, this.h, false);
        c.c.a.a.c.l.q.h0(parcel, 9, this.i, false);
        c.c.a.a.c.l.q.e0(parcel, 10, this.j);
        c.c.a.a.c.l.q.e0(parcel, 11, this.k);
        c.c.a.a.c.l.q.c0(parcel, 12, this.l);
        c.c.a.a.c.l.q.g0(parcel, 13, this.m, i, false);
        c.c.a.a.c.l.q.k0(parcel, 14, this.n, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
