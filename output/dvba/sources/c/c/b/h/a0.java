package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends b {
    public static final Parcelable.Creator<a0> CREATOR = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1776c;

    public a0(String str, String str2) {
        c.c.a.a.c.l.q.d(str);
        this.f1775b = str;
        c.c.a.a.c.l.q.d(str2);
        this.f1776c = str2;
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new a0(this.f1775b, this.f1776c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1775b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1776c, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
