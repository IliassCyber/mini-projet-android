package c.c.a.a.c;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference<byte[]> f1424c = new WeakReference<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<byte[]> f1425b;

    public v(byte[] bArr) {
        super(bArr);
        this.f1425b = f1424c;
    }

    public abstract byte[] C();

    @Override // c.c.a.a.c.t
    public final byte[] t() {
        byte[] bArrC;
        synchronized (this) {
            bArrC = this.f1425b.get();
            if (bArrC == null) {
                bArrC = C();
                this.f1425b = new WeakReference<>(bArrC);
            }
        }
        return bArrC;
    }
}
