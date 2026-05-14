package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.k.l;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.u.a;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1950c;

    public Scope(int i, String str) {
        q.e(str, "scopeUri must not be null or empty");
        this.f1949b = i;
        this.f1950c = str;
    }

    public Scope(String str) {
        q.e(str, "scopeUri must not be null or empty");
        this.f1949b = 1;
        this.f1950c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f1950c.equals(((Scope) obj).f1950c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1950c.hashCode();
    }

    public final String toString() {
        return this.f1950c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1949b);
        q.h0(parcel, 2, this.f1950c, false);
        q.C0(parcel, iA);
    }
}
