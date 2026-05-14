package b.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class p extends w {
    public t d;
    public t e;

    @Override // b.r.d.w
    public int[] a(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.e()) {
            iArr[0] = d(view, g(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.f()) {
            iArr[1] = d(view, h(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // b.r.d.w
    public View b(RecyclerView.o oVar) {
        t tVarG;
        if (oVar.f()) {
            tVarG = h(oVar);
        } else {
            if (!oVar.e()) {
                return null;
            }
            tVarG = g(oVar);
        }
        return f(oVar, tVarG);
    }

    public final int d(View view, t tVar) {
        return ((tVar.c(view) / 2) + tVar.e(view)) - ((tVar.l() / 2) + tVar.k());
    }

    public final int e(RecyclerView.o oVar, t tVar, int i, int i2) {
        int iMax;
        this.f1076b.fling(0, 0, i, i2, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        int[] iArr = {this.f1076b.getFinalX(), this.f1076b.getFinalY()};
        int iY = oVar.y();
        float f = 1.0f;
        if (iY != 0) {
            View view = null;
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            int i4 = RecyclerView.UNDEFINED_DURATION;
            for (int i5 = 0; i5 < iY; i5++) {
                View viewX = oVar.x(i5);
                int iP = oVar.P(viewX);
                if (iP != -1) {
                    if (iP < i3) {
                        view = viewX;
                        i3 = iP;
                    }
                    if (iP > i4) {
                        view2 = viewX;
                        i4 = iP;
                    }
                }
            }
            if (view != null && view2 != null && (iMax = Math.max(tVar.b(view), tVar.b(view2)) - Math.min(tVar.e(view), tVar.e(view2))) != 0) {
                f = (iMax * 1.0f) / ((i4 - i3) + 1);
            }
        }
        if (f <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1]) / f);
    }

    public final View f(RecyclerView.o oVar, t tVar) {
        int iY = oVar.y();
        View view = null;
        if (iY == 0) {
            return null;
        }
        int iL = (tVar.l() / 2) + tVar.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iY; i2++) {
            View viewX = oVar.x(i2);
            int iAbs = Math.abs(((tVar.c(viewX) / 2) + tVar.e(viewX)) - iL);
            if (iAbs < i) {
                view = viewX;
                i = iAbs;
            }
        }
        return view;
    }

    public final t g(RecyclerView.o oVar) {
        t tVar = this.e;
        if (tVar == null || tVar.f1072a != oVar) {
            this.e = new r(oVar);
        }
        return this.e;
    }

    public final t h(RecyclerView.o oVar) {
        t tVar = this.d;
        if (tVar == null || tVar.f1072a != oVar) {
            this.d = new s(oVar);
        }
        return this.d;
    }
}
