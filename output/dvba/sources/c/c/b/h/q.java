package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class q extends b {
    public static final Parcelable.Creator<q> CREATOR = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1875b;

    public q(String str) {
        c.c.a.a.c.l.q.d(str);
        this.f1875b = str;
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new q(this.f1875b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1875b, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
