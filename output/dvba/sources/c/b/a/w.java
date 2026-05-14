package c.b.a;

import c.a.b.q;
import com.app.damnvulnerablebank.ViewBeneficiaryAdmin;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class w extends c.a.b.w.g {
    public final /* synthetic */ ViewBeneficiaryAdmin u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ViewBeneficiaryAdmin viewBeneficiaryAdmin, int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar) {
        super(i, str, null, bVar, aVar);
        this.u = viewBeneficiaryAdmin;
    }

    @Override // c.a.b.o
    public Map g() {
        String string = this.u.getSharedPreferences("jwt", 0).getString("accesstoken", null);
        HashMap map = new HashMap();
        map.put("Authorization", "Bearer " + string);
        return map;
    }
}
