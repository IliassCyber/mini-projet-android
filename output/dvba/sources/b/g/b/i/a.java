package b.g.b.i;

import b.g.b.i.d;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {
    public int h0 = 0;
    public boolean i0 = true;
    public int j0 = 0;

    @Override // b.g.b.i.d
    public void b(b.g.b.d dVar) {
        c[] cVarArr;
        boolean z;
        b.g.b.g gVar;
        c cVar;
        int i;
        int i2;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        c[] cVarArr2 = this.G;
        cVarArr2[0] = this.y;
        cVarArr2[2] = this.z;
        cVarArr2[1] = this.A;
        cVarArr2[3] = this.B;
        int i3 = 0;
        while (true) {
            cVarArr = this.G;
            if (i3 >= cVarArr.length) {
                break;
            }
            cVarArr[i3].g = dVar.l(cVarArr[i3]);
            i3++;
        }
        int i4 = this.h0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        c cVar2 = cVarArr[i4];
        for (int i5 = 0; i5 < this.g0; i5++) {
            d dVar2 = this.f0[i5];
            if ((this.i0 || dVar2.c()) && ((((i = this.h0) == 0 || i == 1) && dVar2.j() == aVar && dVar2.y.d != null && dVar2.A.d != null) || (((i2 = this.h0) == 2 || i2 == 3) && dVar2.n() == aVar && dVar2.z.d != null && dVar2.B.d != null))) {
                z = true;
                break;
            }
        }
        z = false;
        boolean z2 = this.y.c() || this.A.c();
        boolean z3 = this.z.c() || this.B.c();
        int i6 = !z && ((this.h0 == 0 && z2) || ((this.h0 == 2 && z3) || ((this.h0 == 1 && z2) || (this.h0 == 3 && z3)))) ? 5 : 4;
        for (int i7 = 0; i7 < this.g0; i7++) {
            d dVar3 = this.f0[i7];
            if (this.i0 || dVar3.c()) {
                b.g.b.g gVarL = dVar.l(dVar3.G[this.h0]);
                c[] cVarArr3 = dVar3.G;
                int i8 = this.h0;
                cVarArr3[i8].g = gVarL;
                int i9 = (cVarArr3[i8].d == null || cVarArr3[i8].d.f624b != this) ? 0 : cVarArr3[i8].e + 0;
                int i10 = this.h0;
                if (i10 == 0 || i10 == 2) {
                    b.g.b.g gVar2 = cVar2.g;
                    int i11 = this.j0 - i9;
                    b.g.b.b bVarM = dVar.m();
                    b.g.b.g gVarN = dVar.n();
                    gVarN.e = 0;
                    bVarM.f(gVar2, gVarL, gVarN, i11);
                    dVar.c(bVarM);
                } else {
                    b.g.b.g gVar3 = cVar2.g;
                    int i12 = this.j0 + i9;
                    b.g.b.b bVarM2 = dVar.m();
                    b.g.b.g gVarN2 = dVar.n();
                    gVarN2.e = 0;
                    bVarM2.e(gVar3, gVarL, gVarN2, i12);
                    dVar.c(bVarM2);
                }
                dVar.d(cVar2.g, gVarL, this.j0 + i9, i6);
            }
        }
        int i13 = this.h0;
        if (i13 == 0) {
            dVar.d(this.A.g, this.y.g, 0, 8);
            dVar.d(this.y.g, this.K.A.g, 0, 4);
            gVar = this.y.g;
            cVar = this.K.y;
        } else if (i13 == 1) {
            dVar.d(this.y.g, this.A.g, 0, 8);
            dVar.d(this.y.g, this.K.y.g, 0, 4);
            gVar = this.y.g;
            cVar = this.K.A;
        } else if (i13 == 2) {
            dVar.d(this.B.g, this.z.g, 0, 8);
            dVar.d(this.z.g, this.K.B.g, 0, 4);
            gVar = this.z.g;
            cVar = this.K.z;
        } else {
            if (i13 != 3) {
                return;
            }
            dVar.d(this.z.g, this.B.g, 0, 8);
            dVar.d(this.z.g, this.K.z.g, 0, 4);
            gVar = this.z.g;
            cVar = this.K.B;
        }
        dVar.d(gVar, cVar.g, 0, 0);
    }

    @Override // b.g.b.i.d
    public boolean c() {
        return true;
    }

    @Override // b.g.b.i.d
    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("[Barrier] ");
        sbE.append(this.Y);
        sbE.append(" {");
        String string = sbE.toString();
        for (int i = 0; i < this.g0; i++) {
            d dVar = this.f0[i];
            if (i > 0) {
                string = c.a.a.a.a.c(string, ", ");
            }
            StringBuilder sbE2 = c.a.a.a.a.e(string);
            sbE2.append(dVar.Y);
            string = sbE2.toString();
        }
        return c.a.a.a.a.c(string, "}");
    }
}
