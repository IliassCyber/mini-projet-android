package b.l.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f955a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f956b = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f957c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b.l.a.a f960c;
        public Fragment d;
        public boolean e;
        public b.l.a.a f;
    }

    static {
        b0 b0Var;
        try {
            b0Var = (b0) Class.forName("b.t.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            b0Var = null;
        }
        f957c = b0Var;
    }

    public static void a(ArrayList<View> arrayList, b.f.a<String, View> aVar, Collection<String> collection) {
        for (int i = aVar.d - 1; i >= 0; i--) {
            View viewK = aVar.k(i);
            if (collection.contains(b.i.m.l.x(viewK))) {
                arrayList.add(viewK);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(b.l.a.a r11, b.l.a.r.a r12, android.util.SparseArray<b.l.a.w.a> r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.w.b(b.l.a.a, b.l.a.r$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(Fragment fragment, Fragment fragment2, boolean z, b.f.a<String, View> aVar, boolean z2) {
        if (z) {
            Fragment.b bVar = fragment2.K;
        } else {
            Fragment.b bVar2 = fragment.K;
        }
    }

    public static boolean d(b0 b0Var, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!b0Var.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static b.f.a<String, View> e(b0 b0Var, b.f.a<String, String> aVar, Object obj, a aVar2) {
        View view = aVar2.f958a.G;
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        b.f.a<String, View> aVar3 = new b.f.a<>();
        b0Var.i(aVar3, view);
        b.l.a.a aVar4 = aVar2.f960c;
        ArrayList<String> arrayList = aVar2.f959b ? aVar4.n : aVar4.o;
        if (arrayList != null) {
            b.f.g.k(aVar3, arrayList);
            b.f.g.k(aVar3, aVar.values());
        }
        int i = aVar.d;
        while (true) {
            i--;
            if (i < 0) {
                return aVar3;
            }
            if (!aVar3.containsKey(aVar.k(i))) {
                aVar.i(i);
            }
        }
    }

    public static b.f.a<String, View> f(b0 b0Var, b.f.a<String, String> aVar, Object obj, a aVar2) {
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = aVar2.d;
        b.f.a<String, View> aVar3 = new b.f.a<>();
        b0Var.i(aVar3, fragment.Q());
        b.l.a.a aVar4 = aVar2.f;
        b.f.g.k(aVar3, aVar2.e ? aVar4.o : aVar4.n);
        b.f.g.k(aVar, aVar3.keySet());
        return aVar3;
    }

    public static b0 g(Fragment fragment, Fragment fragment2) {
        Object objM;
        Object objL;
        Object objR;
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objM2 = fragment.m();
            if (objM2 != null) {
                arrayList.add(objM2);
            }
            Fragment.b bVar = fragment.K;
            if (bVar == null) {
                objL = null;
            } else {
                objL = bVar.h;
                if (objL == Fragment.V) {
                    objL = fragment.l();
                }
            }
            if (objL != null) {
                arrayList.add(objL);
            }
            Fragment.b bVar2 = fragment.K;
            if (bVar2 == null) {
                objR = null;
            } else {
                objR = bVar2.l;
                if (objR == Fragment.V) {
                    objR = fragment.r();
                }
            }
            if (objR != null) {
                arrayList.add(objR);
            }
        }
        if (fragment2 != null) {
            Object objL2 = fragment2.l();
            if (objL2 != null) {
                arrayList.add(objL2);
            }
            Fragment.b bVar3 = fragment2.K;
            if (bVar3 == null) {
                objM = null;
            } else {
                objM = bVar3.j;
                if (objM == Fragment.V) {
                    objM = fragment2.m();
                }
            }
            if (objM != null) {
                arrayList.add(objM);
            }
            Object objR2 = fragment2.r();
            if (objR2 != null) {
                arrayList.add(objR2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (d(f956b, arrayList)) {
            return f956b;
        }
        b0 b0Var = f957c;
        if (b0Var == null || !d(b0Var, arrayList)) {
            throw new IllegalArgumentException("Invalid Transition types");
        }
        return f957c;
    }

    public static ArrayList<View> h(b0 b0Var, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.G;
        if (view2 != null) {
            b0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        b0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object i(b0 b0Var, Fragment fragment, boolean z) {
        Object objL = null;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Fragment.b bVar = fragment.K;
            if (bVar != null && (objL = bVar.j) == Fragment.V) {
                objL = fragment.m();
            }
        } else {
            objL = fragment.l();
        }
        return b0Var.g(objL);
    }

    public static Object j(b0 b0Var, Fragment fragment, boolean z) {
        Object objM = null;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Fragment.b bVar = fragment.K;
            if (bVar != null && (objM = bVar.h) == Fragment.V) {
                objM = fragment.l();
            }
        } else {
            objM = fragment.m();
        }
        return b0Var.g(objM);
    }

    public static View k(b.f.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        ArrayList<String> arrayList;
        b.l.a.a aVar3 = aVar2.f960c;
        if (obj == null || aVar == null || (arrayList = aVar3.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar3.n : aVar3.o).get(0));
    }

    public static Object l(b0 b0Var, Fragment fragment, Fragment fragment2, boolean z) {
        Object objR;
        if (z) {
            Fragment.b bVar = fragment2.K;
            if (bVar == null) {
                objR = null;
            } else {
                objR = bVar.l;
                if (objR == Fragment.V) {
                    objR = fragment2.r();
                }
            }
        } else {
            objR = fragment.r();
        }
        return b0Var.v(b0Var.g(objR));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object m(b.l.a.b0 r0, java.lang.Object r1, java.lang.Object r2, java.lang.Object r3, androidx.fragment.app.Fragment r4, boolean r5) {
        /*
            if (r1 == 0) goto L24
            if (r2 == 0) goto L24
            if (r4 == 0) goto L24
            if (r5 == 0) goto L16
            androidx.fragment.app.Fragment$b r4 = r4.K
            if (r4 == 0) goto L24
            java.lang.Boolean r4 = r4.m
            if (r4 != 0) goto L11
            goto L24
        L11:
            boolean r4 = r4.booleanValue()
            goto L25
        L16:
            androidx.fragment.app.Fragment$b r4 = r4.K
            if (r4 == 0) goto L24
            java.lang.Boolean r4 = r4.n
            if (r4 != 0) goto L1f
            goto L24
        L1f:
            boolean r4 = r4.booleanValue()
            goto L25
        L24:
            r4 = 1
        L25:
            if (r4 == 0) goto L2c
            java.lang.Object r0 = r0.m(r2, r1, r3)
            goto L30
        L2c:
            java.lang.Object r0 = r0.l(r2, r1, r3)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.w.m(b.l.a.b0, java.lang.Object, java.lang.Object, java.lang.Object, androidx.fragment.app.Fragment, boolean):java.lang.Object");
    }

    public static void n(b0 b0Var, Object obj, Object obj2, b.f.a<String, View> aVar, boolean z, b.l.a.a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
        b0Var.s(obj, view);
        if (obj2 != null) {
            b0Var.s(obj2, view);
        }
    }

    public static void o(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x044a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(b.l.a.k r39, java.util.ArrayList<b.l.a.a> r40, java.util.ArrayList<java.lang.Boolean> r41, int r42, int r43, boolean r44) {
        /*
            Method dump skipped, instruction units count: 1119
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.w.p(b.l.a.k, java.util.ArrayList, java.util.ArrayList, int, int, boolean):void");
    }
}
