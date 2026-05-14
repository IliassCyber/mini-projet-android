package c.c.b.h.c0.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.c.a.a.f.c.n1;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements p0, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1808b = "com.google.firebase.auth.api.internal.IFirebaseAuthService";

    public q0(IBinder iBinder) {
        this.f1807a = iBinder;
    }

    @Override // c.c.b.h.c0.a.p0
    public final void A(String str, String str2, n0 n0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(8, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void B(c.c.a.a.f.c.d0 d0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, d0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(111, parcelC);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1807a;
    }

    public final Parcel c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1808b);
        return parcelObtain;
    }

    @Override // c.c.b.h.c0.a.p0
    public final void e(c.c.a.a.f.c.h0 h0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, h0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(124, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void h(String str, c.c.b.h.w wVar, n0 n0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        c.c.a.a.f.c.i0.c(parcelC, wVar);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(24, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void i(c.c.a.a.f.c.f0 f0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, f0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(112, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void j(c.c.a.a.f.c.b0 b0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, b0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(101, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void k(String str, n1 n1Var, n0 n0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        c.c.a.a.f.c.i0.c(parcelC, n1Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(12, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void l(c.c.b.h.w wVar, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, wVar);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(23, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void n(String str, n0 n0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(1, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void o(c.c.a.a.f.c.m0 m0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, m0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(108, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void p(c.c.b.h.c cVar, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, cVar);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(29, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void r(c.c.a.a.f.c.q0 q0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, q0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(123, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void s(n1 n1Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, n1Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(3, parcelC);
    }

    public final void t(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f1807a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // c.c.b.h.c0.a.p0
    public final void u(c.c.a.a.f.c.o0 o0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, o0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(129, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void v(String str, String str2, String str3, n0 n0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(11, parcelC);
    }

    @Override // c.c.b.h.c0.a.p0
    public final void x(c.c.a.a.f.c.k0 k0Var, n0 n0Var) {
        Parcel parcelC = c();
        c.c.a.a.f.c.i0.c(parcelC, k0Var);
        c.c.a.a.f.c.i0.b(parcelC, n0Var);
        t(103, parcelC);
    }
}
