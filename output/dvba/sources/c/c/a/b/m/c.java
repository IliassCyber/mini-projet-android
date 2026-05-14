package c.c.a.b.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.i.m.l;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<V extends View> extends e<V> {
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public VelocityTracker j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CoordinatorLayout f1650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final V f1651c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f1650b = coordinatorLayout;
            this.f1651c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f1651c == null || (overScroller = c.this.e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                c cVar = c.this;
                cVar.H(this.f1650b, this.f1651c, cVar.e.getCurrY());
                l.P(this.f1651c, this);
                return;
            }
            c cVar2 = c.this;
            CoordinatorLayout coordinatorLayout = this.f1650b;
            V v = this.f1651c;
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) cVar2;
            if (baseBehavior == null) {
                throw null;
            }
            AppBarLayout appBarLayout = (AppBarLayout) v;
            baseBehavior.P(coordinatorLayout, appBarLayout);
            if (appBarLayout.j) {
                appBarLayout.c(appBarLayout.d(baseBehavior.L(coordinatorLayout)));
            }
        }
    }

    public c() {
        this.g = -1;
        this.i = -1;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.i = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.j.computeCurrentVelocity(1000);
                    float yVelocity = this.j.getYVelocity(this.g);
                    AppBarLayout appBarLayout = (AppBarLayout) v;
                    int i = -appBarLayout.getTotalScrollRange();
                    Runnable runnable = this.d;
                    if (runnable != null) {
                        v.removeCallbacks(runnable);
                        this.d = null;
                    }
                    if (this.e == null) {
                        this.e = new OverScroller(v.getContext());
                    }
                    this.e.fling(0, B(), 0, Math.round(yVelocity), 0, 0, i, 0);
                    if (this.e.computeScrollOffset()) {
                        a aVar = new a(coordinatorLayout, v);
                        this.d = aVar;
                        l.P(v, aVar);
                    } else {
                        AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                        baseBehavior.P(coordinatorLayout, appBarLayout);
                        if (appBarLayout.j) {
                            appBarLayout.c(appBarLayout.d(baseBehavior.L(coordinatorLayout)));
                        }
                    }
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.g);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int i2 = this.h - y;
                if (!this.f) {
                    int iAbs = Math.abs(i2);
                    int i3 = this.i;
                    if (iAbs > i3) {
                        this.f = true;
                        i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                    }
                }
                if (this.f) {
                    this.h = y;
                    G(coordinatorLayout, v, i2, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.f = false;
            this.g = -1;
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
        } else {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.j(v, x, y2) || !E(v)) {
                return false;
            }
            this.h = y2;
            this.g = motionEvent.getPointerId(0);
            if (this.j == null) {
                this.j = VelocityTracker.obtain();
            }
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public abstract boolean E(V v);

    public abstract int F();

    public final int G(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return I(coordinatorLayout, v, F() - i, i2, i3);
    }

    public int H(CoordinatorLayout coordinatorLayout, V v, int i) {
        return I(coordinatorLayout, v, i, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    public abstract int I(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L8a
        L2f:
            int r6 = r4.g
            if (r6 != r5) goto L34
            goto L8a
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L8a
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.i
            if (r6 <= r0) goto L8a
            r4.f = r2
            r4.h = r5
            goto L8a
        L51:
            r4.f = r3
            r4.g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L8a
            r5.recycle()
            r5 = 0
            r4.j = r5
            goto L8a
        L60:
            r4.f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.E(r6)
            if (r2 == 0) goto L8a
            boolean r5 = r5.j(r6, r0, r1)
            if (r5 == 0) goto L8a
            r4.h = r1
            int r5 = r7.getPointerId(r3)
            r4.g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 != 0) goto L8a
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r4.j = r5
        L8a:
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L91
            r5.addMovement(r7)
        L91:
            boolean r5 = r4.f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.m.c.j(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
