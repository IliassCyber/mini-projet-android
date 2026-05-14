package b.k.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import b.i.m.l;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final Interpolator v = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f895b;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public OverScroller p;
    public final c q;
    public View r;
    public boolean s;
    public final ViewGroup t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f896c = -1;
    public final Runnable u = new b();

    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.s(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(View view) {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public void e(View view, int i) {
        }

        public abstract void f(int i);

        public abstract void g(View view, int i, int i2, int i3, int i4);

        public abstract void h(View view, float f, float f2);

        public abstract boolean i(View view, int i);
    }

    public e(Context context, ViewGroup viewGroup, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.t = viewGroup;
        this.q = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f895b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = new OverScroller(context, v);
    }

    public void a() {
        this.f896c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void b(View view, int i) {
        if (view.getParent() != this.t) {
            StringBuilder sbE = c.a.a.a.a.e("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            sbE.append(this.t);
            sbE.append(")");
            throw new IllegalArgumentException(sbE.toString());
        }
        this.r = view;
        this.f896c = i;
        this.q.e(view, i);
        s(1);
    }

    public final boolean c(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (0 & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f895b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || this.q != null) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.f895b);
        }
        throw null;
    }

    public final boolean d(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.q.c(view) > 0;
        boolean z2 = this.q.d(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f895b) : z2 && Math.abs(f2) > ((float) this.f895b);
        }
        float f3 = (f2 * f2) + (f * f);
        int i = this.f895b;
        return f3 > ((float) (i * i));
    }

    public final float e(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    public final int f(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    public final void g(int i) {
        if (this.d != null) {
            int i2 = 1 << i;
            if ((this.k & i2) != 0) {
                this.d[i] = 0.0f;
                this.e[i] = 0.0f;
                this.f[i] = 0.0f;
                this.g[i] = 0.0f;
                this.h[i] = 0;
                this.i[i] = 0;
                this.j[i] = 0;
                this.k &= ~i2;
            }
        }
    }

    public final int h(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        float width = this.t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public boolean i(boolean z) {
        if (this.f894a == 2) {
            boolean zComputeScrollOffset = this.p.computeScrollOffset();
            int currX = this.p.getCurrX();
            int currY = this.p.getCurrY();
            int left = currX - this.r.getLeft();
            int top = currY - this.r.getTop();
            if (left != 0) {
                l.J(this.r, left);
            }
            if (top != 0) {
                l.K(this.r, top);
            }
            if (left != 0 || top != 0) {
                this.q.g(this.r, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.p.getFinalX() && currY == this.p.getFinalY()) {
                this.p.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.t.post(this.u);
                } else {
                    s(0);
                }
            }
        }
        return this.f894a == 2;
    }

    public final void j(float f, float f2) {
        this.s = true;
        this.q.h(this.r, f, f2);
        this.s = false;
        if (this.f894a == 1) {
            s(0);
        }
    }

    public View k(int i, int i2) {
        int childCount = this.t.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return null;
            }
            ViewGroup viewGroup = this.t;
            if (this.q == null) {
                throw null;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
    }

    public final boolean l(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.r.getLeft();
        int top = this.r.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.p.abortAnimation();
            s(0);
            return false;
        }
        View view = this.r;
        int iF = f(i3, (int) this.n, (int) this.m);
        int iF2 = f(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i5);
        int iAbs2 = Math.abs(i6);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i7 = iAbs3 + iAbs4;
        int i8 = iAbs + iAbs2;
        if (iF != 0) {
            f = iAbs3;
            f2 = i7;
        } else {
            f = iAbs;
            f2 = i8;
        }
        float f5 = f / f2;
        if (iF2 != 0) {
            f3 = iAbs4;
            f4 = i7;
        } else {
            f3 = iAbs2;
            f4 = i8;
        }
        int iH = h(i5, iF, this.q.c(view));
        this.p.startScroll(left, top, i5, i6, (int) ((h(i6, iF2, this.q.d(view)) * (f3 / f4)) + (iH * f5)));
        s(2);
        return true;
    }

    public final boolean m(int i) {
        if ((this.k & (1 << i)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public void n(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewK = k((int) x, (int) y);
            q(x, y, pointerId);
            v(viewK, pointerId);
            if ((this.h[pointerId] & 0) != 0 && this.q == null) {
                throw null;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f894a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.d[pointerId2];
                            float f2 = y2 - this.e[pointerId2];
                            p(f, f2, pointerId2);
                            if (this.f894a != 1) {
                                View viewK2 = k((int) x2, (int) y2);
                                if (d(viewK2, f, f2) && v(viewK2, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i2++;
                    }
                } else {
                    if (!m(this.f896c)) {
                        return;
                    }
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f896c);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y3 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f;
                    int i3 = this.f896c;
                    int i4 = (int) (x3 - fArr[i3]);
                    int i5 = (int) (y3 - this.g[i3]);
                    int left = this.r.getLeft() + i4;
                    int top = this.r.getTop() + i5;
                    int left2 = this.r.getLeft();
                    int top2 = this.r.getTop();
                    if (i4 != 0) {
                        left = this.q.a(this.r, left, i4);
                        l.J(this.r, left - left2);
                    }
                    int i6 = left;
                    if (i5 != 0) {
                        top = this.q.b(this.r, top, i5);
                        l.K(this.r, top - top2);
                    }
                    int i7 = top;
                    if (i4 != 0 || i5 != 0) {
                        this.q.g(this.r, i6, i7, i6 - left2, i7 - top2);
                    }
                }
                r(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    if (this.f894a == 1 && pointerId3 == this.f896c) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        while (true) {
                            if (i2 >= pointerCount2) {
                                i = -1;
                                break;
                            }
                            int pointerId4 = motionEvent.getPointerId(i2);
                            if (pointerId4 != this.f896c) {
                                View viewK3 = k((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                                View view = this.r;
                                if (viewK3 == view && v(view, pointerId4)) {
                                    i = this.f896c;
                                    break;
                                }
                            }
                            i2++;
                        }
                        if (i == -1) {
                            o();
                        }
                    }
                    g(pointerId3);
                    return;
                }
                int pointerId5 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                q(x4, y4, pointerId5);
                if (this.f894a == 0) {
                    v(k((int) x4, (int) y4), pointerId5);
                    if ((this.h[pointerId5] & 0) != 0 && this.q == null) {
                        throw null;
                    }
                    return;
                }
                int i8 = (int) x4;
                int i9 = (int) y4;
                View view2 = this.r;
                if (view2 != null && i8 >= view2.getLeft() && i8 < view2.getRight() && i9 >= view2.getTop() && i9 < view2.getBottom()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    v(this.r, pointerId5);
                    return;
                }
                return;
            }
            if (this.f894a == 1) {
                j(0.0f, 0.0f);
            }
        } else if (this.f894a == 1) {
            o();
        }
        a();
    }

    public final void o() {
        this.l.computeCurrentVelocity(1000, this.m);
        j(e(this.l.getXVelocity(this.f896c), this.n, this.m), e(this.l.getYVelocity(this.f896c), this.n, this.m));
    }

    public final void p(float f, float f2, int i) {
        int i2 = c(f, f2, i, 1) ? 1 : 0;
        if (c(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (c(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (c(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            if (this.q == null) {
                throw null;
            }
        }
    }

    public final void q(float f, float f2, int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr10 = this.d;
        this.f[i] = f;
        fArr10[i] = f;
        float[] fArr11 = this.e;
        this.g[i] = f2;
        fArr11[i] = f2;
        int[] iArr7 = this.h;
        int i3 = (int) f;
        int i4 = (int) f2;
        int i5 = i3 < this.t.getLeft() + this.o ? 1 : 0;
        if (i4 < this.t.getTop() + this.o) {
            i5 |= 4;
        }
        if (i3 > this.t.getRight() - this.o) {
            i5 |= 2;
        }
        if (i4 > this.t.getBottom() - this.o) {
            i5 |= 8;
        }
        iArr7[i] = i5;
        this.k |= 1 << i;
    }

    public final void r(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    public void s(int i) {
        this.t.removeCallbacks(this.u);
        if (this.f894a != i) {
            this.f894a = i;
            this.q.f(i);
            if (this.f894a == 0) {
                this.r = null;
            }
        }
    }

    public boolean t(int i, int i2) {
        if (this.s) {
            return l(i, i2, (int) this.l.getXVelocity(this.f896c), (int) this.l.getYVelocity(this.f896c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean u(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.e.u(android.view.MotionEvent):boolean");
    }

    public boolean v(View view, int i) {
        if (view == this.r && this.f896c == i) {
            return true;
        }
        if (view == null || !this.q.i(view, i)) {
            return false;
        }
        this.f896c = i;
        b(view, i);
        return true;
    }
}
