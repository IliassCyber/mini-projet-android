package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.m.v.b;
import b.r.d.m;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean H;
    public int I;
    public int[] J;
    public View[] K;
    public final SparseIntArray L;
    public final SparseIntArray M;
    public c N;
    public final Rect O;

    public static final class a extends c {
    }

    public static class b extends RecyclerView.p {
        public int e;
        public int f;

        public b(int i, int i2) {
            super(i, i2);
            this.e = -1;
            this.f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f162a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseIntArray f163b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f164c = false;
        public boolean d = false;

        public int a(int i, int i2) {
            if (!this.d) {
                return c(i, i2);
            }
            int i3 = this.f163b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iC = c(i, i2);
            this.f163b.put(i, iC);
            return iC;
        }

        public int b(int i, int i2) {
            if (!this.f164c) {
                return i % i2;
            }
            int i3 = this.f162a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = i % i2;
            this.f162a.put(i, i4);
            return i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int c(int r9, int r10) {
            /*
                r8 = this;
                boolean r0 = r8.d
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L44
                android.util.SparseIntArray r0 = r8.f163b
                int r3 = r0.size()
                r4 = -1
                int r3 = r3 + r4
                r5 = 0
            Lf:
                if (r5 > r3) goto L20
                int r6 = r5 + r3
                int r6 = r6 >>> r2
                int r7 = r0.keyAt(r6)
                if (r7 >= r9) goto L1d
                int r5 = r6 + 1
                goto Lf
            L1d:
                int r3 = r6 + (-1)
                goto Lf
            L20:
                int r5 = r5 + r4
                if (r5 < 0) goto L2e
                int r3 = r0.size()
                if (r5 >= r3) goto L2e
                int r0 = r0.keyAt(r5)
                goto L2f
            L2e:
                r0 = -1
            L2f:
                if (r0 == r4) goto L44
                android.util.SparseIntArray r3 = r8.f163b
                int r3 = r3.get(r0)
                int r4 = r0 + 1
                int r0 = r8.b(r0, r10)
                int r0 = r0 + r2
                if (r0 != r10) goto L47
                int r3 = r3 + 1
                r0 = 0
                goto L47
            L44:
                r0 = 0
                r3 = 0
                r4 = 0
            L47:
                if (r4 >= r9) goto L59
                int r0 = r0 + 1
                if (r0 != r10) goto L51
                int r3 = r3 + 1
                r0 = 0
                goto L56
            L51:
                if (r0 <= r10) goto L56
                int r3 = r3 + 1
                r0 = 1
            L56:
                int r4 = r4 + 1
                goto L47
            L59:
                int r0 = r0 + r2
                if (r0 <= r10) goto L5e
                int r3 = r3 + 1
            L5e:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.c(int, int):int");
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        N1(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        N1(RecyclerView.o.Q(context, attributeSet, i, i2).f203b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return I1(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void B1(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        d(null);
        if (this.y) {
            this.y = false;
            I0();
        }
    }

    public final void F1(int i) {
        int i2;
        int[] iArr = this.J;
        int i3 = this.I;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.J = iArr;
    }

    public final void G1() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    public int H1(int i, int i2) {
        if (this.s != 1 || !s1()) {
            int[] iArr = this.J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.J;
        int i3 = this.I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int I1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.g) {
            return this.N.a(i, this.I);
        }
        int iC = vVar.c(i);
        if (iC != -1) {
            return this.N.a(iC, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O1();
        G1();
        if (this.s == 1) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    public final int J1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.g) {
            return this.N.b(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iC = vVar.c(i);
        if (iC != -1) {
            return this.N.b(iC, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int K1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.g) {
            if (((a) this.N) != null) {
                return 1;
            }
            throw null;
        }
        int i2 = this.L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (vVar.c(i) != -1) {
            if (((a) this.N) != null) {
                return 1;
            }
            throw null;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O1();
        G1();
        if (this.s == 0) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    public final void L1(View view, int i, boolean z) {
        int iZ;
        int iZ2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f206b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iH1 = H1(bVar.e, bVar.f);
        if (this.s == 1) {
            iZ2 = RecyclerView.o.z(iH1, i, i3, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iZ = RecyclerView.o.z(this.u.l(), this.p, i2, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iZ3 = RecyclerView.o.z(iH1, i, i2, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iZ4 = RecyclerView.o.z(this.u.l(), this.o, i3, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iZ = iZ3;
            iZ2 = iZ4;
        }
        M1(view, iZ2, iZ, z);
    }

    public final void M1(View view, int i, int i2, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? T0(view, i, i2, pVar) : R0(view, i, i2, pVar)) {
            view.measure(i, i2);
        }
    }

    public void N1(int i) {
        if (i == this.I) {
            return;
        }
        this.H = true;
        if (i >= 1) {
            this.I = i;
            this.N.f162a.clear();
            I0();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(Rect rect, int i, int i2) {
        int iH;
        int iH2;
        if (this.J == null) {
            super.O0(rect, i, i2);
        }
        int iN = N() + M();
        int iL = L() + O();
        if (this.s == 1) {
            iH2 = RecyclerView.o.h(i2, rect.height() + iL, J());
            int[] iArr = this.J;
            iH = RecyclerView.o.h(i, iArr[iArr.length - 1] + iN, K());
        } else {
            iH = RecyclerView.o.h(i, rect.width() + iN, K());
            int[] iArr2 = this.J;
            iH2 = RecyclerView.o.h(i2, iArr2[iArr2.length - 1] + iL, J());
        }
        this.f198b.setMeasuredDimension(iH, iH2);
    }

    public final void O1() {
        int iL;
        int iO;
        if (this.s == 1) {
            iL = this.q - N();
            iO = M();
        } else {
            iL = this.r - L();
            iO = O();
        }
        F1(iL - iO);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int R(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return I1(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean W0() {
        return this.C == null && !this.H;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void Y0(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.b(a0Var) && i > 0; i2++) {
            ((m.b) cVar2).a(cVar.d, Math.max(0, cVar.g));
            if (((a) this.N) == null) {
                throw null;
            }
            i--;
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean g(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f0  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View g0(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.v r25, androidx.recyclerview.widget.RecyclerView.a0 r26) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.g0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.i.m.v.b bVar) {
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.j0(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int iI1 = I1(vVar, a0Var, bVar2.a());
        if (this.s == 0) {
            i4 = bVar2.e;
            i = bVar2.f;
            i3 = 1;
            z = false;
            z2 = false;
            i2 = iI1;
        } else {
            i = 1;
            i2 = bVar2.e;
            i3 = bVar2.f;
            z = false;
            z2 = false;
            i4 = iI1;
        }
        bVar.j(b.c.a(i4, i, i2, i3, z, z2));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m0(RecyclerView recyclerView, int i, int i2) {
        this.N.f162a.clear();
        this.N.f163b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n0(RecyclerView recyclerView) {
        this.N.f162a.clear();
        this.N.f163b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View n1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        d1();
        int iK = this.u.k();
        int iG = this.u.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewX = x(i);
            int iP = P(viewX);
            if (iP >= 0 && iP < i3 && J1(vVar, a0Var, iP) == 0) {
                if (((RecyclerView.p) viewX.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.u.e(viewX) < iG && this.u.b(viewX) >= iK) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.f162a.clear();
        this.N.f163b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p0(RecyclerView recyclerView, int i, int i2) {
        this.N.f162a.clear();
        this.N.f163b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r0(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.f162a.clear();
        this.N.f163b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void s0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.g) {
            int iY = y();
            for (int i = 0; i < iY; i++) {
                b bVar = (b) x(i).getLayoutParams();
                int iA = bVar.a();
                this.L.put(iA, bVar.f);
                this.M.put(iA, bVar.e);
            }
        }
        super.s0(vVar, a0Var);
        this.L.clear();
        this.M.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void t0(RecyclerView.a0 a0Var) {
        this.C = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D.d();
        this.H = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x025b  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t1(androidx.recyclerview.widget.RecyclerView.v r19, androidx.recyclerview.widget.RecyclerView.a0 r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.t1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p u() {
        return this.s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void u1(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        O1();
        if (a0Var.b() > 0 && !a0Var.g) {
            boolean z = i == 1;
            int iJ1 = J1(vVar, a0Var, aVar.f166b);
            if (z) {
                while (iJ1 > 0) {
                    int i2 = aVar.f166b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.f166b = i3;
                    iJ1 = J1(vVar, a0Var, i3);
                }
            } else {
                int iB = a0Var.b() - 1;
                int i4 = aVar.f166b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iJ12 = J1(vVar, a0Var, i5);
                    if (iJ12 <= iJ1) {
                        break;
                    }
                    i4 = i5;
                    iJ1 = iJ12;
                }
                aVar.f166b = i4;
            }
        }
        G1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p v(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }
}
