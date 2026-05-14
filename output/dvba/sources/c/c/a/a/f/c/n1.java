package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<java.lang.Object>] */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<n1> CREATOR = new m1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1467c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public String q;

    public n1() {
        this.j = true;
        this.k = true;
    }

    public n1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f1466b = "http://localhost";
        this.d = str;
        this.e = str2;
        this.i = str4;
        this.l = str5;
        this.o = str6;
        this.q = str7;
        this.j = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.l)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        c.c.a.a.c.l.q.d(str3);
        this.f = str3;
        this.g = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.d)) {
            sb.append("id_token=");
            sb.append(this.d);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.e)) {
            sb.append("access_token=");
            sb.append(this.e);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.g)) {
            sb.append("identifier=");
            sb.append(this.g);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.i)) {
            sb.append("oauth_token_secret=");
            sb.append(this.i);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.l)) {
            sb.append("code=");
            sb.append(this.l);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str8)) {
            sb.append("nonce=");
            sb.append(str8);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.f);
        this.h = sb.toString();
        this.k = true;
    }

    public n1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.f1466b = str;
        this.f1467c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = z;
        this.k = z2;
        this.l = str9;
        this.m = str10;
        this.n = str11;
        this.o = str12;
        this.p = z3;
        this.q = str13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1466b, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.f1467c, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 5, this.e, false);
        c.c.a.a.c.l.q.h0(parcel, 6, this.f, false);
        c.c.a.a.c.l.q.h0(parcel, 7, this.g, false);
        c.c.a.a.c.l.q.h0(parcel, 8, this.h, false);
        c.c.a.a.c.l.q.h0(parcel, 9, this.i, false);
        c.c.a.a.c.l.q.c0(parcel, 10, this.j);
        c.c.a.a.c.l.q.c0(parcel, 11, this.k);
        c.c.a.a.c.l.q.h0(parcel, 12, this.l, false);
        c.c.a.a.c.l.q.h0(parcel, 13, this.m, false);
        c.c.a.a.c.l.q.h0(parcel, 14, this.n, false);
        c.c.a.a.c.l.q.h0(parcel, 15, this.o, false);
        c.c.a.a.c.l.q.c0(parcel, 16, this.p);
        c.c.a.a.c.l.q.h0(parcel, 17, this.q, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
