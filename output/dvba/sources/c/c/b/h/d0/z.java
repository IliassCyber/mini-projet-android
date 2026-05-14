package c.c.b.h.d0;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.a.f.c.d1;
import c.c.a.a.f.c.z0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class z extends c.c.a.a.c.l.u.a implements c.c.b.h.b0 {
    public static final Parcelable.Creator<z> CREATOR = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1866c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;

    public z(z0 z0Var, String str) {
        c.c.a.a.c.l.q.f(z0Var);
        c.c.a.a.c.l.q.d(str);
        String str2 = z0Var.f1485b;
        c.c.a.a.c.l.q.d(str2);
        this.f1865b = str2;
        this.f1866c = str;
        this.f = z0Var.f1486c;
        this.d = z0Var.e;
        Uri uri = !TextUtils.isEmpty(z0Var.f) ? Uri.parse(z0Var.f) : null;
        if (uri != null) {
            this.e = uri.toString();
        }
        this.h = z0Var.d;
        this.i = null;
        this.g = z0Var.i;
    }

    public z(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.f1865b = str;
        this.f1866c = str2;
        this.f = str3;
        this.g = str4;
        this.d = str5;
        this.e = str6;
        if (!TextUtils.isEmpty(str6)) {
            Uri.parse(this.e);
        }
        this.h = z;
        this.i = str7;
    }

    public static z h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new z(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new c.c.b.h.c0.b(e);
        }
    }

    @Override // c.c.b.h.b0
    public final String c() {
        return this.f1866c;
    }

    public final String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f1865b);
            jSONObject.putOpt("providerId", this.f1866c);
            jSONObject.putOpt("displayName", this.d);
            jSONObject.putOpt("photoUrl", this.e);
            jSONObject.putOpt("email", this.f);
            jSONObject.putOpt("phoneNumber", this.g);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.h));
            jSONObject.putOpt("rawUserInfo", this.i);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new c.c.b.h.c0.b(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1865b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1866c, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.d, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.h0(parcel, 5, this.f, false);
        c.c.a.a.c.l.q.h0(parcel, 6, this.g, false);
        c.c.a.a.c.l.q.c0(parcel, 7, this.h);
        c.c.a.a.c.l.q.h0(parcel, 8, this.i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }

    public z(d1 d1Var) {
        c.c.a.a.c.l.q.f(d1Var);
        this.f1865b = d1Var.f1440b;
        String str = d1Var.e;
        c.c.a.a.c.l.q.d(str);
        this.f1866c = str;
        this.d = d1Var.f1441c;
        Uri uri = !TextUtils.isEmpty(d1Var.d) ? Uri.parse(d1Var.d) : null;
        if (uri != null) {
            this.e = uri.toString();
        }
        this.f = d1Var.h;
        this.g = d1Var.g;
        this.h = false;
        this.i = d1Var.f;
    }
}
