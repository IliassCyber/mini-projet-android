package com.app.damnvulnerablebank;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import b.b.k.h;
import c.a.b.p;
import c.a.b.q;
import c.a.b.u;
import c.a.b.w.d;
import c.a.b.w.g;
import c.b.a.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewBalance extends h {

    public class a implements q.b<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f1944a;

        public a(TextView textView) {
            this.f1944a = textView;
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(e.a(jSONObject.get("enc_data").toString()));
                if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
                    Toast.makeText(ViewBalance.this.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
                } else {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                    jSONObject3.getString("account_number");
                    String string = jSONObject3.getString("balance");
                    this.f1944a.setText("Your Balance is $" + string);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements q.a {
        public b(ViewBalance viewBalance) {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
        }
    }

    public class c extends g {
        public final /* synthetic */ String u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ViewBalance viewBalance, int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar, String str2) {
            super(i, str, null, bVar, aVar);
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

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_balanceview);
        TextView textView = (TextView) findViewById(R.id.textView);
        String string = getSharedPreferences("jwt", 0).getString("accesstoken", null);
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new c(this, 1, c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/balance/view"), null, new a(textView), new b(this), string));
        ((d) pVarZ.e).a();
    }
}
