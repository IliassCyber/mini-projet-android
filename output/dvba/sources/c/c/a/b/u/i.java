package c.c.a.b.u;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public class i extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f1700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f1701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1702c;

    public i(f fVar, r rVar, MaterialButton materialButton) {
        this.f1702c = fVar;
        this.f1700a = rVar;
        this.f1701b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f1701b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager linearLayoutManagerA0 = this.f1702c.a0();
        int iI1 = i < 0 ? linearLayoutManagerA0.i1() : linearLayoutManagerA0.k1();
        this.f1702c.a0 = this.f1700a.e(iI1);
        this.f1701b.setText(this.f1700a.f1714c.f1682b.h(iI1).f1709c);
    }
}
