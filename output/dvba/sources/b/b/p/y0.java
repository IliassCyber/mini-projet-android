package b.b.p;

import android.R;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public class y0 implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.b.o.i.a f515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f516c;

    public y0(z0 z0Var) {
        this.f516c = z0Var;
        this.f515b = new b.b.o.i.a(this.f516c.f519a.getContext(), 0, R.id.home, 0, this.f516c.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z0 z0Var = this.f516c;
        Window.Callback callback = z0Var.l;
        if (callback == null || !z0Var.m) {
            return;
        }
        callback.onMenuItemSelected(0, this.f515b);
    }
}
