package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<b0> CREATOR = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1433b;

    public b0(String str) {
        this.f1433b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1433b, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
