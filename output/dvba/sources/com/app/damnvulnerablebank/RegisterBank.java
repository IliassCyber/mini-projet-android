package com.app.damnvulnerablebank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
public class RegisterBank extends h {

    public class a implements q.b<JSONObject> {
        public a() {
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            try {
                Toast.makeText(RegisterBank.this.getApplicationContext(), "User created" + e.a(jSONObject2.get("enc_data").toString()), 0).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RegisterBank.this.startActivity(new Intent(RegisterBank.this, (Class<?>) BankLogin.class));
        }
    }

    public class b implements q.a {
        public b() {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
            Toast.makeText(RegisterBank.this.getApplicationContext(), "You did something wrong", 0).show();
        }
    }

    public void backToMain(View view) {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_signup);
    }

    public void register(View view) {
        EditText editText = (EditText) findViewById(R.id.signupemail_editText);
        EditText editText2 = (EditText) findViewById(R.id.signup_password_editText);
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/user/register");
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
}
