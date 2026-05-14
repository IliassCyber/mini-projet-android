package b.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.k;

/* JADX INFO: loaded from: classes.dex */
public class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f1040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1042c;
    public final /* synthetic */ k d;

    public i(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1040a = aVar;
        this.f1041b = viewPropertyAnimator;
        this.f1042c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1041b.setListener(null);
        this.f1042c.setAlpha(1.0f);
        this.f1042c.setTranslationX(0.0f);
        this.f1042c.setTranslationY(0.0f);
        this.d.d(this.f1040a.f1046a);
        this.d.r.remove(this.f1040a.f1046a);
        this.d.l();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        k kVar = this.d;
        RecyclerView.d0 d0Var = this.f1040a.f1046a;
        if (kVar == null) {
            throw null;
        }
    }
}
