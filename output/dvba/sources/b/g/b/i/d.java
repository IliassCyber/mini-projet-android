package b.g.b.i;

import b.g.b.i.c;
import b.g.b.i.l.l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public c F;
    public c[] G;
    public ArrayList<c> H;
    public boolean[] I;
    public a[] J;
    public d K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public float V;
    public Object W;
    public int X;
    public String Y;
    public String Z;
    public int a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.g.b.i.l.c f629b;
    public int b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.g.b.i.l.c f630c;
    public float[] c0;
    public d[] d0;
    public d[] e0;
    public boolean x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f628a = false;
    public b.g.b.i.l.j d = new b.g.b.i.l.j(this);
    public l e = new l(this);
    public boolean[] f = {true, true};
    public int[] g = {0, 0, 0, 0};
    public int h = -1;
    public int i = -1;
    public int j = 0;
    public int k = 0;
    public int[] l = new int[2];
    public int m = 0;
    public int n = 0;
    public float o = 1.0f;
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = -1;
    public float t = 1.0f;
    public int[] u = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float v = 0.0f;
    public boolean w = false;
    public c y = new c(this, c.a.LEFT);
    public c z = new c(this, c.a.TOP);
    public c A = new c(this, c.a.RIGHT);
    public c B = new c(this, c.a.BOTTOM);
    public c C = new c(this, c.a.BASELINE);
    public c D = new c(this, c.a.CENTER_X);
    public c E = new c(this, c.a.CENTER_Y);

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, c.a.CENTER);
        this.F = cVar;
        this.G = new c[]{this.y, this.A, this.z, this.B, this.C, cVar};
        ArrayList<c> arrayList = new ArrayList<>();
        this.H = arrayList;
        this.I = new boolean[2];
        a aVar = a.FIXED;
        this.J = new a[]{aVar, aVar};
        this.K = null;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        this.X = 0;
        this.Y = null;
        this.Z = null;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = new float[]{-1.0f, -1.0f};
        this.d0 = new d[]{null, null};
        this.e0 = new d[]{null, null};
        arrayList.add(this.y);
        this.H.add(this.z);
        this.H.add(this.A);
        this.H.add(this.B);
        this.H.add(this.D);
        this.H.add(this.E);
        this.H.add(this.F);
        this.H.add(this.C);
    }

    public void A(a aVar) {
        this.J[1] = aVar;
    }

    public void B(int i) {
        this.L = i;
        int i2 = this.S;
        if (i < i2) {
            this.L = i2;
        }
    }

    public void C(boolean z, boolean z2) {
        int i;
        int i2;
        a aVar = a.FIXED;
        b.g.b.i.l.j jVar = this.d;
        boolean z3 = z & jVar.g;
        l lVar = this.e;
        boolean z4 = z2 & lVar.g;
        int i3 = jVar.h.g;
        int i4 = lVar.h.g;
        int i5 = jVar.i.g;
        int i6 = lVar.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.P = i3;
        }
        if (z4) {
            this.Q = i4;
        }
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (z3) {
            if (this.J[0] == aVar && i8 < (i2 = this.L)) {
                i8 = i2;
            }
            this.L = i8;
            int i10 = this.S;
            if (i8 < i10) {
                this.L = i10;
            }
        }
        if (z4) {
            if (this.J[1] == aVar && i9 < (i = this.M)) {
                i9 = i;
            }
            this.M = i9;
            int i11 = this.T;
            if (i9 < i11) {
                this.M = i11;
            }
        }
    }

    public void D(b.g.b.d dVar) {
        int i;
        int i2;
        int iO = dVar.o(this.y);
        int iO2 = dVar.o(this.z);
        int iO3 = dVar.o(this.A);
        int iO4 = dVar.o(this.B);
        b.g.b.i.l.j jVar = this.d;
        b.g.b.i.l.f fVar = jVar.h;
        if (fVar.j) {
            b.g.b.i.l.f fVar2 = jVar.i;
            if (fVar2.j) {
                iO = fVar.g;
                iO3 = fVar2.g;
            }
        }
        l lVar = this.e;
        b.g.b.i.l.f fVar3 = lVar.h;
        if (fVar3.j) {
            b.g.b.i.l.f fVar4 = lVar.i;
            if (fVar4.j) {
                iO2 = fVar3.g;
                iO4 = fVar4.g;
            }
        }
        int i3 = iO4 - iO2;
        if (iO3 - iO < 0 || i3 < 0 || iO == Integer.MIN_VALUE || iO == Integer.MAX_VALUE || iO2 == Integer.MIN_VALUE || iO2 == Integer.MAX_VALUE || iO3 == Integer.MIN_VALUE || iO3 == Integer.MAX_VALUE || iO4 == Integer.MIN_VALUE || iO4 == Integer.MAX_VALUE) {
            iO4 = 0;
            iO = 0;
            iO2 = 0;
            iO3 = 0;
        }
        a aVar = a.FIXED;
        int i4 = iO3 - iO;
        int i5 = iO4 - iO2;
        this.P = iO;
        this.Q = iO2;
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (this.J[0] == aVar && i4 < (i2 = this.L)) {
            i4 = i2;
        }
        if (this.J[1] == aVar && i5 < (i = this.M)) {
            i5 = i;
        }
        this.L = i4;
        this.M = i5;
        int i6 = this.T;
        if (i5 < i6) {
            this.M = i6;
        }
        int i7 = this.L;
        int i8 = this.S;
        if (i7 < i8) {
            this.L = i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(b.g.b.d r45) {
        /*
            Method dump skipped, instruction units count: 1532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.d.b(b.g.b.d):void");
    }

    public boolean c() {
        return this.X != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0279 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:297:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:300:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(b.g.b.d r30, boolean r31, boolean r32, boolean r33, boolean r34, b.g.b.g r35, b.g.b.g r36, b.g.b.i.d.a r37, boolean r38, b.g.b.i.c r39, b.g.b.i.c r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instruction units count: 1025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.d.d(b.g.b.d, boolean, boolean, boolean, boolean, b.g.b.g, b.g.b.g, b.g.b.i.d$a, boolean, b.g.b.i.c, b.g.b.i.c, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void e(b.g.b.d dVar) {
        dVar.l(this.y);
        dVar.l(this.z);
        dVar.l(this.A);
        dVar.l(this.B);
        if (this.R > 0) {
            dVar.l(this.C);
        }
    }

    public c f(c.a aVar) {
        switch (aVar) {
            case NONE:
                return null;
            case LEFT:
                return this.y;
            case TOP:
                return this.z;
            case RIGHT:
                return this.A;
            case BOTTOM:
                return this.B;
            case BASELINE:
                return this.C;
            case CENTER:
                return this.F;
            case CENTER_X:
                return this.D;
            case CENTER_Y:
                return this.E;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int g() {
        return q() + this.M;
    }

    public a h(int i) {
        if (i == 0) {
            return j();
        }
        if (i == 1) {
            return n();
        }
        return null;
    }

    public int i() {
        if (this.X == 8) {
            return 0;
        }
        return this.M;
    }

    public a j() {
        return this.J[0];
    }

    public d k(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i == 1 && (cVar2 = (cVar = this.B).d) != null && cVar2.d == cVar) {
                return cVar2.f624b;
            }
            return null;
        }
        c cVar3 = this.A;
        c cVar4 = cVar3.d;
        if (cVar4 == null || cVar4.d != cVar3) {
            return null;
        }
        return cVar4.f624b;
    }

    public d l(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i == 1 && (cVar2 = (cVar = this.z).d) != null && cVar2.d == cVar) {
                return cVar2.f624b;
            }
            return null;
        }
        c cVar3 = this.y;
        c cVar4 = cVar3.d;
        if (cVar4 == null || cVar4.d != cVar3) {
            return null;
        }
        return cVar4.f624b;
    }

    public int m() {
        return p() + this.L;
    }

    public a n() {
        return this.J[1];
    }

    public int o() {
        if (this.X == 8) {
            return 0;
        }
        return this.L;
    }

    public int p() {
        d dVar = this.K;
        return (dVar == null || !(dVar instanceof e)) ? this.P : ((e) dVar).l0 + this.P;
    }

    public int q() {
        d dVar = this.K;
        return (dVar == null || !(dVar instanceof e)) ? this.Q : ((e) dVar).m0 + this.Q;
    }

    public final boolean r(int i) {
        int i2 = i * 2;
        c[] cVarArr = this.G;
        if (cVarArr[i2].d != null && cVarArr[i2].d.d != cVarArr[i2]) {
            int i3 = i2 + 1;
            if (cVarArr[i3].d != null && cVarArr[i3].d.d == cVarArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean s() {
        c cVar = this.y;
        c cVar2 = cVar.d;
        if (cVar2 != null && cVar2.d == cVar) {
            return true;
        }
        c cVar3 = this.A;
        c cVar4 = cVar3.d;
        return cVar4 != null && cVar4.d == cVar3;
    }

    public boolean t() {
        c cVar = this.z;
        c cVar2 = cVar.d;
        if (cVar2 != null && cVar2.d == cVar) {
            return true;
        }
        c cVar3 = this.B;
        c cVar4 = cVar3.d;
        return cVar4 != null && cVar4.d == cVar3;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        String string2 = "";
        if (this.Z != null) {
            StringBuilder sbE = c.a.a.a.a.e("type: ");
            sbE.append(this.Z);
            sbE.append(" ");
            string = sbE.toString();
        } else {
            string = "";
        }
        sb.append(string);
        if (this.Y != null) {
            StringBuilder sbE2 = c.a.a.a.a.e("id: ");
            sbE2.append(this.Y);
            sbE2.append(" ");
            string2 = sbE2.toString();
        }
        sb.append(string2);
        sb.append("(");
        sb.append(this.P);
        sb.append(", ");
        sb.append(this.Q);
        sb.append(") - (");
        sb.append(this.L);
        sb.append(" x ");
        sb.append(this.M);
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        this.y.e();
        this.z.e();
        this.A.e();
        this.B.e();
        this.C.e();
        this.D.e();
        this.E.e();
        this.F.e();
        this.K = null;
        this.v = 0.0f;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        a[] aVarArr = this.J;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.W = null;
        this.X = 0;
        this.Z = null;
        this.a0 = 0;
        this.b0 = 0;
        float[] fArr = this.c0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.h = -1;
        this.i = -1;
        int[] iArr = this.u;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.j = 0;
        this.k = 0;
        this.o = 1.0f;
        this.r = 1.0f;
        this.n = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.m = 0;
        this.p = 0;
        this.s = -1;
        this.t = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.I;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void v(b.g.b.c cVar) {
        this.y.f();
        this.z.f();
        this.A.f();
        this.B.f();
        this.C.f();
        this.F.f();
        this.D.f();
        this.E.f();
    }

    public void w(int i) {
        this.M = i;
        int i2 = this.T;
        if (i < i2) {
            this.M = i2;
        }
    }

    public void x(a aVar) {
        this.J[0] = aVar;
    }

    public void y(int i) {
        if (i < 0) {
            i = 0;
        }
        this.T = i;
    }

    public void z(int i) {
        if (i < 0) {
            i = 0;
        }
        this.S = i;
    }
}
