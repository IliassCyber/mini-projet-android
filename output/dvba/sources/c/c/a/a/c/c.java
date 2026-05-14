package c.c.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.c.l.p;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<c> CREATOR = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public final int f1283c;
    public final long d;

    public c(String str, int i, long j) {
        this.f1282b = str;
        this.f1283c = i;
        this.d = j;
    }

    public c(String str, long j) {
        this.f1282b = str;
        this.d = j;
        this.f1283c = -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.f1282b;
            if (((str != null && str.equals(cVar.f1282b)) || (this.f1282b == null && cVar.f1282b == null)) && h() == cVar.h()) {
                return true;
            }
        }
        return false;
    }

    public long h() {
        long j = this.d;
        return j == -1 ? this.f1283c : j;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1282b, Long.valueOf(h())});
    }

    public String toString() {
        p pVarB0 = a.a.a.a.a.B0(this);
        pVarB0.a("name", this.f1282b);
        pVarB0.a("version", Long.valueOf(h()));
        return pVarB0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.h0(parcel, 1, this.f1282b, false);
        c.c.a.a.c.l.q.d0(parcel, 2, this.f1283c);
        c.c.a.a.c.l.q.e0(parcel, 3, h());
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
