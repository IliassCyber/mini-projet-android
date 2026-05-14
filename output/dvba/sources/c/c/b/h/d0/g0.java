package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends c.c.b.h.u {
    public static final Parcelable.Creator<g0> CREATOR = new i0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1842c;
    public List<c.c.b.h.y> d;

    public g0() {
    }

    public g0(String str, String str2, List<c.c.b.h.y> list) {
        this.f1841b = str;
        this.f1842c = str2;
        this.d = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1841b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1842c, false);
        c.c.a.a.c.l.q.k0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
