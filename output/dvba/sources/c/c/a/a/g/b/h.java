package c.c.a.a.g.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1492b = "com.google.android.gms.signin.internal.ISignInService";

    public h(IBinder iBinder) {
        this.f1491a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1491a;
    }

    @Override // c.c.a.a.g.b.f
    public final void m(j jVar, d dVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1492b);
        c.c.a.a.f.a.b.b(parcelObtain, jVar);
        parcelObtain.writeStrongBinder(dVar.asBinder());
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f1491a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
