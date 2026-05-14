package b.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1146a;

    static {
        f1146a = Build.VERSION.SDK_INT >= 28;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.View a(android.view.ViewGroup r13, android.view.View r14, android.view.View r15) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.t.p.a(android.view.ViewGroup, android.view.View, android.view.View):android.view.View");
    }

    public static Animator b(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
