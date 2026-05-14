package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzgd;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zza {
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[Catch: ActivityNotFoundException -> 0x00b0, TRY_LEAVE, TryCatch #1 {ActivityNotFoundException -> 0x00b0, blocks: (B:30:0x008f, B:32:0x00ac), top: B:38:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean zza(android.content.Context r7, com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel r8, com.google.android.gms.ads.internal.overlay.zzk r9) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto L9
            java.lang.String r7 = "No intent data for launcher overlay."
        L5:
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r7)
            return r0
        L9:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = r8.zzzf
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L19
            java.lang.String r7 = "Open GMSG did not contain a URL."
            goto L5
        L19:
            java.lang.String r2 = r8.mimeType
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L2d
            java.lang.String r2 = r8.zzzf
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r3 = r8.mimeType
            r1.setDataAndType(r2, r3)
            goto L36
        L2d:
            java.lang.String r2 = r8.zzzf
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r1.setData(r2)
        L36:
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.setAction(r2)
            java.lang.String r2 = r8.packageName
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L48
            java.lang.String r2 = r8.packageName
            r1.setPackage(r2)
        L48:
            java.lang.String r2 = r8.zzzg
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            if (r2 != 0) goto L78
            java.lang.String r2 = r8.zzzg
            java.lang.String r4 = "/"
            r5 = 2
            java.lang.String[] r2 = r2.split(r4, r5)
            int r4 = r2.length
            if (r4 >= r5) goto L71
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Could not parse component name from open GMSG: "
            r7.append(r9)
            java.lang.String r8 = r8.zzzg
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L5
        L71:
            r4 = r2[r0]
            r2 = r2[r3]
            r1.setClassName(r4, r2)
        L78:
            java.lang.String r8 = r8.zzzh
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L8f
            int r8 = java.lang.Integer.parseInt(r8)     // Catch: java.lang.NumberFormatException -> L85
            goto L8c
        L85:
            r8 = move-exception
            java.lang.String r8 = "Could not parse intent flags."
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r8)
            r8 = 0
        L8c:
            r1.addFlags(r8)
        L8f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: android.content.ActivityNotFoundException -> Lb0
            r8.<init>()     // Catch: android.content.ActivityNotFoundException -> Lb0
            java.lang.String r2 = "Launching an intent: "
            r8.append(r2)     // Catch: android.content.ActivityNotFoundException -> Lb0
            java.lang.String r2 = r1.toURI()     // Catch: android.content.ActivityNotFoundException -> Lb0
            r8.append(r2)     // Catch: android.content.ActivityNotFoundException -> Lb0
            java.lang.String r8 = r8.toString()     // Catch: android.content.ActivityNotFoundException -> Lb0
            com.google.android.gms.ads.internal.util.client.zzb.zzaB(r8)     // Catch: android.content.ActivityNotFoundException -> Lb0
            r7.startActivity(r1)     // Catch: android.content.ActivityNotFoundException -> Lb0
            if (r9 == 0) goto Laf
            r9.zzaO()     // Catch: android.content.ActivityNotFoundException -> Lb0
        Laf:
            return r3
        Lb0:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zza.zza(android.content.Context, com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel, com.google.android.gms.ads.internal.overlay.zzk):boolean");
    }
}
