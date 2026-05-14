package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.f.c.n1;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends v {
    public static final Parcelable.Creator<g0> CREATOR = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1868c;
    public final String d;
    public final n1 e;
    public final String f;
    public final String g;
    public final String h;

    public g0(String str, String str2, String str3, n1 n1Var, String str4, String str5, String str6) {
        this.f1867b = str;
        this.f1868c = str2;
        this.d = str3;
        this.e = n1Var;
        this.f = str4;
        this.g = str5;
        this.h = str6;
    }

    public static g0 i(n1 n1Var) {
        c.c.a.a.c.l.q.g(n1Var, "Must specify a non-null webSignInCredential");
        return new g0(null, null, null, n1Var, null, null, null);
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new g0(this.f1867b, this.f1868c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1867b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1868c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.g0(parcel, 4, this.e, i, false);
        c.c.a.a.c.l.q.h0(parcel, 5, this.f, false);
        c.c.a.a.c.l.q.h0(parcel, 6, this.g, false);
        c.c.a.a.c.l.q.h0(parcel, 7, this.h, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
