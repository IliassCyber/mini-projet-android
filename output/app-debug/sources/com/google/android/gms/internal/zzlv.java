package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzlv {
    private static int zzakU = -1;

    public static boolean zzam(Context context) {
        return zzap(context) == 3;
    }

    private static int zzan(Context context) {
        return ((zzao(context) % 1000) / 100) + 5;
    }

    private static int zzao(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzap(android.content.Context r2) {
        /*
            int r0 = com.google.android.gms.internal.zzlv.zzakU
            r1 = -1
            if (r0 != r1) goto L24
            int r0 = zzan(r2)
            r1 = 8
            if (r0 == r1) goto L21
            r1 = 10
            if (r0 == r1) goto L1f
            r1 = 13
            if (r0 == r1) goto L21
            boolean r2 = zzaq(r2)
            if (r2 == 0) goto L1d
            r2 = 1
            goto L22
        L1d:
            r2 = 2
            goto L22
        L1f:
            r2 = 3
            goto L22
        L21:
            r2 = 0
        L22:
            com.google.android.gms.internal.zzlv.zzakU = r2
        L24:
            int r2 = com.google.android.gms.internal.zzlv.zzakU
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlv.zzap(android.content.Context):int");
    }

    private static boolean zzaq(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }
}
