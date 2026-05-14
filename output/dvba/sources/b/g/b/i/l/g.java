package b.g.b.i.l;

import b.g.b.i.l.f;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {
    public int m;

    public g(m mVar) {
        super(mVar);
        this.e = mVar instanceof j ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // b.g.b.i.l.f
    public void c(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (d dVar : this.k) {
            dVar.a(dVar);
        }
    }
}
