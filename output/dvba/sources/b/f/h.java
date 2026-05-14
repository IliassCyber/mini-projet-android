package b.f;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h<K, V> {
    public static Object[] e;
    public static int f;
    public static Object[] g;
    public static int h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f592c;
    public int d;

    public h() {
        this.f591b = d.f573a;
        this.f592c = d.f575c;
        this.d = 0;
    }

    public h(int i) {
        if (i == 0) {
            this.f591b = d.f573a;
            this.f592c = d.f575c;
        } else {
            a(i);
        }
        this.d = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (h.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (h.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (h.class) {
                if (g != null) {
                    Object[] objArr = g;
                    this.f592c = objArr;
                    g = (Object[]) objArr[0];
                    this.f591b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (h.class) {
                if (e != null) {
                    Object[] objArr2 = e;
                    this.f592c = objArr2;
                    e = (Object[]) objArr2[0];
                    this.f591b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.f591b = new int[i];
        this.f592c = new Object[i << 1];
    }

    public void b(int i) {
        int i2 = this.d;
        int[] iArr = this.f591b;
        if (iArr.length < i) {
            Object[] objArr = this.f592c;
            a(i);
            if (this.d > 0) {
                System.arraycopy(iArr, 0, this.f591b, 0, i2);
                System.arraycopy(objArr, 0, this.f592c, 0, i2 << 1);
            }
            c(iArr, objArr, i2);
        }
        if (this.d != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f591b;
            Object[] objArr = this.f592c;
            this.f591b = d.f573a;
            this.f592c = d.f575c;
            this.d = 0;
            c(iArr, objArr, i);
        }
        if (this.d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public int d(Object obj, int i) {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = d.a(this.f591b, i2, i);
            if (iA < 0 || obj.equals(this.f592c[iA << 1])) {
                return iA;
            }
            int i3 = iA + 1;
            while (i3 < i2 && this.f591b[i3] == i) {
                if (obj.equals(this.f592c[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iA - 1; i4 >= 0 && this.f591b[i4] == i; i4--) {
                if (obj.equals(this.f592c[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.d != hVar.d) {
                return false;
            }
            for (int i = 0; i < this.d; i++) {
                try {
                    K kH = h(i);
                    V vK = k(i);
                    Object obj2 = hVar.get(kH);
                    if (vK == null) {
                        if (obj2 != null || !hVar.containsKey(kH)) {
                            return false;
                        }
                    } else if (!vK.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.d != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    K kH2 = h(i2);
                    V vK2 = k(i2);
                    Object obj3 = map.get(kH2);
                    if (vK2 == null) {
                        if (obj3 != null || !map.containsKey(kH2)) {
                            return false;
                        }
                    } else if (!vK2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        try {
            int iA = d.a(this.f591b, i, 0);
            if (iA < 0 || this.f592c[iA << 1] == null) {
                return iA;
            }
            int i2 = iA + 1;
            while (i2 < i && this.f591b[i2] == 0) {
                if (this.f592c[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = iA - 1; i3 >= 0 && this.f591b[i3] == 0; i3--) {
                if (this.f592c[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int g(Object obj) {
        int i = this.d * 2;
        Object[] objArr = this.f592c;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int iE = e(obj);
        return iE >= 0 ? (V) this.f592c[(iE << 1) + 1] : v;
    }

    public K h(int i) {
        return (K) this.f592c[i << 1];
    }

    public int hashCode() {
        int[] iArr = this.f591b;
        Object[] objArr = this.f592c;
        int i = this.d;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public V i(int i) {
        Object[] objArr = this.f592c;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.d;
        int i4 = 0;
        if (i3 <= 1) {
            c(this.f591b, objArr, i3);
            this.f591b = d.f573a;
            this.f592c = d.f575c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f591b;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int[] iArr2 = this.f591b;
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr2, i6, iArr2, i, i7);
                    Object[] objArr2 = this.f592c;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f592c;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                int i9 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr3 = this.f591b;
                Object[] objArr4 = this.f592c;
                a(i9);
                if (i3 != this.d) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f591b, 0, i);
                    System.arraycopy(objArr4, 0, this.f592c, 0, i2);
                }
                if (i < i5) {
                    int i10 = i + 1;
                    int i11 = i5 - i;
                    System.arraycopy(iArr3, i10, this.f591b, i, i11);
                    System.arraycopy(objArr4, i10 << 1, this.f592c, i2, i11 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.d) {
            throw new ConcurrentModificationException();
        }
        this.d = i4;
        return v;
    }

    public boolean isEmpty() {
        return this.d <= 0;
    }

    public V j(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f592c;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V k(int i) {
        return (V) this.f592c[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int iD;
        int i2 = this.d;
        if (k == null) {
            iD = f();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iD = d(k, iHashCode);
        }
        if (iD >= 0) {
            int i3 = (iD << 1) + 1;
            Object[] objArr = this.f592c;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iD;
        if (i2 >= this.f591b.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f591b;
            Object[] objArr2 = this.f592c;
            a(i5);
            if (i2 != this.d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f591b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f592c, 0, objArr2.length);
            }
            c(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f591b;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f592c;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.d - i4) << 1);
        }
        int i7 = this.d;
        if (i2 == i7) {
            int[] iArr4 = this.f591b;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f592c;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.d = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V orDefault = getOrDefault(k, null);
        return orDefault == null ? put(k, v) : orDefault;
    }

    public V remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        V vK = k(iE);
        if (obj2 != vK && (obj2 == null || !obj2.equals(vK))) {
            return false;
        }
        i(iE);
        return true;
    }

    public V replace(K k, V v) {
        int iE = e(k);
        if (iE >= 0) {
            return j(iE, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int iE = e(k);
        if (iE < 0) {
            return false;
        }
        V vK = k(iE);
        if (vK != v && (v == null || !v.equals(vK))) {
            return false;
        }
        j(iE, v2);
        return true;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kH = h(i);
            if (kH != this) {
                sb.append(kH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vK = k(i);
            if (vK != this) {
                sb.append(vK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
