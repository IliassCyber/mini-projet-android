package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.k;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public class f extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<f> CREATOR = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1377c;
    public int d;
    public String e;
    public IBinder f;
    public Scope[] g;
    public Bundle h;
    public Account i;
    public c.c.a.a.c.c[] j;
    public c.c.a.a.c.c[] k;
    public boolean l;

    public f(int i) {
        this.f1376b = 4;
        this.d = c.c.a.a.c.e.f1287a;
        this.f1377c = i;
        this.l = true;
    }

    public f(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c.c.a.a.c.c[] cVarArr, c.c.a.a.c.c[] cVarArr2, boolean z) {
        this.f1376b = i;
        this.f1377c = i2;
        this.d = i3;
        if ("com.google.android.gms".equals(str)) {
            this.e = "com.google.android.gms";
        } else {
            this.e = str;
        }
        if (i < 2) {
            this.i = iBinder != null ? a.y(k.a.t(iBinder)) : null;
        } else {
            this.f = iBinder;
            this.i = account;
        }
        this.g = scopeArr;
        this.h = bundle;
        this.j = cVarArr;
        this.k = cVarArr2;
        this.l = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1376b);
        q.d0(parcel, 2, this.f1377c);
        q.d0(parcel, 3, this.d);
        q.h0(parcel, 4, this.e, false);
        IBinder iBinder = this.f;
        if (iBinder != null) {
            int iN0 = q.n0(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            q.C0(parcel, iN0);
        }
        q.j0(parcel, 6, this.g, i, false);
        Bundle bundle = this.h;
        if (bundle != null) {
            int iN02 = q.n0(parcel, 7);
            parcel.writeBundle(bundle);
            q.C0(parcel, iN02);
        }
        q.g0(parcel, 8, this.i, i, false);
        q.j0(parcel, 10, this.j, i, false);
        q.j0(parcel, 11, this.k, i, false);
        q.c0(parcel, 12, this.l);
        q.C0(parcel, iA);
    }
}
