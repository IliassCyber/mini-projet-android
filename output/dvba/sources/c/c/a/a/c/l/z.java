package c.c.a.a.c.l;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator<s> {
    @Override // android.os.Parcelable.Creator
    public final s createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        IBinder iBinderP = null;
        c.c.a.a.c.a aVar = null;
        int iQ = 0;
        boolean zO = false;
        boolean zO2 = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 == 2) {
                iBinderP = q.P(parcel, i);
            } else if (i2 == 3) {
                aVar = (c.c.a.a.c.a) q.n(parcel, i, c.c.a.a.c.a.CREATOR);
            } else if (i2 == 4) {
                zO = q.O(parcel, i);
            } else if (i2 != 5) {
                q.Z(parcel, i);
            } else {
                zO2 = q.O(parcel, i);
            }
        }
        q.v(parcel, iB0);
        return new s(iQ, iBinderP, aVar, zO, zO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s[] newArray(int i) {
        return new s[i];
    }
}
