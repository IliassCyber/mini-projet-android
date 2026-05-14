package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends zzi<zza> {
    private final String zzMZ;
    private final zzd zzaGW;
    private final zzb zzaGX;
    private boolean zzaGY;
    private final Object zzqt;

    public zzf(Context context, Looper looper, zzd zzdVar, com.google.android.gms.common.internal.zze zzeVar) {
        super(context, looper, 24, zzdVar, zzdVar, zzeVar);
        this.zzMZ = context.getPackageName();
        this.zzaGW = (zzd) zzu.zzu(zzdVar);
        this.zzaGW.zza(this);
        this.zzaGX = new zzb();
        this.zzqt = new Object();
        this.zzaGY = true;
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaGX.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        String str;
        String str2;
        try {
            zzxp();
            zznM().zza(this.zzMZ, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            str = "PlayLoggerImpl";
            str2 = "Couldn't send log event.  Will try caching.";
            Log.e(str, str2);
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            str = "PlayLoggerImpl";
            str2 = "Service was disconnected.  Will try caching.";
            Log.e(str, str2);
            zzc(playLoggerContext, logEvent);
        }
    }

    private void zzxp() {
        LogEvent logEvent;
        com.google.android.gms.common.internal.zzb.zzU(!this.zzaGY);
        if (this.zzaGX.isEmpty()) {
            return;
        }
        PlayLoggerContext playLoggerContext = null;
        try {
            ArrayList arrayList = new ArrayList();
            for (zzb.zza zzaVar : this.zzaGX.zzxn()) {
                if (zzaVar.zzaGM != null) {
                    zznM().zza(this.zzMZ, zzaVar.zzaGK, zzrn.zzf(zzaVar.zzaGM));
                } else {
                    if (zzaVar.zzaGK.equals(playLoggerContext)) {
                        logEvent = zzaVar.zzaGL;
                    } else {
                        if (!arrayList.isEmpty()) {
                            zznM().zza(this.zzMZ, playLoggerContext, arrayList);
                            arrayList.clear();
                        }
                        playLoggerContext = zzaVar.zzaGK;
                        logEvent = zzaVar.zzaGL;
                    }
                    arrayList.add(logEvent);
                }
            }
            if (!arrayList.isEmpty()) {
                zznM().zza(this.zzMZ, playLoggerContext, arrayList);
            }
            this.zzaGX.clear();
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getServiceDescriptor() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getStartServiceAction() {
        return "com.google.android.gms.playlog.service.START";
    }

    public void start() {
        synchronized (this.zzqt) {
            if (!isConnecting() && !isConnected()) {
                this.zzaGW.zzaj(true);
                zznJ();
            }
        }
    }

    public void stop() {
        synchronized (this.zzqt) {
            this.zzaGW.zzaj(false);
            disconnect();
        }
    }

    void zzak(boolean z) {
        synchronized (this.zzqt) {
            boolean z2 = this.zzaGY;
            this.zzaGY = z;
            if (z2 && !this.zzaGY) {
                zzxp();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzqt) {
            if (this.zzaGY) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    /* JADX INFO: renamed from: zzdq, reason: merged with bridge method [inline-methods] */
    public zza zzT(IBinder iBinder) {
        return zza.AbstractBinderC0228zza.zzdp(iBinder);
    }
}
