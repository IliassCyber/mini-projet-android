package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<d0> CREATOR = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1439c;
    public final String d;

    public d0(String str, String str2, String str3) {
        this.f1438b = str;
        this.f1439c = str2;
        this.d = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1438b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1439c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
