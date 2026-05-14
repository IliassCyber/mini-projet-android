package androidx.fragment.app;

import android.animation.Animator;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import b.l.a.c0;
import b.l.a.e;
import b.l.a.i;
import b.l.a.j;
import b.l.a.k;
import b.l.a.p;
import b.n.d;
import b.n.g;
import b.n.h;
import b.n.l;
import b.n.s;
import b.n.t;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, g, t, b.s.c {
    public static final Object V = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean E;
    public ViewGroup F;
    public View G;
    public View H;
    public boolean I;
    public b K;
    public boolean L;
    public boolean M;
    public float N;
    public LayoutInflater O;
    public boolean P;
    public h R;
    public c0 S;
    public b.s.b U;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f142c;
    public SparseArray<Parcelable> d;
    public Boolean e;
    public Bundle g;
    public Fragment h;
    public int j;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public k s;
    public i t;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f141b = 0;
    public String f = UUID.randomUUID().toString();
    public String i = null;
    public Boolean k = null;
    public k u = new k();
    public boolean D = true;
    public boolean J = true;
    public d.b Q = d.b.RESUMED;
    public l<g> T = new l<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Animator f146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f147c;
        public int d;
        public int e;
        public int f;
        public Object g = null;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public Boolean m;
        public Boolean n;
        public b.i.d.l o;
        public b.i.d.l p;
        public boolean q;
        public d r;
        public boolean s;

        public b() {
            Object obj = Fragment.V;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    public static class c extends RuntimeException {
        public c(String str, Exception exc) {
            super(str, exc);
        }
    }

    public interface d {
    }

    public Fragment() {
        u();
    }

    @Deprecated
    public static Fragment v(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = b.l.a.h.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.T(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e) {
            throw new c("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new c("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new c("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new c("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public void A(Bundle bundle) {
        Parcelable parcelable;
        this.E = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.u.j0(parcelable);
            this.u.o();
        }
        if (this.u.p >= 1) {
            return;
        }
        this.u.o();
    }

    public View B(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void C() {
        this.E = true;
    }

    public void D() {
        this.E = true;
    }

    public LayoutInflater E(Bundle bundle) {
        i iVar = this.t;
        if (iVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        e.a aVar = (e.a) iVar;
        LayoutInflater layoutInflaterCloneInContext = e.this.getLayoutInflater().cloneInContext(e.this);
        k kVar = this.u;
        if (kVar == null) {
            throw null;
        }
        layoutInflaterCloneInContext.setFactory2(kVar);
        return layoutInflaterCloneInContext;
    }

    public void F(AttributeSet attributeSet, Bundle bundle) {
        this.E = true;
        i iVar = this.t;
        if ((iVar == null ? null : iVar.f907b) != null) {
            this.E = false;
            this.E = true;
        }
    }

    public void G() {
        this.E = true;
    }

    public void H() {
        this.E = true;
    }

    public void I(Bundle bundle) {
    }

    public void J() {
        this.E = true;
    }

    public void K() {
        this.E = true;
    }

    public boolean L(Menu menu, MenuInflater menuInflater) {
        if (this.z) {
            return false;
        }
        return false | this.u.p(menu, menuInflater);
    }

    public void M(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.e0();
        this.q = true;
        this.S = new c0();
        View viewB = B(layoutInflater, viewGroup, bundle);
        this.G = viewB;
        if (viewB == null) {
            if (this.S.f903b != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.S = null;
        } else {
            c0 c0Var = this.S;
            if (c0Var.f903b == null) {
                c0Var.f903b = new h(c0Var);
            }
            this.T.g(this.S);
        }
    }

    public void N() {
        this.E = true;
        this.u.r();
    }

    public boolean O(Menu menu) {
        if (this.z) {
            return false;
        }
        return false | this.u.L(menu);
    }

    public final j P() {
        k kVar = this.s;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException(c.a.a.a.a.b("Fragment ", this, " not associated with a fragment manager."));
    }

    public final View Q() {
        View view = this.G;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(c.a.a.a.a.b("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void R(View view) {
        c().f145a = view;
    }

    public void S(Animator animator) {
        c().f146b = animator;
    }

    public void T(Bundle bundle) {
        k kVar = this.s;
        if (kVar != null) {
            if (kVar == null ? false : kVar.c()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.g = bundle;
    }

    public void U(boolean z) {
        c().s = z;
    }

    public void V(int i) {
        if (this.K == null && i == 0) {
            return;
        }
        c().d = i;
    }

    public void W(d dVar) {
        c();
        d dVar2 = this.K.r;
        if (dVar == dVar2) {
            return;
        }
        if (dVar != null && dVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        b bVar = this.K;
        if (bVar.q) {
            bVar.r = dVar;
        }
        if (dVar != null) {
            ((k.j) dVar).f925c++;
        }
    }

    public void X(boolean z) {
        this.B = z;
        k kVar = this.s;
        if (kVar == null) {
            this.C = true;
        } else if (!z) {
            kVar.i0(this);
        } else {
            if (kVar.c()) {
                return;
            }
            kVar.F.f938b.add(this);
        }
    }

    public void Y() {
        k kVar = this.s;
        if (kVar == null || kVar.q == null) {
            c().q = false;
        } else if (Looper.myLooper() != this.s.q.d.getLooper()) {
            this.s.q.d.postAtFrontOfQueue(new a());
        } else {
            b();
        }
    }

    @Override // b.n.g
    public b.n.d a() {
        return this.R;
    }

    public void b() {
        b bVar = this.K;
        d dVar = null;
        if (bVar != null) {
            bVar.q = false;
            d dVar2 = bVar.r;
            bVar.r = null;
            dVar = dVar2;
        }
        if (dVar != null) {
            k.j jVar = (k.j) dVar;
            int i = jVar.f925c - 1;
            jVar.f925c = i;
            if (i != 0) {
                return;
            }
            jVar.f924b.r.n0();
        }
    }

    public final b c() {
        if (this.K == null) {
            this.K = new b();
        }
        return this.K;
    }

    @Override // b.s.c
    public final b.s.a e() {
        return this.U.f1094b;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // b.n.t
    public s f() {
        k kVar = this.s;
        if (kVar == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        p pVar = kVar.F;
        s sVar = pVar.d.get(this.f);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s();
        pVar.d.put(this.f, sVar2);
        return sVar2;
    }

    public final e g() {
        i iVar = this.t;
        if (iVar == null) {
            return null;
        }
        return (e) iVar.f907b;
    }

    public View h() {
        b bVar = this.K;
        if (bVar == null) {
            return null;
        }
        return bVar.f145a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public Animator i() {
        b bVar = this.K;
        if (bVar == null) {
            return null;
        }
        return bVar.f146b;
    }

    public final j j() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(c.a.a.a.a.b("Fragment ", this, " has not been attached yet."));
    }

    public Context k() {
        i iVar = this.t;
        if (iVar == null) {
            return null;
        }
        return iVar.f908c;
    }

    public Object l() {
        b bVar = this.K;
        if (bVar == null) {
            return null;
        }
        return bVar.g;
    }

    public Object m() {
        b bVar = this.K;
        if (bVar == null) {
            return null;
        }
        return bVar.i;
    }

    public int n() {
        b bVar = this.K;
        if (bVar == null) {
            return 0;
        }
        return bVar.d;
    }

    public int o() {
        b bVar = this.K;
        if (bVar == null) {
            return 0;
        }
        return bVar.e;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.E = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        e eVarG = g();
        if (eVarG == null) {
            throw new IllegalStateException(c.a.a.a.a.b("Fragment ", this, " not attached to an activity."));
        }
        eVarG.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.E = true;
    }

    public int p() {
        b bVar = this.K;
        if (bVar == null) {
            return 0;
        }
        return bVar.f;
    }

    public final Resources q() {
        Context contextK = k();
        if (contextK != null) {
            return contextK.getResources();
        }
        throw new IllegalStateException(c.a.a.a.a.b("Fragment ", this, " not attached to a context."));
    }

    public Object r() {
        b bVar = this.K;
        if (bVar == null) {
            return null;
        }
        return bVar.k;
    }

    public int s() {
        b bVar = this.K;
        if (bVar == null) {
            return 0;
        }
        return bVar.f147c;
    }

    public final String t(int i) {
        return q().getString(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a.a.a.a.a.d(this, sb);
        sb.append(" (");
        sb.append(this.f);
        sb.append(")");
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final void u() {
        this.R = new h(this);
        this.U = new b.s.b(this);
        this.R.a(new b.n.e() { // from class: androidx.fragment.app.Fragment.2
            @Override // b.n.e
            public void g(g gVar, d.a aVar) {
                View view;
                if (aVar != d.a.ON_STOP || (view = Fragment.this.G) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
    }

    public boolean w() {
        b bVar = this.K;
        if (bVar == null) {
            return false;
        }
        return bVar.s;
    }

    public final boolean x() {
        return this.r > 0;
    }

    public void y(Bundle bundle) {
        this.E = true;
    }

    public void z(Context context) {
        this.E = true;
        i iVar = this.t;
        if ((iVar == null ? null : iVar.f907b) != null) {
            this.E = false;
            this.E = true;
        }
    }
}
