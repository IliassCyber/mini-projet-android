package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<c.c.a.a.f.c.i1, java.lang.Object>] */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<i1> CREATOR = new j1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1454c;
    public String d;
    public b1 e;

    public i1() {
    }

    public i1(String str, String str2, String str3, b1 b1Var) {
        this.f1453b = str;
        this.f1454c = str2;
        this.d = str3;
        this.e = b1Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1453b, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.f1454c, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.d, false);
        c.c.a.a.c.l.q.g0(parcel, 5, this.e, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
