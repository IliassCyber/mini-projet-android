package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.m.l;
import b.k.b.e;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f1970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1971c;
    public float d = 0.0f;
    public int e = 2;
    public float f = 0.5f;
    public float g = 0.0f;
    public float h = 0.5f;
    public final e.c i = new a();

    public class a extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1973b = -1;

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
        @Override // b.k.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = b.i.m.l.r(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = 1
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.e
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.f1972a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f1972a
                goto L37
            L1c:
                int r5 = r2.f1972a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.f1972a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f1972a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r4 = java.lang.Math.max(r5, r4)
                int r3 = java.lang.Math.min(r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // b.k.b.e.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // b.k.b.e.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // b.k.b.e.c
        public void e(View view, int i) {
            this.f1973b = i;
            this.f1972a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // b.k.b.e.c
        public void f(int i) {
            b bVar = SwipeDismissBehavior.this.f1970b;
            if (bVar != null) {
                bVar.b(i);
            }
        }

        @Override // b.k.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            float width = (view.getWidth() * SwipeDismissBehavior.this.g) + this.f1972a;
            float width2 = (view.getWidth() * SwipeDismissBehavior.this.h) + this.f1972a;
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        @Override // b.k.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r10 = -1
                r7.f1973b = r10
                int r10 = r8.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r3 == 0) goto L3a
                int r4 = b.i.m.l.r(r8)
                if (r4 != r2) goto L16
                r4 = 1
                goto L17
            L16:
                r4 = 0
            L17:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.e
                r6 = 2
                if (r5 != r6) goto L1f
                goto L2a
            L1f:
                if (r5 != 0) goto L2e
                if (r4 == 0) goto L28
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L2c
                goto L2a
            L28:
                if (r3 <= 0) goto L2c
            L2a:
                r9 = 1
                goto L57
            L2c:
                r9 = 0
                goto L57
            L2e:
                if (r5 != r2) goto L2c
                if (r4 == 0) goto L35
                if (r3 <= 0) goto L2c
                goto L39
            L35:
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L2c
            L39:
                goto L2a
            L3a:
                int r9 = r8.getLeft()
                int r0 = r7.f1972a
                int r9 = r9 - r0
                int r0 = r8.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.f
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r9 = java.lang.Math.abs(r9)
                if (r9 < r0) goto L2c
                goto L2a
            L57:
                if (r9 == 0) goto L66
                int r9 = r8.getLeft()
                int r0 = r7.f1972a
                if (r9 >= r0) goto L63
                int r0 = r0 - r10
                goto L64
            L63:
                int r0 = r0 + r10
            L64:
                r1 = 1
                goto L68
            L66:
                int r0 = r7.f1972a
            L68:
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                b.k.b.e r9 = r9.f1969a
                int r10 = r8.getTop()
                boolean r9 = r9.t(r0, r10)
                if (r9 == 0) goto L81
                com.google.android.material.behavior.SwipeDismissBehavior$c r9 = new com.google.android.material.behavior.SwipeDismissBehavior$c
                com.google.android.material.behavior.SwipeDismissBehavior r10 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r9.<init>(r8, r1)
                b.i.m.l.P(r8, r9)
                goto L8c
            L81:
                if (r1 == 0) goto L8c
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$b r9 = r9.f1970b
                if (r9 == 0) goto L8c
                r9.a(r8)
            L8c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.h(android.view.View, float, float):void");
        }

        @Override // b.k.b.e.c
        public boolean i(View view, int i) {
            int i2 = this.f1973b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.B(view);
        }
    }

    public interface b {
        void a(View view);

        void b(int i);
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f1975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1976c;

        public c(View view, boolean z) {
            this.f1975b = view;
            this.f1976c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            e eVar = SwipeDismissBehavior.this.f1969a;
            if (eVar != null && eVar.i(true)) {
                l.P(this.f1975b, this);
            } else {
                if (!this.f1976c || (bVar = SwipeDismissBehavior.this.f1970b) == null) {
                    return;
                }
                bVar.a(this.f1975b);
            }
        }
    }

    public static float C(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar = this.f1969a;
        if (eVar == null) {
            return false;
        }
        eVar.n(motionEvent);
        return true;
    }

    public boolean B(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean zJ = this.f1971c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zJ = coordinatorLayout.j(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f1971c = zJ;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1971c = false;
        }
        if (!zJ) {
            return false;
        }
        if (this.f1969a == null) {
            this.f1969a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.i);
        }
        return this.f1969a.u(motionEvent);
    }
}
