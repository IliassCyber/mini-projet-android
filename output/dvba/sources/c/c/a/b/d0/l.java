package c.c.a.b.d0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import c.c.a.b.d0.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends m.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f1572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Matrix f1573c;

    public l(m mVar, List list, Matrix matrix) {
        this.f1572b = list;
        this.f1573c = matrix;
    }

    @Override // c.c.a.b.d0.m.f
    public void a(Matrix matrix, c.c.a.b.c0.a aVar, int i, Canvas canvas) {
        Iterator it = this.f1572b.iterator();
        while (it.hasNext()) {
            ((m.f) it.next()).a(this.f1573c, aVar, i, canvas);
        }
    }
}
