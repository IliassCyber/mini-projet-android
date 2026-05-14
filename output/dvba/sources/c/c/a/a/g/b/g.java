package c.c.a.a.g.b;

import android.os.Parcel;
import c.c.a.a.c.k.k.b0;
import c.c.a.a.c.k.k.z;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends c.c.a.a.f.a.a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // c.c.a.a.f.a.a
    public boolean C(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
        } else if (i == 4 || i == 6) {
        } else if (i == 7) {
        } else {
            if (i != 8) {
                return false;
            }
            l lVar = (l) c.c.a.a.f.a.b.a(parcel, l.CREATOR);
            z zVar = (z) this;
            zVar.f1348b.post(new b0(zVar, lVar));
        }
        parcel2.writeNoException();
        return true;
    }
}
