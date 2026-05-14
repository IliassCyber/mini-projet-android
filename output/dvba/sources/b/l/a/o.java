package b.l.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<q> f936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<String> f937c;
    public b[] d;
    public String e;
    public int f;

    public static class a implements Parcelable.Creator<o> {
        @Override // android.os.Parcelable.Creator
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    public o() {
        this.e = null;
    }

    public o(Parcel parcel) {
        this.e = null;
        this.f936b = parcel.createTypedArrayList(q.CREATOR);
        this.f937c = parcel.createStringArrayList();
        this.d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.e = parcel.readString();
        this.f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f936b);
        parcel.writeStringList(this.f937c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
    }
}
