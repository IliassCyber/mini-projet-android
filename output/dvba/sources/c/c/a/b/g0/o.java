package c.c.a.b.g0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f1615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f1616c;
    public int d;
    public FrameLayout e;
    public int f;
    public Animator g;
    public final float h;
    public int i;
    public int j;
    public CharSequence k;
    public boolean l;
    public TextView m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f1618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f1619c;
        public final /* synthetic */ TextView d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f1617a = i;
            this.f1618b = textView;
            this.f1619c = i2;
            this.d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            o oVar = o.this;
            oVar.i = this.f1617a;
            oVar.g = null;
            TextView textView2 = this.f1618b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f1619c == 1 && (textView = o.this.m) != null) {
                    textView.setText((CharSequence) null);
                }
                TextView textView3 = this.d;
                if (textView3 != null) {
                    textView3.setTranslationY(0.0f);
                    this.d.setAlpha(1.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public o(TextInputLayout textInputLayout) {
        this.f1614a = textInputLayout.getContext();
        this.f1615b = textInputLayout;
        this.h = r0.getResources().getDimensionPixelSize(c.c.a.b.d.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i) {
        if (this.f1616c == null && this.e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f1614a);
            this.f1616c = linearLayout;
            linearLayout.setOrientation(0);
            this.f1615b.addView(this.f1616c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.f1614a);
            this.e = frameLayout;
            this.f1616c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f1616c.addView(new Space(this.f1614a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f1615b.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.f1616c.addView(textView, i);
        }
        this.f1616c.setVisibility(0);
        this.d++;
    }

    public void b() {
        if ((this.f1616c == null || this.f1615b.getEditText() == null) ? false : true) {
            this.f1616c.setPaddingRelative(b.i.m.l.v(this.f1615b.getEditText()), 0, this.f1615b.getEditText().getPaddingEnd(), 0);
        }
    }

    public void c() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, i3 == i ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(c.c.a.b.l.a.f1627a);
            list.add(objectAnimatorOfFloat);
            if (i3 == i) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(c.c.a.b.l.a.d);
                list.add(objectAnimatorOfFloat2);
            }
        }
    }

    public boolean e() {
        return (this.j != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    public final TextView f(int i) {
        if (i == 1) {
            return this.m;
        }
        if (i != 2) {
            return null;
        }
        return this.r;
    }

    public int g() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void h() {
        this.k = null;
        c();
        if (this.i == 1) {
            this.j = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        k(this.i, this.j, j(this.m, null));
    }

    public void i(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f1616c == null) {
            return;
        }
        if (!(i == 0 || i == 1) || (frameLayout = this.e) == null) {
            this.f1616c.removeView(textView);
        } else {
            int i2 = this.f - 1;
            this.f = i2;
            if (i2 == 0) {
                frameLayout.setVisibility(8);
            }
            this.e.removeView(textView);
        }
        int i3 = this.d - 1;
        this.d = i3;
        LinearLayout linearLayout = this.f1616c;
        if (i3 == 0) {
            linearLayout.setVisibility(8);
        }
    }

    public final boolean j(TextView textView, CharSequence charSequence) {
        return b.i.m.l.E(this.f1615b) && this.f1615b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void k(int i, int i2, boolean z) {
        TextView textViewF;
        TextView textViewF2;
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.q, this.r, 2, i, i2);
            d(arrayList, this.l, this.m, 1, i, i2);
            c.c.a.a.c.l.q.N(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, f(i), i, f(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (textViewF2 = f(i2)) != null) {
                textViewF2.setVisibility(0);
                textViewF2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewF = f(i)) != null) {
                textViewF.setVisibility(4);
                if (i == 1) {
                    textViewF.setText((CharSequence) null);
                }
            }
            this.i = i2;
        }
        this.f1615b.s();
        this.f1615b.v(z, false);
        this.f1615b.w();
    }
}
