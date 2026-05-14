package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator<e0> {
    @Override // android.os.Parcelable.Creator
    public final e0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        long jR = 0;
        long jR2 = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                jR = c.c.a.a.c.l.q.R(parcel, i);
            } else if (i2 != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                jR2 = c.c.a.a.c.l.q.R(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new e0(jR, jR2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e0[] newArray(int i) {
        return new e0[i];
    }
}
