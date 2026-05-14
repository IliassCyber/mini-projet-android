package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzgd;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zze extends zzfg.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzAE;
    zzh zzAF;
    private zzk zzAH;
    private Context zzAM;
    private zzfe zzAN;
    private zzf zzAO;
    private zzj zzAP;
    private String zzAQ = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzAF = zzh.zzy(this.mActivity.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: all -> 0x003d, RemoteException -> 0x003f, TryCatch #0 {RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:13:0x0029, B:12:0x0022), top: B:23:0x0006, outer: #1 }] */
    @Override // com.google.android.gms.internal.zzfg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r6 != r0) goto L50
            r0 = 0
            r1 = 0
            com.google.android.gms.ads.internal.purchase.zzi r2 = com.google.android.gms.ads.internal.zzo.zzbF()     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            int r2 = r2.zzd(r8)     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            r3 = -1
            if (r7 != r3) goto L22
            com.google.android.gms.ads.internal.zzo.zzbF()     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            if (r2 != 0) goto L22
            com.google.android.gms.ads.internal.purchase.zzk r3 = r5.zzAH     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            java.lang.String r4 = r5.zzAQ     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            boolean r3 = r3.zza(r4, r7, r8)     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            if (r3 == 0) goto L29
            r0 = 1
            goto L29
        L22:
            com.google.android.gms.ads.internal.purchase.zzh r3 = r5.zzAF     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            com.google.android.gms.ads.internal.purchase.zzf r4 = r5.zzAO     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            r3.zza(r4)     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
        L29:
            com.google.android.gms.internal.zzfe r3 = r5.zzAN     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            r3.recordPlayBillingResolution(r2)     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            android.app.Activity r2 = r5.mActivity     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            r2.finish()     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            com.google.android.gms.internal.zzfe r2 = r5.zzAN     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            java.lang.String r2 = r2.getProductId()     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            r5.zza(r2, r0, r7, r8)     // Catch: java.lang.Throwable -> L3d android.os.RemoteException -> L3f
            goto L4a
        L3d:
            r0 = move-exception
            goto L4d
        L3f:
            r0 = move-exception
            java.lang.String r0 = "Fail to process purchase result."
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r0)     // Catch: java.lang.Throwable -> L3d
            android.app.Activity r0 = r5.mActivity     // Catch: java.lang.Throwable -> L3d
            r0.finish()     // Catch: java.lang.Throwable -> L3d
        L4a:
            r5.zzAQ = r1
            goto L50
        L4d:
            r5.zzAQ = r1
            throw r0
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zze.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onCreate() {
        Activity activity;
        int iZzgr;
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelZzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzAP = gInAppPurchaseManagerInfoParcelZzc.zzAA;
        this.zzAH = gInAppPurchaseManagerInfoParcelZzc.zzqe;
        this.zzAN = gInAppPurchaseManagerInfoParcelZzc.zzAy;
        this.zzAE = new zzb(this.mActivity.getApplicationContext());
        this.zzAM = gInAppPurchaseManagerInfoParcelZzc.zzAz;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            activity = this.mActivity;
            iZzgr = zzo.zzbx().zzgq();
        } else {
            activity = this.mActivity;
            iZzgr = zzo.zzbx().zzgr();
        }
        activity.setRequestedOrientation(iZzgr);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzAE.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzAE.zzK(iBinder);
        try {
            this.zzAQ = this.zzAH.zzfi();
            Bundle bundleZzb = this.zzAE.zzb(this.mActivity.getPackageName(), this.zzAN.getProductId(), this.zzAQ);
            PendingIntent pendingIntent = (PendingIntent) bundleZzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int iZzb = zzo.zzbF().zzb(bundleZzb);
                this.zzAN.recordPlayBillingResolution(iZzb);
                zza(this.zzAN.getProductId(), false, iZzb, null);
                this.mActivity.finish();
            } else {
                this.zzAO = new zzf(this.zzAN.getProductId(), this.zzAQ);
                this.zzAF.zzb(this.zzAO);
                Activity activity = this.mActivity;
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intent intent = new Intent();
                Integer num = 0;
                int iIntValue = num.intValue();
                Integer num2 = 0;
                int iIntValue2 = num2.intValue();
                Integer num3 = 0;
                activity.startIntentSenderForResult(intentSender, 1001, intent, iIntValue, iIntValue2, num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        zzj zzjVar = this.zzAP;
        if (zzjVar != null) {
            zzjVar.zza(str, z, i, intent, this.zzAO);
        }
    }
}
