package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzaj {
    private static void zza(DataLayer dataLayer, zzaf.zzd zzdVar) {
        for (zzag.zza zzaVar : zzdVar.zzhX) {
            dataLayer.zzen(zzdf.zzg(zzaVar));
        }
    }

    public static void zza(DataLayer dataLayer, zzaf.zzi zziVar) {
        if (zziVar.zziM == null) {
            zzbg.zzaC("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zziVar.zziM);
        zzb(dataLayer, zziVar.zziM);
        zzc(dataLayer, zziVar.zziM);
    }

    private static void zzb(DataLayer dataLayer, zzaf.zzd zzdVar) {
        for (zzag.zza zzaVar : zzdVar.zzhW) {
            Map<String, Object> mapZzc = zzc(zzaVar);
            if (mapZzc != null) {
                dataLayer.push(mapZzc);
            }
        }
    }

    private static Map<String, Object> zzc(zzag.zza zzaVar) {
        Object objZzl = zzdf.zzl(zzaVar);
        if (objZzl instanceof Map) {
            return (Map) objZzl;
        }
        zzbg.zzaC("value: " + objZzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzaf.zzd zzdVar) {
        String str;
        for (zzaf.zzc zzcVar : zzdVar.zzhY) {
            if (zzcVar.zzaC == null) {
                str = "GaExperimentRandom: No key";
            } else {
                Object objValueOf = dataLayer.get(zzcVar.zzaC);
                Long lValueOf = !(objValueOf instanceof Number) ? null : Long.valueOf(((Number) objValueOf).longValue());
                long j = zzcVar.zzhS;
                long j2 = zzcVar.zzhT;
                if (!zzcVar.zzhU || lValueOf == null || lValueOf.longValue() < j || lValueOf.longValue() > j2) {
                    if (j <= j2) {
                        double dRandom = Math.random();
                        double d = j2 - j;
                        Double.isNaN(d);
                        double d2 = j;
                        Double.isNaN(d2);
                        objValueOf = Long.valueOf(Math.round((dRandom * d) + d2));
                    } else {
                        str = "GaExperimentRandom: random range invalid";
                    }
                }
                dataLayer.zzen(zzcVar.zzaC);
                Map<String, Object> mapZzj = dataLayer.zzj(zzcVar.zzaC, objValueOf);
                if (zzcVar.zzhV > 0) {
                    if (mapZzj.containsKey("gtm")) {
                        Object obj = mapZzj.get("gtm");
                        if (obj instanceof Map) {
                            ((Map) obj).put("lifetime", Long.valueOf(zzcVar.zzhV));
                        } else {
                            zzbg.zzaC("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        mapZzj.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzcVar.zzhV)));
                    }
                }
                dataLayer.push(mapZzj);
            }
            zzbg.zzaC(str);
        }
    }
}
