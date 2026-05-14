package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzax {
    private static String zzaLU;
    static Map<String, String> zzaLV = new HashMap();

    zzax() {
    }

    static String zzD(String str, String str2) {
        if (str2 == null) {
            if (str.length() > 0) {
                return str;
            }
            return null;
        }
        return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }

    static void zzex(String str) {
        synchronized (zzax.class) {
            zzaLU = str;
        }
    }

    static String zzf(Context context, String str, String str2) {
        String string = zzaLV.get(str);
        if (string == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            string = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            zzaLV.put(str, string);
        }
        return zzD(string, str2);
    }

    static String zzj(Context context, String str) {
        if (zzaLU == null) {
            synchronized (zzax.class) {
                if (zzaLU == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    zzaLU = sharedPreferences != null ? sharedPreferences.getString("referrer", "") : "";
                }
            }
        }
        return zzD(zzaLU, str);
    }

    static void zzk(Context context, String str) {
        String strZzD = zzD(str, "conv");
        if (strZzD == null || strZzD.length() <= 0) {
            return;
        }
        zzaLV.put(strZzD, str);
        zzcv.zza(context, "gtm_click_referrers", strZzD, str);
    }
}
