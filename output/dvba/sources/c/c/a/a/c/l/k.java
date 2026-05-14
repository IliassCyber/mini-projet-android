package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {

    public static abstract class a extends c.c.a.a.f.b.b implements k {

        /* JADX INFO: renamed from: c.c.a.a.c.l.k$a$a, reason: collision with other inner class name */
        public static class C0056a extends c.c.a.a.f.b.a implements k {
            public C0056a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // c.c.a.a.c.l.k
            public final Account a() {
                Parcel parcelT = t(2, c());
                Account account = (Account) c.c.a.a.f.b.c.a(parcelT, Account.CREATOR);
                parcelT.recycle();
                return account;
            }
        }

        public static k t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof k ? (k) iInterfaceQueryLocalInterface : new C0056a(iBinder);
        }
    }

    Account a();
}
