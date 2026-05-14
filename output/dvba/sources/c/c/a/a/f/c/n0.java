package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable.Creator<o0> {
    @Override // android.os.Parcelable.Creator
    public final o0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        c.c.b.h.c cVar = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            if ((65535 & i) != 1) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                cVar = (c.c.b.h.c) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.c.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new o0(cVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0[] newArray(int i) {
        return new o0[i];
    }
}
