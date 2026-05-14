package c.c.a.a.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import c.c.a.a.c.l.r;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final j createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        int iQ = 0;
        r rVar = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 != 2) {
                q.Z(parcel, i);
            } else {
                rVar = (r) q.n(parcel, i, r.CREATOR);
            }
        }
        q.v(parcel, iB0);
        return new j(iQ, rVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i) {
        return new j[i];
    }
}
