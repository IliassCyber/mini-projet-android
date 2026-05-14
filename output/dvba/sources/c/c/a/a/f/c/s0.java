package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Parcelable.Creator<t0> {
    @Override // android.os.Parcelable.Creator
    public final t0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        Status status = null;
        c.c.b.h.g0 g0Var = null;
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                status = (Status) c.c.a.a.c.l.q.n(parcel, i, Status.CREATOR);
            } else if (i2 == 2) {
                g0Var = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
            } else if (i2 == 3) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 4) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new t0(status, g0Var, strO, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t0[] newArray(int i) {
        return new t0[i];
    }
}
