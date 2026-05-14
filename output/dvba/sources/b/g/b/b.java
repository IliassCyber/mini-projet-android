package b.g.b;

import b.g.b.d;
import b.g.b.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f601c;
    public a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f600b = 0.0f;
    public ArrayList<g> d = new ArrayList<>();
    public boolean f = false;

    public interface a {
        float a(int i);

        float b(g gVar, boolean z);

        void c(g gVar, float f, boolean z);

        void clear();

        g d(int i);

        float e(g gVar);

        float f(b bVar, boolean z);

        boolean g(g gVar);

        void h(float f);

        void i();

        void j(g gVar, float f);

        int k();
    }

    public b() {
    }

    public b(c cVar) {
        this.e = new b.g.b.a(this, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
    @Override // b.g.b.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(b.g.b.g r3) {
        /*
            r2 = this;
            int r0 = r3.e
            r1 = 1
            if (r0 != r1) goto L6
            goto L21
        L6:
            r1 = 2
            if (r0 != r1) goto Lc
            r0 = 1148846080(0x447a0000, float:1000.0)
            goto L23
        Lc:
            r1 = 3
            if (r0 != r1) goto L13
            r0 = 1232348160(0x49742400, float:1000000.0)
            goto L23
        L13:
            r1 = 4
            if (r0 != r1) goto L1a
            r0 = 1315859240(0x4e6e6b28, float:1.0E9)
            goto L23
        L1a:
            r1 = 5
            if (r0 != r1) goto L21
            r0 = 1399379109(0x5368d4a5, float:1.0E12)
            goto L23
        L21:
            r0 = 1065353216(0x3f800000, float:1.0)
        L23:
            b.g.b.b$a r1 = r2.e
            r1.j(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.b.a(b.g.b.g):void");
    }

    @Override // b.g.b.d.a
    public g b(d dVar, boolean[] zArr) {
        return i(zArr, null);
    }

    public b c(d dVar, int i) {
        this.e.j(dVar.k(i, "ep"), 1.0f);
        this.e.j(dVar.k(i, "em"), -1.0f);
        return this;
    }

    @Override // b.g.b.d.a
    public void clear() {
        this.e.clear();
        this.f599a = null;
        this.f600b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.e.j(gVar, -1.0f);
        this.e.j(gVar2, 1.0f);
        this.e.j(gVar3, f);
        this.e.j(gVar4, -f);
        return this;
    }

    public b e(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f600b = i;
        }
        if (z) {
            this.e.j(gVar, 1.0f);
            this.e.j(gVar2, -1.0f);
            this.e.j(gVar3, -1.0f);
        } else {
            this.e.j(gVar, -1.0f);
            this.e.j(gVar2, 1.0f);
            this.e.j(gVar3, 1.0f);
        }
        return this;
    }

    public b f(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f600b = i;
        }
        if (z) {
            this.e.j(gVar, 1.0f);
            this.e.j(gVar2, -1.0f);
            this.e.j(gVar3, 1.0f);
        } else {
            this.e.j(gVar, -1.0f);
            this.e.j(gVar2, 1.0f);
            this.e.j(gVar3, -1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.e.j(gVar3, 0.5f);
        this.e.j(gVar4, 0.5f);
        this.e.j(gVar, -0.5f);
        this.e.j(gVar2, -0.5f);
        this.f600b = -f;
        return this;
    }

    public final boolean h(g gVar) {
        return gVar.m <= 1;
    }

    public final g i(boolean[] zArr, g gVar) {
        g.a aVar;
        int iK = this.e.k();
        g gVar2 = null;
        float f = 0.0f;
        for (int i = 0; i < iK; i++) {
            float fA = this.e.a(i);
            if (fA < 0.0f) {
                g gVarD = this.e.d(i);
                if ((zArr == null || !zArr[gVarD.f614c]) && gVarD != gVar && (((aVar = gVarD.j) == g.a.SLACK || aVar == g.a.ERROR) && fA < f)) {
                    f = fA;
                    gVar2 = gVarD;
                }
            }
        }
        return gVar2;
    }

    public void j(g gVar) {
        g gVar2 = this.f599a;
        if (gVar2 != null) {
            this.e.j(gVar2, -1.0f);
            this.f599a = null;
        }
        float fB = this.e.b(gVar, true) * (-1.0f);
        this.f599a = gVar;
        if (fB == 1.0f) {
            return;
        }
        this.f600b /= fB;
        this.e.h(fB);
    }

    public void k(g gVar, boolean z) {
        if (gVar.g) {
            float fE = this.e.e(gVar);
            this.f600b = (gVar.f * fE) + this.f600b;
            this.e.b(gVar, z);
            if (z) {
                gVar.b(this);
            }
        }
    }

    public void l(b bVar, boolean z) {
        float f = this.e.f(bVar, z);
        this.f600b = (bVar.f600b * f) + this.f600b;
        if (z) {
            bVar.f599a.b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            b.g.b.g r0 = r9.f599a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L16
        L7:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = c.a.a.a.a.e(r0)
            b.g.b.g r1 = r9.f599a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L16:
            java.lang.String r1 = " = "
            java.lang.String r0 = c.a.a.a.a.c(r0, r1)
            float r1 = r9.f600b
            r2 = 0
            r3 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L33
            java.lang.StringBuilder r0 = c.a.a.a.a.e(r0)
            float r1 = r9.f600b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L34
        L33:
            r1 = 0
        L34:
            b.g.b.b$a r4 = r9.e
            int r4 = r4.k()
        L3a:
            if (r3 >= r4) goto La5
            b.g.b.b$a r5 = r9.e
            b.g.b.g r5 = r5.d(r3)
            if (r5 != 0) goto L45
            goto La2
        L45:
            b.g.b.b$a r6 = r9.e
            float r6 = r6.a(r3)
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 != 0) goto L50
            goto La2
        L50:
            java.lang.String r5 = r5.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L63
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7e
            java.lang.StringBuilder r0 = c.a.a.a.a.e(r0)
            java.lang.String r1 = "- "
            goto L75
        L63:
            java.lang.StringBuilder r0 = c.a.a.a.a.e(r0)
            if (r7 <= 0) goto L73
            java.lang.String r1 = " + "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L7e
        L73:
            java.lang.String r1 = " - "
        L75:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            float r6 = r6 * r8
        L7e:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 != 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L97
        L8a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " "
        L97:
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
            r1 = 1
        La2:
            int r3 = r3 + 1
            goto L3a
        La5:
            if (r1 != 0) goto Lad
            java.lang.String r1 = "0.0"
            java.lang.String r0 = c.a.a.a.a.c(r0, r1)
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.b.toString():java.lang.String");
    }
}
