package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable.Creator<k0> {
    @Override // android.os.Parcelable.Creator
    public final k0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        n1 n1Var = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            if ((65535 & i) != 1) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                n1Var = (n1) c.c.a.a.c.l.q.n(parcel, i, n1.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new k0(n1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k0[] newArray(int i) {
        return new k0[i];
    }
}
