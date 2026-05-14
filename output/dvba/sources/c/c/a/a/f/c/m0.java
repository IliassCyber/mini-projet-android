package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<m0> CREATOR = new l0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1464c;
    public final String d;

    public m0(String str, String str2, String str3) {
        this.f1463b = str;
        this.f1464c = str2;
        this.d = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1463b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1464c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
