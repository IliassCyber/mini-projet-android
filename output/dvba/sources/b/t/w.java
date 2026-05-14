package b.t;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class w extends b0 {
    public static boolean e = true;

    @Override // b.t.b0
    public void a(View view) {
    }

    @Override // b.t.b0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // b.t.b0
    public void c(View view) {
    }

    @Override // b.t.b0
    @SuppressLint({"NewApi"})
    public void e(View view, float f) {
        if (e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        view.setAlpha(f);
    }
}
