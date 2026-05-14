package b.i.l;

/* JADX WARN: Unexpected interfaces in signature: [b.i.l.c<T>] */
/* JADX INFO: loaded from: classes.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f817b;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f816a = new Object[i];
    }

    public T a() {
        int i = this.f817b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f816a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f817b = i - 1;
        return t;
    }

    public boolean b(T t) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.f817b) {
                z = false;
                break;
            }
            if (this.f816a[i] == t) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i2 = this.f817b;
        Object[] objArr = this.f816a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f817b = i2 + 1;
        return true;
    }
}
