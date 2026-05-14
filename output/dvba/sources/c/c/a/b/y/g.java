package c.c.a.b.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f1748a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f1749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f1750c = null;
    public final Animator.AnimatorListener d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            if (gVar.f1750c == animator) {
                gVar.f1750c = null;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f1753b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f1752a = iArr;
            this.f1753b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f1748a.add(bVar);
    }
}
