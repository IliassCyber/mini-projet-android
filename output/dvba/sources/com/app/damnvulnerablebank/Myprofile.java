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
public class Myprofile extends h {

    public class a implements q.b<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f1935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f1936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f1937c;
        public final /* synthetic */ TextView d;

        public a(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
            this.f1935a = textView;
            this.f1936b = textView2;
            this.f1937c = textView3;
            this.d = textView4;
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            TextView textView;
            String str;
            try {
                JSONObject jSONObject2 = new JSONObject(e.a(jSONObject.get("enc_data").toString()));
                if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
                    Toast.makeText(Myprofile.this.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                String string = jSONObject3.getString("balance");
                String string2 = jSONObject3.getString("account_number");
                String string3 = jSONObject3.getString("username");
                String string4 = jSONObject3.getString("is_admin");
                this.f1935a.setText("Name:\t\t" + string3);
                this.f1936b.setText("Account Number:\t\t" + string2);
                this.f1937c.setText("Balance:\t\t$" + string);
                if (string4 == "true") {
                    textView = this.d;
                    str = "Admin:\t\tYes";
                } else {
                    textView = this.d;
                    str = "Admin:\t\tNo";
                }
                textView.setText(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements q.a {
        public b(Myprofile myprofile) {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
        }
    }

    public class c extends g {
        public final /* synthetic */ String u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Myprofile myprofile, int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar, String str2) {
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
        setContentView(R.layout.activity_myprofile);
        TextView textView = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        String string = getSharedPreferences("jwt", 0).getString("accesstoken", null);
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new c(this, 1, c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/user/profile"), null, new a(textView, textView2, textView3, textView4), new b(this), string));
        ((d) pVarZ.e).a();
    }
}
