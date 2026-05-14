package com.app.damnvulnerablebank;

import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.h;
import c.a.a.a.a;
import c.a.b.p;
import c.a.b.w.d;
import c.b.a.i;
import c.b.a.j;
import c.b.a.k;
import c.b.a.l;
import c.b.a.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PendingBeneficiary extends h implements i.a {
    public RecyclerView p;
    public List<m> q;
    public TextView r;
    public i s;

    @Override // b.b.k.h, b.l.a.e, androidx.activity.ComponentActivity, b.i.d.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pendingbenificiary);
        this.p = (RecyclerView) findViewById(R.id.pendb);
        this.q = new ArrayList();
        this.r = (TextView) findViewById(R.id.empty_view);
        String strC = a.c(getSharedPreferences("apiurl", 0).getString("apiurl", null), "/api/beneficiary/pending");
        p pVarZ = a.a.a.a.a.Z(this);
        pVarZ.a(new l(this, 1, strC, null, new j(this), new k(this)));
        ((d) pVarZ.e).a();
    }
}
