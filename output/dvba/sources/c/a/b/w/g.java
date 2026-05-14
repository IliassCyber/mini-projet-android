package c.a.b.w;

import c.a.b.l;
import c.a.b.n;
import c.a.b.q;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends h<JSONObject> {
    public g(int i, String str, JSONObject jSONObject, q.b<JSONObject> bVar, q.a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    @Override // c.a.b.o
    public q<JSONObject> l(l lVar) {
        try {
            return new q<>(new JSONObject(new String(lVar.f1206a, a.a.a.a.a.j0(lVar.f1207b, "utf-8"))), a.a.a.a.a.i0(lVar));
        } catch (UnsupportedEncodingException e) {
            return new q<>(new n(e));
        } catch (JSONException e2) {
            return new q<>(new n(e2));
        }
    }
}
