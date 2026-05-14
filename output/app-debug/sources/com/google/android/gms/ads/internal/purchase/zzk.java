package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzgd;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzk {
    private final String zzsU;

    public zzk(String str) {
        this.zzsU = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        String str2;
        if (str != null && intent != null) {
            String strZze = zzo.zzbF().zze(intent);
            String strZzf = zzo.zzbF().zzf(intent);
            if (strZze != null && strZzf != null) {
                if (str.equals(zzo.zzbF().zzai(strZze))) {
                    String str3 = this.zzsU;
                    if (str3 == null || zzl.zzc(str3, strZze, strZzf)) {
                        return true;
                    }
                    str2 = "Fail to verify signature.";
                } else {
                    str2 = "Developer payload not match.";
                }
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(str2);
                return false;
            }
        }
        return false;
    }

    public String zzfi() {
        return zzo.zzbv().zzgn();
    }
}
