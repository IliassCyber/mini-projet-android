package c.c.a.b.u;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class h extends b.i.m.a {
    public final /* synthetic */ f d;

    public h(f fVar) {
        this.d = fVar;
    }

    @Override // b.i.m.a
    public void d(View view, b.i.m.v.b bVar) {
        f fVar;
        int i;
        this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
        if (this.d.g0.getVisibility() == 0) {
            fVar = this.d;
            i = c.c.a.b.i.mtrl_picker_toggle_to_year_selection;
        } else {
            fVar = this.d;
            i = c.c.a.b.i.mtrl_picker_toggle_to_day_selection;
        }
        bVar.k(fVar.t(i));
    }
}
