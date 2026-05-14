package b.b.p;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
public class u extends q {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = seekBar;
    }

    @Override // b.b.p.q
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        x0 x0VarQ = x0.q(this.d.getContext(), attributeSet, b.b.j.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.d;
        b.i.m.l.V(seekBar, seekBar.getContext(), b.b.j.AppCompatSeekBar, attributeSet, x0VarQ.f507b, i, 0);
        Drawable drawableH = x0VarQ.h(b.b.j.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.d.setThumb(drawableH);
        }
        Drawable drawableG = x0VarQ.g(b.b.j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this.d);
            a.a.a.a.a.o0(drawableG, b.i.m.l.r(this.d));
            if (drawableG.isStateful()) {
                drawableG.setState(this.d.getDrawableState());
            }
            c();
        }
        this.d.invalidate();
        if (x0VarQ.o(b.b.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = e0.c(x0VarQ.j(b.b.j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (x0VarQ.o(b.b.j.AppCompatSeekBar_tickMarkTint)) {
            this.f = x0VarQ.c(b.b.j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        x0VarQ.f507b.recycle();
        c();
    }

    public final void c() {
        if (this.e != null) {
            if (this.h || this.i) {
                Drawable drawableC0 = a.a.a.a.a.C0(this.e.mutate());
                this.e = drawableC0;
                if (this.h) {
                    drawableC0.setTintList(this.f);
                }
                if (this.i) {
                    this.e.setTintMode(this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
