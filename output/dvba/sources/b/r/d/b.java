package b.r.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0043b f1020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1021b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f1022c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f1023a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f1024b;

        public void a(int i) {
            if (i < 64) {
                this.f1023a &= ~(1 << i);
                return;
            }
            a aVar = this.f1024b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        public int b(int i) {
            long j;
            a aVar = this.f1024b;
            if (aVar == null) {
                if (i >= 64) {
                    j = this.f1023a;
                }
                return Long.bitCount(j);
            }
            if (i >= 64) {
                return Long.bitCount(this.f1023a) + aVar.b(i - 64);
            }
            j = this.f1023a & ((1 << i) - 1);
            return Long.bitCount(j);
        }

        public final void c() {
            if (this.f1024b == null) {
                this.f1024b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.f1023a & (1 << i)) != 0;
            }
            c();
            return this.f1024b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f1024b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.f1023a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1023a;
            this.f1023a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f1024b != null) {
                c();
                this.f1024b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f1024b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1023a & j) != 0;
            long j2 = this.f1023a & (~j);
            this.f1023a = j2;
            long j3 = j - 1;
            this.f1023a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            a aVar = this.f1024b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1024b.f(0);
            }
            return z;
        }

        public void g() {
            this.f1023a = 0L;
            a aVar = this.f1024b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i < 64) {
                this.f1023a |= 1 << i;
            } else {
                c();
                this.f1024b.h(i - 64);
            }
        }

        public String toString() {
            if (this.f1024b == null) {
                return Long.toBinaryString(this.f1023a);
            }
            return this.f1024b.toString() + "xx" + Long.toBinaryString(this.f1023a);
        }
    }

    /* JADX INFO: renamed from: b.r.d.b$b, reason: collision with other inner class name */
    public interface InterfaceC0043b {
    }

    public b(InterfaceC0043b interfaceC0043b) {
        this.f1020a = interfaceC0043b;
    }

    public void a(View view, int i, boolean z) {
        int iB = i < 0 ? ((RecyclerView.e) this.f1020a).b() : f(i);
        this.f1021b.e(iB, z);
        if (z) {
            i(view);
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1020a;
        RecyclerView.this.addView(view, iB);
        RecyclerView.this.dispatchChildAttached(view);
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iB = i < 0 ? ((RecyclerView.e) this.f1020a).b() : f(i);
        this.f1021b.e(iB, z);
        if (z) {
            i(view);
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1020a;
        if (eVar == null) {
            throw null;
        }
        RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.o() && !childViewHolderInt.u()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(c.a.a.a.a.a(RecyclerView.this, sb));
            }
            childViewHolderInt.j &= -257;
        }
        RecyclerView.this.attachViewToParent(view, iB, layoutParams);
    }

    public void c(int i) {
        RecyclerView.d0 childViewHolderInt;
        int iF = f(i);
        this.f1021b.f(iF);
        RecyclerView.e eVar = (RecyclerView.e) this.f1020a;
        View childAt = RecyclerView.this.getChildAt(iF);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.o() && !childViewHolderInt.u()) {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(c.a.a.a.a.a(RecyclerView.this, sb));
            }
            childViewHolderInt.b(256);
        }
        RecyclerView.this.detachViewFromParent(iF);
    }

    public View d(int i) {
        return ((RecyclerView.e) this.f1020a).a(f(i));
    }

    public int e() {
        return ((RecyclerView.e) this.f1020a).b() - this.f1022c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int iB = ((RecyclerView.e) this.f1020a).b();
        int i2 = i;
        while (i2 < iB) {
            int iB2 = i - (i2 - this.f1021b.b(i2));
            if (iB2 == 0) {
                while (this.f1021b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB2;
        }
        return -1;
    }

    public View g(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public int h() {
        return ((RecyclerView.e) this.f1020a).b();
    }

    public final void i(View view) {
        this.f1022c.add(view);
        RecyclerView.e eVar = (RecyclerView.e) this.f1020a;
        if (eVar == null) {
            throw null;
        }
        RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            RecyclerView recyclerView = RecyclerView.this;
            int iP = childViewHolderInt.q;
            if (iP == -1) {
                iP = b.i.m.l.p(childViewHolderInt.f184a);
            }
            childViewHolderInt.p = iP;
            recyclerView.setChildImportantForAccessibilityInternal(childViewHolderInt, 4);
        }
    }

    public int j(View view) {
        int iIndexOfChild = RecyclerView.this.indexOfChild(view);
        if (iIndexOfChild == -1 || this.f1021b.d(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.f1021b.b(iIndexOfChild);
    }

    public boolean k(View view) {
        return this.f1022c.contains(view);
    }

    public final boolean l(View view) {
        if (!this.f1022c.remove(view)) {
            return false;
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1020a;
        if (eVar == null) {
            throw null;
        }
        RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null) {
            return true;
        }
        RecyclerView.this.setChildImportantForAccessibilityInternal(childViewHolderInt, childViewHolderInt.p);
        childViewHolderInt.p = 0;
        return true;
    }

    public String toString() {
        return this.f1021b.toString() + ", hidden list:" + this.f1022c.size();
    }
}
