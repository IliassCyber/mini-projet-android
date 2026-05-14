package c.b.a;

import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.GetTransactions;

/* JADX INFO: loaded from: classes.dex */
public class g implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetTransactions f1258a;

    public g(GetTransactions getTransactions) {
        this.f1258a = getTransactions;
    }

    @Override // c.a.b.q.a
    public void a(c.a.b.u uVar) {
        Toast.makeText(this.f1258a.getApplicationContext(), "Something went wrong", 0).show();
    }
}
