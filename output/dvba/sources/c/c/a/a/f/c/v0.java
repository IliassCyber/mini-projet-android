package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class v0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<v0> CREATOR = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<b1> f1482c;
    public c.c.b.h.g0 d;

    public v0(String str, List<b1> list, c.c.b.h.g0 g0Var) {
        this.f1481b = str;
        this.f1482c = list;
        this.d = g0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1481b, false);
        c.c.a.a.c.l.q.k0(parcel, 2, this.f1482c, false);
        c.c.a.a.c.l.q.g0(parcel, 3, this.d, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
