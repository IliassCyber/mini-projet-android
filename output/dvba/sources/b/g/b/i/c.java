package b.g.b.i;

import b.g.b.g;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f625c;
    public c d;
    public b.g.b.g g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<c> f623a = null;
    public int e = 0;
    public int f = -1;

    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public c(d dVar, a aVar) {
        this.f624b = dVar;
        this.f625c = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(b.g.b.i.c r7, int r8, int r9, boolean r10) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != 0) goto L7
            r6.e()
            return r0
        L7:
            r1 = 0
            if (r10 != 0) goto L75
            b.g.b.i.c$a r10 = b.g.b.i.c.a.CENTER_Y
            b.g.b.i.c$a r2 = b.g.b.i.c.a.CENTER_X
            b.g.b.i.c$a r3 = b.g.b.i.c.a.BASELINE
            b.g.b.i.c$a r4 = r7.f625c
            b.g.b.i.c$a r5 = r6.f625c
            if (r4 != r5) goto L25
            if (r5 != r3) goto L3e
            b.g.b.i.d r10 = r7.f624b
            boolean r10 = r10.w
            if (r10 == 0) goto L40
            b.g.b.i.d r10 = r6.f624b
            boolean r10 = r10.w
            if (r10 != 0) goto L3e
            goto L40
        L25:
            int r5 = r5.ordinal()
            switch(r5) {
                case 0: goto L40;
                case 1: goto L5b;
                case 2: goto L42;
                case 3: goto L5b;
                case 4: goto L42;
                case 5: goto L40;
                case 6: goto L38;
                case 7: goto L40;
                case 8: goto L40;
                default: goto L2c;
            }
        L2c:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            b.g.b.i.c$a r8 = r6.f625c
            java.lang.String r8 = r8.name()
            r7.<init>(r8)
            throw r7
        L38:
            if (r4 == r3) goto L40
            if (r4 == r2) goto L40
            if (r4 == r10) goto L40
        L3e:
            r10 = 1
            goto L72
        L40:
            r10 = 0
            goto L72
        L42:
            b.g.b.i.c$a r2 = b.g.b.i.c.a.TOP
            if (r4 == r2) goto L4d
            b.g.b.i.c$a r2 = b.g.b.i.c.a.BOTTOM
            if (r4 != r2) goto L4b
            goto L4d
        L4b:
            r2 = 0
            goto L4e
        L4d:
            r2 = 1
        L4e:
            b.g.b.i.d r3 = r7.f624b
            boolean r3 = r3 instanceof b.g.b.i.f
            if (r3 == 0) goto L59
            if (r2 != 0) goto L3e
            if (r4 != r10) goto L40
            goto L3e
        L59:
            r10 = r2
            goto L72
        L5b:
            b.g.b.i.c$a r10 = b.g.b.i.c.a.LEFT
            if (r4 == r10) goto L66
            b.g.b.i.c$a r10 = b.g.b.i.c.a.RIGHT
            if (r4 != r10) goto L64
            goto L66
        L64:
            r10 = 0
            goto L67
        L66:
            r10 = 1
        L67:
            b.g.b.i.d r3 = r7.f624b
            boolean r3 = r3 instanceof b.g.b.i.f
            if (r3 == 0) goto L72
            if (r10 != 0) goto L3e
            if (r4 != r2) goto L40
            goto L3e
        L72:
            if (r10 != 0) goto L75
            return r1
        L75:
            r6.d = r7
            java.util.HashSet<b.g.b.i.c> r10 = r7.f623a
            if (r10 != 0) goto L82
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            r7.f623a = r10
        L82:
            b.g.b.i.c r7 = r6.d
            java.util.HashSet<b.g.b.i.c> r7 = r7.f623a
            r7.add(r6)
            if (r8 <= 0) goto L8e
            r6.e = r8
            goto L90
        L8e:
            r6.e = r1
        L90:
            r6.f = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.c.a(b.g.b.i.c, int, int, boolean):boolean");
    }

    public int b() {
        c cVar;
        if (this.f624b.X == 8) {
            return 0;
        }
        int i = this.f;
        return (i <= -1 || (cVar = this.d) == null || cVar.f624b.X != 8) ? this.e : i;
    }

    public boolean c() {
        c cVar;
        HashSet<c> hashSet = this.f623a;
        if (hashSet == null) {
            return false;
        }
        for (c cVar2 : hashSet) {
            switch (cVar2.f625c) {
                case NONE:
                case BASELINE:
                case CENTER:
                case CENTER_X:
                case CENTER_Y:
                    cVar = null;
                    break;
                case LEFT:
                    cVar = cVar2.f624b.A;
                    break;
                case TOP:
                    cVar = cVar2.f624b.B;
                    break;
                case RIGHT:
                    cVar = cVar2.f624b.y;
                    break;
                case BOTTOM:
                    cVar = cVar2.f624b.z;
                    break;
                default:
                    throw new AssertionError(cVar2.f625c.name());
            }
            if (cVar.d()) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return this.d != null;
    }

    public void e() {
        HashSet<c> hashSet;
        c cVar = this.d;
        if (cVar != null && (hashSet = cVar.f623a) != null) {
            hashSet.remove(this);
        }
        this.d = null;
        this.e = 0;
        this.f = -1;
    }

    public void f() {
        b.g.b.g gVar = this.g;
        if (gVar == null) {
            this.g = new b.g.b.g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public String toString() {
        return this.f624b.Y + ":" + this.f625c.toString();
    }
}
