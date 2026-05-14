package b.l.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f932c;
    public final /* synthetic */ k d;

    public m(k kVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.d = kVar;
        this.f930a = viewGroup;
        this.f931b = view;
        this.f932c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f930a.endViewTransition(this.f931b);
        Animator animatorI = this.f932c.i();
        this.f932c.S(null);
        if (animatorI == null || this.f930a.indexOfChild(this.f931b) >= 0) {
            return;
        }
        k kVar = this.d;
        Fragment fragment = this.f932c;
        kVar.d0(fragment, fragment.s(), 0, 0, false);
    }
}
