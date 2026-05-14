package b.f;

/* JADX INFO: loaded from: classes.dex */
public class i<E> implements Cloneable {
    public static final Object f = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f594c;
    public Object[] d;
    public int e;

    public i() {
        this(10);
    }

    public i(int i) {
        this.f593b = false;
        if (i == 0) {
            this.f594c = d.f573a;
            this.d = d.f575c;
        } else {
            int iE = d.e(i);
            this.f594c = new int[iE];
            this.d = new Object[iE];
        }
    }

    public void a(int i, E e) {
        int i2 = this.e;
        if (i2 != 0 && i <= this.f594c[i2 - 1]) {
            g(i, e);
            return;
        }
        if (this.f593b && this.e >= this.f594c.length) {
            c();
        }
        int i3 = this.e;
        if (i3 >= this.f594c.length) {
            int iE = d.e(i3 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f594c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f594c = iArr;
            this.d = objArr;
        }
        this.f594c[i3] = i;
        this.d[i3] = e;
        this.e = i3 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f594c = (int[]) this.f594c.clone();
            iVar.d = (Object[]) this.d.clone();
            return iVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void c() {
        int i = this.e;
        int[] iArr = this.f594c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f593b = false;
        this.e = i2;
    }

    public E d(int i) {
        return e(i, null);
    }

    public E e(int i, E e) {
        int iA = d.a(this.f594c, this.e, i);
        if (iA >= 0) {
            Object[] objArr = this.d;
            if (objArr[iA] != f) {
                return (E) objArr[iA];
            }
        }
        return e;
    }

    public int f(int i) {
        if (this.f593b) {
            c();
        }
        return this.f594c[i];
    }

    public void g(int i, E e) {
        int iA = d.a(this.f594c, this.e, i);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.e) {
            Object[] objArr = this.d;
            if (objArr[i2] == f) {
                this.f594c[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f593b && this.e >= this.f594c.length) {
            c();
            i2 = ~d.a(this.f594c, this.e, i);
        }
        int i3 = this.e;
        if (i3 >= this.f594c.length) {
            int iE = d.e(i3 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f594c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f594c = iArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f594c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.e - i2);
        }
        this.f594c[i2] = i;
        this.d[i2] = e;
        this.e++;
    }

    public void h(int i) {
        int iA = d.a(this.f594c, this.e, i);
        if (iA >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[iA];
            Object obj2 = f;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f593b = true;
            }
        }
    }

    public int i() {
        if (this.f593b) {
            c();
        }
        return this.e;
    }

    public E j(int i) {
        if (this.f593b) {
            c();
        }
        return (E) this.d[i];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(f(i));
            sb.append('=');
            E eJ = j(i);
            if (eJ != this) {
                sb.append(eJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
