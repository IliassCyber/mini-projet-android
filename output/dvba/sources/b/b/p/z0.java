package b.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.d;
import b.b.o.i.m;

/* JADX INFO: loaded from: classes.dex */
public class z0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f521c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public c n;
    public int o;
    public int p;
    public Drawable q;

    public class a extends b.i.m.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f522a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f523b;

        public a(int i) {
            this.f523b = i;
        }

        @Override // b.i.m.r
        public void a(View view) {
            if (this.f522a) {
                return;
            }
            z0.this.f519a.setVisibility(this.f523b);
        }

        @Override // b.i.m.s, b.i.m.r
        public void b(View view) {
            z0.this.f519a.setVisibility(0);
        }

        @Override // b.i.m.s, b.i.m.r
        public void c(View view) {
            this.f522a = true;
        }
    }

    public z0(Toolbar toolbar, boolean z) {
        int i;
        Drawable drawable;
        int i2 = b.b.h.abc_action_bar_up_description;
        this.o = 0;
        this.p = 0;
        this.f519a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        x0 x0VarQ = x0.q(toolbar.getContext(), null, b.b.j.ActionBar, b.b.a.actionBarStyle, 0);
        this.q = x0VarQ.g(b.b.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceN = x0VarQ.n(b.b.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceN)) {
                this.h = true;
                this.i = charSequenceN;
                if ((this.f520b & 8) != 0) {
                    this.f519a.setTitle(charSequenceN);
                }
            }
            CharSequence charSequenceN2 = x0VarQ.n(b.b.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceN2)) {
                this.j = charSequenceN2;
                if ((this.f520b & 8) != 0) {
                    this.f519a.setSubtitle(charSequenceN2);
                }
            }
            Drawable drawableG = x0VarQ.g(b.b.j.ActionBar_logo);
            if (drawableG != null) {
                this.f = drawableG;
                y();
            }
            Drawable drawableG2 = x0VarQ.g(b.b.j.ActionBar_icon);
            if (drawableG2 != null) {
                this.e = drawableG2;
                y();
            }
            if (this.g == null && (drawable = this.q) != null) {
                this.g = drawable;
                x();
            }
            u(x0VarQ.j(b.b.j.ActionBar_displayOptions, 0));
            int iL = x0VarQ.l(b.b.j.ActionBar_customNavigationLayout, 0);
            if (iL != 0) {
                View viewInflate = LayoutInflater.from(this.f519a.getContext()).inflate(iL, (ViewGroup) this.f519a, false);
                View view = this.d;
                if (view != null && (this.f520b & 16) != 0) {
                    this.f519a.removeView(view);
                }
                this.d = viewInflate;
                if (viewInflate != null && (this.f520b & 16) != 0) {
                    this.f519a.addView(viewInflate);
                }
                u(this.f520b | 16);
            }
            int iK = x0VarQ.k(b.b.j.ActionBar_height, 0);
            if (iK > 0) {
                ViewGroup.LayoutParams layoutParams = this.f519a.getLayoutParams();
                layoutParams.height = iK;
                this.f519a.setLayoutParams(layoutParams);
            }
            int iE = x0VarQ.e(b.b.j.ActionBar_contentInsetStart, -1);
            int iE2 = x0VarQ.e(b.b.j.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                Toolbar toolbar2 = this.f519a;
                int iMax = Math.max(iE, 0);
                int iMax2 = Math.max(iE2, 0);
                toolbar2.d();
                toolbar2.u.a(iMax, iMax2);
            }
            int iL2 = x0VarQ.l(b.b.j.ActionBar_titleTextStyle, 0);
            if (iL2 != 0) {
                Toolbar toolbar3 = this.f519a;
                Context context = toolbar3.getContext();
                toolbar3.m = iL2;
                TextView textView = toolbar3.f92c;
                if (textView != null) {
                    textView.setTextAppearance(context, iL2);
                }
            }
            int iL3 = x0VarQ.l(b.b.j.ActionBar_subtitleTextStyle, 0);
            if (iL3 != 0) {
                Toolbar toolbar4 = this.f519a;
                Context context2 = toolbar4.getContext();
                toolbar4.n = iL3;
                TextView textView2 = toolbar4.d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, iL3);
                }
            }
            int iL4 = x0VarQ.l(b.b.j.ActionBar_popupTheme, 0);
            if (iL4 != 0) {
                this.f519a.setPopupTheme(iL4);
            }
        } else {
            if (this.f519a.getNavigationIcon() != null) {
                i = 15;
                this.q = this.f519a.getNavigationIcon();
            } else {
                i = 11;
            }
            this.f520b = i;
        }
        x0VarQ.f507b.recycle();
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f519a.getNavigationContentDescription())) {
                int i3 = this.p;
                this.k = i3 != 0 ? t().getString(i3) : null;
                w();
            }
        }
        this.k = this.f519a.getNavigationContentDescription();
        this.f519a.setNavigationOnClickListener(new y0(this));
    }

    @Override // b.b.p.d0
    public boolean a() {
        return this.f519a.u();
    }

    @Override // b.b.p.d0
    public void b(Menu menu, m.a aVar) {
        b.b.o.i.i iVar;
        if (this.n == null) {
            c cVar = new c(this.f519a.getContext());
            this.n = cVar;
            if (cVar == null) {
                throw null;
            }
        }
        c cVar2 = this.n;
        cVar2.f = aVar;
        Toolbar toolbar = this.f519a;
        b.b.o.i.g gVar = (b.b.o.i.g) menu;
        if (gVar == null && toolbar.f91b == null) {
            return;
        }
        toolbar.f();
        b.b.o.i.g gVar2 = toolbar.f91b.q;
        if (gVar2 == gVar) {
            return;
        }
        if (gVar2 != null) {
            gVar2.u(toolbar.K);
            gVar2.u(toolbar.L);
        }
        if (toolbar.L == null) {
            toolbar.L = toolbar.new d();
        }
        cVar2.r = true;
        if (gVar != null) {
            gVar.b(cVar2, toolbar.k);
            gVar.b(toolbar.L, toolbar.k);
        } else {
            cVar2.j(toolbar.k, null);
            Toolbar.d dVar = toolbar.L;
            b.b.o.i.g gVar3 = dVar.f96b;
            if (gVar3 != null && (iVar = dVar.f97c) != null) {
                gVar3.d(iVar);
            }
            dVar.f96b = null;
            cVar2.h(true);
            toolbar.L.h(true);
        }
        toolbar.f91b.setPopupTheme(toolbar.l);
        toolbar.f91b.setPresenter(cVar2);
        toolbar.K = cVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001e  */
    @Override // b.b.p.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c() {
        /*
            r4 = this;
            androidx.appcompat.widget.Toolbar r0 = r4.f519a
            androidx.appcompat.widget.ActionMenuView r0 = r0.f91b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L22
            b.b.p.c r0 = r0.u
            if (r0 == 0) goto L1e
            b.b.p.c$c r3 = r0.w
            if (r3 != 0) goto L19
            boolean r0 = r0.m()
            if (r0 == 0) goto L17
            goto L19
        L17:
            r0 = 0
            goto L1a
        L19:
            r0 = 1
        L1a:
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == 0) goto L22
            r1 = 1
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.p.z0.c():boolean");
    }

    @Override // b.b.p.d0
    public void collapseActionView() {
        Toolbar.d dVar = this.f519a.L;
        b.b.o.i.i iVar = dVar == null ? null : dVar.f97c;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    @Override // b.b.p.d0
    public void d() {
        this.m = true;
    }

    @Override // b.b.p.d0
    public boolean e() {
        return this.f519a.o();
    }

    @Override // b.b.p.d0
    public boolean f() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f519a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f91b) != null && actionMenuView.t;
    }

    @Override // b.b.p.d0
    public boolean g() {
        ActionMenuView actionMenuView = this.f519a.f91b;
        if (actionMenuView == null) {
            return false;
        }
        c cVar = actionMenuView.u;
        return cVar != null && cVar.i();
    }

    @Override // b.b.p.d0
    public CharSequence getTitle() {
        return this.f519a.getTitle();
    }

    @Override // b.b.p.d0
    public void h() {
        c cVar;
        ActionMenuView actionMenuView = this.f519a.f91b;
        if (actionMenuView == null || (cVar = actionMenuView.u) == null) {
            return;
        }
        cVar.e();
    }

    @Override // b.b.p.d0
    public b.i.m.q i(int i, long j) {
        b.i.m.q qVarA = b.i.m.l.a(this.f519a);
        qVarA.a(i == 0 ? 1.0f : 0.0f);
        qVarA.c(j);
        a aVar = new a(i);
        View view = qVarA.f846a.get();
        if (view != null) {
            qVarA.e(view, aVar);
        }
        return qVarA;
    }

    @Override // b.b.p.d0
    public int j() {
        return this.f520b;
    }

    @Override // b.b.p.d0
    public void k(int i) {
        this.f519a.setVisibility(i);
    }

    @Override // b.b.p.d0
    public void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // b.b.p.d0
    public boolean m() {
        Toolbar.d dVar = this.f519a.L;
        return (dVar == null || dVar.f97c == null) ? false : true;
    }

    @Override // b.b.p.d0
    public void n(int i) {
        this.f = i != 0 ? b.b.l.a.a.b(t(), i) : null;
        y();
    }

    @Override // b.b.p.d0
    public void o(q0 q0Var) {
        View view = this.f521c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f519a;
            if (parent == toolbar) {
                toolbar.removeView(this.f521c);
            }
        }
        this.f521c = null;
    }

    @Override // b.b.p.d0
    public ViewGroup p() {
        return this.f519a;
    }

    @Override // b.b.p.d0
    public void q(boolean z) {
    }

    @Override // b.b.p.d0
    public void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // b.b.p.d0
    public void s(boolean z) {
        this.f519a.setCollapsible(z);
    }

    @Override // b.b.p.d0
    public void setIcon(int i) {
        this.e = i != 0 ? b.b.l.a.a.b(t(), i) : null;
        y();
    }

    @Override // b.b.p.d0
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        y();
    }

    @Override // b.b.p.d0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // b.b.p.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        this.i = charSequence;
        if ((this.f520b & 8) != 0) {
            this.f519a.setTitle(charSequence);
        }
    }

    @Override // b.b.p.d0
    public Context t() {
        return this.f519a.getContext();
    }

    @Override // b.b.p.d0
    public void u(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f520b ^ i;
        this.f520b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    w();
                }
                x();
            }
            if ((i2 & 3) != 0) {
                y();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f519a.setTitle(this.i);
                    toolbar = this.f519a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.f519a.setTitle((CharSequence) null);
                    toolbar = this.f519a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f519a.addView(view);
            } else {
                this.f519a.removeView(view);
            }
        }
    }

    @Override // b.b.p.d0
    public int v() {
        return this.o;
    }

    public final void w() {
        if ((this.f520b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f519a.setNavigationContentDescription(this.p);
            } else {
                this.f519a.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void x() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f520b & 4) != 0) {
            toolbar = this.f519a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.f519a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void y() {
        Drawable drawable;
        int i = this.f520b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.f519a.setLogo(drawable);
    }
}
