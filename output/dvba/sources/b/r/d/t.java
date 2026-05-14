package b.r.d;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f1072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1073b = RecyclerView.UNDEFINED_DURATION;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f1074c = new Rect();

    public t(RecyclerView.o oVar, r rVar) {
        this.f1072a = oVar;
    }

    public static t a(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return new r(oVar);
        }
        if (i == 1) {
            return new s(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.f1073b) {
            return 0;
        }
        return l() - this.f1073b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i);
}
