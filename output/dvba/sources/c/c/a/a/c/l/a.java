package c.c.a.a.c.l;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.a.c.l.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends k.a {
    public static Account y(k kVar) {
        if (kVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return kVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
                return null;
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return null;
    }
}
