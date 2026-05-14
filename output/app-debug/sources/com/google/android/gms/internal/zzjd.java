package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.zzjc;

/* JADX INFO: loaded from: classes.dex */
public interface zzjd extends IInterface {

    public static abstract class zza extends Binder implements zzjd {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzjd$zza$zza, reason: collision with other inner class name */
        private static class C0107zza implements zzjd {
            private IBinder zznF;

            C0107zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.APP_MISMATCH, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.TRANSIENT_ERROR, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjcVar, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzc(zzjc zzjcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    parcelObtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkV() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkW() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzjd zzal(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzjd)) ? new C0107zza(iBinder) : (zzjd) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                return true;
            }
            switch (i) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /* 5001 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int iZzkV = zzkV();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzkV);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /* 5002 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int iZzkW = zzkW();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzkW);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /* 5003 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /* 5004 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /* 5005 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /* 5006 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /* 5007 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /* 5008 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /* 5009 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzjc zzjcVar) throws RemoteException;

    void zza(zzjc zzjcVar, int i) throws RemoteException;

    void zza(zzjc zzjcVar, int i, String str, byte[] bArr) throws RemoteException;

    void zza(zzjc zzjcVar, int i, byte[] bArr) throws RemoteException;

    void zzb(zzjc zzjcVar) throws RemoteException;

    void zzb(zzjc zzjcVar, int i) throws RemoteException;

    void zzc(zzjc zzjcVar) throws RemoteException;

    int zzkV() throws RemoteException;

    int zzkW() throws RemoteException;
}
