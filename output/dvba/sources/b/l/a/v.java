package b.l.a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.l.a.w;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b.f.a f954c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ w.a e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Fragment h;
    public final /* synthetic */ Fragment i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Rect m;

    public v(b0 b0Var, b.f.a aVar, Object obj, w.a aVar2, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f953b = b0Var;
        this.f954c = aVar;
        this.d = obj;
        this.e = aVar2;
        this.f = arrayList;
        this.g = view;
        this.h = fragment;
        this.i = fragment2;
        this.j = z;
        this.k = arrayList2;
        this.l = obj2;
        this.m = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.f.a<String, View> aVarE = w.e(this.f953b, this.f954c, this.d, this.e);
        if (aVarE != null) {
            this.f.addAll(aVarE.values());
            this.f.add(this.g);
        }
        w.c(this.h, this.i, this.j, aVarE, false);
        Object obj = this.d;
        if (obj != null) {
            this.f953b.u(obj, this.k, this.f);
            View viewK = w.k(aVarE, this.e, this.l, this.j);
            if (viewK != null) {
                this.f953b.j(viewK, this.m);
            }
        }
    }
}
