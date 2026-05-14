package c.c.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        int iQ = 0;
        long jR = -1;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 == 2) {
                iQ = c.c.a.a.c.l.q.Q(parcel, i);
            } else if (i2 != 3) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                jR = c.c.a.a.c.l.q.R(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new c(strO, iQ, jR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
