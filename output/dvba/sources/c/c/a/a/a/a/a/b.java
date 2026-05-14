package c.c.a.a.a.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.q;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        Uri uri = null;
        String strO5 = null;
        String strO6 = null;
        ArrayList arrayListR = null;
        String strO7 = null;
        String strO8 = null;
        long jR = 0;
        int iQ = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iQ = q.Q(parcel, i);
                    break;
                case 2:
                    strO = q.o(parcel, i);
                    break;
                case 3:
                    strO2 = q.o(parcel, i);
                    break;
                case 4:
                    strO3 = q.o(parcel, i);
                    break;
                case 5:
                    strO4 = q.o(parcel, i);
                    break;
                case 6:
                    uri = (Uri) q.n(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strO5 = q.o(parcel, i);
                    break;
                case 8:
                    jR = q.R(parcel, i);
                    break;
                case 9:
                    strO6 = q.o(parcel, i);
                    break;
                case 10:
                    arrayListR = q.r(parcel, i, Scope.CREATOR);
                    break;
                case 11:
                    strO7 = q.o(parcel, i);
                    break;
                case 12:
                    strO8 = q.o(parcel, i);
                    break;
                default:
                    q.Z(parcel, i);
                    break;
            }
        }
        q.v(parcel, iB0);
        return new GoogleSignInAccount(iQ, strO, strO2, strO3, strO4, uri, strO5, jR, strO6, arrayListR, strO7, strO8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
