package b.g.b;

/* JADX WARN: Unexpected interfaces in signature: [b.g.b.e<T>] */
/* JADX INFO: loaded from: classes.dex */
public class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f609b;

    public e(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f608a = new Object[i];
    }

    public T a() {
        int i = this.f609b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f608a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f609b = i - 1;
        return t;
    }

    public boolean b(T t) {
        int i = this.f609b;
        Object[] objArr = this.f608a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f609b = i + 1;
        return true;
    }
}
