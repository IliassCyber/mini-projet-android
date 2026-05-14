package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<c.c.a.a.f.c.a1, java.lang.Object>] */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<a1> CREATOR = new c1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1431c;
    public Long d;
    public String e;
    public Long f;

    public a1() {
        this.f = Long.valueOf(System.currentTimeMillis());
    }

    public a1(String str, String str2, Long l, String str3, Long l2) {
        this.f1430b = str;
        this.f1431c = str2;
        this.d = l;
        this.e = str3;
        this.f = l2;
    }

    public static a1 h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a1 a1Var = new a1();
            a1Var.f1430b = jSONObject.optString("refresh_token", null);
            a1Var.f1431c = jSONObject.optString("access_token", null);
            a1Var.d = Long.valueOf(jSONObject.optLong("expires_in"));
            a1Var.e = jSONObject.optString("token_type", null);
            a1Var.f = Long.valueOf(jSONObject.optLong("issued_at"));
            return a1Var;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new c.c.b.h.c0.b(e);
        }
    }

    public final String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.f1430b);
            jSONObject.put("access_token", this.f1431c);
            jSONObject.put("expires_in", this.d);
            jSONObject.put("token_type", this.e);
            jSONObject.put("issued_at", this.f);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new c.c.b.h.c0.b(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1430b, false);
        c.c.a.a.c.l.q.h0(parcel, 3, this.f1431c, false);
        Long l = this.d;
        c.c.a.a.c.l.q.f0(parcel, 4, Long.valueOf(l == null ? 0L : l.longValue()), false);
        c.c.a.a.c.l.q.h0(parcel, 5, this.e, false);
        c.c.a.a.c.l.q.f0(parcel, 6, Long.valueOf(this.f.longValue()), false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
