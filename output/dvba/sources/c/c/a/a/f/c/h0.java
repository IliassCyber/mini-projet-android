package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<h0> CREATOR = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.b.h.w f1449c;

    public h0(String str, c.c.b.h.w wVar) {
        this.f1448b = str;
        this.f1449c = wVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1448b, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1449c, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
