package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzqf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzpz {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzag.zza zza(int i, JSONArray jSONArray, zzag.zza[] zzaVarArr, Set<Integer> set) throws zzqf.zzg, JSONException {
        int i2;
        if (set.contains(Integer.valueOf(i))) {
            zzeT("Value cycle detected. Current value reference: " + i + ".  Previous value references: " + set + ".");
        }
        Object objZza = zza(jSONArray, i, "values");
        if (zzaVarArr[i] != null) {
            return zzaVarArr[i];
        }
        set.add(Integer.valueOf(i));
        zzag.zza zzaVar = new zzag.zza();
        int i3 = 0;
        if (objZza instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) objZza;
            zzaVar.type = 2;
            zzaVar.zzjb = true;
            zzaVar.zziS = new zzag.zza[jSONArray2.length()];
            while (i3 < zzaVar.zziS.length) {
                zzaVar.zziS[i3] = zza(jSONArray2.getInt(i3), jSONArray, zzaVarArr, set);
                i3++;
            }
        } else if (objZza instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) objZza;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("escaping");
            if (jSONArrayOptJSONArray != null) {
                zzaVar.zzja = new int[jSONArrayOptJSONArray.length()];
                for (int i4 = 0; i4 < zzaVar.zzja.length; i4++) {
                    zzaVar.zzja[i4] = jSONArrayOptJSONArray.getInt(i4);
                }
            }
            if (jSONObject.has("function_id")) {
                zzaVar.type = 5;
                zzaVar.zziW = jSONObject.getString("function_id");
            } else if (jSONObject.has("macro_reference")) {
                zzaVar.type = 4;
                zzaVar.zzjb = true;
                zzaVar.zziV = com.google.android.gms.tagmanager.zzdf.zzg(zza(jSONObject.getInt("macro_reference"), jSONArray, zzaVarArr, set));
            } else if (jSONObject.has("template_token")) {
                zzaVar.type = 7;
                zzaVar.zzjb = true;
                JSONArray jSONArray3 = jSONObject.getJSONArray("template_token");
                zzaVar.zziZ = new zzag.zza[jSONArray3.length()];
                while (i3 < zzaVar.zziZ.length) {
                    zzaVar.zziZ[i3] = zza(jSONArray3.getInt(i3), jSONArray, zzaVarArr, set);
                    i3++;
                }
            } else {
                zzaVar.type = 3;
                zzaVar.zzjb = true;
                int length = jSONObject.length();
                zzaVar.zziT = new zzag.zza[length];
                zzaVar.zziU = new zzag.zza[length];
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    zzaVar.zziT[i3] = zza(new Integer(next).intValue(), jSONArray, zzaVarArr, set);
                    zzaVar.zziU[i3] = zza(jSONObject.getInt(next), jSONArray, zzaVarArr, set);
                    i3++;
                }
            }
        } else if (objZza instanceof String) {
            zzaVar.zziR = (String) objZza;
            zzaVar.type = 1;
        } else {
            if (objZza instanceof Boolean) {
                zzaVar.zziY = ((Boolean) objZza).booleanValue();
                i2 = 8;
            } else if (objZza instanceof Integer) {
                zzaVar.zziX = ((Integer) objZza).intValue();
                i2 = 6;
            } else {
                zzeT("Invalid value type: " + objZza);
            }
            zzaVar.type = i2;
        }
        zzaVarArr[i] = zzaVar;
        set.remove(Integer.valueOf(i));
        return zzaVar;
    }

    static zzqf.zza zza(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, zzag.zza[] zzaVarArr, int i) throws zzqf.zzg, JSONException {
        zzqf.zzb zzbVarZzAm = zzqf.zza.zzAm();
        JSONArray jSONArray3 = jSONObject.getJSONArray("property");
        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) zza(jSONArray, jSONArray3.getInt(i2), "properties");
            String str = (String) zza(jSONArray2, jSONObject2.getInt("key"), "key");
            zzag.zza zzaVar = (zzag.zza) zza(zzaVarArr, jSONObject2.getInt("value"), "value");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzbVarZzAm.zzq(zzaVar);
            } else {
                zzbVarZzAm.zzb(str, zzaVar);
            }
        }
        return zzbVarZzAm.zzAo();
    }

    static zzqf.zze zza(JSONObject jSONObject, List<zzqf.zza> list, List<zzqf.zza> list2, List<zzqf.zza> list3, zzag.zza[] zzaVarArr) throws JSONException {
        zzqf.zzf zzfVarZzAt = zzqf.zze.zzAt();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("positive_predicate");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("negative_predicate");
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("add_tag");
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("remove_tag");
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("add_tag_rule_name");
        JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("remove_tag_rule_name");
        JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("add_macro");
        JSONArray jSONArrayOptJSONArray8 = jSONObject.optJSONArray("remove_macro");
        JSONArray jSONArrayOptJSONArray9 = jSONObject.optJSONArray("add_macro_rule_name");
        JSONArray jSONArrayOptJSONArray10 = jSONObject.optJSONArray("remove_macro_rule_name");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                zzfVarZzAt.zzd(list3.get(jSONArrayOptJSONArray.getInt(i)));
            }
        }
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                zzfVarZzAt.zze(list3.get(jSONArrayOptJSONArray2.getInt(i2)));
            }
        }
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                zzfVarZzAt.zzf(list.get(jSONArrayOptJSONArray3.getInt(i3)));
            }
        }
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                zzfVarZzAt.zzg(list.get(jSONArrayOptJSONArray4.getInt(i4)));
            }
        }
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                zzfVarZzAt.zzeW(zzaVarArr[jSONArrayOptJSONArray5.getInt(i5)].zziR);
            }
        }
        if (jSONArrayOptJSONArray6 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                zzfVarZzAt.zzeX(zzaVarArr[jSONArrayOptJSONArray6.getInt(i6)].zziR);
            }
        }
        if (jSONArrayOptJSONArray7 != null) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray7.length(); i7++) {
                zzfVarZzAt.zzh(list2.get(jSONArrayOptJSONArray7.getInt(i7)));
            }
        }
        if (jSONArrayOptJSONArray8 != null) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray8.length(); i8++) {
                zzfVarZzAt.zzi(list2.get(jSONArrayOptJSONArray8.getInt(i8)));
            }
        }
        if (jSONArrayOptJSONArray9 != null) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray9.length(); i9++) {
                zzfVarZzAt.zzeY(zzaVarArr[jSONArrayOptJSONArray9.getInt(i9)].zziR);
            }
        }
        if (jSONArrayOptJSONArray10 != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray10.length(); i10++) {
                zzfVarZzAt.zzeZ(zzaVarArr[jSONArrayOptJSONArray10.getInt(i10)].zziR);
            }
        }
        return zzfVarZzAt.zzAE();
    }

    private static <T> T zza(JSONArray jSONArray, int i, String str) throws zzqf.zzg {
        if (i >= 0 && i < jSONArray.length()) {
            try {
                return (T) jSONArray.get(i);
            } catch (JSONException e) {
            }
        }
        zzeT("Index out of bounds detected: " + i + " in " + str);
        return null;
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzqf.zzg {
        if (i < 0 || i >= tArr.length) {
            zzeT("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    static List<zzqf.zza> zza(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, zzag.zza[] zzaVarArr) throws zzqf.zzg, JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i), jSONArray2, jSONArray3, zzaVarArr, i));
        }
        return arrayList;
    }

    private static void zzeT(String str) throws zzqf.zzg {
        com.google.android.gms.tagmanager.zzbg.zzaz(str);
        throw new zzqf.zzg(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzqf.zzc zzey(String str) throws zzqf.zzg, JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Object obj = jSONObject.get("resource");
        if (!(obj instanceof JSONObject)) {
            throw new zzqf.zzg("Resource map not found");
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        zzqf.zzd zzdVarZzAp = zzqf.zzc.zzAp();
        zzag.zza[] zzaVarArrZzj = zzj(jSONObject2);
        JSONArray jSONArray = jSONObject2.getJSONArray("properties");
        JSONArray jSONArray2 = jSONObject2.getJSONArray("key");
        List<zzqf.zza> listZza = zza(jSONObject2.getJSONArray("tags"), jSONArray, jSONArray2, zzaVarArrZzj);
        List<zzqf.zza> listZza2 = zza(jSONObject2.getJSONArray("predicates"), jSONArray, jSONArray2, zzaVarArrZzj);
        List<zzqf.zza> listZza3 = zza(jSONObject2.getJSONArray("macros"), jSONArray, jSONArray2, zzaVarArrZzj);
        Iterator<zzqf.zza> it = listZza3.iterator();
        while (it.hasNext()) {
            zzdVarZzAp.zzc(it.next());
        }
        JSONArray jSONArray3 = jSONObject2.getJSONArray("rules");
        for (int i = 0; i < jSONArray3.length(); i++) {
            zzdVarZzAp.zzb(zza(jSONArray3.getJSONObject(i), listZza, listZza3, listZza2, zzaVarArrZzj));
        }
        zzdVarZzAp.zzeV("1");
        zzdVarZzAp.zzjb(1);
        jSONObject.optJSONArray("runtime");
        return zzdVarZzAp.zzAs();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzag.zza[] zzj(JSONObject jSONObject) throws zzqf.zzg, JSONException {
        Object objOpt = jSONObject.opt("values");
        if (!(objOpt instanceof JSONArray)) {
            throw new zzqf.zzg("Missing Values list");
        }
        JSONArray jSONArray = (JSONArray) objOpt;
        zzag.zza[] zzaVarArr = new zzag.zza[jSONArray.length()];
        for (int i = 0; i < zzaVarArr.length; i++) {
            zza(i, jSONArray, zzaVarArr, new HashSet(0));
        }
        return zzaVarArr;
    }
}
