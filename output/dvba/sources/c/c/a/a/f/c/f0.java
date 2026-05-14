package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<f0> CREATOR = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n1 f1444c;

    public f0(String str, n1 n1Var) {
        this.f1443b = str;
        this.f1444c = n1Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1443b, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1444c, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
