package c.c.a.a.c;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.a.c.l.h0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends c.c.a.a.f.b.b implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1422a;

    public t(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        c.c.a.a.c.l.q.b(bArr.length == 25);
        this.f1422a = Arrays.hashCode(bArr);
    }

    public static byte[] y(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // c.c.a.a.c.l.h0
    public final c.c.a.a.d.a b() {
        return new c.c.a.a.d.b(t());
    }

    @Override // c.c.a.a.f.b.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            c.c.a.a.d.a aVarB = b();
            parcel2.writeNoException();
            c.c.a.a.f.b.c.b(parcel2, aVarB);
            return true;
        }
        if (i != 2) {
            return false;
        }
        int iW = w();
        parcel2.writeNoException();
        parcel2.writeInt(iW);
        return true;
    }

    public boolean equals(Object obj) {
        c.c.a.a.d.a aVarB;
        if (obj != null && (obj instanceof h0)) {
            try {
                h0 h0Var = (h0) obj;
                if (h0Var.w() == this.f1422a && (aVarB = h0Var.b()) != null) {
                    return Arrays.equals(t(), (byte[]) c.c.a.a.d.b.t(aVarB));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1422a;
    }

    public abstract byte[] t();

    @Override // c.c.a.a.c.l.h0
    public final int w() {
        return this.f1422a;
    }
}
