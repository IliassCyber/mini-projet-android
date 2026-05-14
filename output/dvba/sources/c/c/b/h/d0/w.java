package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator<x> {
    @Override // android.os.Parcelable.Creator
    public final x createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        c0 c0Var = null;
        v vVar = null;
        c.c.b.h.g0 g0Var = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                c0Var = (c0) c.c.a.a.c.l.q.n(parcel, i, c0.CREATOR);
            } else if (i2 == 2) {
                vVar = (v) c.c.a.a.c.l.q.n(parcel, i, v.CREATOR);
            } else if (i2 != 3) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                g0Var = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new x(c0Var, vVar, g0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x[] newArray(int i) {
        return new x[i];
    }
}
