package c.c.a.a.c.k;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        int iQ = 0;
        String strO = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 != 2) {
                q.Z(parcel, i);
            } else {
                strO = q.o(parcel, i);
            }
        }
        q.v(parcel, iB0);
        return new Scope(iQ, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
