package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;

/* JADX INFO: loaded from: classes.dex */
public final class zzkg extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzKT;
    private int zzZA;
    private boolean zzZh;
    private int zzZo;
    private int zzZp;
    private int zzZq;
    private int zzZr;
    private int zzZs;
    private boolean zzZt;
    private zzb zzZu;
    private Drawable zzZv;
    private Drawable zzZw;
    private boolean zzZx;
    private boolean zzZy;
    private boolean zzZz;

    private static final class zza extends Drawable {
        private static final zza zzZB = new zza();
        private static final C0118zza zzZC = new C0118zza();

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzkg$zza$zza, reason: collision with other inner class name */
        private static final class C0118zza extends Drawable.ConstantState {
            private C0118zza() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return zza.zzZB;
            }
        }

        private zza() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return zzZC;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {
        int zzZD;
        int zzZE;

        zzb(zzb zzbVar) {
            if (zzbVar != null) {
                this.zzZD = zzbVar.zzZD;
                this.zzZE = zzbVar.zzZE;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.zzZD;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzkg(this);
        }
    }

    public zzkg(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.zzZB : drawable;
        this.zzZv = drawable;
        drawable.setCallback(this);
        zzb zzbVar = this.zzZu;
        zzbVar.zzZE = drawable.getChangingConfigurations() | zzbVar.zzZE;
        drawable2 = drawable2 == null ? zza.zzZB : drawable2;
        this.zzZw = drawable2;
        drawable2.setCallback(this);
        zzb zzbVar2 = this.zzZu;
        zzbVar2.zzZE = drawable2.getChangingConfigurations() | zzbVar2.zzZE;
    }

    zzkg(zzb zzbVar) {
        this.zzZo = 0;
        this.zzZq = MotionEventCompat.ACTION_MASK;
        this.zzZs = 0;
        this.zzZh = true;
        this.zzZu = new zzb(zzbVar);
    }

    public boolean canConstantState() {
        if (!this.zzZx) {
            this.zzZy = (this.zzZv.getConstantState() == null || this.zzZw.getConstantState() == null) ? false : true;
            this.zzZx = true;
        }
        return this.zzZy;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        switch (this.zzZo) {
            case 1:
                this.zzKT = SystemClock.uptimeMillis();
                this.zzZo = 2;
                z = false;
                break;
            case 2:
                if (this.zzKT >= 0) {
                    float fUptimeMillis = (SystemClock.uptimeMillis() - this.zzKT) / this.zzZr;
                    z = fUptimeMillis >= 1.0f;
                    if (z) {
                        this.zzZo = 0;
                    }
                    float fMin = Math.min(fUptimeMillis, 1.0f);
                    this.zzZs = (int) (this.mFrom + ((this.zzZp - r2) * fMin));
                }
                break;
        }
        int i = this.zzZs;
        boolean z = this.zzZh;
        Drawable drawable = this.zzZv;
        Drawable drawable2 = this.zzZw;
        if (z) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            int i2 = this.zzZq;
            if (i == i2) {
                drawable2.setAlpha(i2);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzZq - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzZq);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzZq);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzZu.zzZD | this.zzZu.zzZE;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzZu.zzZD = getChangingConfigurations();
        return this.zzZu;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.zzZv.getIntrinsicHeight(), this.zzZw.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.zzZv.getIntrinsicWidth(), this.zzZw.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.zzZz) {
            this.zzZA = Drawable.resolveOpacity(this.zzZv.getOpacity(), this.zzZw.getOpacity());
            this.zzZz = true;
        }
        return this.zzZA;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!zzlk.zzoR() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.zzZt && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzZv.mutate();
            this.zzZw.mutate();
            this.zzZt = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.zzZv.setBounds(rect);
        this.zzZw.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!zzlk.zzoR() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.zzZs == this.zzZq) {
            this.zzZs = i;
        }
        this.zzZq = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.zzZv.setColorFilter(colorFilter);
        this.zzZw.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.zzZp = this.zzZq;
        this.zzZs = 0;
        this.zzZr = i;
        this.zzZo = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!zzlk.zzoR() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public Drawable zznp() {
        return this.zzZw;
    }
}
