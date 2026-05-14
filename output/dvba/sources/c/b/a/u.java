package c.b.a;

import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.b.q;
import com.app.damnvulnerablebank.ViewBeneficiaryAdmin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class u implements q.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewBeneficiaryAdmin f1273a;

    public u(ViewBeneficiaryAdmin viewBeneficiaryAdmin) {
        this.f1273a = viewBeneficiaryAdmin;
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
            Toast.makeText(this.f1273a.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            c cVar = new c();
            if (jSONObject3.getString("approved").toString() != "false") {
                cVar.a(jSONObject3.getString("beneficiary_account_number").toString());
                this.f1273a.q.add(cVar);
            }
        }
        ViewBeneficiaryAdmin viewBeneficiaryAdmin = this.f1273a;
        viewBeneficiaryAdmin.p.setLayoutManager(new LinearLayoutManager(viewBeneficiaryAdmin.getApplicationContext()));
        ViewBeneficiaryAdmin viewBeneficiaryAdmin2 = this.f1273a;
        viewBeneficiaryAdmin2.s = new b(viewBeneficiaryAdmin2.getApplicationContext(), this.f1273a.q);
        ViewBeneficiaryAdmin viewBeneficiaryAdmin3 = this.f1273a;
        viewBeneficiaryAdmin3.p.setAdapter(viewBeneficiaryAdmin3.s);
        if (Integer.valueOf(this.f1273a.s.a()).intValue() == 0) {
            this.f1273a.p.setVisibility(8);
            this.f1273a.r.setVisibility(0);
        } else {
            this.f1273a.p.setVisibility(0);
            this.f1273a.r.setVisibility(8);
        }
        ViewBeneficiaryAdmin viewBeneficiaryAdmin4 = this.f1273a;
        viewBeneficiaryAdmin4.s.e = viewBeneficiaryAdmin4;
    }
}
