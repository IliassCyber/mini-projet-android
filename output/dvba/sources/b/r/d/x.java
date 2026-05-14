package b.r.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class x extends o {
    public final /* synthetic */ w q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, Context context) {
        super(context);
        this.q = wVar;
    }

    @Override // b.r.d.o, androidx.recyclerview.widget.RecyclerView.z
    public void c(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        w wVar = this.q;
        RecyclerView recyclerView = wVar.f1075a;
        if (recyclerView == null) {
            return;
        }
        int[] iArrA = wVar.a(recyclerView.getLayoutManager(), view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) g(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            aVar.b(i, i2, iCeil, this.j);
        }
    }

    @Override // b.r.d.o
    public float f(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }
}
