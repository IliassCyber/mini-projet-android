package b.g.b.i.l;

import b.g.b.i.d;
import b.g.b.i.l.f;

/* JADX INFO: loaded from: classes.dex */
public class j extends m {
    public static int[] k = new int[2];

    public j(b.g.b.i.d dVar) {
        super(dVar);
        this.h.e = f.a.LEFT;
        this.i.e = f.a.RIGHT;
        this.f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0281, code lost:
    
        if (r15 != 1) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0168  */
    @Override // b.g.b.i.l.m, b.g.b.i.l.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(b.g.b.i.l.d r18) {
        /*
            Method dump skipped, instruction units count: 1005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.j.a(b.g.b.i.l.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01db  */
    @Override // b.g.b.i.l.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instruction units count: 991
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.j.d():void");
    }

    @Override // b.g.b.i.l.m
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f652b.P = fVar.g;
        }
    }

    @Override // b.g.b.i.l.m
    public void f() {
        this.f653c = null;
        this.h.b();
        this.i.b();
        this.e.b();
        this.g = false;
    }

    @Override // b.g.b.i.l.m
    public boolean k() {
        return this.d != d.a.MATCH_CONSTRAINT || this.f652b.j == 0;
    }

    public final void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6 && i7 <= i7) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else {
            if (i6 > i6 || i9 > i7) {
                return;
            }
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    public void n() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("HorizontalRun ");
        sbE.append(this.f652b.Y);
        return sbE.toString();
    }
}
