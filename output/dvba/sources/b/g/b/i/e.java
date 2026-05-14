package b.g.b.i;

import b.g.b.i.d;
import b.g.b.i.l.b;
import b.g.b.i.l.m;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e extends k {
    public int l0;
    public int m0;
    public b.g.b.i.l.b g0 = new b.g.b.i.l.b(this);
    public b.g.b.i.l.e h0 = new b.g.b.i.l.e(this);
    public b.InterfaceC0023b i0 = null;
    public boolean j0 = false;
    public b.g.b.d k0 = new b.g.b.d();
    public int n0 = 0;
    public int o0 = 0;
    public b[] p0 = new b[4];
    public b[] q0 = new b[4];
    public int r0 = 263;
    public boolean s0 = false;
    public boolean t0 = false;

    @Override // b.g.b.i.d
    public void C(boolean z, boolean z2) {
        super.C(z, z2);
        int size = this.f0.size();
        for (int i = 0; i < size; i++) {
            this.f0.get(i).C(z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0215 A[PHI: r0 r14
  0x0215: PHI (r0v30 boolean) = (r0v29 boolean), (r0v32 boolean), (r0v32 boolean), (r0v32 boolean) binds: [B:93:0x01df, B:101:0x01ff, B:102:0x0201, B:104:0x0207] A[DONT_GENERATE, DONT_INLINE]
  0x0215: PHI (r14v5 boolean) = (r14v4 boolean), (r14v7 boolean), (r14v7 boolean), (r14v7 boolean) binds: [B:93:0x01df, B:101:0x01ff, B:102:0x0201, B:104:0x0207] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1 A[Catch: Exception -> 0x00dd, TryCatch #1 {Exception -> 0x00dd, blocks: (B:39:0x00b2, B:41:0x00b8, B:52:0x00d1, B:44:0x00bd, B:46:0x00c1, B:53:0x00d7, B:49:0x00cb), top: B:115:0x00b2 }] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v13 */
    @Override // b.g.b.i.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E() {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.e.E():void");
    }

    public void F(d dVar, int i) {
        if (i == 0) {
            int i2 = this.n0 + 1;
            b[] bVarArr = this.q0;
            if (i2 >= bVarArr.length) {
                this.q0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            this.q0[this.n0] = new b(dVar, 0, this.j0);
            this.n0++;
            return;
        }
        if (i == 1) {
            int i3 = this.o0 + 1;
            b[] bVarArr2 = this.p0;
            if (i3 >= bVarArr2.length) {
                this.p0 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length * 2);
            }
            this.p0[this.o0] = new b(dVar, 1, this.j0);
            this.o0++;
        }
    }

    public boolean G(b.g.b.d dVar) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        b(dVar);
        int size = this.f0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            d dVar2 = this.f0.get(i);
            boolean[] zArr = dVar2.I;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar2 instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                d dVar3 = this.f0.get(i2);
                if (dVar3 instanceof a) {
                    a aVar3 = (a) dVar3;
                    for (int i3 = 0; i3 < aVar3.g0; i3++) {
                        d dVar4 = aVar3.f0[i3];
                        int i4 = aVar3.h0;
                        if (i4 == 0 || i4 == 1) {
                            dVar4.I[0] = true;
                        } else if (i4 == 2 || i4 == 3) {
                            dVar4.I[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            d dVar5 = this.f0.get(i5);
            if (dVar5 == null) {
                throw null;
            }
            if ((dVar5 instanceof j) || (dVar5 instanceof f)) {
                dVar5.b(dVar);
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            d dVar6 = this.f0.get(i6);
            if (dVar6 instanceof e) {
                d.a[] aVarArr = dVar6.J;
                d.a aVar4 = aVarArr[0];
                d.a aVar5 = aVarArr[1];
                if (aVar4 == aVar2) {
                    aVarArr[0] = aVar;
                }
                if (aVar5 == aVar2) {
                    dVar6.J[1] = aVar;
                }
                dVar6.b(dVar);
                if (aVar4 == aVar2) {
                    dVar6.x(aVar4);
                }
                if (aVar5 == aVar2) {
                    dVar6.A(aVar5);
                }
            } else {
                d.a aVar6 = d.a.MATCH_PARENT;
                dVar6.h = -1;
                dVar6.i = -1;
                if (this.J[0] != aVar2 && dVar6.J[0] == aVar6) {
                    int i7 = dVar6.y.e;
                    int iO = o() - dVar6.A.e;
                    c cVar = dVar6.y;
                    cVar.g = dVar.l(cVar);
                    c cVar2 = dVar6.A;
                    cVar2.g = dVar.l(cVar2);
                    dVar.e(dVar6.y.g, i7);
                    dVar.e(dVar6.A.g, iO);
                    dVar6.h = 2;
                    dVar6.P = i7;
                    int i8 = iO - i7;
                    dVar6.L = i8;
                    int i9 = dVar6.S;
                    if (i8 < i9) {
                        dVar6.L = i9;
                    }
                }
                if (this.J[1] != aVar2 && dVar6.J[1] == aVar6) {
                    int i10 = dVar6.z.e;
                    int i11 = i() - dVar6.B.e;
                    c cVar3 = dVar6.z;
                    cVar3.g = dVar.l(cVar3);
                    c cVar4 = dVar6.B;
                    cVar4.g = dVar.l(cVar4);
                    dVar.e(dVar6.z.g, i10);
                    dVar.e(dVar6.B.g, i11);
                    if (dVar6.R > 0 || dVar6.X == 8) {
                        c cVar5 = dVar6.C;
                        cVar5.g = dVar.l(cVar5);
                        dVar.e(dVar6.C.g, dVar6.R + i10);
                    }
                    dVar6.i = 2;
                    dVar6.Q = i10;
                    int i12 = i11 - i10;
                    dVar6.M = i12;
                    int i13 = dVar6.T;
                    if (i12 < i13) {
                        dVar6.M = i13;
                    }
                }
                if (!((dVar6 instanceof j) || (dVar6 instanceof f))) {
                    dVar6.b(dVar);
                }
            }
        }
        if (this.n0 > 0) {
            a.a.a.a.a.a(this, dVar, 0);
        }
        if (this.o0 > 0) {
            a.a.a.a.a.a(this, dVar, 1);
        }
        return true;
    }

    public boolean H(boolean z, int i) {
        b.g.b.i.l.g gVar;
        int i2;
        boolean z2;
        b.g.b.i.l.g gVar2;
        int i3;
        b.g.b.i.l.e eVar = this.h0;
        d.a aVar = d.a.MATCH_PARENT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        d.a aVarH = eVar.f640a.h(0);
        d.a aVarH2 = eVar.f640a.h(1);
        int iP = eVar.f640a.p();
        int iQ = eVar.f640a.q();
        if (z4 && (aVarH == aVar2 || aVarH2 == aVar2)) {
            Iterator<m> it = eVar.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next.f == i && !next.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && aVarH == aVar2) {
                    e eVar2 = eVar.f640a;
                    eVar2.J[0] = aVar3;
                    eVar2.B(eVar.d(eVar2, 0));
                    e eVar3 = eVar.f640a;
                    gVar2 = eVar3.d.e;
                    i3 = eVar3.o();
                    gVar2.c(i3);
                }
            } else if (z4 && aVarH2 == aVar2) {
                e eVar4 = eVar.f640a;
                eVar4.J[1] = aVar3;
                eVar4.w(eVar.d(eVar4, 1));
                e eVar5 = eVar.f640a;
                gVar2 = eVar5.e.e;
                i3 = eVar5.i();
                gVar2.c(i3);
            }
        }
        d.a[] aVarArr = eVar.f640a.J;
        if (i == 0) {
            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar) {
                int iO = eVar.f640a.o() + iP;
                eVar.f640a.d.i.c(iO);
                gVar = eVar.f640a.d.e;
                i2 = iO - iP;
                gVar.c(i2);
                z2 = true;
            }
            z2 = false;
        } else {
            if (aVarArr[1] == aVar3 || aVarArr[1] == aVar) {
                int i4 = eVar.f640a.i() + iQ;
                eVar.f640a.e.i.c(i4);
                gVar = eVar.f640a.e.e;
                i2 = i4 - iQ;
                gVar.c(i2);
                z2 = true;
            }
            z2 = false;
        }
        eVar.g();
        for (m mVar : eVar.e) {
            if (mVar.f == i && (mVar.f652b != eVar.f640a || mVar.g)) {
                mVar.e();
            }
        }
        for (m mVar2 : eVar.e) {
            if (mVar2.f == i && (z2 || mVar2.f652b != eVar.f640a)) {
                if (!mVar2.h.j || !mVar2.i.j || (!(mVar2 instanceof b.g.b.i.l.c) && !mVar2.e.j)) {
                    z3 = false;
                    break;
                }
            }
        }
        eVar.f640a.x(aVarH);
        eVar.f640a.A(aVarH2);
        return z3;
    }

    public void I() {
        this.h0.f641b = true;
    }

    public void J(int i) {
        this.r0 = i;
        b.g.b.d.r = i.a(i, 256);
    }

    @Override // b.g.b.i.k, b.g.b.i.d
    public void u() {
        this.k0.t();
        this.l0 = 0;
        this.m0 = 0;
        super.u();
    }
}
