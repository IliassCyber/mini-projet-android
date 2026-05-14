package c.c.b.h.d0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.a.f.c.a1;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f1856c;
    public c.c.a.a.c.m.a d;

    public p(Context context, String str) {
        c.c.a.a.c.l.q.f(context);
        c.c.a.a.c.l.q.d(str);
        this.f1855b = str;
        this.f1854a = context.getApplicationContext();
        this.f1856c = this.f1854a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f1855b), 0);
        this.d = new c.c.a.a.c.m.a("StorageHelpers", new String[0]);
    }

    public final c0 a(JSONObject jSONObject) {
        JSONArray jSONArray;
        e0 e0VarC;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(z.h(jSONArray2.getString(i)));
            }
            c0 c0Var = new c0(c.c.b.b.d(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                c0Var.k(a1.h(string));
            }
            if (!z) {
                c0Var.i = Boolean.FALSE;
            }
            c0Var.h = str;
            if (jSONObject.has("userMetadata") && (e0VarC = e0.c(jSONObject.getJSONObject("userMetadata"))) != null) {
                c0Var.j = e0VarC;
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                    arrayList2.add("phone".equals(jSONObject2.optString("factorIdKey")) ? c.c.b.h.y.i(jSONObject2) : null);
                }
                c0Var.l(arrayList2);
            }
            return c0Var;
        } catch (c.c.b.h.c0.b | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            Log.wtf(this.d.f1410a, e);
            return null;
        }
    }
}
