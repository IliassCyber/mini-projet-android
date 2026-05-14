package b.r.d;

import android.view.View;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class w extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f1075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f1076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.t f1077c = new a();

    public class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1078a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0 && this.f1078a) {
                this.f1078a = false;
                w.this.c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f1078a = true;
        }
    }

    public abstract int[] a(RecyclerView.o oVar, View view);

    public abstract View b(RecyclerView.o oVar);

    public void c() {
        RecyclerView.o layoutManager;
        View viewB;
        RecyclerView recyclerView = this.f1075a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewB = b(layoutManager)) == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewB);
        if (iArrA[0] == 0 && iArrA[1] == 0) {
            return;
        }
        this.f1075a.smoothScrollBy(iArrA[0], iArrA[1]);
    }
}
