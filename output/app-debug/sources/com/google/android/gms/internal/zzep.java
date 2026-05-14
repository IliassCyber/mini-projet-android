package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzep extends zzeu {
    static final Set<String> zzyu = new HashSet(Arrays.asList("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"));
    private int zznM;
    private int zznN;
    private final zzid zzoA;
    private final Object zzqt;
    private AdSizeParcel zzxT;
    private int zzyA;
    private final Activity zzyB;
    private ImageView zzyC;
    private LinearLayout zzyD;
    private zzev zzyE;
    private PopupWindow zzyF;
    private RelativeLayout zzyG;
    private ViewGroup zzyH;
    private String zzyv;
    private boolean zzyw;
    private int zzyx;
    private int zzyy;
    private int zzyz;

    public zzep(zzid zzidVar, zzev zzevVar) {
        super(zzidVar, "resize");
        this.zzyv = "top-right";
        this.zzyw = true;
        this.zzyx = 0;
        this.zzyy = 0;
        this.zznN = -1;
        this.zzyz = 0;
        this.zzyA = 0;
        this.zznM = -1;
        this.zzqt = new Object();
        this.zzoA = zzidVar;
        this.zzyB = zzidVar.zzgB();
        this.zzyE = zzevVar;
    }

    private int[] zzed() {
        int i;
        if (!zzef()) {
            return null;
        }
        if (this.zzyw) {
            return new int[]{this.zzyx + this.zzyz, this.zzyy + this.zzyA};
        }
        int[] iArrZzh = com.google.android.gms.ads.internal.zzo.zzbv().zzh(this.zzyB);
        int[] iArrZzj = com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzyB);
        int i2 = iArrZzh[0];
        int i3 = this.zzyx + this.zzyz;
        int i4 = this.zzyy + this.zzyA;
        if (i3 < 0) {
            i = 0;
        } else {
            int i5 = this.zznM;
            i = i3 + i5 > i2 ? i2 - i5 : i3;
        }
        if (i4 < iArrZzj[0]) {
            i4 = iArrZzj[0];
        } else {
            int i6 = this.zznN;
            if (i4 + i6 > iArrZzj[1]) {
                i4 = iArrZzj[1] - i6;
            }
        }
        return new int[]{i, i4};
    }

    private void zzg(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zznM = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zznN = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzyz = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzyA = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzyw = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzyv = str;
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzqt) {
            this.zzyx = i;
            this.zzyy = i2;
            if (this.zzyF != null && z) {
                int[] iArrZzed = zzed();
                if (iArrZzed != null) {
                    this.zzyF.update(com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[1]), this.zzyF.getWidth(), this.zzyF.getHeight());
                    zzc(iArrZzed[0], iArrZzed[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    void zzb(int i, int i2) {
        zzev zzevVar = this.zzyE;
        if (zzevVar != null) {
            zzevVar.zza(i, i2, this.zznM, this.zznN);
        }
    }

    void zzc(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzyB)[0], this.zznM, this.zznN);
    }

    public void zzd(int i, int i2) {
        this.zzyx = i;
        this.zzyy = i2;
    }

    boolean zzec() {
        return this.zznM > -1 && this.zznN > -1;
    }

    public boolean zzee() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzyF != null;
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean zzef() {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzep.zzef():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0189  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zzh(java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            Method dump skipped, instruction units count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzep.zzh(java.util.Map):void");
    }

    public void zzn(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzyF != null) {
                this.zzyF.dismiss();
                this.zzyG.removeView(this.zzoA.getWebView());
                if (this.zzyH != null) {
                    this.zzyH.removeView(this.zzyC);
                    this.zzyH.addView(this.zzoA.getWebView());
                    this.zzoA.zza(this.zzxT);
                }
                if (z) {
                    zzag("default");
                    if (this.zzyE != null) {
                        this.zzyE.zzbc();
                    }
                }
                this.zzyF = null;
                this.zzyG = null;
                this.zzyH = null;
                this.zzyD = null;
            }
        }
    }
}
