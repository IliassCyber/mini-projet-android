package b.g.b.i.l;

import b.g.b.i.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.g.b.i.d f652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f653c;
    public d.a d;
    public g e = new g(this);
    public int f = 0;
    public boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    public a j = a.NONE;

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public m(b.g.b.i.d dVar) {
        this.f652b = dVar;
    }

    @Override // b.g.b.i.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i) {
        fVar.l.add(fVar2);
        fVar.f = i;
        fVar2.k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.e);
        fVar.h = i;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        int iMax;
        if (i2 == 0) {
            b.g.b.i.d dVar = this.f652b;
            int i3 = dVar.n;
            iMax = Math.max(dVar.m, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax == i) {
                return i;
            }
        } else {
            b.g.b.i.d dVar2 = this.f652b;
            int i4 = dVar2.q;
            iMax = Math.max(dVar2.p, i);
            if (i4 > 0) {
                iMax = Math.min(i4, i);
            }
            if (iMax == i) {
                return i;
            }
        }
        return iMax;
    }

    public final f h(b.g.b.i.c cVar) {
        m mVar;
        m mVar2;
        b.g.b.i.c cVar2 = cVar.d;
        if (cVar2 == null) {
            return null;
        }
        b.g.b.i.d dVar = cVar2.f624b;
        int iOrdinal = cVar2.f625c.ordinal();
        if (iOrdinal == 1) {
            mVar = dVar.d;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    mVar2 = dVar.d;
                } else {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            return null;
                        }
                        return dVar.e.k;
                    }
                    mVar2 = dVar.e;
                }
                return mVar2.i;
            }
            mVar = dVar.e;
        }
        return mVar.h;
    }

    public final f i(b.g.b.i.c cVar, int i) {
        b.g.b.i.c cVar2 = cVar.d;
        if (cVar2 == null) {
            return null;
        }
        b.g.b.i.d dVar = cVar2.f624b;
        m mVar = i == 0 ? dVar.d : dVar.e;
        int iOrdinal = cVar.d.f625c.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return mVar.h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return mVar.i;
        }
        return null;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(b.g.b.i.c r11, b.g.b.i.c r12, int r13) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.m.l(b.g.b.i.c, b.g.b.i.c, int):void");
    }
}
