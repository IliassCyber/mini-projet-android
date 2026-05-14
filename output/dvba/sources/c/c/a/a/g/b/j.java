package c.c.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.r;

/* JADX INFO: loaded from: classes.dex */
public final class j extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f1494c;

    public j(int i, r rVar) {
        this.f1493b = i;
        this.f1494c = rVar;
    }

    public j(r rVar) {
        this.f1493b = 1;
        this.f1494c = rVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1493b);
        q.g0(parcel, 2, this.f1494c, i, false);
        q.C0(parcel, iA);
    }
}
