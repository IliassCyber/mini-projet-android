package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* JADX INFO: loaded from: classes.dex */
public interface zzqt extends IInterface {

    public static abstract class zza extends Binder implements zzqt {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzqt$zza$zza, reason: collision with other inner class name */
        private static class C0160zza implements zzqt {
            private IBinder zznF;

            C0160zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzqt
            public zzqq zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzqr zzqrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        parcelObtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzqrVar != null ? zzqrVar.asBinder() : null);
                    this.zznF.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return zzqq.zza.zzdF(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzqt zzdI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzqt)) ? new C0160zza(iBinder) : (zzqt) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            zzqq zzqqVarZza = zza(zzd.zza.zzbg(parcel.readStrongBinder()), zzc.zza.zzbf(parcel.readStrongBinder()), parcel.readInt() != 0 ? WalletFragmentOptions.CREATOR.createFromParcel(parcel) : null, zzqr.zza.zzdG(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zzqqVarZza != null ? zzqqVarZza.asBinder() : null);
            return true;
        }
    }

    zzqq zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzqr zzqrVar) throws RemoteException;
}
