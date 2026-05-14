package c.c.b.h.d0;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.c.a.a.c.m.a f1847a = new c.c.a.a.c.m.a("JSONParser", new String[0]);

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objC = jSONArray.get(i);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayList.add(objC);
        }
        return arrayList;
    }

    public static Map<String, Object> b(String str) {
        c.c.a.a.f.c.h hVar;
        c.c.a.a.c.l.q.d(str);
        c.c.a.a.f.c.i iVar = new c.c.a.a.f.c.i(new c.c.a.a.f.c.h(new c.c.a.a.f.c.d()));
        byte[] bArrDecode = null;
        if (str == null || (hVar = iVar.f1451b) == null) {
            throw null;
        }
        c.c.a.a.f.c.j jVar = new c.c.a.a.f.c.j(hVar, iVar, str);
        ArrayList arrayList = new ArrayList();
        while (jVar.hasNext()) {
            arrayList.add((String) jVar.next());
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        if (listUnmodifiableList.size() < 2) {
            c.c.a.a.c.m.a aVar = f1847a;
            Log.e(aVar.f1410a, aVar.a(str.length() != 0 ? "Invalid idToken ".concat(str) : new String("Invalid idToken "), new Object[0]));
        } else {
            String str2 = (String) listUnmodifiableList.get(1);
            try {
                if (str2 != null) {
                    bArrDecode = Base64.decode(str2, 11);
                }
                Map<String, Object> mapD = d(new String(bArrDecode, "UTF-8"));
                return mapD == null ? c.c.a.a.f.c.s.h : mapD;
            } catch (UnsupportedEncodingException e) {
                c.c.a.a.c.m.a aVar2 = f1847a;
                Log.e(aVar2.f1410a, aVar2.a("Unable to decode token", new Object[0]), e);
            }
        }
        return c.c.a.a.f.c.s.h;
    }

    public static Map<String, Object> c(JSONObject jSONObject) throws JSONException {
        b.f.a aVar = new b.f.a();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objC = jSONObject.get(next);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            aVar.put(next, objC);
        }
        return aVar;
    }

    public static Map<String, Object> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new c.c.b.h.c0.b(e);
        }
    }
}
