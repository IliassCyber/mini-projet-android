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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ResetPassword extends h {

    public class a implements q.b<JSONObject> {
        public a() {
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            Toast.makeText(ResetPassword.this.getApplicationContext(), "Done", 0).show();
            ResetPassword.this.getSharedPreferences("jwt", 0).edit().putBoolean("isloggedin", false).apply();
            ResetPassword.this.startActivity(new Intent(ResetPassword.this, (Class<?>) BankLogin.class));
        }
    }

    public class b implements q.a {
        public b() {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
            Toast.makeText(ResetPassword.this.getApplicationContext(), "Something went wrong", 0).show();
        }
    }

    public class c extends g {
        public c(int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar) {
            super(i, str, jSONObject, bVar, aVar);
        }

        @Override // c.a.b.o
        public Map g() {
            String string = ResetPassword.this.getSharedPreferences("jwt", 0).getString("accesstoken", null);
            HashMap map = new HashMap();
            map.put("Authorization", "Bearer " + string);
            return map;
        }
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_passreset);
    }

    public void resetPassword(View view) {
        EditText editText = (EditText) findViewById(R.id.oldlogin_password_editText);
        EditText editText2 = (EditText) findViewById(R.id.newlogin_password_editText);
        EditText editText3 = (EditText) findViewById(R.id.new1login_password_editText);
        String strTrim = editText.getText().toString().trim();
        String strTrim2 = editText2.getText().toString().trim();
        if (!strTrim2.equals(editText3.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), "Something Entered Password is Different", 0).show();
            return;
        }
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/user/change-password");
        p pVarZ = a.a.a.a.a.Z(getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("password", strTrim);
            jSONObject.put("new_password", strTrim2);
            jSONObject2.put("enc_data", e.b(jSONObject.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pVarZ.a(new c(1, strC, jSONObject2, new a(), new b()));
    }
}
