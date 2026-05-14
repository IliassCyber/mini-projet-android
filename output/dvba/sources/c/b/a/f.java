package c.b.a;

import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.b.q;
import com.app.damnvulnerablebank.GetTransactions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements q.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetTransactions f1257a;

    public f(GetTransactions getTransactions) {
        this.f1257a = getTransactions;
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
            Toast.makeText(this.f1257a.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
            return;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            q qVar = new q();
            qVar.f1268a = "From Account Number\t\t:" + jSONObject3.getString("from_account").toString();
            qVar.f1269b = "To    Account Number\t\t:" + jSONObject3.getString("to_account").toString();
            qVar.f1270c = "Amount Sent\t\t:$" + jSONObject3.getString("amount").toString();
            this.f1257a.q.add(qVar);
        }
        GetTransactions getTransactions = this.f1257a;
        getTransactions.p.setLayoutManager(new LinearLayoutManager(getTransactions.getApplicationContext()));
        GetTransactions getTransactions2 = this.f1257a;
        getTransactions2.s = new a(getTransactions2.getApplicationContext(), this.f1257a.q);
        GetTransactions getTransactions3 = this.f1257a;
        getTransactions3.p.setAdapter(getTransactions3.s);
        if (Integer.valueOf(this.f1257a.s.a()).intValue() == 0) {
            this.f1257a.p.setVisibility(8);
            this.f1257a.r.setVisibility(0);
        } else {
            this.f1257a.p.setVisibility(0);
            this.f1257a.r.setVisibility(8);
        }
    }
}
