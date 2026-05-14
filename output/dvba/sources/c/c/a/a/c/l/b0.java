package c.c.a.a.c.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Parcelable.Creator<a0> {
    @Override // android.os.Parcelable.Creator
    public final a0 createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        Bundle bundleK = null;
        c.c.a.a.c.c[] cVarArr = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                bundleK = q.k(parcel, i);
            } else if (i2 != 2) {
                q.Z(parcel, i);
            } else {
                cVarArr = (c.c.a.a.c.c[]) q.q(parcel, i, c.c.a.a.c.c.CREATOR);
            }
        }
        q.v(parcel, iB0);
        return new a0(bundleK, cVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a0[] newArray(int i) {
        return new a0[i];
    }
}
