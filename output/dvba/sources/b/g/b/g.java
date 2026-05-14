package b.g.b;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f613b;
    public float f;
    public a j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f614c = -1;
    public int d = -1;
    public int e = 0;
    public boolean g = false;
    public float[] h = new float[9];
    public float[] i = new float[9];
    public b[] k = new b[16];
    public int l = 0;
    public int m = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.j = aVar;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.l;
            if (i >= i2) {
                b[] bVarArr = this.k;
                if (i2 >= bVarArr.length) {
                    this.k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.k;
                int i3 = this.l;
                bVarArr2[i3] = bVar;
                this.l = i3 + 1;
                return;
            }
            if (this.k[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.l;
        int i2 = 0;
        while (i2 < i) {
            if (this.k[i2] == bVar) {
                while (i2 < i - 1) {
                    b[] bVarArr = this.k;
                    int i3 = i2 + 1;
                    bVarArr[i2] = bVarArr[i3];
                    i2 = i3;
                }
                this.l--;
                return;
            }
            i2++;
        }
    }

    public void c() {
        this.f613b = null;
        this.j = a.UNKNOWN;
        this.e = 0;
        this.f614c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = null;
        }
        this.l = 0;
        this.m = 0;
        this.f612a = false;
        Arrays.fill(this.i, 0.0f);
    }

    public void d(d dVar, float f) {
        this.f = f;
        this.g = true;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].k(this, false);
        }
        this.l = 0;
    }

    public final void e(b bVar) {
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].l(bVar, false);
        }
        this.l = 0;
    }

    public String toString() {
        StringBuilder sbE;
        if (this.f613b != null) {
            sbE = c.a.a.a.a.e("");
            sbE.append(this.f613b);
        } else {
            sbE = c.a.a.a.a.e("");
            sbE.append(this.f614c);
        }
        return sbE.toString();
    }
}
