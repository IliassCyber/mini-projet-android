package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1778c;
    public final String d;
    public String e;
    public boolean f;

    public c(String str, String str2, String str3, String str4, boolean z) {
        c.c.a.a.c.l.q.d(str);
        this.f1777b = str;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f1778c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z;
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new c(this.f1777b, this.f1778c, this.d, this.e, this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1777b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1778c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.c0(parcel, 5, this.f);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
