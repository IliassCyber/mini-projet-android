package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator<v0> {
    @Override // android.os.Parcelable.Creator
    public final v0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        ArrayList arrayListR = null;
        c.c.b.h.g0 g0Var = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 2) {
                arrayListR = c.c.a.a.c.l.q.r(parcel, i, b1.CREATOR);
            } else if (i2 != 3) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                g0Var = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new v0(strO, arrayListR, g0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v0[] newArray(int i) {
        return new v0[i];
    }
}
