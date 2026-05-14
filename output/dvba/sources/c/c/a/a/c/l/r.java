package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public class r extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<r> CREATOR = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Account f1403c;
    public final int d;
    public final GoogleSignInAccount e;

    public r(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f1402b = i;
        this.f1403c = account;
        this.d = i2;
        this.e = googleSignInAccount;
    }

    public r(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.f1402b = 2;
        this.f1403c = account;
        this.d = i;
        this.e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = q.a(parcel);
        q.d0(parcel, 1, this.f1402b);
        q.g0(parcel, 2, this.f1403c, i, false);
        q.d0(parcel, 3, this.d);
        q.g0(parcel, 4, this.e, i, false);
        q.C0(parcel, iA);
    }
}
