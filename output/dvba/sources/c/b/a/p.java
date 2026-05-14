package c.b.a;

import c.a.b.q;
import com.app.damnvulnerablebank.SendMoney;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p extends c.a.b.w.g {
    public final /* synthetic */ String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(SendMoney sendMoney, int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar, String str2) {
        super(i, str, jSONObject, bVar, aVar);
        this.u = str2;
    }

    @Override // c.a.b.o
    public Map g() {
        HashMap map = new HashMap();
        StringBuilder sbE = c.a.a.a.a.e("Bearer ");
        sbE.append(this.u);
        map.put("Authorization", sbE.toString());
        return map;
    }
}
