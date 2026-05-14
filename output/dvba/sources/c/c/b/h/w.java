package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class w extends b implements Cloneable {
    public static final Parcelable.Creator<w> CREATOR = new p0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1879c;
    public boolean d;
    public String e;
    public boolean f;
    public String g;
    public String h;

    public w(String str, String str2, boolean z, String str3, boolean z2, String str4, String str5) {
        if (!((z && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) || (z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) || !((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))))) {
            throw new IllegalArgumentException("Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        }
        this.f1878b = str;
        this.f1879c = str2;
        this.d = z;
        this.e = str3;
        this.f = z2;
        this.g = str4;
        this.h = str5;
    }

    public Object clone() {
        return new w(this.f1878b, this.f1879c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // c.c.b.h.b
    public final b h() {
        return (w) clone();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1878b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1879c, false);
        c.c.a.a.c.l.q.c0(parcel, 3, this.d);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.c0(parcel, 5, this.f);
        c.c.a.a.c.l.q.h0(parcel, 6, this.g, false);
        c.c.a.a.c.l.q.h0(parcel, 7, this.h, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
