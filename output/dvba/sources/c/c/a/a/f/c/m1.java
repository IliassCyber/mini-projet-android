package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Parcelable.Creator<n1> {
    @Override // android.os.Parcelable.Creator
    public final n1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        String strO7 = null;
        String strO8 = null;
        String strO9 = null;
        String strO10 = null;
        String strO11 = null;
        String strO12 = null;
        String strO13 = null;
        boolean zO = false;
        boolean zO2 = false;
        boolean zO3 = false;
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
                    strO3 = c.c.a.a.c.l.q.o(parcel, i);
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
                case 8:
                    strO7 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 9:
                    strO8 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 10:
                    zO = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 11:
                    zO2 = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 12:
                    strO9 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 13:
                    strO10 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 14:
                    strO11 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 15:
                    strO12 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                case 16:
                    zO3 = c.c.a.a.c.l.q.O(parcel, i);
                    break;
                case 17:
                    strO13 = c.c.a.a.c.l.q.o(parcel, i);
                    break;
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new n1(strO, strO2, strO3, strO4, strO5, strO6, strO7, strO8, zO, zO2, strO9, strO10, strO11, strO12, zO3, strO13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n1[] newArray(int i) {
        return new n1[i];
    }
}
