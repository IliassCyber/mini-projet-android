package c.c.a.a.c.k.k;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import c.c.a.a.c.k.k.d;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    public x(int i) {
    }

    public static Status d(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (remoteException instanceof TransactionTooLargeException) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void b(m0 m0Var, boolean z);

    public abstract void c(RuntimeException runtimeException);

    public abstract void e(d.a<?> aVar);
}
