package c.c.b.h;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y extends s {
    public static final Parcelable.Creator<y> CREATOR = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1882c;
    public final long d;
    public final String e;

    public y(String str, @Nullable String str2, long j, String str3) {
        c.c.a.a.c.l.q.d(str);
        this.f1881b = str;
        this.f1882c = str2;
        this.d = j;
        c.c.a.a.c.l.q.d(str3);
        this.e = str3;
    }

    public static y i(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new y(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // c.c.b.h.s
    @Nullable
    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f1881b);
            jSONObject.putOpt("displayName", this.f1882c);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.d));
            jSONObject.putOpt("phoneNumber", this.e);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new c.c.b.h.c0.b(e);
        }
    }

    @Override // android.os.Parcelable
    @SuppressLint({"FirebaseUnknownNullness"})
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1881b, false);
        c.c.a.a.c.l.q.h0(parcel, 2, this.f1882c, false);
        c.c.a.a.c.l.q.e0(parcel, 3, this.d);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
