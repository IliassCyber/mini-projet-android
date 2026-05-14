package com.app.damnvulnerablebank;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertController;
import b.b.k.g;
import b.b.k.h;
import c.a.b.p;
import c.a.b.q;
import c.a.b.u;
import c.a.b.w.d;
import c.a.b.w.j;
import c.b.a.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends h {

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.u(MainActivity.this);
            System.exit(0);
        }
    }

    public class b implements q.b<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f1933a;

        public b(MainActivity mainActivity, Button button) {
            this.f1933a = button;
        }

        @Override // c.a.b.q.b
        public void a(String str) {
            this.f1933a.setText("Api is Up");
            this.f1933a.setTextColor(-16711936);
        }
    }

    public class c implements q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f1934a;

        public c(MainActivity mainActivity, Button button) {
            this.f1934a = button;
        }

        @Override // c.a.b.q.a
        public void a(u uVar) {
            this.f1934a.setText("Api is Down");
            this.f1934a.setTextColor(-65536);
        }
    }

    public static void u(MainActivity mainActivity) {
        mainActivity.f.a();
    }

    public void healthCheck(View view) {
        SharedPreferences.Editor editorEdit = getApplicationContext().getSharedPreferences("apiurl", 0).edit();
        editorEdit.putString("apiurl", ((EditText) findViewById(R.id.apiurl)).getText().toString().trim());
        editorEdit.apply();
        findViewById(R.id.healthc);
        Button button = (Button) findViewById(R.id.healthc);
        p pVarZ = a.a.a.a.a.Z(this);
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/health/check");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enc_data", "GmdBWksdEwAZFAlLVEdDX1FKS0JtQU1DHggaBkNXQQFjTkdBTUMJBgMCFQUIFA5MXUFPDxUdBg4PCkNWY05HQU1DFAYaDwgDBlhTTkUSAgwfHQcJBk9rWkkTbRw=");
            Log.d("DECRYPTING: ", new JSONObject(e.a(jSONObject.get("enc_data").toString())).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pVarZ.a(new j(0, strC, new b(this, button), new c(this, button)));
        ((d) pVarZ.e).a();
    }

    public void loginPage(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) BankLogin.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        g.a aVar = new g.a(this);
        AlertController.b bVar = aVar.f252a;
        bVar.f = "Really Exit?";
        bVar.h = "Are you sure you want to exit?";
        bVar.k = bVar.f49a.getText(android.R.string.no);
        aVar.f252a.l = null;
        a aVar2 = new a();
        AlertController.b bVar2 = aVar.f252a;
        bVar2.i = bVar2.f49a.getText(android.R.string.yes);
        aVar.f252a.j = aVar2;
        aVar.a().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020b  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instruction units count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.app.damnvulnerablebank.MainActivity.onCreate(android.os.Bundle):void");
    }

    public void signupPage(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) RegisterBank.class));
    }
}
