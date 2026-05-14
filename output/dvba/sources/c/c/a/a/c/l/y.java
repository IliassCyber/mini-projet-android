package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator<r> {
    @Override // android.os.Parcelable.Creator
    public final r createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        int iQ = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iQ2 = 0;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            int i2 = 65535 & i;
            if (i2 == 1) {
                iQ = q.Q(parcel, i);
            } else if (i2 == 2) {
                account = (Account) q.n(parcel, i, Account.CREATOR);
            } else if (i2 == 3) {
                iQ2 = q.Q(parcel, i);
            } else if (i2 != 4) {
                q.Z(parcel, i);
            } else {
                googleSignInAccount = (GoogleSignInAccount) q.n(parcel, i, GoogleSignInAccount.CREATOR);
            }
        }
        q.v(parcel, iB0);
        return new r(iQ, account, iQ2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r[] newArray(int i) {
        return new r[i];
    }
}
