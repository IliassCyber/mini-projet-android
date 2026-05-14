package b.i.m;

import android.graphics.Insets;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f853b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f854a;

    public static class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f855c = null;
        public static boolean d = false;
        public static Constructor<WindowInsets> e = null;
        public static boolean f = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WindowInsets f856b;

        /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            /*
                r7 = this;
                r7.<init>()
                boolean r0 = b.i.m.u.a.d
                r1 = 1
                java.lang.String r2 = "WindowInsetsCompat"
                if (r0 != 0) goto L1d
                java.lang.Class<android.view.WindowInsets> r0 = android.view.WindowInsets.class
                java.lang.String r3 = "CONSUMED"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch: java.lang.ReflectiveOperationException -> L15
                b.i.m.u.a.f855c = r0     // Catch: java.lang.ReflectiveOperationException -> L15
                goto L1b
            L15:
                r0 = move-exception
                java.lang.String r3 = "Could not retrieve WindowInsets.CONSUMED field"
                android.util.Log.i(r2, r3, r0)
            L1b:
                b.i.m.u.a.d = r1
            L1d:
                java.lang.reflect.Field r0 = b.i.m.u.a.f855c
                r3 = 0
                if (r0 == 0) goto L37
                java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.ReflectiveOperationException -> L31
                android.view.WindowInsets r0 = (android.view.WindowInsets) r0     // Catch: java.lang.ReflectiveOperationException -> L31
                if (r0 == 0) goto L37
                android.view.WindowInsets r4 = new android.view.WindowInsets     // Catch: java.lang.ReflectiveOperationException -> L31
                r4.<init>(r0)     // Catch: java.lang.ReflectiveOperationException -> L31
                r3 = r4
                goto L6e
            L31:
                r0 = move-exception
                java.lang.String r4 = "Could not get value from WindowInsets.CONSUMED field"
                android.util.Log.i(r2, r4, r0)
            L37:
                boolean r0 = b.i.m.u.a.f
                r4 = 0
                if (r0 != 0) goto L53
                java.lang.Class<android.view.WindowInsets> r0 = android.view.WindowInsets.class
                java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.ReflectiveOperationException -> L4b
                java.lang.Class<android.graphics.Rect> r6 = android.graphics.Rect.class
                r5[r4] = r6     // Catch: java.lang.ReflectiveOperationException -> L4b
                java.lang.reflect.Constructor r0 = r0.getConstructor(r5)     // Catch: java.lang.ReflectiveOperationException -> L4b
                b.i.m.u.a.e = r0     // Catch: java.lang.ReflectiveOperationException -> L4b
                goto L51
            L4b:
                r0 = move-exception
                java.lang.String r5 = "Could not retrieve WindowInsets(Rect) constructor"
                android.util.Log.i(r2, r5, r0)
            L51:
                b.i.m.u.a.f = r1
            L53:
                java.lang.reflect.Constructor<android.view.WindowInsets> r0 = b.i.m.u.a.e
                if (r0 == 0) goto L6e
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.ReflectiveOperationException -> L68
                android.graphics.Rect r5 = new android.graphics.Rect     // Catch: java.lang.ReflectiveOperationException -> L68
                r5.<init>()     // Catch: java.lang.ReflectiveOperationException -> L68
                r1[r4] = r5     // Catch: java.lang.ReflectiveOperationException -> L68
                java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.ReflectiveOperationException -> L68
                android.view.WindowInsets r0 = (android.view.WindowInsets) r0     // Catch: java.lang.ReflectiveOperationException -> L68
                r3 = r0
                goto L6e
            L68:
                r0 = move-exception
                java.lang.String r1 = "Could not invoke WindowInsets(Rect) constructor"
                android.util.Log.i(r2, r1, r0)
            L6e:
                r7.f856b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.i.m.u.a.<init>():void");
        }

        public a(u uVar) {
            this.f856b = uVar.g();
        }

        @Override // b.i.m.u.c
        public u a() {
            return u.h(this.f856b);
        }

        @Override // b.i.m.u.c
        public void c(b.i.f.b bVar) {
            WindowInsets windowInsets = this.f856b;
            if (windowInsets != null) {
                this.f856b = windowInsets.replaceSystemWindowInsets(bVar.f743a, bVar.f744b, bVar.f745c, bVar.d);
            }
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsets.Builder f857b;

        public b() {
            this.f857b = new WindowInsets.Builder();
        }

        public b(u uVar) {
            WindowInsets windowInsetsG = uVar.g();
            this.f857b = windowInsetsG != null ? new WindowInsets.Builder(windowInsetsG) : new WindowInsets.Builder();
        }

        @Override // b.i.m.u.c
        public u a() {
            return u.h(this.f857b.build());
        }

        @Override // b.i.m.u.c
        public void b(b.i.f.b bVar) {
            this.f857b.setStableInsets(Insets.of(bVar.f743a, bVar.f744b, bVar.f745c, bVar.d));
        }

        @Override // b.i.m.u.c
        public void c(b.i.f.b bVar) {
            this.f857b.setSystemWindowInsets(Insets.of(bVar.f743a, bVar.f744b, bVar.f745c, bVar.d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f858a = new u((u) null);

        public abstract u a();

        public void b(b.i.f.b bVar) {
        }

        public abstract void c(b.i.f.b bVar);
    }

    public static class d extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsets f859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b.i.f.b f860c;

        public d(u uVar, WindowInsets windowInsets) {
            super(uVar);
            this.f860c = null;
            this.f859b = windowInsets;
        }

        @Override // b.i.m.u.h
        public final b.i.f.b f() {
            if (this.f860c == null) {
                this.f860c = b.i.f.b.a(this.f859b.getSystemWindowInsetLeft(), this.f859b.getSystemWindowInsetTop(), this.f859b.getSystemWindowInsetRight(), this.f859b.getSystemWindowInsetBottom());
            }
            return this.f860c;
        }

        @Override // b.i.m.u.h
        public u g(int i, int i2, int i3, int i4) {
            u uVarH = u.h(this.f859b);
            c bVar = Build.VERSION.SDK_INT >= 29 ? new b(uVarH) : new a(uVarH);
            bVar.c(u.f(f(), i, i2, i3, i4));
            bVar.b(u.f(e(), i, i2, i3, i4));
            return bVar.a();
        }

        @Override // b.i.m.u.h
        public boolean i() {
            return this.f859b.isRound();
        }
    }

    public static class e extends d {
        public b.i.f.b d;

        public e(u uVar, WindowInsets windowInsets) {
            super(uVar, windowInsets);
            this.d = null;
        }

        @Override // b.i.m.u.h
        public u b() {
            return u.h(this.f859b.consumeStableInsets());
        }

        @Override // b.i.m.u.h
        public u c() {
            return u.h(this.f859b.consumeSystemWindowInsets());
        }

        @Override // b.i.m.u.h
        public final b.i.f.b e() {
            if (this.d == null) {
                this.d = b.i.f.b.a(this.f859b.getStableInsetLeft(), this.f859b.getStableInsetTop(), this.f859b.getStableInsetRight(), this.f859b.getStableInsetBottom());
            }
            return this.d;
        }

        @Override // b.i.m.u.h
        public boolean h() {
            return this.f859b.isConsumed();
        }
    }

    public static class f extends e {
        public f(u uVar, WindowInsets windowInsets) {
            super(uVar, windowInsets);
        }

        @Override // b.i.m.u.h
        public u a() {
            return u.h(this.f859b.consumeDisplayCutout());
        }

        @Override // b.i.m.u.h
        public b.i.m.c d() {
            DisplayCutout displayCutout = this.f859b.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new b.i.m.c(displayCutout);
        }

        @Override // b.i.m.u.h
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                return Objects.equals(this.f859b, ((f) obj).f859b);
            }
            return false;
        }

        @Override // b.i.m.u.h
        public int hashCode() {
            return this.f859b.hashCode();
        }
    }

    public static class g extends f {
        public g(u uVar, WindowInsets windowInsets) {
            super(uVar, windowInsets);
        }

        @Override // b.i.m.u.d, b.i.m.u.h
        public u g(int i, int i2, int i3, int i4) {
            return u.h(this.f859b.inset(i, i2, i3, i4));
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f861a;

        public h(u uVar) {
            this.f861a = uVar;
        }

        public u a() {
            return this.f861a;
        }

        public u b() {
            return this.f861a;
        }

        public u c() {
            return this.f861a;
        }

        public b.i.m.c d() {
            return null;
        }

        public b.i.f.b e() {
            return b.i.f.b.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return i() == hVar.i() && h() == hVar.h() && Objects.equals(f(), hVar.f()) && Objects.equals(e(), hVar.e()) && Objects.equals(d(), hVar.d());
        }

        public b.i.f.b f() {
            return b.i.f.b.e;
        }

        public u g(int i, int i2, int i3, int i4) {
            return u.f853b;
        }

        public boolean h() {
            return false;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(i()), Boolean.valueOf(h()), f(), e(), d());
        }

        public boolean i() {
            return false;
        }
    }

    static {
        f853b = (Build.VERSION.SDK_INT >= 29 ? new b() : new a()).a().f854a.a().f854a.b().f854a.c();
    }

    public u(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        this.f854a = i >= 29 ? new g(this, windowInsets) : i >= 28 ? new f(this, windowInsets) : new e(this, windowInsets);
    }

    public u(u uVar) {
        this.f854a = new h(this);
    }

    public static b.i.f.b f(b.i.f.b bVar, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, bVar.f743a - i);
        int iMax2 = Math.max(0, bVar.f744b - i2);
        int iMax3 = Math.max(0, bVar.f745c - i3);
        int iMax4 = Math.max(0, bVar.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? bVar : b.i.f.b.a(iMax, iMax2, iMax3, iMax4);
    }

    public static u h(WindowInsets windowInsets) {
        if (windowInsets != null) {
            return new u(windowInsets);
        }
        throw null;
    }

    public int a() {
        return e().d;
    }

    public int b() {
        return e().f743a;
    }

    public int c() {
        return e().f745c;
    }

    public int d() {
        return e().f744b;
    }

    public b.i.f.b e() {
        return this.f854a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return Objects.equals(this.f854a, ((u) obj).f854a);
        }
        return false;
    }

    public WindowInsets g() {
        h hVar = this.f854a;
        if (hVar instanceof d) {
            return ((d) hVar).f859b;
        }
        return null;
    }

    public int hashCode() {
        h hVar = this.f854a;
        if (hVar == null) {
            return 0;
        }
        return hVar.hashCode();
    }
}
