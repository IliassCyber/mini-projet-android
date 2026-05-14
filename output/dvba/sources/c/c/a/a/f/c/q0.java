package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<q0> CREATOR = new p0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.c.b.h.w f1472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1473c;

    public q0(c.c.b.h.w wVar, String str) {
        this.f1472b = wVar;
        this.f1473c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1472b, i, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1473c, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
