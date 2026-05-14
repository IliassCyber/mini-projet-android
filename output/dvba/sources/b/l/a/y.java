package b.l.a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f969c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ ArrayList f;

    public y(b0 b0Var, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f968b = i;
        this.f969c = arrayList;
        this.d = arrayList2;
        this.e = arrayList3;
        this.f = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f968b; i++) {
            b.i.m.l.h0((View) this.f969c.get(i), (String) this.d.get(i));
            ((View) this.e.get(i)).setTransitionName((String) this.f.get(i));
        }
    }
}
