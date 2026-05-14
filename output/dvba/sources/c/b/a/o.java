package c.b.a;

import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.SendMoney;

/* JADX INFO: loaded from: classes.dex */
public class o implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendMoney f1267a;

    public o(SendMoney sendMoney) {
        this.f1267a = sendMoney;
    }

    @Override // c.a.b.q.a
    public void a(c.a.b.u uVar) {
        Toast.makeText(this.f1267a.getApplicationContext(), "Something went wrong", 0).show();
    }
}
