package b.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f414a;
    public v0 d;
    public v0 e;
    public v0 f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f416c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f415b = j.a();

    public e(View view) {
        this.f414a = view;
    }

    public void a() {
        Drawable background = this.f414a.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 ? i == 21 : this.d != null) {
                if (this.f == null) {
                    this.f = new v0();
                }
                v0 v0Var = this.f;
                v0Var.f489a = null;
                v0Var.d = false;
                v0Var.f490b = null;
                v0Var.f491c = false;
                ColorStateList colorStateListJ = b.i.m.l.j(this.f414a);
                if (colorStateListJ != null) {
                    v0Var.d = true;
                    v0Var.f489a = colorStateListJ;
                }
                PorterDuff.Mode backgroundTintMode = this.f414a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    v0Var.f491c = true;
                    v0Var.f490b = backgroundTintMode;
                }
                if (v0Var.d || v0Var.f491c) {
                    j.f(background, v0Var, this.f414a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            v0 v0Var2 = this.e;
            if (v0Var2 != null) {
                j.f(background, v0Var2, this.f414a.getDrawableState());
                return;
            }
            v0 v0Var3 = this.d;
            if (v0Var3 != null) {
                j.f(background, v0Var3, this.f414a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        v0 v0Var = this.e;
        if (v0Var != null) {
            return v0Var.f489a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        v0 v0Var = this.e;
        if (v0Var != null) {
            return v0Var.f490b;
        }
        return null;
    }

    public void d(AttributeSet attributeSet, int i) {
        x0 x0VarQ = x0.q(this.f414a.getContext(), attributeSet, b.b.j.ViewBackgroundHelper, i, 0);
        View view = this.f414a;
        b.i.m.l.V(view, view.getContext(), b.b.j.ViewBackgroundHelper, attributeSet, x0VarQ.f507b, i, 0);
        try {
            if (x0VarQ.o(b.b.j.ViewBackgroundHelper_android_background)) {
                this.f416c = x0VarQ.l(b.b.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListD = this.f415b.d(this.f414a.getContext(), this.f416c);
                if (colorStateListD != null) {
                    g(colorStateListD);
                }
            }
            if (x0VarQ.o(b.b.j.ViewBackgroundHelper_backgroundTint)) {
                View view2 = this.f414a;
                view2.setBackgroundTintList(x0VarQ.c(b.b.j.ViewBackgroundHelper_backgroundTint));
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view2.getBackground();
                    boolean z = (view2.getBackgroundTintList() == null && view2.getBackgroundTintMode() == null) ? false : true;
                    if (background != null && z) {
                        if (background.isStateful()) {
                            background.setState(view2.getDrawableState());
                        }
                        view2.setBackground(background);
                    }
                }
            }
            if (x0VarQ.o(b.b.j.ViewBackgroundHelper_backgroundTintMode)) {
                View view3 = this.f414a;
                view3.setBackgroundTintMode(e0.c(x0VarQ.j(b.b.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background2 = view3.getBackground();
                    boolean z2 = (view3.getBackgroundTintList() == null && view3.getBackgroundTintMode() == null) ? false : true;
                    if (background2 != null && z2) {
                        if (background2.isStateful()) {
                            background2.setState(view3.getDrawableState());
                        }
                        view3.setBackground(background2);
                    }
                }
            }
            x0VarQ.f507b.recycle();
        } catch (Throwable th) {
            x0VarQ.f507b.recycle();
            throw th;
        }
    }

    public void e() {
        this.f416c = -1;
        g(null);
        a();
    }

    public void f(int i) {
        this.f416c = i;
        j jVar = this.f415b;
        g(jVar != null ? jVar.d(this.f414a.getContext(), i) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new v0();
            }
            v0 v0Var = this.d;
            v0Var.f489a = colorStateList;
            v0Var.d = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new v0();
        }
        v0 v0Var = this.e;
        v0Var.f489a = colorStateList;
        v0Var.d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new v0();
        }
        v0 v0Var = this.e;
        v0Var.f490b = mode;
        v0Var.f491c = true;
        a();
    }
}
