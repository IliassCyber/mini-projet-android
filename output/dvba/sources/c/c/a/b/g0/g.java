package c.c.a.b.g0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class g extends c.c.a.b.d0.g {
    public final Paint x;
    public final RectF y;
    public int z;

    public g() {
        this(null);
    }

    public g(c.c.a.b.d0.j jVar) {
        super(jVar == null ? new c.c.a.b.d0.j() : jVar);
        Paint paint = new Paint(1);
        this.x = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.x.setColor(-1);
        this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.y = new RectF();
    }

    @Override // c.c.a.b.d0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.z = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.y, this.x);
        if (getCallback() instanceof View) {
            return;
        }
        canvas.restoreToCount(this.z);
    }

    public void y(float f, float f2, float f3, float f4) {
        RectF rectF = this.y;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.y.set(f, f2, f3, f4);
        invalidateSelf();
    }
}
