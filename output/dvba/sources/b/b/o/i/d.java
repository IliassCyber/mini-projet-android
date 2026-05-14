package b.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import b.b.o.i.m;
import b.b.p.l0;
import b.b.p.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = b.b.g.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f351c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final Handler h;
    public View p;
    public View q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean x;
    public m.a y;
    public ViewTreeObserver z;
    public final List<g> i = new ArrayList();
    public final List<C0012d> j = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public final l0 m = new c();
    public int n = 0;
    public int o = 0;
    public boolean w = false;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.a() || d.this.j.size() <= 0 || d.this.j.get(0).f357a.B) {
                return;
            }
            View view = d.this.q;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0012d> it = d.this.j.iterator();
            while (it.hasNext()) {
                it.next().f357a.i();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements l0 {

        public class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0012d f355b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MenuItem f356c;
            public final /* synthetic */ g d;

            public a(C0012d c0012d, MenuItem menuItem, g gVar) {
                this.f355b = c0012d;
                this.f356c = menuItem;
                this.d = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0012d c0012d = this.f355b;
                if (c0012d != null) {
                    d.this.B = true;
                    c0012d.f358b.c(false);
                    d.this.B = false;
                }
                if (this.f356c.isEnabled() && this.f356c.hasSubMenu()) {
                    this.d.r(this.f356c, 4);
                }
            }
        }

        public c() {
        }

        @Override // b.b.p.l0
        public void g(g gVar, MenuItem menuItem) {
            d.this.h.removeCallbacksAndMessages(null);
            int size = d.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.j.get(i).f358b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.h.postAtTime(new a(i2 < d.this.j.size() ? d.this.j.get(i2) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // b.b.p.l0
        public void k(g gVar, MenuItem menuItem) {
            d.this.h.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: renamed from: b.b.o.i.d$d, reason: collision with other inner class name */
    public static class C0012d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0 f357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f359c;

        public C0012d(m0 m0Var, g gVar, int i) {
            this.f357a = m0Var;
            this.f358b = gVar;
            this.f359c = i;
        }
    }

    public d(Context context, View view, int i, int i2, boolean z) {
        this.f351c = context;
        this.p = view;
        this.e = i;
        this.f = i2;
        this.g = z;
        this.r = b.i.m.l.r(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.b.d.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    @Override // b.b.o.i.p
    public boolean a() {
        return this.j.size() > 0 && this.j.get(0).f357a.a();
    }

    @Override // b.b.o.i.m
    public void b(g gVar, boolean z) {
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (gVar == this.j.get(i).f358b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < this.j.size()) {
            this.j.get(i2).f358b.c(false);
        }
        C0012d c0012dRemove = this.j.remove(i);
        c0012dRemove.f358b.u(this);
        if (this.B) {
            m0 m0Var = c0012dRemove.f357a;
            if (m0Var == null) {
                throw null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                m0Var.C.setExitTransition(null);
            }
            c0012dRemove.f357a.C.setAnimationStyle(0);
        }
        c0012dRemove.f357a.dismiss();
        int size2 = this.j.size();
        this.r = size2 > 0 ? this.j.get(size2 - 1).f359c : b.i.m.l.r(this.p) == 1 ? 0 : 1;
        if (size2 != 0) {
            if (z) {
                this.j.get(0).f358b.c(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.k);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.l);
        this.A.onDismiss();
    }

    @Override // b.b.o.i.m
    public void d(m.a aVar) {
        this.y = aVar;
    }

    @Override // b.b.o.i.p
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            C0012d[] c0012dArr = (C0012d[]) this.j.toArray(new C0012d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0012d c0012d = c0012dArr[i];
                if (c0012d.f357a.a()) {
                    c0012d.f357a.dismiss();
                }
            }
        }
    }

    @Override // b.b.o.i.p
    public ListView e() {
        if (this.j.isEmpty()) {
            return null;
        }
        return this.j.get(r0.size() - 1).f357a.d;
    }

    @Override // b.b.o.i.m
    public boolean f(r rVar) {
        for (C0012d c0012d : this.j) {
            if (rVar == c0012d.f358b) {
                c0012d.f357a.d.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        rVar.b(this, this.f351c);
        if (a()) {
            w(rVar);
        } else {
            this.i.add(rVar);
        }
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // b.b.o.i.m
    public boolean g() {
        return false;
    }

    @Override // b.b.o.i.m
    public void h(boolean z) {
        Iterator<C0012d> it = this.j.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = it.next().f357a.d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    @Override // b.b.o.i.p
    public void i() {
        if (a()) {
            return;
        }
        Iterator<g> it = this.i.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
        this.i.clear();
        View view = this.p;
        this.q = view;
        if (view != null) {
            boolean z = this.z == null;
            ViewTreeObserver viewTreeObserver = this.q.getViewTreeObserver();
            this.z = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.k);
            }
            this.q.addOnAttachStateChangeListener(this.l);
        }
    }

    @Override // b.b.o.i.k
    public void l(g gVar) {
        gVar.b(this, this.f351c);
        if (a()) {
            w(gVar);
        } else {
            this.i.add(gVar);
        }
    }

    @Override // b.b.o.i.k
    public boolean m() {
        return false;
    }

    @Override // b.b.o.i.k
    public void o(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = Gravity.getAbsoluteGravity(this.n, b.i.m.l.r(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0012d c0012d;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0012d = null;
                break;
            }
            c0012d = this.j.get(i);
            if (!c0012d.f357a.a()) {
                break;
            } else {
                i++;
            }
        }
        if (c0012d != null) {
            c0012d.f358b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // b.b.o.i.k
    public void p(boolean z) {
        this.w = z;
    }

    @Override // b.b.o.i.k
    public void q(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = Gravity.getAbsoluteGravity(i, b.i.m.l.r(this.p));
        }
    }

    @Override // b.b.o.i.k
    public void r(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // b.b.o.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // b.b.o.i.k
    public void t(boolean z) {
        this.x = z;
    }

    @Override // b.b.o.i.k
    public void u(int i) {
        this.t = true;
        this.v = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(b.b.o.i.g r17) {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.o.i.d.w(b.b.o.i.g):void");
    }
}
