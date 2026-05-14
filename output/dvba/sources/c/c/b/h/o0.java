package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable.Creator<r> {
    @Override // android.os.Parcelable.Creator
    public final r createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO2 = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new r(strO, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r[] newArray(int i) {
        return new r[i];
    }
}
