package c.c.a.b.f0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.f.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends b.k.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0059a();
    public final h<String, Bundle> d;

    /* JADX INFO: renamed from: c.c.a.b.f0.a$a, reason: collision with other inner class name */
    public static class C0059a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }
    }

    public a(Parcel parcel, ClassLoader classLoader, C0059a c0059a) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.d = new h<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.d.put(strArr[i2], bundleArr[i2]);
        }
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("ExtendableSavedState{");
        sbE.append(Integer.toHexString(System.identityHashCode(this)));
        sbE.append(" states=");
        sbE.append(this.d);
        sbE.append("}");
        return sbE.toString();
    }

    @Override // b.k.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f890b, i);
        int i2 = this.d.d;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.d.h(i3);
            bundleArr[i3] = this.d.k(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
