package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhf;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzkw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzp implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    boolean zzoU;
    final String zzpF;
    public String zzpG;
    public final Context zzpH;
    final zzan zzpI;
    public final VersionInfoParcel zzpJ;
    zza zzpK;
    public zzhh zzpL;
    public zzhh zzpM;
    public AdSizeParcel zzpN;
    public zzha zzpO;
    public zzha.zza zzpP;
    public zzhb zzpQ;
    com.google.android.gms.ads.internal.client.zzm zzpR;
    com.google.android.gms.ads.internal.client.zzn zzpS;
    zzt zzpT;
    zzu zzpU;
    zzff zzpV;
    zzfj zzpW;
    zzcu zzpX;
    zzcv zzpY;
    zzkw<String, zzcw> zzpZ;
    zzkw<String, zzcx> zzqa;
    NativeAdOptionsParcel zzqb;
    zzci zzqc;
    List<String> zzqd;
    com.google.android.gms.ads.internal.purchase.zzk zzqe;
    public zzhf zzqf;
    View zzqg;
    public int zzqh;
    boolean zzqi;
    private HashSet<zzhb> zzqj;
    private int zzqk;
    private int zzql;
    private zzhq zzqm;

    public static final class zza extends ViewSwitcher {
        private final zzhn zzqn;

        public zza(Context context) {
            super(context);
            this.zzqn = new zzhn(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzqn.zzd(motionEvent);
            return false;
        }

        @Override // android.widget.ViewAnimator, android.view.ViewGroup
        public void removeAllViews() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                KeyEvent.Callback childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof zzid)) {
                    arrayList.add((zzid) childAt);
                }
            }
            super.removeAllViews();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zzid) it.next()).destroy();
            }
        }

        public zzhn zzbP() {
            return this.zzqn;
        }
    }

    public zzp(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    zzp(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzan zzanVar) {
        this.zzqf = null;
        this.zzqg = null;
        this.zzqh = 0;
        this.zzqi = false;
        this.zzoU = false;
        this.zzqj = null;
        this.zzqk = -1;
        this.zzql = -1;
        zzbz.zzw(context);
        this.zzpF = UUID.randomUUID().toString();
        if (adSizeParcel.zzsn || adSizeParcel.zzsp) {
            this.zzpK = null;
        } else {
            this.zzpK = new zza(context);
            this.zzpK.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzpK.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzpK.setVisibility(4);
        }
        if (context != null && (context instanceof Activity) && this.zzpK != null) {
            Activity activity = (Activity) context;
            zzo.zzbv().zza(activity, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzo.zzbv().zza(activity, (ViewTreeObserver.OnScrollChangedListener) this);
        }
        this.zzpN = adSizeParcel;
        this.zzpG = str;
        this.zzpH = context;
        this.zzpJ = versionInfoParcel;
        this.zzpI = zzanVar == null ? new zzan(new zzg(this)) : zzanVar;
        this.zzqm = new zzhq(200L);
        this.zzqa = new zzkw<>();
    }

    private void zze(boolean z) {
        zzha zzhaVar;
        if (this.zzpK == null || (zzhaVar = this.zzpO) == null || zzhaVar.zzzE == null || !this.zzpO.zzzE.zzgF().zzbU()) {
            return;
        }
        if (!z || this.zzqm.tryAcquire()) {
            int[] iArr = new int[2];
            this.zzpK.getLocationOnScreen(iArr);
            int iZzc = com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.zzpH, iArr[0]);
            int iZzc2 = com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(this.zzpH, iArr[1]);
            if (iZzc == this.zzqk && iZzc2 == this.zzql) {
                return;
            }
            this.zzqk = iZzc;
            this.zzql = iZzc2;
            this.zzpO.zzzE.zzgF().zza(this.zzqk, this.zzql, !z);
        }
    }

    public void destroy() {
        this.zzpS = null;
        this.zzpT = null;
        this.zzpW = null;
        this.zzpV = null;
        this.zzqc = null;
        this.zzpU = null;
        Context context = this.zzpH;
        if (context != null && (context instanceof Activity) && this.zzpK != null) {
            zzo.zzbx().zzb((Activity) this.zzpH, this);
            zzo.zzbv().zzb((Activity) this.zzpH, this);
        }
        zzf(false);
        zza zzaVar = this.zzpK;
        if (zzaVar != null) {
            zzaVar.removeAllViews();
        }
        zzbJ();
        zzbL();
        this.zzpO = null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zze(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zze(true);
    }

    public void zza(HashSet<zzhb> hashSet) {
        this.zzqj = hashSet;
    }

    public HashSet<zzhb> zzbI() {
        return this.zzqj;
    }

    public void zzbJ() {
        zzha zzhaVar = this.zzpO;
        if (zzhaVar == null || zzhaVar.zzzE == null) {
            return;
        }
        this.zzpO.zzzE.destroy();
    }

    public void zzbK() {
        zzha zzhaVar = this.zzpO;
        if (zzhaVar == null || zzhaVar.zzzE == null) {
            return;
        }
        this.zzpO.zzzE.stopLoading();
    }

    public void zzbL() {
        zzha zzhaVar = this.zzpO;
        if (zzhaVar == null || zzhaVar.zzya == null) {
            return;
        }
        try {
            this.zzpO.zzya.destroy();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not destroy mediation adapter.");
        }
    }

    public boolean zzbM() {
        return this.zzqh == 0;
    }

    public boolean zzbN() {
        return this.zzqh == 1;
    }

    public void zzbO() {
        this.zzpQ.zzl(this.zzpO.zzFo);
        this.zzpQ.zzm(this.zzpO.zzFp);
        this.zzpQ.zzy(this.zzpN.zzsn);
        this.zzpQ.zzz(this.zzpO.zzCK);
    }

    public void zzf(boolean z) {
        if (this.zzqh == 0) {
            zzbK();
        }
        zzhh zzhhVar = this.zzpL;
        if (zzhhVar != null) {
            zzhhVar.cancel();
        }
        zzhh zzhhVar2 = this.zzpM;
        if (zzhhVar2 != null) {
            zzhhVar2.cancel();
        }
        if (z) {
            this.zzpO = null;
        }
    }
}
