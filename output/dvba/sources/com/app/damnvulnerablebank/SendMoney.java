package com.app.damnvulnerablebank;

import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.biometric.BiometricPrompt;
import b.b.k.h;
import b.i.g.a.b;
import c.a.b.p;
import c.b.a.e;
import c.b.a.n;
import c.b.a.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SendMoney extends h {
    public Button p;
    public TextView q;

    public class a extends BiometricPrompt.b {
        public a() {
        }

        @Override // androidx.biometric.BiometricPrompt.b
        public void a(BiometricPrompt.c cVar) {
            int i;
            Toast.makeText(SendMoney.this.getApplicationContext(), "Transfer Successful", 1).show();
            SendMoney sendMoney = SendMoney.this;
            int i2 = 0;
            String string = sendMoney.getSharedPreferences("jwt", 0).getString("accesstoken", null);
            String strC = c.a.a.a.a.c(sendMoney.getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/balance/transfer");
            EditText editText = (EditText) sendMoney.findViewById(R.id.edact);
            EditText editText2 = (EditText) sendMoney.findViewById(R.id.edamt);
            p pVarZ = a.a.a.a.a.Z(sendMoney.getApplicationContext());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (editText.getText().toString() == "" || editText2.getText().toString() == "") {
                    Toast.makeText(sendMoney.getApplicationContext(), "Invalid Input ", 0).show();
                    sendMoney.startActivity(new Intent(sendMoney, (Class<?>) SendMoney.class));
                    i = 0;
                } else {
                    i2 = Integer.parseInt(editText.getText().toString());
                    i = Integer.parseInt(editText2.getText().toString());
                }
                jSONObject.put("to_account", i2);
                jSONObject.put("amount", i);
                jSONObject2.put("enc_data", e.b(jSONObject.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            pVarZ.a(new c.b.a.p(sendMoney, 1, strC, jSONObject2, new n(sendMoney), new o(sendMoney), string));
        }
    }

    public void Biometrics(View view) {
        BiometricManager biometricManager;
        String str;
        b bVar = null;
        if (Build.VERSION.SDK_INT >= 29) {
            biometricManager = (BiometricManager) getSystemService(BiometricManager.class);
        } else {
            bVar = new b(this);
            biometricManager = null;
        }
        int iCanAuthenticate = Build.VERSION.SDK_INT >= 29 ? biometricManager.canAuthenticate() : !bVar.c() ? 12 : !bVar.b() ? 11 : 0;
        if (iCanAuthenticate != 0) {
            if (iCanAuthenticate == 1) {
                str = "Biometric sensor is not available";
            } else if (iCanAuthenticate == 11) {
                str = "Your device don't have any fingerprint, check your security setting";
            } else if (iCanAuthenticate == 12) {
                str = "No fingerprint sensor";
            }
            Toast.makeText(this, str, 1).show();
            this.p.setVisibility(4);
        } else {
            Toast.makeText(this, "Authenticate to continue", 1).show();
        }
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, b.i.e.a.d(this), new a());
        Bundle bundle = new Bundle();
        bundle.putCharSequence("title", "Login");
        bundle.putCharSequence("description", "User fingerprint to Proceed");
        bundle.putBoolean("allow_device_credential", true);
        CharSequence charSequence = bundle.getCharSequence("title");
        CharSequence charSequence2 = bundle.getCharSequence("negative_text");
        boolean z = bundle.getBoolean("allow_device_credential");
        boolean z2 = bundle.getBoolean("handling_device_credential_result");
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException("Title must be set and non-empty");
        }
        if (TextUtils.isEmpty(charSequence2) && !z) {
            throw new IllegalArgumentException("Negative text must be set and non-empty");
        }
        if (!TextUtils.isEmpty(charSequence2) && z) {
            throw new IllegalArgumentException("Can't have both negative button behavior and device credential enabled");
        }
        if (z2 && !z) {
            throw new IllegalArgumentException("Can't be handling device credential result without device credential enabled");
        }
        biometricPrompt.b(new BiometricPrompt.e(bundle));
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sendmoney);
        this.q = (TextView) findViewById(R.id.actid);
        this.q.setText(getIntent().getStringExtra("beneficiary_account_number"));
        this.p = (Button) findViewById(R.id.sendbutton);
    }
}
