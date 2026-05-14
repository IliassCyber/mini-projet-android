package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class r extends b {
    public static final Parcelable.Creator<r> CREATOR = new o0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1877c;

    public r(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        i(str, "idToken");
        this.f1876b = str;
        i(str2, "accessToken");
        this.f1877c = str2;
    }

    public static String i(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(str2.concat(" must not be empty"));
    }

    @Override // c.c.b.h.b
    public final b h() {
        return new r(this.f1876b, this.f1877c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1876b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1877c, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
