package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h1 implements Parcelable.Creator<f1> {
    @Override // android.os.Parcelable.Creator
    public final f1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        ArrayList arrayListR = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            if ((65535 & i) != 2) {
                c.c.a.a.c.l.q.Z(parcel, i);
            } else {
                arrayListR = c.c.a.a.c.l.q.r(parcel, i, d1.CREATOR);
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new f1(arrayListR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f1[] newArray(int i) {
        return new f1[i];
    }
}
