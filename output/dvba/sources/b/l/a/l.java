package b.l.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class l implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f928c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f927b.h() != null) {
                l.this.f927b.R(null);
                l lVar = l.this;
                k kVar = lVar.f928c;
                Fragment fragment = lVar.f927b;
                kVar.d0(fragment, fragment.s(), 0, 0, false);
            }
        }
    }

    public l(k kVar, ViewGroup viewGroup, Fragment fragment) {
        this.f928c = kVar;
        this.f926a = viewGroup;
        this.f927b = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f926a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
