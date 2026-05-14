package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<b1> CREATOR = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1435c;
    public final String d;
    public final long e;

    public b1(String str, String str2, String str3, long j) {
        this.f1434b = str;
        c.c.a.a.c.l.q.d(str2);
        this.f1435c = str2;
        this.d = str3;
        this.e = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1434b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1435c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.e0(parcel, 4, this.e);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
