package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import b.r.d.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements q.a {
    public final InterfaceC0042a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.i.l.c<b> f1014a = new b.i.l.c<>(30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f1015b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f1016c = new ArrayList<>();
    public int g = 0;
    public final boolean e = false;
    public final q f = new q(this);

    /* JADX INFO: renamed from: b.r.d.a$a, reason: collision with other inner class name */
    public interface InterfaceC0042a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f1019c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.f1017a = i;
            this.f1018b = i2;
            this.d = i3;
            this.f1019c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f1017a;
            if (i != bVar.f1017a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.f1018b) == 1 && this.d == bVar.f1018b && this.f1018b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f1018b != bVar.f1018b) {
                return false;
            }
            Object obj2 = this.f1019c;
            Object obj3 = bVar.f1019c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1017a * 31) + this.f1018b) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.f1017a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f1018b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.f1019c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(InterfaceC0042a interfaceC0042a) {
        this.d = interfaceC0042a;
    }

    public final boolean a(int i) {
        int size = this.f1016c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1016c.get(i2);
            int i3 = bVar.f1017a;
            if (i3 == 8) {
                if (f(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f1018b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        int size = this.f1016c.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.f) this.d).a(this.f1016c.get(i));
        }
        l(this.f1016c);
        this.g = 0;
    }

    public void c() {
        b();
        int size = this.f1015b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1015b.get(i);
            int i2 = bVar.f1017a;
            if (i2 == 1) {
                ((RecyclerView.f) this.d).a(bVar);
                RecyclerView.f fVar = (RecyclerView.f) this.d;
                RecyclerView.this.offsetPositionRecordsForInsert(bVar.f1018b, bVar.d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                ((RecyclerView.f) this.d).a(bVar);
                InterfaceC0042a interfaceC0042a = this.d;
                int i3 = bVar.f1018b;
                int i4 = bVar.d;
                RecyclerView.f fVar2 = (RecyclerView.f) interfaceC0042a;
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f179c += i4;
            } else if (i2 == 4) {
                ((RecyclerView.f) this.d).a(bVar);
                ((RecyclerView.f) this.d).c(bVar.f1018b, bVar.d, bVar.f1019c);
            } else if (i2 == 8) {
                ((RecyclerView.f) this.d).a(bVar);
                RecyclerView.f fVar3 = (RecyclerView.f) this.d;
                RecyclerView.this.offsetPositionRecordsForMove(bVar.f1018b, bVar.d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        }
        l(this.f1015b);
        this.g = 0;
    }

    public final void d(b bVar) {
        int i;
        int i2 = bVar.f1017a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM = m(bVar.f1018b, i2);
        int i3 = bVar.f1018b;
        int i4 = bVar.f1017a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.d; i6++) {
            int iM2 = m((i * i6) + bVar.f1018b, bVar.f1017a);
            int i7 = bVar.f1017a;
            if (i7 == 2 ? iM2 == iM : i7 == 4 && iM2 == iM + 1) {
                i5++;
            } else {
                b bVarH = h(bVar.f1017a, iM, i5, bVar.f1019c);
                e(bVarH, i3);
                if (!this.e) {
                    bVarH.f1019c = null;
                    this.f1014a.b(bVarH);
                }
                if (bVar.f1017a == 4) {
                    i3 += i5;
                }
                iM = iM2;
                i5 = 1;
            }
        }
        Object obj = bVar.f1019c;
        if (!this.e) {
            bVar.f1019c = null;
            this.f1014a.b(bVar);
        }
        if (i5 > 0) {
            b bVarH2 = h(bVar.f1017a, iM, i5, obj);
            e(bVarH2, i3);
            if (this.e) {
                return;
            }
            bVarH2.f1019c = null;
            this.f1014a.b(bVarH2);
        }
    }

    public void e(b bVar, int i) {
        ((RecyclerView.f) this.d).a(bVar);
        int i2 = bVar.f1017a;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            RecyclerView.f fVar = (RecyclerView.f) this.d;
            RecyclerView.this.viewRangeUpdate(i, bVar.d, bVar.f1019c);
            RecyclerView.this.mItemsChanged = true;
            return;
        }
        InterfaceC0042a interfaceC0042a = this.d;
        int i3 = bVar.d;
        RecyclerView.f fVar2 = (RecyclerView.f) interfaceC0042a;
        RecyclerView.this.offsetPositionRecordsForRemove(i, i3, true);
        RecyclerView recyclerView = RecyclerView.this;
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.f179c += i3;
    }

    public int f(int i, int i2) {
        int size = this.f1016c.size();
        while (i2 < size) {
            b bVar = this.f1016c.get(i2);
            int i3 = bVar.f1017a;
            if (i3 == 8) {
                int i4 = bVar.f1018b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f1018b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean g() {
        return this.f1015b.size() > 0;
    }

    public b h(int i, int i2, int i3, Object obj) {
        b bVarA = this.f1014a.a();
        if (bVarA == null) {
            return new b(i, i2, i3, obj);
        }
        bVarA.f1017a = i;
        bVarA.f1018b = i2;
        bVarA.d = i3;
        bVarA.f1019c = obj;
        return bVarA;
    }

    public final void i(b bVar) {
        this.f1016c.add(bVar);
        int i = bVar.f1017a;
        if (i == 1) {
            RecyclerView.f fVar = (RecyclerView.f) this.d;
            RecyclerView.this.offsetPositionRecordsForInsert(bVar.f1018b, bVar.d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 2) {
            RecyclerView.f fVar2 = (RecyclerView.f) this.d;
            RecyclerView.this.offsetPositionRecordsForRemove(bVar.f1018b, bVar.d, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 4) {
            ((RecyclerView.f) this.d).c(bVar.f1018b, bVar.d, bVar.f1019c);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
            RecyclerView.f fVar3 = (RecyclerView.f) this.d;
            RecyclerView.this.offsetPositionRecordsForMove(bVar.f1018b, bVar.d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0196 A[PHI: r6
  0x0196: PHI (r6v29 int) = (r6v23 int), (r6v33 int) binds: [B:105:0x0194, B:92:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            Method dump skipped, instruction units count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.d.a.j():void");
    }

    public void k(b bVar) {
        if (this.e) {
            return;
        }
        bVar.f1019c = null;
        this.f1014a.b(bVar);
    }

    public void l(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k(list.get(i));
        }
        list.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(int r8, int r9) {
        /*
            r7 = this;
            java.util.ArrayList<b.r.d.a$b> r0 = r7.f1016c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            r2 = 8
            if (r0 < 0) goto L84
            java.util.ArrayList<b.r.d.a$b> r3 = r7.f1016c
            java.lang.Object r3 = r3.get(r0)
            b.r.d.a$b r3 = (b.r.d.a.b) r3
            int r4 = r3.f1017a
            r5 = 2
            if (r4 != r2) goto L65
            int r2 = r3.f1018b
            int r4 = r3.d
            if (r2 >= r4) goto L20
            goto L23
        L20:
            r6 = r4
            r4 = r2
            r2 = r6
        L23:
            if (r8 < r2) goto L4b
            if (r8 > r4) goto L4b
            int r4 = r3.f1018b
            if (r2 != r4) goto L3c
            if (r9 != r1) goto L33
            int r2 = r3.d
            int r2 = r2 + r1
        L30:
            r3.d = r2
            goto L39
        L33:
            if (r9 != r5) goto L39
            int r2 = r3.d
            int r2 = r2 - r1
            goto L30
        L39:
            int r8 = r8 + 1
            goto L81
        L3c:
            if (r9 != r1) goto L43
            int r4 = r4 + 1
        L40:
            r3.f1018b = r4
            goto L48
        L43:
            if (r9 != r5) goto L48
            int r4 = r4 + (-1)
            goto L40
        L48:
            int r8 = r8 + (-1)
            goto L81
        L4b:
            int r2 = r3.f1018b
            if (r8 >= r2) goto L81
            if (r9 != r1) goto L5b
            int r2 = r2 + 1
            r3.f1018b = r2
            int r2 = r3.d
            int r2 = r2 + r1
        L58:
            r3.d = r2
            goto L81
        L5b:
            if (r9 != r5) goto L81
            int r2 = r2 + (-1)
            r3.f1018b = r2
            int r2 = r3.d
            int r2 = r2 - r1
            goto L58
        L65:
            int r2 = r3.f1018b
            if (r2 > r8) goto L75
            if (r4 != r1) goto L6f
            int r2 = r3.d
            int r8 = r8 - r2
            goto L81
        L6f:
            if (r4 != r5) goto L81
            int r2 = r3.d
            int r8 = r8 + r2
            goto L81
        L75:
            if (r9 != r1) goto L7c
            int r2 = r2 + 1
        L79:
            r3.f1018b = r2
            goto L81
        L7c:
            if (r9 != r5) goto L81
            int r2 = r2 + (-1)
            goto L79
        L81:
            int r0 = r0 + (-1)
            goto L8
        L84:
            java.util.ArrayList<b.r.d.a$b> r9 = r7.f1016c
            int r9 = r9.size()
            int r9 = r9 - r1
        L8b:
            if (r9 < 0) goto Lc4
            java.util.ArrayList<b.r.d.a$b> r0 = r7.f1016c
            java.lang.Object r0 = r0.get(r9)
            b.r.d.a$b r0 = (b.r.d.a.b) r0
            int r1 = r0.f1017a
            r3 = 0
            if (r1 != r2) goto Lb3
            int r1 = r0.d
            int r4 = r0.f1018b
            if (r1 == r4) goto La2
            if (r1 >= 0) goto Lc1
        La2:
            java.util.ArrayList<b.r.d.a$b> r1 = r7.f1016c
            r1.remove(r9)
            boolean r1 = r7.e
            if (r1 != 0) goto Lc1
        Lab:
            r0.f1019c = r3
            b.i.l.c<b.r.d.a$b> r1 = r7.f1014a
            r1.b(r0)
            goto Lc1
        Lb3:
            int r1 = r0.d
            if (r1 > 0) goto Lc1
            java.util.ArrayList<b.r.d.a$b> r1 = r7.f1016c
            r1.remove(r9)
            boolean r1 = r7.e
            if (r1 != 0) goto Lc1
            goto Lab
        Lc1:
            int r9 = r9 + (-1)
            goto L8b
        Lc4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.d.a.m(int, int):int");
    }
}
