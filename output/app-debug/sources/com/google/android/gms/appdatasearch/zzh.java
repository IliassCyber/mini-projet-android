package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzh {
    private static final String[] zzNq = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzNr = new HashMap(zzNq.length);

    static {
        int i = 0;
        while (true) {
            String[] strArr = zzNq;
            if (i >= strArr.length) {
                return;
            }
            zzNr.put(strArr[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzai(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = zzNq;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public static int zzbq(String str) {
        Integer num = zzNr.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzkL() {
        return zzNq.length;
    }
}
