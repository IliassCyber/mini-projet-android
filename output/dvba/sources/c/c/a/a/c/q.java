package c.c.a.a.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final a createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        int iQ = 0;
        PendingIntent pendingIntent = null;
        String strO = null;
        int iQ2 = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = c.c.a.a.c.l.q.Q(parcel, i);
            } else if (i2 == 2) {
                iQ2 = c.c.a.a.c.l.q.Q(parcel, i);
            } else if (i2 == 3) {
                pendingIntent = (PendingIntent) c.c.a.a.c.l.q.n(parcel, i, PendingIntent.CREATOR);
            } else if (i2 != 4) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new a(iQ, iQ2, pendingIntent, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
