package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Parcelable.Creator<f0> {
    @Override // android.os.Parcelable.Creator
    public final f0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        ArrayList arrayListR = null;
        g0 g0Var = null;
        String strO = null;
        c.c.b.h.g0 g0Var2 = null;
        c0 c0Var = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                arrayListR = c.c.a.a.c.l.q.r(parcel, i, c.c.b.h.y.CREATOR);
            } else if (i2 == 2) {
                g0Var = (g0) c.c.a.a.c.l.q.n(parcel, i, g0.CREATOR);
            } else if (i2 == 3) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 4) {
                g0Var2 = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
            } else if (i2 != 5) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                c0Var = (c0) c.c.a.a.c.l.q.n(parcel, i, c0.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new f0(arrayListR, g0Var, strO, g0Var2, c0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0[] newArray(int i) {
        return new f0[i];
    }
}
