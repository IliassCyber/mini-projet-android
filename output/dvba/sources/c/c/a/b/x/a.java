package c.c.a.b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton.c f1723c = null;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, i iVar) {
        this.f1722b = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1721a = true;
        this.f1722b.e();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1722b.d();
        if (this.f1721a) {
            return;
        }
        this.f1722b.a(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1722b.onAnimationStart(animator);
        this.f1721a = false;
    }
}
