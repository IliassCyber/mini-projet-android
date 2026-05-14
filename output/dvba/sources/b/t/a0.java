package b.t;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends z {
    @Override // b.t.w, b.t.b0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // b.t.y, b.t.b0
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // b.t.w, b.t.b0
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // b.t.z, b.t.b0
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // b.t.x, b.t.b0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // b.t.x, b.t.b0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
