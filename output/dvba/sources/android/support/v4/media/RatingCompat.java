package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f16c;

    public static class a implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public RatingCompat(int i, float f) {
        this.f15b = i;
        this.f16c = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f15b;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("Rating:style=");
        sbE.append(this.f15b);
        sbE.append(" rating=");
        float f = this.f16c;
        sbE.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15b);
        parcel.writeFloat(this.f16c);
    }
}
