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
public class b extends RecyclerView.g<C0052b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f1251c;
    public List<c> d;
    public a e;

    public interface a {
        void c(int i);
    }

    /* JADX INFO: renamed from: c.b.a.b$b, reason: collision with other inner class name */
    public class C0052b extends RecyclerView.d0 {
        public TextView t;
        public TextView u;

        /* JADX INFO: renamed from: c.b.a.b$b$a */
        public class a implements View.OnClickListener {
            public a(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iE;
                C0052b c0052b = C0052b.this;
                if (b.this.e == null || (iE = c0052b.e()) == -1) {
                    return;
                }
                b.this.e.c(iE);
            }
        }

        public C0052b(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.benif);
            this.u = (TextView) view.findViewById(R.id.isapproved);
            view.setOnClickListener(new a(b.this));
        }
    }

    public b(Context context, List<c> list) {
        this.f1251c = LayoutInflater.from(context);
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void c(RecyclerView.d0 d0Var, int i) {
        C0052b c0052b = (C0052b) d0Var;
        c0052b.t.setText(this.d.get(i).f1253a);
        c0052b.u.setText(this.d.get(i).f1254b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 d(ViewGroup viewGroup, int i) {
        return new C0052b(this.f1251c.inflate(R.layout.custom_benif, viewGroup, false));
    }
}
