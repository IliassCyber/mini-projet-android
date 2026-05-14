package b.g.b;

import b.g.b.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class h implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f617a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f618b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f619c = new int[16];
    public int[] d = new int[16];
    public int[] e = new int[16];
    public float[] f = new float[16];
    public int[] g = new int[16];
    public int[] h = new int[16];
    public int i = 0;
    public int j = -1;
    public final b k;
    public final c l;

    public h(b bVar, c cVar) {
        this.k = bVar;
        this.l = cVar;
        clear();
    }

    @Override // b.g.b.b.a
    public float a(int i) {
        int i2 = this.i;
        int i3 = this.j;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.f[i3];
            }
            i3 = this.h[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // b.g.b.b.a
    public float b(g gVar, boolean z) {
        int iN = n(gVar);
        if (iN == -1) {
            return 0.0f;
        }
        int i = gVar.f614c;
        int i2 = i % this.f618b;
        int[] iArr = this.f619c;
        int i3 = iArr[i2];
        if (i3 != -1) {
            if (this.e[i3] == i) {
                int[] iArr2 = this.d;
                iArr[i2] = iArr2[i3];
                iArr2[i3] = -1;
            } else {
                while (true) {
                    int[] iArr3 = this.d;
                    if (iArr3[i3] == -1 || this.e[iArr3[i3]] == i) {
                        break;
                    }
                    i3 = iArr3[i3];
                }
                int[] iArr4 = this.d;
                int i4 = iArr4[i3];
                if (i4 != -1 && this.e[i4] == i) {
                    iArr4[i3] = iArr4[i4];
                    iArr4[i4] = -1;
                }
            }
        }
        float f = this.f[iN];
        if (this.j == iN) {
            this.j = this.h[iN];
        }
        this.e[iN] = -1;
        int[] iArr5 = this.g;
        if (iArr5[iN] != -1) {
            int[] iArr6 = this.h;
            iArr6[iArr5[iN]] = iArr6[iN];
        }
        int[] iArr7 = this.h;
        if (iArr7[iN] != -1) {
            int[] iArr8 = this.g;
            iArr8[iArr7[iN]] = iArr8[iN];
        }
        this.i--;
        gVar.m--;
        if (z) {
            gVar.b(this.k);
        }
        return f;
    }

    @Override // b.g.b.b.a
    public void c(g gVar, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int iN = n(gVar);
            if (iN == -1) {
                j(gVar, f);
                return;
            }
            float[] fArr = this.f;
            fArr[iN] = fArr[iN] + f;
            if (fArr[iN] <= -0.001f || fArr[iN] >= 0.001f) {
                return;
            }
            fArr[iN] = 0.0f;
            b(gVar, z);
        }
    }

    @Override // b.g.b.b.a
    public void clear() {
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            g gVarD = d(i2);
            if (gVarD != null) {
                gVarD.b(this.k);
            }
        }
        for (int i3 = 0; i3 < this.f617a; i3++) {
            this.e[i3] = -1;
            this.d[i3] = -1;
        }
        for (int i4 = 0; i4 < this.f618b; i4++) {
            this.f619c[i4] = -1;
        }
        this.i = 0;
        this.j = -1;
    }

    @Override // b.g.b.b.a
    public g d(int i) {
        int i2 = this.i;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.j;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.l.d[this.e[i3]];
            }
            i3 = this.h[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // b.g.b.b.a
    public float e(g gVar) {
        int iN = n(gVar);
        if (iN != -1) {
            return this.f[iN];
        }
        return 0.0f;
    }

    @Override // b.g.b.b.a
    public float f(b bVar, boolean z) {
        float fE = e(bVar.f599a);
        b(bVar.f599a, z);
        h hVar = (h) bVar.e;
        int i = hVar.i;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int[] iArr = hVar.e;
            if (iArr[i3] != -1) {
                c(this.l.d[iArr[i3]], hVar.f[i3] * fE, z);
                i2++;
            }
            i3++;
        }
        return fE;
    }

    @Override // b.g.b.b.a
    public boolean g(g gVar) {
        return n(gVar) != -1;
    }

    @Override // b.g.b.b.a
    public void h(float f) {
        int i = this.i;
        int i2 = this.j;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f;
            fArr[i2] = fArr[i2] / f;
            i2 = this.h[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // b.g.b.b.a
    public void i() {
        int i = this.i;
        int i2 = this.j;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.h[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // b.g.b.b.a
    public void j(g gVar, float f) {
        if (f > -0.001f && f < 0.001f) {
            b(gVar, true);
            return;
        }
        int i = 0;
        if (this.i == 0) {
            m(0, gVar, f);
            l(gVar, 0);
            this.j = 0;
            return;
        }
        int iN = n(gVar);
        if (iN != -1) {
            this.f[iN] = f;
            return;
        }
        int i2 = this.i + 1;
        int i3 = this.f617a;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            this.e = Arrays.copyOf(this.e, i4);
            this.f = Arrays.copyOf(this.f, i4);
            this.g = Arrays.copyOf(this.g, i4);
            this.h = Arrays.copyOf(this.h, i4);
            this.d = Arrays.copyOf(this.d, i4);
            for (int i5 = this.f617a; i5 < i4; i5++) {
                this.e[i5] = -1;
                this.d[i5] = -1;
            }
            this.f617a = i4;
        }
        int i6 = this.i;
        int i7 = this.j;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int[] iArr = this.e;
            int i10 = iArr[i7];
            int i11 = gVar.f614c;
            if (i10 == i11) {
                this.f[i7] = f;
                return;
            }
            if (iArr[i7] < i11) {
                i8 = i7;
            }
            i7 = this.h[i7];
            if (i7 == -1) {
                break;
            }
        }
        while (true) {
            if (i >= this.f617a) {
                i = -1;
                break;
            } else if (this.e[i] == -1) {
                break;
            } else {
                i++;
            }
        }
        m(i, gVar, f);
        int[] iArr2 = this.g;
        if (i8 != -1) {
            iArr2[i] = i8;
            int[] iArr3 = this.h;
            iArr3[i] = iArr3[i8];
            iArr3[i8] = i;
        } else {
            iArr2[i] = -1;
            if (this.i > 0) {
                this.h[i] = this.j;
                this.j = i;
            } else {
                this.h[i] = -1;
            }
        }
        int[] iArr4 = this.h;
        if (iArr4[i] != -1) {
            this.g[iArr4[i]] = i;
        }
        l(gVar, i);
    }

    @Override // b.g.b.b.a
    public int k() {
        return this.i;
    }

    public final void l(g gVar, int i) {
        int[] iArr;
        int i2 = gVar.f614c % this.f618b;
        int[] iArr2 = this.f619c;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.d;
                if (iArr[i3] == -1) {
                    break;
                } else {
                    i3 = iArr[i3];
                }
            }
            iArr[i3] = i;
        }
        this.d[i] = -1;
    }

    public final void m(int i, g gVar, float f) {
        this.e[i] = gVar.f614c;
        this.f[i] = f;
        this.g[i] = -1;
        this.h[i] = -1;
        gVar.a(this.k);
        gVar.m++;
        this.i++;
    }

    public int n(g gVar) {
        if (this.i == 0) {
            return -1;
        }
        int i = gVar.f614c;
        int i2 = this.f619c[i % this.f618b];
        if (i2 == -1) {
            return -1;
        }
        if (this.e[i2] == i) {
            return i2;
        }
        while (true) {
            int[] iArr = this.d;
            if (iArr[i2] == -1 || this.e[iArr[i2]] == i) {
                break;
            }
            i2 = iArr[i2];
        }
        int[] iArr2 = this.d;
        if (iArr2[i2] != -1 && this.e[iArr2[i2]] == i) {
            return iArr2[i2];
        }
        return -1;
    }

    public String toString() {
        StringBuilder sbE;
        String strC;
        String strC2 = hashCode() + " { ";
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            g gVarD = d(i2);
            if (gVarD != null) {
                String str = strC2 + gVarD + " = " + a(i2) + " ";
                int iN = n(gVarD);
                String strC3 = c.a.a.a.a.c(str, "[p: ");
                if (this.g[iN] != -1) {
                    sbE = c.a.a.a.a.e(strC3);
                    sbE.append(this.l.d[this.e[this.g[iN]]]);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strC3);
                    sb.append("none");
                    sbE = sb;
                }
                String strC4 = c.a.a.a.a.c(sbE.toString(), ", n: ");
                if (this.h[iN] != -1) {
                    StringBuilder sbE2 = c.a.a.a.a.e(strC4);
                    sbE2.append(this.l.d[this.e[this.h[iN]]]);
                    strC = sbE2.toString();
                } else {
                    strC = c.a.a.a.a.c(strC4, "none");
                }
                strC2 = c.a.a.a.a.c(strC, "]");
            }
        }
        return c.a.a.a.a.c(strC2, " }");
    }
}
