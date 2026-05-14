package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<c.c.a.a.f.c.x0, java.lang.Object>] */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<x0> CREATOR = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1484c;
    public String d;
    public boolean e;
    public l1 f;
    public List<String> g;

    public x0() {
        this.f = new l1(null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1483b, false);
        c.c.a.a.c.l.q.c0(parcel, 3, this.f1484c);
        c.c.a.a.c.l.q.h0(parcel, 4, this.d, false);
        c.c.a.a.c.l.q.c0(parcel, 5, this.e);
        c.c.a.a.c.l.q.g0(parcel, 6, this.f, i, false);
        c.c.a.a.c.l.q.i0(parcel, 7, this.g, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }

    public x0(String str, boolean z, String str2, boolean z2, l1 l1Var, List<String> list) {
        l1 l1Var2;
        this.f1483b = str;
        this.f1484c = z;
        this.d = str2;
        this.e = z2;
        if (l1Var == null) {
            l1Var2 = new l1(null);
        } else {
            l1Var2 = new l1(l1Var.f1460c);
        }
        this.f = l1Var2;
        this.g = list;
    }
}
