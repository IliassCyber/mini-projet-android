package com.google.android.gms.common.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzYK;
    private ArrayList<Integer> zzYL;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.zzYK = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void zznj() {
        synchronized (this) {
            if (!this.zzYK) {
                int count = this.zzWu.getCount();
                this.zzYL = new ArrayList<>();
                if (count > 0) {
                    this.zzYL.add(0);
                    String strZzni = zzni();
                    String strZzd = this.zzWu.zzd(strZzni, 0, this.zzWu.zzbh(0));
                    for (int i = 1; i < count; i++) {
                        int iZzbh = this.zzWu.zzbh(i);
                        String strZzd2 = this.zzWu.zzd(strZzni, i, iZzbh);
                        if (strZzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + strZzni + ", at row: " + i + ", for window: " + iZzbh);
                        }
                        if (!strZzd2.equals(strZzd)) {
                            this.zzYL.add(Integer.valueOf(i));
                            strZzd = strZzd2;
                        }
                    }
                }
                this.zzYK = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final T get(int i) {
        zznj();
        return zzj(zzbk(i), zzbl(i));
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zznj();
        return this.zzYL.size();
    }

    int zzbk(int i) {
        if (i >= 0 && i < this.zzYL.size()) {
            return this.zzYL.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int zzbl(int i) {
        if (i < 0 || i == this.zzYL.size()) {
            return 0;
        }
        int count = (i == this.zzYL.size() - 1 ? this.zzWu.getCount() : this.zzYL.get(i + 1).intValue()) - this.zzYL.get(i).intValue();
        if (count == 1) {
            int iZzbk = zzbk(i);
            int iZzbh = this.zzWu.zzbh(iZzbk);
            String strZznk = zznk();
            if (strZznk != null && this.zzWu.zzd(strZznk, iZzbk, iZzbh) == null) {
                return 0;
            }
        }
        return count;
    }

    protected abstract T zzj(int i, int i2);

    protected abstract String zzni();

    protected String zznk() {
        return null;
    }
}
