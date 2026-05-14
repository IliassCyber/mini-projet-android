package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements Parcelable.Creator<l1> {
    @Override // android.os.Parcelable.Creator
    public final l1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        int iQ = 0;
        ArrayList<String> arrayListP = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = c.c.a.a.c.l.q.Q(parcel, i);
            } else if (i2 != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                arrayListP = c.c.a.a.c.l.q.p(parcel, i);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new l1(iQ, arrayListP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l1[] newArray(int i) {
        return new l1[i];
    }
}
