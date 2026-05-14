package c.c.a.a.e;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class d extends c.c.a.a.f.b.a implements c {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // c.c.a.a.e.c
    public final int d(c.c.a.a.d.a aVar, String str, boolean z) {
        Parcel parcelC = c();
        c.c.a.a.f.b.c.b(parcelC, aVar);
        parcelC.writeString(str);
        parcelC.writeInt(z ? 1 : 0);
        Parcel parcelT = t(5, parcelC);
        int i = parcelT.readInt();
        parcelT.recycle();
        return i;
    }

    @Override // c.c.a.a.e.c
    public final int f(c.c.a.a.d.a aVar, String str, boolean z) {
        Parcel parcelC = c();
        c.c.a.a.f.b.c.b(parcelC, aVar);
        parcelC.writeString(str);
        parcelC.writeInt(z ? 1 : 0);
        Parcel parcelT = t(3, parcelC);
        int i = parcelT.readInt();
        parcelT.recycle();
        return i;
    }

    @Override // c.c.a.a.e.c
    public final int g() {
        Parcel parcelT = t(6, c());
        int i = parcelT.readInt();
        parcelT.recycle();
        return i;
    }
}
