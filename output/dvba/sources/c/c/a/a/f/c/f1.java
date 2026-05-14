package c.c.a.a.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f1 extends c.c.a.a.c.l.u.a {
    public static final Parcelable.Creator<f1> CREATOR = new h1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d1> f1445b;

    public f1() {
        this.f1445b = new ArrayList();
    }

    public f1(List<d1> list) {
        this.f1445b = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = c.c.a.a.c.l.q.a(parcel);
        c.c.a.a.c.l.q.k0(parcel, 2, this.f1445b, false);
        c.c.a.a.c.l.q.C0(parcel, iA);
    }
}
