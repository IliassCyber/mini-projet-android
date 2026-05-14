package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<o0> CREATOR = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.b.h.c f1470b;

    public o0(c.c.b.h.c cVar) {
        this.f1470b = cVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1470b, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
