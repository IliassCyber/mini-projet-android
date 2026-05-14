package c.c.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.s;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final l createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        c.c.a.a.c.a aVar = null;
        s sVar = null;
        int iQ = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 == 2) {
                aVar = (c.c.a.a.c.a) q.n(parcel, i, c.c.a.a.c.a.CREATOR);
            } else if (i2 != 3) {
                q.Z(parcel, i);
            } else {
                sVar = (s) q.n(parcel, i, s.CREATOR);
            }
        }
        q.v(parcel, iB0);
        return new l(iQ, aVar, sVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i) {
        return new l[i];
    }
}
