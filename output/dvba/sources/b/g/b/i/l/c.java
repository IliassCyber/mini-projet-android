package b.g.b.i.l;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends m {
    public ArrayList<m> k;
    public int l;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0038 -> B:17:0x003a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(b.g.b.i.d r4, int r5) {
        /*
            r3 = this;
            r3.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.k = r4
            r3.f = r5
            b.g.b.i.d r4 = r3.f652b
        Le:
            int r5 = r3.f
            b.g.b.i.d r5 = r4.l(r5)
            if (r5 == 0) goto L18
            r4 = r5
            goto Le
        L18:
            r3.f652b = r4
            java.util.ArrayList<b.g.b.i.l.m> r5 = r3.k
            int r0 = r3.f
            r1 = 1
            if (r0 != 0) goto L23
            r0 = r3
            goto L3a
        L23:
            if (r0 != r1) goto L27
            r0 = r3
            goto L3f
        L27:
            r0 = r3
        L28:
            r2 = 0
        L29:
            r5.add(r2)
            int r5 = r0.f
            b.g.b.i.d r4 = r4.k(r5)
            if (r4 == 0) goto L42
            java.util.ArrayList<b.g.b.i.l.m> r5 = r0.k
            int r2 = r0.f
            if (r2 != 0) goto L3d
        L3a:
            b.g.b.i.l.j r2 = r4.d
            goto L29
        L3d:
            if (r2 != r1) goto L28
        L3f:
            b.g.b.i.l.l r2 = r4.e
            goto L29
        L42:
            java.util.ArrayList<b.g.b.i.l.m> r4 = r0.k
            java.util.Iterator r4 = r4.iterator()
        L48:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L64
            java.lang.Object r5 = r4.next()
            b.g.b.i.l.m r5 = (b.g.b.i.l.m) r5
            int r2 = r0.f
            if (r2 != 0) goto L5d
            b.g.b.i.d r5 = r5.f652b
            r5.f629b = r0
            goto L48
        L5d:
            if (r2 != r1) goto L48
            b.g.b.i.d r5 = r5.f652b
            r5.f630c = r0
            goto L48
        L64:
            int r4 = r0.f
            if (r4 != 0) goto L74
            b.g.b.i.d r4 = r0.f652b
            b.g.b.i.d r4 = r4.K
            b.g.b.i.e r4 = (b.g.b.i.e) r4
            boolean r4 = r4.j0
            if (r4 == 0) goto L74
            r4 = 1
            goto L75
        L74:
            r4 = 0
        L75:
            if (r4 == 0) goto L90
            java.util.ArrayList<b.g.b.i.l.m> r4 = r0.k
            int r4 = r4.size()
            if (r4 <= r1) goto L90
            java.util.ArrayList<b.g.b.i.l.m> r4 = r0.k
            int r5 = r4.size()
            int r5 = r5 - r1
            java.lang.Object r4 = r4.get(r5)
            b.g.b.i.l.m r4 = (b.g.b.i.l.m) r4
            b.g.b.i.d r4 = r4.f652b
            r0.f652b = r4
        L90:
            int r4 = r0.f
            if (r4 != 0) goto L99
            b.g.b.i.d r4 = r0.f652b
            int r4 = r4.a0
            goto L9d
        L99:
            b.g.b.i.d r4 = r0.f652b
            int r4 = r4.b0
        L9d:
            r0.l = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.c.<init>(b.g.b.i.d, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01b5 A[PHI: r1 r22 r23
  0x01b5: PHI (r1v45 int) = (r1v43 int), (r1v51 int) binds: [B:116:0x01b3, B:107:0x018d] A[DONT_GENERATE, DONT_INLINE]
  0x01b5: PHI (r22v3 float) = (r22v2 float), (r22v5 float) binds: [B:116:0x01b3, B:107:0x018d] A[DONT_GENERATE, DONT_INLINE]
  0x01b5: PHI (r23v8 b.g.b.i.d$a) = (r23v7 b.g.b.i.d$a), (r23v10 b.g.b.i.d$a) binds: [B:116:0x01b3, B:107:0x018d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.b.i.l.m, b.g.b.i.l.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(b.g.b.i.l.d r25) {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.c.a(b.g.b.i.l.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[PHI: r0 r1
  0x0078: PHI (r0v15 int) = (r0v10 int), (r0v20 int) binds: [B:29:0x00c4, B:19:0x0076] A[DONT_GENERATE, DONT_INLINE]
  0x0078: PHI (r1v3 b.g.b.i.l.f) = (r1v2 b.g.b.i.l.f), (r1v7 b.g.b.i.l.f) binds: [B:29:0x00c4, B:19:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.b.i.l.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.c.d():void");
    }

    @Override // b.g.b.i.l.m
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).e();
        }
    }

    @Override // b.g.b.i.l.m
    public void f() {
        this.f653c = null;
        Iterator<m> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // b.g.b.i.l.m
    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            m mVar = this.k.get(i);
            j = ((long) mVar.i.f) + mVar.j() + j + ((long) mVar.h.f);
        }
        return j;
    }

    @Override // b.g.b.i.l.m
    public boolean k() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!this.k.get(i).k()) {
                return false;
            }
        }
        return true;
    }

    public final b.g.b.i.d m() {
        for (int i = 0; i < this.k.size(); i++) {
            b.g.b.i.d dVar = this.k.get(i).f652b;
            if (dVar.X != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final b.g.b.i.d n() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            b.g.b.i.d dVar = this.k.get(size).f652b;
            if (dVar.X != 8) {
                return dVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sbE = c.a.a.a.a.e("ChainRun ");
        sbE.append(this.f == 0 ? "horizontal : " : "vertical : ");
        String string = sbE.toString();
        for (m mVar : this.k) {
            string = c.a.a.a.a.c(c.a.a.a.a.c(string, "<") + mVar, "> ");
        }
        return string;
    }
}
