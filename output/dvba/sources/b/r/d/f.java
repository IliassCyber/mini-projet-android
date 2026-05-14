package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.d0 f1031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1033c;
    public final /* synthetic */ k d;

    public f(k kVar, RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1031a = d0Var;
        this.f1032b = viewPropertyAnimator;
        this.f1033c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1032b.setListener(null);
        this.f1033c.setAlpha(1.0f);
        this.d.d(this.f1031a);
        this.d.q.remove(this.f1031a);
        this.d.l();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.d == null) {
            throw null;
        }
    }
}
