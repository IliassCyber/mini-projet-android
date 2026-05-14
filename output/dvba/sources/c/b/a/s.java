package c.b.a;

import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.ViewBeneficiary;

/* JADX INFO: loaded from: classes.dex */
public class s implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewBeneficiary f1272a;

    public s(ViewBeneficiary viewBeneficiary) {
        this.f1272a = viewBeneficiary;
    }

    @Override // c.a.b.q.a
    public void a(c.a.b.u uVar) {
        Toast.makeText(this.f1272a.getApplicationContext(), "Something went wrong", 0).show();
    }
}
