package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable.Creator<a1> {
    @Override // android.os.Parcelable.Creator
    public final a1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        Long lS = null;
        String strO3 = null;
        Long lS2 = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 2) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 3) {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 4) {
                lS = c.c.a.a.c.l.q.S(parcel, i);
            } else if (i2 == 5) {
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 6) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                lS2 = c.c.a.a.c.l.q.S(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new a1(strO, strO2, lS, strO3, lS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a1[] newArray(int i) {
        return new a1[i];
    }
}
