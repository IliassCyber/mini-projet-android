package c.c.a.a.c.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<a0> CREATOR = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f1350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.c.a.a.c.c[] f1351c;

    public a0() {
    }

    public a0(Bundle bundle, c.c.a.a.c.c[] cVarArr) {
        this.f1350b = bundle;
        this.f1351c = cVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        Bundle bundle = this.f1350b;
        if (bundle != null) {
            int iN0 = q.n0(parcel, 1);
            parcel.writeBundle(bundle);
            q.C0(parcel, iN0);
        }
        q.j0(parcel, 2, this.f1351c, i, false);
        q.C0(parcel, iA);
    }
}
