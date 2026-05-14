package b.l.a;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable;
import androidx.fragment.app.Fragment;
import b.l.a.p;
import b.l.a.r;
import b.n.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k extends b.l.a.j implements LayoutInflater.Factory2 {
    public static boolean H = false;
    public static final Interpolator I = new DecelerateInterpolator(2.5f);
    public static final Interpolator J = new DecelerateInterpolator(1.5f);
    public ArrayList<Boolean> A;
    public ArrayList<Fragment> B;
    public ArrayList<j> E;
    public p F;
    public ArrayList<h> d;
    public boolean e;
    public ArrayList<b.l.a.a> i;
    public ArrayList<Fragment> j;
    public OnBackPressedDispatcher k;
    public ArrayList<b.l.a.a> m;
    public ArrayList<Integer> n;
    public b.l.a.i q;
    public b.l.a.f r;
    public Fragment s;
    public Fragment t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ArrayList<b.l.a.a> z;
    public int f = 0;
    public final ArrayList<Fragment> g = new ArrayList<>();
    public final HashMap<String, Fragment> h = new HashMap<>();
    public final b.a.b l = new a(false);
    public final CopyOnWriteArrayList<f> o = new CopyOnWriteArrayList<>();
    public int p = 0;
    public Bundle C = null;
    public SparseArray<Parcelable> D = null;
    public Runnable G = new b();

    public class a extends b.a.b {
        public a(boolean z) {
            super(z);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.P();
        }
    }

    public class c extends b.l.a.h {
        public c() {
        }

        @Override // b.l.a.h
        public Fragment a(ClassLoader classLoader, String str) {
            b.l.a.i iVar = k.this.q;
            Context context = iVar.f908c;
            if (iVar != null) {
                return Fragment.v(context, str, null);
            }
            throw null;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f915b;

        public d(Animator animator) {
            this.f914a = null;
            this.f915b = animator;
        }

        public d(Animation animation) {
            this.f914a = animation;
            this.f915b = null;
        }
    }

    public static class e extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f917c;
        public boolean d;
        public boolean e;
        public boolean f;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f = true;
            this.f916b = viewGroup;
            this.f917c = view;
            addAnimation(animation);
            this.f916b.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f = true;
            if (this.d) {
                return !this.e;
            }
            if (!super.getTransformation(j, transformation)) {
                this.d = true;
                b.i.m.k.a(this.f916b, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f = true;
            if (this.d) {
                return !this.e;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.d = true;
                b.i.m.k.a(this.f916b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d || !this.f) {
                this.f916b.endViewTransition(this.f917c);
                this.e = true;
            } else {
                this.f = false;
                this.f916b.post(this);
            }
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f918a;
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f919a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    public interface h {
        boolean a(ArrayList<b.l.a.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class i implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f920a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f922c;

        public i(String str, int i, int i2) {
            this.f921b = i;
            this.f922c = i2;
        }

        @Override // b.l.a.k.h
        public boolean a(ArrayList<b.l.a.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = k.this.t;
            if (fragment == null || this.f921b >= 0 || this.f920a != null || !fragment.j().d()) {
                return k.this.f0(arrayList, arrayList2, this.f920a, this.f921b, this.f922c);
            }
            return false;
        }
    }

    public static class j implements Fragment.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b.l.a.a f924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f925c;

        public j(b.l.a.a aVar, boolean z) {
            this.f923a = z;
            this.f924b = aVar;
        }

        public void a() {
            boolean z = this.f925c > 0;
            k kVar = this.f924b.r;
            int size = kVar.g.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = kVar.g.get(i);
                fragment.W(null);
                if (z) {
                    Fragment.b bVar = fragment.K;
                    if (bVar == null ? false : bVar.q) {
                        fragment.Y();
                    }
                }
            }
            b.l.a.a aVar = this.f924b;
            aVar.r.k(aVar, this.f923a, !z, true);
        }
    }

    public static d a0(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(I);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(J);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new d(animationSet);
    }

    public static int k0(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public void A(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.A(fragment, bundle, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void B(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.B(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void C(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.C(fragment, bundle, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void D(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.D(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void E(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.E(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void F(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.F(fragment, view, bundle, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void G(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.G(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public boolean H(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                if (!fragment.z && fragment.u.H(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void I(Menu menu) {
        if (this.p < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null && !fragment.z) {
                fragment.u.I(menu);
            }
        }
    }

    public final void J(Fragment fragment) {
        if (fragment == null || this.h.get(fragment.f) != fragment) {
            return;
        }
        boolean zX = fragment.s.X(fragment);
        Boolean bool = fragment.k;
        if (bool == null || bool.booleanValue() != zX) {
            fragment.k = Boolean.valueOf(zX);
            k kVar = fragment.u;
            kVar.s0();
            kVar.J(kVar.t);
        }
    }

    public void K(boolean z) {
        int size = this.g.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.g.get(size);
            if (fragment != null) {
                fragment.u.K(z);
            }
        }
    }

    public boolean L(Menu menu) {
        if (this.p < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null && fragment.O(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void M(int i2) {
        try {
            this.e = true;
            c0(i2, false);
            this.e = false;
            P();
        } catch (Throwable th) {
            this.e = false;
            throw th;
        }
    }

    public void N(h hVar, boolean z) {
        if (!z) {
            i();
        }
        synchronized (this) {
            if (!this.x && this.q != null) {
                if (this.d == null) {
                    this.d = new ArrayList<>();
                }
                this.d.add(hVar);
                n0();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void O(boolean z) {
        if (this.e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.q == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.q.d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            i();
        }
        if (this.z == null) {
            this.z = new ArrayList<>();
            this.A = new ArrayList<>();
        }
        this.e = true;
        try {
            R(null, null);
        } finally {
            this.e = false;
        }
    }

    public boolean P() {
        boolean zA;
        O(true);
        boolean z = false;
        while (true) {
            ArrayList<b.l.a.a> arrayList = this.z;
            ArrayList<Boolean> arrayList2 = this.A;
            synchronized (this) {
                if (this.d == null || this.d.size() == 0) {
                    zA = false;
                } else {
                    int size = this.d.size();
                    zA = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        zA |= this.d.get(i2).a(arrayList, arrayList2);
                    }
                    this.d.clear();
                    this.q.d.removeCallbacks(this.G);
                }
            }
            if (!zA) {
                break;
            }
            this.e = true;
            try {
                h0(this.z, this.A);
                j();
                z = true;
            } catch (Throwable th) {
                j();
                throw th;
            }
        }
        s0();
        if (this.y) {
            this.y = false;
            q0();
        }
        this.h.values().removeAll(Collections.singleton(null));
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(java.util.ArrayList<b.l.a.a> r20, java.util.ArrayList<java.lang.Boolean> r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.k.Q(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final void R(ArrayList<b.l.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<j> arrayList3 = this.E;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.E.get(i2);
            if (arrayList == null || jVar.f923a || (iIndexOf2 = arrayList.indexOf(jVar.f924b)) == -1 || !arrayList2.get(iIndexOf2).booleanValue()) {
                if ((jVar.f925c == 0) || (arrayList != null && jVar.f924b.n(arrayList, 0, arrayList.size()))) {
                    this.E.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || jVar.f923a || (iIndexOf = arrayList.indexOf(jVar.f924b)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                        jVar.a();
                    }
                }
                i2++;
            } else {
                this.E.remove(i2);
                i2--;
                size--;
            }
            b.l.a.a aVar = jVar.f924b;
            aVar.r.k(aVar, jVar.f923a, false, false);
            i2++;
        }
    }

    public Fragment S(int i2) {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.g.get(size);
            if (fragment != null && fragment.w == i2) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.h.values()) {
            if (fragment2 != null && fragment2.w == i2) {
                return fragment2;
            }
        }
        return null;
    }

    public Fragment T(String str) {
        for (Fragment fragmentT : this.h.values()) {
            if (fragmentT != null) {
                if (!str.equals(fragmentT.f)) {
                    fragmentT = fragmentT.u.T(str);
                }
                if (fragmentT != null) {
                    return fragmentT;
                }
            }
        }
        return null;
    }

    public final void U() {
        if (this.E != null) {
            while (!this.E.isEmpty()) {
                this.E.remove(0).a();
            }
        }
    }

    public b.l.a.h V() {
        if (this.f910b == null) {
            this.f910b = b.l.a.j.f909c;
        }
        if (this.f910b == b.l.a.j.f909c) {
            Fragment fragment = this.s;
            if (fragment != null) {
                return fragment.s.V();
            }
            this.f910b = new c();
        }
        if (this.f910b == null) {
            this.f910b = b.l.a.j.f909c;
        }
        return this.f910b;
    }

    public final boolean W(Fragment fragment) {
        boolean z;
        k kVar = fragment.u;
        Iterator<Fragment> it = kVar.h.values().iterator();
        boolean zW = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment next = it.next();
            if (next != null) {
                zW = kVar.W(next);
            }
            if (zW) {
                z = true;
                break;
            }
        }
        return z;
    }

    public boolean X(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        k kVar = fragment.s;
        return fragment == kVar.t && X(kVar.s);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.l.a.k.d Y(androidx.fragment.app.Fragment r7, int r8, boolean r9, int r10) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.k.Y(androidx.fragment.app.Fragment, int, boolean, int):b.l.a.k$d");
    }

    public void Z(Fragment fragment) {
        if (this.h.get(fragment.f) != null) {
            return;
        }
        this.h.put(fragment.f, fragment);
        if (fragment.C) {
            if (!fragment.B) {
                i0(fragment);
            } else if (!c()) {
                this.F.f938b.add(fragment);
            }
            fragment.C = false;
        }
    }

    @Override // b.l.a.j
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2;
        String strC = c.a.a.a.a.c(str, "    ");
        if (!this.h.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.h.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    printWriter.print(strC);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(fragment.w));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(fragment.x));
                    printWriter.print(" mTag=");
                    printWriter.println(fragment.y);
                    printWriter.print(strC);
                    printWriter.print("mState=");
                    printWriter.print(fragment.f141b);
                    printWriter.print(" mWho=");
                    printWriter.print(fragment.f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(fragment.r);
                    printWriter.print(strC);
                    printWriter.print("mAdded=");
                    printWriter.print(fragment.l);
                    printWriter.print(" mRemoving=");
                    printWriter.print(fragment.m);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(fragment.n);
                    printWriter.print(" mInLayout=");
                    printWriter.println(fragment.o);
                    printWriter.print(strC);
                    printWriter.print("mHidden=");
                    printWriter.print(fragment.z);
                    printWriter.print(" mDetached=");
                    printWriter.print(fragment.A);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(fragment.D);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(strC);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(fragment.B);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(fragment.J);
                    if (fragment.s != null) {
                        printWriter.print(strC);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(fragment.s);
                    }
                    if (fragment.t != null) {
                        printWriter.print(strC);
                        printWriter.print("mHost=");
                        printWriter.println(fragment.t);
                    }
                    if (fragment.v != null) {
                        printWriter.print(strC);
                        printWriter.print("mParentFragment=");
                        printWriter.println(fragment.v);
                    }
                    if (fragment.g != null) {
                        printWriter.print(strC);
                        printWriter.print("mArguments=");
                        printWriter.println(fragment.g);
                    }
                    if (fragment.f142c != null) {
                        printWriter.print(strC);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(fragment.f142c);
                    }
                    if (fragment.d != null) {
                        printWriter.print(strC);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(fragment.d);
                    }
                    Object obj = fragment.h;
                    if (obj == null) {
                        k kVar = fragment.s;
                        obj = (kVar == null || (str2 = fragment.i) == null) ? null : (Fragment) kVar.h.get(str2);
                    }
                    if (obj != null) {
                        printWriter.print(strC);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(fragment.j);
                    }
                    if (fragment.n() != 0) {
                        printWriter.print(strC);
                        printWriter.print("mNextAnim=");
                        printWriter.println(fragment.n());
                    }
                    if (fragment.F != null) {
                        printWriter.print(strC);
                        printWriter.print("mContainer=");
                        printWriter.println(fragment.F);
                    }
                    if (fragment.G != null) {
                        printWriter.print(strC);
                        printWriter.print("mView=");
                        printWriter.println(fragment.G);
                    }
                    if (fragment.H != null) {
                        printWriter.print(strC);
                        printWriter.print("mInnerView=");
                        printWriter.println(fragment.G);
                    }
                    if (fragment.h() != null) {
                        printWriter.print(strC);
                        printWriter.print("mAnimatingAway=");
                        printWriter.println(fragment.h());
                        printWriter.print(strC);
                        printWriter.print("mStateAfterAnimating=");
                        printWriter.println(fragment.s());
                    }
                    if (fragment.k() != null) {
                        b.o.a.a.b(fragment).a(strC, fileDescriptor, printWriter, strArr);
                    }
                    printWriter.print(strC);
                    printWriter.println("Child " + fragment.u + ":");
                    fragment.u.a(c.a.a.a.a.c(strC, "  "), fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.g.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.j;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.j.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<b.l.a.a> arrayList2 = this.i;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                b.l.a.a aVar = this.i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j(strC, printWriter, true);
            }
        }
        synchronized (this) {
            if (this.m != null && (size2 = this.m.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj2 = (b.l.a.a) this.m.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj2);
                }
            }
            if (this.n != null && this.n.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.n.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj3 = (h) this.d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj3);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.r);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.v);
        printWriter.print(" mStopped=");
        printWriter.print(this.w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.x);
        if (this.u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.u);
        }
    }

    @Override // b.l.a.j
    public Fragment b(String str) {
        int size = this.g.size();
        while (true) {
            size--;
            if (size < 0) {
                for (Fragment fragment : this.h.values()) {
                    if (fragment != null && str.equals(fragment.y)) {
                        return fragment;
                    }
                }
                return null;
            }
            Fragment fragment2 = this.g.get(size);
            if (fragment2 != null && str.equals(fragment2.y)) {
                return fragment2;
            }
        }
    }

    public void b0(Fragment fragment) {
        Animator animator;
        if (fragment != null && this.h.containsKey(fragment.f)) {
            int iMin = this.p;
            if (fragment.m) {
                iMin = fragment.x() ? Math.min(iMin, 1) : Math.min(iMin, 0);
            }
            d0(fragment, iMin, fragment.o(), fragment.p(), false);
            View view = fragment.G;
            if (view != null) {
                ViewGroup viewGroup = fragment.F;
                Fragment fragment2 = null;
                if (viewGroup != null && view != null) {
                    int iIndexOf = this.g.indexOf(fragment);
                    while (true) {
                        iIndexOf--;
                        if (iIndexOf < 0) {
                            break;
                        }
                        Fragment fragment3 = this.g.get(iIndexOf);
                        if (fragment3.F == viewGroup && fragment3.G != null) {
                            fragment2 = fragment3;
                            break;
                        }
                    }
                }
                if (fragment2 != null) {
                    View view2 = fragment2.G;
                    ViewGroup viewGroup2 = fragment.F;
                    int iIndexOfChild = viewGroup2.indexOfChild(view2);
                    int iIndexOfChild2 = viewGroup2.indexOfChild(fragment.G);
                    if (iIndexOfChild2 < iIndexOfChild) {
                        viewGroup2.removeViewAt(iIndexOfChild2);
                        viewGroup2.addView(fragment.G, iIndexOfChild);
                    }
                }
                if (fragment.L && fragment.F != null) {
                    float f2 = fragment.N;
                    if (f2 > 0.0f) {
                        fragment.G.setAlpha(f2);
                    }
                    fragment.N = 0.0f;
                    fragment.L = false;
                    d dVarY = Y(fragment, fragment.o(), true, fragment.p());
                    if (dVarY != null) {
                        Animation animation = dVarY.f914a;
                        if (animation != null) {
                            fragment.G.startAnimation(animation);
                        } else {
                            dVarY.f915b.setTarget(fragment.G);
                            dVarY.f915b.start();
                        }
                    }
                }
            }
            if (fragment.M) {
                if (fragment.G != null) {
                    d dVarY2 = Y(fragment, fragment.o(), !fragment.z, fragment.p());
                    if (dVarY2 == null || (animator = dVarY2.f915b) == null) {
                        if (dVarY2 != null) {
                            fragment.G.startAnimation(dVarY2.f914a);
                            dVarY2.f914a.start();
                        }
                        fragment.G.setVisibility((!fragment.z || fragment.w()) ? 0 : 8);
                        if (fragment.w()) {
                            fragment.U(false);
                        }
                    } else {
                        animator.setTarget(fragment.G);
                        if (!fragment.z) {
                            fragment.G.setVisibility(0);
                        } else if (fragment.w()) {
                            fragment.U(false);
                        } else {
                            ViewGroup viewGroup3 = fragment.F;
                            View view3 = fragment.G;
                            viewGroup3.startViewTransition(view3);
                            dVarY2.f915b.addListener(new n(this, viewGroup3, view3, fragment));
                        }
                        dVarY2.f915b.start();
                    }
                }
                if (fragment.l && W(fragment)) {
                    this.u = true;
                }
                fragment.M = false;
            }
        }
    }

    @Override // b.l.a.j
    public boolean c() {
        return this.v || this.w;
    }

    public void c0(int i2, boolean z) {
        b.l.a.i iVar;
        if (this.q == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.p) {
            this.p = i2;
            int size = this.g.size();
            for (int i3 = 0; i3 < size; i3++) {
                b0(this.g.get(i3));
            }
            for (Fragment fragment : this.h.values()) {
                if (fragment != null && (fragment.m || fragment.A)) {
                    if (!fragment.L) {
                        b0(fragment);
                    }
                }
            }
            q0();
            if (this.u && (iVar = this.q) != null && this.p == 4) {
                b.l.a.e.this.p();
                this.u = false;
            }
        }
    }

    @Override // b.l.a.j
    public boolean d() {
        i();
        P();
        O(true);
        Fragment fragment = this.t;
        if (fragment != null && fragment.j().d()) {
            return true;
        }
        boolean zF0 = f0(this.z, this.A, null, -1, 0);
        if (zF0) {
            this.e = true;
            try {
                h0(this.z, this.A);
            } finally {
                j();
            }
        }
        s0();
        if (this.y) {
            this.y = false;
            q0();
        }
        this.h.values().removeAll(Collections.singleton(null));
        return zF0;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:363:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d0(androidx.fragment.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 1844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.k.d0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    public final void e(b.f.c<Fragment> cVar) {
        int i2 = this.p;
        if (i2 < 1) {
            return;
        }
        int iMin = Math.min(i2, 3);
        int size = this.g.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.g.get(i3);
            if (fragment.f141b < iMin) {
                d0(fragment, iMin, fragment.n(), fragment.o(), false);
                if (fragment.G != null && !fragment.z && fragment.L) {
                    cVar.add(fragment);
                }
            }
        }
    }

    public void e0() {
        this.v = false;
        this.w = false;
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.u.e0();
            }
        }
    }

    public void f(Fragment fragment, boolean z) {
        Z(fragment);
        if (fragment.A) {
            return;
        }
        if (this.g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.g) {
            this.g.add(fragment);
        }
        fragment.l = true;
        fragment.m = false;
        if (fragment.G == null) {
            fragment.M = false;
        }
        if (W(fragment)) {
            this.u = true;
        }
        if (z) {
            d0(fragment, this.p, 0, 0, false);
        }
    }

    public boolean f0(ArrayList<b.l.a.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<b.l.a.a> arrayList3 = this.i;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.i.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    b.l.a.a aVar = this.i.get(size2);
                    if ((str != null && str.equals(aVar.i)) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        b.l.a.a aVar2 = this.i.get(size2);
                        if (str == null || !str.equals(aVar2.i)) {
                            if (i2 < 0 || i2 != aVar2.t) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.i.size() - 1) {
                return false;
            }
            for (int size3 = this.i.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.i.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g(b.l.a.i iVar, b.l.a.f fVar, Fragment fragment) {
        if (this.q != null) {
            throw new IllegalStateException("Already attached");
        }
        this.q = iVar;
        this.r = fVar;
        this.s = fragment;
        if (fragment != null) {
            s0();
        }
        if (iVar instanceof b.a.c) {
            b.a.c cVar = (b.a.c) iVar;
            this.k = cVar.d();
            b.n.g gVar = cVar;
            if (fragment != null) {
                gVar = fragment;
            }
            OnBackPressedDispatcher onBackPressedDispatcher = this.k;
            b.a.b bVar = this.l;
            if (onBackPressedDispatcher == null) {
                throw null;
            }
            b.n.d dVarA = gVar.a();
            if (((b.n.h) dVarA).f987b != d.b.DESTROYED) {
                bVar.f240b.add(onBackPressedDispatcher.new LifecycleOnBackPressedCancellable(dVarA, bVar));
            }
        }
        if (fragment != null) {
            p pVar = fragment.s.F;
            p pVar2 = pVar.f939c.get(fragment.f);
            if (pVar2 == null) {
                pVar2 = new p(pVar.e);
                pVar.f939c.put(fragment.f, pVar2);
            }
            this.F = pVar2;
            return;
        }
        if (!(iVar instanceof b.n.t)) {
            this.F = new p(false);
            return;
        }
        b.n.s sVarF = ((b.n.t) iVar).f();
        b.n.q qVar = p.h;
        String canonicalName = p.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        String strC = c.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
        b.n.p pVarA = sVarF.f995a.get(strC);
        if (!p.class.isInstance(pVarA)) {
            pVarA = qVar instanceof b.n.r ? ((b.n.r) qVar).a(strC, p.class) : ((p.a) qVar).a(p.class);
            b.n.p pVarPut = sVarF.f995a.put(strC, pVarA);
            if (pVarPut != null) {
                pVarPut.a();
            }
        }
        this.F = (p) pVarA;
    }

    public void g0(Fragment fragment) {
        boolean z = !fragment.x();
        if (!fragment.A || z) {
            synchronized (this.g) {
                this.g.remove(fragment);
            }
            if (W(fragment)) {
                this.u = true;
            }
            fragment.l = false;
            fragment.m = true;
        }
    }

    public void h(Fragment fragment) {
        if (fragment.A) {
            fragment.A = false;
            if (fragment.l) {
                return;
            }
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            synchronized (this.g) {
                this.g.add(fragment);
            }
            fragment.l = true;
            if (W(fragment)) {
                this.u = true;
            }
        }
    }

    public final void h0(ArrayList<b.l.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        R(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).p) {
                if (i3 != i2) {
                    Q(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                        i3++;
                    }
                }
                Q(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            Q(arrayList, arrayList2, i3, size);
        }
    }

    public final void i() {
        if (c()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void i0(Fragment fragment) {
        if (c()) {
            return;
        }
        this.F.f938b.remove(fragment);
    }

    public final void j() {
        this.e = false;
        this.A.clear();
        this.z.clear();
    }

    public void j0(Parcelable parcelable) {
        Fragment fragment;
        Bundle bundle;
        q next;
        if (parcelable == null) {
            return;
        }
        o oVar = (o) parcelable;
        if (oVar.f936b == null) {
            return;
        }
        for (Fragment fragment2 : this.F.f938b) {
            Iterator<q> it = oVar.f936b.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.f941c.equals(fragment2.f)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next == null) {
                d0(fragment2, 1, 0, 0, false);
                fragment2.m = true;
                d0(fragment2, 0, 0, 0, false);
            } else {
                next.o = fragment2;
                fragment2.d = null;
                fragment2.r = 0;
                fragment2.o = false;
                fragment2.l = false;
                Fragment fragment3 = fragment2.h;
                fragment2.i = fragment3 != null ? fragment3.f : null;
                fragment2.h = null;
                Bundle bundle2 = next.n;
                if (bundle2 != null) {
                    bundle2.setClassLoader(this.q.f908c.getClassLoader());
                    fragment2.d = next.n.getSparseParcelableArray("android:view_state");
                    fragment2.f142c = next.n;
                }
            }
        }
        this.h.clear();
        for (q qVar : oVar.f936b) {
            if (qVar != null) {
                ClassLoader classLoader = this.q.f908c.getClassLoader();
                b.l.a.h hVarV = V();
                if (qVar.o == null) {
                    Bundle bundle3 = qVar.k;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(classLoader);
                    }
                    Fragment fragmentA = hVarV.a(classLoader, qVar.f940b);
                    qVar.o = fragmentA;
                    fragmentA.T(qVar.k);
                    Bundle bundle4 = qVar.n;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(classLoader);
                        fragment = qVar.o;
                        bundle = qVar.n;
                    } else {
                        fragment = qVar.o;
                        bundle = new Bundle();
                    }
                    fragment.f142c = bundle;
                    Fragment fragment4 = qVar.o;
                    fragment4.f = qVar.f941c;
                    fragment4.n = qVar.d;
                    fragment4.p = true;
                    fragment4.w = qVar.e;
                    fragment4.x = qVar.f;
                    fragment4.y = qVar.g;
                    fragment4.B = qVar.h;
                    fragment4.m = qVar.i;
                    fragment4.A = qVar.j;
                    fragment4.z = qVar.l;
                    fragment4.Q = d.b.values()[qVar.m];
                }
                Fragment fragment5 = qVar.o;
                fragment5.s = this;
                this.h.put(fragment5.f, fragment5);
                qVar.o = null;
            }
        }
        this.g.clear();
        ArrayList<String> arrayList = oVar.f937c;
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragment6 = this.h.get(str);
                if (fragment6 == null) {
                    r0(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                    throw null;
                }
                fragment6.l = true;
                if (this.g.contains(fragment6)) {
                    throw new IllegalStateException("Already added " + fragment6);
                }
                synchronized (this.g) {
                    this.g.add(fragment6);
                }
            }
        }
        if (oVar.d != null) {
            this.i = new ArrayList<>(oVar.d.length);
            int i2 = 0;
            while (true) {
                b.l.a.b[] bVarArr = oVar.d;
                if (i2 >= bVarArr.length) {
                    break;
                }
                b.l.a.b bVar = bVarArr[i2];
                if (bVar == null) {
                    throw null;
                }
                b.l.a.a aVar = new b.l.a.a(this);
                int i3 = 0;
                int i4 = 0;
                while (i3 < bVar.f900b.length) {
                    r.a aVar2 = new r.a();
                    int i5 = i3 + 1;
                    aVar2.f945a = bVar.f900b[i3];
                    String str2 = bVar.f901c.get(i4);
                    aVar2.f946b = str2 != null ? this.h.get(str2) : null;
                    aVar2.g = d.b.values()[bVar.d[i4]];
                    aVar2.h = d.b.values()[bVar.e[i4]];
                    int[] iArr = bVar.f900b;
                    int i6 = i5 + 1;
                    int i7 = iArr[i5];
                    aVar2.f947c = i7;
                    int i8 = i6 + 1;
                    int i9 = iArr[i6];
                    aVar2.d = i9;
                    int i10 = i8 + 1;
                    int i11 = iArr[i8];
                    aVar2.e = i11;
                    int i12 = iArr[i10];
                    aVar2.f = i12;
                    aVar.f943b = i7;
                    aVar.f944c = i9;
                    aVar.d = i11;
                    aVar.e = i12;
                    aVar.c(aVar2);
                    i4++;
                    i3 = i10 + 1;
                }
                aVar.f = bVar.f;
                aVar.g = bVar.g;
                aVar.i = bVar.h;
                aVar.t = bVar.i;
                aVar.h = true;
                aVar.j = bVar.j;
                aVar.k = bVar.k;
                aVar.l = bVar.l;
                aVar.m = bVar.m;
                aVar.n = bVar.n;
                aVar.o = bVar.o;
                aVar.p = bVar.p;
                aVar.h(1);
                this.i.add(aVar);
                int i13 = aVar.t;
                if (i13 >= 0) {
                    synchronized (this) {
                        if (this.m == null) {
                            this.m = new ArrayList<>();
                        }
                        int size = this.m.size();
                        if (i13 < size) {
                            this.m.set(i13, aVar);
                        } else {
                            while (size < i13) {
                                this.m.add(null);
                                if (this.n == null) {
                                    this.n = new ArrayList<>();
                                }
                                this.n.add(Integer.valueOf(size));
                                size++;
                            }
                            this.m.add(aVar);
                        }
                    }
                }
                i2++;
            }
        } else {
            this.i = null;
        }
        String str3 = oVar.e;
        if (str3 != null) {
            Fragment fragment7 = this.h.get(str3);
            this.t = fragment7;
            J(fragment7);
        }
        this.f = oVar.f;
    }

    public void k(b.l.a.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.l(z3);
        } else {
            aVar.k();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            w.p(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            c0(this.p, true);
        }
        for (Fragment fragment : this.h.values()) {
            if (fragment != null && fragment.G != null && fragment.L && aVar.m(fragment.x)) {
                float f2 = fragment.N;
                if (f2 > 0.0f) {
                    fragment.G.setAlpha(f2);
                }
                if (z3) {
                    fragment.N = 0.0f;
                } else {
                    fragment.N = -1.0f;
                    fragment.L = false;
                }
            }
        }
    }

    public void l(Fragment fragment) {
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.l) {
            synchronized (this.g) {
                this.g.remove(fragment);
            }
            if (W(fragment)) {
                this.u = true;
            }
            fragment.l = false;
        }
    }

    public Parcelable l0() {
        b.l.a.b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        Bundle bundle;
        U();
        Iterator<Fragment> it = this.h.values().iterator();
        while (true) {
            bVarArr = null;
            if (!it.hasNext()) {
                break;
            }
            Fragment next = it.next();
            if (next != null) {
                if (next.h() != null) {
                    int iS = next.s();
                    View viewH = next.h();
                    Animation animation = viewH.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewH.clearAnimation();
                    }
                    next.R(null);
                    d0(next, iS, 0, 0, false);
                } else if (next.i() != null) {
                    next.i().end();
                }
            }
        }
        P();
        this.v = true;
        if (this.h.isEmpty()) {
            return null;
        }
        ArrayList<q> arrayList2 = new ArrayList<>(this.h.size());
        boolean z = false;
        for (Fragment fragment : this.h.values()) {
            if (fragment != null) {
                if (fragment.s != this) {
                    r0(new IllegalStateException(c.a.a.a.a.b("Failure saving state: active ", fragment, " was removed from the FragmentManager")));
                    throw null;
                }
                q qVar = new q(fragment);
                arrayList2.add(qVar);
                if (fragment.f141b <= 0 || qVar.n != null) {
                    qVar.n = fragment.f142c;
                } else {
                    if (this.C == null) {
                        this.C = new Bundle();
                    }
                    Bundle bundle2 = this.C;
                    fragment.I(bundle2);
                    fragment.U.b(bundle2);
                    Parcelable parcelableL0 = fragment.u.l0();
                    if (parcelableL0 != null) {
                        bundle2.putParcelable("android:support:fragments", parcelableL0);
                    }
                    C(fragment, this.C, false);
                    if (this.C.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.C;
                        this.C = null;
                    }
                    if (fragment.G != null) {
                        m0(fragment);
                    }
                    if (fragment.d != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", fragment.d);
                    }
                    if (!fragment.J) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", fragment.J);
                    }
                    qVar.n = bundle;
                    String str = fragment.i;
                    if (str != null) {
                        Fragment fragment2 = this.h.get(str);
                        if (fragment2 == null) {
                            r0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.i));
                            throw null;
                        }
                        if (qVar.n == null) {
                            qVar.n = new Bundle();
                        }
                        Bundle bundle3 = qVar.n;
                        if (fragment2.s != this) {
                            r0(new IllegalStateException(c.a.a.a.a.b("Fragment ", fragment2, " is not currently in the FragmentManager")));
                            throw null;
                        }
                        bundle3.putString("android:target_state", fragment2.f);
                        int i2 = fragment.j;
                        if (i2 != 0) {
                            qVar.n.putInt("android:target_req_state", i2);
                        }
                    }
                }
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        int size2 = this.g.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            for (Fragment fragment3 : this.g) {
                arrayList.add(fragment3.f);
                if (fragment3.s != this) {
                    r0(new IllegalStateException(c.a.a.a.a.b("Failure saving state: active ", fragment3, " was removed from the FragmentManager")));
                    throw null;
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<b.l.a.a> arrayList3 = this.i;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b.l.a.b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new b.l.a.b(this.i.get(i3));
            }
        }
        o oVar = new o();
        oVar.f936b = arrayList2;
        oVar.f937c = arrayList;
        oVar.d = bVarArr;
        Fragment fragment4 = this.t;
        if (fragment4 != null) {
            oVar.e = fragment4.f;
        }
        oVar.f = this.f;
        return oVar;
    }

    public void m(Configuration configuration) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.E = true;
                fragment.u.m(configuration);
            }
        }
    }

    public void m0(Fragment fragment) {
        if (fragment.H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.D;
        if (sparseArray == null) {
            this.D = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.H.saveHierarchyState(this.D);
        if (this.D.size() > 0) {
            fragment.d = this.D;
            this.D = null;
        }
    }

    public boolean n(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                if (!fragment.z && fragment.u.n(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void n0() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.E == null || this.E.isEmpty()) ? false : true;
            if (this.d != null && this.d.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.q.d.removeCallbacks(this.G);
                this.q.d.post(this.G);
                s0();
            }
        }
    }

    public void o() {
        this.v = false;
        this.w = false;
        M(1);
    }

    public void o0(Fragment fragment, d.b bVar) {
        if (this.h.get(fragment.f) == fragment && (fragment.t == null || fragment.s == this)) {
            fragment.Q = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f919a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !b.l.a.h.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment fragmentS = resourceId != -1 ? S(resourceId) : null;
        if (fragmentS == null && string != null) {
            fragmentS = b(string);
        }
        if (fragmentS == null && id != -1) {
            fragmentS = S(id);
        }
        if (fragmentS == null) {
            fragmentS = V().a(context.getClassLoader(), str2);
            fragmentS.n = true;
            fragmentS.w = resourceId != 0 ? resourceId : id;
            fragmentS.x = id;
            fragmentS.y = string;
            fragmentS.o = true;
            fragmentS.s = this;
            b.l.a.i iVar = this.q;
            fragmentS.t = iVar;
            Context context2 = iVar.f908c;
            fragmentS.F(attributeSet, fragmentS.f142c);
            f(fragmentS, true);
        } else {
            if (fragmentS.o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            fragmentS.o = true;
            b.l.a.i iVar2 = this.q;
            fragmentS.t = iVar2;
            Context context3 = iVar2.f908c;
            fragmentS.F(attributeSet, fragmentS.f142c);
        }
        Fragment fragment = fragmentS;
        if (this.p >= 1 || !fragment.n) {
            d0(fragment, this.p, 0, 0, false);
        } else {
            d0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.G;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.G.getTag() == null) {
                fragment.G.setTag(string);
            }
            return fragment.G;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public boolean p(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null && fragment.L(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.j != null) {
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                Fragment fragment2 = this.j.get(i3);
                if ((arrayList == null || !arrayList.contains(fragment2)) && fragment2 == null) {
                    throw null;
                }
            }
        }
        this.j = arrayList;
        return z;
    }

    public void p0(Fragment fragment) {
        if (fragment == null || (this.h.get(fragment.f) == fragment && (fragment.t == null || fragment.s == this))) {
            Fragment fragment2 = this.t;
            this.t = fragment;
            J(fragment2);
            J(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void q() {
        this.x = true;
        P();
        M(0);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.k != null) {
            Iterator<b.a.a> it = this.l.f240b.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.k = null;
        }
    }

    public void q0() {
        for (Fragment fragment : this.h.values()) {
            if (fragment != null && fragment.I) {
                if (this.e) {
                    this.y = true;
                } else {
                    fragment.I = false;
                    d0(fragment, this.p, 0, 0, false);
                }
            }
        }
    }

    public void r() {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            Fragment fragment = this.g.get(i2);
            if (fragment != null) {
                fragment.N();
            }
        }
    }

    public final void r0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b.i.l.a("FragmentManager"));
        b.l.a.i iVar = this.q;
        try {
            if (iVar != null) {
                b.l.a.e.this.dump("  ", null, printWriter, new String[0]);
            } else {
                a("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public void s(boolean z) {
        int size = this.g.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.g.get(size);
            if (fragment != null) {
                fragment.u.s(z);
            }
        }
    }

    public final void s0() {
        ArrayList<h> arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.l.f239a = true;
            return;
        }
        b.a.b bVar = this.l;
        ArrayList<b.l.a.a> arrayList2 = this.i;
        bVar.f239a = (arrayList2 != null ? arrayList2.size() : 0) > 0 && X(this.s);
    }

    public void t(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.t(fragment, bundle, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.s;
        if (obj == null) {
            obj = this.q;
        }
        a.a.a.a.a.d(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.u(fragment, context, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void v(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.v(fragment, bundle, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void w(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.w(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void x(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.x(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void y(Fragment fragment, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.y(fragment, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }

    public void z(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.s;
        if (fragment2 != null) {
            k kVar = fragment2.s;
            if (kVar instanceof k) {
                kVar.z(fragment, context, true);
            }
        }
        for (f fVar : this.o) {
            if (!z || fVar.f918a) {
                throw null;
            }
        }
    }
}
