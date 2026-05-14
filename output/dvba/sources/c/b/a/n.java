package c.b.a;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import c.a.b.q;
import com.app.damnvulnerablebank.Dashboard;
import com.app.damnvulnerablebank.SendMoney;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n implements q.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendMoney f1266a;

    public n(SendMoney sendMoney) {
        this.f1266a = sendMoney;
    }

    @Override // c.a.b.q.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        try {
            jSONObject2 = new JSONObject(e.a(jSONObject3.get("enc_data").toString()));
            Log.d("Send Money", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
            Toast.makeText(this.f1266a.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
            return;
        }
        Toast.makeText(this.f1266a.getApplicationContext(), "" + e.a(jSONObject3.get("enc_data").toString()), 0).show();
        this.f1266a.startActivity(new Intent(this.f1266a, (Class<?>) Dashboard.class));
    }
}
