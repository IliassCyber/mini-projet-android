package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Parcelable.Creator<x0> {
    @Override // android.os.Parcelable.Creator
    public final x0 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        l1 l1Var = null;
        ArrayList<String> arrayListP = null;
        boolean zO = false;
        boolean zO2 = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strO = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 3:
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 4:
                    strO2 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 5:
                    zO2 = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 6:
                    l1Var = (l1) c.c.a.a.c.l.q.n(parcel, i, l1.CREATOR);
                    break;
                case 7:
                    arrayListP = c.c.a.a.c.l.q.p(parcel, i);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new x0(strO, zO, strO2, zO2, l1Var, arrayListP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x0[] newArray(int i) {
        return new x0[i];
    }
}
