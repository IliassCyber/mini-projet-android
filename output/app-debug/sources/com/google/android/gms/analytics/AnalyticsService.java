package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzu;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsService extends Service {
    private static Boolean zzIe;
    private final Handler mHandler = new Handler();

    public static boolean zzU(Context context) {
        zzu.zzu(context);
        Boolean bool = zzIe;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zZza = zzam.zza(context, (Class<? extends Service>) AnalyticsService.class);
        zzIe = Boolean.valueOf(zZza);
        return zZza;
    }

    private void zzhd() {
        try {
            synchronized (AnalyticsReceiver.zzoW) {
                PowerManager.WakeLock wakeLock = AnalyticsReceiver.zzIc;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzf zzfVarZzV = zzf.zzV(this);
        zzfVarZzV.zzhQ().zzaT(zzfVarZzV.zzhR().zziW() ? "Device AnalyticsService is starting up" : "Local AnalyticsService is starting up");
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzf zzfVarZzV = zzf.zzV(this);
        zzfVarZzV.zzhQ().zzaT(zzfVarZzV.zzhR().zziW() ? "Device AnalyticsService is shutting down" : "Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        zzhd();
        final zzf zzfVarZzV = zzf.zzV(this);
        final zzaf zzafVarZzhQ = zzfVarZzV.zzhQ();
        String action = intent.getAction();
        zzafVarZzhQ.zza(zzfVarZzV.zzhR().zziW() ? "Device AnalyticsService called. startId, action" : "Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzfVarZzV.zzhl().zza(new zzw() { // from class: com.google.android.gms.analytics.AnalyticsService.1
                @Override // com.google.android.gms.analytics.internal.zzw
                public void zzc(Throwable th) {
                    AnalyticsService.this.mHandler.post(new Runnable() { // from class: com.google.android.gms.analytics.AnalyticsService.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zzaf zzafVar;
                            String str;
                            if (AnalyticsService.this.stopSelfResult(i2)) {
                                if (zzfVarZzV.zzhR().zziW()) {
                                    zzafVar = zzafVarZzhQ;
                                    str = "Device AnalyticsService processed last dispatch request";
                                } else {
                                    zzafVar = zzafVarZzhQ;
                                    str = "Local AnalyticsService processed last dispatch request";
                                }
                                zzafVar.zzaT(str);
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
