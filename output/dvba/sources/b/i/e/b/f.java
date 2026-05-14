package b.i.e.b;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f735b;

    public f(int i, int i2) {
        this.f734a = new int[]{i, i2};
        this.f735b = new float[]{0.0f, 1.0f};
    }

    public f(int i, int i2, int i3) {
        this.f734a = new int[]{i, i2, i3};
        this.f735b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public f(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.f734a = new int[size];
        this.f735b = new float[size];
        for (int i = 0; i < size; i++) {
            this.f734a[i] = list.get(i).intValue();
            this.f735b[i] = list2.get(i).floatValue();
        }
    }
}
