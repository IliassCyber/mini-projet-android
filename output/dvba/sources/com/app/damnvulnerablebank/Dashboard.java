package com.app.damnvulnerablebank;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import b.b.k.g;
import b.b.k.h;

/* JADX INFO: loaded from: classes.dex */
public class Dashboard extends h {

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Dashboard.u(Dashboard.this);
            System.exit(0);
        }
    }

    public static void u(Dashboard dashboard) {
        dashboard.f.a();
    }

    public void addBeneficiary(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) AddBeneficiary.class));
    }

    public void getCurrencyRates(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) CurrencyRates.class));
    }

    public void getPendingBeneficiaries(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) PendingBeneficiary.class));
    }

    public void logout(View view) {
        SharedPreferences.Editor editorEdit = getApplicationContext().getSharedPreferences("jwt", 0).edit();
        editorEdit.putBoolean("isloggedin", false);
        editorEdit.apply();
        startActivity(new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
    }

    public void myprofile(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) Myprofile.class));
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

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dashboard);
        if (a.a.a.a.a.R()) {
            Toast.makeText(getApplicationContext(), "Phone is Rooted", 0).show();
            finish();
        }
    }

    public void resetPassword(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) ResetPassword.class));
    }

    public void viewBeneficiaryAdmin(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) ViewBeneficiaryAdmin.class));
    }

    public void viewMyBeneficiaries(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) ViewBeneficiary.class));
    }

    public void viewTransactions(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) GetTransactions.class));
    }

    public void viewbalance(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) ViewBalance.class));
    }
}
