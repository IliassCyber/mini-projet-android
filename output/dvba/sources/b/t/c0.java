package b.t;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1116c;
    public final /* synthetic */ d0 d;

    public c0(d0 d0Var, ViewGroup viewGroup, View view, View view2) {
        this.d = d0Var;
        this.f1114a = viewGroup;
        this.f1115b = view;
        this.f1116c = view2;
    }

    @Override // b.t.i.d
    public void c(i iVar) {
        this.f1116c.setTag(f.save_overlay_view, null);
        this.f1114a.getOverlay().remove(this.f1115b);
        iVar.w(this);
    }

    @Override // b.t.l, b.t.i.d
    public void d(i iVar) {
        this.f1114a.getOverlay().remove(this.f1115b);
    }

    @Override // b.t.l, b.t.i.d
    public void e(i iVar) {
        if (this.f1115b.getParent() == null) {
            this.f1114a.getOverlay().add(this.f1115b);
        } else {
            this.d.d();
        }
    }
}
