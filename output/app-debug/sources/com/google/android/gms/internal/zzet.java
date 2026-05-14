package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzes;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzet extends zzeu {
    private final Context mContext;
    private final zzid zzoA;
    private final WindowManager zzqF;
    private final zzbq zzyT;
    DisplayMetrics zzyU;
    private float zzyV;
    int zzyW;
    int zzyX;
    private int zzyY;
    int zzyZ;
    int zzza;
    int zzzb;
    int zzzc;

    public zzet(zzid zzidVar, Context context, zzbq zzbqVar) {
        super(zzidVar);
        this.zzyW = -1;
        this.zzyX = -1;
        this.zzyZ = -1;
        this.zzza = -1;
        this.zzzb = -1;
        this.zzzc = -1;
        this.zzoA = zzidVar;
        this.mContext = context;
        this.zzyT = zzbqVar;
        this.zzqF = (WindowManager) context.getSystemService("window");
    }

    private void zzeh() {
        this.zzyU = new DisplayMetrics();
        Display defaultDisplay = this.zzqF.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzyU);
        this.zzyV = this.zzyU.density;
        this.zzyY = defaultDisplay.getRotation();
    }

    private void zzem() {
        int[] iArr = new int[2];
        this.zzoA.getLocationOnScreen(iArr);
        zze(com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.mContext, iArr[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.mContext, iArr[1]));
    }

    private zzes zzep() {
        return new zzes.zza().zzp(this.zzyT.zzcQ()).zzo(this.zzyT.zzcR()).zzq(this.zzyT.zzcV()).zzr(this.zzyT.zzcS()).zzs(this.zzyT.zzcT()).zzeg();
    }

    public void zze(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzo.zzbv().zzj((Activity) this.mContext)[0] : 0), this.zzzb, this.zzzc);
        this.zzoA.zzgF().zzd(i, i2);
    }

    void zzei() {
        int iZzb;
        com.google.android.gms.ads.internal.util.client.zza zzaVarZzcA = com.google.android.gms.ads.internal.client.zzk.zzcA();
        DisplayMetrics displayMetrics = this.zzyU;
        this.zzyW = zzaVarZzcA.zzb(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.util.client.zza zzaVarZzcA2 = com.google.android.gms.ads.internal.client.zzk.zzcA();
        DisplayMetrics displayMetrics2 = this.zzyU;
        this.zzyX = zzaVarZzcA2.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZzgB = this.zzoA.zzgB();
        if (activityZzgB == null || activityZzgB.getWindow() == null) {
            this.zzyZ = this.zzyW;
            iZzb = this.zzyX;
        } else {
            int[] iArrZzg = com.google.android.gms.ads.internal.zzo.zzbv().zzg(activityZzgB);
            this.zzyZ = com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyU, iArrZzg[0]);
            iZzb = com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyU, iArrZzg[1]);
        }
        this.zzza = iZzb;
    }

    void zzej() {
        int iZzc;
        if (this.zzoA.zzaN().zzsn) {
            this.zzzb = this.zzyW;
            iZzc = this.zzyX;
        } else {
            this.zzoA.measure(0, 0);
            this.zzzb = com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.mContext, this.zzoA.getMeasuredWidth());
            iZzc = com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.mContext, this.zzoA.getMeasuredHeight());
        }
        this.zzzc = iZzc;
    }

    public void zzek() {
        zzeh();
        zzei();
        zzej();
        zzen();
        zzeo();
        zzem();
        zzel();
    }

    void zzel() {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Dispatching Ready Event.");
        }
        zzaf(this.zzoA.zzgI().zzGG);
    }

    void zzen() {
        zza(this.zzyW, this.zzyX, this.zzyZ, this.zzza, this.zzyV, this.zzyY);
    }

    void zzeo() {
        this.zzoA.zzb("onDeviceFeaturesReceived", zzep().toJson());
    }
}
