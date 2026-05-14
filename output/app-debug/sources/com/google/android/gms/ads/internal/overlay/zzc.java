package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzid;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzc extends zzex.zza implements zzl {
    static final int zzzj = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    zzid zzoA;
    RelativeLayout zzyG;
    AdOverlayInfoParcel zzzk;
    zzh zzzl;
    C0013zzc zzzm;
    zzj zzzn;
    FrameLayout zzzp;
    WebChromeClient.CustomViewCallback zzzq;
    private boolean zzzv;
    boolean zzzo = false;
    boolean zzzr = false;
    boolean zzzs = false;
    boolean zzzt = false;
    int zzzu = 0;
    private boolean zzzw = false;
    private boolean zzzx = true;

    @zzgd
    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzgd
    static final class zzb extends RelativeLayout {
        zzhn zzqn;

        public zzb(Context context, String str) {
            super(context);
            this.zzqn = new zzhn(context, str);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzqn.zzd(motionEvent);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.overlay.zzc$zzc, reason: collision with other inner class name */
    @zzgd
    public static class C0013zzc {
        public final int index;
        public final Context zzpH;
        public final ViewGroup zzzA;
        public final ViewGroup.LayoutParams zzzz;

        public C0013zzc(zzid zzidVar) throws zza {
            this.zzzz = zzidVar.getLayoutParams();
            ViewParent parent = zzidVar.getParent();
            this.zzpH = zzidVar.zzgC();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.zzzA = (ViewGroup) parent;
            this.index = this.zzzA.indexOfChild(zzidVar.getWebView());
            this.zzzA.removeView(zzidVar.getWebView());
            zzidVar.zzB(true);
        }
    }

    public zzc(Activity activity) {
        this.mActivity = activity;
    }

    public void close() {
        this.zzzu = 2;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzex
    public void onBackPressed() {
        this.zzzu = 0;
    }

    @Override // com.google.android.gms.internal.zzex
    public void onCreate(Bundle bundle) {
        this.zzzr = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzzk = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzzk == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.zzzk.zzpJ.zzGI > 7500000) {
                this.zzzu = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzzx = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzzk.zzzN != null) {
                this.zzzs = this.zzzk.zzzN.zzoU;
            } else {
                this.zzzs = false;
            }
            if (bundle == null) {
                if (this.zzzk.zzzD != null && this.zzzx) {
                    this.zzzk.zzzD.zzaW();
                }
                if (this.zzzk.zzzK != 1 && this.zzzk.zzzC != null) {
                    this.zzzk.zzzC.onAdClicked();
                }
            }
            this.zzyG = new zzb(this.mActivity, this.zzzk.zzzM);
            switch (this.zzzk.zzzK) {
                case 1:
                    break;
                case 2:
                    this.zzzm = new C0013zzc(this.zzzk.zzzE);
                    break;
                case 3:
                    zzu(true);
                    return;
                case 4:
                    if (!this.zzzr && zzo.zzbs().zza(this.mActivity, this.zzzk.zzzB, this.zzzk.zzzJ)) {
                        return;
                    }
                    this.zzzu = 3;
                    Activity activity = this.mActivity;
                    activity.finish();
                    return;
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
            zzu(false);
        } catch (zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(e.getMessage());
            this.zzzu = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzex
    public void onDestroy() {
        zzh zzhVar = this.zzzl;
        if (zzhVar != null) {
            zzhVar.destroy();
        }
        zzid zzidVar = this.zzoA;
        if (zzidVar != null) {
            this.zzyG.removeView(zzidVar.getWebView());
        }
        zzeu();
    }

    @Override // com.google.android.gms.internal.zzex
    public void onPause() {
        zzh zzhVar = this.zzzl;
        if (zzhVar != null) {
            zzhVar.pause();
        }
        zzer();
        if (this.zzoA != null && (!this.mActivity.isFinishing() || this.zzzm == null)) {
            zzo.zzbx().zza(this.zzoA.getWebView());
        }
        zzeu();
    }

    @Override // com.google.android.gms.internal.zzex
    public void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzex
    public void onResume() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzzk;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzzK == 4) {
            if (this.zzzr) {
                this.zzzu = 3;
                this.mActivity.finish();
            } else {
                this.zzzr = true;
            }
        }
        zzid zzidVar = this.zzoA;
        if (zzidVar == null || zzidVar.isDestroyed()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("The webview does not exit. Ignoring action.");
        } else {
            zzo.zzbx().zzb(this.zzoA.getWebView());
        }
    }

    @Override // com.google.android.gms.internal.zzex
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzzr);
    }

    @Override // com.google.android.gms.internal.zzex
    public void onStart() {
    }

    @Override // com.google.android.gms.internal.zzex
    public void onStop() {
        zzeu();
    }

    public void setRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzzp = new FrameLayout(this.mActivity);
        this.zzzp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzzp.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzzp);
        zzaE();
        this.zzzq = customViewCallback;
        this.zzzo = true;
    }

    public void zza(boolean z, boolean z2) {
        zzj zzjVar = this.zzzn;
        if (zzjVar != null) {
            zzjVar.zza(z, z2);
        }
    }

    @Override // com.google.android.gms.internal.zzex
    public void zzaE() {
        this.zzzv = true;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        zzh zzhVar = this.zzzl;
        if (zzhVar != null) {
            zzhVar.zzf(i, i2, i3, i4);
        }
    }

    public void zze(int i, int i2, int i3, int i4) {
        if (this.zzzl == null) {
            this.zzzl = new zzh(this.mActivity, this.zzoA);
            this.zzyG.addView(this.zzzl, 0, new ViewGroup.LayoutParams(-1, -1));
            this.zzzl.zzf(i, i2, i3, i4);
            this.zzoA.zzgF().zzD(false);
        }
    }

    public zzh zzeq() {
        return this.zzzl;
    }

    public void zzer() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzzk;
        if (adOverlayInfoParcel != null && this.zzzo) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzzp != null) {
            this.mActivity.setContentView(this.zzyG);
            zzaE();
            this.zzzp.removeAllViews();
            this.zzzp = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzzq;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzzq = null;
        }
        this.zzzo = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzl
    public void zzes() {
        this.zzzu = 1;
        this.mActivity.finish();
    }

    public void zzet() {
        this.zzyG.removeView(this.zzzn);
        zzt(true);
    }

    protected void zzeu() {
        if (!this.mActivity.isFinishing() || this.zzzw) {
            return;
        }
        this.zzzw = true;
        if (this.mActivity.isFinishing()) {
            if (this.zzoA != null) {
                zzv(this.zzzu);
                this.zzyG.removeView(this.zzoA.getWebView());
                C0013zzc c0013zzc = this.zzzm;
                if (c0013zzc != null) {
                    this.zzoA.setContext(c0013zzc.zzpH);
                    this.zzoA.zzB(false);
                    this.zzzm.zzzA.addView(this.zzoA.getWebView(), this.zzzm.index, this.zzzm.zzzz);
                    this.zzzm = null;
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzzk;
            if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzzD == null) {
                return;
            }
            this.zzzk.zzzD.zzaV();
        }
    }

    public void zzev() {
        if (this.zzzt) {
            this.zzzt = false;
            zzew();
        }
    }

    protected void zzew() {
        this.zzoA.zzew();
    }

    public void zzt(boolean z) {
        this.zzzn = new zzj(this.mActivity, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zzzn.zza(z, this.zzzk.zzzH);
        this.zzyG.addView(this.zzzn, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void zzu(boolean r14) throws com.google.android.gms.ads.internal.overlay.zzc.zza {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zzu(boolean):void");
    }

    protected void zzv(int i) {
        this.zzoA.zzv(i);
    }
}
