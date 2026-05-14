package com.app.damnvulnerablebank;

import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.h;
import c.a.a.a.a;
import c.a.b.p;
import c.a.b.w.d;
import c.b.a.b;
import c.b.a.c;
import c.b.a.r;
import c.b.a.s;
import c.b.a.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewBeneficiary extends h implements b.a {
    public RecyclerView p;
    public List<c> q;
    public b r;
    public TextView s;

    @Override // c.b.a.b.a
    public void c(int i) {
    }

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_viewbenif);
        this.p = (RecyclerView) findViewById(R.id.benif);
        this.s = (TextView) findViewById(R.id.empty_view);
        this.q = new ArrayList();
        String strC = a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/beneficiary/view");
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new t(this, 1, strC, null, new r(this), new s(this)));
        ((d) pVarZ.e).a();
    }
}
