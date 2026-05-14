package c.b.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.app.damnvulnerablebank.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends RecyclerView.g<C0051a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f1250c;
    public List<q> d;

    /* JADX INFO: renamed from: c.b.a.a$a, reason: collision with other inner class name */
    public class C0051a extends RecyclerView.d0 {
        public TextView t;
        public TextView u;
        public TextView v;

        public C0051a(a aVar, View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.fromacc);
            this.u = (TextView) view.findViewById(R.id.toacc);
            this.v = (TextView) view.findViewById(R.id.amount);
        }
    }

    public a(Context context, List<q> list) {
        this.f1250c = LayoutInflater.from(context);
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void c(RecyclerView.d0 d0Var, int i) {
        C0051a c0051a = (C0051a) d0Var;
        c0051a.t.setText(this.d.get(i).f1268a);
        c0051a.u.setText(this.d.get(i).f1269b);
        c0051a.v.setText(this.d.get(i).f1270c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 d(ViewGroup viewGroup, int i) {
        return new C0051a(this, this.f1250c.inflate(R.layout.custom_list, viewGroup, false));
    }
}
