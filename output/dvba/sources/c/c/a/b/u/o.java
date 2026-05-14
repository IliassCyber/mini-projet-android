package c.c.a.b.u;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Comparable<o>, Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f1708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1709c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public static class a implements Parcelable.Creator<o> {
        @Override // android.os.Parcelable.Creator
        public o createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            Calendar calendarF = c.c.a.a.c.l.q.F();
            calendarF.set(1, i);
            calendarF.set(2, i2);
            return new o(calendarF);
        }

        @Override // android.os.Parcelable.Creator
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    public o(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarB = c.c.a.a.c.l.q.B(calendar);
        this.f1708b = calendarB;
        this.d = calendarB.get(2);
        this.e = this.f1708b.get(1);
        this.f = this.f1708b.getMaximum(7);
        this.g = this.f1708b.getActualMaximum(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(c.c.a.a.c.l.q.D());
        this.f1709c = simpleDateFormat.format(this.f1708b.getTime());
        this.f1708b.getTimeInMillis();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        return this.f1708b.compareTo(oVar.f1708b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.d == oVar.d && this.e == oVar.e;
    }

    public int f() {
        int firstDayOfWeek = this.f1708b.get(7) - this.f1708b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f : firstDayOfWeek;
    }

    public o h(int i) {
        Calendar calendarB = c.c.a.a.c.l.q.B(this.f1708b);
        calendarB.add(2, i);
        return new o(calendarB);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public int i(o oVar) {
        if (!(this.f1708b instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (oVar.d - this.d) + ((oVar.e - this.e) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeInt(this.d);
    }
}
