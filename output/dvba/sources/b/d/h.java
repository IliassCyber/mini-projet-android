package b.d;

import b.d.e;
import com.app.damnvulnerablebank.SendMoney;

/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e.a f566b;

    public h(e.a aVar) {
        this.f566b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (((SendMoney.a) e.this.Y) == null) {
            throw null;
        }
    }
}
