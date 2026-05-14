package c.b.a;

import android.util.Log;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.b.q;
import com.app.damnvulnerablebank.PendingBeneficiary;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements q.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PendingBeneficiary f1261a;

    public j(PendingBeneficiary pendingBeneficiary) {
        this.f1261a = pendingBeneficiary;
    }

    @Override // c.a.b.q.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(e.a(jSONObject.get("enc_data").toString()));
            Log.d("Pending Beneficiary", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
            Toast.makeText(this.f1261a.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            m mVar = new m();
            mVar.f1263a = "Account Number\t\t:" + jSONObject3.getString("account_number").toString();
            mVar.f1264b = "Benificiary Account Number\t\t:" + jSONObject3.getString("beneficiary_account_number").toString() + "\n";
            mVar.f1265c = "ID\t\t:" + jSONObject3.getString("id").toString();
            this.f1261a.q.add(mVar);
        }
        PendingBeneficiary pendingBeneficiary = this.f1261a;
        pendingBeneficiary.p.setLayoutManager(new LinearLayoutManager(pendingBeneficiary.getApplicationContext()));
        PendingBeneficiary pendingBeneficiary2 = this.f1261a;
        pendingBeneficiary2.s = new i(pendingBeneficiary2.getApplicationContext(), this.f1261a.q);
        PendingBeneficiary pendingBeneficiary3 = this.f1261a;
        pendingBeneficiary3.p.setAdapter(pendingBeneficiary3.s);
        PendingBeneficiary pendingBeneficiary4 = this.f1261a;
        i iVar = pendingBeneficiary4.s;
        iVar.e = pendingBeneficiary4;
        if (Integer.valueOf(iVar.a()).intValue() == 0) {
            this.f1261a.p.setVisibility(8);
            this.f1261a.r.setVisibility(0);
        } else {
            this.f1261a.p.setVisibility(0);
            this.f1261a.r.setVisibility(8);
        }
    }
}
