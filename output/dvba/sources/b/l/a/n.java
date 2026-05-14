package b.l.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f935c;

    public n(k kVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f933a = viewGroup;
        this.f934b = view;
        this.f935c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f933a.endViewTransition(this.f934b);
        animator.removeListener(this);
        Fragment fragment = this.f935c;
        View view = fragment.G;
        if (view == null || !fragment.z) {
            return;
        }
        view.setVisibility(8);
    }
}
