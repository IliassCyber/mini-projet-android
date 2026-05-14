package b.b.p;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f468a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f469b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f470c = RecyclerView.UNDEFINED_DURATION;
    public int d = RecyclerView.UNDEFINED_DURATION;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public void a(int i, int i2) {
        this.f470c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f468a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f469b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f468a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f469b = i2;
        }
    }
}
