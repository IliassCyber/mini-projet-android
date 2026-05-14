package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g1 implements Parcelable.Creator<d1> {
    @Override // android.os.Parcelable.Creator
    public final d1 createFromParcel(Parcel parcel) {
        int iB0 = c.c.a.a.c.l.q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        String strO7 = null;
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
                default:
                    c.c.a.a.c.l.q.Z(parcel, i);
                    break;
            }
        }
        c.c.a.a.c.l.q.v(parcel, iB0);
        return new d1(strO, strO2, strO3, strO4, strO5, strO6, strO7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d1[] newArray(int i) {
        return new d1[i];
    }
}
