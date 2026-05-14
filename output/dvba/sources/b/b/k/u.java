package b.b.k;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import b.b.k.a;
import b.b.o.a;
import b.b.o.i.g;
import b.b.p.d0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class u extends b.b.k.a implements ActionBarOverlayLayout.d {
    public static final Interpolator A = new AccelerateInterpolator();
    public static final Interpolator B = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f293c;
    public ActionBarContainer d;
    public d0 e;
    public ActionBarContextView f;
    public View g;
    public boolean h;
    public d i;
    public b.b.o.a j;
    public a.InterfaceC0011a k;
    public boolean l;
    public ArrayList<a.b> m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public b.b.o.g u;
    public boolean v;
    public boolean w;
    public final b.i.m.r x;
    public final b.i.m.r y;
    public final b.i.m.t z;

    public class a extends b.i.m.s {
        public a() {
        }

        @Override // b.i.m.r
        public void a(View view) {
            View view2;
            u uVar = u.this;
            if (uVar.p && (view2 = uVar.g) != null) {
                view2.setTranslationY(0.0f);
                u.this.d.setTranslationY(0.0f);
            }
            u.this.d.setVisibility(8);
            u.this.d.setTransitioning(false);
            u uVar2 = u.this;
            uVar2.u = null;
            a.InterfaceC0011a interfaceC0011a = uVar2.k;
            if (interfaceC0011a != null) {
                interfaceC0011a.b(uVar2.j);
                uVar2.j = null;
                uVar2.k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = u.this.f293c;
            if (actionBarOverlayLayout != null) {
                b.i.m.l.U(actionBarOverlayLayout);
            }
        }
    }

    public class b extends b.i.m.s {
        public b() {
        }

        @Override // b.i.m.r
        public void a(View view) {
            u uVar = u.this;
            uVar.u = null;
            uVar.d.requestLayout();
        }
    }

    public class c implements b.i.m.t {
        public c() {
        }
    }

    public class d extends b.b.o.a implements g.a {
        public final Context d;
        public final b.b.o.i.g e;
        public a.InterfaceC0011a f;
        public WeakReference<View> g;

        public d(Context context, a.InterfaceC0011a interfaceC0011a) {
            this.d = context;
            this.f = interfaceC0011a;
            b.b.o.i.g gVar = new b.b.o.i.g(context);
            gVar.l = 1;
            this.e = gVar;
            gVar.e = this;
        }

        @Override // b.b.o.i.g.a
        public void a(b.b.o.i.g gVar) {
            if (this.f == null) {
                return;
            }
            i();
            b.b.p.c cVar = u.this.f.e;
            if (cVar != null) {
                cVar.n();
            }
        }

        @Override // b.b.o.i.g.a
        public boolean b(b.b.o.i.g gVar, MenuItem menuItem) {
            a.InterfaceC0011a interfaceC0011a = this.f;
            if (interfaceC0011a != null) {
                return interfaceC0011a.c(this, menuItem);
            }
            return false;
        }

        @Override // b.b.o.a
        public void c() {
            u uVar = u.this;
            if (uVar.i != this) {
                return;
            }
            if ((uVar.q || uVar.r) ? false : true) {
                this.f.b(this);
            } else {
                u uVar2 = u.this;
                uVar2.j = this;
                uVar2.k = this.f;
            }
            this.f = null;
            u.this.k(false);
            ActionBarContextView actionBarContextView = u.this.f;
            if (actionBarContextView.l == null) {
                actionBarContextView.h();
            }
            u.this.e.p().sendAccessibilityEvent(32);
            u uVar3 = u.this;
            uVar3.f293c.setHideOnContentScrollEnabled(uVar3.w);
            u.this.i = null;
        }

        @Override // b.b.o.a
        public View d() {
            WeakReference<View> weakReference = this.g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // b.b.o.a
        public Menu e() {
            return this.e;
        }

        @Override // b.b.o.a
        public MenuInflater f() {
            return new b.b.o.f(this.d);
        }

        @Override // b.b.o.a
        public CharSequence g() {
            return u.this.f.getSubtitle();
        }

        @Override // b.b.o.a
        public CharSequence h() {
            return u.this.f.getTitle();
        }

        @Override // b.b.o.a
        public void i() {
            if (u.this.i != this) {
                return;
            }
            this.e.z();
            try {
                this.f.a(this, this.e);
            } finally {
                this.e.y();
            }
        }

        @Override // b.b.o.a
        public boolean j() {
            return u.this.f.s;
        }

        @Override // b.b.o.a
        public void k(View view) {
            u.this.f.setCustomView(view);
            this.g = new WeakReference<>(view);
        }

        @Override // b.b.o.a
        public void l(int i) {
            u.this.f.setSubtitle(u.this.f291a.getResources().getString(i));
        }

        @Override // b.b.o.a
        public void m(CharSequence charSequence) {
            u.this.f.setSubtitle(charSequence);
        }

        @Override // b.b.o.a
        public void n(int i) {
            u.this.f.setTitle(u.this.f291a.getResources().getString(i));
        }

        @Override // b.b.o.a
        public void o(CharSequence charSequence) {
            u.this.f.setTitle(charSequence);
        }

        @Override // b.b.o.a
        public void p(boolean z) {
            this.f318c = z;
            u.this.f.setTitleOptional(z);
        }
    }

    public u(Activity activity, boolean z) {
        new ArrayList();
        this.m = new ArrayList<>();
        this.o = 0;
        this.p = true;
        this.t = true;
        this.x = new a();
        this.y = new b();
        this.z = new c();
        View decorView = activity.getWindow().getDecorView();
        l(decorView);
        if (z) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    public u(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList<>();
        this.o = 0;
        this.p = true;
        this.t = true;
        this.x = new a();
        this.y = new b();
        this.z = new c();
        l(dialog.getWindow().getDecorView());
    }

    @Override // b.b.k.a
    public boolean a() {
        d0 d0Var = this.e;
        if (d0Var == null || !d0Var.m()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // b.b.k.a
    public void b(boolean z) {
        if (z == this.l) {
            return;
        }
        this.l = z;
        int size = this.m.size();
        for (int i = 0; i < size; i++) {
            this.m.get(i).a(z);
        }
    }

    @Override // b.b.k.a
    public int c() {
        return this.e.j();
    }

    @Override // b.b.k.a
    public Context d() {
        if (this.f292b == null) {
            TypedValue typedValue = new TypedValue();
            this.f291a.getTheme().resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f292b = new ContextThemeWrapper(this.f291a, i);
            } else {
                this.f292b = this.f291a;
            }
        }
        return this.f292b;
    }

    @Override // b.b.k.a
    public void e(Configuration configuration) {
        m(this.f291a.getResources().getBoolean(b.b.b.abc_action_bar_embed_tabs));
    }

    @Override // b.b.k.a
    public boolean f(int i, KeyEvent keyEvent) {
        b.b.o.i.g gVar;
        d dVar = this.i;
        if (dVar == null || (gVar = dVar.e) == null) {
            return false;
        }
        gVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return gVar.performShortcut(i, keyEvent, 0);
    }

    @Override // b.b.k.a
    public void g(boolean z) {
        if (this.h) {
            return;
        }
        int i = z ? 4 : 0;
        int iJ = this.e.j();
        this.h = true;
        this.e.u((i & 4) | (iJ & (-5)));
    }

    @Override // b.b.k.a
    public void h(boolean z) {
        b.b.o.g gVar;
        this.v = z;
        if (z || (gVar = this.u) == null) {
            return;
        }
        gVar.a();
    }

    @Override // b.b.k.a
    public void i(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // b.b.k.a
    public b.b.o.a j(a.InterfaceC0011a interfaceC0011a) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.c();
        }
        this.f293c.setHideOnContentScrollEnabled(false);
        this.f.h();
        d dVar2 = new d(this.f.getContext(), interfaceC0011a);
        dVar2.e.z();
        try {
            if (!dVar2.f.d(dVar2, dVar2.e)) {
                return null;
            }
            this.i = dVar2;
            dVar2.i();
            this.f.f(dVar2);
            k(true);
            this.f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.e.y();
        }
    }

    public void k(boolean z) {
        b.i.m.q qVarI;
        b.i.m.q qVarE;
        if (z) {
            if (!this.s) {
                this.s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f293c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                n(false);
            }
        } else if (this.s) {
            this.s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f293c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            n(false);
        }
        if (!b.i.m.l.E(this.d)) {
            if (z) {
                this.e.k(4);
                this.f.setVisibility(0);
                return;
            } else {
                this.e.k(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z) {
            qVarE = this.e.i(4, 100L);
            qVarI = this.f.e(0, 200L);
        } else {
            qVarI = this.e.i(0, 200L);
            qVarE = this.f.e(8, 100L);
        }
        b.b.o.g gVar = new b.b.o.g();
        gVar.f336a.add(qVarE);
        View view = qVarE.f846a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = qVarI.f846a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        gVar.f336a.add(qVarI);
        gVar.b();
    }

    public final void l(View view) {
        d0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(b.b.f.decor_content_parent);
        this.f293c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(b.b.f.action_bar);
        if (callbackFindViewById instanceof d0) {
            wrapper = (d0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                StringBuilder sbE = c.a.a.a.a.e("Can't make a decor toolbar out of ");
                sbE.append(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null");
                throw new IllegalStateException(sbE.toString());
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.e = wrapper;
        this.f = (ActionBarContextView) view.findViewById(b.b.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(b.b.f.action_bar_container);
        this.d = actionBarContainer;
        d0 d0Var = this.e;
        if (d0Var == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(u.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f291a = d0Var.t();
        boolean z = (this.e.j() & 4) != 0;
        if (z) {
            this.h = true;
        }
        Context context = this.f291a;
        this.e.q((context.getApplicationInfo().targetSdkVersion < 14) || z);
        m(context.getResources().getBoolean(b.b.b.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f291a.obtainStyledAttributes(null, b.b.j.ActionBar, b.b.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(b.b.j.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f293c;
            if (!actionBarOverlayLayout2.i) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(b.b.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            b.i.m.l.b0(this.d, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m(boolean z) {
        this.n = z;
        if (z) {
            this.d.setTabContainer(null);
            this.e.o(null);
        } else {
            this.e.o(null);
            this.d.setTabContainer(null);
        }
        boolean z2 = this.e.v() == 2;
        this.e.s(!this.n && z2);
        this.f293c.setHasNonEmbeddedTabs(!this.n && z2);
    }

    public final void n(boolean z) {
        View view;
        View view2;
        View view3;
        if (!(this.s || !this.r)) {
            if (this.t) {
                this.t = false;
                b.b.o.g gVar = this.u;
                if (gVar != null) {
                    gVar.a();
                }
                if (this.o != 0 || (!this.v && !z)) {
                    this.x.a(null);
                    return;
                }
                this.d.setAlpha(1.0f);
                this.d.setTransitioning(true);
                b.b.o.g gVar2 = new b.b.o.g();
                float f = -this.d.getHeight();
                if (z) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f -= r9[1];
                }
                b.i.m.q qVarA = b.i.m.l.a(this.d);
                qVarA.g(f);
                qVarA.f(this.z);
                if (!gVar2.e) {
                    gVar2.f336a.add(qVarA);
                }
                if (this.p && (view = this.g) != null) {
                    b.i.m.q qVarA2 = b.i.m.l.a(view);
                    qVarA2.g(f);
                    if (!gVar2.e) {
                        gVar2.f336a.add(qVarA2);
                    }
                }
                Interpolator interpolator = A;
                if (!gVar2.e) {
                    gVar2.f338c = interpolator;
                }
                if (!gVar2.e) {
                    gVar2.f337b = 250L;
                }
                b.i.m.r rVar = this.x;
                if (!gVar2.e) {
                    gVar2.d = rVar;
                }
                this.u = gVar2;
                gVar2.b();
                return;
            }
            return;
        }
        if (this.t) {
            return;
        }
        this.t = true;
        b.b.o.g gVar3 = this.u;
        if (gVar3 != null) {
            gVar3.a();
        }
        this.d.setVisibility(0);
        if (this.o == 0 && (this.v || z)) {
            this.d.setTranslationY(0.0f);
            float f2 = -this.d.getHeight();
            if (z) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f2 -= r9[1];
            }
            this.d.setTranslationY(f2);
            b.b.o.g gVar4 = new b.b.o.g();
            b.i.m.q qVarA3 = b.i.m.l.a(this.d);
            qVarA3.g(0.0f);
            qVarA3.f(this.z);
            if (!gVar4.e) {
                gVar4.f336a.add(qVarA3);
            }
            if (this.p && (view3 = this.g) != null) {
                view3.setTranslationY(f2);
                b.i.m.q qVarA4 = b.i.m.l.a(this.g);
                qVarA4.g(0.0f);
                if (!gVar4.e) {
                    gVar4.f336a.add(qVarA4);
                }
            }
            Interpolator interpolator2 = B;
            if (!gVar4.e) {
                gVar4.f338c = interpolator2;
            }
            if (!gVar4.e) {
                gVar4.f337b = 250L;
            }
            b.i.m.r rVar2 = this.y;
            if (!gVar4.e) {
                gVar4.d = rVar2;
            }
            this.u = gVar4;
            gVar4.b();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.p && (view2 = this.g) != null) {
                view2.setTranslationY(0.0f);
            }
            this.y.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f293c;
        if (actionBarOverlayLayout != null) {
            b.i.m.l.U(actionBarOverlayLayout);
        }
    }
}
