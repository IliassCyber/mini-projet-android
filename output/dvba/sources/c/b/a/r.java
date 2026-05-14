package c.b.a;

import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.b.q;
import com.app.damnvulnerablebank.ViewBeneficiary;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r implements q.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewBeneficiary f1271a;

    public r(ViewBeneficiary viewBeneficiary) {
        this.f1271a = viewBeneficiary;
    }

    @Override // c.a.b.q.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(e.a(jSONObject.get("enc_data").toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
            Toast.makeText(this.f1271a.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            c cVar = new c();
            cVar.a(jSONObject3.getString("beneficiary_account_number").toString());
            cVar.f1254b = "\n\nAccount Approved By Admin\n" + jSONObject3.getString("approved").toString();
            this.f1271a.q.add(cVar);
        }
        ViewBeneficiary viewBeneficiary = this.f1271a;
        viewBeneficiary.p.setLayoutManager(new LinearLayoutManager(viewBeneficiary.getApplicationContext()));
        ViewBeneficiary viewBeneficiary2 = this.f1271a;
        viewBeneficiary2.r = new b(viewBeneficiary2.getApplicationContext(), this.f1271a.q);
        ViewBeneficiary viewBeneficiary3 = this.f1271a;
        viewBeneficiary3.p.setAdapter(viewBeneficiary3.r);
        if (Integer.valueOf(this.f1271a.r.a()).intValue() == 0) {
            this.f1271a.p.setVisibility(8);
            this.f1271a.s.setVisibility(0);
        } else {
            this.f1271a.p.setVisibility(0);
            this.f1271a.s.setVisibility(8);
        }
        ViewBeneficiary viewBeneficiary4 = this.f1271a;
        viewBeneficiary4.r.e = viewBeneficiary4;
    }
}
