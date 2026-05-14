package com.google.firebase.auth;

import androidx.annotation.Keep;
import c.c.a.a.c.l.q;
import c.c.b.h.d0.b;
import c.c.b.h.m0;
import c.c.b.i.d;
import c.c.b.i.h;
import c.c.b.i.p;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseAuthRegistrar implements h {
    @Override // c.c.b.i.h
    @Keep
    public List<d<?>> getComponents() {
        d[] dVarArr = new d[2];
        d.b bVar = new d.b(FirebaseAuth.class, new Class[]{b.class}, null);
        bVar.a(new p(c.c.b.b.class, 1, 0));
        bVar.c(m0.f1873a);
        if (!(bVar.f1891c == 0)) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        bVar.f1891c = 2;
        dVarArr[0] = bVar.b();
        dVarArr[1] = q.j("fire-auth", "19.4.0");
        return Arrays.asList(dVarArr);
    }
}
