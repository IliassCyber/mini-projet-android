package a.a.a.b;

import a.a.a.b.a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a.a.a.b.a f5c;

    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    /* JADX INFO: renamed from: a.a.a.b.b$b, reason: collision with other inner class name */
    public class BinderC0002b extends a.AbstractBinderC0000a {
        public BinderC0002b() {
        }

        @Override // a.a.a.b.a
        public void z(int i, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f4b;
            if (handler != null) {
                handler.post(bVar.new c(i, bundle));
            } else {
                bVar.c(i, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f8c;

        public c(int i, Bundle bundle) {
            this.f7b = i;
            this.f8c = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c(this.f7b, this.f8c);
        }
    }

    public b(Parcel parcel) {
        this.f5c = a.AbstractBinderC0000a.c(parcel.readStrongBinder());
    }

    public void c(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f5c == null) {
                this.f5c = new BinderC0002b();
            }
            parcel.writeStrongBinder(this.f5c.asBinder());
        }
    }
}
