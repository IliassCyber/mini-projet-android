package b.r.d;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {
    public static final ThreadLocal<m> f = new ThreadLocal<>();
    public static Comparator<c> g = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1061c;
    public long d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<RecyclerView> f1060b = new ArrayList<>();
    public ArrayList<c> e = new ArrayList<>();

    public static class a implements Comparator<c> {
        /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int compare(b.r.d.m.c r6, b.r.d.m.c r7) {
            /*
                r5 = this;
                b.r.d.m$c r6 = (b.r.d.m.c) r6
                b.r.d.m$c r7 = (b.r.d.m.c) r7
                androidx.recyclerview.widget.RecyclerView r0 = r6.d
                r1 = 1
                r2 = 0
                if (r0 != 0) goto Lc
                r0 = 1
                goto Ld
            Lc:
                r0 = 0
            Ld:
                androidx.recyclerview.widget.RecyclerView r3 = r7.d
                if (r3 != 0) goto L13
                r3 = 1
                goto L14
            L13:
                r3 = 0
            L14:
                r4 = -1
                if (r0 == r3) goto L1c
                androidx.recyclerview.widget.RecyclerView r6 = r6.d
                if (r6 != 0) goto L24
                goto L25
            L1c:
                boolean r0 = r6.f1065a
                boolean r3 = r7.f1065a
                if (r0 == r3) goto L27
                if (r0 == 0) goto L25
            L24:
                r1 = -1
            L25:
                r2 = r1
                goto L38
            L27:
                int r0 = r7.f1066b
                int r1 = r6.f1066b
                int r0 = r0 - r1
                if (r0 == 0) goto L30
                r2 = r0
                goto L38
            L30:
                int r6 = r6.f1067c
                int r7 = r7.f1067c
                int r6 = r6 - r7
                if (r6 == 0) goto L38
                r2 = r6
            L38:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: b.r.d.m.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f1064c;
        public int d;

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            int[] iArr = this.f1064c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f1064c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f1064c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f1064c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.d++;
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.f1064c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.l) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.g()) {
                    oVar.j(recyclerView.mAdapter.a(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.i(this.f1062a, this.f1063b, recyclerView.mState, this);
            }
            int i = this.d;
            if (i > oVar.m) {
                oVar.m = i;
                oVar.n = z;
                recyclerView.mRecycler.m();
            }
        }

        public boolean c(int i) {
            if (this.f1064c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1064c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1067c;
        public RecyclerView d;
        public int e;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f1061c == 0) {
            this.f1061c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.f1062a = i;
        bVar.f1063b = i2;
    }

    public void b(long j) {
        RecyclerView recyclerView;
        c cVar;
        int size = this.f1060b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView2 = this.f1060b.get(i2);
            if (recyclerView2.getWindowVisibility() == 0) {
                recyclerView2.mPrefetchRegistry.b(recyclerView2, false);
                i += recyclerView2.mPrefetchRegistry.d;
            }
        }
        this.e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = this.f1060b.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                b bVar = recyclerView3.mPrefetchRegistry;
                int iAbs = Math.abs(bVar.f1063b) + Math.abs(bVar.f1062a);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.e.size()) {
                        cVar = new c();
                        this.e.add(cVar);
                    } else {
                        cVar = this.e.get(i3);
                    }
                    int i6 = bVar.f1064c[i5 + 1];
                    cVar.f1065a = i6 <= iAbs;
                    cVar.f1066b = iAbs;
                    cVar.f1067c = i6;
                    cVar.d = recyclerView3;
                    cVar.e = bVar.f1064c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.e, g);
        for (int i7 = 0; i7 < this.e.size(); i7++) {
            c cVar2 = this.e.get(i7);
            if (cVar2.d == null) {
                return;
            }
            RecyclerView.d0 d0VarC = c(cVar2.d, cVar2.e, cVar2.f1065a ? RecyclerView.FOREVER_NS : j);
            if (d0VarC != null && d0VarC.f185b != null && d0VarC.j() && !d0VarC.k() && (recyclerView = d0VarC.f185b.get()) != null) {
                if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.h() != 0) {
                    recyclerView.removeAndRecycleViews();
                }
                b bVar2 = recyclerView.mPrefetchRegistry;
                bVar2.b(recyclerView, true);
                if (bVar2.d != 0) {
                    try {
                        b.i.i.b.a(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                        RecyclerView.a0 a0Var = recyclerView.mState;
                        RecyclerView.g gVar = recyclerView.mAdapter;
                        a0Var.d = 1;
                        a0Var.e = gVar.a();
                        a0Var.g = false;
                        a0Var.h = false;
                        a0Var.i = false;
                        for (int i8 = 0; i8 < bVar2.d * 2; i8 += 2) {
                            c(recyclerView, bVar2.f1064c[i8], j);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        b.i.i.b.b();
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            cVar2.f1065a = false;
            cVar2.f1066b = 0;
            cVar2.f1067c = 0;
            cVar2.d = null;
            cVar2.e = 0;
        }
    }

    public final RecyclerView.d0 c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int iH = recyclerView.mChildHelper.h();
        int i2 = 0;
        while (true) {
            if (i2 >= iH) {
                z = false;
                break;
            }
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i2));
            if (childViewHolderInt.f186c == i && !childViewHolderInt.k()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 d0VarK = vVar.k(i, false, j);
            if (d0VarK != null) {
                if (!d0VarK.j() || d0VarK.k()) {
                    vVar.a(d0VarK, false);
                } else {
                    vVar.h(d0VarK.f184a);
                }
            }
            return d0VarK;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.i.i.b.a(RecyclerView.TRACE_PREFETCH_TAG);
            if (this.f1060b.isEmpty()) {
                this.f1061c = 0L;
                Trace.endSection();
                return;
            }
            int size = this.f1060b.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.f1060b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.f1061c = 0L;
                Trace.endSection();
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
                this.f1061c = 0L;
                Trace.endSection();
            }
        } catch (Throwable th) {
            this.f1061c = 0L;
            b.i.i.b.b();
            throw th;
        }
    }
}
