package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataStatsResult;

/* JADX INFO: loaded from: classes.dex */
public interface zzmr extends IInterface {

    public static abstract class zza extends Binder implements zzmr {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzmr$zza$zza, reason: collision with other inner class name */
        private static class C0134zza implements zzmr {
            private IBinder zznF;

            C0134zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzmr
            public void zza(DataStatsResult dataStatsResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    if (dataStatsResult != null) {
                        parcelObtain.writeInt(1);
                        dataStatsResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zznF.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzmr zzbC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzmr)) ? new C0134zza(iBinder) : (zzmr) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.fitness.internal.IReadStatsCallback");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
            zza(parcel.readInt() != 0 ? DataStatsResult.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void zza(DataStatsResult dataStatsResult) throws RemoteException;
}
