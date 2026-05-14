package b.g.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.g.b.i.d;

/* JADX INFO: loaded from: classes.dex */
public class i extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f691c;
    public int d;

    public void a() {
        d.a aVar = d.a.FIXED;
        if (this.f691c == null) {
            return;
        }
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar3 = (ConstraintLayout.a) this.f691c.getLayoutParams();
        aVar3.m0.X = 0;
        if (aVar2.m0.j() != aVar) {
            aVar2.m0.B(aVar3.m0.o());
        }
        if (aVar2.m0.n() != aVar) {
            aVar2.m0.w(aVar3.m0.i());
        }
        aVar3.m0.X = 8;
    }

    public View getContent() {
        return this.f691c;
    }

    public int getEmptyVisibility() {
        return this.d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (iHeight / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View viewFindViewById;
        if (this.f690b == i) {
            return;
        }
        View view = this.f691c;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f691c.getLayoutParams()).a0 = false;
            this.f691c = null;
        }
        this.f690b = i;
        if (i == -1 || (viewFindViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.d = i;
    }
}
