package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzfk;
import com.google.android.gms.internal.zzfo;

/* JADX INFO: loaded from: classes.dex */
public class zzz {
    private final Context mContext;
    private final zzg zznH;
    private String zzoL;
    private zza zzrU;
    private AdListener zzrV;
    private final zzee zzsR;
    private zzr zzsT;
    private String zzsU;
    private InAppPurchaseListener zzsW;
    private PlayStorePurchaseListener zzsX;
    private OnCustomRenderedAdLoadedListener zzsY;
    private PublisherInterstitialAd zzsZ;
    private AppEventListener zzsq;

    public zzz(Context context) {
        this(context, zzg.zzcw(), null);
    }

    public zzz(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzg.zzcw(), publisherInterstitialAd);
    }

    public zzz(Context context, zzg zzgVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzsR = new zzee();
        this.mContext = context;
        this.zznH = zzgVar;
        this.zzsZ = publisherInterstitialAd;
    }

    private void zzL(String str) throws RemoteException {
        if (this.zzoL == null) {
            zzM(str);
        }
        this.zzsT = zzk.zzcB().zzb(this.mContext, new AdSizeParcel(), this.zzoL, this.zzsR);
        AdListener adListener = this.zzrV;
        if (adListener != null) {
            this.zzsT.zza(new zzc(adListener));
        }
        zza zzaVar = this.zzrU;
        if (zzaVar != null) {
            this.zzsT.zza(new zzb(zzaVar));
        }
        AppEventListener appEventListener = this.zzsq;
        if (appEventListener != null) {
            this.zzsT.zza(new zzi(appEventListener));
        }
        InAppPurchaseListener inAppPurchaseListener = this.zzsW;
        if (inAppPurchaseListener != null) {
            this.zzsT.zza(new zzfk(inAppPurchaseListener));
        }
        PlayStorePurchaseListener playStorePurchaseListener = this.zzsX;
        if (playStorePurchaseListener != null) {
            this.zzsT.zza(new zzfo(playStorePurchaseListener), this.zzsU);
        }
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener = this.zzsY;
        if (onCustomRenderedAdLoadedListener != null) {
            this.zzsT.zza(new zzcj(onCustomRenderedAdLoadedListener));
        }
    }

    private void zzM(String str) {
        if (this.zzsT != null) {
            return;
        }
        throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
    }

    public AdListener getAdListener() {
        return this.zzrV;
    }

    public String getAdUnitId() {
        return this.zzoL;
    }

    public AppEventListener getAppEventListener() {
        return this.zzsq;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzsW;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzsT != null) {
                return this.zzsT.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzsY;
    }

    public boolean isLoaded() {
        try {
            if (this.zzsT == null) {
                return false;
            }
            return this.zzsT.isReady();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzrV = adListener;
            if (this.zzsT != null) {
                this.zzsT.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.zzoL != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzoL = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzsq = appEventListener;
            if (this.zzsT != null) {
                this.zzsT.zza(appEventListener != null ? new zzi(appEventListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzsX != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzsW = inAppPurchaseListener;
            if (this.zzsT != null) {
                this.zzsT.zza(inAppPurchaseListener != null ? new zzfk(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzsY = onCustomRenderedAdLoadedListener;
            if (this.zzsT != null) {
                this.zzsT.zza(onCustomRenderedAdLoadedListener != null ? new zzcj(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzsW != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzsX = playStorePurchaseListener;
            this.zzsU = str;
            if (this.zzsT != null) {
                this.zzsT.zza(playStorePurchaseListener != null ? new zzfo(playStorePurchaseListener) : null, str);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            zzM("show");
            this.zzsT.showInterstitial();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza zzaVar) {
        try {
            this.zzrU = zzaVar;
            if (this.zzsT != null) {
                this.zzsT.zza(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzx zzxVar) {
        try {
            if (this.zzsT == null) {
                zzL("loadAd");
            }
            if (this.zzsT.zza(this.zznH.zza(this.mContext, zzxVar))) {
                this.zzsR.zzf(zzxVar.zzcJ());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", e);
        }
    }
}
