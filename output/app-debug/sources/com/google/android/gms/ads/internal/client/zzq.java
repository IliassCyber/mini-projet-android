package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzef;

/* JADX INFO: loaded from: classes.dex */
public interface zzq extends IInterface {

    public static abstract class zza extends Binder implements zzq {

        /* JADX INFO: renamed from: com.google.android.gms.ads.internal.client.zzq$zza$zza, reason: collision with other inner class name */
        private static class C0006zza implements zzq {
            private IBinder zznF;

            C0006zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.ads.internal.client.zzq
            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, String str, zzef zzefVar, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzefVar != null ? zzefVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zznF.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzq zzj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzq)) ? new C0006zza(iBinder) : (zzq) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            IBinder iBinderZza = zza(zzd.zza.zzbg(parcel.readStrongBinder()), parcel.readString(), zzef.zza.zzE(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderZza);
            return true;
        }
    }

    IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, String str, zzef zzefVar, int i) throws RemoteException;
}
