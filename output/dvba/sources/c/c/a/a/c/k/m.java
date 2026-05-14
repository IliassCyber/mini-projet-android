package c.c.a.a.c.k;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final Status createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        int iQ = 0;
        String strO = null;
        PendingIntent pendingIntent = null;
        int iQ2 = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ2 = q.Q(parcel, i);
            } else if (i2 == 2) {
                strO = q.o(parcel, i);
            } else if (i2 == 3) {
                pendingIntent = (PendingIntent) q.n(parcel, i, PendingIntent.CREATOR);
            } else if (i2 != 1000) {
                q.Z(parcel, i);
            } else {
                iQ = q.Q(parcel, i);
            }
        }
        q.v(parcel, iB0);
        return new Status(iQ, iQ2, strO, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
