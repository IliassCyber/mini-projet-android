package b.r.d;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends v {
    public static TimeInterpolator s;
    public ArrayList<RecyclerView.d0> h = new ArrayList<>();
    public ArrayList<RecyclerView.d0> i = new ArrayList<>();
    public ArrayList<b> j = new ArrayList<>();
    public ArrayList<a> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.d0>> l = new ArrayList<>();
    public ArrayList<ArrayList<b>> m = new ArrayList<>();
    public ArrayList<ArrayList<a>> n = new ArrayList<>();
    public ArrayList<RecyclerView.d0> o = new ArrayList<>();
    public ArrayList<RecyclerView.d0> p = new ArrayList<>();
    public ArrayList<RecyclerView.d0> q = new ArrayList<>();
    public ArrayList<RecyclerView.d0> r = new ArrayList<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f1046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f1047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1048c;
        public int d;
        public int e;
        public int f;

        public a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4) {
            this.f1046a = d0Var;
            this.f1047b = d0Var2;
            this.f1048c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder sbE = c.a.a.a.a.e("ChangeInfo{oldHolder=");
            sbE.append(this.f1046a);
            sbE.append(", newHolder=");
            sbE.append(this.f1047b);
            sbE.append(", fromX=");
            sbE.append(this.f1048c);
            sbE.append(", fromY=");
            sbE.append(this.d);
            sbE.append(", toX=");
            sbE.append(this.e);
            sbE.append(", toY=");
            sbE.append(this.f);
            sbE.append('}');
            return sbE.toString();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f1049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1051c;
        public int d;
        public int e;

        public b(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
            this.f1049a = d0Var;
            this.f1050b = i;
            this.f1051c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.c(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void f(RecyclerView.d0 d0Var) {
        View view = d0Var.f184a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.j.get(size).f1049a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                d(d0Var);
                this.j.remove(size);
            }
        }
        m(this.k, d0Var);
        if (this.h.remove(d0Var)) {
            view.setAlpha(1.0f);
            d(d0Var);
        }
        if (this.i.remove(d0Var)) {
            view.setAlpha(1.0f);
            d(d0Var);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<a> arrayList = this.n.get(size2);
            m(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<b> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f1049a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    d(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.l.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                this.q.remove(d0Var);
                this.o.remove(d0Var);
                this.r.remove(d0Var);
                this.p.remove(d0Var);
                l();
                return;
            }
            ArrayList<RecyclerView.d0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                d(d0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void g() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.j.get(size);
            View view = bVar.f1049a.f184a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            d(bVar.f1049a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            d(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.i.get(size3);
            d0Var.f184a.setAlpha(1.0f);
            d(d0Var);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            a aVar = this.k.get(size4);
            RecyclerView.d0 d0Var2 = aVar.f1046a;
            if (d0Var2 != null) {
                n(aVar, d0Var2);
            }
            RecyclerView.d0 d0Var3 = aVar.f1047b;
            if (d0Var3 != null) {
                n(aVar, d0Var3);
            }
        }
        this.k.clear();
        if (!h()) {
            return;
        }
        int size5 = this.m.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<b> arrayList = this.m.get(size5);
            int size6 = arrayList.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f1049a.f184a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    d(bVar2.f1049a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
        }
        int size7 = this.l.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.d0> arrayList2 = this.l.get(size7);
            int size8 = arrayList2.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.d0 d0Var4 = arrayList2.get(size8);
                    d0Var4.f184a.setAlpha(1.0f);
                    d(d0Var4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
        }
        int size9 = this.n.size();
        while (true) {
            size9--;
            if (size9 < 0) {
                k(this.q);
                k(this.p);
                k(this.o);
                k(this.r);
                e();
                return;
            }
            ArrayList<a> arrayList3 = this.n.get(size9);
            int size10 = arrayList3.size();
            while (true) {
                size10--;
                if (size10 >= 0) {
                    a aVar2 = arrayList3.get(size10);
                    RecyclerView.d0 d0Var5 = aVar2.f1046a;
                    if (d0Var5 != null) {
                        n(aVar2, d0Var5);
                    }
                    RecyclerView.d0 d0Var6 = aVar2.f1047b;
                    if (d0Var6 != null) {
                        n(aVar2, d0Var6);
                    }
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean h() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // b.r.d.v
    public boolean j(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
        View view = d0Var.f184a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) d0Var.f184a.getTranslationY());
        o(d0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            d(d0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.j.add(new b(d0Var, translationX, translationY, i3, i4));
        return true;
    }

    public void k(List<RecyclerView.d0> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                list.get(size).f184a.animate().cancel();
            }
        }
    }

    public void l() {
        if (h()) {
            return;
        }
        e();
    }

    public final void m(List<a> list, RecyclerView.d0 d0Var) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            a aVar = list.get(size);
            if (n(aVar, d0Var) && aVar.f1046a == null && aVar.f1047b == null) {
                list.remove(aVar);
            }
        }
    }

    public final boolean n(a aVar, RecyclerView.d0 d0Var) {
        if (aVar.f1047b == d0Var) {
            aVar.f1047b = null;
        } else {
            if (aVar.f1046a != d0Var) {
                return false;
            }
            aVar.f1046a = null;
        }
        d0Var.f184a.setAlpha(1.0f);
        d0Var.f184a.setTranslationX(0.0f);
        d0Var.f184a.setTranslationY(0.0f);
        d(d0Var);
        return true;
    }

    public final void o(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.f184a.animate().setInterpolator(s);
        f(d0Var);
    }
}
