package b.g.b.i.l;

import b.g.b.i.d;
import b.g.b.i.l.f;

/* JADX INFO: loaded from: classes.dex */
public class l extends m {
    public f k;
    public g l;

    public l(b.g.b.i.d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.k = fVar;
        this.l = null;
        this.h.e = f.a.TOP;
        this.i.e = f.a.BOTTOM;
        fVar.e = f.a.BASELINE;
        this.f = 1;
    }

    @Override // b.g.b.i.l.m, b.g.b.i.l.d
    public void a(d dVar) {
        float f;
        int i;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int iOrdinal = this.j.ordinal();
        if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal == 3) {
            b.g.b.i.d dVar2 = this.f652b;
            l(dVar2.z, dVar2.B, 1);
            return;
        }
        g gVar = this.e;
        if (gVar.f645c && !gVar.j && this.d == aVar) {
            b.g.b.i.d dVar3 = this.f652b;
            int i2 = dVar3.k;
            if (i2 == 2) {
                b.g.b.i.d dVar4 = dVar3.K;
                if (dVar4 != null) {
                    if (dVar4.e.e.j) {
                        gVar.c((int) ((r1.g * dVar3.r) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                if (dVar3.d.e.j) {
                    int i3 = dVar3.O;
                    if (i3 == -1) {
                        f = r0.g / dVar3.N;
                        i = (int) (f + 0.5f);
                        this.e.c(i);
                    } else if (i3 != 0) {
                        if (i3 != 1) {
                            i = 0;
                            this.e.c(i);
                        }
                        f = r0.g / dVar3.N;
                        i = (int) (f + 0.5f);
                        this.e.c(i);
                    } else {
                        f = r0.g * dVar3.N;
                        i = (int) (f + 0.5f);
                        this.e.c(i);
                    }
                }
            }
        }
        f fVar = this.h;
        if (fVar.f645c) {
            f fVar2 = this.i;
            if (fVar2.f645c) {
                if (fVar.j && fVar2.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == aVar) {
                    b.g.b.i.d dVar5 = this.f652b;
                    if (dVar5.j == 0 && !dVar5.t()) {
                        f fVar3 = this.h.l.get(0);
                        f fVar4 = this.i.l.get(0);
                        int i4 = fVar3.g;
                        f fVar5 = this.h;
                        int i5 = i4 + fVar5.f;
                        int i6 = fVar4.g + this.i.f;
                        fVar5.c(i5);
                        this.i.c(i6);
                        this.e.c(i6 - i5);
                        return;
                    }
                }
                if (!this.e.j && this.d == aVar && this.f651a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    f fVar6 = this.h.l.get(0);
                    int i7 = (this.i.l.get(0).g + this.i.f) - (fVar6.g + this.h.f);
                    g gVar2 = this.e;
                    int i8 = gVar2.m;
                    if (i7 < i8) {
                        gVar2.c(i7);
                    } else {
                        gVar2.c(i8);
                    }
                }
                if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    f fVar7 = this.h.l.get(0);
                    f fVar8 = this.i.l.get(0);
                    int i9 = fVar7.g;
                    int i10 = this.h.f + i9;
                    int i11 = fVar8.g;
                    int i12 = this.i.f + i11;
                    float f2 = this.f652b.V;
                    if (fVar7 == fVar8) {
                        f2 = 0.5f;
                    } else {
                        i9 = i10;
                        i11 = i12;
                    }
                    this.h.c((int) ((((i11 - i9) - this.e.g) * f2) + i9 + 0.5f));
                    this.i.c(this.h.g + this.e.g);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0326, code lost:
    
        if (r10.f652b.w != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0328, code lost:
    
        r0 = r10.k;
        r1 = r10.h;
        r2 = r10.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03bf, code lost:
    
        if (r10.f652b.w != false) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x042f A[PHI: r0
  0x042f: PHI (r0v31 b.g.b.i.l.j) = (r0v18 b.g.b.i.l.j), (r0v45 b.g.b.i.l.j) binds: [B:159:0x042d, B:133:0x0386] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    @Override // b.g.b.i.l.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instruction units count: 1112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.l.d():void");
    }

    @Override // b.g.b.i.l.m
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f652b.Q = fVar.g;
        }
    }

    @Override // b.g.b.i.l.m
    public void f() {
        this.f653c = null;
        this.h.b();
        this.i.b();
        this.k.b();
        this.e.b();
        this.g = false;
    }

    @Override // b.g.b.i.l.m
    public boolean k() {
        return this.d != d.a.MATCH_CONSTRAINT || this.f652b.k == 0;
    }

    public void m() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.k.b();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("VerticalRun ");
        sbE.append(this.f652b.Y);
        return sbE.toString();
    }
}
