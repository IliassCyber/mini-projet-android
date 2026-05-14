package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Parcelable.Creator<z0> {
    @Override // android.os.Parcelable.Creator
    public final z0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        long jR = 0;
        long jR2 = 0;
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        f1 f1Var = null;
        String strO5 = null;
        String strO6 = null;
        c.c.b.h.g0 g0Var = null;
        ArrayList arrayListR = null;
        boolean zO = false;
        boolean zO2 = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strO = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 3:
                    strO2 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 4:
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 5:
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 6:
                    strO4 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 7:
                    f1Var = (f1) c.c.a.a.c.l.q.n(parcel, i, f1.CREATOR);
                    break;
                case 8:
                    strO5 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 9:
                    strO6 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 10:
                    jR = c.c.a.a.c.l.q.R(parcel, i);
                    break;
                case 11:
                    jR2 = c.c.a.a.c.l.q.R(parcel, i);
                    break;
                case 12:
                    zO2 = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 13:
                    g0Var = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
                    break;
                case 14:
                    arrayListR = c.c.a.a.c.l.q.r(parcel, i, b1.CREATOR);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new z0(strO, strO2, zO, strO3, strO4, f1Var, strO5, strO6, jR, jR2, zO2, g0Var, arrayListR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z0[] newArray(int i) {
        return new z0[i];
    }
}
