package b.t;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.t.i;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o extends i {
    public int L;
    public ArrayList<i> J = new ArrayList<>();
    public boolean K = true;
    public boolean M = false;
    public int N = 0;

    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1144a;

        public a(o oVar, i iVar) {
            this.f1144a = iVar;
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            this.f1144a.z();
            iVar.w(this);
        }
    }

    public static class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f1145a;

        public b(o oVar) {
            this.f1145a = oVar;
        }

        @Override // b.t.l, b.t.i.d
        public void a(i iVar) {
            o oVar = this.f1145a;
            if (oVar.M) {
                return;
            }
            oVar.G();
            this.f1145a.M = true;
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            o oVar = this.f1145a;
            int i = oVar.L - 1;
            oVar.L = i;
            if (i == 0) {
                oVar.M = false;
                oVar.n();
            }
            iVar.w(this);
        }
    }

    @Override // b.t.i
    public i A(long j) {
        ArrayList<i> arrayList;
        this.d = j;
        if (j >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).A(j);
            }
        }
        return this;
    }

    @Override // b.t.i
    public void B(i.c cVar) {
        this.E = cVar;
        this.N |= 8;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).B(cVar);
        }
    }

    @Override // b.t.i
    public i C(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<i> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).C(timeInterpolator);
            }
        }
        this.e = timeInterpolator;
        return this;
    }

    @Override // b.t.i
    public void D(e eVar) {
        this.F = eVar == null ? i.H : eVar;
        this.N |= 4;
        if (this.J != null) {
            for (int i = 0; i < this.J.size(); i++) {
                this.J.get(i).D(eVar);
            }
        }
    }

    @Override // b.t.i
    public void E(n nVar) {
        this.D = nVar;
        this.N |= 2;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).E(nVar);
        }
    }

    @Override // b.t.i
    public i F(long j) {
        this.f1130c = j;
        return this;
    }

    @Override // b.t.i
    public String H(String str) {
        String strH = super.H(str);
        for (int i = 0; i < this.J.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strH);
            sb.append("\n");
            sb.append(this.J.get(i).H(str + "  "));
            strH = sb.toString();
        }
        return strH;
    }

    public o I(i iVar) {
        this.J.add(iVar);
        iVar.s = this;
        long j = this.d;
        if (j >= 0) {
            iVar.A(j);
        }
        if ((this.N & 1) != 0) {
            iVar.C(this.e);
        }
        if ((this.N & 2) != 0) {
            iVar.E(null);
        }
        if ((this.N & 4) != 0) {
            iVar.D(this.F);
        }
        if ((this.N & 8) != 0) {
            iVar.B(this.E);
        }
        return this;
    }

    public i J(int i) {
        if (i < 0 || i >= this.J.size()) {
            return null;
        }
        return this.J.get(i);
    }

    public o K(int i) {
        if (i == 0) {
            this.K = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.K = false;
        }
        return this;
    }

    @Override // b.t.i
    public i a(i.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // b.t.i
    public i b(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).b(view);
        }
        this.g.add(view);
        return this;
    }

    @Override // b.t.i
    public void d() {
        super.d();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).d();
        }
    }

    @Override // b.t.i
    public void e(q qVar) {
        if (t(qVar.f1148b)) {
            for (i iVar : this.J) {
                if (iVar.t(qVar.f1148b)) {
                    iVar.e(qVar);
                    qVar.f1149c.add(iVar);
                }
            }
        }
    }

    @Override // b.t.i
    public void g(q qVar) {
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).g(qVar);
        }
    }

    @Override // b.t.i
    public void h(q qVar) {
        if (t(qVar.f1148b)) {
            for (i iVar : this.J) {
                if (iVar.t(qVar.f1148b)) {
                    iVar.h(qVar);
                    qVar.f1149c.add(iVar);
                }
            }
        }
    }

    @Override // b.t.i
    /* JADX INFO: renamed from: k */
    public i clone() {
        o oVar = (o) super.clone();
        oVar.J = new ArrayList<>();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            i iVarClone = this.J.get(i).clone();
            oVar.J.add(iVarClone);
            iVarClone.s = oVar;
        }
        return oVar;
    }

    @Override // b.t.i
    public void m(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long j = this.f1130c;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.J.get(i);
            if (j > 0 && (this.K || i == 0)) {
                long j2 = iVar.f1130c;
                if (j2 > 0) {
                    iVar.F(j2 + j);
                } else {
                    iVar.F(j);
                }
            }
            iVar.m(viewGroup, rVar, rVar2, arrayList, arrayList2);
        }
    }

    @Override // b.t.i
    public void v(View view) {
        super.v(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).v(view);
        }
    }

    @Override // b.t.i
    public i w(i.d dVar) {
        super.w(dVar);
        return this;
    }

    @Override // b.t.i
    public i x(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).x(view);
        }
        this.g.remove(view);
        return this;
    }

    @Override // b.t.i
    public void y(View view) {
        super.y(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).y(view);
        }
    }

    @Override // b.t.i
    public void z() {
        if (this.J.isEmpty()) {
            G();
            n();
            return;
        }
        b bVar = new b(this);
        Iterator<i> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.L = this.J.size();
        if (this.K) {
            Iterator<i> it2 = this.J.iterator();
            while (it2.hasNext()) {
                it2.next().z();
            }
            return;
        }
        for (int i = 1; i < this.J.size(); i++) {
            this.J.get(i - 1).a(new a(this, this.J.get(i)));
        }
        i iVar = this.J.get(0);
        if (iVar != null) {
            iVar.z();
        }
    }
}
