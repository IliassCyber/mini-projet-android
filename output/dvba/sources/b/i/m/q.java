package b.i.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f847b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f848c = null;
    public int d = -1;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f850b;

        public a(q qVar, r rVar, View view) {
            this.f849a = rVar;
            this.f850b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f849a.c(this.f850b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f849a.a(this.f850b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f849a.b(this.f850b);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f852b;

        public b(q qVar, t tVar, View view) {
            this.f851a = tVar;
            this.f852b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) b.b.k.u.this.d.getParent()).invalidate();
        }
    }

    public q(View view) {
        this.f846a = new WeakReference<>(view);
    }

    public q a(float f) {
        View view = this.f846a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f846a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public q c(long j) {
        View view = this.f846a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public q d(r rVar) {
        View view = this.f846a.get();
        if (view != null) {
            e(view, rVar);
        }
        return this;
    }

    public final void e(View view, r rVar) {
        if (rVar != null) {
            view.animate().setListener(new a(this, rVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public q f(t tVar) {
        View view = this.f846a.get();
        if (view != null) {
            view.animate().setUpdateListener(tVar != null ? new b(this, tVar, view) : null);
        }
        return this;
    }

    public q g(float f) {
        View view = this.f846a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
