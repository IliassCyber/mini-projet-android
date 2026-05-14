package c.c.a.b.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.u.f;
import com.google.android.material.datepicker.MaterialCalendarGridView;

/* JADX INFO: loaded from: classes.dex */
public class r extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.c.a.b.u.a f1714c;
    public final d<?> d;
    public final f.InterfaceC0065f e;
    public final int f;

    public static class a extends RecyclerView.d0 {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(c.c.a.b.f.month_title);
            this.t = textView;
            b.i.m.l.X(textView, true);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(c.c.a.b.f.month_grid);
            if (z) {
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public r(Context context, d<?> dVar, c.c.a.b.u.a aVar, f.InterfaceC0065f interfaceC0065f) {
        o oVar = aVar.f1682b;
        o oVar2 = aVar.f1683c;
        o oVar3 = aVar.d;
        if (oVar.compareTo(oVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (oVar3.compareTo(oVar2) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (f.Z(context) * p.f) + (n.c0(context) ? context.getResources().getDimensionPixelSize(c.c.a.b.d.mtrl_calendar_day_height) : 0);
        this.f1714c = aVar;
        this.d = dVar;
        this.e = interfaceC0065f;
        if (this.f189a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f190b = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f1714c.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long b(int i) {
        return this.f1714c.f1682b.h(i).f1708b.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void c(RecyclerView.d0 d0Var, int i) {
        a aVar = (a) d0Var;
        o oVarH = this.f1714c.f1682b.h(i);
        aVar.t.setText(oVarH.f1709c);
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.u.findViewById(c.c.a.b.f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !oVarH.equals(materialCalendarGridView.getAdapter().f1710b)) {
            p pVar = new p(oVarH, this.d, this.f1714c);
            materialCalendarGridView.setNumColumns(oVarH.f);
            materialCalendarGridView.setAdapter((ListAdapter) pVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new q(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 d(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(c.c.a.b.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!n.c0(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f));
        return new a(linearLayout, true);
    }

    public o e(int i) {
        return this.f1714c.f1682b.h(i);
    }

    public int f(o oVar) {
        return this.f1714c.f1682b.i(oVar);
    }
}
