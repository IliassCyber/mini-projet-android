package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable.Creator<d> {
    @Override // android.os.Parcelable.Creator
    public final d createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            if ((65535 & i) != 1) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                strO = c.c.a.a.c.l.q.o(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new d(strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d[] newArray(int i) {
        return new d[i];
    }
}
