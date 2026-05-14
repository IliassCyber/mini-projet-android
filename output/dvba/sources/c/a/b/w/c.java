package c.a.b.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final Comparator<byte[]> e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f1232a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<byte[]> f1233b = new ArrayList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1234c = 0;
    public final int d;

    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i) {
        this.d = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f1233b.size(); i2++) {
            byte[] bArr = this.f1233b.get(i2);
            if (bArr.length >= i) {
                this.f1234c -= bArr.length;
                this.f1233b.remove(i2);
                this.f1232a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.f1232a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f1233b, bArr, e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f1233b.add(iBinarySearch, bArr);
                this.f1234c += bArr.length;
                synchronized (this) {
                    while (this.f1234c > this.d) {
                        byte[] bArrRemove = this.f1232a.remove(0);
                        this.f1233b.remove(bArrRemove);
                        this.f1234c -= bArrRemove.length;
                    }
                }
            }
        }
    }
}
