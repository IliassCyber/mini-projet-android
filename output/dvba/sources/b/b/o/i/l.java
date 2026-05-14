package b.b.o.i;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import b.b.o.i.m;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f385c;
    public final int d;
    public final int e;
    public View f;
    public boolean h;
    public m.a i;
    public k j;
    public PopupWindow.OnDismissListener k;
    public int g = 8388611;
    public final PopupWindow.OnDismissListener l = new a();

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.c();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.f383a = context;
        this.f384b = gVar;
        this.f = view;
        this.f385c = z;
        this.d = i;
        this.e = i2;
    }

    public k a() {
        if (this.j == null) {
            Display defaultDisplay = ((WindowManager) this.f383a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            k dVar = Math.min(point.x, point.y) >= this.f383a.getResources().getDimensionPixelSize(b.b.d.abc_cascading_menus_min_smallest_width) ? new d(this.f383a, this.f, this.d, this.e, this.f385c) : new q(this.f383a, this.f384b, this.f, this.d, this.e, this.f385c);
            dVar.l(this.f384b);
            dVar.s(this.l);
            dVar.o(this.f);
            dVar.d(this.i);
            dVar.p(this.h);
            dVar.q(this.g);
            this.j = dVar;
        }
        return this.j;
    }

    public boolean b() {
        k kVar = this.j;
        return kVar != null && kVar.a();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a aVar) {
        this.i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.d(aVar);
        }
    }

    public final void e(int i, int i2, boolean z, boolean z2) {
        k kVarA = a();
        kVarA.t(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.g, b.i.m.l.r(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            kVarA.r(i);
            kVarA.u(i2);
            int i3 = (int) ((this.f383a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            kVarA.f382b = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        kVarA.i();
    }

    public boolean f() {
        if (b()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
