package b.g.b.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.i.d;
import b.g.b.i.l.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.g.b.i.e f640a;
    public b.g.b.i.e d;
    public b.InterfaceC0023b f;
    public b.a g;
    public ArrayList<k> h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f641b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f642c = true;
    public ArrayList<m> e = new ArrayList<>();

    public e(b.g.b.i.e eVar) {
        new ArrayList();
        this.f = null;
        this.g = new b.a();
        this.h = new ArrayList<>();
        this.f640a = eVar;
        this.d = eVar;
    }

    public final void a(f fVar, int i, int i2, f fVar2, ArrayList<k> arrayList, k kVar) {
        m mVar = fVar.d;
        if (mVar.f653c == null) {
            b.g.b.i.e eVar = this.f640a;
            if (mVar == eVar.d || mVar == eVar.e) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i2);
                arrayList.add(kVar);
            }
            mVar.f653c = kVar;
            kVar.f650b.add(mVar);
            for (d dVar : mVar.h.k) {
                if (dVar instanceof f) {
                    a((f) dVar, i, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.i.k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i, 1, fVar2, arrayList, kVar);
                }
            }
            if (i == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).k.k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            Iterator<f> it = mVar.h.l.iterator();
            while (it.hasNext()) {
                a(it.next(), i, 0, fVar2, arrayList, kVar);
            }
            Iterator<f> it2 = mVar.i.l.iterator();
            while (it2.hasNext()) {
                a(it2.next(), i, 1, fVar2, arrayList, kVar);
            }
            if (i == 1 && (mVar instanceof l)) {
                Iterator<f> it3 = ((l) mVar).k.l.iterator();
                while (it3.hasNext()) {
                    a(it3.next(), i, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0010 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(b.g.b.i.e r19) {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.e.b(b.g.b.i.e):boolean");
    }

    public void c() {
        m hVar;
        ArrayList<m> arrayList = this.e;
        arrayList.clear();
        this.d.d.f();
        this.d.e.f();
        arrayList.add(this.d.d);
        arrayList.add(this.d.e);
        HashSet hashSet = null;
        for (b.g.b.i.d dVar : this.d.f0) {
            if (dVar instanceof b.g.b.i.f) {
                hVar = new h(dVar);
            } else {
                if (dVar.s()) {
                    if (dVar.f629b == null) {
                        dVar.f629b = new c(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f629b);
                } else {
                    arrayList.add(dVar.d);
                }
                if (dVar.t()) {
                    if (dVar.f630c == null) {
                        dVar.f630c = new c(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f630c);
                } else {
                    arrayList.add(dVar.e);
                }
                if (dVar instanceof b.g.b.i.h) {
                    hVar = new i(dVar);
                }
            }
            arrayList.add(hVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (m mVar : arrayList) {
            if (mVar.f652b != this.d) {
                mVar.d();
            }
        }
        this.h.clear();
        k.f648c = 0;
        e(this.f640a.d, 0, this.h);
        e(this.f640a.e, 1, this.h);
        this.f641b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(b.g.b.i.e r17, int r18) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.e.d(b.g.b.i.e, int):int");
    }

    public final void e(m mVar, int i, ArrayList<k> arrayList) {
        for (d dVar : mVar.h.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, mVar.i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).h, i, 0, mVar.i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.i.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, mVar.h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).i, i, 1, mVar.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (d dVar3 : ((l) mVar).k.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(b.g.b.i.d dVar, d.a aVar, int i, d.a aVar2, int i2) {
        b.a aVar3 = this.g;
        aVar3.f637a = aVar;
        aVar3.f638b = aVar2;
        aVar3.f639c = i;
        aVar3.d = i2;
        ((ConstraintLayout.b) this.f).a(dVar, aVar3);
        dVar.B(this.g.e);
        dVar.w(this.g.f);
        b.a aVar4 = this.g;
        dVar.w = aVar4.h;
        int i3 = aVar4.g;
        dVar.R = i3;
        dVar.w = i3 > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r13 == r7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        r0.m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        r0.c(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (r11 == r7) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            r14 = this;
            b.g.b.i.d$a r6 = b.g.b.i.d.a.FIXED
            b.g.b.i.d$a r7 = b.g.b.i.d.a.MATCH_CONSTRAINT
            b.g.b.i.d$a r8 = b.g.b.i.d.a.WRAP_CONTENT
            b.g.b.i.e r0 = r14.f640a
            java.util.ArrayList<b.g.b.i.d> r0 = r0.f0
            java.util.Iterator r9 = r0.iterator()
        Le:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lb6
            java.lang.Object r0 = r9.next()
            r10 = r0
            b.g.b.i.d r10 = (b.g.b.i.d) r10
            boolean r0 = r10.f628a
            if (r0 == 0) goto L20
            goto Le
        L20:
            b.g.b.i.d$a[] r0 = r10.J
            r1 = 0
            r11 = r0[r1]
            r12 = 1
            r13 = r0[r12]
            int r0 = r10.j
            int r2 = r10.k
            if (r11 == r8) goto L35
            if (r11 != r7) goto L33
            if (r0 != r12) goto L33
            goto L35
        L33:
            r0 = 0
            goto L36
        L35:
            r0 = 1
        L36:
            if (r13 == r8) goto L3c
            if (r13 != r7) goto L3d
            if (r2 != r12) goto L3d
        L3c:
            r1 = 1
        L3d:
            b.g.b.i.l.j r2 = r10.d
            b.g.b.i.l.g r2 = r2.e
            boolean r3 = r2.j
            b.g.b.i.l.l r4 = r10.e
            b.g.b.i.l.g r4 = r4.e
            boolean r5 = r4.j
            if (r3 == 0) goto L5b
            if (r5 == 0) goto L5b
            int r3 = r2.g
            int r5 = r4.g
            r0 = r14
            r1 = r10
            r2 = r6
            r4 = r6
            r0.f(r1, r2, r3, r4, r5)
        L58:
            r10.f628a = r12
            goto La5
        L5b:
            if (r3 == 0) goto L83
            if (r1 == 0) goto L83
            b.g.b.i.l.j r0 = r10.d
            b.g.b.i.l.g r0 = r0.e
            int r3 = r0.g
            b.g.b.i.l.l r0 = r10.e
            b.g.b.i.l.g r0 = r0.e
            int r5 = r0.g
            r0 = r14
            r1 = r10
            r2 = r6
            r4 = r8
            r0.f(r1, r2, r3, r4, r5)
            b.g.b.i.l.l r0 = r10.e
            b.g.b.i.l.g r0 = r0.e
            int r1 = r10.i()
            if (r13 != r7) goto L7f
        L7c:
            r0.m = r1
            goto La5
        L7f:
            r0.c(r1)
            goto L58
        L83:
            if (r5 == 0) goto La5
            if (r0 == 0) goto La5
            b.g.b.i.l.j r0 = r10.d
            b.g.b.i.l.g r0 = r0.e
            int r3 = r0.g
            b.g.b.i.l.l r0 = r10.e
            b.g.b.i.l.g r0 = r0.e
            int r5 = r0.g
            r0 = r14
            r1 = r10
            r2 = r8
            r4 = r6
            r0.f(r1, r2, r3, r4, r5)
            b.g.b.i.l.j r0 = r10.d
            b.g.b.i.l.g r0 = r0.e
            int r1 = r10.o()
            if (r11 != r7) goto L7f
            goto L7c
        La5:
            boolean r0 = r10.f628a
            if (r0 == 0) goto Le
            b.g.b.i.l.l r0 = r10.e
            b.g.b.i.l.g r0 = r0.l
            if (r0 == 0) goto Le
            int r1 = r10.R
            r0.c(r1)
            goto Le
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.b.i.l.e.g():void");
    }
}
