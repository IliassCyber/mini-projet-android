package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements Parcelable.Creator<q0> {
    @Override // android.os.Parcelable.Creator
    public final q0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        c.c.b.h.w wVar = null;
        String strO = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                wVar = (c.c.b.h.w) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.w.CREATOR);
            } else if (i2 != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new q0(wVar, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q0[] newArray(int i) {
        return new q0[i];
    }
}
