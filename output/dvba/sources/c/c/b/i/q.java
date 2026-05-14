package c.c.b.i;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q extends r {
    /* JADX WARN: Illegal instructions before constructor call */
    public q(List<d<?>> list) {
        StringBuilder sbE = c.a.a.a.a.e("Dependency cycle detected: ");
        sbE.append(Arrays.toString(list.toArray()));
        super(sbE.toString());
    }
}
