package b.f;

/* JADX INFO: loaded from: classes.dex */
public class e<E> implements Cloneable {
    public static final Object f = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f576b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f577c;
    public Object[] d;
    public int e;

    public e() {
        int iF = d.f(10);
        this.f577c = new long[iF];
        this.d = new Object[iF];
    }

    public void a(long j, E e) {
        int i = this.e;
        if (i != 0 && j <= this.f577c[i - 1]) {
            g(j, e);
            return;
        }
        if (this.f576b && this.e >= this.f577c.length) {
            d();
        }
        int i2 = this.e;
        if (i2 >= this.f577c.length) {
            int iF = d.f(i2 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f577c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f577c = jArr;
            this.d = objArr;
        }
        this.f577c[i2] = j;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public void b() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f576b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f577c = (long[]) this.f577c.clone();
            eVar.d = (Object[]) this.d.clone();
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void d() {
        int i = this.e;
        long[] jArr = this.f577c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f576b = false;
        this.e = i2;
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e) {
        int iB = d.b(this.f577c, this.e, j);
        if (iB >= 0) {
            Object[] objArr = this.d;
            if (objArr[iB] != f) {
                return (E) objArr[iB];
            }
        }
        return e;
    }

    public void g(long j, E e) {
        int iB = d.b(this.f577c, this.e, j);
        if (iB >= 0) {
            this.d[iB] = e;
            return;
        }
        int i = ~iB;
        if (i < this.e) {
            Object[] objArr = this.d;
            if (objArr[i] == f) {
                this.f577c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f576b && this.e >= this.f577c.length) {
            d();
            i = ~d.b(this.f577c, this.e, j);
        }
        int i2 = this.e;
        if (i2 >= this.f577c.length) {
            int iF = d.f(i2 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f577c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f577c = jArr;
            this.d = objArr2;
        }
        int i3 = this.e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f577c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i4, this.e - i);
        }
        this.f577c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    public int h() {
        if (this.f576b) {
            d();
        }
        return this.e;
    }

    public E i(int i) {
        if (this.f576b) {
            d();
        }
        return (E) this.d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f576b) {
                d();
            }
            sb.append(this.f577c[i]);
            sb.append('=');
            E eI = i(i);
            if (eI != this) {
                sb.append(eI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
