package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.f.c.n1;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<g0> {
    @Override // android.os.Parcelable.Creator
    public final g0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        n1 n1Var = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strO = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 2:
                    strO2 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 3:
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 4:
                    n1Var = (n1) c.c.a.a.c.l.q.n(parcel, i, n1.CREATOR);
                    break;
                case 5:
                    strO4 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 6:
                    strO5 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 7:
                    strO6 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new g0(strO, strO2, strO3, n1Var, strO4, strO5, strO6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g0[] newArray(int i) {
        return new g0[i];
    }
}
