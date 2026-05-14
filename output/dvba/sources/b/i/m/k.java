package b.i.m;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver f834c;
    public final Runnable d;

    public k(View view, Runnable runnable) {
        this.f833b = view;
        this.f834c = view.getViewTreeObserver();
        this.d = runnable;
    }

    public static k a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        k kVar = new k(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(kVar);
        view.addOnAttachStateChangeListener(kVar);
        return kVar;
    }

    public void b() {
        (this.f834c.isAlive() ? this.f834c : this.f833b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f833b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f834c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
