package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzt extends zzak {
    private final zza zzaLe;
    private static final String ID = com.google.android.gms.internal.zzad.FUNCTION_CALL.toString();
    private static final String zzaLd = com.google.android.gms.internal.zzae.FUNCTION_CALL_NAME.toString();
    private static final String zzaKr = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();

    public interface zza {
        Object zzd(String str, Map<String, Object> map);
    }

    public zzt(zza zzaVar) {
        super(ID, zzaLd);
        this.zzaLe = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String str;
        String strZzg = zzdf.zzg(map.get(zzaLd));
        HashMap map2 = new HashMap();
        zzag.zza zzaVar = map.get(zzaKr);
        if (zzaVar == null) {
            return zzdf.zzI(this.zzaLe.zzd(strZzg, map2));
        }
        Object objZzl = zzdf.zzl(zzaVar);
        if (objZzl instanceof Map) {
            for (Map.Entry entry : ((Map) objZzl).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
            try {
                return zzdf.zzI(this.zzaLe.zzd(strZzg, map2));
            } catch (Exception e) {
                str = "Custom macro/tag " + strZzg + " threw exception " + e.getMessage();
            }
        } else {
            str = "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.";
        }
        zzbg.zzaC(str);
        return zzdf.zzzQ();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
