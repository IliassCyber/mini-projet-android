package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable.Creator<g0> {
    @Override // android.os.Parcelable.Creator
    public final g0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        ArrayList arrayListR = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 2) {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 3) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                arrayListR = c.c.a.a.c.l.q.r(parcel, i, c.c.b.h.y.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new g0(strO, strO2, arrayListR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g0[] newArray(int i) {
        return new g0[i];
    }
}
