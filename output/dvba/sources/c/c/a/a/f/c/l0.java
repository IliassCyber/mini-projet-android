package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable.Creator<m0> {
    @Override // android.os.Parcelable.Creator
    public final m0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
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
                strO3 = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new m0(strO, strO2, strO3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m0[] newArray(int i) {
        return new m0[i];
    }
}
