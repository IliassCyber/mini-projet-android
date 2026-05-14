package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        boolean zO = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 2) {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 3) {
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 4) {
                strO4 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 5) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                zO = c.c.a.a.c.l.q.O(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new c(strO, strO2, strO3, strO4, zO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
