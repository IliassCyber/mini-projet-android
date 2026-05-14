package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzki extends ImageView {
    private Uri zzZF;
    private int zzZG;
    private int zzZH;
    private zza zzZI;
    private int zzZJ;
    private float zzZK;

    public interface zza {
        Path zzk(int i, int i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        zza zzaVar = this.zzZI;
        if (zzaVar != null) {
            canvas.clipPath(zzaVar.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        int i = this.zzZH;
        if (i != 0) {
            canvas.drawColor(i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int measuredWidth;
        super.onMeasure(i, i2);
        switch (this.zzZJ) {
            case 1:
                measuredHeight = getMeasuredHeight();
                measuredWidth = (int) (measuredHeight * this.zzZK);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                measuredHeight = (int) (measuredWidth / this.zzZK);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void zzbo(int i) {
        this.zzZG = i;
    }

    public void zzi(Uri uri) {
        this.zzZF = uri;
    }

    public int zznr() {
        return this.zzZG;
    }
}
