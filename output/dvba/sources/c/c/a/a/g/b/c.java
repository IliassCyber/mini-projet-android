package c.c.a.a.g.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class c extends c.c.a.a.c.l.u.a implements c.c.a.a.c.k.h {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1490c;
    public Intent d;

    public c() {
        this.f1489b = 2;
        this.f1490c = 0;
        this.d = null;
    }

    public c(int i, int i2, Intent intent) {
        this.f1489b = i;
        this.f1490c = i2;
        this.d = intent;
    }

    @Override // c.c.a.a.c.k.h
    public final Status f() {
        return this.f1490c == 0 ? Status.f : Status.h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1489b);
        q.d0(parcel, 2, this.f1490c);
        q.g0(parcel, 3, this.d, i, false);
        q.C0(parcel, iA);
    }
}
