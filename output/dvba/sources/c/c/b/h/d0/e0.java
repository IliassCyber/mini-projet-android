package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements c.c.a.a.c.l.u.c {
    public static final Parcelable.Creator<e0> CREATOR = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1837c;

    public e0(long j, long j2) {
        this.f1836b = j;
        this.f1837c = j2;
    }

    public static e0 c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new e0(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.e0(parcel, 1, this.f1836b);
        c.c.a.a.c.l.q.e0(parcel, 2, this.f1837c);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
