package com.app.damnvulnerablebank;

import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.h;
import c.a.b.p;
import c.a.b.w.d;
import c.b.a.a;
import c.b.a.f;
import c.b.a.g;
import c.b.a.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GetTransactions extends h {
    public RecyclerView p;
    public List<q> q;
    public TextView r;
    public a s;

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_transactions);
        this.p = (RecyclerView) findViewById(R.id.transt);
        this.q = new ArrayList();
        this.r = (TextView) findViewById(R.id.empty_view);
        String strC = c.a.a.a.a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/transactions/view");
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new c.b.a.h(this, 1, strC, null, new f(this), new g(this)));
        ((d) pVarZ.e).a();
    }
}
