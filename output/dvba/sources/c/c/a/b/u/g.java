package c.c.a.b.u;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class g extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f1697a = c.c.a.a.c.l.q.F();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f1698b = c.c.a.a.c.l.q.F();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1699c;

    public g(f fVar) {
        this.f1699c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if ((recyclerView.getAdapter() instanceof w) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            w wVar = (w) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (b.i.l.b<Long, Long> bVar : this.f1699c.Y.d()) {
                Long l = bVar.f814a;
                if (l != null && bVar.f815b != null) {
                    this.f1697a.setTimeInMillis(l.longValue());
                    this.f1698b.setTimeInMillis(bVar.f815b.longValue());
                    int iE = wVar.e(this.f1697a.get(1));
                    int iE2 = wVar.e(this.f1698b.get(1));
                    View viewT = gridLayoutManager.t(iE);
                    View viewT2 = gridLayoutManager.t(iE2);
                    int i = gridLayoutManager.I;
                    int i2 = iE / i;
                    int i3 = iE2 / i;
                    for (int i4 = i2; i4 <= i3; i4++) {
                        View viewT3 = gridLayoutManager.t(gridLayoutManager.I * i4);
                        if (viewT3 != null) {
                            int top = viewT3.getTop() + this.f1699c.c0.d.f1684a.top;
                            int bottom = viewT3.getBottom() - this.f1699c.c0.d.f1684a.bottom;
                            canvas.drawRect(i4 == i2 ? (viewT.getWidth() / 2) + viewT.getLeft() : 0, top, i4 == i3 ? (viewT2.getWidth() / 2) + viewT2.getLeft() : recyclerView.getWidth(), bottom, this.f1699c.c0.h);
                        }
                    }
                }
            }
        }
    }
}
