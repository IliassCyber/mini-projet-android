package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Parcelable.Creator<h0> {
    @Override // android.os.Parcelable.Creator
    public final h0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        c.c.b.h.w wVar = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            } else if (i2 != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                wVar = (c.c.b.h.w) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.w.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new h0(strO, wVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h0[] newArray(int i) {
        return new h0[i];
    }
}
