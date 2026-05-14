package c.c.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.s;

/* JADX INFO: loaded from: classes.dex */
public final class l extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.a.a.c.a f1496c;
    public final s d;

    public l() {
        c.c.a.a.c.a aVar = new c.c.a.a.c.a(8, null);
        this.f1495b = 1;
        this.f1496c = aVar;
        this.d = null;
    }

    public l(int i, c.c.a.a.c.a aVar, s sVar) {
        this.f1495b = i;
        this.f1496c = aVar;
        this.d = sVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1495b);
        q.g0(parcel, 2, this.f1496c, i, false);
        q.g0(parcel, 3, this.d, i, false);
        q.C0(parcel, iA);
    }
}
