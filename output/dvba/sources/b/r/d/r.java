package b.r.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class r extends t {
    public r(RecyclerView.o oVar) {
        super(oVar, null);
    }

    @Override // b.r.d.t
    public int b(View view) {
        return this.f1072a.F(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    @Override // b.r.d.t
    public int c(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.f1072a.E(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // b.r.d.t
    public int d(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return this.f1072a.D(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // b.r.d.t
    public int e(View view) {
        return this.f1072a.C(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    @Override // b.r.d.t
    public int f() {
        return this.f1072a.q;
    }

    @Override // b.r.d.t
    public int g() {
        RecyclerView.o oVar = this.f1072a;
        return oVar.q - oVar.N();
    }

    @Override // b.r.d.t
    public int h() {
        return this.f1072a.N();
    }

    @Override // b.r.d.t
    public int i() {
        return this.f1072a.o;
    }

    @Override // b.r.d.t
    public int j() {
        return this.f1072a.p;
    }

    @Override // b.r.d.t
    public int k() {
        return this.f1072a.M();
    }

    @Override // b.r.d.t
    public int l() {
        RecyclerView.o oVar = this.f1072a;
        return (oVar.q - oVar.M()) - this.f1072a.N();
    }

    @Override // b.r.d.t
    public int n(View view) {
        this.f1072a.T(view, true, this.f1074c);
        return this.f1074c.right;
    }

    @Override // b.r.d.t
    public int o(View view) {
        this.f1072a.T(view, true, this.f1074c);
        return this.f1074c.left;
    }

    @Override // b.r.d.t
    public void p(int i) {
        this.f1072a.Z(i);
    }
}
