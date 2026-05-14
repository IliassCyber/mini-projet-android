package c.c.a.a.c.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import c.c.a.a.c.l.b;

/* JADX INFO: loaded from: classes.dex */
public interface l extends IInterface {

    public static abstract class a extends c.c.a.a.f.b.b implements l {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // c.c.a.a.f.b.b
        public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                ((b.i) this).t(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.c.a.a.f.b.c.a(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                parcel.readInt();
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            } else {
                if (i != 3) {
                    return false;
                }
                int i3 = parcel.readInt();
                IBinder strongBinder = parcel.readStrongBinder();
                a0 a0Var = (a0) c.c.a.a.f.b.c.a(parcel, a0.CREATOR);
                b.i iVar = (b.i) this;
                q.g(iVar.f1360a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                q.f(a0Var);
                iVar.f1360a.s = a0Var;
                iVar.t(i3, strongBinder, a0Var.f1350b);
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
