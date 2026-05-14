package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e1 implements Parcelable.Creator<b1> {
    @Override // android.os.Parcelable.Creator
    public final b1 createFromParcel(Parcel parcel) {
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
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 4) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                jR = c.c.a.a.c.l.q.R(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new b1(strO, strO2, strO3, jR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b1[] newArray(int i) {
        return new b1[i];
    }
}
