package b.t;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Cloneable {
    public static final int[] G = {2, 1, 3, 4};
    public static final e H = new a();
    public static ThreadLocal<b.f.a<Animator, b>> I = new ThreadLocal<>();
    public n D;
    public c E;
    public ArrayList<q> u;
    public ArrayList<q> v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1129b = getClass().getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1130c = -1;
    public long d = -1;
    public TimeInterpolator e = null;
    public ArrayList<Integer> f = new ArrayList<>();
    public ArrayList<View> g = new ArrayList<>();
    public ArrayList<String> h = null;
    public ArrayList<Class<?>> i = null;
    public ArrayList<Integer> j = null;
    public ArrayList<View> k = null;
    public ArrayList<Class<?>> l = null;
    public ArrayList<String> m = null;
    public ArrayList<Integer> n = null;
    public ArrayList<View> o = null;
    public ArrayList<Class<?>> p = null;
    public r q = new r();
    public r r = new r();
    public o s = null;
    public int[] t = G;
    public boolean w = false;
    public ArrayList<Animator> x = new ArrayList<>();
    public int y = 0;
    public boolean z = false;
    public boolean A = false;
    public ArrayList<d> B = null;
    public ArrayList<Animator> C = new ArrayList<>();
    public e F = H;

    public static class a extends e {
        @Override // b.t.e
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f1131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q f1133c;
        public f0 d;
        public i e;

        public b(View view, String str, i iVar, f0 f0Var, q qVar) {
            this.f1131a = view;
            this.f1132b = str;
            this.f1133c = qVar;
            this.d = f0Var;
            this.e = iVar;
        }
    }

    public static abstract class c {
    }

    public interface d {
        void a(i iVar);

        void b(i iVar);

        void c(i iVar);

        void d(i iVar);

        void e(i iVar);
    }

    public static void c(r rVar, View view, q qVar) {
        rVar.f1150a.put(view, qVar);
        int id = view.getId();
        if (id >= 0) {
            if (rVar.f1151b.indexOfKey(id) >= 0) {
                rVar.f1151b.put(id, null);
            } else {
                rVar.f1151b.put(id, view);
            }
        }
        String strX = b.i.m.l.x(view);
        if (strX != null) {
            if (rVar.d.e(strX) >= 0) {
                rVar.d.put(strX, null);
            } else {
                rVar.d.put(strX, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                b.f.e<View> eVar = rVar.f1152c;
                if (eVar.f576b) {
                    eVar.d();
                }
                if (b.f.d.b(eVar.f577c, eVar.e, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    rVar.f1152c.g(itemIdAtPosition, view);
                    return;
                }
                View viewE = rVar.f1152c.e(itemIdAtPosition);
                if (viewE != null) {
                    viewE.setHasTransientState(false);
                    rVar.f1152c.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static b.f.a<Animator, b> p() {
        b.f.a<Animator, b> aVar = I.get();
        if (aVar != null) {
            return aVar;
        }
        b.f.a<Animator, b> aVar2 = new b.f.a<>();
        I.set(aVar2);
        return aVar2;
    }

    public static boolean u(q qVar, q qVar2, String str) {
        Object obj = qVar.f1147a.get(str);
        Object obj2 = qVar2.f1147a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public i A(long j) {
        this.d = j;
        return this;
    }

    public void B(c cVar) {
        this.E = cVar;
    }

    public i C(TimeInterpolator timeInterpolator) {
        this.e = timeInterpolator;
        return this;
    }

    public void D(e eVar) {
        if (eVar == null) {
            eVar = H;
        }
        this.F = eVar;
    }

    public void E(n nVar) {
        this.D = nVar;
    }

    public i F(long j) {
        this.f1130c = j;
        return this;
    }

    public void G() {
        if (this.y == 0) {
            ArrayList<d> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((d) arrayList2.get(i)).a(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public String H(String str) {
        StringBuilder sbE = c.a.a.a.a.e(str);
        sbE.append(getClass().getSimpleName());
        sbE.append("@");
        sbE.append(Integer.toHexString(hashCode()));
        sbE.append(": ");
        String string = sbE.toString();
        if (this.d != -1) {
            string = string + "dur(" + this.d + ") ";
        }
        if (this.f1130c != -1) {
            string = string + "dly(" + this.f1130c + ") ";
        }
        if (this.e != null) {
            string = string + "interp(" + this.e + ") ";
        }
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            return string;
        }
        String strC = c.a.a.a.a.c(string, "tgts(");
        if (this.f.size() > 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (i > 0) {
                    strC = c.a.a.a.a.c(strC, ", ");
                }
                StringBuilder sbE2 = c.a.a.a.a.e(strC);
                sbE2.append(this.f.get(i));
                strC = sbE2.toString();
            }
        }
        if (this.g.size() > 0) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (i2 > 0) {
                    strC = c.a.a.a.a.c(strC, ", ");
                }
                StringBuilder sbE3 = c.a.a.a.a.e(strC);
                sbE3.append(this.g.get(i2));
                strC = sbE3.toString();
            }
        }
        return c.a.a.a.a.c(strC, ")");
    }

    public i a(d dVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(dVar);
        return this;
    }

    public i b(View view) {
        this.g.add(view);
        return this;
    }

    public void d() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<d> arrayList = this.B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.B.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((d) arrayList2.get(i)).b(this);
        }
    }

    public abstract void e(q qVar);

    public final void f(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.l.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    q qVar = new q(view);
                    if (z) {
                        h(qVar);
                    } else {
                        e(qVar);
                    }
                    qVar.f1149c.add(this);
                    g(qVar);
                    c(z ? this.q : this.r, view, qVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.p.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                f(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public void g(q qVar) {
    }

    public abstract void h(q qVar);

    public void i(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        j(z);
        if ((this.f.size() <= 0 && this.g.size() <= 0) || (((arrayList = this.h) != null && !arrayList.isEmpty()) || ((arrayList2 = this.i) != null && !arrayList2.isEmpty()))) {
            f(viewGroup, z);
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(this.f.get(i).intValue());
            if (viewFindViewById != null) {
                q qVar = new q(viewFindViewById);
                if (z) {
                    h(qVar);
                } else {
                    e(qVar);
                }
                qVar.f1149c.add(this);
                g(qVar);
                c(z ? this.q : this.r, viewFindViewById, qVar);
            }
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            View view = this.g.get(i2);
            q qVar2 = new q(view);
            if (z) {
                h(qVar2);
            } else {
                e(qVar2);
            }
            qVar2.f1149c.add(this);
            g(qVar2);
            c(z ? this.q : this.r, view, qVar2);
        }
    }

    public void j(boolean z) {
        r rVar;
        if (z) {
            this.q.f1150a.clear();
            this.q.f1151b.clear();
            rVar = this.q;
        } else {
            this.r.f1150a.clear();
            this.r.f1151b.clear();
            rVar = this.r;
        }
        rVar.f1152c.b();
    }

    @Override // 
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.C = new ArrayList<>();
            iVar.q = new r();
            iVar.r = new r();
            iVar.u = null;
            iVar.v = null;
            return iVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.view.ViewGroup r20, b.t.r r21, b.t.r r22, java.util.ArrayList<b.t.q> r23, java.util.ArrayList<b.t.q> r24) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.t.i.m(android.view.ViewGroup, b.t.r, b.t.r, java.util.ArrayList, java.util.ArrayList):void");
    }

    public void n() {
        int i = this.y - 1;
        this.y = i;
        if (i == 0) {
            ArrayList<d> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.q.f1152c.h(); i3++) {
                View viewI = this.q.f1152c.i(i3);
                if (viewI != null) {
                    b.i.m.l.c0(viewI, false);
                }
            }
            for (int i4 = 0; i4 < this.r.f1152c.h(); i4++) {
                View viewI2 = this.r.f1152c.i(i4);
                if (viewI2 != null) {
                    b.i.m.l.c0(viewI2, false);
                }
            }
            this.A = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r7 = r6.v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r7 = r6.u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.t.q o(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            b.t.o r0 = r6.s
            if (r0 == 0) goto L9
            b.t.q r7 = r0.o(r7, r8)
            return r7
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<b.t.q> r0 = r6.u
            goto L10
        Le:
            java.util.ArrayList<b.t.q> r0 = r6.v
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1a:
            if (r4 >= r2) goto L2e
            java.lang.Object r5 = r0.get(r4)
            b.t.q r5 = (b.t.q) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f1148b
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<b.t.q> r7 = r6.v
            goto L37
        L35:
            java.util.ArrayList<b.t.q> r7 = r6.u
        L37:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            b.t.q r1 = (b.t.q) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.t.i.o(android.view.View, boolean):b.t.q");
    }

    public String[] q() {
        return null;
    }

    public q r(View view, boolean z) {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.r(view, z);
        }
        return (z ? this.q : this.r).f1150a.getOrDefault(view, null);
    }

    public boolean s(q qVar, q qVar2) {
        if (qVar == null || qVar2 == null) {
            return false;
        }
        String[] strArrQ = q();
        if (strArrQ == null) {
            Iterator<String> it = qVar.f1147a.keySet().iterator();
            while (it.hasNext()) {
                if (u(qVar, qVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrQ) {
            if (!u(qVar, qVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean t(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.l.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.m != null && b.i.m.l.x(view) != null && this.m.contains(view.getTransitionName())) {
            return false;
        }
        if ((this.f.size() == 0 && this.g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f.contains(Integer.valueOf(id)) || this.g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(b.i.m.l.x(view))) {
            return true;
        }
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (this.i.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return H("");
    }

    public void v(View view) {
        if (this.A) {
            return;
        }
        b.f.a<Animator, b> aVarP = p();
        int i = aVarP.d;
        f0 f0VarC = v.c(view);
        for (int i2 = i - 1; i2 >= 0; i2--) {
            b bVarK = aVarP.k(i2);
            if (bVarK.f1131a != null && f0VarC.equals(bVarK.d)) {
                aVarP.h(i2).pause();
            }
        }
        ArrayList<d> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((d) arrayList2.get(i3)).d(this);
            }
        }
        this.z = true;
    }

    public i w(d dVar) {
        ArrayList<d> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public i x(View view) {
        this.g.remove(view);
        return this;
    }

    public void y(View view) {
        if (this.z) {
            if (!this.A) {
                b.f.a<Animator, b> aVarP = p();
                int i = aVarP.d;
                f0 f0VarC = v.c(view);
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    b bVarK = aVarP.k(i2);
                    if (bVarK.f1131a != null && f0VarC.equals(bVarK.d)) {
                        aVarP.h(i2).resume();
                    }
                }
                ArrayList<d> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size = arrayList2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((d) arrayList2.get(i3)).e(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public void z() {
        G();
        b.f.a<Animator, b> aVarP = p();
        for (Animator animator : this.C) {
            if (aVarP.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new j(this, aVarP));
                    long j = this.d;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.f1130c;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.e;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new k(this));
                    animator.start();
                }
            }
        }
        this.C.clear();
        n();
    }
}
