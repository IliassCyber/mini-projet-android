package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class zzx {
    public static String zza(Map<String, String> map) {
        return zzb(map, "ISO-8859-1");
    }

    public static zzb.zza zzb(zzi zziVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zziVar.zzA;
        String str = map.get("Date");
        long j5 = 0;
        long jZzg = str != null ? zzg(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            j = 0;
            j2 = 0;
            int i2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long jZzg2 = str3 != null ? zzg(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jZzg3 = str4 != null ? zzg(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            long j6 = jCurrentTimeMillis + (j * 1000);
            if (i != 0) {
                j4 = j6;
            } else {
                Long.signum(j2);
                j4 = (j2 * 1000) + j6;
            }
            j3 = j4;
            j5 = j6;
        } else {
            if (jZzg > 0 && jZzg2 >= jZzg) {
                j5 = jCurrentTimeMillis + (jZzg2 - jZzg);
            }
            j3 = j5;
        }
        zzb.zza zzaVar = new zzb.zza();
        zzaVar.data = zziVar.data;
        zzaVar.zzb = str5;
        zzaVar.zzf = j5;
        zzaVar.zze = j3;
        zzaVar.zzc = jZzg;
        zzaVar.zzd = jZzg3;
        zzaVar.zzg = map;
        return zzaVar;
    }

    public static String zzb(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(";");
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=");
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long zzg(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }
}
