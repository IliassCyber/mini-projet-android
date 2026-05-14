package com.app.damnvulnerablebank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.h;
import c.a.a.a.a;
import c.a.b.p;
import c.a.b.w.d;
import c.b.a.b;
import c.b.a.c;
import c.b.a.u;
import c.b.a.v;
import c.b.a.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewBeneficiaryAdmin extends h implements b.a {
    public RecyclerView p;
    public List<c> q;
    public TextView r;
    public b s;

    @Override // c.b.a.b.a
    public void c(int i) {
        Intent intent = new Intent(this, (Class<?>) SendMoney.class);
        intent.putExtra("beneficiary_account_number", this.q.get(i).f1253a);
        startActivity(intent);
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_viewbenif);
        this.p = (RecyclerView) findViewById(R.id.benif);
        this.r = (TextView) findViewById(R.id.empty_view);
        this.q = new ArrayList();
        String strC = a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/beneficiary/view");
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new w(this, 1, strC, null, new u(this), new v(this)));
        ((d) pVarZ.e).a();
    }
}
