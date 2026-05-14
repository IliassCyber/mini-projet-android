package b.l.a;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class z implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f971c;

    public z(b0 b0Var, ArrayList arrayList, Map map) {
        this.f970b = arrayList;
        this.f971c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int size = this.f970b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f970b.get(i);
            String strX = b.i.m.l.x(view);
            if (strX != null) {
                Iterator it = this.f971c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (strX.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
