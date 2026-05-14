package b.t;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.t.i;
import b.t.m;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class d extends b.l.a.b0 {

    public class a extends i.c {
        public a(d dVar, Rect rect) {
        }
    }

    public class b implements i.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1118b;

        public b(d dVar, View view, ArrayList arrayList) {
            this.f1117a = view;
            this.f1118b = arrayList;
        }

        @Override // b.t.i.d
        public void a(i iVar) {
        }

        @Override // b.t.i.d
        public void b(i iVar) {
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            iVar.w(this);
            this.f1117a.setVisibility(8);
            int size = this.f1118b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f1118b.get(i)).setVisibility(0);
            }
        }

        @Override // b.t.i.d
        public void d(i iVar) {
        }

        @Override // b.t.i.d
        public void e(i iVar) {
        }
    }

    public class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1121c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1119a = obj;
            this.f1120b = arrayList;
            this.f1121c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // b.t.l, b.t.i.d
        public void a(i iVar) {
            Object obj = this.f1119a;
            if (obj != null) {
                d.this.o(obj, this.f1120b, null);
            }
            Object obj2 = this.f1121c;
            if (obj2 != null) {
                d.this.o(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                d.this.o(obj3, this.f, null);
            }
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            iVar.w(this);
        }
    }

    /* JADX INFO: renamed from: b.t.d$d, reason: collision with other inner class name */
    public class C0046d extends i.c {
        public C0046d(d dVar, Rect rect) {
        }
    }

    public static boolean w(i iVar) {
        return (b.l.a.b0.k(iVar.f) && b.l.a.b0.k(iVar.h) && b.l.a.b0.k(iVar.i)) ? false : true;
    }

    @Override // b.l.a.b0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((i) obj).b(view);
        }
    }

    @Override // b.l.a.b0
    public void b(Object obj, ArrayList<View> arrayList) {
        i iVar = (i) obj;
        if (iVar == null) {
            return;
        }
        int i = 0;
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            int size = oVar.J.size();
            while (i < size) {
                b(oVar.J(i), arrayList);
                i++;
            }
            return;
        }
        if (w(iVar) || !b.l.a.b0.k(iVar.g)) {
            return;
        }
        int size2 = arrayList.size();
        while (i < size2) {
            iVar.b(arrayList.get(i));
            i++;
        }
    }

    @Override // b.l.a.b0
    public void c(ViewGroup viewGroup, Object obj) {
        i iVar = (i) obj;
        if (m.f1139c.contains(viewGroup) || !b.i.m.l.E(viewGroup)) {
            return;
        }
        m.f1139c.add(viewGroup);
        i iVarClone = iVar.clone();
        ArrayList<i> orDefault = m.a().getOrDefault(viewGroup, null);
        if (orDefault != null && orDefault.size() > 0) {
            Iterator<i> it = orDefault.iterator();
            while (it.hasNext()) {
                it.next().v(viewGroup);
            }
        }
        if (iVarClone != null) {
            iVarClone.i(viewGroup, true);
        }
        if (((h) viewGroup.getTag(f.transition_current_scene)) != null) {
            throw null;
        }
        viewGroup.setTag(f.transition_current_scene, null);
        if (iVarClone != null) {
            m.a aVar = new m.a(iVarClone, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    @Override // b.l.a.b0
    public boolean e(Object obj) {
        return obj instanceof i;
    }

    @Override // b.l.a.b0
    public Object g(Object obj) {
        if (obj != null) {
            return ((i) obj).clone();
        }
        return null;
    }

    @Override // b.l.a.b0
    public Object l(Object obj, Object obj2, Object obj3) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        i iVar3 = (i) obj3;
        if (iVar != null && iVar2 != null) {
            o oVar = new o();
            oVar.I(iVar);
            oVar.I(iVar2);
            oVar.K(1);
            iVar = oVar;
        } else if (iVar == null) {
            iVar = iVar2 != null ? iVar2 : null;
        }
        if (iVar3 == null) {
            return iVar;
        }
        o oVar2 = new o();
        if (iVar != null) {
            oVar2.I(iVar);
        }
        oVar2.I(iVar3);
        return oVar2;
    }

    @Override // b.l.a.b0
    public Object m(Object obj, Object obj2, Object obj3) {
        o oVar = new o();
        if (obj != null) {
            oVar.I((i) obj);
        }
        if (obj2 != null) {
            oVar.I((i) obj2);
        }
        if (obj3 != null) {
            oVar.I((i) obj3);
        }
        return oVar;
    }

    @Override // b.l.a.b0
    public void n(Object obj, View view) {
        if (obj != null) {
            ((i) obj).x(view);
        }
    }

    @Override // b.l.a.b0
    public void o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        i iVar = (i) obj;
        int i = 0;
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            int size = oVar.J.size();
            while (i < size) {
                o(oVar.J(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (w(iVar)) {
            return;
        }
        ArrayList<View> arrayList3 = iVar.g;
        if (arrayList3.size() != arrayList.size() || !arrayList3.containsAll(arrayList)) {
            return;
        }
        int size2 = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size2) {
            iVar.b(arrayList2.get(i));
            i++;
        }
        int size3 = arrayList.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                return;
            } else {
                iVar.x(arrayList.get(size3));
            }
        }
    }

    @Override // b.l.a.b0
    public void p(Object obj, View view, ArrayList<View> arrayList) {
        ((i) obj).a(new b(this, view, arrayList));
    }

    @Override // b.l.a.b0
    public void q(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((i) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // b.l.a.b0
    public void r(Object obj, Rect rect) {
        if (obj != null) {
            ((i) obj).B(new C0046d(this, rect));
        }
    }

    @Override // b.l.a.b0
    public void s(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((i) obj).B(new a(this, rect));
        }
    }

    @Override // b.l.a.b0
    public void t(Object obj, View view, ArrayList<View> arrayList) {
        o oVar = (o) obj;
        ArrayList<View> arrayList2 = oVar.g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b.l.a.b0.d(arrayList2, arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(oVar, arrayList);
    }

    @Override // b.l.a.b0
    public void u(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        o oVar = (o) obj;
        if (oVar != null) {
            oVar.g.clear();
            oVar.g.addAll(arrayList2);
            o(oVar, arrayList, arrayList2);
        }
    }

    @Override // b.l.a.b0
    public Object v(Object obj) {
        if (obj == null) {
            return null;
        }
        o oVar = new o();
        oVar.I((i) obj);
        return oVar;
    }
}
