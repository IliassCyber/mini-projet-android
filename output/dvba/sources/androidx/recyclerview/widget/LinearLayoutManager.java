package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.m;
import b.r.d.o;
import b.r.d.t;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public int A;
    public int B;
    public d C;
    public final a D;
    public final b E;
    public int F;
    public int[] G;
    public int s;
    public c t;
    public t u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f167c;
        public boolean d;
        public boolean e;

        public a() {
            d();
        }

        public void a() {
            this.f167c = this.d ? this.f165a.g() : this.f165a.k();
        }

        public void b(View view, int i) {
            if (this.d) {
                this.f167c = this.f165a.m() + this.f165a.b(view);
            } else {
                this.f167c = this.f165a.e(view);
            }
            this.f166b = i;
        }

        public void c(View view, int i) {
            int iMin;
            int iM = this.f165a.m();
            if (iM >= 0) {
                b(view, i);
                return;
            }
            this.f166b = i;
            if (this.d) {
                int iG = (this.f165a.g() - iM) - this.f165a.b(view);
                this.f167c = this.f165a.g() - iG;
                if (iG <= 0) {
                    return;
                }
                int iC = this.f167c - this.f165a.c(view);
                int iK = this.f165a.k();
                int iMin2 = iC - (Math.min(this.f165a.e(view) - iK, 0) + iK);
                if (iMin2 >= 0) {
                    return;
                }
                iMin = Math.min(iG, -iMin2) + this.f167c;
            } else {
                int iE = this.f165a.e(view);
                int iK2 = iE - this.f165a.k();
                this.f167c = iE;
                if (iK2 <= 0) {
                    return;
                }
                int iG2 = (this.f165a.g() - Math.min(0, (this.f165a.g() - iM) - this.f165a.b(view))) - (this.f165a.c(view) + iE);
                if (iG2 >= 0) {
                    return;
                } else {
                    iMin = this.f167c - Math.min(iK2, -iG2);
                }
            }
            this.f167c = iMin;
        }

        public void d() {
            this.f166b = -1;
            this.f167c = RecyclerView.UNDEFINED_DURATION;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            StringBuilder sbE = c.a.a.a.a.e("AnchorInfo{mPosition=");
            sbE.append(this.f166b);
            sbE.append(", mCoordinate=");
            sbE.append(this.f167c);
            sbE.append(", mLayoutFromEnd=");
            sbE.append(this.d);
            sbE.append(", mValid=");
            sbE.append(this.e);
            sbE.append('}');
            return sbE.toString();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f170c;
        public boolean d;
    }

    public static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f173c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean j;
        public int k;
        public boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f171a = true;
        public int h = 0;
        public int i = 0;
        public List<RecyclerView.d0> l = null;

        public void a(View view) {
            int iA;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).f184a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.d) * this.e) >= 0 && iA < i) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    } else {
                        i = iA;
                    }
                }
            }
            this.d = view2 == null ? -1 : ((RecyclerView.p) view2.getLayoutParams()).a();
        }

        public boolean b(RecyclerView.a0 a0Var) {
            int i = this.d;
            return i >= 0 && i < a0Var.b();
        }

        public View c(RecyclerView.v vVar) {
            List<RecyclerView.d0> list = this.l;
            if (list == null) {
                View view = vVar.k(this.d, false, RecyclerView.FOREVER_NS).f184a;
                this.d += this.e;
                return view;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view2 = this.l.get(i).f184a;
                RecyclerView.p pVar = (RecyclerView.p) view2.getLayoutParams();
                if (!pVar.c() && this.d == pVar.a()) {
                    a(view2);
                    return view2;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f175c;
        public boolean d;

        public static class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.f174b = parcel.readInt();
            this.f175c = parcel.readInt();
            this.d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f174b = dVar.f174b;
            this.f175c = dVar.f175c;
            this.d = dVar.d;
        }

        public boolean c() {
            return this.f174b >= 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f174b);
            parcel.writeInt(this.f175c);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        A1(i);
        d(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        I0();
    }

    public LinearLayoutManager(Context context) {
        this(1, false);
    }

    public void A1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        d(null);
        if (i != this.s || this.u == null) {
            t tVarA = t.a(this, i);
            this.u = tVarA;
            this.D.f165a = tVarA;
            this.s = i;
            I0();
        }
    }

    public void B1(boolean z) {
        d(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        I0();
    }

    public final void C1(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int iK;
        this.t.m = x1();
        this.t.f = i;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        X0(a0Var, iArr);
        int iMax = Math.max(0, this.G[0]);
        int iMax2 = Math.max(0, this.G[1]);
        boolean z2 = i == 1;
        this.t.h = z2 ? iMax2 : iMax;
        c cVar = this.t;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            c cVar2 = this.t;
            cVar2.h = this.u.h() + cVar2.h;
            View viewQ1 = q1();
            this.t.e = this.x ? -1 : 1;
            c cVar3 = this.t;
            int iP = P(viewQ1);
            c cVar4 = this.t;
            cVar3.d = iP + cVar4.e;
            cVar4.f172b = this.u.b(viewQ1);
            iK = this.u.b(viewQ1) - this.u.g();
        } else {
            View viewR1 = r1();
            c cVar5 = this.t;
            cVar5.h = this.u.k() + cVar5.h;
            this.t.e = this.x ? 1 : -1;
            c cVar6 = this.t;
            int iP2 = P(viewR1);
            c cVar7 = this.t;
            cVar6.d = iP2 + cVar7.e;
            cVar7.f172b = this.u.e(viewR1);
            iK = (-this.u.e(viewR1)) + this.u.k();
        }
        c cVar8 = this.t;
        cVar8.f173c = i2;
        if (z) {
            cVar8.f173c = i2 - iK;
        }
        this.t.g = iK;
    }

    public final void D1(int i, int i2) {
        this.t.f173c = this.u.g() - i2;
        this.t.e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.d = i;
        cVar.f = 1;
        cVar.f172b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    public final void E1(int i, int i2) {
        this.t.f173c = i2 - this.u.k();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f172b = i2;
        cVar2.g = RecyclerView.UNDEFINED_DURATION;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(int i) {
        this.A = i;
        this.B = RecyclerView.UNDEFINED_DURATION;
        d dVar = this.C;
        if (dVar != null) {
            dVar.f174b = -1;
        }
        I0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean S0() {
        boolean z;
        if (this.p != 1073741824 && this.o != 1073741824) {
            int iY = y();
            int i = 0;
            while (true) {
                if (i >= iY) {
                    z = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = x(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean U() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        o oVar = new o(recyclerView.getContext());
        oVar.f217a = i;
        V0(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean W0() {
        return this.C == null && this.v == this.y;
    }

    public void X0(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int iL = a0Var.f177a != -1 ? this.u.l() : 0;
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i;
    }

    public void Y0(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= a0Var.b()) {
            return;
        }
        ((m.b) cVar2).a(i, Math.max(0, cVar.g));
    }

    public final int Z0(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return a.a.a.a.a.l(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        if (y() == 0) {
            return null;
        }
        int i2 = (i < P(x(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public final int a1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return a.a.a.a.a.m(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z, this.x);
    }

    public final int b1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return a.a.a.a.a.n(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    public int c1(int i) {
        if (i == 1) {
            return (this.s != 1 && s1()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && s1()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.s == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 33) {
            if (this.s == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 66) {
            if (this.s == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 130 && this.s == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.C != null || (recyclerView = this.f198b) == null) {
            return;
        }
        recyclerView.assertNotInLayoutOrScroll(str);
    }

    public void d1() {
        if (this.t == null) {
            this.t = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean e() {
        return this.s == 0;
    }

    public int e1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i = cVar.f173c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            v1(vVar, cVar);
        }
        int i3 = cVar.f173c + cVar.h;
        b bVar = this.E;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.b(a0Var)) {
                break;
            }
            bVar.f168a = 0;
            bVar.f169b = false;
            bVar.f170c = false;
            bVar.d = false;
            t1(vVar, a0Var, cVar, bVar);
            if (!bVar.f169b) {
                cVar.f172b = (bVar.f168a * cVar.f) + cVar.f172b;
                if (!bVar.f170c || cVar.l != null || !a0Var.g) {
                    int i4 = cVar.f173c;
                    int i5 = bVar.f168a;
                    cVar.f173c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f168a;
                    cVar.g = i7;
                    int i8 = cVar.f173c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    v1(vVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f173c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean f() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f0(RecyclerView recyclerView, RecyclerView.v vVar) {
        e0();
    }

    public final View f1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return n1(vVar, a0Var, 0, y(), a0Var.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View g0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iC1;
        y1();
        if (y() == 0 || (iC1 = c1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        d1();
        C1(iC1, (int) (this.u.l() * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
        cVar.f171a = false;
        e1(vVar, cVar, a0Var, true);
        View viewL1 = iC1 == -1 ? this.x ? l1(y() - 1, -1) : l1(0, y()) : this.x ? l1(0, y()) : l1(y() - 1, -1);
        View viewR1 = iC1 == -1 ? r1() : q1();
        if (!viewR1.hasFocusable()) {
            return viewL1;
        }
        if (viewL1 == null) {
            return null;
        }
        return viewR1;
    }

    public View g1(boolean z, boolean z2) {
        int iY;
        int iY2;
        if (this.x) {
            iY = 0;
            iY2 = y();
        } else {
            iY = y() - 1;
            iY2 = -1;
        }
        return m1(iY, iY2, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.v vVar = this.f198b.mRecycler;
        i0(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(i1());
            accessibilityEvent.setToIndex(k1());
        }
    }

    public View h1(boolean z, boolean z2) {
        int iY;
        int iY2;
        if (this.x) {
            iY = y() - 1;
            iY2 = -1;
        } else {
            iY = 0;
            iY2 = y();
        }
        return m1(iY, iY2, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        d1();
        C1(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
        Y0(a0Var, this.t, cVar);
    }

    public int i1() {
        View viewM1 = m1(0, y(), false, true);
        if (viewM1 == null) {
            return -1;
        }
        return P(viewM1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void j(int i, RecyclerView.o.c cVar) {
        boolean z;
        int i2;
        d dVar = this.C;
        if (dVar == null || !dVar.c()) {
            y1();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.C;
            z = dVar2.d;
            i2 = dVar2.f174b;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.F && i2 >= 0 && i2 < i; i4++) {
            ((m.b) cVar).a(i2, 0);
            i2 += i3;
        }
    }

    public final View j1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return n1(vVar, a0Var, y() - 1, -1, a0Var.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    public int k1() {
        View viewM1 = m1(y() - 1, -1, false, true);
        if (viewM1 == null) {
            return -1;
        }
        return P(viewM1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    public View l1(int i, int i2) {
        int i3;
        int i4;
        d1();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return x(i);
        }
        if (this.u.e(x(i)) < this.u.k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.s == 0 ? this.e : this.f).a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    public View m1(int i, int i2, boolean z, boolean z2) {
        d1();
        return (this.s == 0 ? this.e : this.f).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int n(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

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
            if (iP >= 0 && iP < i3) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    public final int o1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iG;
        int iG2 = this.u.g() - i;
        if (iG2 <= 0) {
            return 0;
        }
        int i2 = -z1(-iG2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iG = this.u.g() - i3) <= 0) {
            return i2;
        }
        this.u.p(iG);
        return iG + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    public final int p1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iK;
        int iK2 = i - this.u.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i2 = -z1(iK2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iK = i3 - this.u.k()) <= 0) {
            return i2;
        }
        this.u.p(-iK);
        return i2 - iK;
    }

    public final View q1() {
        return x(this.x ? 0 : y() - 1);
    }

    public final View r1() {
        return x(this.x ? y() - 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0177  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s0(androidx.recyclerview.widget.RecyclerView.v r17, androidx.recyclerview.widget.RecyclerView.a0 r18) {
        /*
            Method dump skipped, instruction units count: 1075
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.s0(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    public boolean s1() {
        return I() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View t(int i) {
        int iY = y();
        if (iY == 0) {
            return null;
        }
        int iP = i - P(x(0));
        if (iP >= 0 && iP < iY) {
            View viewX = x(iP);
            if (P(viewX) == i) {
                return viewX;
            }
        }
        return super.t(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t0(RecyclerView.a0 a0Var) {
        this.C = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D.d();
    }

    public void t1(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int iM;
        int iD;
        View viewC = cVar.c(vVar);
        if (viewC == null) {
            bVar.f169b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewC.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                c(viewC, -1, false);
            } else {
                c(viewC, 0, false);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                c(viewC, -1, true);
            } else {
                c(viewC, 0, true);
            }
        }
        RecyclerView.p pVar2 = (RecyclerView.p) viewC.getLayoutParams();
        Rect itemDecorInsetsForChild = this.f198b.getItemDecorInsetsForChild(viewC);
        int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + 0;
        int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + 0;
        int iZ = RecyclerView.o.z(this.q, this.o, N() + M() + ((ViewGroup.MarginLayoutParams) pVar2).leftMargin + ((ViewGroup.MarginLayoutParams) pVar2).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar2).width, e());
        int iZ2 = RecyclerView.o.z(this.r, this.p, L() + O() + ((ViewGroup.MarginLayoutParams) pVar2).topMargin + ((ViewGroup.MarginLayoutParams) pVar2).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar2).height, f());
        if (R0(viewC, iZ, iZ2, pVar2)) {
            viewC.measure(iZ, iZ2);
        }
        bVar.f168a = this.u.c(viewC);
        if (this.s == 1) {
            if (s1()) {
                iD = this.q - N();
                iM = iD - this.u.d(viewC);
            } else {
                iM = M();
                iD = this.u.d(viewC) + iM;
            }
            int i6 = cVar.f;
            int i7 = cVar.f172b;
            if (i6 == -1) {
                i3 = i7;
                i2 = iD;
                i = i7 - bVar.f168a;
            } else {
                i = i7;
                i2 = iD;
                i3 = bVar.f168a + i7;
            }
        } else {
            int iO = O();
            int iD2 = this.u.d(viewC) + iO;
            int i8 = cVar.f;
            int i9 = cVar.f172b;
            if (i8 == -1) {
                i2 = i9;
                i = iO;
                i3 = iD2;
                iM = i9 - bVar.f168a;
            } else {
                i = iO;
                i2 = bVar.f168a + i9;
                i3 = iD2;
                iM = i9;
            }
        }
        Y(viewC, iM, i, i2, i3);
        if (pVar.c() || pVar.b()) {
            bVar.f170c = true;
        }
        bVar.d = viewC.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p u() {
        return new RecyclerView.p(-2, -2);
    }

    public void u1(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    public final void v1(RecyclerView.v vVar, c cVar) {
        if (!cVar.f171a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            int iY = y();
            if (i < 0) {
                return;
            }
            int iF = (this.u.f() - i) + i2;
            if (this.x) {
                for (int i3 = 0; i3 < iY; i3++) {
                    View viewX = x(i3);
                    if (this.u.e(viewX) < iF || this.u.o(viewX) < iF) {
                        w1(vVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = iY - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View viewX2 = x(i5);
                if (this.u.e(viewX2) < iF || this.u.o(viewX2) < iF) {
                    w1(vVar, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int iY2 = y();
        if (!this.x) {
            for (int i7 = 0; i7 < iY2; i7++) {
                View viewX3 = x(i7);
                if (this.u.b(viewX3) > i6 || this.u.n(viewX3) > i6) {
                    w1(vVar, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = iY2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View viewX4 = x(i9);
            if (this.u.b(viewX4) > i6 || this.u.n(viewX4) > i6) {
                w1(vVar, i8, i9);
                return;
            }
        }
    }

    public final void w1(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                F0(i, vVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                F0(i3, vVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.C = (d) parcelable;
            I0();
        }
    }

    public boolean x1() {
        return this.u.i() == 0 && this.u.f() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable y0() {
        d dVar = this.C;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (y() > 0) {
            d1();
            boolean z = this.v ^ this.x;
            dVar2.d = z;
            if (z) {
                View viewQ1 = q1();
                dVar2.f175c = this.u.g() - this.u.b(viewQ1);
                dVar2.f174b = P(viewQ1);
            } else {
                View viewR1 = r1();
                dVar2.f174b = P(viewR1);
                dVar2.f175c = this.u.e(viewR1) - this.u.k();
            }
        } else {
            dVar2.f174b = -1;
        }
        return dVar2;
    }

    public final void y1() {
        this.x = (this.s == 1 || !s1()) ? this.w : !this.w;
    }

    public int z1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        d1();
        this.t.f171a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        C1(i2, iAbs, true, a0Var);
        c cVar = this.t;
        int iE1 = e1(vVar, cVar, a0Var, false) + cVar.g;
        if (iE1 < 0) {
            return 0;
        }
        if (iAbs > iE1) {
            i = i2 * iE1;
        }
        this.u.p(-i);
        this.t.k = i;
        return i;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        RecyclerView.o.d dVarQ = RecyclerView.o.Q(context, attributeSet, i, i2);
        A1(dVarQ.f202a);
        boolean z = dVarQ.f204c;
        d(null);
        if (z != this.w) {
            this.w = z;
            I0();
        }
        B1(dVarQ.d);
    }
}
