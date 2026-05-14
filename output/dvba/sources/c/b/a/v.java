package c.b.a;

import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.ViewBeneficiaryAdmin;

/* JADX INFO: loaded from: classes.dex */
public class v implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewBeneficiaryAdmin f1274a;

    public v(ViewBeneficiaryAdmin viewBeneficiaryAdmin) {
        this.f1274a = viewBeneficiaryAdmin;
    }

    @Override // c.a.b.q.a
    public void a(c.a.b.u uVar) {
        Toast.makeText(this.f1274a.getApplicationContext(), "Something went wrong", 0).show();
    }
}
