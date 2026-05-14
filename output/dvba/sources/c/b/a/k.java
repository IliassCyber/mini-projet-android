package c.b.a;

import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.PendingBeneficiary;

/* JADX INFO: loaded from: classes.dex */
public class k implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PendingBeneficiary f1262a;

    public k(PendingBeneficiary pendingBeneficiary) {
        this.f1262a = pendingBeneficiary;
    }

    @Override // c.a.b.q.a
    public void a(c.a.b.u uVar) {
        Toast.makeText(this.f1262a.getApplicationContext(), "Something went wrong", 0).show();
    }
}
