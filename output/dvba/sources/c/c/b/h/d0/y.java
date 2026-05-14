package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator<z> {
    @Override // android.os.Parcelable.Creator
    public final z createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        String strO7 = null;
        boolean zO = false;
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
                    strO5 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 4:
                    strO4 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 5:
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 6:
                    strO6 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 7:
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 8:
                    strO7 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new z(strO, strO2, strO3, strO4, strO5, strO6, zO, strO7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z[] newArray(int i) {
        return new z[i];
    }
}
