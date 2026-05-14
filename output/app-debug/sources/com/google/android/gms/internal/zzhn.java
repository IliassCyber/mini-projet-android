package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzhn {
    private final Context mContext;
    private int mState;
    private String zzGo;
    private float zzGp;
    private float zzGq;
    private float zzGr;
    private final float zzyV;

    public zzhn(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzyV = context.getResources().getDisplayMetrics().density;
    }

    public zzhn(Context context, String str) {
        this(context);
        this.zzGo = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showDialog() {
        /*
            r5 = this;
            android.content.Context r0 = r5.mContext
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 != 0) goto Lc
            java.lang.String r0 = "Can not create dialog without Activity Context"
            com.google.android.gms.ads.internal.util.client.zzb.zzaA(r0)
            return
        Lc:
            java.lang.String r0 = r5.zzGo
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6a
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r5.zzGo
            android.net.Uri$Builder r0 = r0.encodedQuery(r1)
            android.net.Uri r0 = r0.build()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.google.android.gms.internal.zzhl r2 = com.google.android.gms.ads.internal.zzo.zzbv()
            java.util.Map r0 = r2.zzd(r0)
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L38:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L5b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r4 = " = "
            r1.append(r4)
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r1.append(r3)
            java.lang.String r3 = "\n\n"
            r1.append(r3)
            goto L38
        L5b:
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.trim()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L6a
            goto L6c
        L6a:
            java.lang.String r0 = "No debug information"
        L6c:
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            android.content.Context r2 = r5.mContext
            r1.<init>(r2)
            r1.setMessage(r0)
            java.lang.String r2 = "Ad Information"
            r1.setTitle(r2)
            java.lang.String r2 = "Share"
            com.google.android.gms.internal.zzhn$1 r3 = new com.google.android.gms.internal.zzhn$1
            r3.<init>()
            r1.setPositiveButton(r2, r3)
            java.lang.String r0 = "Close"
            com.google.android.gms.internal.zzhn$2 r2 = new com.google.android.gms.internal.zzhn$2
            r2.<init>()
            r1.setNegativeButton(r0, r2)
            android.app.AlertDialog r0 = r1.create()
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhn.showDialog():void");
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzGp = f;
            this.zzGq = f2;
            this.zzGr = f2;
            return;
        }
        int i2 = this.mState;
        if (i2 == -1) {
            return;
        }
        if (i != 2) {
            if (i == 1 && i2 == 4) {
                showDialog();
                return;
            }
            return;
        }
        if (f2 > this.zzGq) {
            this.zzGq = f2;
        } else if (f2 < this.zzGr) {
            this.zzGr = f2;
        }
        if (this.zzGq - this.zzGr > this.zzyV * 30.0f) {
            this.mState = -1;
            return;
        }
        int i3 = this.mState;
        if (i3 == 0 || i3 == 2 ? f - this.zzGp >= this.zzyV * 50.0f : !((i3 != 1 && i3 != 3) || f - this.zzGp > this.zzyV * (-50.0f))) {
            this.zzGp = f;
            this.mState++;
        }
        int i4 = this.mState;
        if (i4 == 1 || i4 == 3) {
            if (f <= this.zzGp) {
                return;
            }
        } else if (i4 != 2 || f >= this.zzGp) {
            return;
        }
        this.zzGp = f;
    }

    public void zzaw(String str) {
        this.zzGo = str;
    }

    public void zzd(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
