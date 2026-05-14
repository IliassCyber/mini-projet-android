package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.m.l;
import b.i.m.v.b;
import b.k.b.e;
import c.c.a.a.c.l.q;
import c.c.a.b.d0.g;
import c.c.a.b.j;
import c.c.a.b.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int K = j.Widget_Design_BottomSheet_Modal;
    public int A;
    public WeakReference<V> B;
    public WeakReference<View> C;
    public final ArrayList<d> D;
    public VelocityTracker E;
    public int F;
    public int G;
    public boolean H;
    public Map<View, Integer> I;
    public final e.c J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1980c;
    public int d;
    public boolean e;
    public int f;
    public boolean g;
    public g h;
    public c.c.a.b.d0.j i;
    public boolean j;
    public BottomSheetBehavior<V>.f k;
    public ValueAnimator l;
    public int m;
    public int n;
    public int o;
    public float p;
    public int q;
    public float r;
    public boolean s;
    public boolean t;
    public int u;
    public b.k.b.e v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f1982c;

        public a(View view, int i) {
            this.f1981b = view;
            this.f1982c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.L(this.f1981b, this.f1982c);
        }
    }

    public class b extends e.c {
        public b() {
        }

        @Override // b.k.b.e.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // b.k.b.e.c
        public int b(View view, int i, int i2) {
            int iH = BottomSheetBehavior.this.H();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.a.a.a.a.j(i, iH, bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q);
        }

        @Override // b.k.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q;
        }

        @Override // b.k.b.e.c
        public void f(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.K(1);
            }
        }

        @Override // b.k.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.F(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        
            if (java.lang.Math.abs(r8 - r6.f1983a.o) < java.lang.Math.abs(r8 - r6.f1983a.q)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00cb, code lost:
        
            if (java.lang.Math.abs(r8 - r0) < java.lang.Math.abs(r8 - r6.f1983a.q)) goto L31;
         */
        @Override // b.k.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b.h(android.view.View, float, float):void");
        }

        @Override // b.k.b.e.c
        public boolean i(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.u;
            if (i2 == 1 || bottomSheetBehavior.H) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.F == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.C;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.B;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public class c implements b.i.m.v.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1984a;

        public c(int i) {
            this.f1984a = i;
        }
    }

    public static abstract class d {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    public static class e extends b.k.a.a {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public final int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;

        public static class a implements Parcelable.ClassLoaderCreator<e> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new e(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new e[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
            this.h = parcel.readInt() == 1;
        }

        public e(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.d = bottomSheetBehavior.u;
            this.e = bottomSheetBehavior.d;
            this.f = bottomSheetBehavior.f1979b;
            this.g = bottomSheetBehavior.s;
            this.h = bottomSheetBehavior.t;
        }

        @Override // b.k.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f890b, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f1986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1987c;
        public int d;

        public f(View view, int i) {
            this.f1986b = view;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k.b.e eVar = BottomSheetBehavior.this.v;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.K(this.d);
            } else {
                l.P(this.f1986b, this);
            }
            this.f1987c = false;
        }
    }

    public BottomSheetBehavior() {
        this.f1978a = 0;
        this.f1979b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new b();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.f1978a = 0;
        this.f1979b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.BottomSheetBehavior_Layout);
        this.g = typedArrayObtainStyledAttributes.hasValue(k.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(k.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            E(context, attributeSet, zHasValue, q.z(context, typedArrayObtainStyledAttributes, k.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            E(context, attributeSet, zHasValue, null);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.l.addUpdateListener(new c.c.a.b.o.a(this));
        this.r = typedArrayObtainStyledAttributes.getDimension(k.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(k.BottomSheetBehavior_Layout_behavior_peekHeight);
        I((typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) ? typedArrayObtainStyledAttributes.getDimensionPixelSize(k.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : i);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.s != z) {
            this.s = z;
            if (!z && this.u == 5) {
                J(4);
            }
            P();
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f1979b != z2) {
            this.f1979b = z2;
            if (this.B != null) {
                D();
            }
            K((this.f1979b && this.u == 6) ? 3 : this.u);
            P();
        }
        this.t = typedArrayObtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.f1978a = typedArrayObtainStyledAttributes.getInt(k.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = typedArrayObtainStyledAttributes.getFloat(k.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.p = f2;
        int i2 = typedArrayObtainStyledAttributes.getInt(k.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
        if (i2 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.m = i2;
        typedArrayObtainStyledAttributes.recycle();
        this.f1980c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.u == 1 && actionMasked == 0) {
            return true;
        }
        b.k.b.e eVar = this.v;
        if (eVar != null) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.F = -1;
            VelocityTracker velocityTracker = this.E;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.E = null;
            }
        }
        if (this.E == null) {
            this.E = VelocityTracker.obtain();
        }
        this.E.addMovement(motionEvent);
        if (actionMasked == 2 && !this.w) {
            float fAbs = Math.abs(this.G - motionEvent.getY());
            b.k.b.e eVar2 = this.v;
            if (fAbs > eVar2.f895b) {
                eVar2.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.w;
    }

    public final void C(V v, b.a aVar, int i) {
        l.T(v, aVar, null, new c(i));
    }

    public final void D() {
        int iMax = this.e ? Math.max(this.f, this.A - ((this.z * 9) / 16)) : this.d;
        if (this.f1979b) {
            this.q = Math.max(this.A - iMax, this.n);
        } else {
            this.q = this.A - iMax;
        }
    }

    public final void E(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.g) {
            this.i = c.c.a.b.d0.j.b(context, attributeSet, c.c.a.b.b.bottomSheetStyle, K).a();
            g gVar = new g(this.i);
            this.h = gVar;
            gVar.f1555b.f1559b = new c.c.a.b.v.a(context);
            gVar.x();
            if (z && colorStateList != null) {
                this.h.q(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.h.setTint(typedValue.data);
        }
    }

    public void F(int i) {
        float f2;
        float fH;
        V v = this.B.get();
        if (v == null || this.D.isEmpty()) {
            return;
        }
        int i2 = this.q;
        if (i > i2) {
            f2 = i2 - i;
            fH = this.A - i2;
        } else {
            f2 = i2 - i;
            fH = i2 - H();
        }
        float f3 = f2 / fH;
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            this.D.get(i3).a(v, f3);
        }
    }

    public View G(View view) {
        if (l.F(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewG = G(viewGroup.getChildAt(i));
            if (viewG != null) {
                return viewG;
            }
        }
        return null;
    }

    public final int H() {
        return this.f1979b ? this.n : this.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            if (r4 != r1) goto Lc
            boolean r4 = r3.e
            if (r4 != 0) goto L15
            r3.e = r0
            goto L1f
        Lc:
            boolean r1 = r3.e
            if (r1 != 0) goto L17
            int r1 = r3.d
            if (r1 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L1f
        L17:
            r3.e = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.d = r4
        L1f:
            if (r0 == 0) goto L3a
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.B
            if (r4 == 0) goto L3a
            r3.D()
            int r4 = r3.u
            r0 = 4
            if (r4 != r0) goto L3a
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.B
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L3a
            r4.requestLayout()
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.I(int):void");
    }

    public void J(int i) {
        if (i == this.u) {
            return;
        }
        if (this.B != null) {
            M(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.s && i == 5)) {
            this.u = i;
        }
    }

    public void K(int i) {
        V v;
        if (this.u == i) {
            return;
        }
        this.u = i;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 6 || i == 3) {
            R(true);
        } else if (i == 5 || i == 4) {
            R(false);
        }
        Q(i);
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            this.D.get(i2).b(v, i);
        }
        P();
    }

    public void L(View view, int i) {
        int iH;
        int i2;
        if (i == 4) {
            iH = this.q;
        } else if (i == 6) {
            int i3 = this.o;
            if (!this.f1979b || i3 > (i2 = this.n)) {
                iH = i3;
            } else {
                iH = i2;
                i = 3;
            }
        } else if (i == 3) {
            iH = H();
        } else {
            if (!this.s || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            iH = this.A;
        }
        O(view, i, iH, false);
    }

    public final void M(int i) {
        V v = this.B.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && l.D(v)) {
            v.post(new a(v, i));
        } else {
            L(v, i);
        }
    }

    public boolean N(View view, float f2) {
        if (this.t) {
            return true;
        }
        if (view.getTop() < this.q) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.q)) / ((float) this.d) > 0.5f;
    }

    public void O(View view, int i, int i2, boolean z) {
        boolean zL;
        if (z) {
            zL = this.v.t(view.getLeft(), i2);
        } else {
            b.k.b.e eVar = this.v;
            int left = view.getLeft();
            eVar.r = view;
            eVar.f896c = -1;
            zL = eVar.l(left, i2, 0, 0);
            if (!zL && eVar.f894a == 0 && eVar.r != null) {
                eVar.r = null;
            }
        }
        if (!zL) {
            K(i);
            return;
        }
        K(2);
        Q(i);
        if (this.k == null) {
            this.k = new f(view, i);
        }
        BottomSheetBehavior<V>.f fVar = this.k;
        boolean z2 = fVar.f1987c;
        fVar.d = i;
        if (z2) {
            return;
        }
        l.P(view, fVar);
        this.k.f1987c = true;
    }

    public final void P() {
        V v;
        int i;
        b.a aVar;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        l.R(v, 524288);
        l.R(v, 262144);
        l.R(v, 1048576);
        if (this.s && this.u != 5) {
            C(v, b.a.j, 5);
        }
        int i2 = this.u;
        if (i2 == 3) {
            i = this.f1979b ? 4 : 6;
            aVar = b.a.i;
        } else {
            if (i2 != 4) {
                if (i2 != 6) {
                    return;
                }
                C(v, b.a.i, 4);
                C(v, b.a.h, 3);
                return;
            }
            i = this.f1979b ? 3 : 6;
            aVar = b.a.h;
        }
        C(v, aVar, i);
    }

    public final void Q(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.j != z) {
            this.j = z;
            if (this.h == null || (valueAnimator = this.l) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.l.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.l.setFloatValues(1.0f - f2, f2);
            this.l.start();
        }
    }

    public final void R(boolean z) {
        int iIntValue;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.I != null) {
                    return;
                } else {
                    this.I = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.B.get()) {
                    Map<View, Integer> map = this.I;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        iIntValue = 4;
                    } else if (map != null && map.containsKey(childAt)) {
                        iIntValue = this.I.get(childAt).intValue();
                    }
                    l.d0(childAt, iIntValue);
                }
            }
            if (z) {
                return;
            }
            this.I = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.B = null;
        this.v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.B = null;
        this.v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        b.k.b.e eVar;
        if (!v.isShown()) {
            this.w = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.F = -1;
            VelocityTracker velocityTracker = this.E;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.E = null;
            }
        }
        if (this.E == null) {
            this.E = VelocityTracker.obtain();
        }
        this.E.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.G = (int) motionEvent.getY();
            if (this.u != 2) {
                WeakReference<View> weakReference = this.C;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.j(view, x, this.G)) {
                    this.F = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.H = true;
                }
            }
            this.w = this.F == -1 && !coordinatorLayout.j(v, x, this.G);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.H = false;
            this.F = -1;
            if (this.w) {
                this.w = false;
                return false;
            }
        }
        if (!this.w && (eVar = this.v) != null && eVar.u(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.C;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.w || this.u == 1 || coordinatorLayout.j(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.v == null || Math.abs(((float) this.G) - motionEvent.getY()) <= ((float) this.v.f895b)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        int iH;
        g gVar;
        if (l.o(coordinatorLayout) && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.B == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(c.c.a.b.d.design_bottom_sheet_peek_height_min);
            this.B = new WeakReference<>(v);
            if (this.g && (gVar = this.h) != null) {
                v.setBackground(gVar);
            }
            g gVar2 = this.h;
            if (gVar2 != null) {
                float elevation = this.r;
                if (elevation == -1.0f) {
                    elevation = v.getElevation();
                }
                gVar2.p(elevation);
                boolean z = this.u == 3;
                this.j = z;
                this.h.r(z ? 0.0f : 1.0f);
            }
            P();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
        }
        if (this.v == null) {
            this.v = new b.k.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.J);
        }
        int top = v.getTop();
        coordinatorLayout.q(v, i);
        this.z = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.A = height;
        this.n = Math.max(0, height - v.getHeight());
        this.o = (int) ((1.0f - this.p) * this.A);
        D();
        int i2 = this.u;
        if (i2 == 3) {
            iH = H();
        } else if (i2 == 6) {
            iH = this.o;
        } else if (this.s && i2 == 5) {
            iH = this.A;
        } else {
            int i3 = this.u;
            if (i3 != 4) {
                if (i3 == 1 || i3 == 2) {
                    l.K(v, top - v.getTop());
                }
                this.C = new WeakReference<>(G(v));
                return true;
            }
            iH = this.q;
        }
        l.K(v, iH);
        this.C = new WeakReference<>(G(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.C;
        return (weakReference == null || view != weakReference.get() || this.u == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.C;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < H()) {
                iArr[1] = top - H();
                l.K(v, -iArr[1]);
                i4 = 3;
                K(i4);
            } else {
                iArr[1] = i2;
                l.K(v, -i2);
                K(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.q;
            if (i5 <= i6 || this.s) {
                iArr[1] = i2;
                l.K(v, -i2);
                K(1);
            } else {
                iArr[1] = top - i6;
                l.K(v, -iArr[1]);
                i4 = 4;
                K(i4);
            }
        }
        F(v.getTop());
        this.x = i2;
        this.y = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        e eVar = (e) parcelable;
        int i = this.f1978a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.d = eVar.e;
            }
            int i2 = this.f1978a;
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f1979b = eVar.f;
            }
            int i3 = this.f1978a;
            if (i3 == -1 || (i3 & 4) == 4) {
                this.s = eVar.g;
            }
            int i4 = this.f1978a;
            if (i4 == -1 || (i4 & 8) == 8) {
                this.t = eVar.h;
            }
        }
        int i5 = eVar.d;
        if (i5 == 1 || i5 == 2) {
            this.u = 4;
        } else {
            this.u = i5;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
        return new e((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.x = 0;
        this.y = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(androidx.coordinatorlayout.widget.CoordinatorLayout r2, V r3, android.view.View r4, int r5) {
        /*
            r1 = this;
            int r2 = r3.getTop()
            int r5 = r1.H()
            r0 = 3
            if (r2 != r5) goto Lf
            r1.K(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r2 = r1.C
            if (r2 == 0) goto Lb4
            java.lang.Object r2 = r2.get()
            if (r4 != r2) goto Lb4
            boolean r2 = r1.y
            if (r2 != 0) goto L1f
            goto Lb4
        L1f:
            int r2 = r1.x
            if (r2 <= 0) goto L29
            int r2 = r1.H()
            goto Lae
        L29:
            boolean r2 = r1.s
            if (r2 == 0) goto L4c
            android.view.VelocityTracker r2 = r1.E
            if (r2 != 0) goto L33
            r2 = 0
            goto L42
        L33:
            r4 = 1000(0x3e8, float:1.401E-42)
            float r5 = r1.f1980c
            r2.computeCurrentVelocity(r4, r5)
            android.view.VelocityTracker r2 = r1.E
            int r4 = r1.F
            float r2 = r2.getYVelocity(r4)
        L42:
            boolean r2 = r1.N(r3, r2)
            if (r2 == 0) goto L4c
            int r2 = r1.A
            r0 = 5
            goto Lae
        L4c:
            int r2 = r1.x
            if (r2 != 0) goto L8d
            int r2 = r3.getTop()
            boolean r4 = r1.f1979b
            if (r4 == 0) goto L6c
            int r4 = r1.n
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.q
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lab
            int r2 = r1.n
            goto Lae
        L6c:
            int r4 = r1.o
            if (r2 >= r4) goto L7d
            int r4 = r1.q
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r2 >= r4) goto La7
            int r2 = r1.m
            goto Lae
        L7d:
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.q
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lab
            goto La7
        L8d:
            boolean r2 = r1.f1979b
            if (r2 == 0) goto L92
            goto Lab
        L92:
            int r2 = r3.getTop()
            int r4 = r1.o
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.q
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lab
        La7:
            int r2 = r1.o
            r0 = 6
            goto Lae
        Lab:
            int r2 = r1.q
            r0 = 4
        Lae:
            r4 = 0
            r1.O(r3, r0, r2, r4)
            r1.y = r4
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }
}
