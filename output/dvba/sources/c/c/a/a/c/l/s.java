package c.c.a.a.c.l;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.k;

/* JADX INFO: loaded from: classes.dex */
public class s extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<s> CREATOR = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBinder f1405c;
    public c.c.a.a.c.a d;
    public boolean e;
    public boolean f;

    public s(int i, IBinder iBinder, c.c.a.a.c.a aVar, boolean z, boolean z2) {
        this.f1404b = i;
        this.f1405c = iBinder;
        this.d = aVar;
        this.e = z;
        this.f = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.d.equals(sVar.d) && h().equals(sVar.h());
    }

    public k h() {
        return k.a.t(this.f1405c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1404b);
        IBinder iBinder = this.f1405c;
        if (iBinder != null) {
            int iN0 = q.n0(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            q.C0(parcel, iN0);
        }
        q.g0(parcel, 3, this.d, i, false);
        q.c0(parcel, 4, this.e);
        q.c0(parcel, 5, this.f);
        q.C0(parcel, iA);
    }
}
