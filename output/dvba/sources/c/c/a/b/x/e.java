package c.c.a.b.x;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import b.i.m.l;
import c.c.a.a.c.l.q;
import c.c.a.b.d0.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final TimeInterpolator A = c.c.a.b.l.a.f1629c;
    public static final int[] B = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] C = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] D = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] E = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] F = {R.attr.state_enabled};
    public static final int[] G = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f1732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.c.a.b.d0.g f1733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1734c;
    public float e;
    public float f;
    public float g;
    public final c.c.a.b.y.g h;
    public c.c.a.b.l.g i;
    public c.c.a.b.l.g j;
    public Animator k;
    public c.c.a.b.l.g l;
    public c.c.a.b.l.g m;
    public float n;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<Animator.AnimatorListener> r;
    public ArrayList<InterfaceC0066e> s;
    public final FloatingActionButton t;
    public final c.c.a.b.c0.b u;
    public ViewTreeObserver.OnPreDrawListener z;
    public boolean d = true;
    public float o = 1.0f;
    public int p = 0;
    public final Rect v = new Rect();
    public final RectF w = new RectF();
    public final RectF x = new RectF();
    public final Matrix y = new Matrix();

    public class a extends c.c.a.b.l.f {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            e.this.o = f;
            matrix.getValues(this.f1635a);
            matrix2.getValues(this.f1636b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f1636b;
                float f2 = fArr[i];
                float[] fArr2 = this.f1635a;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.f1637c.setValues(this.f1636b);
            return this.f1637c;
        }
    }

    public class b extends h {
        public b(e eVar) {
            super(null);
        }

        @Override // c.c.a.b.x.e.h
        public float a() {
            return 0.0f;
        }
    }

    public class c extends h {
        public c() {
            super(null);
        }

        @Override // c.c.a.b.x.e.h
        public float a() {
            e eVar = e.this;
            return eVar.e + eVar.f;
        }
    }

    public class d extends h {
        public d() {
            super(null);
        }

        @Override // c.c.a.b.x.e.h
        public float a() {
            e eVar = e.this;
            return eVar.e + eVar.g;
        }
    }

    /* JADX INFO: renamed from: c.c.a.b.x.e$e, reason: collision with other inner class name */
    public interface InterfaceC0066e {
        void a();

        void b();
    }

    public interface f {
    }

    public class g extends h {
        public g() {
            super(null);
        }

        @Override // c.c.a.b.x.e.h
        public float a() {
            return e.this.e;
        }
    }

    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1737c;

        public h(c.c.a.b.x.c cVar) {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this == null) {
                throw null;
            }
            this.f1735a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f1735a) {
                c.c.a.b.d0.g gVar = e.this.f1733b;
                this.f1736b = gVar == null ? 0.0f : gVar.f1555b.o;
                this.f1737c = a();
                this.f1735a = true;
            }
            e eVar = e.this;
            valueAnimator.getAnimatedFraction();
            if (eVar == null) {
                throw null;
            }
        }
    }

    public e(FloatingActionButton floatingActionButton, c.c.a.b.c0.b bVar) {
        this.t = floatingActionButton;
        this.u = bVar;
        c.c.a.b.y.g gVar = new c.c.a.b.y.g();
        this.h = gVar;
        gVar.a(B, b(new d()));
        this.h.a(C, b(new c()));
        this.h.a(D, b(new c()));
        this.h.a(E, b(new c()));
        this.h.a(F, b(new g()));
        this.h.a(G, b(new b(this)));
        this.n = this.t.getRotation();
    }

    public final AnimatorSet a(c.c.a.b.l.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.t, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        gVar.d("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.t, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        gVar.d("scale").a(objectAnimatorOfFloat2);
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimatorOfFloat2.setEvaluator(new c.c.a.b.x.f(this));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.t, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        gVar.d("scale").a(objectAnimatorOfFloat3);
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimatorOfFloat3.setEvaluator(new c.c.a.b.x.f(this));
        }
        arrayList.add(objectAnimatorOfFloat3);
        this.y.reset();
        this.t.getDrawable();
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.t, new c.c.a.b.l.e(), new a(), new Matrix(this.y));
        gVar.d("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        q.N(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(A);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public abstract float c();

    public void d(Rect rect) {
        int sizeDimension = this.f1734c ? (0 - this.t.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.d ? c() + this.g : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r0 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public boolean e() {
        return this.t.getVisibility() == 0 ? this.p == 1 : this.p != 2;
    }

    public boolean f() {
        return this.t.getVisibility() != 0 ? this.p == 2 : this.p != 1;
    }

    public abstract void g();

    public abstract void h();

    public abstract void i(int[] iArr);

    public abstract void j(float f2, float f3, float f4);

    public void k() {
        ArrayList<InterfaceC0066e> arrayList = this.s;
        if (arrayList != null) {
            Iterator<InterfaceC0066e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l() {
        ArrayList<InterfaceC0066e> arrayList = this.s;
        if (arrayList != null) {
            Iterator<InterfaceC0066e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public abstract boolean m();

    public final void n(float f2) {
        this.o = f2;
        Matrix matrix = this.y;
        matrix.reset();
        this.t.getDrawable();
        this.t.setImageMatrix(matrix);
    }

    public abstract void o(ColorStateList colorStateList);

    public abstract boolean p();

    public final boolean q() {
        return l.E(this.t) && !this.t.isInEditMode();
    }

    public final boolean r() {
        return !this.f1734c || this.t.getSizeDimension() >= 0;
    }

    public abstract void s();

    public final void t() {
        Rect rect = this.v;
        d(rect);
        a.a.a.a.a.h(null, "Didn't initialize content background");
        if (p()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.u;
            if (bVar == null) {
                throw null;
            }
            super/*android.widget.ImageButton*/.setBackgroundDrawable(insetDrawable);
        } else if (((FloatingActionButton.b) this.u) == null) {
            throw null;
        }
        c.c.a.b.c0.b bVar2 = this.u;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        FloatingActionButton.b bVar3 = (FloatingActionButton.b) bVar2;
        FloatingActionButton.this.l.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i5 = floatingActionButton.j;
        floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
    }
}
