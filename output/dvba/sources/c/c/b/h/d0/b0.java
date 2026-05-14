package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.f.c.a1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Parcelable.Creator<c0> {
    @Override // android.os.Parcelable.Creator
    public final c0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        a1 a1Var = null;
        z zVar = null;
        String strO = null;
        String strO2 = null;
        ArrayList arrayListR = null;
        ArrayList<String> arrayListP = null;
        String strO3 = null;
        Boolean boolValueOf = null;
        e0 e0Var = null;
        c.c.b.h.g0 g0Var = null;
        m mVar = null;
        boolean zO = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (i & 65535) {
                case 1:
                    a1Var = (a1) c.c.a.a.c.l.q.n(parcel, i, a1.CREATOR);
                    break;
                case 2:
                    zVar = (z) c.c.a.a.c.l.q.n(parcel, i, z.CREATOR);
                    break;
                case 3:
                    strO = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 4:
                    strO2 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 5:
                    arrayListR = c.c.a.a.c.l.q.r(parcel, i, z.CREATOR);
                    break;
                case 6:
                    arrayListP = c.c.a.a.c.l.q.p(parcel, i);
                    break;
                case 7:
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 8:
                    int iT = c.c.a.a.c.l.q.T(parcel, i);
                    if (iT != 0) {
                        c.c.a.a.c.l.q.z0(parcel, iT, 4);
                        boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 9:
                    e0Var = (e0) c.c.a.a.c.l.q.n(parcel, i, e0.CREATOR);
                    break;
                case 10:
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 11:
                    g0Var = (c.c.b.h.g0) c.c.a.a.c.l.q.n(parcel, i, c.c.b.h.g0.CREATOR);
                    break;
                case 12:
                    mVar = (m) c.c.a.a.c.l.q.n(parcel, i, m.CREATOR);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new c0(a1Var, zVar, strO, strO2, arrayListR, arrayListP, strO3, boolValueOf, e0Var, zO, g0Var, mVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0[] newArray(int i) {
        return new c0[i];
    }
}
