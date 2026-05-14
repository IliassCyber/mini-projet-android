package c.b.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.app.damnvulnerablebank.ApproveBeneficiary;
import com.app.damnvulnerablebank.PendingBeneficiary;
import com.app.damnvulnerablebank.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f1259c;
    public List<m> d;
    public a e;

    public interface a {
    }

    public class b extends RecyclerView.d0 {
        public TextView t;
        public TextView u;
        public TextView v;

        public class a implements View.OnClickListener {
            public a(i iVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iE;
                b bVar = b.this;
                if (i.this.e == null || (iE = bVar.e()) == -1) {
                    return;
                }
                PendingBeneficiary pendingBeneficiary = (PendingBeneficiary) i.this.e;
                if (pendingBeneficiary == null) {
                    throw null;
                }
                Intent intent = new Intent(pendingBeneficiary, (Class<?>) ApproveBeneficiary.class);
                intent.putExtra("id", pendingBeneficiary.q.get(iE).f1265c);
                pendingBeneficiary.startActivity(intent);
            }
        }

        public b(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.accno);
            this.u = (TextView) view.findViewById(R.id.beacc);
            this.v = (TextView) view.findViewById(R.id.idn);
            view.setOnClickListener(new a(i.this));
        }
    }

    public i(Context context, List<m> list) {
        this.f1259c = LayoutInflater.from(context);
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void c(RecyclerView.d0 d0Var, int i) {
        b bVar = (b) d0Var;
        bVar.t.setText(this.d.get(i).f1263a);
        bVar.u.setText(this.d.get(i).f1264b);
        bVar.v.setText(this.d.get(i).f1265c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 d(ViewGroup viewGroup, int i) {
        return new b(this.f1259c.inflate(R.layout.custom_pend, viewGroup, false));
    }
}
