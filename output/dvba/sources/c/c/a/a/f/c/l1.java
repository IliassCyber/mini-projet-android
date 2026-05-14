package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<l1> CREATOR = new k1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f1460c;

    public l1() {
        this(null);
    }

    public l1(int i, List<String> list) {
        List<String> listEmptyList;
        this.f1459b = i;
        if (list == null || list.isEmpty()) {
            listEmptyList = Collections.emptyList();
        } else {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, c.c.a.a.c.o.d.a(list.get(i2)));
            }
            listEmptyList = Collections.unmodifiableList(list);
        }
        this.f1460c = listEmptyList;
    }

    public l1(List<String> list) {
        this.f1459b = 1;
        this.f1460c = new ArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f1460c.addAll(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.d0(parcel, 1, this.f1459b);
        c.c.a.a.c.l.q.i0(parcel, 2, this.f1460c, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
