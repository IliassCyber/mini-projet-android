package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v implements c.c.a.a.c.l.u.c {
    public static final Parcelable.Creator<v> CREATOR = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1862c;
    public boolean d;

    public v(String str, String str2, boolean z) {
        c.c.a.a.c.l.q.d(str);
        c.c.a.a.c.l.q.d(str2);
        this.f1861b = str;
        this.f1862c = str2;
        k.d(str2);
        this.d = z;
    }

    public v(boolean z) {
        this.d = z;
        this.f1862c = null;
        this.f1861b = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1861b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1862c, false);
        c.c.a.a.c.l.q.c0(parcel, 3, this.d);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
