package c.c.a.b.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f1666a;

    public e(BottomAppBar bottomAppBar) {
        this.f1666a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1666a.W.onAnimationStart(animator);
        FloatingActionButton floatingActionButtonB = this.f1666a.B();
        if (floatingActionButtonB != null) {
            floatingActionButtonB.setTranslationX(this.f1666a.getFabTranslationX());
        }
    }
}
