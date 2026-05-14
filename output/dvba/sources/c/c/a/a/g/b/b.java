package c.c.a.a.g.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final c createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        int iQ = 0;
        Intent intent = null;
        int iQ2 = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 == 2) {
                iQ2 = q.Q(parcel, i);
            } else if (i2 != 3) {
                q.Z(parcel, i);
            } else {
                intent = (Intent) q.n(parcel, i, Intent.CREATOR);
            }
        }
        q.v(parcel, iB0);
        return new c(iQ, iQ2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
