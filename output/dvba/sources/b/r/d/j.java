package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.k;

/* JADX INFO: loaded from: classes.dex */
public class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f1043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1045c;
    public final /* synthetic */ k d;

    public j(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1043a = aVar;
        this.f1044b = viewPropertyAnimator;
        this.f1045c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1044b.setListener(null);
        this.f1045c.setAlpha(1.0f);
        this.f1045c.setTranslationX(0.0f);
        this.f1045c.setTranslationY(0.0f);
        this.d.d(this.f1043a.f1047b);
        this.d.r.remove(this.f1043a.f1047b);
        this.d.l();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        k kVar = this.d;
        RecyclerView.d0 d0Var = this.f1043a.f1047b;
        if (kVar == null) {
            throw null;
        }
    }
}
