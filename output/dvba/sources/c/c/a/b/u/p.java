package c.c.a.b.u;

import android.widget.BaseAdapter;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class p extends BaseAdapter {
    public static final int f = c.c.a.a.c.l.q.F().getMaximum(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<?> f1711c;
    public c d;
    public final a e;

    public p(o oVar, d<?> dVar, a aVar) {
        this.f1710b = oVar;
        this.f1711c = dVar;
        this.e = aVar;
    }

    public int a() {
        return this.f1710b.f();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.f1710b.f() || i > c()) {
            return null;
        }
        o oVar = this.f1710b;
        int iF = (i - oVar.f()) + 1;
        Calendar calendarB = c.c.a.a.c.l.q.B(oVar.f1708b);
        calendarB.set(5, iF);
        return Long.valueOf(calendarB.getTimeInMillis());
    }

    public int c() {
        return (this.f1710b.f() + this.f1710b.g) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return a() + this.f1710b.g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f1710b.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0103  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.u.p.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
