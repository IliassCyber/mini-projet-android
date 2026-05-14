package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class z extends b {
    public static final Parcelable.Creator<z> CREATOR = new r0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1883b;

    public z(String str) {
        c.c.a.a.c.l.q.d(str);
        this.f1883b = str;
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new z(this.f1883b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1883b, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
