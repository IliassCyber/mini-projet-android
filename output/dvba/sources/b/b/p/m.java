package b.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0 f459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0 f460c;

    public m(ImageView imageView) {
        this.f458a = imageView;
    }

    public void a() {
        Drawable drawable = this.f458a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 && i == 21) {
                if (this.f460c == null) {
                    this.f460c = new v0();
                }
                v0 v0Var = this.f460c;
                v0Var.f489a = null;
                v0Var.d = false;
                v0Var.f490b = null;
                v0Var.f491c = false;
                ColorStateList imageTintList = this.f458a.getImageTintList();
                if (imageTintList != null) {
                    v0Var.d = true;
                    v0Var.f489a = imageTintList;
                }
                PorterDuff.Mode imageTintMode = this.f458a.getImageTintMode();
                if (imageTintMode != null) {
                    v0Var.f491c = true;
                    v0Var.f490b = imageTintMode;
                }
                if (v0Var.d || v0Var.f491c) {
                    j.f(drawable, v0Var, this.f458a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            v0 v0Var2 = this.f459b;
            if (v0Var2 != null) {
                j.f(drawable, v0Var2, this.f458a.getDrawableState());
            }
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable drawable2;
        int iL;
        x0 x0VarQ = x0.q(this.f458a.getContext(), attributeSet, b.b.j.AppCompatImageView, i, 0);
        ImageView imageView = this.f458a;
        b.i.m.l.V(imageView, imageView.getContext(), b.b.j.AppCompatImageView, attributeSet, x0VarQ.f507b, i, 0);
        try {
            Drawable drawable3 = this.f458a.getDrawable();
            if (drawable3 == null && (iL = x0VarQ.l(b.b.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable3 = b.b.l.a.a.b(this.f458a.getContext(), iL)) != null) {
                this.f458a.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                e0.b(drawable3);
            }
            if (x0VarQ.o(b.b.j.AppCompatImageView_tint)) {
                ImageView imageView2 = this.f458a;
                imageView2.setImageTintList(x0VarQ.c(b.b.j.AppCompatImageView_tint));
                if (Build.VERSION.SDK_INT == 21 && (drawable2 = imageView2.getDrawable()) != null && imageView2.getImageTintList() != null) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView2.getDrawableState());
                    }
                    imageView2.setImageDrawable(drawable2);
                }
            }
            if (x0VarQ.o(b.b.j.AppCompatImageView_tintMode)) {
                ImageView imageView3 = this.f458a;
                imageView3.setImageTintMode(e0.c(x0VarQ.j(b.b.j.AppCompatImageView_tintMode, -1), null));
                if (Build.VERSION.SDK_INT == 21 && (drawable = imageView3.getDrawable()) != null && imageView3.getImageTintList() != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView3.getDrawableState());
                    }
                    imageView3.setImageDrawable(drawable);
                }
            }
            x0VarQ.f507b.recycle();
        } catch (Throwable th) {
            x0VarQ.f507b.recycle();
            throw th;
        }
    }

    public void c(int i) {
        if (i != 0) {
            Drawable drawableB = b.b.l.a.a.b(this.f458a.getContext(), i);
            if (drawableB != null) {
                e0.b(drawableB);
            }
            this.f458a.setImageDrawable(drawableB);
        } else {
            this.f458a.setImageDrawable(null);
        }
        a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.f459b == null) {
            this.f459b = new v0();
        }
        v0 v0Var = this.f459b;
        v0Var.f489a = colorStateList;
        v0Var.d = true;
        a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.f459b == null) {
            this.f459b = new v0();
        }
        v0 v0Var = this.f459b;
        v0Var.f490b = mode;
        v0Var.f491c = true;
        a();
    }
}
