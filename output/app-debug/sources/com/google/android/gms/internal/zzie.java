package com.google.android.gms.internal;

import android.net.Uri;
import android.support.v4.media.TransportMediator;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzie extends WebViewClient {
    private zza zzBi;
    private final HashMap<String, List<zzdg>> zzHb;
    private com.google.android.gms.ads.internal.overlay.zzf zzHc;
    private boolean zzHd;
    private com.google.android.gms.ads.internal.overlay.zzk zzHe;
    private final zzet zzHf;
    private boolean zzHg;
    private boolean zzHh;
    private boolean zzHi;
    private boolean zzHj;
    private int zzHk;
    protected final zzid zzoA;
    private boolean zzqs;
    private final Object zzqt;
    private com.google.android.gms.ads.internal.client.zza zzrU;
    private zzde zzvU;
    private zzdk zzwu;
    private com.google.android.gms.ads.internal.zzd zzww;
    private zzep zzwx;
    private zzdi zzwz;
    private zzev zzyE;

    public interface zza {
        void zza(zzid zzidVar, boolean z);
    }

    private static class zzb implements com.google.android.gms.ads.internal.overlay.zzf {
        private com.google.android.gms.ads.internal.overlay.zzf zzHc;
        private zzid zzHn;

        public zzb(zzid zzidVar, com.google.android.gms.ads.internal.overlay.zzf zzfVar) {
            this.zzHn = zzidVar;
            this.zzHc = zzfVar;
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzf
        public void zzaV() {
            this.zzHc.zzaV();
            this.zzHn.zzgA();
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzf
        public void zzaW() {
            this.zzHc.zzaW();
            this.zzHn.zzew();
        }
    }

    private class zzc implements zzdg {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzie.this.zzgO();
            } else if (map.keySet().contains("stop")) {
                zzie.this.zzgP();
            } else if (map.keySet().contains("cancel")) {
                zzie.this.zzgQ();
            }
        }
    }

    public zzie(zzid zzidVar, boolean z) {
        this(zzidVar, z, new zzet(zzidVar, zzidVar.zzgC(), new zzbq(zzidVar.getContext())), null);
    }

    zzie(zzid zzidVar, boolean z, zzet zzetVar, zzep zzepVar) {
        this.zzHb = new HashMap<>();
        this.zzqt = new Object();
        this.zzHd = false;
        this.zzoA = zzidVar;
        this.zzqs = z;
        this.zzHf = zzetVar;
        this.zzwx = zzepVar;
    }

    private static boolean zzf(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzgO() {
        this.zzHk++;
        zzgR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzgP() {
        this.zzHk--;
        zzgR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzgQ() {
        this.zzHj = true;
        zzgR();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading resource: " + str);
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzg(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzqt) {
            if (this.zzHh && "about:blank".equals(str)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Blank page loaded, 1...");
                this.zzoA.zzgK();
            } else {
                this.zzHi = true;
                zzgR();
            }
        }
    }

    public final void reset() {
        synchronized (this.zzqt) {
            this.zzHb.clear();
            this.zzrU = null;
            this.zzHc = null;
            this.zzBi = null;
            this.zzvU = null;
            this.zzHd = false;
            this.zzqs = false;
            this.zzwz = null;
            this.zzHe = null;
            if (this.zzwx != null) {
                this.zzwx.zzn(true);
                this.zzwx = null;
            }
            this.zzHg = false;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case Place.TYPE_SPA /* 85 */:
            case Place.TYPE_STADIUM /* 86 */:
            case Place.TYPE_STORAGE /* 87 */:
            case Place.TYPE_STORE /* 88 */:
            case Place.TYPE_SUBWAY_STATION /* 89 */:
            case 90:
            case Place.TYPE_TAXI_STAND /* 91 */:
                return true;
            default:
                switch (keyCode) {
                    case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
                    case TransportMediator.KEYCODE_MEDIA_PAUSE /* 127 */:
                    case 128:
                    case 129:
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdWebView shouldOverrideUrlLoading: " + str);
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzg(uriZza);
        } else {
            if (this.zzHd && webView == this.zzoA && zzf(uriZza)) {
                if (!this.zzHg) {
                    this.zzHg = true;
                    if (this.zzrU != null && zzbz.zzul.get().booleanValue()) {
                        this.zzrU.onAdClicked();
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (this.zzoA.willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdWebView unable to handle URL: " + str);
            } else {
                try {
                    zzan zzanVarZzgH = this.zzoA.zzgH();
                    if (zzanVarZzgH != null && zzanVarZzgH.zzb(uriZza)) {
                        uriZza = zzanVarZzgH.zza(uriZza, this.zzoA.getContext());
                    }
                } catch (zzao e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Unable to append parameter to URL: " + str);
                }
                com.google.android.gms.ads.internal.zzd zzdVar = this.zzww;
                if (zzdVar == null || zzdVar.zzbd()) {
                    zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null));
                } else {
                    this.zzww.zzo(str);
                }
            }
        }
        return true;
    }

    public void zzD(boolean z) {
        this.zzHd = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzHf.zze(i, i2);
        zzep zzepVar = this.zzwx;
        if (zzepVar != null) {
            zzepVar.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean zZzgJ = this.zzoA.zzgJ();
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, (!zZzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null, zZzgJ ? null : this.zzHc, this.zzHe, this.zzoA.zzgI()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzep zzepVar = this.zzwx;
        com.google.android.gms.ads.internal.zzo.zzbt().zza(this.zzoA.getContext(), adOverlayInfoParcel, zzepVar != null ? zzepVar.zzee() : false ? false : true);
    }

    public void zza(zza zzaVar) {
        this.zzBi = zzaVar;
    }

    public final void zza(String str, zzdg zzdgVar) {
        synchronized (this.zzqt) {
            List<zzdg> copyOnWriteArrayList = this.zzHb.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.zzHb.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzdgVar);
        }
    }

    public final void zza(boolean z, int i) {
        com.google.android.gms.ads.internal.client.zza zzaVar = (!this.zzoA.zzgJ() || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        com.google.android.gms.ads.internal.overlay.zzf zzfVar = this.zzHc;
        com.google.android.gms.ads.internal.overlay.zzk zzkVar = this.zzHe;
        zzid zzidVar = this.zzoA;
        zza(new AdOverlayInfoParcel(zzaVar, zzfVar, zzkVar, zzidVar, z, i, zzidVar.zzgI()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zZzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza zzaVar = (!zZzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        zzb zzbVar = zZzgJ ? null : new zzb(this.zzoA, this.zzHc);
        zzde zzdeVar = this.zzvU;
        com.google.android.gms.ads.internal.overlay.zzk zzkVar = this.zzHe;
        zzid zzidVar = this.zzoA;
        zza(new AdOverlayInfoParcel(zzaVar, zzbVar, zzdeVar, zzkVar, zzidVar, z, i, str, zzidVar.zzgI(), this.zzwz));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zZzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza zzaVar = (!zZzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        zzb zzbVar = zZzgJ ? null : new zzb(this.zzoA, this.zzHc);
        zzde zzdeVar = this.zzvU;
        com.google.android.gms.ads.internal.overlay.zzk zzkVar = this.zzHe;
        zzid zzidVar = this.zzoA;
        zza(new AdOverlayInfoParcel(zzaVar, zzbVar, zzdeVar, zzkVar, zzidVar, z, i, str, str2, zzidVar.zzgI(), this.zzwz));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzf zzfVar, zzde zzdeVar, com.google.android.gms.ads.internal.overlay.zzk zzkVar, boolean z, zzdi zzdiVar, zzdk zzdkVar, com.google.android.gms.ads.internal.zzd zzdVar, zzev zzevVar) {
        if (zzdVar == null) {
            zzdVar = new com.google.android.gms.ads.internal.zzd(false);
        }
        this.zzwx = new zzep(this.zzoA, zzevVar);
        zza("/appEvent", new zzdd(zzdeVar));
        zza("/canOpenURLs", zzdf.zzvW);
        zza("/canOpenIntents", zzdf.zzvX);
        zza("/click", zzdf.zzvY);
        zza("/close", zzdf.zzvZ);
        zza("/customClose", zzdf.zzwa);
        zza("/delayPageLoaded", new zzc());
        zza("/httpTrack", zzdf.zzwb);
        zza("/log", zzdf.zzwc);
        zza("/mraid", new zzdm(zzdVar, this.zzwx));
        zza("/open", new zzdn(zzdiVar, zzdVar, this.zzwx));
        zza("/precache", zzdf.zzwf);
        zza("/touch", zzdf.zzwd);
        zza("/video", zzdf.zzwe);
        if (zzdkVar != null) {
            zza("/setInterstitialProperties", new zzdj(zzdkVar));
        }
        this.zzrU = zzaVar;
        this.zzHc = zzfVar;
        this.zzvU = zzdeVar;
        this.zzwz = zzdiVar;
        this.zzHe = zzkVar;
        this.zzww = zzdVar;
        this.zzyE = zzevVar;
        this.zzwu = zzdkVar;
        zzD(z);
        this.zzHg = false;
    }

    public final void zzb(String str, zzdg zzdgVar) {
        synchronized (this.zzqt) {
            List<zzdg> list = this.zzHb.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzdgVar);
        }
    }

    public boolean zzbU() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzqs;
        }
        return z;
    }

    public void zzd(int i, int i2) {
        zzep zzepVar = this.zzwx;
        if (zzepVar != null) {
            zzepVar.zzd(i, i2);
        }
    }

    public final void zzet() {
        synchronized (this.zzqt) {
            this.zzHd = false;
            this.zzqs = true;
            this.zzoA.zzgL();
            final com.google.android.gms.ads.internal.overlay.zzc zzcVarZzgD = this.zzoA.zzgD();
            if (zzcVarZzgD != null) {
                if (com.google.android.gms.ads.internal.client.zzk.zzcA().zzgw()) {
                    zzcVarZzgD.zzet();
                } else {
                    zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzie.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zzcVarZzgD.zzet();
                        }
                    });
                }
            }
        }
    }

    public void zzg(Uri uri) {
        String path = uri.getPath();
        List<zzdg> list = this.zzHb.get(path);
        if (list == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("No GMSG handler found for GMSG: " + uri);
            return;
        }
        Map<String, String> mapZzd = com.google.android.gms.ads.internal.zzo.zzbv().zzd(uri);
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Received GMSG: " + path);
            for (String str : mapZzd.keySet()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("  " + str + ": " + mapZzd.get(str));
            }
        }
        Iterator<zzdg> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzoA, mapZzd);
        }
    }

    public com.google.android.gms.ads.internal.zzd zzgM() {
        return this.zzww;
    }

    public void zzgN() {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading blank page in WebView, 2...");
            this.zzHh = true;
            this.zzoA.zzaD("about:blank");
        }
    }

    public final void zzgR() {
        if (this.zzBi != null) {
            if ((!this.zzHi || this.zzHk > 0) && !this.zzHj) {
                return;
            }
            this.zzBi.zza(this.zzoA, !this.zzHj);
            this.zzBi = null;
        }
    }

    public void zzgS() {
        if (zzbU()) {
            this.zzHf.zzek();
        }
    }
}
