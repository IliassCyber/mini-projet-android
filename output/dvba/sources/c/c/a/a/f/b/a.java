package c.c.a.a.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1429b;

    public a(IBinder iBinder, String str) {
        this.f1428a = iBinder;
        this.f1429b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1428a;
    }

    public final Parcel c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1429b);
        return parcelObtain;
    }

    public final Parcel t(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f1428a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
