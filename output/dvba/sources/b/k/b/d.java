package b.k.b;

import android.graphics.Rect;
import b.k.b.a;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements Comparator<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f892b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f893c = new Rect();
    public final boolean d;
    public final b<T> e;

    public d(boolean z, b<T> bVar) {
        this.d = z;
        this.e = bVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.f892b;
        Rect rect2 = this.f893c;
        ((a.C0038a) this.e).a(t, rect);
        ((a.C0038a) this.e).a(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.d ? 1 : -1;
        }
        if (i3 > i4) {
            return this.d ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return this.d ? 1 : -1;
        }
        if (i7 > i8) {
            return this.d ? -1 : 1;
        }
        return 0;
    }
}
