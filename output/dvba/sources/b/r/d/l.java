package b.r.d;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class l extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f1054c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public RecyclerView s;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z = ValueAnimator.ofFloat(0.0f, 1.0f);
    public int A = 0;
    public final Runnable B = new a();
    public final RecyclerView.t C = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            int i = lVar.A;
            if (i == 1) {
                lVar.z.cancel();
            } else if (i != 2) {
                return;
            }
            lVar.A = 3;
            ValueAnimator valueAnimator = lVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            lVar.z.setDuration(500);
            lVar.z.start();
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            l lVar = l.this;
            int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int iComputeVerticalScrollRange = lVar.s.computeVerticalScrollRange();
            int i3 = lVar.r;
            lVar.t = iComputeVerticalScrollRange - i3 > 0 && i3 >= lVar.f1052a;
            int iComputeHorizontalScrollRange = lVar.s.computeHorizontalScrollRange();
            int i4 = lVar.q;
            boolean z = iComputeHorizontalScrollRange - i4 > 0 && i4 >= lVar.f1052a;
            lVar.u = z;
            if (!lVar.t && !z) {
                if (lVar.v != 0) {
                    lVar.j(0);
                    return;
                }
                return;
            }
            if (lVar.t) {
                float f = i3;
                lVar.l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                lVar.k = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
            }
            if (lVar.u) {
                float f2 = iComputeHorizontalScrollOffset;
                float f3 = i4;
                lVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                lVar.n = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
            }
            int i5 = lVar.v;
            if (i5 == 0 || i5 == 1) {
                lVar.j(1);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1057a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1057a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1057a) {
                this.f1057a = false;
                return;
            }
            if (((Float) l.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                l lVar = l.this;
                lVar.A = 0;
                lVar.j(0);
            } else {
                l lVar2 = l.this;
                lVar2.A = 2;
                lVar2.s.invalidate();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            l.this.f1054c.setAlpha(iFloatValue);
            l.this.d.setAlpha(iFloatValue);
            l.this.s.invalidate();
        }
    }

    public l(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f1054c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f1052a = i2;
        this.f1053b = i3;
        this.f1054c.setAlpha(255);
        this.d.setAlpha(255);
        this.z.addListener(new c());
        this.z.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.s.removeOnItemTouchListener(this);
            this.s.removeOnScrollListener(this.C);
            f();
        }
        this.s = recyclerView;
        recyclerView.addItemDecoration(this);
        this.s.addOnItemTouchListener(this);
        this.s.addOnScrollListener(this.C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.v;
        if (i == 1) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zG = g(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (zH || zG)) {
                if (zG) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zH) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                j(2);
                return true;
            }
        } else if (i == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zG = g(motionEvent.getX(), motionEvent.getY());
            if (zH || zG) {
                if (zG) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zH) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                j(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            j(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            k();
            if (this.w == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.y;
                int i = this.f1053b;
                iArr[0] = i;
                iArr[1] = this.q - i;
                float fMax = Math.max(iArr[0], Math.min(iArr[1], x));
                if (Math.abs(this.o - fMax) >= 2.0f) {
                    int i2 = i(this.p, fMax, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                    if (i2 != 0) {
                        this.s.scrollBy(i2, 0);
                    }
                    this.p = fMax;
                }
            }
            if (this.w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.x;
                int i3 = this.f1053b;
                iArr2[0] = i3;
                iArr2[1] = this.r - i3;
                float fMax2 = Math.max(iArr2[0], Math.min(iArr2[1], y));
                if (Math.abs(this.l - fMax2) < 2.0f) {
                    return;
                }
                int i4 = i(this.m, fMax2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                if (i4 != 0) {
                    this.s.scrollBy(0, i4);
                }
                this.m = fMax2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void e(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            j(0);
            return;
        }
        if (this.A != 0) {
            if (this.t) {
                int i = this.q;
                int i2 = this.e;
                int i3 = i - i2;
                int i4 = this.l;
                int i5 = this.k;
                int i6 = i4 - (i5 / 2);
                this.f1054c.setBounds(0, 0, i2, i5);
                this.d.setBounds(0, 0, this.f, this.r);
                if (b.i.m.l.r(this.s) == 1) {
                    this.d.draw(canvas);
                    canvas.translate(this.e, i6);
                    canvas.scale(-1.0f, 1.0f);
                    this.f1054c.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    i3 = this.e;
                } else {
                    canvas.translate(i3, 0.0f);
                    this.d.draw(canvas);
                    canvas.translate(0.0f, i6);
                    this.f1054c.draw(canvas);
                }
                canvas.translate(-i3, -i6);
            }
            if (this.u) {
                int i7 = this.r;
                int i8 = this.i;
                int i9 = this.o;
                int i10 = this.n;
                this.g.setBounds(0, 0, i10, i8);
                this.h.setBounds(0, 0, this.q, this.j);
                canvas.translate(0.0f, i7 - i8);
                this.h.draw(canvas);
                canvas.translate(i9 - (i10 / 2), 0.0f);
                this.g.draw(canvas);
                canvas.translate(-r2, -r7);
            }
        }
    }

    public final void f() {
        this.s.removeCallbacks(this.B);
    }

    public boolean g(float f, float f2) {
        if (f2 >= this.r - this.i) {
            int i = this.o;
            int i2 = this.n;
            if (f >= i - (i2 / 2) && f <= (i2 / 2) + i) {
                return true;
            }
        }
        return false;
    }

    public boolean h(float f, float f2) {
        if (b.i.m.l.r(this.s) == 1) {
            if (f > this.e / 2) {
                return false;
            }
        } else if (f < this.q - this.e) {
            return false;
        }
        int i = this.l;
        int i2 = this.k / 2;
        return f2 >= ((float) (i - i2)) && f2 <= ((float) (i2 + i));
    }

    public final int i(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    public void j(int i) {
        int i2;
        if (i == 2 && this.v != 2) {
            this.f1054c.setState(D);
            f();
        }
        if (i == 0) {
            this.s.invalidate();
        } else {
            k();
        }
        if (this.v != 2 || i == 2) {
            i2 = i == 1 ? 1500 : 1200;
            this.v = i;
        }
        this.f1054c.setState(E);
        f();
        this.s.postDelayed(this.B, i2);
        this.v = i;
    }

    public void k() {
        int i = this.A;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }
}
