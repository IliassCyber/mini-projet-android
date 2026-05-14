package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import c.c.a.a.f.c.a1;
import c.c.a.a.f.c.n;
import c.c.b.h.c0.a.g;
import c.c.b.h.d0.c0;
import c.c.b.h.d0.e0;
import c.c.b.h.d0.f;
import c.c.b.h.d0.j;
import c.c.b.h.d0.m;
import c.c.b.h.d0.p;
import c.c.b.h.d0.q;
import c.c.b.h.d0.r;
import c.c.b.h.d0.z;
import c.c.b.h.j0;
import c.c.b.h.k0;
import c.c.b.h.o;
import c.c.b.h.s;
import c.c.b.h.y;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseAuth implements c.c.b.h.d0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.c.b.b f2025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f2026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c.c.b.h.d0.a> f2027c;
    public List<a> d;
    public g e;
    public o f;
    public final Object g;
    public String h;
    public final p i;
    public final j j;
    public c.c.b.h.d0.o k;
    public q l;

    public interface a {
        void a(FirebaseAuth firebaseAuth);
    }

    public interface b {
        void a(FirebaseAuth firebaseAuth);
    }

    public class c implements r {
        public c() {
        }

        @Override // c.c.b.h.d0.r
        public final void a(a1 a1Var, o oVar) {
            c.c.a.a.c.l.q.f(a1Var);
            c.c.a.a.c.l.q.f(oVar);
            oVar.k(a1Var);
            FirebaseAuth.this.b(oVar, a1Var, true, false);
        }
    }

    public class d implements f, r {
        public d() {
        }

        @Override // c.c.b.h.d0.r
        public final void a(a1 a1Var, o oVar) {
            c.c.a.a.c.l.q.f(a1Var);
            c.c.a.a.c.l.q.f(oVar);
            oVar.k(a1Var);
            FirebaseAuth.this.b(oVar, a1Var, true, true);
        }

        @Override // c.c.b.h.d0.f
        public final void b(Status status) {
            int i = status.f1952c;
            if (i == 17011 || i == 17021 || i == 17005 || i == 17091) {
                FirebaseAuth.this.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FirebaseAuth(c.c.b.b r11) {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.<init>(c.c.b.b):void");
    }

    @Keep
    public static FirebaseAuth getInstance() {
        c.c.b.b bVarC = c.c.b.b.c();
        bVarC.a();
        return (FirebaseAuth) bVarC.d.a(FirebaseAuth.class);
    }

    public void a() {
        o oVar = this.f;
        if (oVar != null) {
            p pVar = this.i;
            c.c.a.a.c.l.q.f(oVar);
            pVar.f1856c.edit().remove(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", ((c0) oVar).f1832c.f1865b)).apply();
            this.f = null;
        }
        this.i.f1856c.edit().remove("com.google.firebase.auth.FIREBASE_USER").apply();
        d(null);
        e(null);
        c.c.b.h.d0.o oVar2 = this.k;
        if (oVar2 != null) {
            c.c.b.h.d0.c cVar = oVar2.f1852b;
            cVar.f.removeCallbacks(cVar.g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11, types: [c.c.b.h.d0.p] */
    /* JADX WARN: Type inference failed for: r7v12, types: [c.c.a.a.f.c.n] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v4, types: [c.c.b.h.o] */
    /* JADX WARN: Type inference failed for: r8v2, types: [c.c.a.a.f.c.n] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(o oVar, a1 a1Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        ?? H;
        boolean z5;
        c.c.b.h.d0.o oVar2;
        p pVar;
        String string;
        ?? size;
        p pVar2;
        ?? H2;
        c.c.a.a.c.l.q.f(oVar);
        c.c.a.a.c.l.q.f(a1Var);
        o oVar3 = this.f;
        boolean z6 = false;
        boolean z7 = oVar3 != null && ((c0) oVar).f1832c.f1865b.equals(((c0) oVar3).f1832c.f1865b);
        if (z7 || !z2) {
            o oVar4 = this.f;
            if (oVar4 == null) {
                z4 = true;
                z3 = true;
            } else {
                z3 = !z7 || (((c0) oVar4).f1831b.f1431c.equals(a1Var.f1431c) ^ true);
                z4 = !z7;
            }
            c.c.a.a.c.l.q.f(oVar);
            o oVar5 = this.f;
            if (oVar5 == null) {
                this.f = oVar;
            } else {
                c0 c0Var = (c0) oVar;
                oVar5.j(c0Var.f);
                if (!oVar.i()) {
                    ((c0) this.f).i = Boolean.FALSE;
                }
                c.c.a.a.c.l.q.f(c0Var);
                m mVar = c0Var.m;
                if (mVar != null) {
                    H = new ArrayList();
                    Iterator<y> it = mVar.f1848b.iterator();
                    while (it.hasNext()) {
                        H.add(it.next());
                    }
                } else {
                    H = n.h();
                }
                this.f.l(H);
            }
            if (z) {
                p pVar3 = this.i;
                o oVar6 = this.f;
                if (pVar3 == null) {
                    throw null;
                }
                c.c.a.a.c.l.q.f(oVar6);
                JSONObject jSONObject = new JSONObject();
                if (c0.class.isAssignableFrom(oVar6.getClass())) {
                    c0 c0Var2 = (c0) oVar6;
                    try {
                        jSONObject.put("cachedTokenState", c0Var2.m());
                        c.c.b.b bVarD = c.c.b.b.d(c0Var2.d);
                        bVarD.a();
                        jSONObject.put("applicationName", bVarD.f1763b);
                        jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                        if (c0Var2.f != null) {
                            JSONArray jSONArray = new JSONArray();
                            List<z> list = c0Var2.f;
                            int i = 0;
                            while (true) {
                                size = list.size();
                                if (i >= size) {
                                    break;
                                }
                                jSONArray.put(list.get(i).i());
                                i++;
                            }
                            jSONObject.put("userInfos", jSONArray);
                        }
                        jSONObject.put("anonymous", c0Var2.i());
                        jSONObject.put("version", "2");
                        try {
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        size = pVar3;
                    }
                    if (c0Var2.j != null) {
                        e0 e0Var = c0Var2.j;
                        if (e0Var == null) {
                            throw null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        z5 = z3;
                        try {
                            jSONObject2.put("lastSignInTimestamp", e0Var.f1836b);
                            pVar2 = pVar3;
                            try {
                                jSONObject2.put("creationTimestamp", e0Var.f1837c);
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            pVar2 = pVar3;
                        }
                        jSONObject.put("userMetadata", jSONObject2);
                        c.c.a.a.c.m.a aVar = size.d;
                        Log.wtf(aVar.f1410a, aVar.a("Failed to turn object into JSON", new Object[0]), e);
                        throw new c.c.b.h.c0.b(e);
                    }
                    z5 = z3;
                    pVar2 = pVar3;
                    c.c.a.a.c.l.q.f(c0Var2);
                    m mVar2 = c0Var2.m;
                    if (mVar2 != null) {
                        H2 = new ArrayList();
                        Iterator<y> it2 = mVar2.f1848b.iterator();
                        while (it2.hasNext()) {
                            H2.add(it2.next());
                        }
                    } else {
                        H2 = n.h();
                    }
                    if (H2 != 0 && !H2.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i2 = 0; i2 < H2.size(); i2++) {
                            jSONArray2.put(((s) H2.get(i2)).h());
                        }
                        jSONObject.put("userMultiFactorInfo", jSONArray2);
                    }
                    string = jSONObject.toString();
                    pVar = pVar2;
                } else {
                    z5 = z3;
                    pVar = pVar3;
                    string = null;
                }
                if (!TextUtils.isEmpty(string)) {
                    pVar.f1856c.edit().putString("com.google.firebase.auth.FIREBASE_USER", string).apply();
                }
            } else {
                z5 = z3;
            }
            if (z5) {
                o oVar7 = this.f;
                if (oVar7 != null) {
                    oVar7.k(a1Var);
                }
                d(this.f);
            }
            if (z4) {
                e(this.f);
            }
            if (z) {
                p pVar4 = this.i;
                if (pVar4 == null) {
                    throw null;
                }
                c.c.a.a.c.l.q.f(oVar);
                c.c.a.a.c.l.q.f(a1Var);
                pVar4.f1856c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", ((c0) oVar).f1832c.f1865b), a1Var.i()).apply();
            }
            synchronized (this) {
                if (this.k == null) {
                    c.c.b.h.d0.o oVar8 = new c.c.b.h.d0.o(this.f2025a);
                    synchronized (this) {
                        this.k = oVar8;
                    }
                }
                oVar2 = this.k;
            }
            a1 a1Var2 = ((c0) this.f).f1831b;
            if (oVar2 == null) {
                throw null;
            }
            if (a1Var2 == null) {
                return;
            }
            Long l = a1Var2.d;
            long jLongValue = l == null ? 0L : l.longValue();
            if (jLongValue <= 0) {
                jLongValue = 3600;
            }
            long jLongValue2 = (jLongValue * 1000) + a1Var2.f.longValue();
            c.c.b.h.d0.c cVar = oVar2.f1852b;
            cVar.f1829b = jLongValue2;
            cVar.f1830c = -1L;
            if (oVar2.f1851a > 0 && !oVar2.f1853c) {
                z6 = true;
            }
            if (z6) {
                oVar2.f1852b.a();
            }
        }
    }

    public final boolean c(String str) {
        c.c.b.h.a aVarA = c.c.b.h.a.a(str);
        return (aVarA == null || TextUtils.equals(this.h, aVarA.d)) ? false : true;
    }

    public final void d(o oVar) {
        String string;
        if (oVar != null) {
            String str = ((c0) oVar).f1832c.f1865b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(str);
            sb.append(" ).");
            string = sb.toString();
        } else {
            string = "Notifying id token listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", string);
        c.c.b.m.a aVar = new c.c.b.m.a(oVar != null ? ((c0) oVar).f1831b.f1431c : null);
        this.l.f1858a.post(new k0(this, aVar));
    }

    public final void e(o oVar) {
        String string;
        if (oVar != null) {
            String str = ((c0) oVar).f1832c.f1865b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(str);
            sb.append(" ).");
            string = sb.toString();
        } else {
            string = "Notifying auth state listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", string);
        q qVar = this.l;
        qVar.f1858a.post(new j0(this));
    }

    @Keep
    public static FirebaseAuth getInstance(c.c.b.b bVar) {
        bVar.a();
        return (FirebaseAuth) bVar.d.a(FirebaseAuth.class);
    }
}
