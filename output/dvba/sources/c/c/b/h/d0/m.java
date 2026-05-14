package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<m> CREATOR = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c.c.b.h.y> f1848b;

    public m(List<c.c.b.h.y> list) {
        this.f1848b = list == null ? c.c.a.a.f.c.n.h() : list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.k0(parcel, 1, this.f1848b, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
