package b.b.o.i;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.b.o.i.m;
import b.b.p.f0;
import b.b.p.m0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = b.b.g.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f387c;
    public final g d;
    public final f e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final m0 j;
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public m.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean v;
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public int u = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (q.this.a()) {
                q qVar = q.this;
                if (qVar.j.B) {
                    return;
                }
                View view = qVar.o;
                if (view == null || !view.isShown()) {
                    q.this.dismiss();
                } else {
                    q.this.j.i();
                }
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
            ViewTreeObserver viewTreeObserver = q.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.q = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.q.removeGlobalOnLayoutListener(qVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.f387c = context;
        this.d = gVar;
        this.f = z;
        this.e = new f(gVar, LayoutInflater.from(context), this.f, w);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.b.d.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new m0(this.f387c, null, this.h, this.i);
        gVar.b(this, context);
    }

    @Override // b.b.o.i.p
    public boolean a() {
        return !this.r && this.j.a();
    }

    @Override // b.b.o.i.m
    public void b(g gVar, boolean z) {
        if (gVar != this.d) {
            return;
        }
        dismiss();
        m.a aVar = this.p;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // b.b.o.i.m
    public void d(m.a aVar) {
        this.p = aVar;
    }

    @Override // b.b.o.i.p
    public void dismiss() {
        if (a()) {
            this.j.dismiss();
        }
    }

    @Override // b.b.o.i.p
    public ListView e() {
        return this.j.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // b.b.o.i.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(b.b.o.i.r r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L76
            b.b.o.i.l r0 = new b.b.o.i.l
            android.content.Context r3 = r9.f387c
            android.view.View r5 = r9.o
            boolean r6 = r9.f
            int r7 = r9.h
            int r8 = r9.i
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            b.b.o.i.m$a r2 = r9.p
            r0.d(r2)
            boolean r2 = b.b.o.i.k.v(r10)
            r0.h = r2
            b.b.o.i.k r3 = r0.j
            if (r3 == 0) goto L2a
            r3.p(r2)
        L2a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.m
            r0.k = r2
            r2 = 0
            r9.m = r2
            b.b.o.i.g r2 = r9.d
            r2.c(r1)
            b.b.p.m0 r2 = r9.j
            int r3 = r2.g
            boolean r4 = r2.j
            if (r4 != 0) goto L40
            r2 = 0
            goto L42
        L40:
            int r2 = r2.h
        L42:
            int r4 = r9.u
            android.view.View r5 = r9.n
            int r5 = b.i.m.l.r(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L5a
            android.view.View r4 = r9.n
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L5a:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L62
            goto L6b
        L62:
            android.view.View r4 = r0.f
            if (r4 != 0) goto L68
            r0 = 0
            goto L6c
        L68:
            r0.e(r3, r2, r5, r5)
        L6b:
            r0 = 1
        L6c:
            if (r0 == 0) goto L76
            b.b.o.i.m$a r0 = r9.p
            if (r0 == 0) goto L75
            r0.c(r10)
        L75:
            return r5
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.o.i.q.f(b.b.o.i.r):boolean");
    }

    @Override // b.b.o.i.m
    public boolean g() {
        return false;
    }

    @Override // b.b.o.i.m
    public void h(boolean z) {
        this.s = false;
        f fVar = this.e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // b.b.o.i.p
    public void i() {
        View view;
        boolean z = false;
        if (a()) {
            z = true;
        } else if (!this.r && (view = this.n) != null) {
            this.o = view;
            this.j.C.setOnDismissListener(this);
            m0 m0Var = this.j;
            m0Var.t = this;
            m0Var.s(true);
            View view2 = this.o;
            boolean z2 = this.q == null;
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            this.q = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.k);
            }
            view2.addOnAttachStateChangeListener(this.l);
            m0 m0Var2 = this.j;
            m0Var2.s = view2;
            m0Var2.m = this.u;
            if (!this.s) {
                this.t = k.n(this.e, null, this.f387c, this.g);
                this.s = true;
            }
            this.j.r(this.t);
            this.j.C.setInputMethodMode(2);
            m0 m0Var3 = this.j;
            Rect rect = this.f382b;
            if (m0Var3 == null) {
                throw null;
            }
            m0Var3.A = rect != null ? new Rect(rect) : null;
            this.j.i();
            f0 f0Var = this.j.d;
            f0Var.setOnKeyListener(this);
            if (this.v && this.d.m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f387c).inflate(b.b.g.abc_popup_menu_header_item_layout, (ViewGroup) f0Var, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(this.d.m);
                }
                frameLayout.setEnabled(false);
                f0Var.addHeaderView(frameLayout, null, false);
            }
            this.j.o(this.e);
            this.j.i();
            z = true;
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // b.b.o.i.k
    public void l(g gVar) {
    }

    @Override // b.b.o.i.k
    public void o(View view) {
        this.n = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.e.d = z;
    }

    @Override // b.b.o.i.k
    public void q(int i) {
        this.u = i;
    }

    @Override // b.b.o.i.k
    public void r(int i) {
        this.j.g = i;
    }

    @Override // b.b.o.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // b.b.o.i.k
    public void t(boolean z) {
        this.v = z;
    }

    @Override // b.b.o.i.k
    public void u(int i) {
        m0 m0Var = this.j;
        m0Var.h = i;
        m0Var.j = true;
    }
}
