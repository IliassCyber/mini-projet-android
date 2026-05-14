package b.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class c extends d0 {

    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1111a;

        public a(c cVar, View view) {
            this.f1111a = view;
        }

        @Override // b.t.i.d
        public void c(i iVar) {
            v.f1155a.e(this.f1111a, 1.0f);
            v.f1155a.a(this.f1111a);
            iVar.w(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1113b = false;

        public b(View view) {
            this.f1112a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.f1155a.e(this.f1112a, 1.0f);
            if (this.f1113b) {
                this.f1112a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (b.i.m.l.B(this.f1112a) && this.f1112a.getLayerType() == 0) {
                this.f1113b = true;
                this.f1112a.setLayerType(2, null);
            }
        }
    }

    public c(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.J = i;
    }

    @Override // b.t.d0
    public Animator K(ViewGroup viewGroup, View view, q qVar, q qVar2) {
        v.f1155a.c(view);
        Float f = (Float) qVar.f1147a.get("android:fade:transitionAlpha");
        return L(view, f != null ? f.floatValue() : 1.0f, 0.0f);
    }

    public final Animator L(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        v.f1155a.e(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, v.f1156b, f2);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(this, view));
        return objectAnimatorOfFloat;
    }

    @Override // b.t.i
    public void h(q qVar) {
        I(qVar);
        qVar.f1147a.put("android:fade:transitionAlpha", Float.valueOf(v.b(qVar.f1148b)));
    }
}
