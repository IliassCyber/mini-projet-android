package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* JADX INFO: loaded from: classes.dex */
public class zze implements RewardItem {
    private final zza zzER;

    public zze(zza zzaVar) {
        this.zzER = zzaVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public int getAmount() {
        zza zzaVar = this.zzER;
        if (zzaVar == null) {
            return 0;
        }
        try {
            return zzaVar.getAmount();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public String getType() {
        zza zzaVar = this.zzER;
        if (zzaVar == null) {
            return null;
        }
        try {
            return zzaVar.getType();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
