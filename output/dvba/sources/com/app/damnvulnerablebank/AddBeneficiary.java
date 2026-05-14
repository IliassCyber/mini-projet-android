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
public class AddBeneficiary extends h {

    public class a implements q.b<JSONObject> {
        public a() {
        }

        @Override // c.a.b.q.b
        public void a(JSONObject jSONObject) {
            try {
                Toast.makeText(AddBeneficiary.this.getApplicationContext(), e.a(jSONObject.get("enc_data").toString()), 0).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AddBeneficiary.this.startActivity(new Intent(AddBeneficiary.this, (Class<?>) Dashboard.class));
        }
    }

    public class b implements q.a {
        public b() {
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
            Toast.makeText(AddBeneficiary.this.getApplicationContext(), "Something went wrong", 0).show();
        }
    }

    public class c extends g {
        public final /* synthetic */ String u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AddBeneficiary addBeneficiary, int i, String str, JSONObject jSONObject, q.b bVar, q.a aVar, String str2) {
            super(i, str, jSONObject, bVar, aVar);
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

    public void addBeneficiary(View view) {
        String string = getSharedPreferences("jwt", 0).getString("accesstoken", null);
        String strTrim = ((EditText) findViewById(R.id.edt)).getText().toString().trim();
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/beneficiary/add");
        p pVarZ = a.a.a.a.a.Z(getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("account_number", strTrim);
            jSONObject2.put("enc_data", e.b(jSONObject.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pVarZ.a(new c(this, 1, strC, jSONObject2, new a(), new b(), string));
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_addbenif);
    }
}
