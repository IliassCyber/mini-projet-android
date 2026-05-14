package b.g.b.i;

import b.g.b.i.c;
import b.g.b.i.d;

/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    public float f0 = -1.0f;
    public int g0 = -1;
    public int h0 = -1;
    public c i0 = this.z;
    public int j0 = 0;

    public f() {
        this.H.clear();
        this.H.add(this.i0);
        int length = this.G.length;
        for (int i = 0; i < length; i++) {
            this.G[i] = this.i0;
        }
    }

    @Override // b.g.b.i.d
    public void D(b.g.b.d dVar) {
        if (this.K == null) {
            return;
        }
        int iO = dVar.o(this.i0);
        if (this.j0 == 1) {
            this.P = iO;
            this.Q = 0;
            w(this.K.i());
            B(0);
            return;
        }
        this.P = 0;
        this.Q = iO;
        B(this.K.o());
        w(0);
    }

    public void E(int i) {
        if (this.j0 == i) {
            return;
        }
        this.j0 = i;
        this.H.clear();
        this.i0 = this.j0 == 1 ? this.y : this.z;
        this.H.add(this.i0);
        int length = this.G.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.G[i2] = this.i0;
        }
    }

    @Override // b.g.b.i.d
    public void b(b.g.b.d dVar) {
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar = (e) this.K;
        if (eVar == null) {
            return;
        }
        c cVarF = eVar.f(c.a.LEFT);
        c cVarF2 = eVar.f(c.a.RIGHT);
        d dVar2 = this.K;
        boolean z = dVar2 != null && dVar2.J[0] == aVar;
        if (this.j0 == 0) {
            cVarF = eVar.f(c.a.TOP);
            cVarF2 = eVar.f(c.a.BOTTOM);
            d dVar3 = this.K;
            z = dVar3 != null && dVar3.J[1] == aVar;
        }
        if (this.g0 != -1) {
            b.g.b.g gVarL = dVar.l(this.i0);
            dVar.d(gVarL, dVar.l(cVarF), this.g0, 8);
            if (z) {
                dVar.f(dVar.l(cVarF2), gVarL, 0, 5);
                return;
            }
            return;
        }
        if (this.h0 != -1) {
            b.g.b.g gVarL2 = dVar.l(this.i0);
            b.g.b.g gVarL3 = dVar.l(cVarF2);
            dVar.d(gVarL2, gVarL3, -this.h0, 8);
            if (z) {
                dVar.f(gVarL2, dVar.l(cVarF), 0, 5);
                dVar.f(gVarL3, gVarL2, 0, 5);
                return;
            }
            return;
        }
        if (this.f0 != -1.0f) {
            b.g.b.g gVarL4 = dVar.l(this.i0);
            b.g.b.g gVarL5 = dVar.l(cVarF2);
            float f = this.f0;
            b.g.b.b bVarM = dVar.m();
            bVarM.e.j(gVarL4, -1.0f);
            bVarM.e.j(gVarL5, f);
            dVar.c(bVarM);
        }
    }

    @Override // b.g.b.i.d
    public boolean c() {
        return true;
    }

    @Override // b.g.b.i.d
    public c f(c.a aVar) {
        switch (aVar) {
            case NONE:
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
                return null;
            case LEFT:
            case RIGHT:
                if (this.j0 == 1) {
                    return this.i0;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.j0 == 0) {
                    return this.i0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }
}
