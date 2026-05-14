package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j1 implements Parcelable.Creator<i1> {
    @Override // android.os.Parcelable.Creator
    public final i1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        b1 b1Var = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 2) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 3) {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 4) {
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 5) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                b1Var = (b1) c.c.a.a.c.l.q.n(parcel, i, b1.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new i1(strO, strO2, strO3, b1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i1[] newArray(int i) {
        return new i1[i];
    }
}
