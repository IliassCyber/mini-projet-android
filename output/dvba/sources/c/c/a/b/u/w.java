package c.c.a.b.u;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class w extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f<?> f1717c;

    public static class a extends RecyclerView.d0 {
        public final TextView t;

        public a(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    public w(f<?> fVar) {
        this.f1717c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f1717c.Z.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void c(RecyclerView.d0 d0Var, int i) {
        a aVar = (a) d0Var;
        int i2 = this.f1717c.Z.f1682b.e + i;
        String string = aVar.t.getContext().getString(c.c.a.b.i.mtrl_picker_navigate_to_year_description);
        aVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        aVar.t.setContentDescription(String.format(string, Integer.valueOf(i2)));
        c cVar = this.f1717c.c0;
        Calendar calendarE = c.c.a.a.c.l.q.E();
        b bVar = calendarE.get(1) == i2 ? cVar.f : cVar.d;
        Iterator<Long> it = this.f1717c.Y.e().iterator();
        while (it.hasNext()) {
            calendarE.setTimeInMillis(it.next().longValue());
            if (calendarE.get(1) == i2) {
                bVar = cVar.e;
            }
        }
        bVar.b(aVar.t);
        aVar.t.setOnClickListener(new v(this, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 d(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(c.c.a.b.h.mtrl_calendar_year, viewGroup, false));
    }

    public int e(int i) {
        return i - this.f1717c.Z.f1682b.e;
    }
}
