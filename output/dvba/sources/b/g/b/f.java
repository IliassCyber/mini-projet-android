package b.g.b;

import b.g.b.b;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class f extends b.g.b.b {
    public int g;
    public g[] h;
    public g[] i;
    public int j;
    public b k;

    public class a implements Comparator<g> {
        public a(f fVar) {
        }

        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            return gVar.f614c - gVar2.f614c;
        }
    }

    public class b implements Comparable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f610b;

        public b(f fVar) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f610b.f614c - ((g) obj).f614c;
        }

        public String toString() {
            String string = "[ ";
            if (this.f610b != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder sbE = c.a.a.a.a.e(string);
                    sbE.append(this.f610b.i[i]);
                    sbE.append(" ");
                    string = sbE.toString();
                }
            }
            return string + "] " + this.f610b;
        }
    }

    public f(c cVar) {
        super(cVar);
        this.g = 128;
        this.h = new g[128];
        this.i = new g[128];
        this.j = 0;
        this.k = new b(this);
    }

    @Override // b.g.b.b, b.g.b.d.a
    public void a(g gVar) {
        this.k.f610b = gVar;
        Arrays.fill(gVar.i, 0.0f);
        gVar.i[gVar.e] = 1.0f;
        m(gVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    @Override // b.g.b.b, b.g.b.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.g.b.g b(b.g.b.d r11, boolean[] r12) {
        /*
            r10 = this;
            r11 = 0
            r0 = -1
            r1 = 0
            r2 = -1
        L4:
            int r3 = r10.j
            r4 = 0
            if (r1 >= r3) goto L5e
            b.g.b.g[] r3 = r10.h
            r5 = r3[r1]
            int r6 = r5.f614c
            boolean r6 = r12[r6]
            if (r6 == 0) goto L14
            goto L5a
        L14:
            b.g.b.f$b r6 = r10.k
            r6.f610b = r5
            r5 = 8
            r7 = 1
            if (r2 != r0) goto L3a
            if (r6 == 0) goto L39
        L1f:
            if (r5 < 0) goto L35
            b.g.b.g r3 = r6.f610b
            float[] r3 = r3.i
            r3 = r3[r5]
            r4 = 0
            int r8 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r8 <= 0) goto L2d
            goto L35
        L2d:
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L32
            goto L36
        L32:
            int r5 = r5 + (-1)
            goto L1f
        L35:
            r7 = 0
        L36:
            if (r7 == 0) goto L5a
            goto L59
        L39:
            throw r4
        L3a:
            r3 = r3[r2]
            if (r6 == 0) goto L5d
        L3e:
            if (r5 < 0) goto L56
            float[] r4 = r3.i
            r4 = r4[r5]
            b.g.b.g r8 = r6.f610b
            float[] r8 = r8.i
            r8 = r8[r5]
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 != 0) goto L51
            int r5 = r5 + (-1)
            goto L3e
        L51:
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 >= 0) goto L56
            goto L57
        L56:
            r7 = 0
        L57:
            if (r7 == 0) goto L5a
        L59:
            r2 = r1
        L5a:
            int r1 = r1 + 1
            goto L4
        L5d:
            throw r4
        L5e:
            if (r2 != r0) goto L61
            return r4
        L61:
            b.g.b.g[] r11 = r10.h
            r11 = r11[r2]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.f.b(b.g.b.d, boolean[]):b.g.b.g");
    }

    @Override // b.g.b.b, b.g.b.d.a
    public void clear() {
        this.j = 0;
        this.f600b = 0.0f;
    }

    @Override // b.g.b.b
    public void l(b.g.b.b bVar, boolean z) {
        g gVar = bVar.f599a;
        if (gVar == null) {
            return;
        }
        b.a aVar = bVar.e;
        int iK = aVar.k();
        for (int i = 0; i < iK; i++) {
            g gVarD = aVar.d(i);
            float fA = aVar.a(i);
            b bVar2 = this.k;
            bVar2.f610b = gVarD;
            boolean z2 = true;
            if (gVarD.f612a) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = bVar2.f610b.i;
                    fArr[i2] = (gVar.i[i2] * fA) + fArr[i2];
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        bVar2.f610b.i[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    f.this.n(bVar2.f610b);
                }
                z2 = false;
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f = gVar.i[i3];
                    if (f != 0.0f) {
                        float f2 = f * fA;
                        if (Math.abs(f2) < 1.0E-4f) {
                            f2 = 0.0f;
                        }
                        bVar2.f610b.i[i3] = f2;
                    } else {
                        bVar2.f610b.i[i3] = 0.0f;
                    }
                }
            }
            if (z2) {
                m(gVarD);
            }
            this.f600b = (bVar.f600b * fA) + this.f600b;
        }
        n(gVar);
    }

    public final void m(g gVar) {
        int i;
        int i2 = this.j + 1;
        g[] gVarArr = this.h;
        if (i2 > gVarArr.length) {
            g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            this.h = gVarArr2;
            this.i = (g[]) Arrays.copyOf(gVarArr2, gVarArr2.length * 2);
        }
        g[] gVarArr3 = this.h;
        int i3 = this.j;
        gVarArr3[i3] = gVar;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && gVarArr3[i4 - 1].f614c > gVar.f614c) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a(this));
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        gVar.f612a = true;
        gVar.a(this);
    }

    public final void n(g gVar) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == gVar) {
                while (true) {
                    int i2 = this.j;
                    if (i >= i2 - 1) {
                        this.j = i2 - 1;
                        gVar.f612a = false;
                        return;
                    } else {
                        g[] gVarArr = this.h;
                        int i3 = i + 1;
                        gVarArr[i] = gVarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // b.g.b.b
    public String toString() {
        String string = " goal -> (" + this.f600b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.f610b = this.h[i];
            StringBuilder sbE = c.a.a.a.a.e(string);
            sbE.append(this.k);
            sbE.append(" ");
            string = sbE.toString();
        }
        return string;
    }
}
