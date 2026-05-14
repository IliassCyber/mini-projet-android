package b.l.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f950c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Fragment e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ Object i;

    public t(Object obj, b0 b0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f949b = obj;
        this.f950c = b0Var;
        this.d = view;
        this.e = fragment;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = arrayList3;
        this.i = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f949b;
        if (obj != null) {
            this.f950c.n(obj, this.d);
            this.g.addAll(w.h(this.f950c, this.f949b, this.e, this.f, this.d));
        }
        if (this.h != null) {
            if (this.i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.d);
                this.f950c.o(this.i, this.h, arrayList);
            }
            this.h.clear();
            this.h.add(this.d);
        }
    }
}
