package c.c.b.h.c0.a;

import android.os.Parcel;
import c.c.a.a.f.c.i1;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends c.c.a.a.f.c.a implements n0 {
    public o0() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // c.c.a.a.f.c.a
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                c.c.a.a.f.c.a1 a1Var = (c.c.a.a.f.c.a1) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.a1.CREATOR);
                w0 w0Var = (w0) this;
                c.a.a.a.a.f(37, "Unexpected response type: ", w0Var.f1820a.f1815a, w0Var.f1820a.f1815a == 1);
                u0 u0Var = w0Var.f1820a;
                u0Var.j = a1Var;
                u0.g(u0Var);
                return true;
            case 2:
                c.c.a.a.f.c.a1 a1Var2 = (c.c.a.a.f.c.a1) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.a1.CREATOR);
                c.c.a.a.f.c.z0 z0Var = (c.c.a.a.f.c.z0) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.z0.CREATOR);
                w0 w0Var2 = (w0) this;
                c.a.a.a.a.f(37, "Unexpected response type: ", w0Var2.f1820a.f1815a, w0Var2.f1820a.f1815a == 2);
                u0 u0Var2 = w0Var2.f1820a;
                u0Var2.j = a1Var2;
                u0Var2.k = z0Var;
                u0.g(u0Var2);
                return true;
            case 3:
                c.c.a.a.f.c.x0 x0Var = (c.c.a.a.f.c.x0) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.x0.CREATOR);
                w0 w0Var3 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var3.f1820a.f1815a, w0Var3.f1820a.f1815a == 3);
                u0 u0Var3 = w0Var3.f1820a;
                u0Var3.l = x0Var;
                u0.g(u0Var3);
                return true;
            case 4:
                i1 i1Var = (i1) c.c.a.a.f.c.i0.a(parcel, i1.CREATOR);
                w0 w0Var4 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var4.f1820a.f1815a, w0Var4.f1820a.f1815a == 4);
                u0 u0Var4 = w0Var4.f1820a;
                u0Var4.m = i1Var;
                u0.g(u0Var4);
                return true;
            case 5:
                Status status = (Status) c.c.a.a.f.c.i0.a(parcel, Status.CREATOR);
                w0 w0Var5 = (w0) this;
                String str = status.d;
                if (str != null) {
                    if (str.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                        status = new Status(17081, null);
                    } else if (str.contains("MISSING_MFA_ENROLLMENT_ID")) {
                        status = new Status(17082, null);
                    } else if (str.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                        status = new Status(17083, null);
                    } else if (str.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                        status = new Status(17084, null);
                    } else if (str.contains("ADMIN_ONLY_OPERATION")) {
                        status = new Status(17085, null);
                    } else if (str.contains("UNVERIFIED_EMAIL")) {
                        status = new Status(17086, null);
                    } else if (str.contains("SECOND_FACTOR_EXISTS")) {
                        status = new Status(17087, null);
                    } else if (str.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                        status = new Status(17088, null);
                    } else if (str.contains("UNSUPPORTED_FIRST_FACTOR")) {
                        status = new Status(17089, null);
                    } else if (str.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                        status = new Status(17090, null);
                    }
                }
                u0 u0Var5 = w0Var5.f1820a;
                if (u0Var5.f1815a == 8) {
                    u0Var5.v = true;
                    w0Var5.f1820a.i.execute(new z0(w0Var5, new a1(status)));
                } else {
                    c.c.b.h.d0.f fVar = u0Var5.f;
                    if (fVar != null) {
                        fVar.b(status);
                    }
                    u0 u0Var6 = w0Var5.f1820a;
                    u0Var6.v = true;
                    u0Var6.g.a(null, status);
                }
                return true;
            case 6:
                w0 w0Var6 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var6.f1820a.f1815a, w0Var6.f1820a.f1815a == 5);
                u0.g(w0Var6.f1820a);
                return true;
            case 7:
                w0 w0Var7 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var7.f1820a.f1815a, w0Var7.f1820a.f1815a == 6);
                u0.g(w0Var7.f1820a);
                return true;
            case 8:
                String string = parcel.readString();
                w0 w0Var8 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var8.f1820a.f1815a, w0Var8.f1820a.f1815a == 7);
                u0 u0Var7 = w0Var8.f1820a;
                u0Var7.n = string;
                u0.g(u0Var7);
                return true;
            case 9:
                String string2 = parcel.readString();
                w0 w0Var9 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var9.f1820a.f1815a, w0Var9.f1820a.f1815a == 8);
                w0Var9.f1820a.o = string2;
                w0Var9.f1820a.i.execute(new z0(w0Var9, new v0(string2)));
                return true;
            case 10:
                c.c.b.h.w wVar = (c.c.b.h.w) c.c.a.a.f.c.i0.a(parcel, c.c.b.h.w.CREATOR);
                w0 w0Var10 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var10.f1820a.f1815a, w0Var10.f1820a.f1815a == 8);
                w0Var10.f1820a.v = true;
                w0Var10.f1820a.i.execute(new z0(w0Var10, new y0(wVar)));
                return true;
            case 11:
                String string3 = parcel.readString();
                w0 w0Var11 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var11.f1820a.f1815a, w0Var11.f1820a.f1815a == 8);
                u0 u0Var8 = w0Var11.f1820a;
                u0Var8.o = string3;
                u0Var8.v = true;
                w0Var11.f1820a.i.execute(new z0(w0Var11, new x0(string3)));
                return true;
            case 12:
                Status status2 = (Status) c.c.a.a.f.c.i0.a(parcel, Status.CREATOR);
                c.c.b.h.w wVar2 = (c.c.b.h.w) c.c.a.a.f.c.i0.a(parcel, c.c.b.h.w.CREATOR);
                w0 w0Var12 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var12.f1820a.f1815a, w0Var12.f1820a.f1815a == 2);
                w0Var12.t(status2, wVar2, null, null);
                return true;
            case 13:
                w0 w0Var13 = (w0) this;
                c.a.a.a.a.f(36, "Unexpected response type ", w0Var13.f1820a.f1815a, w0Var13.f1820a.f1815a == 9);
                u0.g(w0Var13.f1820a);
                return true;
            case 14:
                c.c.a.a.f.c.t0 t0Var = (c.c.a.a.f.c.t0) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.t0.CREATOR);
                ((w0) this).t(t0Var.f1479b, t0Var.f1480c, t0Var.d, t0Var.e);
                return true;
            case 15:
                c.c.a.a.f.c.v0 v0Var = (c.c.a.a.f.c.v0) c.c.a.a.f.c.i0.a(parcel, c.c.a.a.f.c.v0.CREATOR);
                u0 u0Var9 = ((w0) this).f1820a;
                u0Var9.s = v0Var;
                Status statusP0 = c.c.a.a.c.l.q.p0("REQUIRES_SECOND_FACTOR_AUTH");
                u0Var9.v = true;
                u0Var9.g.a(null, statusP0);
                return true;
            default:
                return false;
        }
    }
}
