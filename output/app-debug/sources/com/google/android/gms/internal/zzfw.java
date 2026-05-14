package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzfw extends zzfs {
    private zzdw zzBA;
    protected zzec zzBB;
    private zzef zzoq;
    private zzdy zzxn;

    zzfw(Context context, zzha.zza zzaVar, zzid zzidVar, zzef zzefVar, zzft.zza zzaVar2) {
        super(context, zzaVar, zzidVar, zzaVar2);
        this.zzoq = zzefVar;
        this.zzxn = zzaVar.zzFm;
    }

    @Override // com.google.android.gms.internal.zzfs, com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzBr) {
            super.onStop();
            if (this.zzBA != null) {
                this.zzBA.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfs
    protected void zzh(long j) throws zzfs.zza {
        synchronized (this.zzBr) {
            this.zzBA = new zzdw(this.mContext, this.zzBs.zzFr, this.zzoq, this.zzxn);
        }
        this.zzBB = this.zzBA.zza(j, 60000L);
        switch (this.zzBB.zzxY) {
            case 0:
                return;
            case 1:
                throw new zzfs.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzfs.zza("Unexpected mediation result: " + this.zzBB.zzxY, 0);
        }
    }

    @Override // com.google.android.gms.internal.zzfs
    protected zzha zzz(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzBs.zzFr;
        AdRequestParcel adRequestParcel = adRequestInfoParcel.zzCm;
        zzid zzidVar = this.zzoA;
        List<String> list = this.zzBt.zzxF;
        List<String> list2 = this.zzBt.zzxG;
        List<String> list3 = this.zzBt.zzCM;
        int i2 = this.zzBt.orientation;
        long j = this.zzBt.zzxJ;
        String str = adRequestInfoParcel.zzCp;
        boolean z = this.zzBt.zzCK;
        zzec zzecVar = this.zzBB;
        zzdx zzdxVar = zzecVar != null ? zzecVar.zzxZ : null;
        zzec zzecVar2 = this.zzBB;
        zzeg zzegVar = zzecVar2 != null ? zzecVar2.zzya : null;
        zzec zzecVar3 = this.zzBB;
        String name = zzecVar3 != null ? zzecVar3.zzyb : AdMobAdapter.class.getName();
        zzdy zzdyVar = this.zzxn;
        zzec zzecVar4 = this.zzBB;
        return new zzha(adRequestParcel, zzidVar, list, i, list2, list3, i2, j, str, z, zzdxVar, zzegVar, name, zzdyVar, zzecVar4 != null ? zzecVar4.zzyc : null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, adRequestInfoParcel.zzCC);
    }
}
