package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator<v> {
    @Override // android.os.Parcelable.Creator
    public final v createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        boolean zO = false;
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
                zO = c.c.a.a.c.l.q.O(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new v(strO, strO2, zO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ v[] newArray(int i) {
        return new v[i];
    }
}
