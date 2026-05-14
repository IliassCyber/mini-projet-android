package b.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import b.b.p.j;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public static n0 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, b.f.i<ColorStateList>> f463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.f.h<String, d> f464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.f.i<String> f465c;
    public final WeakHashMap<Context, b.f.e<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);
    public TypedValue e;
    public boolean f;
    public e g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final c j = new c(6);

    public static class a implements d {
        @Override // b.b.p.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.b.m.a.a.h(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    public static class b implements d {
        @Override // b.b.p.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                b.u.a.a.b bVar = new b.u.a.a.b(context, null, null);
                bVar.inflate(resources, xmlPullParser, attributeSet, theme);
                return bVar;
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    public static class c extends b.f.f<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }
    }

    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface e {
    }

    public static class f implements d {
        @Override // b.b.p.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.u.a.a.f.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static synchronized n0 d() {
        if (i == null) {
            n0 n0Var = new n0();
            i = n0Var;
            if (Build.VERSION.SDK_INT < 24) {
                n0Var.a("vector", new f());
                n0Var.a("animated-vector", new b());
                n0Var.a("animated-selector", new a());
            }
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        c cVar = j;
        if (cVar == null) {
            throw null;
        }
        int i3 = (i2 + 31) * 31;
        porterDuffColorFilterA = cVar.a(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i2, mode);
            c cVar2 = j;
            if (cVar2 == null) {
                throw null;
            }
            cVar2.b(Integer.valueOf(mode.hashCode() + i3), porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    public static void l(Drawable drawable, v0 v0Var, int[] iArr) {
        if (e0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (v0Var.d || v0Var.f491c) {
            PorterDuffColorFilter porterDuffColorFilterH = null;
            ColorStateList colorStateList = v0Var.d ? v0Var.f489a : null;
            PorterDuff.Mode mode = v0Var.f491c ? v0Var.f490b : h;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilterH = h(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilterH);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(String str, d dVar) {
        if (this.f464b == null) {
            this.f464b = new b.f.h<>();
        }
        this.f464b.put(str, dVar);
    }

    public final synchronized boolean b(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            b.f.e<WeakReference<Drawable.ConstantState>> eVar = this.d.get(context);
            if (eVar == null) {
                eVar = new b.f.e<>();
                this.d.put(context, eVar);
            }
            eVar.g(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Drawable c(Context context, int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j2);
        if (drawableE != null) {
            return drawableE;
        }
        e eVar = this.g;
        LayerDrawable layerDrawable = null;
        if (eVar != null) {
            if (i2 == b.b.e.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, b.b.e.abc_cab_background_internal_bg), f(context, b.b.e.abc_cab_background_top_mtrl_alpha)});
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j2) {
        b.f.e<WeakReference<Drawable.ConstantState>> eVar = this.d.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceF = eVar.f(j2, null);
        if (weakReferenceF != null) {
            Drawable.ConstantState constantState = weakReferenceF.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iB = b.f.d.b(eVar.f577c, eVar.e, j2);
            if (iB >= 0) {
                Object[] objArr = eVar.d;
                Object obj = objArr[iB];
                Object obj2 = b.f.e.f;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    eVar.f576b = true;
                }
            }
        }
        return null;
    }

    public synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.graphics.drawable.Drawable g(android.content.Context r5, int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L6
            goto L2a
        L6:
            r0 = 1
            r4.f = r0     // Catch: java.lang.Throwable -> L47
            int r1 = b.b.n.a.abc_vector_test     // Catch: java.lang.Throwable -> L47
            android.graphics.drawable.Drawable r1 = r4.f(r5, r1)     // Catch: java.lang.Throwable -> L47
            r2 = 0
            if (r1 == 0) goto L49
            boolean r3 = r1 instanceof b.u.a.a.f     // Catch: java.lang.Throwable -> L47
            if (r3 != 0) goto L28
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L47
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L27
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L49
        L2a:
            android.graphics.drawable.Drawable r0 = r4.j(r5, r6)     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L34
            android.graphics.drawable.Drawable r0 = r4.c(r5, r6)     // Catch: java.lang.Throwable -> L47
        L34:
            if (r0 != 0) goto L3a
            android.graphics.drawable.Drawable r0 = b.i.e.a.c(r5, r6)     // Catch: java.lang.Throwable -> L47
        L3a:
            if (r0 == 0) goto L40
            android.graphics.drawable.Drawable r0 = r4.k(r5, r6, r7, r0)     // Catch: java.lang.Throwable -> L47
        L40:
            if (r0 == 0) goto L45
            b.b.p.e0.b(r0)     // Catch: java.lang.Throwable -> L47
        L45:
            monitor-exit(r4)
            return r0
        L47:
            r5 = move-exception
            goto L53
        L49:
            r4.f = r2     // Catch: java.lang.Throwable -> L47
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L47
            throw r5     // Catch: java.lang.Throwable -> L47
        L53:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.p.n0.g(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public synchronized ColorStateList i(Context context, int i2) {
        ColorStateList colorStateListE;
        b.f.i<ColorStateList> iVar;
        WeakHashMap<Context, b.f.i<ColorStateList>> weakHashMap = this.f463a;
        ColorStateList colorStateListC = null;
        colorStateListE = (weakHashMap == null || (iVar = weakHashMap.get(context)) == null) ? null : iVar.e(i2, null);
        if (colorStateListE == null) {
            if (this.g != null) {
                colorStateListC = ((j.a) this.g).c(context, i2);
            }
            if (colorStateListC != null) {
                if (this.f463a == null) {
                    this.f463a = new WeakHashMap<>();
                }
                b.f.i<ColorStateList> iVar2 = this.f463a.get(context);
                if (iVar2 == null) {
                    iVar2 = new b.f.i<>(10);
                    this.f463a.put(context, iVar2);
                }
                iVar2.a(i2, colorStateListC);
            }
            colorStateListE = colorStateListC;
        }
        return colorStateListE;
    }

    public final Drawable j(Context context, int i2) {
        int next;
        b.f.h<String, d> hVar = this.f464b;
        if (hVar == null || hVar.isEmpty()) {
            return null;
        }
        b.f.i<String> iVar = this.f465c;
        if (iVar != null) {
            String strE = iVar.e(i2, null);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.f464b.getOrDefault(strE, null) == null)) {
                return null;
            }
        } else {
            this.f465c = new b.f.i<>(10);
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableE = e(context, j2);
        if (drawableE != null) {
            return drawableE;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f465c.a(i2, name);
                d dVar = this.f464b.get(name);
                if (dVar != null) {
                    drawableE = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableE != null) {
                    drawableE.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j2, drawableE);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableE == null) {
            this.f465c.a(i2, "appcompat_skip_skip");
        }
        return drawableE;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable k(android.content.Context r10, int r11, boolean r12, android.graphics.drawable.Drawable r13) {
        /*
            r9 = this;
            android.content.res.ColorStateList r0 = r9.i(r10, r11)
            r1 = 0
            if (r0 == 0) goto L2c
            boolean r10 = b.b.p.e0.a(r13)
            if (r10 == 0) goto L11
            android.graphics.drawable.Drawable r13 = r13.mutate()
        L11:
            android.graphics.drawable.Drawable r13 = a.a.a.a.a.C0(r13)
            r13.setTintList(r0)
            b.b.p.n0$e r10 = r9.g
            if (r10 != 0) goto L1d
            goto L25
        L1d:
            b.b.p.j$a r10 = (b.b.p.j.a) r10
            int r10 = b.b.e.abc_switch_thumb_material
            if (r11 != r10) goto L25
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.MULTIPLY
        L25:
            if (r1 == 0) goto La7
            r13.setTintMode(r1)
            goto La7
        L2c:
            b.b.p.n0$e r0 = r9.g
            if (r0 == 0) goto L9e
            b.b.p.j$a r0 = (b.b.p.j.a) r0
            if (r0 == 0) goto L9d
            int r2 = b.b.e.abc_seekbar_track_material
            r3 = 1
            r4 = 16908301(0x102000d, float:2.3877265E-38)
            r5 = 16908303(0x102000f, float:2.387727E-38)
            r6 = 16908288(0x1020000, float:2.387723E-38)
            if (r11 != r2) goto L72
            r2 = r13
            android.graphics.drawable.LayerDrawable r2 = (android.graphics.drawable.LayerDrawable) r2
            android.graphics.drawable.Drawable r6 = r2.findDrawableByLayerId(r6)
            int r7 = b.b.a.colorControlNormal
            int r7 = b.b.p.s0.c(r10, r7)
            android.graphics.PorterDuff$Mode r8 = b.b.p.j.f440b
            r0.d(r6, r7, r8)
            android.graphics.drawable.Drawable r5 = r2.findDrawableByLayerId(r5)
            int r6 = b.b.a.colorControlNormal
        L59:
            int r6 = b.b.p.s0.c(r10, r6)
            android.graphics.PorterDuff$Mode r7 = b.b.p.j.f440b
            r0.d(r5, r6, r7)
            android.graphics.drawable.Drawable r2 = r2.findDrawableByLayerId(r4)
            int r4 = b.b.a.colorControlActivated
            int r4 = b.b.p.s0.c(r10, r4)
            android.graphics.PorterDuff$Mode r5 = b.b.p.j.f440b
            r0.d(r2, r4, r5)
            goto L9a
        L72:
            int r2 = b.b.e.abc_ratingbar_material
            if (r11 == r2) goto L81
            int r2 = b.b.e.abc_ratingbar_indicator_material
            if (r11 == r2) goto L81
            int r2 = b.b.e.abc_ratingbar_small_material
            if (r11 != r2) goto L7f
            goto L81
        L7f:
            r3 = 0
            goto L9a
        L81:
            r2 = r13
            android.graphics.drawable.LayerDrawable r2 = (android.graphics.drawable.LayerDrawable) r2
            android.graphics.drawable.Drawable r6 = r2.findDrawableByLayerId(r6)
            int r7 = b.b.a.colorControlNormal
            int r7 = b.b.p.s0.b(r10, r7)
            android.graphics.PorterDuff$Mode r8 = b.b.p.j.f440b
            r0.d(r6, r7, r8)
            android.graphics.drawable.Drawable r5 = r2.findDrawableByLayerId(r5)
            int r6 = b.b.a.colorControlActivated
            goto L59
        L9a:
            if (r3 == 0) goto L9e
            goto La7
        L9d:
            throw r1
        L9e:
            boolean r10 = r9.m(r10, r11, r13)
            if (r10 != 0) goto La7
            if (r12 == 0) goto La7
            r13 = r1
        La7:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.p.n0.k(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            b.b.p.n0$e r0 = r7.g
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6f
            b.b.p.j$a r0 = (b.b.p.j.a) r0
            if (r0 == 0) goto L6d
            android.graphics.PorterDuff$Mode r3 = b.b.p.j.f440b
            int[] r4 = r0.f443a
            boolean r4 = r0.a(r4, r9)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            r6 = -1
            if (r4 == 0) goto L1b
            int r5 = b.b.a.colorControlNormal
            goto L44
        L1b:
            int[] r4 = r0.f445c
            boolean r4 = r0.a(r4, r9)
            if (r4 == 0) goto L26
            int r5 = b.b.a.colorControlActivated
            goto L44
        L26:
            int[] r4 = r0.d
            boolean r0 = r0.a(r4, r9)
            if (r0 == 0) goto L31
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L44
        L31:
            int r0 = b.b.e.abc_list_divider_mtrl_alpha
            if (r9 != r0) goto L40
            r9 = 16842800(0x1010030, float:2.3693693E-38)
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            goto L46
        L40:
            int r0 = b.b.e.abc_dialog_material_background
            if (r9 != r0) goto L48
        L44:
            r9 = r5
            r0 = -1
        L46:
            r4 = 1
            goto L4b
        L48:
            r9 = 0
            r0 = -1
            r4 = 0
        L4b:
            if (r4 == 0) goto L69
            boolean r4 = b.b.p.e0.a(r10)
            if (r4 == 0) goto L57
            android.graphics.drawable.Drawable r10 = r10.mutate()
        L57:
            int r8 = b.b.p.s0.c(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = b.b.p.j.c(r8, r3)
            r10.setColorFilter(r8)
            if (r0 == r6) goto L67
            r10.setAlpha(r0)
        L67:
            r8 = 1
            goto L6a
        L69:
            r8 = 0
        L6a:
            if (r8 == 0) goto L6f
            goto L70
        L6d:
            r8 = 0
            throw r8
        L6f:
            r1 = 0
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.p.n0.m(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
