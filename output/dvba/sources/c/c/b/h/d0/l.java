package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator<m> {
    @Override // android.os.Parcelable.Creator
    public final m createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        ArrayList arrayListR = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            if ((65535 & i) != 1) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                arrayListR = c.c.a.a.c.l.q.r(parcel, i, c.c.b.h.y.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new m(arrayListR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m[] newArray(int i) {
        return new m[i];
    }
}
