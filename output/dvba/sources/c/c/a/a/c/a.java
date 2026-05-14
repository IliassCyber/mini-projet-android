package c.c.a.a.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.p;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c.c.a.a.c.l.u.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1279c;
    public final PendingIntent d;
    public final String e;
    public static final a f = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new q();

    public a(int i) {
        this.f1278b = 1;
        this.f1279c = i;
        this.d = null;
        this.e = null;
    }

    public a(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f1278b = i;
        this.f1279c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public static String i(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1279c == aVar.f1279c && a.a.a.a.a.y(this.d, aVar.d) && a.a.a.a.a.y(this.e, aVar.e);
    }

    public final boolean h() {
        return this.f1279c == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1279c), this.d, this.e});
    }

    public final String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("statusCode", i(this.f1279c));
        pVarB0.a("resolution", this.d);
        pVarB0.a("message", this.e);
        return pVarB0.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.d0(parcel, 1, this.f1278b);
        c.c.a.a.c.l.q.d0(parcel, 2, this.f1279c);
        c.c.a.a.c.l.q.g0(parcel, 3, this.d, i, false);
        c.c.a.a.c.l.q.h0(parcel, 4, this.e, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }

    public a(int i, PendingIntent pendingIntent) {
        this.f1278b = 1;
        this.f1279c = i;
        this.d = pendingIntent;
        this.e = null;
    }
}
