package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzgt extends zza.AbstractBinderC0023zza {
    private zzgu zzEW;
    private zzgr zzFc;
    private zzgs zzFd;

    public zzgt(zzgs zzgsVar) {
        this.zzFd = zzgsVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, RewardItemParcel rewardItemParcel) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.zza(rewardItemParcel);
        }
    }

    public void zza(zzgr zzgrVar) {
        this.zzFc = zzgrVar;
    }

    public void zza(zzgu zzguVar) {
        this.zzEW = zzguVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        zzgr zzgrVar = this.zzFc;
        if (zzgrVar != null) {
            zzgrVar.zzI(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        zzgu zzguVar = this.zzEW;
        if (zzguVar != null) {
            zzguVar.zzb(com.google.android.gms.dynamic.zze.zzn(zzdVar).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zze(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgr zzgrVar = this.zzFc;
        if (zzgrVar != null) {
            zzgrVar.zzfO();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzf(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgu zzguVar = this.zzEW;
        if (zzguVar != null) {
            zzguVar.zzap(com.google.android.gms.dynamic.zze.zzn(zzdVar).getClass().getName());
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzg(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzh(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzi(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzj(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.zzfL();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzk(com.google.android.gms.dynamic.zzd zzdVar) {
        zzgs zzgsVar = this.zzFd;
        if (zzgsVar != null) {
            zzgsVar.onRewardedVideoAdLeftApplication();
        }
    }
}
