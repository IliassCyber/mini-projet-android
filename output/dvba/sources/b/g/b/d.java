package b.g.b;

import b.g.b.b;
import b.g.b.g;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int q = 1000;
    public static boolean r = true;
    public static long s;
    public static long t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f607c;
    public b.g.b.b[] f;
    public final c m;
    public a p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f605a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, g> f606b = null;
    public int d = 32;
    public int e = 32;
    public boolean g = false;
    public boolean h = false;
    public boolean[] i = new boolean[32];
    public int j = 1;
    public int k = 0;
    public int l = 32;
    public g[] n = new g[q];
    public int o = 0;

    public interface a {
        void a(g gVar);

        g b(d dVar, boolean[] zArr);

        void clear();
    }

    public class b extends b.g.b.b {
        public b(d dVar, c cVar) {
            this.e = new h(this, cVar);
        }
    }

    public d() {
        this.f = null;
        this.f = new b.g.b.b[32];
        s();
        c cVar = new c();
        this.m = cVar;
        this.f607c = new f(cVar);
        this.p = r ? new b(this, this.m) : new b.g.b.b(this.m);
    }

    public final g a(g.a aVar, String str) {
        g gVarA = this.m.f604c.a();
        if (gVarA == null) {
            gVarA = new g(aVar);
        } else {
            gVarA.c();
        }
        gVarA.j = aVar;
        int i = this.o;
        int i2 = q;
        if (i >= i2) {
            int i3 = i2 * 2;
            q = i3;
            this.n = (g[]) Arrays.copyOf(this.n, i3);
        }
        g[] gVarArr = this.n;
        int i4 = this.o;
        this.o = i4 + 1;
        gVarArr[i4] = gVarA;
        return gVarA;
    }

    public void b(g gVar, g gVar2, int i, float f, g gVar3, g gVar4, int i2, int i3) {
        int i4;
        float f2;
        b.g.b.b bVarM = m();
        if (gVar2 == gVar3) {
            bVarM.e.j(gVar, 1.0f);
            bVarM.e.j(gVar4, 1.0f);
            bVarM.e.j(gVar2, -2.0f);
        } else {
            if (f == 0.5f) {
                bVarM.e.j(gVar, 1.0f);
                bVarM.e.j(gVar2, -1.0f);
                bVarM.e.j(gVar3, -1.0f);
                bVarM.e.j(gVar4, 1.0f);
                if (i > 0 || i2 > 0) {
                    i4 = (-i) + i2;
                    f2 = i4;
                }
            } else if (f <= 0.0f) {
                bVarM.e.j(gVar, -1.0f);
                bVarM.e.j(gVar2, 1.0f);
                f2 = i;
            } else if (f >= 1.0f) {
                bVarM.e.j(gVar4, -1.0f);
                bVarM.e.j(gVar3, 1.0f);
                i4 = -i2;
                f2 = i4;
            } else {
                float f3 = 1.0f - f;
                bVarM.e.j(gVar, f3 * 1.0f);
                bVarM.e.j(gVar2, f3 * (-1.0f));
                bVarM.e.j(gVar3, (-1.0f) * f);
                bVarM.e.j(gVar4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    bVarM.f600b = (i2 * f) + ((-i) * f3);
                }
            }
            bVarM.f600b = f2;
        }
        if (i3 != 8) {
            bVarM.c(this, i3);
        }
        c(bVarM);
    }

    public void c(b.g.b.b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g gVarI;
        g.a aVar = g.a.UNRESTRICTED;
        boolean z4 = true;
        if (this.k + 1 >= this.l || this.j + 1 >= this.e) {
            p();
        }
        if (bVar.f) {
            z = false;
        } else {
            if (this.f.length != 0) {
                boolean z5 = false;
                while (!z5) {
                    int iK = bVar.e.k();
                    for (int i = 0; i < iK; i++) {
                        g gVarD = bVar.e.d(i);
                        if (gVarD.d != -1 || gVarD.g) {
                            bVar.d.add(gVarD);
                        }
                    }
                    if (bVar.d.size() > 0) {
                        for (g gVar : bVar.d) {
                            if (gVar.g) {
                                bVar.k(gVar, true);
                            } else {
                                bVar.l(this.f[gVar.d], true);
                            }
                        }
                        bVar.d.clear();
                    } else {
                        z5 = true;
                    }
                }
            }
            if (bVar.f599a == null && bVar.f600b == 0.0f && bVar.e.k() == 0) {
                return;
            }
            float f = bVar.f600b;
            if (f < 0.0f) {
                bVar.f600b = f * (-1.0f);
                bVar.e.i();
            }
            int iK2 = bVar.e.k();
            g gVar2 = null;
            g gVar3 = null;
            float f2 = 0.0f;
            boolean zH = false;
            float f3 = 0.0f;
            boolean zH2 = false;
            for (int i2 = 0; i2 < iK2; i2++) {
                float fA = bVar.e.a(i2);
                g gVarD2 = bVar.e.d(i2);
                if (gVarD2.j == aVar) {
                    if (gVar2 == null || f2 > fA) {
                        zH = bVar.h(gVarD2);
                        f2 = fA;
                        gVar2 = gVarD2;
                    } else if (!zH && bVar.h(gVarD2)) {
                        f2 = fA;
                        gVar2 = gVarD2;
                        zH = true;
                    }
                } else if (gVar2 == null && fA < 0.0f) {
                    if (gVar3 == null || f3 > fA) {
                        zH2 = bVar.h(gVarD2);
                        f3 = fA;
                        gVar3 = gVarD2;
                    } else if (!zH2 && bVar.h(gVarD2)) {
                        f3 = fA;
                        gVar3 = gVarD2;
                        zH2 = true;
                    }
                }
            }
            if (gVar2 == null) {
                gVar2 = gVar3;
            }
            if (gVar2 == null) {
                z2 = true;
            } else {
                bVar.j(gVar2);
                z2 = false;
            }
            if (bVar.e.k() == 0) {
                bVar.f = true;
            }
            if (z2) {
                if (this.j + 1 >= this.e) {
                    p();
                }
                g gVarA = a(g.a.SLACK, null);
                int i3 = this.f605a + 1;
                this.f605a = i3;
                this.j++;
                gVarA.f614c = i3;
                this.m.d[i3] = gVarA;
                bVar.f599a = gVarA;
                i(bVar);
                b.g.b.b bVar2 = (b.g.b.b) this.p;
                if (bVar2 == null) {
                    throw null;
                }
                bVar2.f599a = null;
                bVar2.e.clear();
                for (int i4 = 0; i4 < bVar.e.k(); i4++) {
                    bVar2.e.c(bVar.e.d(i4), bVar.e.a(i4), true);
                }
                r(this.p);
                if (gVarA.d == -1) {
                    if (bVar.f599a == gVarA && (gVarI = bVar.i(null, gVarA)) != null) {
                        bVar.j(gVarI);
                    }
                    if (!bVar.f) {
                        bVar.f599a.e(bVar);
                    }
                    this.k--;
                }
                z3 = true;
            } else {
                z3 = false;
            }
            g gVar4 = bVar.f599a;
            if (gVar4 == null || (gVar4.j != aVar && bVar.f600b < 0.0f)) {
                z4 = false;
            }
            if (!z4) {
                return;
            } else {
                z = z3;
            }
        }
        if (z) {
            return;
        }
        i(bVar);
    }

    public b.g.b.b d(g gVar, g gVar2, int i, int i2) {
        if (i2 == 8 && gVar2.g && gVar.d == -1) {
            gVar.d(this, gVar2.f + i);
            return null;
        }
        b.g.b.b bVarM = m();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            bVarM.f600b = i;
        }
        if (z) {
            bVarM.e.j(gVar, 1.0f);
            bVarM.e.j(gVar2, -1.0f);
        } else {
            bVarM.e.j(gVar, -1.0f);
            bVarM.e.j(gVar2, 1.0f);
        }
        if (i2 != 8) {
            bVarM.c(this, i2);
        }
        c(bVarM);
        return bVarM;
    }

    public void e(g gVar, int i) {
        b.g.b.b bVarM;
        b.a aVar;
        float f;
        int i2 = gVar.d;
        if (i2 == -1) {
            gVar.d(this, i);
            return;
        }
        if (i2 != -1) {
            b.g.b.b bVar = this.f[i2];
            if (!bVar.f) {
                if (bVar.e.k() == 0) {
                    bVar.f = true;
                } else {
                    bVarM = m();
                    if (i < 0) {
                        bVarM.f600b = i * (-1);
                        aVar = bVarM.e;
                        f = 1.0f;
                    } else {
                        bVarM.f600b = i;
                        aVar = bVarM.e;
                        f = -1.0f;
                    }
                    aVar.j(gVar, f);
                }
            }
            bVar.f600b = i;
            return;
        }
        bVarM = m();
        bVarM.f599a = gVar;
        float f2 = i;
        gVar.f = f2;
        bVarM.f600b = f2;
        bVarM.f = true;
        c(bVarM);
    }

    public void f(g gVar, g gVar2, int i, int i2) {
        b.g.b.b bVarM = m();
        g gVarN = n();
        gVarN.e = 0;
        bVarM.e(gVar, gVar2, gVarN, i);
        if (i2 != 8) {
            bVarM.e.j(k(i2, null), (int) (bVarM.e.e(gVarN) * (-1.0f)));
        }
        c(bVarM);
    }

    public void g(g gVar, g gVar2, int i, int i2) {
        b.g.b.b bVarM = m();
        g gVarN = n();
        gVarN.e = 0;
        bVarM.f(gVar, gVar2, gVarN, i);
        if (i2 != 8) {
            bVarM.e.j(k(i2, null), (int) (bVarM.e.e(gVarN) * (-1.0f)));
        }
        c(bVarM);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f, int i) {
        b.g.b.b bVarM = m();
        bVarM.d(gVar, gVar2, gVar3, gVar4, f);
        if (i != 8) {
            bVarM.c(this, i);
        }
        c(bVarM);
    }

    public final void i(b.g.b.b bVar) {
        e<b.g.b.b> eVar;
        b.g.b.b bVar2;
        if (r) {
            b.g.b.b[] bVarArr = this.f;
            int i = this.k;
            if (bVarArr[i] != null) {
                eVar = this.m.f602a;
                bVar2 = bVarArr[i];
                eVar.b(bVar2);
            }
        } else {
            b.g.b.b[] bVarArr2 = this.f;
            int i2 = this.k;
            if (bVarArr2[i2] != null) {
                eVar = this.m.f603b;
                bVar2 = bVarArr2[i2];
                eVar.b(bVar2);
            }
        }
        b.g.b.b[] bVarArr3 = this.f;
        int i3 = this.k;
        bVarArr3[i3] = bVar;
        g gVar = bVar.f599a;
        gVar.d = i3;
        this.k = i3 + 1;
        gVar.e(bVar);
    }

    public final void j() {
        for (int i = 0; i < this.k; i++) {
            b.g.b.b bVar = this.f[i];
            bVar.f599a.f = bVar.f600b;
        }
    }

    public g k(int i, String str) {
        if (this.j + 1 >= this.e) {
            p();
        }
        g gVarA = a(g.a.ERROR, str);
        int i2 = this.f605a + 1;
        this.f605a = i2;
        this.j++;
        gVarA.f614c = i2;
        gVarA.e = i;
        this.m.d[i2] = gVarA;
        this.f607c.a(gVarA);
        return gVarA;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.e) {
            p();
        }
        if (obj instanceof b.g.b.i.c) {
            b.g.b.i.c cVar = (b.g.b.i.c) obj;
            gVar = cVar.g;
            if (gVar == null) {
                cVar.f();
                gVar = cVar.g;
            }
            int i = gVar.f614c;
            if (i == -1 || i > this.f605a || this.m.d[i] == null) {
                if (gVar.f614c != -1) {
                    gVar.c();
                }
                int i2 = this.f605a + 1;
                this.f605a = i2;
                this.j++;
                gVar.f614c = i2;
                gVar.j = g.a.UNRESTRICTED;
                this.m.d[i2] = gVar;
            }
        }
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[PHI: r0
  0x0038: PHI (r0v6 b.g.b.b) = (r0v4 b.g.b.b), (r0v11 b.g.b.b) binds: [B:8:0x0029, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.g.b.b m() {
        /*
            r5 = this;
            boolean r0 = b.g.b.d.r
            r1 = 1
            if (r0 == 0) goto L1f
            b.g.b.c r0 = r5.m
            b.g.b.e<b.g.b.b> r0 = r0.f602a
            java.lang.Object r0 = r0.a()
            b.g.b.b r0 = (b.g.b.b) r0
            if (r0 != 0) goto L38
            b.g.b.d$b r0 = new b.g.b.d$b
            b.g.b.c r3 = r5.m
            r0.<init>(r5, r3)
            long r3 = b.g.b.d.t
            long r3 = r3 + r1
            b.g.b.d.t = r3
            goto L46
        L1f:
            b.g.b.c r0 = r5.m
            b.g.b.e<b.g.b.b> r0 = r0.f603b
            java.lang.Object r0 = r0.a()
            b.g.b.b r0 = (b.g.b.b) r0
            if (r0 != 0) goto L38
            b.g.b.b r0 = new b.g.b.b
            b.g.b.c r3 = r5.m
            r0.<init>(r3)
            long r3 = b.g.b.d.s
            long r3 = r3 + r1
            b.g.b.d.s = r3
            goto L46
        L38:
            r1 = 0
            r0.f599a = r1
            b.g.b.b$a r1 = r0.e
            r1.clear()
            r1 = 0
            r0.f600b = r1
            r1 = 0
            r0.f = r1
        L46:
            int r1 = b.g.b.g.n
            int r1 = r1 + 1
            b.g.b.g.n = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.d.m():b.g.b.b");
    }

    public g n() {
        if (this.j + 1 >= this.e) {
            p();
        }
        g gVarA = a(g.a.SLACK, null);
        int i = this.f605a + 1;
        this.f605a = i;
        this.j++;
        gVarA.f614c = i;
        this.m.d[i] = gVarA;
        return gVarA;
    }

    public int o(Object obj) {
        g gVar = ((b.g.b.i.c) obj).g;
        if (gVar != null) {
            return (int) (gVar.f + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i = this.d * 2;
        this.d = i;
        this.f = (b.g.b.b[]) Arrays.copyOf(this.f, i);
        c cVar = this.m;
        cVar.d = (g[]) Arrays.copyOf(cVar.d, this.d);
        int i2 = this.d;
        this.i = new boolean[i2];
        this.e = i2;
        this.l = i2;
    }

    public void q(a aVar) {
        float f;
        int i;
        boolean z;
        g.a aVar2 = g.a.UNRESTRICTED;
        int i2 = 0;
        while (true) {
            f = 0.0f;
            i = 1;
            if (i2 >= this.k) {
                z = false;
                break;
            }
            b.g.b.b[] bVarArr = this.f;
            if (bVarArr[i2].f599a.j != aVar2 && bVarArr[i2].f600b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3 += i;
                float f2 = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                while (i4 < this.k) {
                    b.g.b.b bVar = this.f[i4];
                    if (bVar.f599a.j != aVar2 && !bVar.f && bVar.f600b < f) {
                        int i8 = 1;
                        while (i8 < this.j) {
                            g gVar = this.m.d[i8];
                            float fE = bVar.e.e(gVar);
                            if (fE > f) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f3 = gVar.h[i9] / fE;
                                    if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                        i7 = i9;
                                        f2 = f3;
                                        i5 = i4;
                                        i6 = i8;
                                    }
                                }
                            }
                            i8++;
                            f = 0.0f;
                        }
                    }
                    i4++;
                    f = 0.0f;
                }
                if (i5 != -1) {
                    b.g.b.b bVar2 = this.f[i5];
                    bVar2.f599a.d = -1;
                    bVar2.j(this.m.d[i6]);
                    g gVar2 = bVar2.f599a;
                    gVar2.d = i5;
                    gVar2.e(bVar2);
                } else {
                    z2 = true;
                }
                if (i3 > this.j / 2) {
                    z2 = true;
                }
                f = 0.0f;
                i = 1;
            }
        }
        r(aVar);
        j();
    }

    public final int r(a aVar) {
        for (int i = 0; i < this.j; i++) {
            this.i[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.j * 2) {
                return i2;
            }
            g gVar = ((b.g.b.b) aVar).f599a;
            if (gVar != null) {
                this.i[gVar.f614c] = true;
            }
            g gVarB = aVar.b(this, this.i);
            if (gVarB != null) {
                boolean[] zArr = this.i;
                int i3 = gVarB.f614c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (gVarB != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.k; i5++) {
                    b.g.b.b bVar = this.f[i5];
                    if (bVar.f599a.j != g.a.UNRESTRICTED && !bVar.f && bVar.e.g(gVarB)) {
                        float fE = bVar.e.e(gVarB);
                        if (fE < 0.0f) {
                            float f2 = (-bVar.f600b) / fE;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b.g.b.b bVar2 = this.f[i4];
                    bVar2.f599a.d = -1;
                    bVar2.j(gVarB);
                    g gVar2 = bVar2.f599a;
                    gVar2.d = i4;
                    gVar2.e(bVar2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public final void s() {
        int i = 0;
        if (r) {
            while (true) {
                b.g.b.b[] bVarArr = this.f;
                if (i >= bVarArr.length) {
                    return;
                }
                b.g.b.b bVar = bVarArr[i];
                if (bVar != null) {
                    this.m.f602a.b(bVar);
                }
                this.f[i] = null;
                i++;
            }
        } else {
            while (true) {
                b.g.b.b[] bVarArr2 = this.f;
                if (i >= bVarArr2.length) {
                    return;
                }
                b.g.b.b bVar2 = bVarArr2[i];
                if (bVar2 != null) {
                    this.m.f603b.b(bVar2);
                }
                this.f[i] = null;
                i++;
            }
        }
    }

    public void t() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.m;
            g[] gVarArr = cVar.d;
            if (i >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i];
            if (gVar != null) {
                gVar.c();
            }
            i++;
        }
        e<g> eVar = cVar.f604c;
        g[] gVarArr2 = this.n;
        int length = this.o;
        if (eVar == null) {
            throw null;
        }
        if (length > gVarArr2.length) {
            length = gVarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            g gVar2 = gVarArr2[i2];
            int i3 = eVar.f609b;
            Object[] objArr = eVar.f608a;
            if (i3 < objArr.length) {
                objArr[i3] = gVar2;
                eVar.f609b = i3 + 1;
            }
        }
        this.o = 0;
        Arrays.fill(this.m.d, (Object) null);
        HashMap<String, g> map = this.f606b;
        if (map != null) {
            map.clear();
        }
        this.f605a = 0;
        this.f607c.clear();
        this.j = 1;
        for (int i4 = 0; i4 < this.k; i4++) {
            this.f[i4].f601c = false;
        }
        s();
        this.k = 0;
        this.p = r ? new b(this, this.m) : new b.g.b.b(this.m);
    }
}
