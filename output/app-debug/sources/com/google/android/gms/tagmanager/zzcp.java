package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzm;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzcp {
    private static final zzbw<zzag.zza> zzaNe = new zzbw<>(zzdf.zzzQ(), true);
    private final DataLayer zzaKz;
    private final zzqf.zzc zzaNf;
    private final zzah zzaNg;
    private final Map<String, zzak> zzaNh;
    private final Map<String, zzak> zzaNi;
    private final Map<String, zzak> zzaNj;
    private final zzl<zzqf.zza, zzbw<zzag.zza>> zzaNk;
    private final zzl<String, zzb> zzaNl;
    private final Set<zzqf.zze> zzaNm;
    private final Map<String, zzc> zzaNn;
    private volatile String zzaNo;
    private int zzaNp;

    interface zza {
        void zza(zzqf.zze zzeVar, Set<zzqf.zza> set, Set<zzqf.zza> set2, zzck zzckVar);
    }

    private static class zzb {
        private zzbw<zzag.zza> zzaNv;
        private zzag.zza zzaNw;

        public zzb(zzbw<zzag.zza> zzbwVar, zzag.zza zzaVar) {
            this.zzaNv = zzbwVar;
            this.zzaNw = zzaVar;
        }

        public int getSize() {
            int iZzBU = this.zzaNv.getObject().zzBU();
            zzag.zza zzaVar = this.zzaNw;
            return iZzBU + (zzaVar == null ? 0 : zzaVar.zzBU());
        }

        public zzbw<zzag.zza> zzzr() {
            return this.zzaNv;
        }

        public zzag.zza zzzs() {
            return this.zzaNw;
        }
    }

    private static class zzc {
        private zzqf.zza zzaNB;
        private final Set<zzqf.zze> zzaNm = new HashSet();
        private final Map<zzqf.zze, List<zzqf.zza>> zzaNx = new HashMap();
        private final Map<zzqf.zze, List<String>> zzaNz = new HashMap();
        private final Map<zzqf.zze, List<zzqf.zza>> zzaNy = new HashMap();
        private final Map<zzqf.zze, List<String>> zzaNA = new HashMap();

        public void zza(zzqf.zze zzeVar) {
            this.zzaNm.add(zzeVar);
        }

        public void zza(zzqf.zze zzeVar, zzqf.zza zzaVar) {
            List<zzqf.zza> arrayList = this.zzaNx.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzaNx.put(zzeVar, arrayList);
            }
            arrayList.add(zzaVar);
        }

        public void zza(zzqf.zze zzeVar, String str) {
            List<String> arrayList = this.zzaNz.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzaNz.put(zzeVar, arrayList);
            }
            arrayList.add(str);
        }

        public void zzb(zzqf.zza zzaVar) {
            this.zzaNB = zzaVar;
        }

        public void zzb(zzqf.zze zzeVar, zzqf.zza zzaVar) {
            List<zzqf.zza> arrayList = this.zzaNy.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzaNy.put(zzeVar, arrayList);
            }
            arrayList.add(zzaVar);
        }

        public void zzb(zzqf.zze zzeVar, String str) {
            List<String> arrayList = this.zzaNA.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzaNA.put(zzeVar, arrayList);
            }
            arrayList.add(str);
        }

        public Set<zzqf.zze> zzzt() {
            return this.zzaNm;
        }

        public Map<zzqf.zze, List<zzqf.zza>> zzzu() {
            return this.zzaNx;
        }

        public Map<zzqf.zze, List<String>> zzzv() {
            return this.zzaNz;
        }

        public Map<zzqf.zze, List<String>> zzzw() {
            return this.zzaNA;
        }

        public Map<zzqf.zze, List<zzqf.zza>> zzzx() {
            return this.zzaNy;
        }

        public zzqf.zza zzzy() {
            return this.zzaNB;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcp(Context context, zzqf.zzc zzcVar, DataLayer dataLayer, zzt.zza zzaVar, zzt.zza zzaVar2, zzah zzahVar) {
        if (zzcVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzaNf = zzcVar;
        this.zzaNm = new HashSet(zzcVar.zzAq());
        this.zzaKz = dataLayer;
        this.zzaNg = zzahVar;
        this.zzaNk = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new zzm.zza<zzqf.zza, zzbw<zzag.zza>>() { // from class: com.google.android.gms.tagmanager.zzcp.1
            @Override // com.google.android.gms.tagmanager.zzm.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int sizeOf(zzqf.zza zzaVar3, zzbw<zzag.zza> zzbwVar) {
                return zzbwVar.getObject().zzBU();
            }
        });
        this.zzaNl = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new zzm.zza<String, zzb>() { // from class: com.google.android.gms.tagmanager.zzcp.2
            @Override // com.google.android.gms.tagmanager.zzm.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, zzb zzbVar) {
                return str.length() + zzbVar.getSize();
            }
        });
        this.zzaNh = new HashMap();
        zzb(new zzj(context));
        zzb(new zzt(zzaVar2));
        zzb(new zzx(dataLayer));
        zzb(new zzdg(context, dataLayer));
        zzb(new zzdb(context, dataLayer));
        this.zzaNi = new HashMap();
        zzc(new zzr());
        zzc(new zzae());
        zzc(new zzaf());
        zzc(new zzam());
        zzc(new zzan());
        zzc(new zzbc());
        zzc(new zzbd());
        zzc(new zzcf());
        zzc(new zzcy());
        this.zzaNj = new HashMap();
        zza(new com.google.android.gms.tagmanager.zzb(context));
        zza(new com.google.android.gms.tagmanager.zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzn());
        zza(new zzq(this.zzaNf.getVersion()));
        zza(new zzt(zzaVar));
        zza(new zzv(dataLayer));
        zza(new zzaa(context));
        zza(new zzab());
        zza(new zzad());
        zza(new zzai(this));
        zza(new zzao());
        zza(new zzap());
        zza(new zzaw(context));
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbi());
        zza(new zzbk(context));
        zza(new zzbx());
        zza(new zzbz());
        zza(new zzcc());
        zza(new zzce());
        zza(new zzcg(context));
        zza(new zzcq());
        zza(new zzcr());
        zza(new zzda());
        zza(new zzdh());
        this.zzaNn = new HashMap();
        for (zzqf.zze zzeVar : this.zzaNm) {
            if (zzahVar.zzyL()) {
                zza(zzeVar.zzAy(), zzeVar.zzAz(), "add macro");
                zza(zzeVar.zzAD(), zzeVar.zzAA(), "remove macro");
                zza(zzeVar.zzAw(), zzeVar.zzAB(), "add tag");
                zza(zzeVar.zzAx(), zzeVar.zzAC(), "remove tag");
            }
            for (int i = 0; i < zzeVar.zzAy().size(); i++) {
                zzqf.zza zzaVar3 = zzeVar.zzAy().get(i);
                String str = "Unknown";
                if (zzahVar.zzyL() && i < zzeVar.zzAz().size()) {
                    str = zzeVar.zzAz().get(i);
                }
                zzc zzcVarZzh = zzh(this.zzaNn, zza(zzaVar3));
                zzcVarZzh.zza(zzeVar);
                zzcVarZzh.zza(zzeVar, zzaVar3);
                zzcVarZzh.zza(zzeVar, str);
            }
            for (int i2 = 0; i2 < zzeVar.zzAD().size(); i2++) {
                zzqf.zza zzaVar4 = zzeVar.zzAD().get(i2);
                String str2 = "Unknown";
                if (zzahVar.zzyL() && i2 < zzeVar.zzAA().size()) {
                    str2 = zzeVar.zzAA().get(i2);
                }
                zzc zzcVarZzh2 = zzh(this.zzaNn, zza(zzaVar4));
                zzcVarZzh2.zza(zzeVar);
                zzcVarZzh2.zzb(zzeVar, zzaVar4);
                zzcVarZzh2.zzb(zzeVar, str2);
            }
        }
        for (Map.Entry<String, List<zzqf.zza>> entry : this.zzaNf.zzAr().entrySet()) {
            for (zzqf.zza zzaVar5 : entry.getValue()) {
                if (!zzdf.zzk(zzaVar5.zzAn().get(com.google.android.gms.internal.zzae.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzh(this.zzaNn, entry.getKey()).zzb(zzaVar5);
                }
            }
        }
    }

    private zzbw<zzag.zza> zza(zzag.zza zzaVar, Set<String> set, zzdi zzdiVar) {
        if (!zzaVar.zzjb) {
            return new zzbw<>(zzaVar, true);
        }
        int i = zzaVar.type;
        if (i == 7) {
            zzag.zza zzaVarZzo = zzqf.zzo(zzaVar);
            zzaVarZzo.zziZ = new zzag.zza[zzaVar.zziZ.length];
            for (int i2 = 0; i2 < zzaVar.zziZ.length; i2++) {
                zzbw<zzag.zza> zzbwVarZza = zza(zzaVar.zziZ[i2], set, zzdiVar.zziX(i2));
                zzbw<zzag.zza> zzbwVar = zzaNe;
                if (zzbwVarZza == zzbwVar) {
                    return zzbwVar;
                }
                zzaVarZzo.zziZ[i2] = zzbwVarZza.getObject();
            }
            return new zzbw<>(zzaVarZzo, false);
        }
        switch (i) {
            case 2:
                zzag.zza zzaVarZzo2 = zzqf.zzo(zzaVar);
                zzaVarZzo2.zziS = new zzag.zza[zzaVar.zziS.length];
                for (int i3 = 0; i3 < zzaVar.zziS.length; i3++) {
                    zzbw<zzag.zza> zzbwVarZza2 = zza(zzaVar.zziS[i3], set, zzdiVar.zziU(i3));
                    zzbw<zzag.zza> zzbwVar2 = zzaNe;
                    if (zzbwVarZza2 == zzbwVar2) {
                        return zzbwVar2;
                    }
                    zzaVarZzo2.zziS[i3] = zzbwVarZza2.getObject();
                }
                return new zzbw<>(zzaVarZzo2, false);
            case 3:
                zzag.zza zzaVarZzo3 = zzqf.zzo(zzaVar);
                if (zzaVar.zziT.length != zzaVar.zziU.length) {
                    zzbg.zzaz("Invalid serving value: " + zzaVar.toString());
                    return zzaNe;
                }
                zzaVarZzo3.zziT = new zzag.zza[zzaVar.zziT.length];
                zzaVarZzo3.zziU = new zzag.zza[zzaVar.zziT.length];
                for (int i4 = 0; i4 < zzaVar.zziT.length; i4++) {
                    zzbw<zzag.zza> zzbwVarZza3 = zza(zzaVar.zziT[i4], set, zzdiVar.zziV(i4));
                    zzbw<zzag.zza> zzbwVarZza4 = zza(zzaVar.zziU[i4], set, zzdiVar.zziW(i4));
                    zzbw<zzag.zza> zzbwVar3 = zzaNe;
                    if (zzbwVarZza3 == zzbwVar3 || zzbwVarZza4 == zzbwVar3) {
                        return zzaNe;
                    }
                    zzaVarZzo3.zziT[i4] = zzbwVarZza3.getObject();
                    zzaVarZzo3.zziU[i4] = zzbwVarZza4.getObject();
                }
                return new zzbw<>(zzaVarZzo3, false);
            case 4:
                if (!set.contains(zzaVar.zziV)) {
                    set.add(zzaVar.zziV);
                    zzbw<zzag.zza> zzbwVarZza5 = zzdj.zza(zza(zzaVar.zziV, set, zzdiVar.zzyZ()), zzaVar.zzja);
                    set.remove(zzaVar.zziV);
                    return zzbwVarZza5;
                }
                zzbg.zzaz("Macro cycle detected.  Current macro reference: " + zzaVar.zziV + ".  Previous macro references: " + set.toString() + ".");
                return zzaNe;
            default:
                zzbg.zzaz("Unknown type: " + zzaVar.type);
                return zzaNe;
        }
    }

    private zzbw<zzag.zza> zza(String str, Set<String> set, zzbj zzbjVar) {
        zzqf.zza next;
        this.zzaNp++;
        zzb zzbVar = this.zzaNl.get(str);
        if (zzbVar != null && !this.zzaNg.zzyL()) {
            zza(zzbVar.zzzs(), set);
            this.zzaNp--;
            return zzbVar.zzzr();
        }
        zzc zzcVar = this.zzaNn.get(str);
        if (zzcVar == null) {
            zzbg.zzaz(zzzq() + "Invalid macro: " + str);
            this.zzaNp = this.zzaNp - 1;
            return zzaNe;
        }
        zzbw<Set<zzqf.zza>> zzbwVarZza = zza(str, zzcVar.zzzt(), zzcVar.zzzu(), zzcVar.zzzv(), zzcVar.zzzx(), zzcVar.zzzw(), set, zzbjVar.zzyB());
        if (zzbwVarZza.getObject().isEmpty()) {
            next = zzcVar.zzzy();
        } else {
            if (zzbwVarZza.getObject().size() > 1) {
                zzbg.zzaC(zzzq() + "Multiple macros active for macroName " + str);
            }
            next = zzbwVarZza.getObject().iterator().next();
        }
        if (next == null) {
            this.zzaNp--;
            return zzaNe;
        }
        zzbw<zzag.zza> zzbwVarZza2 = zza(this.zzaNj, next, set, zzbjVar.zzyR());
        boolean z = zzbwVarZza.zzza() && zzbwVarZza2.zzza();
        zzbw<zzag.zza> zzbwVar = zzaNe;
        if (zzbwVarZza2 != zzbwVar) {
            zzbwVar = new zzbw<>(zzbwVarZza2.getObject(), z);
        }
        zzag.zza zzaVarZzzs = next.zzzs();
        if (zzbwVar.zzza()) {
            this.zzaNl.zzf(str, new zzb(zzbwVar, zzaVarZzzs));
        }
        zza(zzaVarZzzs, set);
        this.zzaNp--;
        return zzbwVar;
    }

    private zzbw<zzag.zza> zza(Map<String, zzak> map, zzqf.zza zzaVar, Set<String> set, zzch zzchVar) {
        String str;
        zzag.zza zzaVar2 = zzaVar.zzAn().get(com.google.android.gms.internal.zzae.FUNCTION.toString());
        if (zzaVar2 == null) {
            str = "No function id in properties";
        } else {
            String str2 = zzaVar2.zziW;
            zzak zzakVar = map.get(str2);
            if (zzakVar == null) {
                str = str2 + " has no backing implementation.";
            } else {
                zzbw<zzag.zza> zzbwVar = this.zzaNk.get(zzaVar);
                if (zzbwVar != null && !this.zzaNg.zzyL()) {
                    return zzbwVar;
                }
                HashMap map2 = new HashMap();
                boolean z = true;
                for (Map.Entry<String, zzag.zza> entry : zzaVar.zzAn().entrySet()) {
                    zzbw<zzag.zza> zzbwVarZza = zza(entry.getValue(), set, zzchVar.zzez(entry.getKey()).zze(entry.getValue()));
                    zzbw<zzag.zza> zzbwVar2 = zzaNe;
                    if (zzbwVarZza == zzbwVar2) {
                        return zzbwVar2;
                    }
                    if (zzbwVarZza.zzza()) {
                        zzaVar.zza(entry.getKey(), zzbwVarZza.getObject());
                    } else {
                        z = false;
                    }
                    map2.put(entry.getKey(), zzbwVarZza.getObject());
                }
                if (zzakVar.zzg(map2.keySet())) {
                    boolean z2 = z && zzakVar.zzyh();
                    zzbw<zzag.zza> zzbwVar3 = new zzbw<>(zzakVar.zzE(map2), z2);
                    if (z2) {
                        this.zzaNk.zzf(zzaVar, zzbwVar3);
                    }
                    zzchVar.zzd(zzbwVar3.getObject());
                    return zzbwVar3;
                }
                str = "Incorrect keys for function " + str2 + " required " + zzakVar.zzyN() + " had " + map2.keySet();
            }
        }
        zzbg.zzaz(str);
        return zzaNe;
    }

    private zzbw<Set<zzqf.zza>> zza(Set<zzqf.zze> set, Set<String> set2, zza zzaVar, zzco zzcoVar) {
        boolean z;
        Set<zzqf.zza> hashSet = new HashSet<>();
        Set<zzqf.zza> hashSet2 = new HashSet<>();
        while (true) {
            for (zzqf.zze zzeVar : set) {
                zzck zzckVarZzyY = zzcoVar.zzyY();
                zzbw<Boolean> zzbwVarZza = zza(zzeVar, set2, zzckVarZzyY);
                if (zzbwVarZza.getObject().booleanValue()) {
                    zzaVar.zza(zzeVar, hashSet, hashSet2, zzckVarZzyY);
                }
                z = z && zzbwVarZza.zzza();
            }
            hashSet.removeAll(hashSet2);
            zzcoVar.zzh(hashSet);
            return new zzbw<>(hashSet, z);
        }
    }

    private static String zza(zzqf.zza zzaVar) {
        return zzdf.zzg(zzaVar.zzAn().get(com.google.android.gms.internal.zzae.INSTANCE_NAME.toString()));
    }

    private void zza(zzag.zza zzaVar, Set<String> set) {
        zzbw<zzag.zza> zzbwVarZza;
        if (zzaVar == null || (zzbwVarZza = zza(zzaVar, set, new zzbu())) == zzaNe) {
            return;
        }
        Object objZzl = zzdf.zzl(zzbwVarZza.getObject());
        if (objZzl instanceof Map) {
            this.zzaKz.push((Map) objZzl);
            return;
        }
        if (!(objZzl instanceof List)) {
            zzbg.zzaC("pushAfterEvaluate: value not a Map or List");
            return;
        }
        for (Object obj : (List) objZzl) {
            if (obj instanceof Map) {
                this.zzaKz.push((Map) obj);
            } else {
                zzbg.zzaC("pushAfterEvaluate: value not a Map");
            }
        }
    }

    private static void zza(List<zzqf.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbg.zzaA("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzak> map, zzak zzakVar) {
        if (!map.containsKey(zzakVar.zzyM())) {
            map.put(zzakVar.zzyM(), zzakVar);
            return;
        }
        throw new IllegalArgumentException("Duplicate function type name: " + zzakVar.zzyM());
    }

    private static zzc zzh(Map<String, zzc> map, String str) {
        zzc zzcVar = map.get(str);
        if (zzcVar != null) {
            return zzcVar;
        }
        zzc zzcVar2 = new zzc();
        map.put(str, zzcVar2);
        return zzcVar2;
    }

    private String zzzq() {
        if (this.zzaNp <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzaNp));
        for (int i = 2; i < this.zzaNp; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    zzbw<Boolean> zza(zzqf.zza zzaVar, Set<String> set, zzch zzchVar) {
        zzbw<zzag.zza> zzbwVarZza = zza(this.zzaNi, zzaVar, set, zzchVar);
        Boolean boolZzk = zzdf.zzk(zzbwVarZza.getObject());
        zzchVar.zzd(zzdf.zzI(boolZzk));
        return new zzbw<>(boolZzk, zzbwVarZza.zzza());
    }

    zzbw<Boolean> zza(zzqf.zze zzeVar, Set<String> set, zzck zzckVar) {
        boolean z;
        Iterator<zzqf.zza> it = zzeVar.zzAv().iterator();
        while (true) {
            while (it.hasNext()) {
                zzbw<Boolean> zzbwVarZza = zza(it.next(), set, zzckVar.zzyS());
                if (zzbwVarZza.getObject().booleanValue()) {
                    zzckVar.zzf(zzdf.zzI(false));
                    return new zzbw<>(false, zzbwVarZza.zzza());
                }
                z = z && zzbwVarZza.zzza();
            }
            Iterator<zzqf.zza> it2 = zzeVar.zzAu().iterator();
            while (it2.hasNext()) {
                zzbw<Boolean> zzbwVarZza2 = zza(it2.next(), set, zzckVar.zzyT());
                if (!zzbwVarZza2.getObject().booleanValue()) {
                    zzckVar.zzf(zzdf.zzI(false));
                    return new zzbw<>(false, zzbwVarZza2.zzza());
                }
                z = z && zzbwVarZza2.zzza();
            }
            zzckVar.zzf(zzdf.zzI(true));
            return new zzbw<>(true, z);
        }
    }

    zzbw<Set<zzqf.zza>> zza(String str, Set<zzqf.zze> set, final Map<zzqf.zze, List<zzqf.zza>> map, final Map<zzqf.zze, List<String>> map2, final Map<zzqf.zze, List<zzqf.zza>> map3, final Map<zzqf.zze, List<String>> map4, Set<String> set2, zzco zzcoVar) {
        return zza(set, set2, new zza() { // from class: com.google.android.gms.tagmanager.zzcp.3
            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzqf.zze zzeVar, Set<zzqf.zza> set3, Set<zzqf.zza> set4, zzck zzckVar) {
                List<zzqf.zza> list = (List) map.get(zzeVar);
                List<String> list2 = (List) map2.get(zzeVar);
                if (list != null) {
                    set3.addAll(list);
                    zzckVar.zzyU().zzc(list, list2);
                }
                List<zzqf.zza> list3 = (List) map3.get(zzeVar);
                List<String> list4 = (List) map4.get(zzeVar);
                if (list3 != null) {
                    set4.addAll(list3);
                    zzckVar.zzyV().zzc(list3, list4);
                }
            }
        }, zzcoVar);
    }

    zzbw<Set<zzqf.zza>> zza(Set<zzqf.zze> set, zzco zzcoVar) {
        return zza(set, new HashSet(), new zza() { // from class: com.google.android.gms.tagmanager.zzcp.4
            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzqf.zze zzeVar, Set<zzqf.zza> set2, Set<zzqf.zza> set3, zzck zzckVar) {
                set2.addAll(zzeVar.zzAw());
                set3.addAll(zzeVar.zzAx());
                zzckVar.zzyW().zzc(zzeVar.zzAw(), zzeVar.zzAB());
                zzckVar.zzyX().zzc(zzeVar.zzAx(), zzeVar.zzAC());
            }
        }, zzcoVar);
    }

    void zza(zzak zzakVar) {
        zza(this.zzaNj, zzakVar);
    }

    void zzb(zzak zzakVar) {
        zza(this.zzaNh, zzakVar);
    }

    void zzc(zzak zzakVar) {
        zza(this.zzaNi, zzakVar);
    }

    public zzbw<zzag.zza> zzeD(String str) {
        this.zzaNp = 0;
        zzag zzagVarZzet = this.zzaNg.zzet(str);
        zzbw<zzag.zza> zzbwVarZza = zza(str, new HashSet(), zzagVarZzet.zzyI());
        zzagVarZzet.zzyK();
        return zzbwVarZza;
    }

    synchronized void zzeE(String str) {
        this.zzaNo = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void zzeh(String str) {
        zzeE(str);
        zzag zzagVarZzeu = this.zzaNg.zzeu(str);
        zzu zzuVarZzyJ = zzagVarZzeu.zzyJ();
        Iterator<zzqf.zza> it = zza(this.zzaNm, zzuVarZzyJ.zzyB()).getObject().iterator();
        while (it.hasNext()) {
            zza(this.zzaNh, it.next(), new HashSet(), zzuVarZzyJ.zzyA());
        }
        zzagVarZzeu.zzyK();
        zzeE(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void zzs(List<zzaf.zzi> list) {
        for (zzaf.zzi zziVar : list) {
            if (zziVar.name == null || !zziVar.name.startsWith("gaExperiment:")) {
                zzbg.zzaB("Ignored supplemental: " + zziVar);
            } else {
                zzaj.zza(this.zzaKz, zziVar);
            }
        }
    }

    synchronized String zzzp() {
        return this.zzaNo;
    }
}
