package c.c.b.h.d0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class x implements c.c.a.a.c.l.u.c {
    public static final Parcelable.Creator<x> CREATOR = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f1863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f1864c;
    public c.c.b.h.g0 d;

    public x(c0 c0Var) {
        c.c.a.a.c.l.q.f(c0Var);
        this.f1863b = c0Var;
        List<z> list = c0Var.f;
        this.f1864c = null;
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.isEmpty(list.get(i).i)) {
                this.f1864c = new v(list.get(i).f1866c, list.get(i).i, c0Var.k);
            }
        }
        if (this.f1864c == null) {
            this.f1864c = new v(c0Var.k);
        }
        this.d = c0Var.l;
    }

    public x(c0 c0Var, v vVar, c.c.b.h.g0 g0Var) {
        this.f1863b = c0Var;
        this.f1864c = vVar;
        this.d = g0Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.g0(parcel, 1, this.f1863b, i, false);
        c.c.a.a.c.l.q.g0(parcel, 2, this.f1864c, i, false);
        c.c.a.a.c.l.q.g0(parcel, 3, this.d, i, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
