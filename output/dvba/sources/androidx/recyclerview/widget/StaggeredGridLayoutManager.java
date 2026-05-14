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
import b.i.m.v.b;
import b.r.d.m;
import b.r.d.n;
import b.r.d.o;
import b.r.d.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public int[] O;
    public int s;
    public f[] t;
    public t u;
    public t v;
    public int w;
    public int x;
    public final n y;
    public boolean z;
    public boolean A = false;
    public int C = -1;
    public int D = RecyclerView.UNDEFINED_DURATION;
    public d E = new d();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.Y0();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f226c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            b();
        }

        public void a() {
            this.f225b = this.f226c ? StaggeredGridLayoutManager.this.u.g() : StaggeredGridLayoutManager.this.u.k();
        }

        public void b() {
            this.f224a = -1;
            this.f225b = RecyclerView.UNDEFINED_DURATION;
            this.f226c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.p {
        public f e;
        public boolean f;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<a> f228b;

        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0005a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f229b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f230c;
            public int[] d;
            public boolean e;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            public static class C0005a implements Parcelable.Creator<a> {
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a() {
            }

            public a(Parcel parcel) {
                this.f229b = parcel.readInt();
                this.f230c = parcel.readInt();
                this.e = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder sbE = c.a.a.a.a.e("FullSpanItem{mPosition=");
                sbE.append(this.f229b);
                sbE.append(", mGapDir=");
                sbE.append(this.f230c);
                sbE.append(", mHasUnwantedGapAfter=");
                sbE.append(this.e);
                sbE.append(", mGapPerSpan=");
                sbE.append(Arrays.toString(this.d));
                sbE.append('}');
                return sbE.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f229b);
                parcel.writeInt(this.f230c);
                parcel.writeInt(this.e ? 1 : 0);
                int[] iArr = this.d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.d);
                }
            }
        }

        public void a(a aVar) {
            if (this.f228b == null) {
                this.f228b = new ArrayList();
            }
            int size = this.f228b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f228b.get(i);
                if (aVar2.f229b == aVar.f229b) {
                    this.f228b.remove(i);
                }
                if (aVar2.f229b >= aVar.f229b) {
                    this.f228b.add(i, aVar);
                    return;
                }
            }
            this.f228b.add(aVar);
        }

        public void b() {
            int[] iArr = this.f227a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f228b = null;
        }

        public void c(int i) {
            int[] iArr = this.f227a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f227a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f227a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f227a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List<a> list = this.f228b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f228b.get(size).f229b >= i) {
                        this.f228b.remove(size);
                    }
                }
            }
            return g(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.f228b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f228b.get(i4);
                int i5 = aVar.f229b;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.f230c == i3 || (z && aVar.e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.f228b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f228b.get(size);
                if (aVar.f229b == i) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int g(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.f227a
                r1 = -1
                if (r0 != 0) goto L6
                return r1
            L6:
                int r0 = r0.length
                if (r5 < r0) goto La
                return r1
            La:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f228b
                if (r0 != 0) goto L10
            Le:
                r0 = -1
                goto L46
            L10:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = r4.f(r5)
                if (r0 == 0) goto L1b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r2 = r4.f228b
                r2.remove(r0)
            L1b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f228b
                int r0 = r0.size()
                r2 = 0
            L22:
                if (r2 >= r0) goto L34
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r4.f228b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r3 = r3.f229b
                if (r3 < r5) goto L31
                goto L35
            L31:
                int r2 = r2 + 1
                goto L22
            L34:
                r2 = -1
            L35:
                if (r2 == r1) goto Le
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f228b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r4.f228b
                r3.remove(r2)
                int r0 = r0.f229b
            L46:
                if (r0 != r1) goto L52
                int[] r0 = r4.f227a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.f227a
                int r5 = r5.length
                return r5
            L52:
                int[] r2 = r4.f227a
                int r0 = r0 + 1
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.g(int):int");
        }

        public void h(int i, int i2) {
            int[] iArr = this.f227a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f227a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f227a, i, i3, -1);
            List<a> list = this.f228b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f228b.get(size);
                int i4 = aVar.f229b;
                if (i4 >= i) {
                    aVar.f229b = i4 + i2;
                }
            }
        }

        public void i(int i, int i2) {
            int[] iArr = this.f227a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f227a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f227a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            List<a> list = this.f228b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f228b.get(size);
                int i4 = aVar.f229b;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f228b.remove(size);
                    } else {
                        aVar.f229b = i4 - i2;
                    }
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f232c;
        public int d;
        public int[] e;
        public int f;
        public int[] g;
        public List<d.a> h;
        public boolean i;
        public boolean j;
        public boolean k;

        public static class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        public e(Parcel parcel) {
            this.f231b = parcel.readInt();
            this.f232c = parcel.readInt();
            int i = parcel.readInt();
            this.d = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.e = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.f = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
            this.h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.d = eVar.d;
            this.f231b = eVar.f231b;
            this.f232c = eVar.f232c;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.h = eVar.h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f231b);
            parcel.writeInt(this.f232c);
            parcel.writeInt(this.d);
            if (this.d > 0) {
                parcel.writeIntArray(this.e);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<View> f233a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f234b = RecyclerView.UNDEFINED_DURATION;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f235c = RecyclerView.UNDEFINED_DURATION;
        public int d = 0;
        public final int e;

        public f(int i) {
            this.e = i;
        }

        public void a(View view) {
            c cVarJ = j(view);
            cVarJ.e = this;
            this.f233a.add(view);
            this.f235c = RecyclerView.UNDEFINED_DURATION;
            if (this.f233a.size() == 1) {
                this.f234b = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarJ.c() || cVarJ.b()) {
                this.d = StaggeredGridLayoutManager.this.u.c(view) + this.d;
            }
        }

        public void b() {
            d.a aVarF;
            ArrayList<View> arrayList = this.f233a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarJ = j(view);
            this.f235c = StaggeredGridLayoutManager.this.u.b(view);
            if (cVarJ.f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarJ.a())) != null && aVarF.f230c == 1) {
                int i = this.f235c;
                int i2 = this.e;
                int[] iArr = aVarF.d;
                this.f235c = i + (iArr == null ? 0 : iArr[i2]);
            }
        }

        public void c() {
            d.a aVarF;
            View view = this.f233a.get(0);
            c cVarJ = j(view);
            this.f234b = StaggeredGridLayoutManager.this.u.e(view);
            if (cVarJ.f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarJ.a())) != null && aVarF.f230c == -1) {
                int i = this.f234b;
                int i2 = this.e;
                int[] iArr = aVarF.d;
                this.f234b = i - (iArr != null ? iArr[i2] : 0);
            }
        }

        public void d() {
            this.f233a.clear();
            this.f234b = RecyclerView.UNDEFINED_DURATION;
            this.f235c = RecyclerView.UNDEFINED_DURATION;
            this.d = 0;
        }

        public int e() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.z) {
                size = this.f233a.size() - 1;
                size2 = -1;
            } else {
                size = 0;
                size2 = this.f233a.size();
            }
            return g(size, size2, true);
        }

        public int f() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.z) {
                size = 0;
                size2 = this.f233a.size();
            } else {
                size = this.f233a.size() - 1;
                size2 = -1;
            }
            return g(size, size2, true);
        }

        public int g(int i, int i2, boolean z) {
            int iK = StaggeredGridLayoutManager.this.u.k();
            int iG = StaggeredGridLayoutManager.this.u.g();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f233a.get(i);
                int iE = StaggeredGridLayoutManager.this.u.e(view);
                int iB = StaggeredGridLayoutManager.this.u.b(view);
                boolean z2 = false;
                boolean z3 = !z ? iE >= iG : iE > iG;
                if (!z ? iB > iK : iB >= iK) {
                    z2 = true;
                }
                if (z3 && z2 && (iE < iK || iB > iG)) {
                    return StaggeredGridLayoutManager.this.P(view);
                }
                i += i3;
            }
            return -1;
        }

        public int h(int i) {
            int i2 = this.f235c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f233a.size() == 0) {
                return i;
            }
            b();
            return this.f235c;
        }

        public View i(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f233a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f233a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.P(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.P(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f233a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f233a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.P(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.P(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public c j(View view) {
            return (c) view.getLayoutParams();
        }

        public int k(int i) {
            int i2 = this.f234b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f233a.size() == 0) {
                return i;
            }
            c();
            return this.f234b;
        }

        public void l() {
            int size = this.f233a.size();
            View viewRemove = this.f233a.remove(size - 1);
            c cVarJ = j(viewRemove);
            cVarJ.e = null;
            if (cVarJ.c() || cVarJ.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.c(viewRemove);
            }
            if (size == 1) {
                this.f234b = RecyclerView.UNDEFINED_DURATION;
            }
            this.f235c = RecyclerView.UNDEFINED_DURATION;
        }

        public void m() {
            View viewRemove = this.f233a.remove(0);
            c cVarJ = j(viewRemove);
            cVarJ.e = null;
            if (this.f233a.size() == 0) {
                this.f235c = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarJ.c() || cVarJ.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.c(viewRemove);
            }
            this.f234b = RecyclerView.UNDEFINED_DURATION;
        }

        public void n(View view) {
            c cVarJ = j(view);
            cVarJ.e = this;
            this.f233a.add(0, view);
            this.f234b = RecyclerView.UNDEFINED_DURATION;
            if (this.f233a.size() == 1) {
                this.f235c = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarJ.c() || cVarJ.b()) {
                this.d = StaggeredGridLayoutManager.this.u.c(view) + this.d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = -1;
        this.z = false;
        RecyclerView.o.d dVarQ = RecyclerView.o.Q(context, attributeSet, i, i2);
        int i3 = dVarQ.f202a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        d(null);
        if (i3 != this.w) {
            this.w = i3;
            t tVar = this.u;
            this.u = this.v;
            this.v = tVar;
            I0();
        }
        int i4 = dVarQ.f203b;
        d(null);
        if (i4 != this.s) {
            this.E.b();
            I0();
            this.s = i4;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i5 = 0; i5 < this.s; i5++) {
                this.t[i5] = new f(i5);
            }
            I0();
        }
        boolean z = dVarQ.f204c;
        d(null);
        e eVar = this.I;
        if (eVar != null && eVar.i != z) {
            eVar.i = z;
        }
        this.z = z;
        I0();
        this.y = new n();
        this.u = t.a(this, this.w);
        this.v = t.a(this, 1 - this.w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 1 ? this.s : super.A(vVar, a0Var);
    }

    public final void A1(f fVar, int i, int i2) {
        int i3 = fVar.d;
        if (i == -1) {
            int i4 = fVar.f234b;
            if (i4 == Integer.MIN_VALUE) {
                fVar.c();
                i4 = fVar.f234b;
            }
            if (i4 + i3 > i2) {
                return;
            }
        } else {
            int i5 = fVar.f235c;
            if (i5 == Integer.MIN_VALUE) {
                fVar.b();
                i5 = fVar.f235c;
            }
            if (i5 - i3 < i2) {
                return;
            }
        }
        this.B.set(fVar.e, false);
    }

    public final int B1(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return w1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(int i) {
        e eVar = this.I;
        if (eVar != null && eVar.f231b != i) {
            eVar.e = null;
            eVar.d = 0;
            eVar.f231b = -1;
            eVar.f232c = -1;
        }
        this.C = i;
        this.D = RecyclerView.UNDEFINED_DURATION;
        I0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return w1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(Rect rect, int i, int i2) {
        int iH;
        int iH2;
        int iN = N() + M();
        int iL = L() + O();
        if (this.w == 1) {
            iH2 = RecyclerView.o.h(i2, rect.height() + iL, J());
            iH = RecyclerView.o.h(i, (this.x * this.s) + iN, K());
        } else {
            iH = RecyclerView.o.h(i, rect.width() + iN, K());
            iH2 = RecyclerView.o.h(i2, (this.x * this.s) + iL, J());
        }
        this.f198b.setMeasuredDimension(iH, iH2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int R(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 0 ? this.s : super.R(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean U() {
        return this.F != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        o oVar = new o(recyclerView.getContext());
        oVar.f217a = i;
        V0(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean W0() {
        return this.I == null;
    }

    public final int X0(int i) {
        if (y() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < h1()) != this.A ? -1 : 1;
    }

    public boolean Y0() {
        int iH1;
        int iI1;
        if (y() == 0 || this.F == 0 || !this.i) {
            return false;
        }
        if (this.A) {
            iH1 = i1();
            iI1 = h1();
        } else {
            iH1 = h1();
            iI1 = i1();
        }
        if (iH1 == 0 && m1() != null) {
            this.E.b();
        } else {
            if (!this.M) {
                return false;
            }
            int i = this.A ? -1 : 1;
            int i2 = iI1 + 1;
            d.a aVarE = this.E.e(iH1, i2, i, true);
            if (aVarE == null) {
                this.M = false;
                this.E.d(i2);
                return false;
            }
            d.a aVarE2 = this.E.e(iH1, aVarE.f229b, i * (-1), true);
            if (aVarE2 == null) {
                this.E.d(aVarE.f229b);
            } else {
                this.E.d(aVarE2.f229b + 1);
            }
        }
        this.h = true;
        I0();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z(int i) {
        RecyclerView recyclerView = this.f198b;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            f fVar = this.t[i2];
            int i3 = fVar.f234b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.f234b = i3 + i;
            }
            int i4 = fVar.f235c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.f235c = i4 + i;
            }
        }
    }

    public final int Z0(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return a.a.a.a.a.l(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        int iX0 = X0(i);
        PointF pointF = new PointF();
        if (iX0 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = iX0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iX0;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a0(int i) {
        RecyclerView recyclerView = this.f198b;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            f fVar = this.t[i2];
            int i3 = fVar.f234b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.f234b = i3 + i;
            }
            int i4 = fVar.f235c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.f235c = i4 + i;
            }
        }
    }

    public final int a1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return a.a.a.a.a.m(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N, this.A);
    }

    public final int b1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return a.a.a.a.a.n(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cf  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c1(androidx.recyclerview.widget.RecyclerView.v r19, b.r.d.n r20, androidx.recyclerview.widget.RecyclerView.a0 r21) {
        /*
            Method dump skipped, instruction units count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c1(androidx.recyclerview.widget.RecyclerView$v, b.r.d.n, androidx.recyclerview.widget.RecyclerView$a0):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.I != null || (recyclerView = this.f198b) == null) {
            return;
        }
        recyclerView.assertNotInLayoutOrScroll(str);
    }

    public View d1(boolean z) {
        int iK = this.u.k();
        int iG = this.u.g();
        View view = null;
        for (int iY = y() - 1; iY >= 0; iY--) {
            View viewX = x(iY);
            int iE = this.u.e(viewX);
            int iB = this.u.b(viewX);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z) {
                    return viewX;
                }
                if (view == null) {
                    view = viewX;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean e() {
        return this.w == 0;
    }

    public View e1(boolean z) {
        int iK = this.u.k();
        int iG = this.u.g();
        int iY = y();
        View view = null;
        for (int i = 0; i < iY; i++) {
            View viewX = x(i);
            int iE = this.u.e(viewX);
            if (this.u.b(viewX) > iK && iE < iG) {
                if (iE >= iK || !z) {
                    return viewX;
                }
                if (view == null) {
                    view = viewX;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean f() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f0(RecyclerView recyclerView, RecyclerView.v vVar) {
        e0();
        Runnable runnable = this.P;
        RecyclerView recyclerView2 = this.f198b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i = 0; i < this.s; i++) {
            this.t[i].d();
        }
        recyclerView.requestLayout();
    }

    public final void f1(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iG;
        int iJ1 = j1(RecyclerView.UNDEFINED_DURATION);
        if (iJ1 != Integer.MIN_VALUE && (iG = this.u.g() - iJ1) > 0) {
            int i = iG - (-w1(-iG, vVar, a0Var));
            if (!z || i <= 0) {
                return;
            }
            this.u.p(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean g(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003e  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View g0(android.view.View r10, int r11, androidx.recyclerview.widget.RecyclerView.v r12, androidx.recyclerview.widget.RecyclerView.a0 r13) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.g0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    public final void g1(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iK;
        int iK1 = k1(Integer.MAX_VALUE);
        if (iK1 != Integer.MAX_VALUE && (iK = iK1 - this.u.k()) > 0) {
            int iW1 = iK - w1(iK, vVar, a0Var);
            if (!z || iW1 <= 0) {
                return;
            }
            this.u.p(-iW1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.v vVar = this.f198b.mRecycler;
        i0(accessibilityEvent);
        if (y() > 0) {
            View viewE1 = e1(false);
            View viewD1 = d1(false);
            if (viewE1 == null || viewD1 == null) {
                return;
            }
            int iP = P(viewE1);
            int iP2 = P(viewD1);
            if (iP < iP2) {
                accessibilityEvent.setFromIndex(iP);
                accessibilityEvent.setToIndex(iP2);
            } else {
                accessibilityEvent.setFromIndex(iP2);
                accessibilityEvent.setToIndex(iP);
            }
        }
    }

    public int h1() {
        if (y() == 0) {
            return 0;
        }
        return P(x(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int iH;
        int iK;
        if (this.w != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        r1(i, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.s; i4++) {
            n nVar = this.y;
            if (nVar.d == -1) {
                iH = nVar.f;
                iK = this.t[i4].k(iH);
            } else {
                iH = this.t[i4].h(nVar.g);
                iK = this.y.g;
            }
            int i5 = iH - iK;
            if (i5 >= 0) {
                this.O[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.O, 0, i3);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = this.y.f1070c;
            if (!(i7 >= 0 && i7 < a0Var.b())) {
                return;
            }
            ((m.b) cVar).a(this.y.f1070c, this.O[i6]);
            n nVar2 = this.y;
            nVar2.f1070c += nVar2.d;
        }
    }

    public int i1() {
        int iY = y();
        if (iY == 0) {
            return 0;
        }
        return P(x(iY - 1));
    }

    public final int j1(int i) {
        int iH = this.t[0].h(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iH2 = this.t[i2].h(i);
            if (iH2 > iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.i.m.v.b bVar) {
        b.c cVarA;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.j0(view, bVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.w == 0) {
            f fVar = cVar.e;
            cVarA = b.c.a(fVar == null ? -1 : fVar.e, cVar.f ? this.s : 1, -1, -1, false, false);
        } else {
            f fVar2 = cVar.e;
            cVarA = b.c.a(-1, -1, fVar2 == null ? -1 : fVar2.e, cVar.f ? this.s : 1, false, false);
        }
        bVar.j(cVarA);
    }

    public final int k1(int i) {
        int iK = this.t[0].k(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iK2 = this.t[i2].k(i);
            if (iK2 < iK) {
                iK = iK2;
            }
        }
        return iK;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l1(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.i1()
            goto Ld
        L9:
            int r0 = r6.h1()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.g(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.h(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.i(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.h(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.A
            if (r7 == 0) goto L4d
            int r7 = r6.h1()
            goto L51
        L4d:
            int r7 = r6.i1()
        L51:
            if (r3 > r7) goto L56
            r6.I0()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.l1(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m0(RecyclerView recyclerView, int i, int i2) {
        l1(i, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View m1() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m1():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int n(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n0(RecyclerView recyclerView) {
        this.E.b();
        I0();
    }

    public boolean n1() {
        return I() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o0(RecyclerView recyclerView, int i, int i2, int i3) {
        l1(i, i2, 8);
    }

    public final void o1(View view, int i, int i2, boolean z) {
        Rect rect = this.K;
        RecyclerView recyclerView = this.f198b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect2 = this.K;
        int iB1 = B1(i, i3 + rect2.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect2.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect3 = this.K;
        int iB12 = B1(i2, i4 + rect3.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect3.bottom);
        if (z ? T0(view, iB1, iB12, cVar) : R0(view, iB1, iB12, cVar)) {
            view.measure(iB1, iB12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p0(RecyclerView recyclerView, int i, int i2) {
        l1(i, i2, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0406  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p1(androidx.recyclerview.widget.RecyclerView.v r13, androidx.recyclerview.widget.RecyclerView.a0 r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 1061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.p1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    public final boolean q1(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == n1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r0(RecyclerView recyclerView, int i, int i2, Object obj) {
        l1(i, i2, 4);
    }

    public void r1(int i, RecyclerView.a0 a0Var) {
        int iH1;
        int i2;
        if (i > 0) {
            iH1 = i1();
            i2 = 1;
        } else {
            iH1 = h1();
            i2 = -1;
        }
        this.y.f1068a = true;
        z1(iH1, a0Var);
        x1(i2);
        n nVar = this.y;
        nVar.f1070c = iH1 + nVar.d;
        nVar.f1069b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void s0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        p1(vVar, a0Var, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r6.e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s1(androidx.recyclerview.widget.RecyclerView.v r5, b.r.d.n r6) {
        /*
            r4 = this;
            boolean r0 = r6.f1068a
            if (r0 == 0) goto L7c
            boolean r0 = r6.i
            if (r0 == 0) goto La
            goto L7c
        La:
            int r0 = r6.f1069b
            r1 = -1
            if (r0 != 0) goto L1f
            int r0 = r6.e
            if (r0 != r1) goto L19
        L13:
            int r6 = r6.g
        L15:
            r4.t1(r5, r6)
            goto L7c
        L19:
            int r6 = r6.f
        L1b:
            r4.u1(r5, r6)
            goto L7c
        L1f:
            int r0 = r6.e
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L50
            int r0 = r6.f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.t
            r1 = r1[r2]
            int r1 = r1.k(r0)
        L2f:
            int r2 = r4.s
            if (r3 >= r2) goto L41
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.t
            r2 = r2[r3]
            int r2 = r2.k(r0)
            if (r2 <= r1) goto L3e
            r1 = r2
        L3e:
            int r3 = r3 + 1
            goto L2f
        L41:
            int r0 = r0 - r1
            if (r0 >= 0) goto L45
            goto L13
        L45:
            int r1 = r6.g
            int r6 = r6.f1069b
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = r1 - r6
            goto L15
        L50:
            int r0 = r6.g
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.t
            r1 = r1[r2]
            int r1 = r1.h(r0)
        L5a:
            int r2 = r4.s
            if (r3 >= r2) goto L6c
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.t
            r2 = r2[r3]
            int r2 = r2.h(r0)
            if (r2 >= r1) goto L69
            r1 = r2
        L69:
            int r3 = r3 + 1
            goto L5a
        L6c:
            int r0 = r6.g
            int r1 = r1 - r0
            if (r1 >= 0) goto L72
            goto L19
        L72:
            int r0 = r6.f
            int r6 = r6.f1069b
            int r6 = java.lang.Math.min(r1, r6)
            int r6 = r6 + r0
            goto L1b
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s1(androidx.recyclerview.widget.RecyclerView$v, b.r.d.n):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t0(RecyclerView.a0 a0Var) {
        this.C = -1;
        this.D = RecyclerView.UNDEFINED_DURATION;
        this.I = null;
        this.L.b();
    }

    public final void t1(RecyclerView.v vVar, int i) {
        for (int iY = y() - 1; iY >= 0; iY--) {
            View viewX = x(iY);
            if (this.u.e(viewX) < i || this.u.o(viewX) < i) {
                return;
            }
            c cVar = (c) viewX.getLayoutParams();
            if (cVar.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f233a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].l();
                }
            } else if (cVar.e.f233a.size() == 1) {
                return;
            } else {
                cVar.e.l();
            }
            E0(viewX, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p u() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public final void u1(RecyclerView.v vVar, int i) {
        while (y() > 0) {
            View viewX = x(0);
            if (this.u.b(viewX) > i || this.u.n(viewX) > i) {
                return;
            }
            c cVar = (c) viewX.getLayoutParams();
            if (cVar.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f233a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].m();
                }
            } else if (cVar.e.f233a.size() == 1) {
                return;
            } else {
                cVar.e.m();
            }
            E0(viewX, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p v(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public final void v1() {
        this.A = (this.w == 1 || !n1()) ? this.z : !this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        r1(i, a0Var);
        int iC1 = c1(vVar, this.y, a0Var);
        if (this.y.f1069b >= iC1) {
            i = i < 0 ? -iC1 : iC1;
        }
        this.u.p(-i);
        this.G = this.A;
        n nVar = this.y;
        nVar.f1069b = 0;
        s1(vVar, nVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            I0();
        }
    }

    public final void x1(int i) {
        n nVar = this.y;
        nVar.e = i;
        nVar.d = this.A != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable y0() {
        int iK;
        int iK2;
        int[] iArr;
        e eVar = this.I;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.i = this.z;
        eVar2.j = this.G;
        eVar2.k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f227a) == null) {
            eVar2.f = 0;
        } else {
            eVar2.g = iArr;
            eVar2.f = iArr.length;
            eVar2.h = dVar.f228b;
        }
        if (y() > 0) {
            eVar2.f231b = this.G ? i1() : h1();
            View viewD1 = this.A ? d1(true) : e1(true);
            eVar2.f232c = viewD1 != null ? P(viewD1) : -1;
            int i = this.s;
            eVar2.d = i;
            eVar2.e = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    iK = this.t[i2].h(RecyclerView.UNDEFINED_DURATION);
                    if (iK != Integer.MIN_VALUE) {
                        iK2 = this.u.g();
                        iK -= iK2;
                    }
                } else {
                    iK = this.t[i2].k(RecyclerView.UNDEFINED_DURATION);
                    if (iK != Integer.MIN_VALUE) {
                        iK2 = this.u.k();
                        iK -= iK2;
                    }
                }
                eVar2.e[i2] = iK;
            }
        } else {
            eVar2.f231b = -1;
            eVar2.f232c = -1;
            eVar2.d = 0;
        }
        return eVar2;
    }

    public final void y1(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f233a.isEmpty()) {
                A1(this.t[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void z0(int i) {
        if (i == 0) {
            Y0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z1(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            b.r.d.n r0 = r4.y
            r1 = 0
            r0.f1069b = r1
            r0.f1070c = r5
            androidx.recyclerview.widget.RecyclerView$z r0 = r4.g
            r2 = 1
            if (r0 == 0) goto L12
            boolean r0 = r0.e
            if (r0 == 0) goto L12
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 == 0) goto L33
            int r6 = r6.f177a
            r0 = -1
            if (r6 == r0) goto L33
            boolean r0 = r4.A
            if (r6 >= r5) goto L20
            r5 = 1
            goto L21
        L20:
            r5 = 0
        L21:
            if (r0 != r5) goto L2a
            b.r.d.t r5 = r4.u
            int r5 = r5.l()
            goto L34
        L2a:
            b.r.d.t r5 = r4.u
            int r5 = r5.l()
            r6 = r5
            r5 = 0
            goto L35
        L33:
            r5 = 0
        L34:
            r6 = 0
        L35:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f198b
            if (r0 == 0) goto L3f
            boolean r0 = r0.mClipToPadding
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L59
            b.r.d.n r0 = r4.y
            b.r.d.t r3 = r4.u
            int r3 = r3.k()
            int r3 = r3 - r6
            r0.f = r3
            b.r.d.n r6 = r4.y
            b.r.d.t r0 = r4.u
            int r0 = r0.g()
            int r0 = r0 + r5
            r6.g = r0
            goto L69
        L59:
            b.r.d.n r0 = r4.y
            b.r.d.t r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 + r5
            r0.g = r3
            b.r.d.n r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L69:
            b.r.d.n r5 = r4.y
            r5.h = r1
            r5.f1068a = r2
            b.r.d.t r6 = r4.u
            int r6 = r6.i()
            if (r6 != 0) goto L80
            b.r.d.t r6 = r4.u
            int r6 = r6.f()
            if (r6 != 0) goto L80
            r1 = 1
        L80:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.z1(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }
}
