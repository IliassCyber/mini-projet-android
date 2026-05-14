package b.l.a;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a0 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f899c;

    public a0(b0 b0Var, ArrayList arrayList, Map map) {
        this.f898b = arrayList;
        this.f899c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f898b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f898b.get(i);
            view.setTransitionName((String) this.f899c.get(b.i.m.l.x(view)));
        }
    }
}
