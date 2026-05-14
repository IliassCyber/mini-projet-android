package c.c.a.b.u;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class f<S> extends t<S> {
    public static final Object h0 = "MONTHS_VIEW_GROUP_TAG";
    public static final Object i0 = "NAVIGATION_PREV_TAG";
    public static final Object j0 = "NAVIGATION_NEXT_TAG";
    public static final Object k0 = "SELECTOR_TOGGLE_TAG";
    public int X;
    public c.c.a.b.u.d<S> Y;
    public c.c.a.b.u.a Z;
    public o a0;
    public e b0;
    public c.c.a.b.u.c c0;
    public RecyclerView d0;
    public RecyclerView e0;
    public View f0;
    public View g0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1692b;

        public a(int i) {
            this.f1692b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.e0.smoothScrollToPosition(this.f1692b);
        }
    }

    public class b extends b.i.m.a {
        public b(f fVar) {
        }

        @Override // b.i.m.a
        public void d(View view, b.i.m.v.b bVar) {
            this.f820a.onInitializeAccessibilityNodeInfo(view, bVar.f864a);
            bVar.i(null);
        }
    }

    public class c extends u {
        public final /* synthetic */ int H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.H = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void X0(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.H == 0) {
                iArr[0] = f.this.e0.getWidth();
                iArr[1] = f.this.e0.getWidth();
            } else {
                iArr[0] = f.this.e0.getHeight();
                iArr[1] = f.this.e0.getHeight();
            }
        }
    }

    public class d implements InterfaceC0065f {
        public d() {
        }
    }

    public enum e {
        DAY,
        YEAR
    }

    /* JADX INFO: renamed from: c.c.a.b.u.f$f, reason: collision with other inner class name */
    public interface InterfaceC0065f {
    }

    public static int Z(Context context) {
        return context.getResources().getDimensionPixelSize(c.c.a.b.d.mtrl_calendar_day_height);
    }

    @Override // androidx.fragment.app.Fragment
    public void A(Bundle bundle) {
        super.A(bundle);
        if (bundle == null) {
            bundle = this.g;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (c.c.a.b.u.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (c.c.a.b.u.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.a0 = (o) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0135, code lost:
    
        r13 = new b.r.d.p();
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View B(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.u.f.B(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // androidx.fragment.app.Fragment
    public void I(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.a0);
    }

    public LinearLayoutManager a0() {
        return (LinearLayoutManager) this.e0.getLayoutManager();
    }

    public final void b0(int i) {
        this.e0.post(new a(i));
    }

    public void c0(o oVar) {
        RecyclerView recyclerView;
        int i;
        r rVar = (r) this.e0.getAdapter();
        int i2 = rVar.f1714c.f1682b.i(oVar);
        int iF = i2 - rVar.f(this.a0);
        boolean z = Math.abs(iF) > 3;
        boolean z2 = iF > 0;
        this.a0 = oVar;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.e0;
                i = i2 + 3;
            }
            b0(i2);
        }
        recyclerView = this.e0;
        i = i2 - 3;
        recyclerView.scrollToPosition(i);
        b0(i2);
    }

    public void d0(e eVar) {
        this.b0 = eVar;
        if (eVar == e.YEAR) {
            this.d0.getLayoutManager().K0(((w) this.d0.getAdapter()).e(this.a0.e));
            this.f0.setVisibility(0);
            this.g0.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f0.setVisibility(8);
            this.g0.setVisibility(0);
            c0(this.a0);
        }
    }
}
