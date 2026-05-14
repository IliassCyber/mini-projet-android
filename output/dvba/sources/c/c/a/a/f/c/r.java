package c.c.a.a.f.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1474a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1475b = 0;

    public final r<K, V> a(K k, V v) {
        int i = (this.f1475b + 1) << 1;
        Object[] objArr = this.f1474a;
        if (i > objArr.length) {
            int length = objArr.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = length + (length >> 1) + 1;
            if (iHighestOneBit < i) {
                iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                iHighestOneBit = Integer.MAX_VALUE;
            }
            this.f1474a = Arrays.copyOf(objArr, iHighestOneBit);
        }
        c.c.a.a.c.l.q.x0(k, v);
        Object[] objArr2 = this.f1474a;
        int i2 = this.f1475b;
        int i3 = i2 * 2;
        objArr2[i3] = k;
        objArr2[i3 + 1] = v;
        this.f1475b = i2 + 1;
        return this;
    }
}
