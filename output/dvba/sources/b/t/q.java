package b.t;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1148b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f1147a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<i> f1149c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public q(View view) {
        this.f1148b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f1148b == qVar.f1148b && this.f1147a.equals(qVar.f1147a);
    }

    public int hashCode() {
        return this.f1147a.hashCode() + (this.f1148b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("TransitionValues@");
        sbE.append(Integer.toHexString(hashCode()));
        sbE.append(":\n");
        String strC = c.a.a.a.a.c(sbE.toString() + "    view = " + this.f1148b + "\n", "    values:");
        for (String str : this.f1147a.keySet()) {
            strC = strC + "    " + str + ": " + this.f1147a.get(str) + "\n";
        }
        return strC;
    }
}
