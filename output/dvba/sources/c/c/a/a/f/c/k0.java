package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<k0> CREATOR = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f1457b;

    public k0(n1 n1Var) {
        this.f1457b = n1Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1457b, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
