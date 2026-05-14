package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends c.c.b.h.t {
    public static final Parcelable.Creator<f0> CREATOR = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c.c.b.h.y> f1838b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f1839c;
    public final String d;
    public final c.c.b.h.g0 e;
    public final c0 f;

    public f0(List<c.c.b.h.y> list, g0 g0Var, String str, c.c.b.h.g0 g0Var2, c0 c0Var) {
        for (c.c.b.h.y yVar : list) {
            if (yVar instanceof c.c.b.h.y) {
                this.f1838b.add(yVar);
            }
        }
        c.c.a.a.c.l.q.f(g0Var);
        this.f1839c = g0Var;
        c.c.a.a.c.l.q.d(str);
        this.d = str;
        this.e = g0Var2;
        this.f = c0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.k0(parcel, 1, this.f1838b, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1839c, i, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.g0(parcel, 4, this.e, i, false);
        c.c.a.a.c.l.q.g0(parcel, 5, this.f, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
