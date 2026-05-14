package b.g.b.i;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k extends d {
    public ArrayList<d> f0 = new ArrayList<>();

    public void E() {
        ArrayList<d> arrayList = this.f0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.f0.get(i);
            if (dVar instanceof k) {
                ((k) dVar).E();
            }
        }
    }

    @Override // b.g.b.i.d
    public void u() {
        this.f0.clear();
        super.u();
    }

    @Override // b.g.b.i.d
    public void v(b.g.b.c cVar) {
        super.v(cVar);
        int size = this.f0.size();
        for (int i = 0; i < size; i++) {
            this.f0.get(i).v(cVar);
        }
    }
}
