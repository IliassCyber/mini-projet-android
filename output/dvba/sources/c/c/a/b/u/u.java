package c.c.a.b.u;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class u extends LinearLayoutManager {

    public class a extends b.r.d.o {
        public a(u uVar, Context context) {
            super(context);
        }

        @Override // b.r.d.o
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public u(Context context, int i, boolean z) {
        super(i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.f217a = i;
        V0(aVar);
    }
}
