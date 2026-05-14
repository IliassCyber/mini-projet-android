package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<t0> CREATOR = new s0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Status f1479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.b.h.g0 f1480c;
    public final String d;
    public final String e;

    public t0(Status status, c.c.b.h.g0 g0Var, String str, String str2) {
        this.f1479b = status;
        this.f1480c = g0Var;
        this.d = str;
        this.e = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1479b, i, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1480c, i, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
