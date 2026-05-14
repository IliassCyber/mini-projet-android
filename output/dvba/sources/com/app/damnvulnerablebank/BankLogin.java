package com.app.damnvulnerablebank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import b.b.k.h;
import c.a.b.p;
import c.a.b.q;
import c.a.b.u;
import c.a.b.w.g;
import c.b.a.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BankLogin extends h {
    public ProgressBar p;
    public RelativeLayout q;

    public class a implements q.b<JSONObject> {
        public a() {
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            BankLogin bankLogin;
            Intent intent;
            try {
                JSONObject jSONObject2 = new JSONObject(e.a(jSONObject.get("enc_data").toString()));
                if (jSONObject2.getJSONObject("status").getInt("code") != 200) {
                    Toast.makeText(BankLogin.this.getApplicationContext(), "Error: " + jSONObject2.getJSONObject("data").getString("message"), 0).show();
                    bankLogin = BankLogin.this;
                    intent = new Intent(BankLogin.this, (Class<?>) BankLogin.class);
                } else {
                    String string = jSONObject2.getJSONObject("data").getString("accessToken");
                    SharedPreferences sharedPreferences = BankLogin.this.getSharedPreferences("jwt", 0);
                    Log.d("accesstoken", string);
                    sharedPreferences.edit().putString("accesstoken", string).apply();
                    sharedPreferences.edit().putBoolean("isloggedin", true).apply();
                    bankLogin = BankLogin.this;
                    intent = new Intent(BankLogin.this, (Class<?>) Dashboard.class);
                }
                bankLogin.startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements q.a {
        public b() {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
            Toast.makeText(BankLogin.this.getApplicationContext(), "Something went wrong", 0).show();
            BankLogin.this.startActivity(new Intent(BankLogin.this, (Class<?>) BankLogin.class));
        }
    }

    public void backToMain(View view) {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    public void bankLogin(View view) {
        EditText editText = (EditText) findViewById(R.id.loginemail_editText);
        EditText editText2 = (EditText) findViewById(R.id.login_password_editText);
        this.q = (RelativeLayout) findViewById(R.id.relp);
        this.p = (ProgressBar) findViewById(R.id.progressb);
        this.q.setVisibility(0);
        this.p.setVisibility(0);
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/user/login");
        p pVarZ = a.a.a.a.a.Z(getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("username", strTrim);
            jSONObject.put("password", strTrim2);
            jSONObject2.put("enc_data", e.b(jSONObject.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pVarZ.a(new g(1, strC, jSONObject2, new a(), new b()));
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
    }
}
