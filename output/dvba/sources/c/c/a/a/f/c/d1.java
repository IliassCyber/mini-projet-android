package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<d1> CREATOR = new g1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1441c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public d1() {
    }

    public d1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f1440b = str;
        this.f1441c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1440b, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.f1441c, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 5, this.e, false);
        c.c.a.a.c.l.q.h0(parcel, 6, this.f, false);
        c.c.a.a.c.l.q.h0(parcel, 7, this.g, false);
        c.c.a.a.c.l.q.h0(parcel, 8, this.h, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
