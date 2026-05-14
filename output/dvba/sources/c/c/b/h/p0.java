package c.c.b.h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements Parcelable.Creator<w> {
    @Override // android.os.Parcelable.Creator
    public final w createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        boolean zO = false;
        boolean zO2 = false;
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
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 4:
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 5:
                    zO2 = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 6:
                    strO4 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 7:
                    strO5 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new w(strO, strO2, zO, strO3, zO2, strO4, strO5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w[] newArray(int i) {
        return new w[i];
    }
}
