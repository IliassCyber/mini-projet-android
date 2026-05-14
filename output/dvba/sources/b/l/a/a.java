package b.l.a;

import androidx.fragment.app.Fragment;
import b.l.a.k;
import b.l.a.r;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends r implements k.h {
    public final k r;
    public boolean s;
    public int t = -1;

    public a(k kVar) {
        this.r = kVar;
    }

    public static boolean o(r.a aVar) {
        Fragment fragment = aVar.f946b;
        if (fragment == null || !fragment.l || fragment.G == null || fragment.A || fragment.z) {
            return false;
        }
        Fragment.b bVar = fragment.K;
        return bVar == null ? false : bVar.q;
    }

    @Override // b.l.a.k.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        boolean z = k.H;
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.h) {
            return true;
        }
        k kVar = this.r;
        if (kVar.i == null) {
            kVar.i = new ArrayList<>();
        }
        kVar.i.add(this);
        return true;
    }

    @Override // b.l.a.r
    public int e() {
        return i(true);
    }

    @Override // b.l.a.r
    public r f(Fragment fragment) {
        k kVar = fragment.s;
        if (kVar == null || kVar == this.r) {
            c(new r.a(6, fragment));
            return this;
        }
        StringBuilder sbE = c.a.a.a.a.e("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        sbE.append(fragment.toString());
        sbE.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbE.toString());
    }

    @Override // b.l.a.r
    public void g(int i, Fragment fragment, String str, int i2) {
        super.g(i, fragment, str, i2);
        fragment.s = this.r;
    }

    public void h(int i) {
        if (this.h) {
            boolean z = k.H;
            int size = this.f942a.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f942a.get(i2).f946b;
                if (fragment != null) {
                    fragment.r += i;
                    boolean z2 = k.H;
                }
            }
        }
    }

    public int i(boolean z) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        boolean z2 = k.H;
        this.s = true;
        int size = -1;
        if (this.h) {
            k kVar = this.r;
            synchronized (kVar) {
                if (kVar.n == null || kVar.n.size() <= 0) {
                    if (kVar.m == null) {
                        kVar.m = new ArrayList<>();
                    }
                    size = kVar.m.size();
                    kVar.m.add(this);
                } else {
                    size = kVar.n.remove(kVar.n.size() - 1).intValue();
                    kVar.m.set(size, this);
                }
            }
        }
        this.t = size;
        this.r.N(this, z);
        return this.t;
    }

    public void j(String str, PrintWriter printWriter, boolean z) {
        String string;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.f943b != 0 || this.f944c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f943b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f944c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (this.f942a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f942a.size();
        for (int i = 0; i < size; i++) {
            r.a aVar = this.f942a.get(i);
            switch (aVar.f945a) {
                case 0:
                    string = "NULL";
                    break;
                case 1:
                    string = "ADD";
                    break;
                case 2:
                    string = "REPLACE";
                    break;
                case 3:
                    string = "REMOVE";
                    break;
                case 4:
                    string = "HIDE";
                    break;
                case 5:
                    string = "SHOW";
                    break;
                case 6:
                    string = "DETACH";
                    break;
                case 7:
                    string = "ATTACH";
                    break;
                case 8:
                    string = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    string = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    string = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder sbE = c.a.a.a.a.e("cmd=");
                    sbE.append(aVar.f945a);
                    string = sbE.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(string);
            printWriter.print(" ");
            printWriter.println(aVar.f946b);
            if (z) {
                if (aVar.f947c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f947c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    public void k() {
        int size = this.f942a.size();
        for (int i = 0; i < size; i++) {
            r.a aVar = this.f942a.get(i);
            Fragment fragment = aVar.f946b;
            if (fragment != null) {
                int i2 = this.f;
                int i3 = this.g;
                if (fragment.K != null || i2 != 0 || i3 != 0) {
                    fragment.c();
                    Fragment.b bVar = fragment.K;
                    bVar.e = i2;
                    bVar.f = i3;
                }
            }
            switch (aVar.f945a) {
                case 1:
                    fragment.V(aVar.f947c);
                    this.r.f(fragment, false);
                    break;
                case 2:
                default:
                    StringBuilder sbE = c.a.a.a.a.e("Unknown cmd: ");
                    sbE.append(aVar.f945a);
                    throw new IllegalArgumentException(sbE.toString());
                case 3:
                    fragment.V(aVar.d);
                    this.r.g0(fragment);
                    break;
                case 4:
                    fragment.V(aVar.d);
                    if (this.r == null) {
                        throw null;
                    }
                    if (!fragment.z) {
                        fragment.z = true;
                        fragment.M = !fragment.M;
                    }
                    break;
                    break;
                case 5:
                    fragment.V(aVar.f947c);
                    if (this.r == null) {
                        throw null;
                    }
                    if (fragment.z) {
                        fragment.z = false;
                        fragment.M = !fragment.M;
                    }
                    break;
                    break;
                case 6:
                    fragment.V(aVar.d);
                    this.r.l(fragment);
                    break;
                case 7:
                    fragment.V(aVar.f947c);
                    this.r.h(fragment);
                    break;
                case 8:
                    this.r.p0(fragment);
                    break;
                case 9:
                    this.r.p0(null);
                    break;
                case 10:
                    this.r.o0(fragment, aVar.h);
                    break;
            }
            if (!this.p && aVar.f945a != 1 && fragment != null) {
                this.r.b0(fragment);
            }
        }
        if (this.p) {
            return;
        }
        k kVar = this.r;
        kVar.c0(kVar.p, true);
    }

    public void l(boolean z) {
        for (int size = this.f942a.size() - 1; size >= 0; size--) {
            r.a aVar = this.f942a.get(size);
            Fragment fragment = aVar.f946b;
            if (fragment != null) {
                int iK0 = k.k0(this.f);
                int i = this.g;
                if (fragment.K != null || iK0 != 0 || i != 0) {
                    fragment.c();
                    Fragment.b bVar = fragment.K;
                    bVar.e = iK0;
                    bVar.f = i;
                }
            }
            switch (aVar.f945a) {
                case 1:
                    fragment.V(aVar.f);
                    this.r.g0(fragment);
                    break;
                case 2:
                default:
                    StringBuilder sbE = c.a.a.a.a.e("Unknown cmd: ");
                    sbE.append(aVar.f945a);
                    throw new IllegalArgumentException(sbE.toString());
                case 3:
                    fragment.V(aVar.e);
                    this.r.f(fragment, false);
                    break;
                case 4:
                    fragment.V(aVar.e);
                    if (this.r == null) {
                        throw null;
                    }
                    if (fragment.z) {
                        fragment.z = false;
                        fragment.M = !fragment.M;
                    }
                    break;
                    break;
                case 5:
                    fragment.V(aVar.f);
                    if (this.r == null) {
                        throw null;
                    }
                    if (!fragment.z) {
                        fragment.z = true;
                        fragment.M = !fragment.M;
                    }
                    break;
                    break;
                case 6:
                    fragment.V(aVar.e);
                    this.r.h(fragment);
                    break;
                case 7:
                    fragment.V(aVar.f);
                    this.r.l(fragment);
                    break;
                case 8:
                    this.r.p0(null);
                    break;
                case 9:
                    this.r.p0(fragment);
                    break;
                case 10:
                    this.r.o0(fragment, aVar.g);
                    break;
            }
            if (!this.p && aVar.f945a != 3 && fragment != null) {
                this.r.b0(fragment);
            }
        }
        if (this.p || !z) {
            return;
        }
        k kVar = this.r;
        kVar.c0(kVar.p, true);
    }

    public boolean m(int i) {
        int size = this.f942a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f942a.get(i2).f946b;
            int i3 = fragment != null ? fragment.x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean n(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f942a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f942a.get(i4).f946b;
            int i5 = fragment != null ? fragment.x : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f942a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f942a.get(i7).f946b;
                        if ((fragment2 != null ? fragment2.x : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
