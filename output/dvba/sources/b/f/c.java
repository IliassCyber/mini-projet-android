package b.f;

import b.f.g;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c<E> implements Collection<E>, Set<E> {
    public static final int[] f = new int[0];
    public static final Object[] g = new Object[0];
    public static Object[] h;
    public static int i;
    public static Object[] j;
    public static int k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f571b = f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f572c = g;
    public int d = 0;
    public g<E, E> e;

    public static void b(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (c.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.f572c = objArr;
                    j = (Object[]) objArr[0];
                    this.f571b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (c.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.f572c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.f571b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.f571b = new int[i2];
        this.f572c = new Object[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int iC;
        if (e == null) {
            iC = d();
            i2 = 0;
        } else {
            int iHashCode = e.hashCode();
            i2 = iHashCode;
            iC = c(e, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i3 = ~iC;
        int i4 = this.d;
        if (i4 >= this.f571b.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f571b;
            Object[] objArr = this.f572c;
            a(i5);
            int[] iArr2 = this.f571b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f572c, 0, objArr.length);
            }
            b(iArr, objArr, this.d);
        }
        int i6 = this.d;
        if (i3 < i6) {
            int[] iArr3 = this.f571b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f572c;
            System.arraycopy(objArr2, i3, objArr2, i7, this.d - i3);
        }
        this.f571b[i3] = i2;
        this.f572c[i3] = e;
        this.d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.d;
        int[] iArr = this.f571b;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f572c;
            a(size);
            int i2 = this.d;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f571b, 0, i2);
                System.arraycopy(objArr, 0, this.f572c, 0, this.d);
            }
            b(iArr, objArr, this.d);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final int c(Object obj, int i2) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int iA = d.a(this.f571b, i3, i2);
        if (iA < 0 || obj.equals(this.f572c[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f571b[i4] == i2) {
            if (obj.equals(this.f572c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f571b[i5] == i2; i5--) {
            if (obj.equals(this.f572c[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.d;
        if (i2 != 0) {
            b(this.f571b, this.f572c, i2);
            this.f571b = f;
            this.f572c = g;
            this.d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int iA = d.a(this.f571b, i2, 0);
        if (iA < 0 || this.f572c[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f571b[i3] == 0) {
            if (this.f572c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f571b[i4] == 0; i4--) {
            if (this.f572c[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public E e(int i2) {
        Object[] objArr = this.f572c;
        E e = (E) objArr[i2];
        int i3 = this.d;
        if (i3 <= 1) {
            b(this.f571b, objArr, i3);
            this.f571b = f;
            this.f572c = g;
            this.d = 0;
        } else {
            int[] iArr = this.f571b;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = this.d - 1;
                this.d = i4;
                if (i2 < i4) {
                    int[] iArr2 = this.f571b;
                    int i5 = i2 + 1;
                    System.arraycopy(iArr2, i5, iArr2, i2, i4 - i2);
                    Object[] objArr2 = this.f572c;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.d - i2);
                }
                this.f572c[this.d] = null;
            } else {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr3 = this.f571b;
                Object[] objArr3 = this.f572c;
                a(i6);
                this.d--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f571b, 0, i2);
                    System.arraycopy(objArr3, 0, this.f572c, 0, i2);
                }
                int i7 = this.d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f571b, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.f572c, i2, this.d - i2);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.d != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    if (!set.contains(this.f572c[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f571b;
        int i2 = this.d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? d() : c(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        if (this.e == null) {
            this.e = new b(this);
        }
        g<E, E> gVar = this.e;
        if (gVar.f582b == null) {
            gVar.f582b = new g.c();
        }
        return gVar.f582b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        e(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f572c[i2])) {
                e(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f572c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.d));
        }
        System.arraycopy(this.f572c, 0, tArr, 0, this.d);
        int length = tArr.length;
        int i2 = this.d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f572c[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
