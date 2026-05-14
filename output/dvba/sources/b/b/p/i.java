package b.b.p;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompoundButton f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f434b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f435c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public i(CompoundButton compoundButton) {
        this.f433a = compoundButton;
    }

    public void a() {
        Drawable drawableA = a.a.a.a.a.A(this.f433a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = a.a.a.a.a.C0(drawableA).mutate();
                if (this.d) {
                    drawableMutate.setTintList(this.f434b);
                }
                if (this.e) {
                    drawableMutate.setTintMode(this.f435c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f433a.getDrawableState());
                }
                this.f433a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        boolean z;
        int iL;
        int iL2;
        x0 x0VarQ = x0.q(this.f433a.getContext(), attributeSet, b.b.j.CompoundButton, i, 0);
        CompoundButton compoundButton = this.f433a;
        b.i.m.l.V(compoundButton, compoundButton.getContext(), b.b.j.CompoundButton, attributeSet, x0VarQ.f507b, i, 0);
        try {
            if (!x0VarQ.o(b.b.j.CompoundButton_buttonCompat) || (iL2 = x0VarQ.l(b.b.j.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.f433a.setButtonDrawable(b.b.l.a.a.b(this.f433a.getContext(), iL2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z && x0VarQ.o(b.b.j.CompoundButton_android_button) && (iL = x0VarQ.l(b.b.j.CompoundButton_android_button, 0)) != 0) {
                this.f433a.setButtonDrawable(b.b.l.a.a.b(this.f433a.getContext(), iL));
            }
            if (x0VarQ.o(b.b.j.CompoundButton_buttonTint)) {
                this.f433a.setButtonTintList(x0VarQ.c(b.b.j.CompoundButton_buttonTint));
            }
            if (x0VarQ.o(b.b.j.CompoundButton_buttonTintMode)) {
                this.f433a.setButtonTintMode(e0.c(x0VarQ.j(b.b.j.CompoundButton_buttonTintMode, -1), null));
            }
            x0VarQ.f507b.recycle();
        } catch (Throwable th) {
            x0VarQ.f507b.recycle();
            throw th;
        }
    }
}
