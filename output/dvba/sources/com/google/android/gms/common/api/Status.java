package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.k.h;
import c.c.a.a.c.k.m;
import c.c.a.a.c.l.p;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.u.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends a implements h, ReflectedParcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1952c;
    public final String d;
    public final PendingIntent e;
    public static final Status f = new Status(0, null);
    public static final Status g = new Status(15, null);
    public static final Status h = new Status(16, null);
    public static final Parcelable.Creator<Status> CREATOR = new m();

    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f1951b = i;
        this.f1952c = i2;
        this.d = str;
        this.e = pendingIntent;
    }

    public Status(int i, String str) {
        this.f1951b = 1;
        this.f1952c = i;
        this.d = str;
        this.e = null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1951b == status.f1951b && this.f1952c == status.f1952c && a.a.a.a.a.y(this.d, status.d) && a.a.a.a.a.y(this.e, status.e);
    }

    @Override // c.c.a.a.c.k.h
    public final Status f() {
        return this;
    }

    public final String h() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        int i = this.f1952c;
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
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
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1951b), Integer.valueOf(this.f1952c), this.d, this.e});
    }

    public final String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("statusCode", h());
        pVarB0.a("resolution", this.e);
        return pVarB0.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1952c);
        q.h0(parcel, 2, this.d, false);
        q.g0(parcel, 3, this.e, i, false);
        q.d0(parcel, 1000, this.f1951b);
        q.C0(parcel, iA);
    }
}
