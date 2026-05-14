package b.t;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Rect> {
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        return new Rect(rect3.left + ((int) ((rect4.left - r0) * f)), rect3.top + ((int) ((rect4.top - r1) * f)), rect3.right + ((int) ((rect4.right - r2) * f)), rect3.bottom + ((int) ((rect4.bottom - r6) * f)));
    }
}
