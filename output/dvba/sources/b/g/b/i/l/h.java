package b.g.b.i.l;

/* JADX INFO: loaded from: classes.dex */
public class h extends m {
    public h(b.g.b.i.d dVar) {
        super(dVar);
        dVar.d.f();
        dVar.e.f();
        this.f = ((b.g.b.i.f) dVar).j0;
    }

    @Override // b.g.b.i.l.m, b.g.b.i.l.d
    public void a(d dVar) {
        f fVar = this.h;
        if (fVar.f645c && !fVar.j) {
            this.h.c((int) ((fVar.l.get(0).g * ((b.g.b.i.f) this.f652b).f0) + 0.5f));
        }
    }

    @Override // b.g.b.i.l.m
    public void d() {
        m mVar;
        b.g.b.i.d dVar = this.f652b;
        b.g.b.i.f fVar = (b.g.b.i.f) dVar;
        int i = fVar.g0;
        int i2 = fVar.h0;
        if (fVar.j0 == 1) {
            f fVar2 = this.h;
            if (i != -1) {
                fVar2.l.add(dVar.K.d.h);
                this.f652b.K.d.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                fVar2.l.add(dVar.K.d.i);
                this.f652b.K.d.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                fVar2.f644b = true;
                fVar2.l.add(dVar.K.d.i);
                this.f652b.K.d.i.k.add(this.h);
            }
            m(this.f652b.d.h);
            mVar = this.f652b.d;
        } else {
            f fVar3 = this.h;
            if (i != -1) {
                fVar3.l.add(dVar.K.e.h);
                this.f652b.K.e.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                fVar3.l.add(dVar.K.e.i);
                this.f652b.K.e.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                fVar3.f644b = true;
                fVar3.l.add(dVar.K.e.i);
                this.f652b.K.e.i.k.add(this.h);
            }
            m(this.f652b.e.h);
            mVar = this.f652b.e;
        }
        m(mVar.i);
    }

    @Override // b.g.b.i.l.m
    public void e() {
        b.g.b.i.d dVar = this.f652b;
        if (((b.g.b.i.f) dVar).j0 == 1) {
            dVar.P = this.h.g;
        } else {
            dVar.Q = this.h.g;
        }
    }

    @Override // b.g.b.i.l.m
    public void f() {
        this.h.b();
    }

    @Override // b.g.b.i.l.m
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }
}
