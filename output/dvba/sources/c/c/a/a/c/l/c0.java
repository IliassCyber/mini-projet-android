package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int iB0 = q.b0(parcel);
        String strO = null;
        IBinder iBinderP = null;
        Scope[] scopeArr = null;
        Bundle bundleK = null;
        Account account = null;
        c.c.a.a.c.c[] cVarArr = null;
        c.c.a.a.c.c[] cVarArr2 = null;
        int iQ = 0;
        int iQ2 = 0;
        int iQ3 = 0;
        boolean zO = false;
        while (parcel.dataPosition() < iB0) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iQ = q.Q(parcel, i);
                    break;
                case 2:
                    iQ2 = q.Q(parcel, i);
                    break;
                case 3:
                    iQ3 = q.Q(parcel, i);
                    break;
                case 4:
                    strO = q.o(parcel, i);
                    break;
                case 5:
                    iBinderP = q.P(parcel, i);
                    break;
                case 6:
                    scopeArr = (Scope[]) q.q(parcel, i, Scope.CREATOR);
                    break;
                case 7:
                    bundleK = q.k(parcel, i);
                    break;
                case 8:
                    account = (Account) q.n(parcel, i, Account.CREATOR);
                    break;
                case 9:
                default:
                    q.Z(parcel, i);
                    break;
                case 10:
                    cVarArr = (c.c.a.a.c.c[]) q.q(parcel, i, c.c.a.a.c.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c.c.a.a.c.c[]) q.q(parcel, i, c.c.a.a.c.c.CREATOR);
                    break;
                case 12:
                    zO = q.O(parcel, i);
                    break;
            }
        }
        q.v(parcel, iB0);
        return new f(iQ, iQ2, iQ3, strO, iBinderP, scopeArr, bundleK, account, cVarArr, cVarArr2, zO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i) {
        return new f[i];
    }
}
