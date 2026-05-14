package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements Parcelable.Creator<y> {
    @Override // android.os.Parcelable.Creator
    public final y createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        long jR = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 2) {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 3) {
                jR = c.c.a.a.c.l.q.R(parcel, i);
            } else if (i2 != 4) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new y(strO, strO2, jR, strO3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y[] newArray(int i) {
        return new y[i];
    }
}
