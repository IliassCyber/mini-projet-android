package c.c.a.b.u;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0064a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f1683c;
    public final o d;
    public final b e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: c.c.a.b.u.a$a, reason: collision with other inner class name */
    public static class C0064a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((o) parcel.readParcelable(o.class.getClassLoader()), (o) parcel.readParcelable(o.class.getClassLoader()), (o) parcel.readParcelable(o.class.getClassLoader()), (b) parcel.readParcelable(b.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public interface b extends Parcelable {
        boolean g(long j);
    }

    public a(o oVar, o oVar2, o oVar3, b bVar, C0064a c0064a) {
        this.f1682b = oVar;
        this.f1683c = oVar2;
        this.d = oVar3;
        this.e = bVar;
        if (oVar.f1708b.compareTo(oVar3.f1708b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (oVar3.f1708b.compareTo(oVar2.f1708b) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.g = oVar.i(oVar2) + 1;
        this.f = (oVar2.e - oVar.e) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1682b.equals(aVar.f1682b) && this.f1683c.equals(aVar.f1683c) && this.d.equals(aVar.d) && this.e.equals(aVar.e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1682b, this.f1683c, this.d, this.e});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1682b, 0);
        parcel.writeParcelable(this.f1683c, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.e, 0);
    }
}
