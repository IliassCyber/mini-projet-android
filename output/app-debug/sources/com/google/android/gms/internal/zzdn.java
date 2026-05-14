package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzdn implements zzdg {
    private final com.google.android.gms.ads.internal.zzd zzww;
    private final zzep zzwx;
    private final zzdi zzwz;

    public zzdn(zzdi zzdiVar, com.google.android.gms.ads.internal.zzd zzdVar, zzep zzepVar) {
        this.zzwz = zzdiVar;
        this.zzww = zzdVar;
        this.zzwx = zzepVar;
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return com.google.android.gms.ads.internal.zzo.zzbx().zzgr();
        }
        if ("l".equalsIgnoreCase(str)) {
            return com.google.android.gms.ads.internal.zzo.zzbx().zzgq();
        }
        if ("c".equalsIgnoreCase(str)) {
            return com.google.android.gms.ads.internal.zzo.zzbx().zzgs();
        }
        return -1;
    }

    private void zzm(boolean z) {
        zzep zzepVar = this.zzwx;
        if (zzepVar != null) {
            zzepVar.zzn(z);
        }
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzidVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzd zzdVar = this.zzww;
        if (zzdVar != null && !zzdVar.zzbd()) {
            this.zzww.zzo(map.get("u"));
            return;
        }
        zzie zzieVarZzgF = zzidVar.zzgF();
        if ("expand".equalsIgnoreCase(str)) {
            if (zzidVar.zzgJ()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzm(false);
                zzieVarZzgF.zza(zzd(map), zze(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            zzm(false);
            if (str2 != null) {
                zzieVarZzgF.zza(zzd(map), zze(map), str2);
                return;
            } else {
                zzieVarZzgF.zza(zzd(map), zze(map), map.get("html"), map.get("baseurl"));
                return;
            }
        }
        if (!"in_app_purchase".equalsIgnoreCase(str)) {
            zzm(true);
            zzidVar.zzgH();
            String strZza = map.get("u");
            if (!TextUtils.isEmpty(strZza)) {
                strZza = com.google.android.gms.ads.internal.zzo.zzbv().zza(zzidVar, strZza);
            }
            zzieVarZzgF.zza(new AdLauncherIntentInfoParcel(map.get("i"), strZza, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            return;
        }
        String str3 = map.get("product_id");
        String str4 = map.get("report_urls");
        if (this.zzwz == null) {
            return;
        }
        if (str4 == null || str4.isEmpty()) {
            this.zzwz.zza(str3, new ArrayList<>());
        } else {
            this.zzwz.zza(str3, new ArrayList<>(Arrays.asList(str4.split(" "))));
        }
    }
}
