package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import b.r.d.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends RecyclerView.l {
    public boolean g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f194a;
        int i4 = cVar.f195b;
        if (d0Var2.u()) {
            int i5 = cVar.f194a;
            i2 = cVar.f195b;
            i = i5;
        } else {
            i = cVar2.f194a;
            i2 = cVar2.f195b;
        }
        k kVar = (k) this;
        if (d0Var == d0Var2) {
            return kVar.j(d0Var, i3, i4, i, i2);
        }
        float translationX = d0Var.f184a.getTranslationX();
        float translationY = d0Var.f184a.getTranslationY();
        float alpha = d0Var.f184a.getAlpha();
        kVar.o(d0Var);
        d0Var.f184a.setTranslationX(translationX);
        d0Var.f184a.setTranslationY(translationY);
        d0Var.f184a.setAlpha(alpha);
        kVar.o(d0Var2);
        d0Var2.f184a.setTranslationX(-((int) ((i - i3) - translationX)));
        d0Var2.f184a.setTranslationY(-((int) ((i2 - i4) - translationY)));
        d0Var2.f184a.setAlpha(0.0f);
        kVar.k.add(new k.a(d0Var, d0Var2, i3, i4, i, i2));
        return true;
    }

    public abstract boolean j(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4);
}
